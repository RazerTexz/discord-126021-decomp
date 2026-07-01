package b.g.a.c.g0.t;

import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.i0.TypeKey;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.g0.t.m, reason: use source file name */
/* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReadOnlyClassToSerializerMap {
    public final a[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f711b;

    /* JADX INFO: renamed from: b.g.a.c.g0.t.m$a */
    /* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
    public static final class a {
        public final JsonSerializer<Object> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f712b;
        public final Class<?> c;
        public final JavaType d;
        public final boolean e;

        public a(a aVar, TypeKey typeKey, JsonSerializer<Object> jsonSerializer) {
            this.f712b = aVar;
            this.a = jsonSerializer;
            this.e = typeKey.d;
            this.c = typeKey.f730b;
            this.d = typeKey.c;
        }
    }

    public ReadOnlyClassToSerializerMap(Map<TypeKey, JsonSerializer<Object>> map) {
        int size = map.size();
        int i = 8;
        while (i < (size <= 64 ? size + size : size + (size >> 2))) {
            i += i;
        }
        this.f711b = i - 1;
        a[] aVarArr = new a[i];
        for (Map.Entry<TypeKey, JsonSerializer<Object>> entry : map.entrySet()) {
            TypeKey key = entry.getKey();
            int i2 = key.a & this.f711b;
            aVarArr[i2] = new a(aVarArr[i2], key, entry.getValue());
        }
        this.a = aVarArr;
    }

    public JsonSerializer<Object> a(JavaType javaType) {
        a aVar = this.a[(javaType._hash - 1) & this.f711b];
        if (aVar == null) {
            return null;
        }
        if (!aVar.e && javaType.equals(aVar.d)) {
            return aVar.a;
        }
        do {
            aVar = aVar.f712b;
            if (aVar == null) {
                return null;
            }
        } while (!(!aVar.e && javaType.equals(aVar.d)));
        return aVar.a;
    }

    public JsonSerializer<Object> b(Class<?> cls) {
        a aVar = this.a[cls.getName().hashCode() & this.f711b];
        if (aVar == null) {
            return null;
        }
        if (aVar.c == cls && !aVar.e) {
            return aVar.a;
        }
        do {
            aVar = aVar.f712b;
            if (aVar == null) {
                return null;
            }
        } while (!(aVar.c == cls && !aVar.e));
        return aVar.a;
    }
}
