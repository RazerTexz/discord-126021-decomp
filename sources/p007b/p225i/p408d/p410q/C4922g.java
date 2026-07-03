package p007b.p225i.p408d.p410q;

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
import p007b.p225i.p408d.InterfaceC4902f;
import p007b.p225i.p408d.p410q.p413y.AbstractC4944b;

/* JADX INFO: renamed from: b.i.d.q.g */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4922g {

    /* JADX INFO: renamed from: a */
    public final Map<Type, InterfaceC4902f<?>> f13115a;

    /* JADX INFO: renamed from: b */
    public final AbstractC4944b f13116b = AbstractC4944b.f13148a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.i.d.q.g$a */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    public class a<T> implements InterfaceC4933r<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ InterfaceC4902f f13117a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Type f13118b;

        public a(C4922g c4922g, InterfaceC4902f interfaceC4902f, Type type) {
            this.f13117a = interfaceC4902f;
            this.f13118b = type;
        }

        @Override // p007b.p225i.p408d.p410q.InterfaceC4933r
        /* JADX INFO: renamed from: a */
        public T mo6869a() {
            return (T) this.f13117a.m6853a(this.f13118b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.i.d.q.g$b */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    public class b<T> implements InterfaceC4933r<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ InterfaceC4902f f13119a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Type f13120b;

        public b(C4922g c4922g, InterfaceC4902f interfaceC4902f, Type type) {
            this.f13119a = interfaceC4902f;
            this.f13120b = type;
        }

        @Override // p007b.p225i.p408d.p410q.InterfaceC4933r
        /* JADX INFO: renamed from: a */
        public T mo6869a() {
            return (T) this.f13119a.m6853a(this.f13120b);
        }
    }

    public C4922g(Map<Type, InterfaceC4902f<?>> map) {
        this.f13115a = map;
    }

    /* JADX INFO: renamed from: a */
    public <T> InterfaceC4933r<T> m6870a(TypeToken<T> typeToken) {
        C4923h c4923h;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InterfaceC4902f<?> interfaceC4902f = this.f13115a.get(type);
        if (interfaceC4902f != null) {
            return new a(this, interfaceC4902f, type);
        }
        InterfaceC4902f<?> interfaceC4902f2 = this.f13115a.get(rawType);
        if (interfaceC4902f2 != null) {
            return new b(this, interfaceC4902f2, type);
        }
        InterfaceC4933r<T> c4920e = null;
        try {
            Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f13116b.mo6912a(declaredConstructor);
            }
            c4923h = new C4923h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            c4923h = null;
        }
        if (c4923h != null) {
            return c4923h;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                c4920e = new C4924i<>(this);
            } else if (EnumSet.class.isAssignableFrom(rawType)) {
                c4920e = new C4925j<>(this, type);
            } else if (Set.class.isAssignableFrom(rawType)) {
                c4920e = new C4926k<>(this);
            } else {
                c4920e = Queue.class.isAssignableFrom(rawType) ? new C4927l<>(this) : new C4928m<>(this);
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                c4920e = new C4929n<>(this);
            } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                c4920e = new C4917b<>(this);
            } else if (SortedMap.class.isAssignableFrom(rawType)) {
                c4920e = new C4918c<>(this);
            } else {
                c4920e = (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new C4920e<>(this) : new C4919d<>(this);
            }
        }
        return c4920e != null ? c4920e : new C4921f(this, rawType, type);
    }

    public String toString() {
        return this.f13115a.toString();
    }
}
