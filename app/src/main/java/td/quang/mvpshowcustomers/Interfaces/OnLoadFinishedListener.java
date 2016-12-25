package td.quang.mvpshowcustomers.Interfaces;

import java.util.List;

import td.quang.mvpshowcustomers.Customer;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public interface OnLoadFinishedListener {
    void onLoadSuccess(List<Customer> customers);

    void onLoadFail();
}
