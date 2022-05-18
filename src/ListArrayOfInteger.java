public class ListArrayOfInteger {
    //atributos
    private static final int INITIAL_SIZE = 10;
    private Integer [] data;
    private int count;
    //construtores
    public ListArrayOfInteger(){
        this(INITIAL_SIZE);
    }
    public ListArrayOfInteger(int tam){
        if (tam <= 0 ) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }
    //metodos
    public void clear(){
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public int size(){
        return count;
    }
    private void setCapacity(int newCapacity){//aumenta o tamanho da lista
        if(newCapacity != data.length){
            int min = 0;//até onde seram armazenados os dados atuais
            Integer newData[] = new Integer[newCapacity];
            if (newCapacity > data.length) {
                min = data.length;
            }else{
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
    public void add(Integer element){//adiciona no final da lista
        if (count == data.length) {
            setCapacity(2 * data.length);
        }
        data[count] = element;
        count++;
    }
    public void add(int index, Integer element){//adiciona a uma determinada posição da lista
        if(index < 0 || index >size()){
            throw new IndexOutOfBoundsException();
        }
        if(count == data.length){//duplica o tamanho da lista caso nao haja espaçço
            setCapacity(2 * data.length);
        }
        for (int i = count; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        count++;
    }
    public int get(int index){//retona o elemento de uma posição especifica
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
    public boolean remove(Integer element){//remove a primeira ocorrencia de um elemento
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element)) {
                for (int j = i; j < count-1; j++) {
                    data[j] = data[j+1];
                }
                count--;
                return true;
            }
        }
        return false;
    }
    public Integer set(int index, Integer element){//substitui e retorna o elemento substituido
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException();
        }
        Integer aux = data[index];
        data[index] = element;
        return aux;
    }
    public boolean contains(Integer element){//procura um elemento na lista
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    public Integer removeByIndex(int index){
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Integer aux = data[index];
        for (int i = index; i < count-1; i++) {
            data[i] = data[i+1];
        }
        count--;
        return aux;
    }
    public int indexOf(Integer element){//retorna o indice de um determinado elemento
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }
}
