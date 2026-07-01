package b.f.j.h;

import b.f.j.j.h;
import b.f.j.j.i;
import java.util.List;

/* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    public final f$c a = new f$b(null);

    @Override // b.f.j.h.d
    public i a(int i) {
        return new h(i, i >= this.a.b(), false);
    }

    @Override // b.f.j.h.d
    public int b(int i) {
        List<Integer> listA = this.a.a();
        if (listA == null || listA.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            if (listA.get(i2).intValue() > i) {
                return listA.get(i2).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }
}
