package MYCBackend.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeInProductService {

    private final SizeRepository repo;

    @Autowired
    public SizeInProductService(SizeRepository repo) {
        this.repo = repo;
    }

    public List<SizeInProduct> getAllSizeInProducts() {
        return repo.findAll();
    }

    public SizeInProduct getSizeInProductById(int id) {
        return repo.findById(id).get();
    }

    public SizeInProduct createSizeInProduct(SizeInProduct sizeInProduct) {
        // Throw exception if sizeInProduct already exists
        repo.findBySizeNameAndProductID(sizeInProduct.getSizeName(), sizeInProduct.getProductID())
                .ifPresent( param -> {
                    throw new IllegalStateException("SizeInProduct already exists");
                });
        return repo.save(sizeInProduct);
    }

    public SizeInProduct updateSizeInProduct(int id, SizeInProduct sizeInProduct) {
        // Throw exception if sizeInProduct does not exist
        if(!repo.existsById(id)){
            throw new IllegalStateException("SizeInProduct doest not exist");
        }
        return repo.save(sizeInProduct);
    }

    public boolean deleteSizeInProduct(int id) {
        // Throw exception if size does not exist
//        if(!repo.existsById(id)){
//            throw new IllegalStateException("SizeInProduct doest not exist");
//        }
        try {
            repo.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;

    }

    public SizeInProduct updateQuantity(int id, int newQuantity) {
        // Throw exception if size does not exist
        SizeInProduct temp = repo.findById(id)
                .orElseThrow( () -> {
                    throw new IllegalStateException("SizeInProduct doest not exist");
                });
        temp.setQuantity(newQuantity);
        return repo.save(temp);

    }
}