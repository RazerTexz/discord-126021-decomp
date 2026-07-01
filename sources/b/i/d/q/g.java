package b.i.d.q;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final Map<Type, b.i.d.f<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.d.q.y.b f1808b = b.i.d.q.y.b.a;

    public g(Map<Type, b.i.d.f<?>> map) {
        this.a = map;
    }

    public <T> r<T> a(TypeToken<T> typeToken) {
        h hVar;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        b.i.d.f<?> fVar = this.a.get(type);
        if (fVar != null) {
            return new g$a(this, fVar, type);
        }
        b.i.d.f<?> fVar2 = this.a.get(rawType);
        if (fVar2 != null) {
            return new g$b(this, fVar2, type);
        }
        r<T> eVar = null;
        try {
            Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f1808b.a(declaredConstructor);
            }
            hVar = new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            hVar = null;
        }
        if (hVar != null) {
            return hVar;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                eVar = new i<>(this);
            } else if (EnumSet.class.isAssignableFrom(rawType)) {
                eVar = new j<>(this, type);
            } else if (Set.class.isAssignableFrom(rawType)) {
                eVar = new k<>(this);
            } else {
                eVar = Queue.class.isAssignableFrom(rawType) ? new l<>(this) : new m<>(this);
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                eVar = new n<>(this);
            } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                eVar = new b<>(this);
            } else if (SortedMap.class.isAssignableFrom(rawType)) {
                eVar = new c<>(this);
            } else {
                eVar = (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new e<>(this) : new d<>(this);
            }
        }
        return eVar != null ? eVar : new f(this, rawType, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
