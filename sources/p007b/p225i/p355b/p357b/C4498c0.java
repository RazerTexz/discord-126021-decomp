package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.InterfaceC4492l;

/* JADX INFO: renamed from: b.i.b.b.c0 */
/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4498c0<V> implements InterfaceC4492l<List<V>>, Serializable {
    private final int expectedValuesPerKey;

    public C4498c0(int i) {
        C3404f.m4189A(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
    public Object get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
