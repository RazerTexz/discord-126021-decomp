package p007b.p225i.p226a.p242c;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.p1 */
/* JADX INFO: compiled from: MediaMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2835p1 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2835p1 f7368j = new b().m3345a();

    /* JADX INFO: renamed from: k */
    public static final InterfaceC2963w0.a<C2835p1> f7369k = new InterfaceC2963w0.a() { // from class: b.i.a.c.l0
        @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
        /* JADX INFO: renamed from: a */
        public final InterfaceC2963w0 mo2576a(Bundle bundle) {
            Bundle bundle2;
            Bundle bundle3;
            C2835p1.b bVar = new C2835p1.b();
            bVar.f7407a = bundle.getCharSequence(C2835p1.m3343b(0));
            bVar.f7408b = bundle.getCharSequence(C2835p1.m3343b(1));
            bVar.f7409c = bundle.getCharSequence(C2835p1.m3343b(2));
            bVar.f7410d = bundle.getCharSequence(C2835p1.m3343b(3));
            bVar.f7411e = bundle.getCharSequence(C2835p1.m3343b(4));
            bVar.f7412f = bundle.getCharSequence(C2835p1.m3343b(5));
            bVar.f7413g = bundle.getCharSequence(C2835p1.m3343b(6));
            bVar.f7414h = (Uri) bundle.getParcelable(C2835p1.m3343b(7));
            byte[] byteArray = bundle.getByteArray(C2835p1.m3343b(10));
            Integer numValueOf = bundle.containsKey(C2835p1.m3343b(29)) ? Integer.valueOf(bundle.getInt(C2835p1.m3343b(29))) : null;
            bVar.f7417k = byteArray != null ? (byte[]) byteArray.clone() : null;
            bVar.f7418l = numValueOf;
            bVar.f7419m = (Uri) bundle.getParcelable(C2835p1.m3343b(11));
            bVar.f7430x = bundle.getCharSequence(C2835p1.m3343b(22));
            bVar.f7431y = bundle.getCharSequence(C2835p1.m3343b(23));
            bVar.f7432z = bundle.getCharSequence(C2835p1.m3343b(24));
            bVar.f7404C = bundle.getCharSequence(C2835p1.m3343b(27));
            bVar.f7405D = bundle.getCharSequence(C2835p1.m3343b(28));
            bVar.f7406E = bundle.getBundle(C2835p1.m3343b(1000));
            if (bundle.containsKey(C2835p1.m3343b(8)) && (bundle3 = bundle.getBundle(C2835p1.m3343b(8))) != null) {
                int i = AbstractC2656d2.f6334j;
                bVar.f7415i = (AbstractC2656d2) C2830o0.f7260a.mo2576a(bundle3);
            }
            if (bundle.containsKey(C2835p1.m3343b(9)) && (bundle2 = bundle.getBundle(C2835p1.m3343b(9))) != null) {
                int i2 = AbstractC2656d2.f6334j;
                bVar.f7416j = (AbstractC2656d2) C2830o0.f7260a.mo2576a(bundle2);
            }
            if (bundle.containsKey(C2835p1.m3343b(12))) {
                bVar.f7420n = Integer.valueOf(bundle.getInt(C2835p1.m3343b(12)));
            }
            if (bundle.containsKey(C2835p1.m3343b(13))) {
                bVar.f7421o = Integer.valueOf(bundle.getInt(C2835p1.m3343b(13)));
            }
            if (bundle.containsKey(C2835p1.m3343b(14))) {
                bVar.f7422p = Integer.valueOf(bundle.getInt(C2835p1.m3343b(14)));
            }
            if (bundle.containsKey(C2835p1.m3343b(15))) {
                bVar.f7423q = Boolean.valueOf(bundle.getBoolean(C2835p1.m3343b(15)));
            }
            if (bundle.containsKey(C2835p1.m3343b(16))) {
                bVar.f7424r = Integer.valueOf(bundle.getInt(C2835p1.m3343b(16)));
            }
            if (bundle.containsKey(C2835p1.m3343b(17))) {
                bVar.f7425s = Integer.valueOf(bundle.getInt(C2835p1.m3343b(17)));
            }
            if (bundle.containsKey(C2835p1.m3343b(18))) {
                bVar.f7426t = Integer.valueOf(bundle.getInt(C2835p1.m3343b(18)));
            }
            if (bundle.containsKey(C2835p1.m3343b(19))) {
                bVar.f7427u = Integer.valueOf(bundle.getInt(C2835p1.m3343b(19)));
            }
            if (bundle.containsKey(C2835p1.m3343b(20))) {
                bVar.f7428v = Integer.valueOf(bundle.getInt(C2835p1.m3343b(20)));
            }
            if (bundle.containsKey(C2835p1.m3343b(21))) {
                bVar.f7429w = Integer.valueOf(bundle.getInt(C2835p1.m3343b(21)));
            }
            if (bundle.containsKey(C2835p1.m3343b(25))) {
                bVar.f7402A = Integer.valueOf(bundle.getInt(C2835p1.m3343b(25)));
            }
            if (bundle.containsKey(C2835p1.m3343b(26))) {
                bVar.f7403B = Integer.valueOf(bundle.getInt(C2835p1.m3343b(26)));
            }
            return bVar.m3345a();
        }
    };

    /* JADX INFO: renamed from: A */
    @Nullable
    public final Integer f7370A;

    /* JADX INFO: renamed from: B */
    @Nullable
    public final Boolean f7371B;

    /* JADX INFO: renamed from: C */
    @Nullable
    @Deprecated
    public final Integer f7372C;

    /* JADX INFO: renamed from: D */
    @Nullable
    public final Integer f7373D;

    /* JADX INFO: renamed from: E */
    @Nullable
    public final Integer f7374E;

    /* JADX INFO: renamed from: F */
    @Nullable
    public final Integer f7375F;

    /* JADX INFO: renamed from: G */
    @Nullable
    public final Integer f7376G;

    /* JADX INFO: renamed from: H */
    @Nullable
    public final Integer f7377H;

    /* JADX INFO: renamed from: I */
    @Nullable
    public final Integer f7378I;

    /* JADX INFO: renamed from: J */
    @Nullable
    public final CharSequence f7379J;

    /* JADX INFO: renamed from: K */
    @Nullable
    public final CharSequence f7380K;

    /* JADX INFO: renamed from: L */
    @Nullable
    public final CharSequence f7381L;

    /* JADX INFO: renamed from: M */
    @Nullable
    public final Integer f7382M;

    /* JADX INFO: renamed from: N */
    @Nullable
    public final Integer f7383N;

    /* JADX INFO: renamed from: O */
    @Nullable
    public final CharSequence f7384O;

    /* JADX INFO: renamed from: P */
    @Nullable
    public final CharSequence f7385P;

    /* JADX INFO: renamed from: Q */
    @Nullable
    public final Bundle f7386Q;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final CharSequence f7387l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final CharSequence f7388m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final CharSequence f7389n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final CharSequence f7390o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final CharSequence f7391p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final CharSequence f7392q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public final CharSequence f7393r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final Uri f7394s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public final AbstractC2656d2 f7395t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public final AbstractC2656d2 f7396u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public final byte[] f7397v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public final Integer f7398w;

    /* JADX INFO: renamed from: x */
    @Nullable
    public final Uri f7399x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public final Integer f7400y;

    /* JADX INFO: renamed from: z */
    @Nullable
    public final Integer f7401z;

    /* JADX INFO: renamed from: b.i.a.c.p1$b */
    /* JADX INFO: compiled from: MediaMetadata.java */
    public static final class b {

        /* JADX INFO: renamed from: A */
        @Nullable
        public Integer f7402A;

        /* JADX INFO: renamed from: B */
        @Nullable
        public Integer f7403B;

        /* JADX INFO: renamed from: C */
        @Nullable
        public CharSequence f7404C;

        /* JADX INFO: renamed from: D */
        @Nullable
        public CharSequence f7405D;

        /* JADX INFO: renamed from: E */
        @Nullable
        public Bundle f7406E;

        /* JADX INFO: renamed from: a */
        @Nullable
        public CharSequence f7407a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public CharSequence f7408b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public CharSequence f7409c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public CharSequence f7410d;

        /* JADX INFO: renamed from: e */
        @Nullable
        public CharSequence f7411e;

        /* JADX INFO: renamed from: f */
        @Nullable
        public CharSequence f7412f;

        /* JADX INFO: renamed from: g */
        @Nullable
        public CharSequence f7413g;

        /* JADX INFO: renamed from: h */
        @Nullable
        public Uri f7414h;

        /* JADX INFO: renamed from: i */
        @Nullable
        public AbstractC2656d2 f7415i;

        /* JADX INFO: renamed from: j */
        @Nullable
        public AbstractC2656d2 f7416j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public byte[] f7417k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public Integer f7418l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public Uri f7419m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public Integer f7420n;

        /* JADX INFO: renamed from: o */
        @Nullable
        public Integer f7421o;

        /* JADX INFO: renamed from: p */
        @Nullable
        public Integer f7422p;

        /* JADX INFO: renamed from: q */
        @Nullable
        public Boolean f7423q;

        /* JADX INFO: renamed from: r */
        @Nullable
        public Integer f7424r;

        /* JADX INFO: renamed from: s */
        @Nullable
        public Integer f7425s;

        /* JADX INFO: renamed from: t */
        @Nullable
        public Integer f7426t;

        /* JADX INFO: renamed from: u */
        @Nullable
        public Integer f7427u;

        /* JADX INFO: renamed from: v */
        @Nullable
        public Integer f7428v;

        /* JADX INFO: renamed from: w */
        @Nullable
        public Integer f7429w;

        /* JADX INFO: renamed from: x */
        @Nullable
        public CharSequence f7430x;

        /* JADX INFO: renamed from: y */
        @Nullable
        public CharSequence f7431y;

        /* JADX INFO: renamed from: z */
        @Nullable
        public CharSequence f7432z;

        public b() {
        }

        /* JADX INFO: renamed from: a */
        public C2835p1 m3345a() {
            return new C2835p1(this, null);
        }

        /* JADX INFO: renamed from: b */
        public b m3346b(byte[] bArr, int i) {
            if (this.f7417k == null || C2738e0.m2993a(Integer.valueOf(i), 3) || !C2738e0.m2993a(this.f7418l, 3)) {
                this.f7417k = (byte[]) bArr.clone();
                this.f7418l = Integer.valueOf(i);
            }
            return this;
        }

        public b(C2835p1 c2835p1, a aVar) {
            this.f7407a = c2835p1.f7387l;
            this.f7408b = c2835p1.f7388m;
            this.f7409c = c2835p1.f7389n;
            this.f7410d = c2835p1.f7390o;
            this.f7411e = c2835p1.f7391p;
            this.f7412f = c2835p1.f7392q;
            this.f7413g = c2835p1.f7393r;
            this.f7414h = c2835p1.f7394s;
            this.f7415i = c2835p1.f7395t;
            this.f7416j = c2835p1.f7396u;
            this.f7417k = c2835p1.f7397v;
            this.f7418l = c2835p1.f7398w;
            this.f7419m = c2835p1.f7399x;
            this.f7420n = c2835p1.f7400y;
            this.f7421o = c2835p1.f7401z;
            this.f7422p = c2835p1.f7370A;
            this.f7423q = c2835p1.f7371B;
            this.f7424r = c2835p1.f7373D;
            this.f7425s = c2835p1.f7374E;
            this.f7426t = c2835p1.f7375F;
            this.f7427u = c2835p1.f7376G;
            this.f7428v = c2835p1.f7377H;
            this.f7429w = c2835p1.f7378I;
            this.f7430x = c2835p1.f7379J;
            this.f7431y = c2835p1.f7380K;
            this.f7432z = c2835p1.f7381L;
            this.f7402A = c2835p1.f7382M;
            this.f7403B = c2835p1.f7383N;
            this.f7404C = c2835p1.f7384O;
            this.f7405D = c2835p1.f7385P;
            this.f7406E = c2835p1.f7386Q;
        }
    }

    public C2835p1(b bVar, a aVar) {
        this.f7387l = bVar.f7407a;
        this.f7388m = bVar.f7408b;
        this.f7389n = bVar.f7409c;
        this.f7390o = bVar.f7410d;
        this.f7391p = bVar.f7411e;
        this.f7392q = bVar.f7412f;
        this.f7393r = bVar.f7413g;
        this.f7394s = bVar.f7414h;
        this.f7395t = bVar.f7415i;
        this.f7396u = bVar.f7416j;
        this.f7397v = bVar.f7417k;
        this.f7398w = bVar.f7418l;
        this.f7399x = bVar.f7419m;
        this.f7400y = bVar.f7420n;
        this.f7401z = bVar.f7421o;
        this.f7370A = bVar.f7422p;
        this.f7371B = bVar.f7423q;
        Integer num = bVar.f7424r;
        this.f7372C = num;
        this.f7373D = num;
        this.f7374E = bVar.f7425s;
        this.f7375F = bVar.f7426t;
        this.f7376G = bVar.f7427u;
        this.f7377H = bVar.f7428v;
        this.f7378I = bVar.f7429w;
        this.f7379J = bVar.f7430x;
        this.f7380K = bVar.f7431y;
        this.f7381L = bVar.f7432z;
        this.f7382M = bVar.f7402A;
        this.f7383N = bVar.f7403B;
        this.f7384O = bVar.f7404C;
        this.f7385P = bVar.f7405D;
        this.f7386Q = bVar.f7406E;
    }

    /* JADX INFO: renamed from: b */
    public static String m3343b(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: renamed from: a */
    public b m3344a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2835p1.class != obj.getClass()) {
            return false;
        }
        C2835p1 c2835p1 = (C2835p1) obj;
        return C2738e0.m2993a(this.f7387l, c2835p1.f7387l) && C2738e0.m2993a(this.f7388m, c2835p1.f7388m) && C2738e0.m2993a(this.f7389n, c2835p1.f7389n) && C2738e0.m2993a(this.f7390o, c2835p1.f7390o) && C2738e0.m2993a(this.f7391p, c2835p1.f7391p) && C2738e0.m2993a(this.f7392q, c2835p1.f7392q) && C2738e0.m2993a(this.f7393r, c2835p1.f7393r) && C2738e0.m2993a(this.f7394s, c2835p1.f7394s) && C2738e0.m2993a(this.f7395t, c2835p1.f7395t) && C2738e0.m2993a(this.f7396u, c2835p1.f7396u) && Arrays.equals(this.f7397v, c2835p1.f7397v) && C2738e0.m2993a(this.f7398w, c2835p1.f7398w) && C2738e0.m2993a(this.f7399x, c2835p1.f7399x) && C2738e0.m2993a(this.f7400y, c2835p1.f7400y) && C2738e0.m2993a(this.f7401z, c2835p1.f7401z) && C2738e0.m2993a(this.f7370A, c2835p1.f7370A) && C2738e0.m2993a(this.f7371B, c2835p1.f7371B) && C2738e0.m2993a(this.f7373D, c2835p1.f7373D) && C2738e0.m2993a(this.f7374E, c2835p1.f7374E) && C2738e0.m2993a(this.f7375F, c2835p1.f7375F) && C2738e0.m2993a(this.f7376G, c2835p1.f7376G) && C2738e0.m2993a(this.f7377H, c2835p1.f7377H) && C2738e0.m2993a(this.f7378I, c2835p1.f7378I) && C2738e0.m2993a(this.f7379J, c2835p1.f7379J) && C2738e0.m2993a(this.f7380K, c2835p1.f7380K) && C2738e0.m2993a(this.f7381L, c2835p1.f7381L) && C2738e0.m2993a(this.f7382M, c2835p1.f7382M) && C2738e0.m2993a(this.f7383N, c2835p1.f7383N) && C2738e0.m2993a(this.f7384O, c2835p1.f7384O) && C2738e0.m2993a(this.f7385P, c2835p1.f7385P);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7387l, this.f7388m, this.f7389n, this.f7390o, this.f7391p, this.f7392q, this.f7393r, this.f7394s, this.f7395t, this.f7396u, Integer.valueOf(Arrays.hashCode(this.f7397v)), this.f7398w, this.f7399x, this.f7400y, this.f7401z, this.f7370A, this.f7371B, this.f7373D, this.f7374E, this.f7375F, this.f7376G, this.f7377H, this.f7378I, this.f7379J, this.f7380K, this.f7381L, this.f7382M, this.f7383N, this.f7384O, this.f7385P});
    }
}
