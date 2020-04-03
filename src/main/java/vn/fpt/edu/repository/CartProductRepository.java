package vn.fpt.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.fpt.edu.entity.CartProduct;
import vn.fpt.edu.entity.CartProductId;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, CartProductId>{

}
