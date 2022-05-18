package com.chaitanya;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutePlanner
{
    RoutePlanner()
    {

    }

    List<Travelling> flightList;
    public List<Travelling> showRoutePlanner()
    {
        flightList = new ArrayList<>();
        String line = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/com/chaitanya/routes.csv"));
            while((line=br.readLine())!=null)
            {
                String[] split = line.split(",");
                Travelling travel = new Travelling(split[0],split[1],split[2],split[3],split[4]);
                flightList.add(travel);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return flightList;
    }

    public List<Travelling> showDirectFlights(List<Travelling> allFlights,String departureCity)
    {
        int count = 0;
        for (Travelling list3 : allFlights)
        {
            if (list3.fromCity.equalsIgnoreCase(departureCity))
            {
                count++;
            }
        }

        List<Travelling> list1 = null;
        if (count == 0)
        {
            System.out.println("We are sorry. At this point of time, we do not have any information on flights originating from ---> " + departureCity);

        }
        else
        {
            list1 = allFlights.stream().filter(trave -> trave.fromCity.equalsIgnoreCase(departureCity)).collect(Collectors.toList());
        }
        return list1;
    }

    public void sortDirectFlights(List<Travelling> directFlights)
    {
        List<Travelling> sorted = directFlights.stream().sorted((flight1,flight2)->flight1.toCity.compareToIgnoreCase(flight2.toCity)).collect(Collectors.toList());
        sorted.forEach(flight->System.out.println(flight));
    }

    public void showAllConnections(List<Travelling> flightList, String startCity, String destinationCity)
    {
        //Finding direct flight from startCity to destinationCity
        List<Travelling> directFlight = flightList.stream().filter(flight->flight.fromCity.trim().equalsIgnoreCase(startCity) && flight.toCity.trim().equalsIgnoreCase(destinationCity)).collect(Collectors.toList());
        directFlight.forEach(fl->System.out.println(fl));

        //Direct flight list from startCity
        List<Travelling> directFlights1 = showDirectFlights(flightList,startCity);

        //All flight list
        List<Travelling> flightList1 = showRoutePlanner();


    }

}

 /*
List<Travelling> flightList3 = null;
for(Travelling indirectFlight1 : directFlights1)
{

    flightList3 = flightList1.stream().filter(flight-> flight.fromCity.trim().equalsIgnoreCase(indirectFlight1.toCity.trim())
                    && flight.toCity.trim().equalsIgnoreCase(destinationCity)).collect(Collectors.toList());

}
flightList3.forEach(fl->System.out.println(fl));

List<Travelling> flightList4 = null;
for(Travelling indirectFlight4 :flightList3)
{
    flightList4 = flightList1.stream().filter(flight-> flight.fromCity.trim().equalsIgnoreCase(startCity)
            && flight.toCity.trim().equalsIgnoreCase(indirectFlight4.fromCity.trim())).collect(Collectors.toList());
}
if(!(flightList4 ==null))
{
    flightList4.forEach(fl->System.out.println(fl));
}*/

