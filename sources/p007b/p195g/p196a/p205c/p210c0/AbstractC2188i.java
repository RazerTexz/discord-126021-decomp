package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.i */
/* JADX INFO: compiled from: AnnotatedMember.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2188i extends AbstractC2175b implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: j */
    public final transient InterfaceC2182e0 f4716j;

    /* JADX INFO: renamed from: k */
    public final transient C2195p f4717k;

    public AbstractC2188i(InterfaceC2182e0 interfaceC2182e0, C2195p c2195p) {
        this.f4716j = interfaceC2182e0;
        this.f4717k = c2195p;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: b */
    public final <A extends Annotation> A mo1818b(Class<A> cls) {
        HashMap<Class<?>, Annotation> map;
        C2195p c2195p = this.f4717k;
        if (c2195p == null || (map = c2195p.f4731j) == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    /* JADX INFO: renamed from: f */
    public final void m1902f(boolean z2) {
        Member memberMo1888i = mo1888i();
        if (memberMo1888i != null) {
            C2342d.m2172d(memberMo1888i, z2);
        }
    }

    /* JADX INFO: renamed from: g */
    public abstract Class<?> mo1887g();

    /* JADX INFO: renamed from: h */
    public String mo1903h() {
        return mo1887g().getName() + "#" + mo1819c();
    }

    /* JADX INFO: renamed from: i */
    public abstract Member mo1888i();

    /* JADX INFO: renamed from: j */
    public abstract Object mo1889j(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    /* JADX INFO: renamed from: k */
    public final boolean m1904k(Class<?> cls) {
        HashMap<Class<?>, Annotation> map;
        C2195p c2195p = this.f4717k;
        if (c2195p == null || (map = c2195p.f4731j) == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    /* JADX INFO: renamed from: l */
    public abstract AbstractC2175b mo1890l(C2195p c2195p);
}
