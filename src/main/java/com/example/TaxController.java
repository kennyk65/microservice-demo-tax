package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {

	
	/**
	 * Get the amount of taxes for a given product code.  
	 * The business logic is pretty simple so we'll do it all here in the controller:
	 */
	@GetMapping("/taxes")
	public Item getProduct( @RequestBody Item item) {
	
		if (item.getQuantity() == null || item.getQuantity() < 1 ) item.setQuantity(1l);
		
		// Item "EEE" is tax exempt.  Everything else is taxed at 10%:
		if( item.getCode().equalsIgnoreCase("EEE")) {
			item.setTax(new BigDecimal(0)); 
		} else {
			item.setTax( 
				item.getPrice()
				.multiply( new BigDecimal(item.getQuantity()))
				.multiply(new BigDecimal(0.1))
				.setScale(2, RoundingMode.HALF_UP)
				);
		}
		return item;
	}

	@GetMapping("/taxes/{code}/price/{price}")
	public Item getProduct(@PathVariable String code, @PathVariable BigDecimal price ) {
		return getProduct( new Item(code,price,1l) );
	}
}
