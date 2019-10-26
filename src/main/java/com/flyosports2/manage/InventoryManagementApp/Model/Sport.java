package com.flyosports2.manage.InventoryManagementApp.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int sportID;
    String sportName;


/*
    @OneToMany
    @JoinTable(name = "SPORT_PRODUCT", joinColumns = @JoinColumn(name = "SPORT_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private Collection<Product> products;
*/

    public Sport() {
    }

    public Sport(int sportID, String sportName) {
        this.sportID = sportID;
        this.sportName = sportName;
    }

    public Sport(String sportName) {
        this.sportName = sportName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

/*
    public Collection<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        if(products==null){
            products = new ArrayList<Product>();
        }
        if(!products.contains(product)){
            products.add(product);
        }
    }
*/

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", sportID=" + sportID +
                ", sportName='" + sportName + '\'' +
                '}';
    }
}