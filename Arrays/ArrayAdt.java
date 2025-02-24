class ArrayAdt {


    private int[] array;

    private int size;

    private int index;

    public ArrayAdt(int size){
        this.size = size;
        this.array = new int[this.size];
        this.index = 0;
    }

    //insert data to the array
    public void insert(int value){
        if(this.size == index) {
            System.out.println("Array is full");
            return;
        }

        array[index] = value;
        index++;
    }

    //delete 
    public void delete(int deleteIndex){
        if (deleteIndex < 0 || deleteIndex >= size) {
            System.out.println("Invalid index");
            return;
        }

        for(int i = deleteIndex; i<size - 1; i++){
            array[i] = arr[i + 1];
        }
        index--;
    }

    //search value and return it's index position
    public int search(int value){
        int indexResult = -1;
        
        for(int i=0;i<index;i++){
            if (array[i] == value) {
                indexResult = i;
                break;
            }
        }
        return indexResult;
    }

    //Get the value based on index
    public int getData(int getIndex){
        if(getIndex < 0 || getIndex >= this.index){
            System.out.println("invalid index");
            return -1;
        }

        return array[getIndex];
    }


    //traverse the array
    public void traverse(){
        for(int i=0;i<index;i++){
            System.out.println(array[i]+"\t");
        }
        System.out.println();
    }


    //Update the array
    public void updateArray(int updateIndex , int value){
        if(updateIndex < 0 || updateIndex >= size) {
            System.out.println("invalid index");
            return;
        }
        array[updateIndex] = value;
    }

    //get the size of array
    public int getSize(){
        return this.index;
    }



}