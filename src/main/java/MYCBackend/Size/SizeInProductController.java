package MYCBackend.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizeInProducts")
public class SizeInProductController {


    private final SizeInProductService service;

    @Autowired
    public SizeInProductController(SizeInProductService service) {
        this.service = service;
    }

    @GetMapping(path = "", produces = {"application/json"})
    public List<SizeInProduct> getAllSizeInProducts(){
        return service.getAllSizeInProducts();
    }

    @GetMapping(path="/{id}", produces = {"application/json"})
    public SizeInProduct getSizeInProductById(@PathVariable("id") int id){
        return service.getSizeInProductById(id);
    }

    @PostMapping(path = "", produces = {"application/json"})
    public SizeInProduct createSizeInProduct(@RequestBody SizeInProduct sizeInProduct){
        return service.createSizeInProduct(sizeInProduct);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public SizeInProduct updateSizeInProduct(@PathVariable("id") int id, @RequestBody SizeInProduct sizeInProduct){
        return service.updateSizeInProduct(id, sizeInProduct);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public boolean deleteSizeInProduct(@PathVariable("id") int id){
        return service.deleteSizeInProduct(id);
    }

    @PutMapping(path="/{id}/update/{newQuantity}", produces = "application/json")
    public SizeInProduct updateQuantity(@PathVariable("id") int id, @PathVariable("newQuantity") int newQuantity){
        return service.updateQuantity(id, newQuantity);
    }
}