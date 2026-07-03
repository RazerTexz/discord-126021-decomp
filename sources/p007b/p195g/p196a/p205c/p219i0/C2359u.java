package p007b.p195g.p196a.p205c.p219i0;

import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.i0.u */
/* JADX INFO: compiled from: TypeKey.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2359u {

    /* JADX INFO: renamed from: a */
    public int f4987a;

    /* JADX INFO: renamed from: b */
    public Class<?> f4988b;

    /* JADX INFO: renamed from: c */
    public AbstractC2360j f4989c;

    /* JADX INFO: renamed from: d */
    public boolean f4990d;

    public C2359u() {
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != C2359u.class) {
            return false;
        }
        C2359u c2359u = (C2359u) obj;
        if (c2359u.f4990d != this.f4990d) {
            return false;
        }
        Class<?> cls = this.f4988b;
        if (cls != null) {
            return c2359u.f4988b == cls;
        }
        return this.f4989c.equals(c2359u.f4989c);
    }

    public final int hashCode() {
        return this.f4987a;
    }

    public final String toString() {
        if (this.f4988b != null) {
            StringBuilder sbM833U = C1643a.m833U("{class: ");
            C1643a.m860k0(this.f4988b, sbM833U, ", typed? ");
            return C1643a.m827O(sbM833U, this.f4990d, "}");
        }
        StringBuilder sbM833U2 = C1643a.m833U("{type: ");
        sbM833U2.append(this.f4989c);
        sbM833U2.append(", typed? ");
        return C1643a.m827O(sbM833U2, this.f4990d, "}");
    }

    public C2359u(Class<?> cls, boolean z2) {
        this.f4988b = cls;
        this.f4989c = null;
        this.f4990d = z2;
        this.f4987a = z2 ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public C2359u(AbstractC2360j abstractC2360j, boolean z2) {
        int i;
        this.f4989c = abstractC2360j;
        this.f4988b = null;
        this.f4990d = z2;
        if (z2) {
            i = abstractC2360j._hash - 2;
        } else {
            i = abstractC2360j._hash - 1;
        }
        this.f4987a = i;
    }
}
