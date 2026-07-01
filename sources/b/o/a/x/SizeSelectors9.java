package b.o.a.x;

import androidx.annotation.NonNull;
import b.i.a.f.e.o.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.x.l, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors9 implements SizeSelector {
    public SizeSelector[] a;

    public SizeSelectors9(SizeSelector[] sizeSelectorArr, f.a aVar) {
        this.a = sizeSelectorArr;
    }

    @Override // b.o.a.x.SizeSelector
    @NonNull
    public List<Size3> a(@NonNull List<Size3> list) {
        List<Size3> listA = null;
        for (SizeSelector sizeSelector : this.a) {
            listA = sizeSelector.a(list);
            if (!listA.isEmpty()) {
                break;
            }
        }
        return listA == null ? new ArrayList() : listA;
    }
}
