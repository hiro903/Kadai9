package com.example.cosmetic9;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface CosmeticMapper {
    @Select("SELECT * FROM cosmetics WHERE id =#{id}")
    Optional<Cosmetic> findBYId(int id);
}
