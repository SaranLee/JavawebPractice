package demo.mapper;

import demo.domain.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductDao {
    Product getProductById(@Param("id") String id);
}

