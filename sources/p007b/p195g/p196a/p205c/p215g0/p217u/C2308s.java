package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.s */
/* JADX INFO: compiled from: JsonValueSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2308s extends AbstractC2305q0<Object> implements InterfaceC2240i {
    public final AbstractC2188i _accessor;
    public final boolean _forceTypeInformation;
    public final InterfaceC2206d _property;
    public final AbstractC2364n<Object> _valueSerializer;
    public final AbstractC2360j _valueType;
    public final AbstractC2215g _valueTypeSerializer;

    /* JADX INFO: renamed from: k */
    public transient AbstractC2262l f4861k;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.s$a */
    /* JADX INFO: compiled from: JsonValueSerializer.java */
    public static class a extends AbstractC2215g {

        /* JADX INFO: renamed from: a */
        public final AbstractC2215g f4862a;

        /* JADX INFO: renamed from: b */
        public final Object f4863b;

        public a(AbstractC2215g abstractC2215g, Object obj) {
            this.f4862a = abstractC2215g;
            this.f4863b = obj;
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
        /* JADX INFO: renamed from: a */
        public AbstractC2215g mo1955a(InterfaceC2206d interfaceC2206d) {
            throw new UnsupportedOperationException();
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
        /* JADX INFO: renamed from: b */
        public String mo1956b() {
            return this.f4862a.mo1956b();
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
        /* JADX INFO: renamed from: c */
        public InterfaceC2070c0.a mo1957c() {
            return this.f4862a.mo1957c();
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
        /* JADX INFO: renamed from: e */
        public C2138b mo1959e(AbstractC2108d abstractC2108d, C2138b c2138b) throws IOException {
            c2138b.f4584a = this.f4863b;
            return this.f4862a.mo1959e(abstractC2108d, c2138b);
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
        /* JADX INFO: renamed from: f */
        public C2138b mo1960f(AbstractC2108d abstractC2108d, C2138b c2138b) throws IOException {
            return this.f4862a.mo1960f(abstractC2108d, c2138b);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C2308s(C2308s c2308s, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, boolean z2) {
        Class cls = c2308s._handledType;
        super(cls == null ? Object.class : cls);
        this._accessor = c2308s._accessor;
        this._valueType = c2308s._valueType;
        this._valueTypeSerializer = abstractC2215g;
        this._valueSerializer = abstractC2364n;
        this._property = interfaceC2206d;
        this._forceTypeInformation = z2;
        this.f4861k = AbstractC2262l.b.f4828b;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2215g abstractC2215gMo1955a = this._valueTypeSerializer;
        if (abstractC2215gMo1955a != null) {
            abstractC2215gMo1955a = abstractC2215gMo1955a.mo1955a(interfaceC2206d);
        }
        AbstractC2364n<?> abstractC2364n = this._valueSerializer;
        if (abstractC2364n != null) {
            return m2081q(interfaceC2206d, abstractC2215gMo1955a, abstractC2374x.m2260y(abstractC2364n, interfaceC2206d), this._forceTypeInformation);
        }
        if (!abstractC2374x.m2239C(EnumC2366p.USE_STATIC_TYPING) && !this._valueType.m2220x()) {
            return interfaceC2206d != this._property ? m2081q(interfaceC2206d, abstractC2215gMo1955a, abstractC2364n, this._forceTypeInformation) : this;
        }
        AbstractC2364n<Object> abstractC2364nM2252q = abstractC2374x.m2252q(this._valueType, interfaceC2206d);
        Class<?> cls = this._valueType._class;
        boolean zM2187s = false;
        if (!cls.isPrimitive() ? cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class : cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE) {
            zM2187s = C2342d.m2187s(abstractC2364nM2252q);
        }
        return m2081q(interfaceC2206d, abstractC2215gMo1955a, abstractC2364nM2252q, zM2187s);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        Object objMo1889j = this._accessor.mo1889j(obj);
        if (objMo1889j == null) {
            return true;
        }
        AbstractC2364n<Object> abstractC2364nM2080p = this._valueSerializer;
        if (abstractC2364nM2080p == null) {
            try {
                abstractC2364nM2080p = m2080p(abstractC2374x, objMo1889j.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return abstractC2364nM2080p.mo2021d(abstractC2374x, objMo1889j);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        try {
            Object objMo1889j = this._accessor.mo1889j(obj);
            if (objMo1889j == null) {
                abstractC2374x.m2248l(abstractC2108d);
                return;
            }
            AbstractC2364n<Object> abstractC2364nM2080p = this._valueSerializer;
            if (abstractC2364nM2080p == null) {
                abstractC2364nM2080p = m2080p(abstractC2374x, objMo1889j.getClass());
            }
            AbstractC2215g abstractC2215g = this._valueTypeSerializer;
            if (abstractC2215g != null) {
                abstractC2364nM2080p.mo1808g(objMo1889j, abstractC2108d, abstractC2374x, abstractC2215g);
            } else {
                abstractC2364nM2080p.mo1807f(objMo1889j, abstractC2108d, abstractC2374x);
            }
        } catch (Exception e) {
            m2077o(abstractC2374x, e, obj, this._accessor.mo1819c() + "()");
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        try {
            Object objMo1889j = this._accessor.mo1889j(obj);
            if (objMo1889j == null) {
                abstractC2374x.m2248l(abstractC2108d);
                return;
            }
            AbstractC2364n<Object> abstractC2364nM2080p = this._valueSerializer;
            if (abstractC2364nM2080p == null) {
                abstractC2364nM2080p = m2080p(abstractC2374x, objMo1889j.getClass());
            } else if (this._forceTypeInformation) {
                C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(obj, EnumC2112h.VALUE_STRING));
                abstractC2364nM2080p.mo1807f(objMo1889j, abstractC2108d, abstractC2374x);
                abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
                return;
            }
            abstractC2364nM2080p.mo1808g(objMo1889j, abstractC2108d, abstractC2374x, new a(abstractC2215g, obj));
        } catch (Exception e) {
            m2077o(abstractC2374x, e, obj, this._accessor.mo1819c() + "()");
            throw null;
        }
    }

    /* JADX INFO: renamed from: p */
    public AbstractC2364n<Object> m2080p(AbstractC2374x abstractC2374x, Class<?> cls) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nMo2034c = this.f4861k.mo2034c(cls);
        if (abstractC2364nMo2034c != null) {
            return abstractC2364nMo2034c;
        }
        if (!this._valueType.mo2102r()) {
            AbstractC2364n<Object> abstractC2364nM2253r = abstractC2374x.m2253r(cls, this._property);
            this.f4861k = this.f4861k.mo2033b(cls, abstractC2364nM2253r);
            return abstractC2364nM2253r;
        }
        AbstractC2360j abstractC2360jM2247k = abstractC2374x.m2247k(this._valueType, cls);
        AbstractC2364n<Object> abstractC2364nM2252q = abstractC2374x.m2252q(abstractC2360jM2247k, this._property);
        AbstractC2262l abstractC2262l = this.f4861k;
        Objects.requireNonNull(abstractC2262l);
        this.f4861k = abstractC2262l.mo2033b(abstractC2360jM2247k._class, abstractC2364nM2252q);
        return abstractC2364nM2252q;
    }

    /* JADX INFO: renamed from: q */
    public C2308s m2081q(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, boolean z2) {
        return (this._property == interfaceC2206d && this._valueTypeSerializer == abstractC2215g && this._valueSerializer == abstractC2364n && z2 == this._forceTypeInformation) ? this : new C2308s(this, interfaceC2206d, abstractC2215g, abstractC2364n, z2);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("(@JsonValue serializer for method ");
        sbM833U.append(this._accessor.mo1887g());
        sbM833U.append("#");
        sbM833U.append(this._accessor.mo1819c());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public C2308s(AbstractC2188i abstractC2188i, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n) {
        super(abstractC2188i.mo1821e());
        this._accessor = abstractC2188i;
        this._valueType = abstractC2188i.mo1821e();
        this._valueTypeSerializer = abstractC2215g;
        this._valueSerializer = abstractC2364n;
        this._property = null;
        this._forceTypeInformation = true;
        this.f4861k = AbstractC2262l.b.f4828b;
    }
}
