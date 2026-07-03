package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.d */
/* JADX INFO: compiled from: BeanProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2206d {

    /* JADX INFO: renamed from: c */
    public static final InterfaceC2081i.d f4765c = new InterfaceC2081i.d("", InterfaceC2081i.c.ANY, "", "", InterfaceC2081i.b.f4406a, null);

    /* JADX INFO: renamed from: b.g.a.c.d$a */
    /* JADX INFO: compiled from: BeanProperty.java */
    public static class a implements InterfaceC2206d, Serializable {
        private static final long serialVersionUID = 1;
        public final AbstractC2188i _member;
        public final C2369s _metadata;
        public final C2370t _name;
        public final AbstractC2360j _type;
        public final C2370t _wrapperName;

        public a(C2370t c2370t, AbstractC2360j abstractC2360j, C2370t c2370t2, AbstractC2188i abstractC2188i, C2369s c2369s) {
            this._name = c2370t;
            this._type = abstractC2360j;
            this._wrapperName = c2370t2;
            this._metadata = c2369s;
            this._member = abstractC2188i;
        }

        @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
        /* JADX INFO: renamed from: a */
        public InterfaceC2081i.d mo1928a(AbstractC2394l<?> abstractC2394l, Class<?> cls) {
            AbstractC2188i abstractC2188i;
            InterfaceC2081i.d dVarMo1784h;
            InterfaceC2081i.d dVarMo2271i = abstractC2394l.mo2271i(cls);
            AbstractC2165b abstractC2165bM2267e = abstractC2394l.m2267e();
            return (abstractC2165bM2267e == null || (abstractC2188i = this._member) == null || (dVarMo1784h = abstractC2165bM2267e.mo1784h(abstractC2188i)) == null) ? dVarMo2271i : dVarMo2271i.m1607k(dVarMo1784h);
        }

        @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
        /* JADX INFO: renamed from: b */
        public InterfaceC2094p.b mo1929b(AbstractC2394l<?> abstractC2394l, Class<?> cls) {
            AbstractC2188i abstractC2188i;
            InterfaceC2094p.b bVarMo1802z;
            InterfaceC2094p.b bVarMo2269g = abstractC2394l.mo2269g(cls, this._type._class);
            AbstractC2165b abstractC2165bM2267e = abstractC2394l.m2267e();
            return (abstractC2165bM2267e == null || (abstractC2188i = this._member) == null || (bVarMo1802z = abstractC2165bM2267e.mo1802z(abstractC2188i)) == null) ? bVarMo2269g : bVarMo2269g.m1618a(bVarMo1802z);
        }

        @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
        public AbstractC2188i getMember() {
            return this._member;
        }

        @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
        public AbstractC2360j getType() {
            return this._type;
        }
    }

    static {
        InterfaceC2094p.b bVar = InterfaceC2094p.b.f4436j;
        InterfaceC2094p.b bVar2 = InterfaceC2094p.b.f4436j;
    }

    /* JADX INFO: renamed from: a */
    InterfaceC2081i.d mo1928a(AbstractC2394l<?> abstractC2394l, Class<?> cls);

    /* JADX INFO: renamed from: b */
    InterfaceC2094p.b mo1929b(AbstractC2394l<?> abstractC2394l, Class<?> cls);

    AbstractC2188i getMember();

    AbstractC2360j getType();
}
