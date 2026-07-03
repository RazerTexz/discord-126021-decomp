package p007b.p225i.p226a.p242c.p267x2.p276k0;

import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.AbstractC2999a;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.z */
/* JADX INFO: compiled from: PsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3105z extends AbstractC2999a {

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.z$b */
    /* JADX INFO: compiled from: PsBinarySearchSeeker.java */
    public static final class b implements AbstractC2999a.f {

        /* JADX INFO: renamed from: a */
        public final C2736d0 f8923a;

        /* JADX INFO: renamed from: b */
        public final C2757x f8924b = new C2757x();

        public b(C2736d0 c2736d0, a aVar) {
            this.f8923a = c2736d0;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.f
        /* JADX INFO: renamed from: a */
        public void mo3627a() {
            this.f8924b.m3076B(C2738e0.f6713f);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:36:0x00d5
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.f
        /* JADX INFO: renamed from: b */
        public p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.e mo3628b(p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i r17, long r18) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p242c.p267x2.p276k0.C3105z.b.mo3628b(b.i.a.c.x2.i, long):b.i.a.c.x2.a$e");
        }
    }

    public C3105z(C2736d0 c2736d0, long j, long j2) {
        super(new AbstractC2999a.b(), new b(c2736d0, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    /* JADX INFO: renamed from: g */
    public static int m3794g(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
