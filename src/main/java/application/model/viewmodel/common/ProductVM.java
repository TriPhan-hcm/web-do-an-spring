package application.model.viewmodel.common;

import application.data.model.SizeColor;

import java.util.List;

public class ProductVM {
    private int id;
    private String categoryName;
    private String name;
    private String shortDesc;
    private String description;
    private String product_main_image;
    private String manufacturer;
    private String model;
    private String screen;
    private String resolution;
    private String cpu;
    private String ram;
    private String camera;
    private String pin;
    private String other;
    private String size;
    private int yearGuaratee;

    public int getYearGuaratee() {
        return yearGuaratee;
    }

    public void setYearGuaratee(int yearGuaratee) {
        this.yearGuaratee = yearGuaratee;
    }

    private List<ProductImageVM> productImageVMS;
    private List<RateVM> rateVMS;
    private List<ProductGuaranteeVM> productGuaranteeVMS;
    private List<SizeColorVM> sizeColorVMS;

    public List<SizeColorVM> getSizeColorVMS() {
        return sizeColorVMS;
    }

    public void setSizeColorVMS(List<SizeColorVM> sizeColorVMS) {
        this.sizeColorVMS = sizeColorVMS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryId) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_main_image() {
        return product_main_image;
    }

    public void setProduct_main_image(String product_main_image) {
        this.product_main_image = product_main_image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<ProductImageVM> getProductImageVMS() {
        return productImageVMS;
    }

    public void setProductImageVMS(List<ProductImageVM> productImageVMS) {
        this.productImageVMS = productImageVMS;
    }

    public List<RateVM> getRateVMS() {
        return rateVMS;
    }

    public void setRateVMS(List<RateVM> rateVMS) {
        this.rateVMS = rateVMS;
    }

    public List<ProductGuaranteeVM> getProductGuaranteeVMS() {
        return productGuaranteeVMS;
    }

    public void setProductGuaranteeVMS(List<ProductGuaranteeVM> productGuaranteeVMS) {
        this.productGuaranteeVMS = productGuaranteeVMS;
    }
}
