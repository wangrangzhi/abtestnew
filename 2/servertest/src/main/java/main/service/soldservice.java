package main.service;

import main.domain.soldproduct;

public interface soldservice {
    public  int insert(soldproduct record);

    public  soldproduct soldTheproduct(String port,String threadname);

}
