package org.zxy.mapper;


import org.springframework.stereotype.Repository;
import org.zxy.entity.User;

@Repository
public interface UserMapper {

    User Sel(int id);
}