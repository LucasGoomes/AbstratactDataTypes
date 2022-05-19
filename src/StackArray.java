import java.util.EmptyStackException;

public class StackArray{
    private Integer pilha[];
    private int topo;

    public StackArray(){
        pilha = new Integer[10];

    }

    public void clear(){//esvazia a lista
        pilha = new Integer[10];
    }
    public int size(){//retorna o tamanho
        return topo;
    }
    public boolean isEmpty(){//retorna se a lista está vazia
        return (topo == 0);
    }

    public void push(Integer element){//insere na primeira posição

        if(topo == pilha.length){//se a pilha já estiver cheia
            throw new RuntimeException("Pilha cheia"); 
        }else{
            pilha[topo] = element;
            topo++;
        }
    }

    public Integer pop(){//remove e retorna o primeiro elemento da pilha

        if(topo == 0){//se a pilha estiver
            throw new EmptyStackException();
        }
        Integer removido = pilha[topo-1];
        pilha[topo-1] = null;
        topo--;
        return removido;
    }

    public Integer top(){//retorna o elemento do topo da fila

        if(topo == 0){//se a pilha estiver
            throw new EmptyStackException();
        }
        return pilha[topo-1];
    }
}