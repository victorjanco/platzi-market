package com.platzi.market;

import com.platzi.market.persistence.ProductoRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PlatziMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);

//		ProductoRepository productoRepository= new ProductoRepository();
//
//		List<Producto> listadoProductos = productoRepository.getAll();
//		for(Producto row: listadoProductos) {
//			System.out.println(row.getNombre());
//		}
	}

}
