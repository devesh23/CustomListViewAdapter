package com.devesh.customlistviewadapter;


public class DataProvider {

    private int food_poster_resource;
    private String FoodName;
    private String Price;

    public DataProvider(int Food_poster_resource,String FoodName,String Price)
    {
        this.setFood_poster_resource(Food_poster_resource);
        this.setFoodName(FoodName);
        this.setPrice(Price);

    }
    public int getFood_poster_resource() {
        return food_poster_resource;
    }

    public void setFood_poster_resource(int food_poster_resource) {
        this.food_poster_resource = food_poster_resource;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
