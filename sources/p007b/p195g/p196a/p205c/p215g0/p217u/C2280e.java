package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.e */
/* JADX INFO: compiled from: BooleanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public final class C2280e extends AbstractC2303p0<Object> implements InterfaceC2240i {
    private static final long serialVersionUID = 1;
    public final boolean _forPrimitive;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.e$a */
    /* JADX INFO: compiled from: BooleanSerializer.java */
    public static final class a extends AbstractC2303p0<Object> implements InterfaceC2240i {
        private static final long serialVersionUID = 1;
        public final boolean _forPrimitive;

        public a(boolean z2) {
            super(z2 ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = z2;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
        /* JADX INFO: renamed from: a */
        public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
            InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, Boolean.class);
            return (dVarM2074l == null || dVarM2074l.m1601e().m1596f()) ? this : new C2280e(this._forPrimitive);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            abstractC2108d.mo1634H(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: g */
        public final void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
            abstractC2108d.mo1662s(Boolean.TRUE.equals(obj));
        }
    }

    public C2280e(boolean z2) {
        super(z2 ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z2;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, Boolean.class);
        return (dVarM2074l == null || !dVarM2074l.m1601e().m1596f()) ? this : new a(this._forPrimitive);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1662s(Boolean.TRUE.equals(obj));
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public final void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        abstractC2108d.mo1662s(Boolean.TRUE.equals(obj));
    }
}
