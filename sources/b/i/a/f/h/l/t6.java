package b.i.a.f.h.l;

import java.util.Collections;
import java.util.List;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t6<FieldDescriptorType> extends r6<FieldDescriptorType, Object> {
    public t6(int i) {
        super(i, null);
    }

    @Override // b.i.a.f.h.l.r6
    public final void c() {
        if (!this.n) {
            for (int i = 0; i < e(); i++) {
                Map$Entry<FieldDescriptorType, Object> map$EntryD = d(i);
                if (((p4) map$EntryD.getKey()).d()) {
                    map$EntryD.setValue(Collections.unmodifiableList((List) map$EntryD.getValue()));
                }
            }
            for (Map$Entry<FieldDescriptorType, Object> map$Entry : g()) {
                if (((p4) map$Entry.getKey()).d()) {
                    map$Entry.setValue(Collections.unmodifiableList((List) map$Entry.getValue()));
                }
            }
        }
        super.c();
    }
}
