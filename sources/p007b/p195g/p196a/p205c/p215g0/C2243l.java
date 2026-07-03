package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2379e;

/* JADX INFO: renamed from: b.g.a.c.g0.l */
/* JADX INFO: compiled from: PropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2243l {

    /* JADX INFO: renamed from: a */
    public final C2372v f4809a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2172c f4810b;

    /* JADX INFO: renamed from: c */
    public final AbstractC2165b f4811c;

    /* JADX INFO: renamed from: d */
    public Object f4812d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2094p.b f4813e;

    /* JADX INFO: renamed from: f */
    public final boolean f4814f;

    public C2243l(C2372v c2372v, AbstractC2172c abstractC2172c) {
        this.f4809a = c2372v;
        this.f4810b = abstractC2172c;
        InterfaceC2094p.b bVar = InterfaceC2094p.b.f4436j;
        InterfaceC2094p.b bVarM1618a = InterfaceC2094p.b.f4436j;
        InterfaceC2094p.b bVarMo1814c = abstractC2172c.mo1814c(bVarM1618a);
        c2372v.m2273k(abstractC2172c.f4626a._class, bVarM1618a);
        bVarM1618a = bVarMo1814c != null ? bVarMo1814c.m1618a(bVarM1618a) : bVarM1618a;
        InterfaceC2094p.b bVar2 = c2372v._configOverrides._defaultInclusion;
        this.f4813e = bVar2 == null ? bVarM1618a : bVar2.m1618a(bVarM1618a);
        this.f4814f = bVarM1618a._valueInclusion == InterfaceC2094p.a.NON_DEFAULT;
        this.f4811c = c2372v.m2267e();
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2360j m2006a(AbstractC2175b abstractC2175b, boolean z2, AbstractC2360j abstractC2360j) throws JsonMappingException {
        AbstractC2360j abstractC2360jMo1780e0 = this.f4811c.mo1780e0(this.f4809a, abstractC2175b, abstractC2360j);
        if (abstractC2360jMo1780e0 != abstractC2360j) {
            Class<?> cls = abstractC2360jMo1780e0._class;
            Class<?> cls2 = abstractC2360j._class;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                StringBuilder sbM833U = C1643a.m833U("Illegal concrete-type annotation for method '");
                sbM833U.append(abstractC2175b.mo1819c());
                sbM833U.append("': class ");
                sbM833U.append(cls.getName());
                sbM833U.append(" not a super-type of (declared) class ");
                sbM833U.append(cls2.getName());
                throw new IllegalArgumentException(sbM833U.toString());
            }
            z2 = true;
            abstractC2360j = abstractC2360jMo1780e0;
        }
        InterfaceC2379e.b bVarMo1755K = this.f4811c.mo1755K(abstractC2175b);
        if (bVarMo1755K != null && bVarMo1755K != InterfaceC2379e.b.DEFAULT_TYPING) {
            z2 = bVarMo1755K == InterfaceC2379e.b.STATIC;
        }
        if (z2) {
            return abstractC2360j.mo2129M();
        }
        return null;
    }
}
