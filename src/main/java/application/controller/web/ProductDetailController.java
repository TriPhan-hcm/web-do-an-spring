package application.controller.web;

import application.data.model.Product;
import application.data.model.ProductImage;
import application.data.model.Rate;
import application.data.model.SizeColor;
import application.data.service.ProductService;
import application.model.viewmodel.common.ProductImageVM;
import application.model.viewmodel.common.ProductVM;
import application.model.viewmodel.common.RateVM;
import application.model.viewmodel.common.SizeColorVM;
import application.model.viewmodel.productdetail.ProductDetailVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping(path="/product")
public class ProductDetailController extends BaseController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public String productDetail(@PathVariable Integer productId, Model model,
                                @Valid @ModelAttribute("productname") ProductVM productName,
                                HttpServletResponse response,
                                HttpServletRequest request,
                                final Principal principal){
//        this.ch
        ProductDetailVM vm =  new ProductDetailVM();
        Product productEntity = productService.findOne(productId);
        ProductVM productVM = new ProductVM();


        if(productEntity != null){
            productVM.setId(productEntity.getId());
            productVM.setName(productEntity.getName());
            productVM.setCamera(productEntity.getCamera());
            productVM.setCpu(productEntity.getCpu());
            productVM.setModel(productEntity.getModel());
            productVM.setManufacturer(productEntity.getManufacturer());
            productVM.setPin(productEntity.getPin());
            productVM.setRam(productEntity.getRam());
            productVM.setProduct_main_image(productEntity.getProduct_main_image());
            productVM.setScreen(productEntity.getScreen());
            productVM.setResolution(productEntity.getResolution());
            productVM.setShortDesc(productEntity.getShortDesc());
            productVM.setDescription(productEntity.getDescription());
            productVM.setSize(productEntity.getSize());
            productVM.setYearGuaratee(productEntity.getYearGuaratee());
            productVM.setOther(productEntity.getOther());

            //List : ProductImage

            List<ProductImageVM> productImageVMS = new ArrayList<>();
            for(ProductImage productImage : productEntity.getProductImageList()){
                ProductImageVM productImageVM = new ProductImageVM();

                productImageVM.setLink(productImage.getLink());

                productImageVMS.add(productImageVM);
            }
            productVM.setProductImageVMS(productImageVMS);

            //List: Rate

            List<RateVM> rateVMS = new ArrayList<>();
            for(Rate rate : productEntity.getRateList()){
                RateVM rateVM = new RateVM();

                rateVM.setStar(rate.getStar());

                rateVMS.add(rateVM);
            }
            productVM.setRateVMS(rateVMS);

            //List: SizeColor

            List<SizeColorVM> sizeColorVMS = new ArrayList<>();
            for(SizeColor sizeColor : productEntity.getListSizeColor()){
                SizeColorVM sizeColorVM = new SizeColorVM();

                sizeColorVM.setColor(sizeColor.getColor());
                sizeColorVM.setPrice(sizeColor.getPrice());
                sizeColorVM.setAmount(sizeColor.getAmount());

                sizeColorVMS.add(sizeColorVM);
            }
            productVM.setSizeColorVMS(sizeColorVMS);
        }
        vm.setLayoutHeaderVM(this.getLayoutHeaderVM());
        vm.setProductVM(productVM);

        model.addAttribute("vm", vm);
        return "/index";
    }

}
