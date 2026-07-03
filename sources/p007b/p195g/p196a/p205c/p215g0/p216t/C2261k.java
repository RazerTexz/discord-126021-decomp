package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.lang.reflect.Method;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p197a.AbstractC2088l0;
import p007b.p195g.p196a.p205c.p210c0.C2174a0;
import p007b.p195g.p196a.p205c.p215g0.C2234c;

/* JADX INFO: renamed from: b.g.a.c.g0.t.k */
/* JADX INFO: compiled from: PropertyBasedObjectIdGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2261k extends AbstractC2088l0 {
    private static final long serialVersionUID = 1;
    public final C2234c _property;

    public C2261k(Class<?> cls, C2234c c2234c) {
        super(cls);
        this._property = c2234c;
    }

    @Override // p007b.p195g.p196a.p197a.AbstractC2084j0, p007b.p195g.p196a.p197a.AbstractC2082i0
    /* JADX INFO: renamed from: a */
    public boolean mo1608a(AbstractC2082i0<?> abstractC2082i0) {
        if (abstractC2082i0.getClass() != C2261k.class) {
            return false;
        }
        C2261k c2261k = (C2261k) abstractC2082i0;
        return c2261k._scope == this._scope && c2261k._property == this._property;
    }

    @Override // p007b.p195g.p196a.p197a.AbstractC2082i0
    /* JADX INFO: renamed from: b */
    public AbstractC2082i0<Object> mo1609b(Class<?> cls) {
        return cls == this._scope ? this : new C2261k(cls, this._property);
    }

    @Override // p007b.p195g.p196a.p197a.AbstractC2082i0
    /* JADX INFO: renamed from: c */
    public Object mo1610c(Object obj) {
        try {
            C2234c c2234c = this._property;
            Method method = c2234c.f4792l;
            return method == null ? c2234c.f4793m.get(obj) : method.invoke(obj, null);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder sbM833U = C1643a.m833U("Problem accessing property '");
            sbM833U.append(this._property._name._value);
            sbM833U.append("': ");
            sbM833U.append(e2.getMessage());
            throw new IllegalStateException(sbM833U.toString(), e2);
        }
    }

    @Override // p007b.p195g.p196a.p197a.AbstractC2082i0
    /* JADX INFO: renamed from: e */
    public AbstractC2082i0<Object> mo1612e(Object obj) {
        return this;
    }

    public C2261k(C2174a0 c2174a0, C2234c c2234c) {
        super(c2174a0.f4631e);
        this._property = c2234c;
    }
}
