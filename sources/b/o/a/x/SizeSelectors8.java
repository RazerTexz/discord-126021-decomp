package b.o.a.x;

import androidx.annotation.NonNull;
import b.i.a.f.e.o.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.x.k, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors8 implements SizeSelector {
    public SizeSelectors7 a;

    public SizeSelectors8(SizeSelectors7 sizeSelectors7, f.a aVar) {
        this.a = sizeSelectors7;
    }

    @Override // b.o.a.x.SizeSelector
    @NonNull
    public List<Size3> a(@NonNull List<Size3> list) {
        ArrayList arrayList = new ArrayList();
        for (Size3 size3 : list) {
            if (this.a.a(size3)) {
                arrayList.add(size3);
            }
        }
        return arrayList;
    }
}
