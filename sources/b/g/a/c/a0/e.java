package b.g.a.c.a0;

import b.g.a.c.k;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: DeserializerCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 1;
    public final HashMap<b.g.a.c.j, k<Object>> _incompleteDeserializers = new HashMap<>(8);
    public final b.g.a.c.i0.h<b.g.a.c.j, k<Object>> _cachedDeserializers = new b.g.a.c.i0.h<>(Math.min(64, 500), 2000);

    public Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }
}
