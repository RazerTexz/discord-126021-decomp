package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.Member;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.f0 */
/* JADX INFO: compiled from: VirtualAnnotatedMember.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2184f0 extends AbstractC2188i implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _declaringClass;
    public final String _name;
    public final AbstractC2360j _type;

    public C2184f0(InterfaceC2182e0 interfaceC2182e0, Class<?> cls, String str, AbstractC2360j abstractC2360j) {
        super(interfaceC2182e0, null);
        this._declaringClass = cls;
        this._type = abstractC2360j;
        this._name = str;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: c */
    public String mo1819c() {
        return this._name;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: d */
    public Class<?> mo1820d() {
        return this._type._class;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: e */
    public AbstractC2360j mo1821e() {
        return this._type;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!C2342d.m2183o(obj, C2184f0.class)) {
            return false;
        }
        C2184f0 c2184f0 = (C2184f0) obj;
        return c2184f0._declaringClass == this._declaringClass && c2184f0._name.equals(this._name);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: g */
    public Class<?> mo1887g() {
        return this._declaringClass;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public int hashCode() {
        return this._name.hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: i */
    public Member mo1888i() {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: j */
    public Object mo1889j(Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException(C1643a.m822J(C1643a.m833U("Cannot get virtual property '"), this._name, "'"));
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: l */
    public AbstractC2175b mo1890l(C2195p c2195p) {
        return this;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[virtual ");
        sbM833U.append(mo1903h());
        sbM833U.append("]");
        return sbM833U.toString();
    }
}
