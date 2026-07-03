package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;

/* JADX INFO: renamed from: b.g.a.c.g0.t.p */
/* JADX INFO: compiled from: TypeWrappedSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2266p extends AbstractC2364n<Object> implements InterfaceC2240i {

    /* JADX INFO: renamed from: j */
    public final AbstractC2215g f4845j;

    /* JADX INFO: renamed from: k */
    public final AbstractC2364n<Object> f4846k;

    public C2266p(AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n) {
        this.f4845j = abstractC2215g;
        this.f4846k = abstractC2364n;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nM2261z = this.f4846k;
        if (abstractC2364nM2261z instanceof InterfaceC2240i) {
            abstractC2364nM2261z = abstractC2374x.m2261z(abstractC2364nM2261z, interfaceC2206d);
        }
        return abstractC2364nM2261z == this.f4846k ? this : new C2266p(this.f4845j, abstractC2364nM2261z);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: c */
    public Class<Object> mo2041c() {
        return Object.class;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        this.f4846k.mo1808g(obj, abstractC2108d, abstractC2374x, this.f4845j);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        this.f4846k.mo1808g(obj, abstractC2108d, abstractC2374x, abstractC2215g);
    }
}
