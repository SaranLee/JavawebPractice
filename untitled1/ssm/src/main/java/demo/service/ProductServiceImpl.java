package demo.service;

import demo.domain.Product;
import demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> list() {
        return mapper.selectByExample(null);
    }
}
