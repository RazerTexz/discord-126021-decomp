package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3635e1;

/* JADX INFO: renamed from: b.i.a.f.h.l.d1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3621d1 extends AbstractC3851u4<C3621d1, a> implements InterfaceC3626d6 {
    private static final C3621d1 zzd;
    private static volatile InterfaceC3710j6<C3621d1> zze;
    private InterfaceC3597b5<C3635e1> zzc = C3749m6.f10094k;

    /* JADX INFO: renamed from: b.i.a.f.h.l.d1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3621d1, a> implements InterfaceC3626d6 {
        public a() {
            super(C3621d1.zzd);
        }

        /* JADX INFO: renamed from: q */
        public final a m4627q(C3635e1.a aVar) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3621d1.m4622w((C3621d1) this.f10347k, (C3635e1) ((AbstractC3851u4) aVar.m5320p()));
            return this;
        }

        public a(C3718k1 c3718k1) {
            super(C3621d1.zzd);
        }
    }

    static {
        C3621d1 c3621d1 = new C3621d1();
        zzd = c3621d1;
        AbstractC3851u4.m5313r(C3621d1.class, c3621d1);
    }

    /* JADX INFO: renamed from: w */
    public static void m4622w(C3621d1 c3621d1, C3635e1 c3635e1) {
        Objects.requireNonNull(c3621d1);
        InterfaceC3597b5<C3635e1> interfaceC3597b5 = c3621d1.zzc;
        if (!interfaceC3597b5.mo4568a()) {
            c3621d1.zzc = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3621d1.zzc.add(c3635e1);
    }

    /* JADX INFO: renamed from: x */
    public static a m4623x() {
        return zzd.m5314s();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3621d1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", C3635e1.class});
            case 4:
                return zzd;
            case 5:
                InterfaceC3710j6<C3621d1> aVar = zze;
                if (aVar == null) {
                    synchronized (C3621d1.class) {
                        aVar = zze;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzd);
                            zze = aVar;
                        }
                        break;
                    }
                }
                return aVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: u */
    public final C3635e1 m4625u() {
        return this.zzc.get(0);
    }

    /* JADX INFO: renamed from: v */
    public final List<C3635e1> m4626v() {
        return this.zzc;
    }
}
