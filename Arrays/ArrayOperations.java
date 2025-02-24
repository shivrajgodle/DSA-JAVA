public class ArrayOperations {
    public static void main(String args[]){
        ArrayAdt adt = new ArrayAdt(10);

        adt.insert(5);
        adt.insert(12);
        adt.insert(3);
        adt.insert(123);
        
        System.out.println("Array size :"+adt.getSize());

        adt.traverse();

    }
}
