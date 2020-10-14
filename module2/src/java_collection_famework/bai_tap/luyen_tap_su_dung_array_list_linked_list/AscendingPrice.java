package java_collection_famework.bai_tap.luyen_tap_su_dung_array_list_linked_list;

import java.util.Comparator;

public class AscendingPrice implements Comparator<Product> {
    @Override
    public int compare(Product s1, Product s2) {
        if (s1.getPrice() > s2.getPrice()) {
            return 1;
        } else if (s1.getPrice() == s2.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }
}

