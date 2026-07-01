package b.i.b.b;

import b.i.b.a.Supplier2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.b.b.c0, reason: use source file name */
/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MultimapBuilder<V> implements Supplier2<List<V>>, Serializable {
    private final int expectedValuesPerKey;

    public MultimapBuilder(int i) {
        b.i.a.f.e.o.f.A(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    @Override // b.i.b.a.Supplier2
    public Object get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
