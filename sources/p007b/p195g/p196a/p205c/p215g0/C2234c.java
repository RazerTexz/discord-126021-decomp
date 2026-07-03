package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.p200p.C2130j;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.C2369s;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p210c0.C2185g;
import p007b.p195g.p196a.p205c.p210c0.C2189j;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.c */
/* JADX INFO: compiled from: BeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2234c extends AbstractC2245n implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f4790j = 0;
    private static final long serialVersionUID = 1;
    public final AbstractC2360j _cfgSerializationType;
    public final AbstractC2360j _declaredType;
    public final Class<?>[] _includeInViews;
    public final AbstractC2188i _member;
    public final C2130j _name;
    public AbstractC2360j _nonTrivialBaseType;
    public AbstractC2364n<Object> _nullSerializer;
    public AbstractC2364n<Object> _serializer;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public AbstractC2215g _typeSerializer;
    public final C2370t _wrapperName;

    /* JADX INFO: renamed from: k */
    public final transient InterfaceC2339a f4791k;

    /* JADX INFO: renamed from: l */
    public transient Method f4792l;

    /* JADX INFO: renamed from: m */
    public transient Field f4793m;

    /* JADX INFO: renamed from: n */
    public transient AbstractC2262l f4794n;

    /* JADX INFO: renamed from: o */
    public transient HashMap<Object, Object> f4795o;

    public C2234c(AbstractC2198s abstractC2198s, AbstractC2188i abstractC2188i, InterfaceC2339a interfaceC2339a, AbstractC2360j abstractC2360j, AbstractC2364n<?> abstractC2364n, AbstractC2215g abstractC2215g, AbstractC2360j abstractC2360j2, boolean z2, Object obj, Class<?>[] clsArr) {
        super(abstractC2198s);
        this._member = abstractC2188i;
        this.f4791k = interfaceC2339a;
        this._name = new C2130j(abstractC2198s.mo1858p());
        this._wrapperName = abstractC2198s.mo1862t();
        this._declaredType = abstractC2360j;
        this._serializer = abstractC2364n;
        this.f4794n = abstractC2364n == null ? AbstractC2262l.b.f4828b : null;
        this._typeSerializer = abstractC2215g;
        this._cfgSerializationType = abstractC2360j2;
        if (abstractC2188i instanceof C2185g) {
            this.f4792l = null;
            this.f4793m = (Field) abstractC2188i.mo1888i();
        } else if (abstractC2188i instanceof C2189j) {
            this.f4792l = (Method) abstractC2188i.mo1888i();
            this.f4793m = null;
        } else {
            this.f4792l = null;
            this.f4793m = null;
        }
        this._suppressNulls = z2;
        this._suppressableValue = obj;
        this._nullSerializer = null;
        this._includeInViews = clsArr;
    }

    /* JADX INFO: renamed from: c */
    public AbstractC2364n<Object> mo1977c(AbstractC2262l abstractC2262l, Class<?> cls, AbstractC2374x abstractC2374x) throws JsonMappingException {
        AbstractC2262l.d dVar;
        AbstractC2360j abstractC2360j = this._nonTrivialBaseType;
        if (abstractC2360j != null) {
            AbstractC2360j abstractC2360jM2247k = abstractC2374x.m2247k(abstractC2360j, cls);
            AbstractC2364n<Object> abstractC2364nM2252q = abstractC2374x.m2252q(abstractC2360jM2247k, this);
            dVar = new AbstractC2262l.d(abstractC2364nM2252q, abstractC2262l.mo2033b(abstractC2360jM2247k._class, abstractC2364nM2252q));
        } else {
            AbstractC2364n<Object> abstractC2364nM2253r = abstractC2374x.m2253r(cls, this);
            dVar = new AbstractC2262l.d(abstractC2364nM2253r, abstractC2262l.mo2033b(cls, abstractC2364nM2253r));
        }
        AbstractC2262l abstractC2262l2 = dVar.f4831b;
        if (abstractC2262l != abstractC2262l2) {
            this.f4794n = abstractC2262l2;
        }
        return dVar.f4830a;
    }

    /* JADX INFO: renamed from: d */
    public boolean m1978d(AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2364n abstractC2364n) throws IOException {
        if (abstractC2364n.mo2052i()) {
            return false;
        }
        if (abstractC2374x.m2240D(EnumC2373w.FAIL_ON_SELF_REFERENCES)) {
            if (!(abstractC2364n instanceof AbstractC2278d)) {
                return false;
            }
            abstractC2374x.mo1942f(this._declaredType, "Direct self-reference leading to cycle");
            throw null;
        }
        if (!abstractC2374x.m2240D(EnumC2373w.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this._nullSerializer == null) {
            return true;
        }
        if (!abstractC2108d.mo1650c().m1674b()) {
            abstractC2108d.mo1665x(this._name);
        }
        this._nullSerializer.mo1807f(null, abstractC2108d, abstractC2374x);
        return true;
    }

    /* JADX INFO: renamed from: e */
    public void mo1979e(AbstractC2364n<Object> abstractC2364n) {
        AbstractC2364n<Object> abstractC2364n2 = this._nullSerializer;
        if (abstractC2364n2 != null && abstractC2364n2 != abstractC2364n) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", C2342d.m2173e(this._nullSerializer), C2342d.m2173e(abstractC2364n)));
        }
        this._nullSerializer = abstractC2364n;
    }

    /* JADX INFO: renamed from: f */
    public void mo1980f(AbstractC2364n<Object> abstractC2364n) {
        AbstractC2364n<Object> abstractC2364n2 = this._serializer;
        if (abstractC2364n2 != null && abstractC2364n2 != abstractC2364n) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", C2342d.m2173e(this._serializer), C2342d.m2173e(abstractC2364n)));
        }
        this._serializer = abstractC2364n;
    }

    /* JADX INFO: renamed from: g */
    public C2234c mo1981g(AbstractC2352n abstractC2352n) {
        String strMo2202a = abstractC2352n.mo2202a(this._name._value);
        return strMo2202a.equals(this._name._value) ? this : new C2234c(this, C2370t.m2227a(strMo2202a));
    }

    @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
    public AbstractC2188i getMember() {
        return this._member;
    }

    @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
    public AbstractC2360j getType() {
        return this._declaredType;
    }

    /* JADX INFO: renamed from: h */
    public void mo1982h(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        Method method = this.f4792l;
        Object objInvoke = method == null ? this.f4793m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            AbstractC2364n<Object> abstractC2364n = this._nullSerializer;
            if (abstractC2364n != null) {
                abstractC2364n.mo1807f(null, abstractC2108d, abstractC2374x);
                return;
            } else {
                abstractC2108d.mo1631A();
                return;
            }
        }
        AbstractC2364n<Object> abstractC2364nMo1977c = this._serializer;
        if (abstractC2364nMo1977c == null) {
            Class<?> cls = objInvoke.getClass();
            AbstractC2262l abstractC2262l = this.f4794n;
            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
            abstractC2364nMo1977c = abstractC2364nMo2034c == null ? mo1977c(abstractC2262l, cls, abstractC2374x) : abstractC2364nMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (InterfaceC2094p.a.NON_EMPTY == obj2) {
                if (abstractC2364nMo1977c.mo2021d(abstractC2374x, objInvoke)) {
                    AbstractC2364n<Object> abstractC2364n2 = this._nullSerializer;
                    if (abstractC2364n2 != null) {
                        abstractC2364n2.mo1807f(null, abstractC2108d, abstractC2374x);
                        return;
                    } else {
                        abstractC2108d.mo1631A();
                        return;
                    }
                }
            } else if (obj2.equals(objInvoke)) {
                AbstractC2364n<Object> abstractC2364n3 = this._nullSerializer;
                if (abstractC2364n3 != null) {
                    abstractC2364n3.mo1807f(null, abstractC2108d, abstractC2374x);
                    return;
                } else {
                    abstractC2108d.mo1631A();
                    return;
                }
            }
        }
        if (objInvoke == obj && m1978d(abstractC2108d, abstractC2374x, abstractC2364nMo1977c)) {
            return;
        }
        AbstractC2215g abstractC2215g = this._typeSerializer;
        if (abstractC2215g == null) {
            abstractC2364nMo1977c.mo1807f(objInvoke, abstractC2108d, abstractC2374x);
        } else {
            abstractC2364nMo1977c.mo1808g(objInvoke, abstractC2108d, abstractC2374x, abstractC2215g);
        }
    }

    /* JADX INFO: renamed from: i */
    public void mo1983i(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        Method method = this.f4792l;
        Object objInvoke = method == null ? this.f4793m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            if (this._nullSerializer != null) {
                abstractC2108d.mo1665x(this._name);
                this._nullSerializer.mo1807f(null, abstractC2108d, abstractC2374x);
                return;
            }
            return;
        }
        AbstractC2364n<Object> abstractC2364nMo1977c = this._serializer;
        if (abstractC2364nMo1977c == null) {
            Class<?> cls = objInvoke.getClass();
            AbstractC2262l abstractC2262l = this.f4794n;
            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
            abstractC2364nMo1977c = abstractC2364nMo2034c == null ? mo1977c(abstractC2262l, cls, abstractC2374x) : abstractC2364nMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (InterfaceC2094p.a.NON_EMPTY == obj2) {
                if (abstractC2364nMo1977c.mo2021d(abstractC2374x, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && m1978d(abstractC2108d, abstractC2374x, abstractC2364nMo1977c)) {
            return;
        }
        abstractC2108d.mo1665x(this._name);
        AbstractC2215g abstractC2215g = this._typeSerializer;
        if (abstractC2215g == null) {
            abstractC2364nMo1977c.mo1807f(objInvoke, abstractC2108d, abstractC2374x);
        } else {
            abstractC2364nMo1977c.mo1808g(objInvoke, abstractC2108d, abstractC2374x, abstractC2215g);
        }
    }

    public Object readResolve() {
        AbstractC2188i abstractC2188i = this._member;
        if (abstractC2188i instanceof C2185g) {
            this.f4792l = null;
            this.f4793m = (Field) abstractC2188i.mo1888i();
        } else if (abstractC2188i instanceof C2189j) {
            this.f4792l = (Method) abstractC2188i.mo1888i();
            this.f4793m = null;
        }
        if (this._serializer == null) {
            this.f4794n = AbstractC2262l.b.f4828b;
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(this._name._value);
        sb.append("' (");
        if (this.f4792l != null) {
            sb.append("via method ");
            sb.append(this.f4792l.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f4792l.getName());
        } else if (this.f4793m != null) {
            sb.append("field \"");
            sb.append(this.f4793m.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f4793m.getName());
        } else {
            sb.append("virtual");
        }
        if (this._serializer == null) {
            sb.append(", no static serializer");
        } else {
            StringBuilder sbM833U = C1643a.m833U(", static serializer of type ");
            sbM833U.append(this._serializer.getClass().getName());
            sb.append(sbM833U.toString());
        }
        sb.append(')');
        return sb.toString();
    }

    public C2234c() {
        super(C2369s.f5027l);
        this._member = null;
        this.f4791k = null;
        this._name = null;
        this._wrapperName = null;
        this._includeInViews = null;
        this._declaredType = null;
        this._serializer = null;
        this.f4794n = null;
        this._typeSerializer = null;
        this._cfgSerializationType = null;
        this.f4792l = null;
        this.f4793m = null;
        this._suppressNulls = false;
        this._suppressableValue = null;
        this._nullSerializer = null;
    }

    public C2234c(C2234c c2234c, C2370t c2370t) {
        super(c2234c);
        this._name = new C2130j(c2370t._simpleName);
        this._wrapperName = c2234c._wrapperName;
        this.f4791k = c2234c.f4791k;
        this._declaredType = c2234c._declaredType;
        this._member = c2234c._member;
        this.f4792l = c2234c.f4792l;
        this.f4793m = c2234c.f4793m;
        this._serializer = c2234c._serializer;
        this._nullSerializer = c2234c._nullSerializer;
        if (c2234c.f4795o != null) {
            this.f4795o = new HashMap<>(c2234c.f4795o);
        }
        this._cfgSerializationType = c2234c._cfgSerializationType;
        this.f4794n = c2234c.f4794n;
        this._suppressNulls = c2234c._suppressNulls;
        this._suppressableValue = c2234c._suppressableValue;
        this._includeInViews = c2234c._includeInViews;
        this._typeSerializer = c2234c._typeSerializer;
        this._nonTrivialBaseType = c2234c._nonTrivialBaseType;
    }

    public C2234c(C2234c c2234c, C2130j c2130j) {
        super(c2234c);
        this._name = c2130j;
        this._wrapperName = c2234c._wrapperName;
        this._member = c2234c._member;
        this.f4791k = c2234c.f4791k;
        this._declaredType = c2234c._declaredType;
        this.f4792l = c2234c.f4792l;
        this.f4793m = c2234c.f4793m;
        this._serializer = c2234c._serializer;
        this._nullSerializer = c2234c._nullSerializer;
        if (c2234c.f4795o != null) {
            this.f4795o = new HashMap<>(c2234c.f4795o);
        }
        this._cfgSerializationType = c2234c._cfgSerializationType;
        this.f4794n = c2234c.f4794n;
        this._suppressNulls = c2234c._suppressNulls;
        this._suppressableValue = c2234c._suppressableValue;
        this._includeInViews = c2234c._includeInViews;
        this._typeSerializer = c2234c._typeSerializer;
        this._nonTrivialBaseType = c2234c._nonTrivialBaseType;
    }
}
