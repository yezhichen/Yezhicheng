package com.bawei.electricityproject.bean;

/**
 * Created by 叶至成 on 2019/3/26.
 */
public class ResultBean {

        private boolean isCheck;
        private int commodityId;
        private String commodityName;
        private int count;
        private String pic;
        private int price;

    public ResultBean(boolean isCheck, int commodityId, String commodityName, int count, String pic, int price) {
        this.isCheck = isCheck;
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.count = count;
        this.pic = pic;
        this.price = price;
    }

    public ResultBean() {
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "isCheck=" + isCheck +
                ", commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", count=" + count +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                '}';
    }
}
