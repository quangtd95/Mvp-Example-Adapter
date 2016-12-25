package td.quang.mvpshowcustomers.Models;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Random;

import td.quang.mvpshowcustomers.Customer;
import td.quang.mvpshowcustomers.Interfaces.CustomerInteractor;
import td.quang.mvpshowcustomers.Interfaces.OnLoadFinishedListener;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public class CustomerInteractorImpl implements CustomerInteractor {

    private static String generateRandomString(Random random, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    @Override
    public void loadDatas(OnLoadFinishedListener listener) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            boolean r = new Random().nextBoolean();
            if (r) {
                ArrayList<Customer> customers = new ArrayList<>();
                Random random = new Random();
                for (int i = 0; i < 100; i++) {
                    Customer customer = new Customer();
                    customer.setName(generateRandomString(random, new Random().nextInt(20) + 10));
                    customer.setAge(new Random().nextInt(99) + 1);
                    customers.add(customer);
                }
                listener.onLoadSuccess(customers);
            } else {
                listener.onLoadFail();
            }

        }, 2000);
    }
}
