package com.strictlyindian.rentsmart.StorageHelpers;

import android.content.Context;
import android.util.Log;

import com.strictlyindian.rentsmart.Model.CartModel;
import com.strictlyindian.rentsmart.Model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 9/3/17.
 * Helper class to Handle Cart Functionality
 *
 *It performs add ,remove to {@link CartModel } from cart
 *
 * Cart model if Different From Product Model
 */

public class CartHandler  {

    private static final String TAG = "CART_HANDLER";
    private List<CartModel> mCartProducts;

    private Context mContext =  null;
    private DataStore mDataStore  = null;
    private static CartHandler mCartHandler;

    public CartHandler(Context mContext) {
        this.mContext = mContext;
        mDataStore  = DataStore.getStorageInstance(mContext);

    }



    public static synchronized CartHandler getInstance(Context context) {
        if (mCartHandler == null) {
            mCartHandler = new CartHandler(context);
        }
        return mCartHandler;
    }

    /*First Update the Local Vairable All together
    * and wirte the whole variable ,
    *

    * */
    public boolean addProductToCart(CartModel p ){
       //Firt Chekc whether user have Already Saved some Products


        //First Get the Product in Cart Storage
        mCartProducts = getProducts();


        if (mCartProducts == null){
            Log.d(TAG, "Cart Product is null");
            mCartProducts = new ArrayList<>();
        }

        //Check Whether The Cart Has Already the Same Product
        for (int i = 0; i< mCartProducts.size(); i++){

            CartModel model = mCartProducts.get(i);
            if (p.getPid() == model.getPid()){
                //model Already exists
                Log.d(TAG, "addProductToCart: product alrady Exists so not added");
                return false;
            }

        }

        //No Product Exists

        //Append The Product to Cart
        mCartProducts.add(p);

        //save The new List to Storage
         mDataStore.saveCartList(mCartProducts);
        return true;
    }



    public  void addProductstoCart(List<Product> mList){
            // First Get the Products From Cart
        mCartProducts = getProducts();
        Log.d(TAG, "addProductstoCart: Current List "+mList);
                // check Against Each Product in List

    }


    public  List<CartModel> getProducts(){
        if(mDataStore == null){
            mDataStore = DataStore.getStorageInstance(mContext);
        }
        return mDataStore.getCartProducts();
    }


    public List<Product> getMockProducts(){
        ArrayList<Product> mockList = new ArrayList<>(15);
        for (int i =0;i<15;i++){
            mockList.add(new Product(i,"Product Id "+i,"This is Product Summary",4,"nu",35,"2 Weeks",458,5,false,false,0));
        }
        return mockList;
    }



    /**
     * Chekcs to See Whether the Product is Adlready in Cart or Not
     *
     * {@param p - The product}
     *
     *          Returns True - if Present
     *
     * */

    public boolean isChecked(Product p) {
        mCartProducts = getProducts();
        if (mCartProducts == null){
            return false;
        }
        for (int i = 0; i<mCartProducts.size(); i++){
            CartModel model = mCartProducts.get(i);
            if (p.getPid() == model.getPid()){
                return true;
            }
        }
        return false;
    }


    public void removeProduct(Product p) {

        //First get the Products
        mCartProducts = getProducts();
        if (mCartProducts == null){
            //iF no product present , return
            return;
        }



        for (int i = 0; i< mCartProducts.size(); i++){
            CartModel model = mCartProducts.get(i);
            // same Product Id exists , remove that product;
            if (p.getPid() == model.getPid()){
                 mCartProducts.remove(i);
            }
        }


        //save the Updated List;
        mDataStore.saveCartList(mCartProducts);

    }
}
