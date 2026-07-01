package b.o.a.x;

import androidx.annotation.NonNull;
import b.i.a.f.e.o.f$a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements c {
    public c[] a;

    public l(c[] cVarArr, f$a f_a) {
        this.a = cVarArr;
    }

    @Override // b.o.a.x.c
    @NonNull
    public List<b> a(@NonNull List<b> list) {
        List<b> listA = null;
        for (c cVar : this.a) {
            listA = cVar.a(list);
            if (!listA.isEmpty()) {
                break;
            }
        }
        return listA == null ? new ArrayList() : listA;
    }
}
