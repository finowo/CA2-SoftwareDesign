package com.company;

//an interface is a list of abstract methods
//any class that promises to implement the interface must write these methods
//an interface forces similar classes to have the same methods
public interface Reports {
    public abstract void printDetailedReport();
    public abstract void printSummary();

}
