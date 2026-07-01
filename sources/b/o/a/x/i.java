package b.o.a.x;

import androidx.annotation.NonNull;
import b.i.a.f.e.o.f$a;
import java.util.List;

/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements c {
    public c[] a;

    public i(c[] cVarArr, f$a f_a) {
        this.a = cVarArr;
    }

    @Override // b.o.a.x.c
    @NonNull
    public List<b> a(@NonNull List<b> list) {
        for (c cVar : this.a) {
            list = cVar.a(list);
        }
        return list;
    }
}
