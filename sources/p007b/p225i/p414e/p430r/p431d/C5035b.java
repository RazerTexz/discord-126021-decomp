package p007b.p225i.p414e.p430r.p431d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p414e.p430r.C5031a;

/* JADX INFO: renamed from: b.i.e.r.d.b */
/* JADX INFO: compiled from: BarcodeValue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5035b {

    /* JADX INFO: renamed from: a */
    public final Map<Integer, Integer> f13469a = new HashMap();

    /* JADX INFO: renamed from: a */
    public int[] m7048a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f13469a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return C5031a.m7045b(arrayList);
    }

    /* JADX INFO: renamed from: b */
    public void m7049b(int i) {
        Integer num = this.f13469a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f13469a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
