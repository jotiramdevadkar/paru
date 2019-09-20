
package com.paru.enterprices.admin.controller;

import static com.paru.enterprices.admin.constants.ControllerConstants.PRODUCT_CONTROLLER;
import static com.paru.enterprices.services.constants.ResponceConstant.ADDED_SUCESSFULLY;

import java.util.List;
import java.util.Set;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paru.enterprices.database.entity.Product;
import com.paru.enterprices.database.entity.ProductVariation;
import com.paru.enterprices.admin.controller.ResponseVo;
import com.paru.enterprices.services.OfferService;
import com.paru.enterprices.services.ProductService;
import com.paru.enterprices.services.dto.OfferDto;
import com.paru.enterprices.services.dto.OfferRetriveDto;
import com.paru.enterprices.services.dto.ProductDto;
import com.paru.enterprices.services.dto.UpdateOfferDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(PRODUCT_CONTROLLER)
public class ProductController {
	@Autowired
	private OfferService offerService;
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/addOffer")
	public ResponseEntity<Object> addOffer(@RequestBody OfferDto addOfferDto) {
		String result = offerService.addOffers(addOfferDto);

		if (ADDED_SUCESSFULLY.equals(result)) {

			ResponseVo response = new ResponseVo();
			response.setMessage(result);
			response.setMessageCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			ResponseVo response = new ResponseVo();
			response.setErrorMessage(result);
			response.setErrorCode(HttpStatus.NOT_FOUND.value());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	@PutMapping(value = "/updateOffer")
	public ResponseEntity<Object> updateOffer(@RequestBody UpdateOfferDto updateOfferDto) {
		String result = offerService.updateOffers(updateOfferDto);

		if (ADDED_SUCESSFULLY.equals(result)) {

			ResponseVo response = new ResponseVo();
			response.setMessage(result);
			response.setMessageCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			ResponseVo response = new ResponseVo();
			response.setErrorMessage(result);
			response.setErrorCode(HttpStatus.NOT_FOUND.value());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	@GetMapping(value = "getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> products = productService.getAllProucts();
		if (products != null) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.NOT_FOUND);

	}

	@GetMapping(value = "getProductVariations/{productId}")
	public ResponseEntity<List<ProductVariation>> getProductVariations(@PathVariable("productId") Long productId) {
		List<ProductVariation> result = productService.getProductVariations(productId);
		if (result != null) {
			return new ResponseEntity<List<ProductVariation>>(result, HttpStatus.OK);
		}
		return new ResponseEntity<List<ProductVariation>>(result, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "getAllProductDetails")
	public ResponseEntity<List<ProductDto>> getAllProductDetails() {
		List<ProductDto> productDto = productService.getProducts();
		if (productDto != null) {
			return new ResponseEntity<List<ProductDto>>(productDto, HttpStatus.OK);
		}
		return new ResponseEntity<List<ProductDto>>(productDto, HttpStatus.NOT_FOUND);

	}

	@GetMapping(value = "offers")
	public Set<OfferRetriveDto> getOffers(String status) {
		Set<OfferRetriveDto> productDto = offerService.getOffers(status, null, null, null);
		return productDto;
	}

	public ResponseEntity<Set<OfferRetriveDto>> getOffers(@QueryParam("status") String status,@QueryParam("productId")Long productId,@QueryParam("productVariationId")Long productVariationId,@QueryParam("quantity") Integer quantity) {
		Set<OfferRetriveDto> productDto = offerService.getOffers(status,productId,productVariationId,quantity);
		if (productDto != null) {
			return new ResponseEntity<Set<OfferRetriveDto>>(productDto, HttpStatus.OK);
		}
		return new ResponseEntity<Set<OfferRetriveDto>>(productDto, HttpStatus.NOT_FOUND);

	}

}
