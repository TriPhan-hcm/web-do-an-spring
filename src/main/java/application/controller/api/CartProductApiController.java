package application.controller.api;

import application.data.model.Cart;
import application.data.model.CartProduct;

import application.data.model.Product;
import application.data.service.*;
import application.model.api.BaseApiResult;
import application.model.dto.CartProductDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/api/cart-product")
public class CartProductApiController {
    private static final Logger logger = LogManager.getLogger(CartProductApiController.class);

    @Autowired
    private CartService cartService;

    @Autowired
    private CartProductService cartProductService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public BaseApiResult addToCart(@RequestBody CartProductDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            if(dto.getGuid() != null && dto.getAmount() > 0 && dto.getProductId() > 0) {
                Cart cartEntity = cartService.findFirstCartByGuid(dto.getGuid());
                Product productEntity = productService.findOne(dto.getProductId());
                if(cartEntity != null && productEntity != null) {
                    CartProduct cartProductEntity = cartProductService.findFirstCartProductByCartIdAndProductId(cartEntity.getId(),productEntity.getId());
                    if(cartProductEntity != null) {
                        cartProductEntity.setAmount(cartProductEntity.getAmount() + dto.getAmount());
                        cartProductService.updateCartProduct(cartProductEntity);
                    } else {
                        CartProduct cartProduct = new CartProduct();

                        cartProduct.setAmount(dto.getAmount());
                        cartProduct.setColor(dto.getColor());
                        cartProduct.setPrice(dto.getPrice());
                        cartProduct.setCart(cartEntity);
                        cartProduct.setProduct(productEntity);

                        cartProductService.addNewCartProduct(cartProduct);
                    } // ông bảo chạy đâu
                    result.setMessage("Add to cart successfully!");
                    result.setSuccess(true);
                    return result;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        result.setMessage("Fail!");
        result.setSuccess(false);
        return result;
    }

    @PostMapping("/update")
    public BaseApiResult updateCartProduct(@RequestBody CartProductDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            if(dto.getId()>0 && dto.getAmount() > 0) {
                CartProduct cartProductEntity = cartProductService.findOne(dto.getId());

                if(cartProductEntity != null) {
                    cartProductEntity.setAmount(dto.getAmount());
                    cartProductService.updateCartProduct(cartProductEntity);
                    result.setMessage("Update Cart Product success !");
                    result.setSuccess(true);
                    return result;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        result.setMessage("Fail!");
        result.setSuccess(false);
        return result;
    }

    @GetMapping("/delete/{cartProductId}")
    public BaseApiResult deleteCartProduct(@PathVariable int cartProductId) {
        BaseApiResult result = new BaseApiResult();

        try {
            if(cartProductService.deleteCartProduct(cartProductId) == true) {
                result.setMessage("Delete success");
                result.setSuccess(true);
                return result;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        result.setSuccess(false);
        result.setMessage("Fail!");
        return result;
    }
}
