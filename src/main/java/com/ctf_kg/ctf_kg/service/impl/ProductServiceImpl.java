package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.product.ProductResponse;
import com.ctf_kg.ctf_kg.entities.Product;
import com.ctf_kg.ctf_kg.entities.User;
import com.ctf_kg.ctf_kg.entities.UserAllProductInformation;
import com.ctf_kg.ctf_kg.enums.Role;
import com.ctf_kg.ctf_kg.exception.BadCredentialsException;
import com.ctf_kg.ctf_kg.mapper.product.ProductMapper;
import com.ctf_kg.ctf_kg.repositories.ProductRepository;
import com.ctf_kg.ctf_kg.repositories.UserAllProductInformationRepository;
import com.ctf_kg.ctf_kg.repositories.UserRepository;
import com.ctf_kg.ctf_kg.service.ProductService;
import com.ctf_kg.ctf_kg.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final UserAllProductInformationRepository userAllProductInformationRepository;
    @Override
    public List<ProductResponse> getAll() {
        return productMapper.toDtoS(productRepository.findAll());
    }

    @Override
    public List<ProductResponse> search(String search) {
        if (search.isEmpty())
            return productMapper.toDtoS(productRepository.findAll());
        return productMapper.toDtoS(productRepository.searchByMultipleFields(search, search, search));

    }

    @Override
    public int setFlag(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElseThrow();

        if (!user.getRole().equals(Role.SMI)){
            throw new BadCredentialsException("the role is not SMI!");
        }
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
           Optional<UserAllProductInformation> userAllProductInformation = userAllProductInformationRepository.findByUserIdAndProductId(user.getId(), productId);
           if (userAllProductInformation.isPresent()){
               if(userAllProductInformation.get().getIsProduct().equals(true)){
                   userAllProductInformation.get().setIsProduct(false);
                   if (product.get().getFlag()>0){
                       product.get().setFlag(product.get().getFlag()-1);
                   }
                   else {
                       product.get().setFlag(0);
                   }
               }
               else {
                   userAllProductInformation.get().setIsProduct(true);
                   if (product.get().getFlag()>0){
                       product.get().setFlag(product.get().getFlag()+1);
                   }
                   else {
                       product.get().setFlag(1);
                   }
               }
               userAllProductInformationRepository.save(userAllProductInformation.get());

           }
           else {
               UserAllProductInformation userAllProductInformation1 = new UserAllProductInformation();
               userAllProductInformation1.setUserId(user.getId());
               userAllProductInformation1.setProductId(productId);
               userAllProductInformation1.setIsProduct(true);
               userAllProductInformationRepository.save(userAllProductInformation1);
               if (product.get().getFlag()>0){
                   product.get().setFlag(product.get().getFlag()+1);
               }
               else {
                   product.get().setFlag(1);
               }
           }
           productRepository.save(product.get());
           return product.get().getFlag();
        }
        else {
            throw new BadCredentialsException("the product with this id{"+productId+"} is not present!");
        }
    }

    @Override
    public List<Object[]> getFive() {
        return productRepository.findTopTypeOfProducts();
    }

    @Override
    public void comment(String token, Long productId, String content) {
        User user = userService.getUsernameFromToken(token);
        if (user.getRole().equals(Role.SMI)){
            Optional<Product> product = productRepository.findById(productId);
            if (product.isPresent()){

            }
        }
    }
}
