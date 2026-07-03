package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.g */
/* JADX INFO: compiled from: AnnotatedField.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2185g extends AbstractC2188i implements Serializable {
    private static final long serialVersionUID = 1;
    public a _serialization;

    /* JADX INFO: renamed from: l */
    public final transient Field f4708l;

    /* JADX INFO: renamed from: b.g.a.c.c0.g$a */
    /* JADX INFO: compiled from: AnnotatedField.java */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?> clazz;
        public String name;

        public a(Field field) {
            this.clazz = field.getDeclaringClass();
            this.name = field.getName();
        }
    }

    public C2185g(InterfaceC2182e0 interfaceC2182e0, Field field, C2195p c2195p) {
        super(interfaceC2182e0, c2195p);
        this.f4708l = field;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: c */
    public String mo1819c() {
        return this.f4708l.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: d */
    public Class<?> mo1820d() {
        return this.f4708l.getType();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: e */
    public AbstractC2360j mo1821e() {
        return this.f4716j.mo1831a(this.f4708l.getGenericType());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return C2342d.m2183o(obj, C2185g.class) && ((C2185g) obj).f4708l == this.f4708l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: g */
    public Class<?> mo1887g() {
        return this.f4708l.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public int hashCode() {
        return this.f4708l.getName().hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: i */
    public Member mo1888i() {
        return this.f4708l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: j */
    public Object mo1889j(Object obj) throws IllegalArgumentException {
        try {
            return this.f4708l.get(obj);
        } catch (IllegalAccessException e) {
            StringBuilder sbM833U = C1643a.m833U("Failed to getValue() for field ");
            sbM833U.append(mo1903h());
            sbM833U.append(": ");
            sbM833U.append(e.getMessage());
            throw new IllegalArgumentException(sbM833U.toString(), e);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: l */
    public AbstractC2175b mo1890l(C2195p c2195p) {
        return new C2185g(this.f4716j, this.f4708l, c2195p);
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Field declaredField = cls.getDeclaredField(aVar.name);
            if (!declaredField.isAccessible()) {
                C2342d.m2172d(declaredField, false);
            }
            return new C2185g(null, declaredField, null);
        } catch (Exception unused) {
            StringBuilder sbM833U = C1643a.m833U("Could not find method '");
            sbM833U.append(this._serialization.name);
            sbM833U.append("' from Class '");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[field ");
        sbM833U.append(mo1903h());
        sbM833U.append("]");
        return sbM833U.toString();
    }

    public Object writeReplace() {
        return new C2185g(new a(this.f4708l));
    }

    public C2185g(a aVar) {
        super(null, null);
        this.f4708l = null;
        this._serialization = aVar;
    }
}
