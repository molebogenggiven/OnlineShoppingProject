package com.michaelcgood.Service;

import com.michaelcgood.dao.MenRepository;
import com.michaelcgood.model.MenModel;
import com.michaelcgood.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenService {

    @Autowired
    MenRepository menRepository;
    public void saveMenItemToDatabase(Product product){
        MenModel menModel = new MenModel();
        menModel.setProductId(product.getProductId());
        menModel.setCategoty(product.getCategory());
        menModel.setPictureData(product.getPictureData());
        menModel.setProductName(product.getProductName());
        menModel.setProductPrice(product.getProductPrice());
        menModel.setProductQuantity(product.getProductQuantity());
        menModel.setProductSize(product.getProductSize());


        menRepository.save(menModel);

    }

}
