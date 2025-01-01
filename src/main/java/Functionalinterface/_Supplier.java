package Functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.print(getDBConnectionUrl());
        System.out.print(getConnectionURLsSupplier.get());
    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:5332/users";
    }

    static Supplier<List<String>> getConnectionURLsSupplier = ()
            ->  List.of(
                    "jdbc://localhost:5332/users",
                    "jdbc://localhost:5332/customer");

}
