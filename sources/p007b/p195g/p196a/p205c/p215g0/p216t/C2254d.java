package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p215g0.C2234c;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.g0.t.d */
/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2254d extends C2234c implements Serializable {
    private static final long serialVersionUID = 1;
    public final C2234c _delegate;
    public final Class<?>[] _views;

    public C2254d(C2234c c2234c, Class<?>[] clsArr) {
        super(c2234c, c2234c._name);
        this._delegate = c2234c;
        this._views = clsArr;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: e */
    public void mo1979e(AbstractC2364n<Object> abstractC2364n) {
        this._delegate.mo1979e(abstractC2364n);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: f */
    public void mo1980f(AbstractC2364n<Object> abstractC2364n) {
        this._delegate.mo1980f(abstractC2364n);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: g */
    public C2234c mo1981g(AbstractC2352n abstractC2352n) {
        return new C2254d(this._delegate.mo1981g(abstractC2352n), this._views);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: h */
    public void mo1982h(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        if (m2020j(abstractC2374x._serializationView)) {
            this._delegate.mo1982h(obj, abstractC2108d, abstractC2374x);
            return;
        }
        AbstractC2364n<Object> abstractC2364n = this._delegate._nullSerializer;
        if (abstractC2364n != null) {
            abstractC2364n.mo1807f(null, abstractC2108d, abstractC2374x);
        } else {
            abstractC2108d.mo1631A();
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: i */
    public void mo1983i(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        if (m2020j(abstractC2374x._serializationView)) {
            this._delegate.mo1983i(obj, abstractC2108d, abstractC2374x);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(abstractC2108d);
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m2020j(Class<?> cls) {
        if (cls == null) {
            return true;
        }
        int length = this._views.length;
        for (int i = 0; i < length; i++) {
            if (this._views[i].isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}
