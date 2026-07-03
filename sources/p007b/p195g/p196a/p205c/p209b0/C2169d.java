package p007b.p195g.p196a.p205c.p209b0;

import java.beans.ConstructorProperties;
import java.beans.Transient;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2193n;
import p007b.p195g.p196a.p205c.p210c0.C2192m;

/* JADX INFO: renamed from: b.g.a.c.b0.d */
/* JADX INFO: compiled from: Java7SupportImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2169d extends AbstractC2168c {
    @Override // p007b.p195g.p196a.p205c.p209b0.AbstractC2168c
    /* JADX INFO: renamed from: a */
    public C2370t mo1804a(C2192m c2192m) {
        ConstructorProperties constructorPropertiesMo1818b;
        AbstractC2193n abstractC2193n = c2192m._owner;
        if (abstractC2193n == null || (constructorPropertiesMo1818b = abstractC2193n.mo1818b(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] strArrValue = constructorPropertiesMo1818b.value();
        int i = c2192m._index;
        if (i < strArrValue.length) {
            return C2370t.m2227a(strArrValue[i]);
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p209b0.AbstractC2168c
    /* JADX INFO: renamed from: b */
    public Boolean mo1805b(AbstractC2175b abstractC2175b) {
        Transient transientMo1818b = abstractC2175b.mo1818b(Transient.class);
        if (transientMo1818b != null) {
            return Boolean.valueOf(transientMo1818b.value());
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p209b0.AbstractC2168c
    /* JADX INFO: renamed from: c */
    public Boolean mo1806c(AbstractC2175b abstractC2175b) {
        if (abstractC2175b.mo1818b(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }
}
