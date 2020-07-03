package application.controller.api;
import application.data.model.Cart;
import application.data.model.CartProduct;

import application.data.model.Category;
import application.data.model.Product;
import application.data.service.*;
import application.model.api.BaseApiResult;
import application.model.dto.CartDTO;
import application.model.dto.CartProductDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/api/cart")
public class CartApiController {
    private static final Logger logger = LogManager.getLogger(CartApiController.class);

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public BaseApiResult addToCart(@RequestBody CartDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
           Cart cart = new Cart();
           cart.setId(dto.getId());
            cart.setGuid(dto.getGuid());
            cart.setUserName(dto.getUserName());
            cartService.addNewCart(cart);
            result.setSuccess(true);
            result.setMessage("Create category successfully: " + cart.getId());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return result;
    }

}
