package com.chaitanya;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n----------------------------------------------- TASK - 1 ---------------------------------------------------");
        RoutePlanner route = new RoutePlanner();
        List<Travelling> list1 =  route.showRoutePlanner();
        list1.forEach(travel->System.out.println(travel));

        System.out.println("\n----------------------------------------------- TASK - 2 ---------------------------------------------------");
        List<Travelling> list2 = route.showDirectFlights(list1,"Frankfurt");
        if(list2 != null)
        {
            list2.forEach(travel->System.out.println(travel));
        }

        System.out.println("\n----------------------------------------------- TASK - 3 ----------------------------------------------------");
        route.sortDirectFlights(list2);

        System.out.println("\n------------------------------------------------- TASK - 4 ----------------------------------------------------");
        route.showAllConnections(list1,"Frankfurt","San Francisco");

    }
}
