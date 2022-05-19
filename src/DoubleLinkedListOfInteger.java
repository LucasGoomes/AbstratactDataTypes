public class DoubleLinkedListOfInteger {
    //atributos
    private Node header;
    private Node trailer;
    private Node current;//referencia para a posição corrente
    private int count;

    private class Node{//classe privada que implementa o nodo
        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer e){
            element = e;
            next = null;
            prev = null;
        }
    }
    public DoubleLinkedListOfInteger(){
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;

    }
    //metodos
    private Node getNodeIndex(int index){//retorna uma referencia para o nodo da posição index
        Node aux;
        //verificamos se está mais perto do inicio ou do final
        if(index < count/2){
            aux = header;
            for(int i =0; i<index; i++){
                aux = aux.next;
            }
        }else{
            aux = trailer.prev;
            for (int i = count-1; i > index; i--){
                aux = aux.prev;
            }
        }
        return aux;
    }
    public void add(Integer element){
        Node n = new Node(element);

        n.prev = trailer.prev;
        n.next = trailer;
        trailer.prev.next = n;
        trailer.prev = n;
        count++;
    }
    public void add(int index, Integer element) throws IndexOutOfBoundsException{
        if (index < 0 || index > count) {//indice invalidos
            throw new IndexOutOfBoundsException();
        }
        if (index == count) {
            add(element);
        }else{
            Node n = new Node(element);
            Node aux = getNodeIndex(index);

            n.next = aux;
            n.prev = aux.prev;

            aux.prev.next = n;
            aux.prev = n;
            count++;
        }
    }
    public boolean remove(Integer element){
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) { 
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;               
                return true;
            }
            aux = aux.next;
        }
        return false;	
    }
    public Integer removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        
        Node aux = getNodeIndex(index);
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return aux.element;
    }
    public Integer get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        Integer elem = aux.element;
        aux.element = element;
        return elem;
    }
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    } 
    public int size() {
        return count;
    }
    public boolean isEmpty() {
        return (count == 0);
    }
    public void reset() {
        current = header.next;
    }
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }
}
