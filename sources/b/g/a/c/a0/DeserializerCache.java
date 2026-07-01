package b.g.a.c.a0;

import b.g.a.c.JavaType;
import b.g.a.c.JsonDeserializer;
import b.g.a.c.i0.LRUMap;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: renamed from: b.g.a.c.a0.e, reason: use source file name */
/* JADX INFO: compiled from: DeserializerCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializerCache implements Serializable {
    private static final long serialVersionUID = 1;
    public final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap<>(8);
    public final LRUMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new LRUMap<>(Math.min(64, 500), 2000);

    public Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }
}
