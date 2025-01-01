package Final;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
hello("Tony","Montana",value ->{
    System.out.println("no lastName provided for" + " " + value);
});
    }

    static void hello (String firstName , String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if (lastName != null ){
            System.out.println(lastName);
        }else{
            callback.accept(firstName);
        }
    }


//    fuction hello (firstName,lastName,callback){
//        console.log(firstName);
//        if (lastName){
//            console.log(lastName)
//        }else{
//            callback();
//        }
//    }
    //hello ("John",null,fuction() {console.log("noLastNameprovided")})
    //John
    //no LastName provided
 }
