public class Queue {
    private int[] values;   //array que armazena os elementos
    private int front;      //o primeiro elemento da fila
    private int rear;       //o ultimo elemento da fila
    private int count;      //total de elementos na fila no momento

    public Queue(){
        this.values = new int[10];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }
    
    public void enqueue(int element){//insere um elemento no final da fila
        if(isFull()){
            throw new RuntimeException("Fila cheia!");
        }
        values[rear] = element;
        //fazendo o ultimo receber o resto da divisao, garantimos que o ultimo retorna a posição 0 quando chega no final do vetor
        rear = (rear +1) % values.length;
        count++;
    }
    public int dequeue(){//remove e retorna o ultimo elemento da fila
        if(isEmpty()){
            throw new RuntimeException("Fila vazia!");
        }
        int element = values[front];
        //mesma logica do enqueue
        front = (front + 1) % values.length;
        count--;
        return element;
    }
    public boolean isEmpty(){//retorna se a fila esta vazia
        return (count == 0);
    }
    public boolean isFull(){//retorna se a fila esta cheia
        return (count == values.length);
    }
    public int peek(){//retorna o primeiro elemento da fila
        return values[front];
    }
}