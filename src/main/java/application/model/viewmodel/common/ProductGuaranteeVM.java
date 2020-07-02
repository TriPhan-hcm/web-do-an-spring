package application.model.viewmodel.common;

import java.util.Date;

public class ProductGuaranteeVM {
    private int id;
    private String detail;
    private Date guaranteeDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getGuaranteeDay() {
        return guaranteeDay;
    }

    public void setGuaranteeDay(Date guaranteeDay) {
        this.guaranteeDay = guaranteeDay;
    }
}
