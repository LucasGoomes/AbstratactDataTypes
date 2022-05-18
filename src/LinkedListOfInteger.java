public class LinkedListOfInteger {
    
    private class Node{//classe interna node
        public Integer element;
        public Node next;

        public Node(Integer element){
            this.element = element;
            this.next = null;
        }
    }

    //referencias e contagem
    private Node head;
    private Node tail;
    private int count;

    //construtor
    public LinkedListOfInteger(){
        head = null;
        tail = null;
        count = 0;
    }
    //metodos
    public boolean isEmpty(){
        return (head == null);
    }
    public int size(){
        return count;
    }
    public void clear(){
        head = null;
        tail = null;
        count = 0;
    }
    public void add(Integer element){//adiciona um elemento ao final da lista
        Node n = new Node(element);
        if (head == null) {
            head = n;
        }else{
            tail.next = n;
        }
        tail = n;
        count ++;
    }
    public void add(int index, Integer element){
        Node n = new Node(element);
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {//se a inserção for no inicio
            if (count == 0) {//se a lista estiver vazia
                tail = n;
            }else{
                tail.next = head;
            }
            head = n;
        }
        else if(index == count){//se a inserção é no fim
            tail.next = n;
            tail = n;
        }else{
            Node ant = head;
            for (int i = 0; i < index-1; i++) {
                ant = ant.next;
            }
            n.next = ant.next;
            ant.next = n;
        }
        count++;
    }
    public Integer get(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.element;
    }
    public boolean remove(Integer element){
        if (count == 0) {
            return false;
        }
        if (head.element.equals(element)) {
            head = head.next;
            if (count ==  1) {//se tinha apenas um elemento na lista
                tail = null;
            }
            count--;
            return true;
        }
        Node aux = head.next;
        Node ant = head;
        while(aux != null){
            if(aux.element.equals(element)){
                if (aux == tail) {//se remoção do ultimo
                    tail = ant;
                    tail.next = null;
                }else{//se remoção do meio
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
        }
        return false;
    }
    public Integer RemoveByIndex(int index){
        if (index < 0 || index >=size()) {
            throw new IndexOutOfBoundsException();
        }
        Integer elemRemovido;
        if (index == 0) {//se remoção do primeiro
            elemRemovido = head.element;
            if (count == 1) {
                tail = null;
            }
            head = head.next;
            count--;
            return elemRemovido;
        }

        //remoção do meio ou do fim
        Node ant = head;
        for(int i = 0; i < index-1; i++){
            ant = ant.next;
        }
        elemRemovido = ant.next.element;
        if (index == count-1) {
            tail = ant;
            tail.next = null;
        }else{
            ant.next = ant.next.next;
        }
        count--;
        return elemRemovido;
    }
    public int IndexOf(Integer element){
        Node aux = head;
        for (int i = 0; i < size(); i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    public boolean contains(Integer element){//retorna se a lista contem o elemento
        Node aux = head;
        for (int i = 0; i < size(); i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    public boolean equals(LinkedListOfInteger obj){//retorna se as duas listas são iguas
        if(count != obj.count){
            return false;
        }
        Node aux1 = head;
        Node aux2 = obj.head;
        for (int i = 0; i < size(); i++) {
            if (! aux1.element.equals(aux2.element)) {
                return false;
            }
            aux1 = aux1.next;
            aux2 = aux2.next;
        }
        return true;
    }
    public int countOccurrences(Integer element){//conta o numero de ocorrencias de um elemento
        Node aux = head;
        int c = 0;
        for (int i = 0; i < size(); i++) {
            if (aux.element.equals(element)) {
                c++;
            }
            aux = aux.next;
        }

        return c;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }    
    
}