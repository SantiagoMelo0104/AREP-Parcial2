package org.arep;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;
public class MathService {

    static String[] pr = {"10","20","13","40","60"};
    static String pr1 = "10,20,13,40,60";

    public static void main(String... args) {

        staticFileLocation("public");
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");
        get("/linear", (req, res) -> {
            String list= req.queryParams("list");
            String value= req.queryParams("value");
            return "{\"operation\": \"linearSearch\",\n \"inputlist\": " + list + ", \"value\": "+ value + " \"output\": " + linearSeacrh(list,value) + "\n}";
        });

        get("/binary", (req, res) -> {
            String list= req.queryParams("list");
            String value= req.queryParams("value");

            return "{\"operation\": \"binarySearch\",\n \"inputlist\": " + list + ", \"value\": "+ value + " \"output\": " + binarySearch(list,value) + "\n}";
        });

        System.out.println(binarySearch(pr1, "13"));

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static int linearSeacrh(String lista, String value){
        int respuesta = -1;
        lista=lista.replace("[","").replace("]","");
        List<String> list = new ArrayList<String>(Arrays.asList(lista.split(",")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(value)){
                respuesta = Integer.parseInt(String.valueOf(i));
            }
        }
        return respuesta;
    }

    public static int binarySearchA(List<Integer> lista, int value, int firstElement, int endElement){
        int middleElement = firstElement+(endElement - firstElement)/2;

        if (firstElement > endElement) {
            return -1;
        }

        if(lista.get(middleElement) == value){
            return middleElement;
        } else if (lista.get(middleElement)> value ) {
            return binarySearchA( lista, value , firstElement, middleElement-1);
        } else {
            return binarySearchA( lista, value , middleElement+1, endElement);
        }
    }
    public static int binarySearch(String lista, String value){
        int value1 = Integer.parseInt(value);
        lista=lista.replace("[","").replace("]","");
        List<String> list = new ArrayList<String>(Arrays.asList(lista.split(",")));
        List<Integer> list1 = new ArrayList<>();
        for(String number: list){
            list1.add(Integer.parseInt(number));
        }
        return  binarySearchA(list1, value1, 0, list1.size()-1);
    }

}
