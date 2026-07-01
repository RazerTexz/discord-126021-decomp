package b.i.a.f.h.l;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
                Map.Entry<FieldDescriptorType, Object> entryD = d(i);
                if (((p4) entryD.getKey()).d()) {
                    entryD.setValue(Collections.unmodifiableList((List) entryD.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : g()) {
                if (((p4) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.c();
    }
}
