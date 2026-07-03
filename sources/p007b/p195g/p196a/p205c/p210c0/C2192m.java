package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Member;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.m */
/* JADX INFO: compiled from: AnnotatedParameter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2192m extends AbstractC2188i {
    private static final long serialVersionUID = 1;
    public final int _index;
    public final AbstractC2193n _owner;
    public final AbstractC2360j _type;

    public C2192m(AbstractC2193n abstractC2193n, AbstractC2360j abstractC2360j, InterfaceC2182e0 interfaceC2182e0, C2195p c2195p, int i) {
        super(interfaceC2182e0, c2195p);
        this._owner = abstractC2193n;
        this._type = abstractC2360j;
        this._index = i;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: c */
    public String mo1819c() {
        return "";
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
        if (!C2342d.m2183o(obj, C2192m.class)) {
            return false;
        }
        C2192m c2192m = (C2192m) obj;
        return c2192m._owner.equals(this._owner) && c2192m._index == this._index;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: g */
    public Class<?> mo1887g() {
        return this._owner.mo1887g();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: i */
    public Member mo1888i() {
        return this._owner.mo1888i();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: j */
    public Object mo1889j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbM833U = C1643a.m833U("Cannot call getValue() on constructor parameter of ");
        sbM833U.append(mo1887g().getName());
        throw new UnsupportedOperationException(sbM833U.toString());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2188i
    /* JADX INFO: renamed from: l */
    public AbstractC2175b mo1890l(C2195p c2195p) {
        if (c2195p == this.f4717k) {
            return this;
        }
        AbstractC2193n abstractC2193n = this._owner;
        int i = this._index;
        abstractC2193n._paramAnnotations[i] = c2195p;
        return abstractC2193n.m1910m(i);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[parameter #");
        sbM833U.append(this._index);
        sbM833U.append(", annotations: ");
        sbM833U.append(this.f4717k);
        sbM833U.append("]");
        return sbM833U.toString();
    }
}
