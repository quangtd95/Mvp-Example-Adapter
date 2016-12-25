package td.quang.mvpshowcustomers.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import td.quang.mvpshowcustomers.Customer;
import td.quang.mvpshowcustomers.Interfaces.IAdapter;
import td.quang.mvpshowcustomers.R;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerHolder> implements IAdapter {
    private List<Customer> customers;

    @Override
    public void setDatas(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void addData(Customer customer) {
        if (customer != null) {
            customers.add(customer);
        }
    }

    @Override
    public void removeData(Customer customer) {
        if (customer != null) {
            customers.remove(customer);
        }
    }

    @Override
    public void removeData(int position) {
        if (position > -1 && position < customers.size()) {
            customers.remove(position);
        }
    }


    @Override
    public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomerHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.tvName.setText(customer.getName());
        holder.tvAge.setText(customer.getAge() + "");
    }

    @Override
    public int getItemCount() {
        return (customers != null) ? customers.size() : 0;
    }


    /*************************/
    static class CustomerHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAge;

        public CustomerHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAge = (TextView) itemView.findViewById(R.id.tvAge);
        }
    }
}
