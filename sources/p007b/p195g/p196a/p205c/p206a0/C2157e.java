package p007b.p195g.p196a.p205c.p206a0;

import java.io.Serializable;
import java.util.HashMap;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2361k;
import p007b.p195g.p196a.p205c.p219i0.C2346h;

/* JADX INFO: renamed from: b.g.a.c.a0.e */
/* JADX INFO: compiled from: DeserializerCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2157e implements Serializable {
    private static final long serialVersionUID = 1;
    public final HashMap<AbstractC2360j, AbstractC2361k<Object>> _incompleteDeserializers = new HashMap<>(8);
    public final C2346h<AbstractC2360j, AbstractC2361k<Object>> _cachedDeserializers = new C2346h<>(Math.min(64, 500), 2000);

    public Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }
}
