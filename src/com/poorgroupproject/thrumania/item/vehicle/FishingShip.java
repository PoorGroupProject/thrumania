package com.poorgroupproject.thrumania.item.vehicle;

import com.poorgroupproject.thrumania.events.ClickEvent;
import com.poorgroupproject.thrumania.events.Event;
import com.poorgroupproject.thrumania.events.StopFishingEvent;
import com.poorgroupproject.thrumania.item.GameObject;
import com.poorgroupproject.thrumania.item.human.Citizen;
import com.poorgroupproject.thrumania.item.human.Human;
import com.poorgroupproject.thrumania.item.human.Oriention;
import com.poorgroupproject.thrumania.item.place.Port;
import com.poorgroupproject.thrumania.util.ResourcePath;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *@author yahya
 * @version 1.0.0
 */
public class FishingShip extends Ship  {

    Port port;
    int peopleNum;
    final int peopleCapacity=1200;
    int foodNum=0;

    int shipCapacity;
    Human []fisherMan;
    Image fishingShip;



    public FishingShip(int x, int y) {
        super(x, y, 256, 256);
        //this.port=port;
        fisherMan =new Human[7];
        setCurrentImage(fishingShip);
        shipSpeed = 6;
    }



    public void getHuman(){
        for(int i=0;i<7;i++){
           // fisherMan[i]=pickUpHuman;
        }
    }

    public void IsEmpty(){
       shipCapacity= peopleNum *peopleCapacity;
        if(foodNum==shipCapacity){
            //send event to people stop fishing
            //chang the image
            Human h =new Citizen(0,0, Oriention.Down);
            h.processEvent(new StopFishingEvent(this));


        }
    }

    @Override
    public void loadResoure() {
        try {
            fishingShip = ImageIO.read(new File(ResourcePath.fishingFishPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void processEvent(Event event) {


    }

    @Override
    public void tik() {

    }

    public void setPort(Port port) {
        this.port = port;
    }
}
