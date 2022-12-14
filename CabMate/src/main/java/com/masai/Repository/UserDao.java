package com.masai.Repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

import com.masai.Entities.User;

@Repository
public interface UserDao extends JpaAttributeConverter<User, String> {

}
