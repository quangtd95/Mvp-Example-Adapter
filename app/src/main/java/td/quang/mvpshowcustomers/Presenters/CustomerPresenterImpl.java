package td.quang.mvpshowcustomers.Presenters;

import java.util.List;

import td.quang.mvpshowcustomers.Customer;
import td.quang.mvpshowcustomers.Interfaces.CustomerInteractor;
import td.quang.mvpshowcustomers.Interfaces.CustomerPresenter;
import td.quang.mvpshowcustomers.Interfaces.CustomerView;
import td.quang.mvpshowcustomers.Interfaces.IAdapter;
import td.quang.mvpshowcustomers.Interfaces.OnLoadFinishedListener;
import td.quang.mvpshowcustomers.Models.CustomerInteractorImpl;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public class CustomerPresenterImpl implements CustomerPresenter, OnLoadFinishedListener {
    private CustomerView customerView;
    private CustomerInteractor customerInteractor;
    private IAdapter adapter;

    public CustomerPresenterImpl(CustomerView customerView, IAdapter adapter) {
        this.customerView = customerView;
        customerInteractor = new CustomerInteractorImpl();
        this.adapter = adapter;
    }

    @Override
    public void loadDatas() {
        customerInteractor.loadDatas(this);
        customerView.showProgressBar();
    }

    @Override
    public void onLoadSuccess(List<Customer> customers) {
        customerView.hideProgressBar();
        adapter.setDatas(customers);
        customerView.refresh();
    }

    @Override
    public void onLoadFail() {
        customerView.hideProgressBar();
        customerView.showDialogFail();
    }
}
