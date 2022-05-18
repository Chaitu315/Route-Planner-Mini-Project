package com.chaitanya;

import java.util.stream.Stream;

public class Travelling
{
    String fromCity;
    String toCity;
    String distance;
    String departureTime;
    String ticketCost;

    public Travelling(String fromCity, String toCity, String distance, String departureTime, String ticketCost)
    {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.departureTime = departureTime;
        this.ticketCost = ticketCost;
    }

    @Override
    public String toString()
    {
        return "Travelling { fromCity : " + fromCity +", toCity : " +
                toCity +", distance : " + distance + ", departureTime : " +
                departureTime +", ticketCost : " + ticketCost +" }";
    }

}
