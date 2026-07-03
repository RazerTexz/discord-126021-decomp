package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2305q0;

/* JADX INFO: renamed from: b.g.a.c.g0.t.q */
/* JADX INFO: compiled from: UnknownSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2267q extends AbstractC2305q0<Object> {
    public C2267q() {
        super(Object.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        if (abstractC2374x.m2240D(EnumC2373w.FAIL_ON_EMPTY_BEANS)) {
            m2042p(abstractC2374x, obj);
        }
        abstractC2108d.mo1656f0(obj, 0);
        abstractC2108d.mo1664u();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public final void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        if (abstractC2374x.m2240D(EnumC2373w.FAIL_ON_EMPTY_BEANS)) {
            m2042p(abstractC2374x, obj);
        }
        abstractC2215g.mo1960f(abstractC2108d, abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(obj, EnumC2112h.START_OBJECT)));
    }

    /* JADX INFO: renamed from: p */
    public void m2042p(AbstractC2374x abstractC2374x, Object obj) throws JsonMappingException {
        abstractC2374x.m1943g(this._handledType, String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", obj.getClass().getName()));
    }

    public C2267q(Class<?> cls) {
        super(cls, false);
    }
}
