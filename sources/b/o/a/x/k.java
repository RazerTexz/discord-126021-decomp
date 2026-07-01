package b.o.a.x;

import androidx.annotation.NonNull;
import b.i.a.f.e.o.f$a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements c {
    public j a;

    public k(j jVar, f$a f_a) {
        this.a = jVar;
    }

    @Override // b.o.a.x.c
    @NonNull
    public List<b> a(@NonNull List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (this.a.a(bVar)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
