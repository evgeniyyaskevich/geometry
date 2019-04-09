package by.epam.evgeniyyaskevich.shapes.entity;

import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Shape extends Observable {

    private static final AtomicInteger NEXT_ID = new AtomicInteger(0);

    protected final int ID = NEXT_ID.getAndIncrement();
    protected String name;


    protected Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public int getId() {
        return ID;
    }
}
