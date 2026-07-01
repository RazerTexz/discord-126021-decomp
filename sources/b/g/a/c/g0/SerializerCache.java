package b.g.a.c.g0;

import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.g0.t.ReadOnlyClassToSerializerMap;
import b.g.a.c.i0.TypeKey;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.c.g0.p, reason: use source file name */
/* JADX INFO: compiled from: SerializerCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SerializerCache {
    public final HashMap<TypeKey, JsonSerializer<Object>> a = new HashMap<>(64);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<ReadOnlyClassToSerializerMap> f703b = new AtomicReference<>();

    public JsonSerializer<Object> a(JavaType javaType) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = this.a.get(new TypeKey(javaType, false));
        }
        return jsonSerializer;
    }

    public JsonSerializer<Object> b(Class<?> cls) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = this.a.get(new TypeKey(cls, false));
        }
        return jsonSerializer;
    }
}
