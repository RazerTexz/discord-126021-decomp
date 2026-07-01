package d0.e0.p.d.m0.i;

import java.util.Collections;
import java.util.List;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s<FieldDescriptorType> extends t<FieldDescriptorType, Object> {
    public s(int i) {
        super(i, null);
    }

    @Override // d0.e0.p.d.m0.i.t
    public void makeImmutable() {
        if (!isImmutable()) {
            for (int i = 0; i < getNumArrayEntries(); i++) {
                Map$Entry<FieldDescriptorType, Object> arrayEntryAt = getArrayEntryAt(i);
                if (((f$a) arrayEntryAt.getKey()).isRepeated()) {
                    arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                }
            }
            for (Map$Entry<FieldDescriptorType, Object> map$Entry : getOverflowEntries()) {
                if (((f$a) map$Entry.getKey()).isRepeated()) {
                    map$Entry.setValue(Collections.unmodifiableList((List) map$Entry.getValue()));
                }
            }
        }
        super.makeImmutable();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put((f$a) obj, obj2);
    }
}
