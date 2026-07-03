package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: renamed from: b.i.a.f.h.l.t6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3840t6<FieldDescriptorType> extends C3814r6<FieldDescriptorType, Object> {
    public C3840t6(int i) {
        super(i, null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3814r6
    /* JADX INFO: renamed from: c */
    public final void mo5205c() {
        if (!this.f10292n) {
            for (int i = 0; i < m5207e(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryM5206d = m5206d(i);
                if (((InterfaceC3786p4) entryM5206d.getKey()).mo5178d()) {
                    entryM5206d.setValue(Collections.unmodifiableList((List) entryM5206d.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : m5209g()) {
                if (((InterfaceC3786p4) entry.getKey()).mo5178d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo5205c();
    }
}
