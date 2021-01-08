package demo.mapper;

import demo.domain.Category;
import org.apache.ibatis.annotations.Param;

public interface CategoryDao {
    Category getCategoryById(@Param("id") String id);
}
