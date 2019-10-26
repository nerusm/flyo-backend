package com.flyosports2.manage.InventoryManagementApp.Controller;


import com.flyosports2.manage.InventoryManagementApp.Model.Product;
import com.flyosports2.manage.InventoryManagementApp.Model.Sport;
import com.flyosports2.manage.InventoryManagementApp.Model.Supplier;
import com.flyosports2.manage.InventoryManagementApp.Repository.SupplierRespository;
import com.flyosports2.manage.InventoryManagementApp.Service.FileSystemStorageService;
import com.flyosports2.manage.InventoryManagementApp.Service.ProductMasterService;
import com.flyosports2.manage.InventoryManagementApp.Service.SportsService;
import com.flyosports2.manage.InventoryManagementApp.Service.StorageService;
import com.flyosports2.manage.InventoryManagementApp.UIModels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

    @Autowired
    SportsService sportsService;

    @Autowired
    SupplierRespository supplierRespository;

    @Autowired
    ProductMasterService productMasterService;

    private StorageService storageService;

    @Autowired
    public AppController(StorageService storageService){
        this.storageService = storageService;
    }



    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello!!!";
    }

/*    @RequestMapping(value = "/getSports", method = RequestMethod.GET)
    public Iterable<Sport> getSports(){
        Iterable<Sport> allSports = sportsService.getAllSports();
        return allSports;
    }*/



    @RequestMapping(value = "/getallproducts", method = RequestMethod.GET)
    public Iterable<Product> getAllPorducts(){
        return sportsService.getAllProducts();
    }

    @RequestMapping(value = "/getProductsBySport", method = RequestMethod.GET)
    public List<Product> getProductsBySport(@RequestParam(value = "name") String name){
        return sportsService.getProductsBySport(name);
    }

    @RequestMapping(value = "/getProductsByManufacturer", method = RequestMethod.GET)
    public List<Product> getProductsByManufacturer(@RequestParam(value = "name") String name){
        return (List<Product>) sportsService.getAllProductsByManfacturere(name);
    }

    @RequestMapping(value = "/getProductsByName", method = RequestMethod.GET)
    public List<Product> getProductsByName(@RequestParam(value = "name") String name){
        return (List<Product>) sportsService.getAllProductsByName(name);
    }

    @RequestMapping(value = "/getProductsByNameAndSize", method = RequestMethod.GET)
    public List<Product> getProductsByName(@RequestParam(value = "name") String name,
                                           @RequestParam(value = "size") String size){
        return (List<Product>) sportsService.getAllProductsByNameAndSize(name, size);
    }



    @RequestMapping(value = "/createnewproduct", method = RequestMethod.POST)
    public String createNewProduct( @RequestParam(name = "SportName") String sportName,
                                    @RequestParam(name = "ManufacturerName") String manufacturerName,
                                    @RequestBody Product product){
        sportsService.createNewProduct(sportName, manufacturerName, product);
        return "DONE!";
    }

    @RequestMapping(value = "/sports", method = RequestMethod.GET)
    public List<SportUI> sports(){
        List<Sport> allSports = sportsService.getAllSports();
        System.out.println("Size: "+allSports.size());
        List<SportUI> sportUIS = new ArrayList<>();
        Iterator<Sport> iterator = allSports.iterator();
        while (iterator.hasNext()){
            sportUIS.add(new SportUI(iterator.next().getSportName()));
        }
        System.out.println("Size of UIs: "+sportUIS.size());
        return sportUIS;
    }

/*    @RequestMapping(value = "/sports", method = RequestMethod.POST)
    public String sports(@RequestParam(value = "name") String name){
        sportsService.createNewSport(name);
        return "DONE!";
    }*/

    @RequestMapping(value = "/sports", method = RequestMethod.POST)
    public void sports(@RequestBody SportUI sportUI){
        System.out.println("SAving Sport");
        Sport sport = new Sport(sportUI.getSportName());
        sportsService.createNewSport(sport);
//        return "DONE!";
    }

    @RequestMapping(value = "/deleteEntries", method = RequestMethod.POST)
    public void deleteEntries(@RequestBody CheckedItemsWrapper checkedItemsWrapper){
        System.out.println("fff");
        String entity = checkedItemsWrapper.getEntity();
        switch (entity){
            case "SPORT":
                System.out.println("Delete sport");
                sportsService.deleteSport(checkedItemsWrapper.getCheckedItems());
                break;
            case "SUPPLIER":
                System.out.println("Supplier Delete");
                sportsService.deleteSupplier(checkedItemsWrapper.getCheckedItems());
                break;
            case "PRODUCT":
                System.out.println("Product Delete");
                sportsService.deleteProducts(checkedItemsWrapper.getCheckedItems());
                break;
            default:
                System.out.println("Default");
                break;
        }
//        sportsService.deleteSport();
    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.POST)
    public void suppliers(@RequestBody SupplierUI supplierUI){
        Supplier supplier = new Supplier(supplierUI.getName(),supplierUI.getLocation());
        supplierRespository.save(supplier);
        System.out.println("Supplier Saved: "+supplier.toString());
    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public List<SupplierUI> suppliers(){
        System.out.println("Supplier Requested");
        Iterable<Supplier> supplierIterable = supplierRespository.findAll();
        Iterator<Supplier> supplierIterator = supplierIterable.iterator();
        List<SupplierUI> supplierUIList = new ArrayList<SupplierUI>();
        while (supplierIterator.hasNext()){
            Supplier supplier = supplierIterator.next();
            supplierUIList.add(new SupplierUI(supplier.getSupplierName(), supplier.getLocation() ));
        }
        System.out.println(supplierUIList.size());
        return supplierUIList;
    }


    @RequestMapping(value = "/handleFileUpload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return file.getOriginalFilename();
        
    }

    @RequestMapping(value = "/processProductMasterFile", method = RequestMethod.POST)
    public String processProductMasterCSV(@RequestParam(name = "fileName") String fileName) throws FileNotFoundException {
//        ProductMasterService productMasterService = new ProductMasterService(fileName);
        productMasterService.createProducts(fileName);
        return "Done!";
    }

    @RequestMapping(value = "/deleteProducts", method = RequestMethod.DELETE)
    public void deleteProducts(@RequestParam(name = "name") String name,
                               @RequestParam(name = "model") String model){
        sportsService.deleteProduct(name, model);
    }

    @RequestMapping(value = "/deleteProductsById", method = RequestMethod.DELETE)
    public void deleteProducts(@RequestParam(name = "id") int id){
        sportsService.deleteProduct(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductUI> getAllProducts(){
        List<ProductUI> productUIList = sportsService.getAllProductsUI();
        System.out.println("ProUI List: "+productUIList.size());
        return productUIList;
    }

}
