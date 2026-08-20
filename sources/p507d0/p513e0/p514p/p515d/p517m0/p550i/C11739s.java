package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: renamed from: d0.e0.p.d.m0.i.s */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11739s<FieldDescriptorType> extends C11740t<FieldDescriptorType, Object> {
    public C11739s(int i) {
        super(i, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11740t
    public void makeImmutable() {
        if (!isImmutable()) {
            for (int i = 0; i < getNumArrayEntries(); i++) {
                Map.Entry<FieldDescriptorType, Object> arrayEntryAt = getArrayEntryAt(i);
                if (((C11726f.a) arrayEntryAt.getKey()).isRepeated()) {
                    arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : getOverflowEntries()) {
                if (((C11726f.a) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.makeImmutable();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put((C11726f.a) obj, obj2);
    }
}
