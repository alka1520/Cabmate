package com.masai.Repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

import com.masai.Entities.Cab;

@Repository
public interface CabDao extends JpaAttributeConverter<Cab, Integer>{

	
	
}
