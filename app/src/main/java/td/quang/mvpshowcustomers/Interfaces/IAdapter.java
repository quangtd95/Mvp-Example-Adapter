package td.quang.mvpshowcustomers.Interfaces;

import java.util.List;

import td.quang.mvpshowcustomers.Customer;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public interface IAdapter {
    void setDatas(List<Customer> datas);

    void addData(Customer customer);

    void removeData(Customer customer);

    void removeData(int position);
}
