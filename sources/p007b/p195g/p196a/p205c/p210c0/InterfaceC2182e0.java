package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Type;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p218h0.C2334m;
import p007b.p195g.p196a.p205c.p218h0.C2335n;

/* JADX INFO: renamed from: b.g.a.c.c0.e0 */
/* JADX INFO: compiled from: TypeResolutionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2182e0 {

    /* JADX INFO: renamed from: b.g.a.c.c0.e0$a */
    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class a implements InterfaceC2182e0 {

        /* JADX INFO: renamed from: j */
        public final C2335n f4702j;

        /* JADX INFO: renamed from: k */
        public final C2334m f4703k;

        public a(C2335n c2335n, C2334m c2334m) {
            this.f4702j = c2335n;
            this.f4703k = c2334m;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.InterfaceC2182e0
        /* JADX INFO: renamed from: a */
        public AbstractC2360j mo1831a(Type type) {
            return this.f4702j.m2160b(null, type, this.f4703k);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.e0$b */
    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class b implements InterfaceC2182e0 {

        /* JADX INFO: renamed from: j */
        public final C2335n f4704j;

        public b(C2335n c2335n) {
            this.f4704j = c2335n;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.InterfaceC2182e0
        /* JADX INFO: renamed from: a */
        public AbstractC2360j mo1831a(Type type) {
            return this.f4704j.m2160b(null, type, C2335n.f4926l);
        }
    }

    /* JADX INFO: renamed from: a */
    AbstractC2360j mo1831a(Type type);
}
