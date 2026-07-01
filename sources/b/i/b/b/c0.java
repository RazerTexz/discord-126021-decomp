package b.i.b.b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0<V> implements b.i.b.a.l<List<V>>, Serializable {
    private final int expectedValuesPerKey;

    public c0(int i) {
        b.i.a.f.e.o.f.A(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    @Override // b.i.b.a.l
    public Object get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
