package org.example.random;

public class sample {

    String s = "Hello World";

     void getData(){
        System.out.println("Content is:-"+s);
    }

    void setData(String s){
        this.s = s;
    }


    public static void main(String args[]){

        sample s = new sample();
        s.setData("Bye Bye");
        s.getData();
    }


}
