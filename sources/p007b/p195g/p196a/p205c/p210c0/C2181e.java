package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.e */
/* JADX INFO: compiled from: AnnotatedConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2181e extends AbstractC2193n {
    private static final long serialVersionUID = 1;
    public final Constructor<?> _constructor;
    public a _serialization;

    /* JADX INFO: renamed from: b.g.a.c.c0.e$a */
    /* JADX INFO: compiled from: AnnotatedConstructor.java */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?>[] args;
        public Class<?> clazz;

        public a(Constructor<?> constructor) {
            this.clazz = constructor.getDeclaringClass();
            this.args = constructor.getParameterTypes();
        }
    }

    public C2181e(InterfaceC2182e0 interfaceC2182e0, Constructor<?> constructor, C2195p c2195p, C2195p[] c2195pArr) {
        super(interfaceC2182e0, c2195p, c2195pArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this._constructor = constructor;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: c */
    public String mo1819c() {
        return this._constructor.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: d */
    public Class<?> mo1820d() {
        return this._constructor.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: e */
    public AbstractC2360j mo1821e() {
        return this.f4716j.mo1831a(mo1820d());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return C2342d.m2183o(obj, C2181e.class) && ((C2181e) obj)._constructor == this._constructor;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: g */
    public Class<?> mo1887g() {
        return this._constructor.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public int hashCode() {
        return this._constructor.getName().hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: i */
    public Member mo1888i() {
        return this._constructor;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: j */
    public Object mo1889j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbM833U = C1643a.m833U("Cannot call getValue() on constructor of ");
        sbM833U.append(mo1887g().getName());
        throw new UnsupportedOperationException(sbM833U.toString());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: l */
    public AbstractC2175b mo1890l(C2195p c2195p) {
        return new C2181e(this.f4716j, this._constructor, c2195p, this._paramAnnotations);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2193n
    /* JADX INFO: renamed from: n */
    public AbstractC2360j mo1891n(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.f4716j.mo1831a(genericParameterTypes[i]);
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(aVar.args);
            if (!declaredConstructor.isAccessible()) {
                C2342d.m2172d(declaredConstructor, false);
            }
            return new C2181e(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            StringBuilder sbM833U = C1643a.m833U("Could not find constructor with ");
            sbM833U.append(this._serialization.args.length);
            sbM833U.append(" args from Class '");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
    }

    public String toString() {
        int length = this._constructor.getParameterTypes().length;
        Object[] objArr = new Object[4];
        objArr[0] = C2342d.m2189u(this._constructor.getDeclaringClass());
        objArr[1] = Integer.valueOf(length);
        objArr[2] = length == 1 ? "" : "s";
        objArr[3] = this.f4717k;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", objArr);
    }

    public Object writeReplace() {
        return new C2181e(new a(this._constructor));
    }

    public C2181e(a aVar) {
        super(null, null, null);
        this._constructor = null;
        this._serialization = aVar;
    }
}
