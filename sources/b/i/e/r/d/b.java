package b.i.e.r.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: BarcodeValue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final Map<Integer, Integer> a = new HashMap();

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map$Entry<Integer, Integer> map$Entry : this.a.entrySet()) {
            if (map$Entry.getValue().intValue() > iIntValue) {
                iIntValue = map$Entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(map$Entry.getKey());
            } else if (map$Entry.getValue().intValue() == iIntValue) {
                arrayList.add(map$Entry.getKey());
            }
        }
        return b.i.e.r.a.b(arrayList);
    }

    public void b(int i) {
        Integer num = this.a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
