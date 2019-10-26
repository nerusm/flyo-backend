package com.flyosports2.manage.InventoryManagementApp.Model;

public class AllSportsView {
    Iterable<Sport> sports;

    public AllSportsView(Iterable<Sport> sports) {
        this.sports = sports;
    }

    public AllSportsView() {
    }

    public Iterable<Sport> getSports() {
        return sports;
    }

    public void setSports(Iterable<Sport> sports) {
        this.sports = sports;
    }
}
