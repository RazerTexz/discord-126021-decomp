package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.FieldSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: renamed from: d0.e0.p.d.m0.i.s, reason: use source file name */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SmallSortedMap<FieldDescriptorType> extends SmallSortedMap2<FieldDescriptorType, Object> {
    public SmallSortedMap(int i) {
        super(i, null);
    }

    @Override // d0.e0.p.d.m0.i.SmallSortedMap2
    public void makeImmutable() {
        if (!isImmutable()) {
            for (int i = 0; i < getNumArrayEntries(); i++) {
                Map.Entry<FieldDescriptorType, Object> arrayEntryAt = getArrayEntryAt(i);
                if (((FieldSet.a) arrayEntryAt.getKey()).isRepeated()) {
                    arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : getOverflowEntries()) {
                if (((FieldSet.a) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.makeImmutable();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put((FieldSet.a) obj, obj2);
    }
}
