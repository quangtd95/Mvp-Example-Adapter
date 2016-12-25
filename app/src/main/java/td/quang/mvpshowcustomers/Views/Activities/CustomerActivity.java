package td.quang.mvpshowcustomers.Views.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import td.quang.mvpshowcustomers.Adapters.CustomerAdapter;
import td.quang.mvpshowcustomers.Interfaces.CustomerPresenter;
import td.quang.mvpshowcustomers.Interfaces.CustomerView;
import td.quang.mvpshowcustomers.Presenters.CustomerPresenterImpl;
import td.quang.mvpshowcustomers.R;

public class CustomerActivity extends AppCompatActivity implements CustomerView {
    private RecyclerView rvCustomers;
    private ProgressBar progressBar;
    private CustomerAdapter adapter;
    private CustomerPresenter customerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addComponents();

        adapter = new CustomerAdapter();
        rvCustomers.setAdapter(adapter);

        customerPresenter = new CustomerPresenterImpl(this, adapter);
        customerPresenter.loadDatas();

    }

    private void addComponents() {
        rvCustomers = (RecyclerView) findViewById(R.id.rvCustomers);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        rvCustomers.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void refresh() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDialogFail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Load không thành công");
        AlertDialog alertDialog = builder.create();
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", (dialog, which) -> {
            alertDialog.dismiss();
            startActivity(new Intent(CustomerActivity.this, CustomerActivity.class));
            finish();
        });
        alertDialog.show();
    }
}
