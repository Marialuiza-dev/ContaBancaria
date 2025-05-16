package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
    int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent())
            conta.get().visualizar();
        else
            System.out.printf("\nA Conta número %d não foi encontrada\n", numero);
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("A Conta foi criada com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {
        Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

        if (buscaConta.isPresent()) {
            listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
            System.out.printf("\nA Conta número %d foi atualizada com sucesso!\n", conta.getNumero());
        } else {
            System.out.printf("\nA Conta número %d não foi encontrada\n", conta.getNumero());
        }
    }

    @Override
    public void deletar(int numero) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            if (listaContas.remove(conta.get()))
                System.out.printf("\nA Conta número %d foi excluída com sucesso!\n", numero);
        } else {
            System.out.printf("\nA Conta número %d não foi encontrada\n", numero);
        }
    }

    @Override
    public void sacar(int numero, float valor) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            if (conta.get().sacar(valor))
                System.out.printf("\nSaque na Conta número %d efetuado com sucesso!\n", numero);
            else
                System.out.printf("\nSaldo insuficiente na Conta número %d!\n", numero);
        } else {
            System.out.printf("\nA Conta número %d não foi encontrada\n", numero);
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            conta.get().depositar(valor);
            System.out.printf("\nDepósito na Conta número %d efetuado com sucesso!\n", numero);
        } else {
            System.out.printf("\nA Conta número %d não foi encontrada\n", numero);
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
        Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            if (contaOrigem.get().sacar(valor)) {
                contaDestino.get().depositar(valor);
                System.out.printf("\nTransferência de R$ %.2f da Conta %d para a Conta %d realizada com sucesso!\n",
                        valor, numeroOrigem, numeroDestino);
            } else {
                System.out.printf("\nSaldo insuficiente na Conta número %d!\n", numeroOrigem);
            }
        } else {
            if (!contaOrigem.isPresent())
                System.out.printf("\nA Conta de origem número %d não foi encontrada\n", numeroOrigem);
            if (!contaDestino.isPresent())
                System.out.printf("\nA Conta de destino número %d não foi encontrada\n", numeroDestino);
        }
    }

    // Métodos auxiliares

    public int gerarNumero() {
        return ++numero;
    }

    public Optional<Conta> buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero)
                return Optional.of(conta);
        }
        return Optional.empty();
    }
}
