package b.f.g.a.a.h;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ForwardingImageOriginListener.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public final List<b> a;

    public a(b... bVarArr) {
        ArrayList arrayList = new ArrayList(bVarArr.length);
        this.a = arrayList;
        Collections.addAll(arrayList, bVarArr);
    }

    @Override // b.f.g.a.a.h.b
    public synchronized void a(String str, int i, boolean z2, String str2) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.a.get(i2);
            if (bVar != null) {
                try {
                    bVar.a(str, i, z2, str2);
                } catch (Exception e) {
                    b.f.d.e.a.f("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
                }
            }
        }
    }
}
