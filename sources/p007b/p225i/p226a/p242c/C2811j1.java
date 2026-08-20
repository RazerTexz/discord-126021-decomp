package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2739f;
import p007b.p225i.p226a.p242c.p260g3.C2777n;

/* JADX INFO: renamed from: b.i.a.c.j1 */
/* JADX INFO: compiled from: Format.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2811j1 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2811j1 f7125j = new b().m3277a();

    /* JADX INFO: renamed from: k */
    public static final InterfaceC2963w0.a<C2811j1> f7126k = new InterfaceC2963w0.a() { // from class: b.i.a.c.h0
        @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
        /* JADX INFO: renamed from: a */
        public final InterfaceC2963w0 mo2576a(Bundle bundle) {
            C2811j1 c2811j1 = C2811j1.f7125j;
            C2811j1.b bVar = new C2811j1.b();
            if (bundle != null) {
                ClassLoader classLoader = C2739f.class.getClassLoader();
                int i = C2738e0.f6708a;
                bundle.setClassLoader(classLoader);
            }
            int i2 = 0;
            String string = bundle.getString(C2811j1.m3274d(0));
            C2811j1 c2811j2 = C2811j1.f7125j;
            bVar.f7163a = (String) C2811j1.m3273b(string, c2811j2.f7144l);
            bVar.f7164b = (String) C2811j1.m3273b(bundle.getString(C2811j1.m3274d(1)), c2811j2.f7145m);
            bVar.f7165c = (String) C2811j1.m3273b(bundle.getString(C2811j1.m3274d(2)), c2811j2.f7146n);
            bVar.f7166d = bundle.getInt(C2811j1.m3274d(3), c2811j2.f7147o);
            bVar.f7167e = bundle.getInt(C2811j1.m3274d(4), c2811j2.f7148p);
            bVar.f7168f = bundle.getInt(C2811j1.m3274d(5), c2811j2.f7149q);
            bVar.f7169g = bundle.getInt(C2811j1.m3274d(6), c2811j2.f7150r);
            bVar.f7170h = (String) C2811j1.m3273b(bundle.getString(C2811j1.m3274d(7)), c2811j2.f7152t);
            bVar.f7171i = (Metadata) C2811j1.m3273b((Metadata) bundle.getParcelable(C2811j1.m3274d(8)), c2811j2.f7153u);
            bVar.f7172j = (String) C2811j1.m3273b(bundle.getString(C2811j1.m3274d(9)), c2811j2.f7154v);
            bVar.f7173k = (String) C2811j1.m3273b(bundle.getString(C2811j1.m3274d(10)), c2811j2.f7155w);
            bVar.f7174l = bundle.getInt(C2811j1.m3274d(11), c2811j2.f7156x);
            ArrayList arrayList = new ArrayList();
            while (true) {
                String strM3274d = C2811j1.m3274d(12);
                String string2 = Integer.toString(i2, 36);
                StringBuilder sb = new StringBuilder(String.valueOf(string2).length() + String.valueOf(strM3274d).length() + 1);
                sb.append(strM3274d);
                sb.append("_");
                sb.append(string2);
                byte[] byteArray = bundle.getByteArray(sb.toString());
                if (byteArray == null) {
                    bVar.f7175m = arrayList;
                    bVar.f7176n = (DrmInitData) bundle.getParcelable(C2811j1.m3274d(13));
                    String strM3274d2 = C2811j1.m3274d(14);
                    C2811j1 c2811j3 = C2811j1.f7125j;
                    bVar.f7177o = bundle.getLong(strM3274d2, c2811j3.f7127A);
                    bVar.f7178p = bundle.getInt(C2811j1.m3274d(15), c2811j3.f7128B);
                    bVar.f7179q = bundle.getInt(C2811j1.m3274d(16), c2811j3.f7129C);
                    bVar.f7180r = bundle.getFloat(C2811j1.m3274d(17), c2811j3.f7130D);
                    bVar.f7181s = bundle.getInt(C2811j1.m3274d(18), c2811j3.f7131E);
                    bVar.f7182t = bundle.getFloat(C2811j1.m3274d(19), c2811j3.f7132F);
                    bVar.f7183u = bundle.getByteArray(C2811j1.m3274d(20));
                    bVar.f7184v = bundle.getInt(C2811j1.m3274d(21), c2811j3.f7134H);
                    int i3 = C2777n.f6843j;
                    bVar.f7185w = (C2777n) C2739f.m3021c(new InterfaceC2963w0.a() { // from class: b.i.a.c.g3.a
                        @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
                        /* JADX INFO: renamed from: a */
                        public final InterfaceC2963w0 mo2576a(Bundle bundle2) {
                            return new C2777n(bundle2.getInt(C2777n.m3125c(0), -1), bundle2.getInt(C2777n.m3125c(1), -1), bundle2.getInt(C2777n.m3125c(2), -1), bundle2.getByteArray(C2777n.m3125c(3)));
                        }
                    }, bundle.getBundle(C2811j1.m3274d(22)));
                    bVar.f7186x = bundle.getInt(C2811j1.m3274d(23), c2811j3.f7136J);
                    bVar.f7187y = bundle.getInt(C2811j1.m3274d(24), c2811j3.f7137K);
                    bVar.f7188z = bundle.getInt(C2811j1.m3274d(25), c2811j3.f7138L);
                    bVar.f7159A = bundle.getInt(C2811j1.m3274d(26), c2811j3.f7139M);
                    bVar.f7160B = bundle.getInt(C2811j1.m3274d(27), c2811j3.f7140N);
                    bVar.f7161C = bundle.getInt(C2811j1.m3274d(28), c2811j3.f7141O);
                    bVar.f7162D = bundle.getInt(C2811j1.m3274d(29), c2811j3.f7142P);
                    return bVar.m3277a();
                }
                arrayList.add(byteArray);
                i2++;
            }
        }
    };

    /* JADX INFO: renamed from: A */
    public final long f7127A;

    /* JADX INFO: renamed from: B */
    public final int f7128B;

    /* JADX INFO: renamed from: C */
    public final int f7129C;

    /* JADX INFO: renamed from: D */
    public final float f7130D;

    /* JADX INFO: renamed from: E */
    public final int f7131E;

    /* JADX INFO: renamed from: F */
    public final float f7132F;

    /* JADX INFO: renamed from: G */
    @Nullable
    public final byte[] f7133G;

    /* JADX INFO: renamed from: H */
    public final int f7134H;

    /* JADX INFO: renamed from: I */
    @Nullable
    public final C2777n f7135I;

    /* JADX INFO: renamed from: J */
    public final int f7136J;

    /* JADX INFO: renamed from: K */
    public final int f7137K;

    /* JADX INFO: renamed from: L */
    public final int f7138L;

    /* JADX INFO: renamed from: M */
    public final int f7139M;

    /* JADX INFO: renamed from: N */
    public final int f7140N;

    /* JADX INFO: renamed from: O */
    public final int f7141O;

    /* JADX INFO: renamed from: P */
    public final int f7142P;

    /* JADX INFO: renamed from: Q */
    public int f7143Q;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f7144l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f7145m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final String f7146n;

    /* JADX INFO: renamed from: o */
    public final int f7147o;

    /* JADX INFO: renamed from: p */
    public final int f7148p;

    /* JADX INFO: renamed from: q */
    public final int f7149q;

    /* JADX INFO: renamed from: r */
    public final int f7150r;

    /* JADX INFO: renamed from: s */
    public final int f7151s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public final String f7152t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public final Metadata f7153u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public final String f7154v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public final String f7155w;

    /* JADX INFO: renamed from: x */
    public final int f7156x;

    /* JADX INFO: renamed from: y */
    public final List<byte[]> f7157y;

    /* JADX INFO: renamed from: z */
    @Nullable
    public final DrmInitData f7158z;

    public C2811j1(b bVar, a aVar) {
        this.f7144l = bVar.f7163a;
        this.f7145m = bVar.f7164b;
        this.f7146n = C2738e0.m2982C(bVar.f7165c);
        this.f7147o = bVar.f7166d;
        this.f7148p = bVar.f7167e;
        int i = bVar.f7168f;
        this.f7149q = i;
        int i2 = bVar.f7169g;
        this.f7150r = i2;
        this.f7151s = i2 != -1 ? i2 : i;
        this.f7152t = bVar.f7170h;
        this.f7153u = bVar.f7171i;
        this.f7154v = bVar.f7172j;
        this.f7155w = bVar.f7173k;
        this.f7156x = bVar.f7174l;
        List<byte[]> list = bVar.f7175m;
        this.f7157y = list == null ? Collections.emptyList() : list;
        DrmInitData drmInitData = bVar.f7176n;
        this.f7158z = drmInitData;
        this.f7127A = bVar.f7177o;
        this.f7128B = bVar.f7178p;
        this.f7129C = bVar.f7179q;
        this.f7130D = bVar.f7180r;
        int i3 = bVar.f7181s;
        this.f7131E = i3 == -1 ? 0 : i3;
        float f = bVar.f7182t;
        this.f7132F = f == -1.0f ? 1.0f : f;
        this.f7133G = bVar.f7183u;
        this.f7134H = bVar.f7184v;
        this.f7135I = bVar.f7185w;
        this.f7136J = bVar.f7186x;
        this.f7137K = bVar.f7187y;
        this.f7138L = bVar.f7188z;
        int i4 = bVar.f7159A;
        this.f7139M = i4 == -1 ? 0 : i4;
        int i5 = bVar.f7160B;
        this.f7140N = i5 != -1 ? i5 : 0;
        this.f7141O = bVar.f7161C;
        int i6 = bVar.f7162D;
        if (i6 != 0 || drmInitData == null) {
            this.f7142P = i6;
        } else {
            this.f7142P = 1;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static <T> T m3273b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    /* JADX INFO: renamed from: d */
    public static String m3274d(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: renamed from: a */
    public b m3275a() {
        return new b(this, null);
    }

    /* JADX INFO: renamed from: c */
    public boolean m3276c(C2811j1 c2811j1) {
        if (this.f7157y.size() != c2811j1.f7157y.size()) {
            return false;
        }
        for (int i = 0; i < this.f7157y.size(); i++) {
            if (!Arrays.equals(this.f7157y.get(i), c2811j1.f7157y.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || C2811j1.class != obj.getClass()) {
            return false;
        }
        C2811j1 c2811j1 = (C2811j1) obj;
        int i2 = this.f7143Q;
        return (i2 == 0 || (i = c2811j1.f7143Q) == 0 || i2 == i) && this.f7147o == c2811j1.f7147o && this.f7148p == c2811j1.f7148p && this.f7149q == c2811j1.f7149q && this.f7150r == c2811j1.f7150r && this.f7156x == c2811j1.f7156x && this.f7127A == c2811j1.f7127A && this.f7128B == c2811j1.f7128B && this.f7129C == c2811j1.f7129C && this.f7131E == c2811j1.f7131E && this.f7134H == c2811j1.f7134H && this.f7136J == c2811j1.f7136J && this.f7137K == c2811j1.f7137K && this.f7138L == c2811j1.f7138L && this.f7139M == c2811j1.f7139M && this.f7140N == c2811j1.f7140N && this.f7141O == c2811j1.f7141O && this.f7142P == c2811j1.f7142P && Float.compare(this.f7130D, c2811j1.f7130D) == 0 && Float.compare(this.f7132F, c2811j1.f7132F) == 0 && C2738e0.m2993a(this.f7144l, c2811j1.f7144l) && C2738e0.m2993a(this.f7145m, c2811j1.f7145m) && C2738e0.m2993a(this.f7152t, c2811j1.f7152t) && C2738e0.m2993a(this.f7154v, c2811j1.f7154v) && C2738e0.m2993a(this.f7155w, c2811j1.f7155w) && C2738e0.m2993a(this.f7146n, c2811j1.f7146n) && Arrays.equals(this.f7133G, c2811j1.f7133G) && C2738e0.m2993a(this.f7153u, c2811j1.f7153u) && C2738e0.m2993a(this.f7135I, c2811j1.f7135I) && C2738e0.m2993a(this.f7158z, c2811j1.f7158z) && m3276c(c2811j1);
    }

    public int hashCode() {
        if (this.f7143Q == 0) {
            String str = this.f7144l;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f7145m;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f7146n;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f7147o) * 31) + this.f7148p) * 31) + this.f7149q) * 31) + this.f7150r) * 31;
            String str4 = this.f7152t;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f7153u;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f7154v;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f7155w;
            this.f7143Q = ((((((((((((((((Float.floatToIntBits(this.f7132F) + ((((Float.floatToIntBits(this.f7130D) + ((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f7156x) * 31) + ((int) this.f7127A)) * 31) + this.f7128B) * 31) + this.f7129C) * 31)) * 31) + this.f7131E) * 31)) * 31) + this.f7134H) * 31) + this.f7136J) * 31) + this.f7137K) * 31) + this.f7138L) * 31) + this.f7139M) * 31) + this.f7140N) * 31) + this.f7141O) * 31) + this.f7142P;
        }
        return this.f7143Q;
    }

    public String toString() {
        String str = this.f7144l;
        String str2 = this.f7145m;
        String str3 = this.f7154v;
        String str4 = this.f7155w;
        String str5 = this.f7152t;
        int i = this.f7151s;
        String str6 = this.f7146n;
        int i2 = this.f7128B;
        int i3 = this.f7129C;
        float f = this.f7130D;
        int i4 = this.f7136J;
        int i5 = this.f7137K;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str6, C1643a.m841b(str5, C1643a.m841b(str4, C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 104)))))), "Format(", str, ", ", str2);
        C1643a.m876s0(sbM831S, ", ", str3, ", ", str4);
        sbM831S.append(", ");
        sbM831S.append(str5);
        sbM831S.append(", ");
        sbM831S.append(i);
        sbM831S.append(", ");
        sbM831S.append(str6);
        sbM831S.append(", [");
        sbM831S.append(i2);
        sbM831S.append(", ");
        sbM831S.append(i3);
        sbM831S.append(", ");
        sbM831S.append(f);
        sbM831S.append("], [");
        sbM831S.append(i4);
        sbM831S.append(", ");
        sbM831S.append(i5);
        sbM831S.append("])");
        return sbM831S.toString();
    }

    /* JADX INFO: renamed from: b.i.a.c.j1$b */
    /* JADX INFO: compiled from: Format.java */
    public static final class b {

        /* JADX INFO: renamed from: A */
        public int f7159A;

        /* JADX INFO: renamed from: B */
        public int f7160B;

        /* JADX INFO: renamed from: C */
        public int f7161C;

        /* JADX INFO: renamed from: D */
        public int f7162D;

        /* JADX INFO: renamed from: a */
        @Nullable
        public String f7163a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public String f7164b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public String f7165c;

        /* JADX INFO: renamed from: d */
        public int f7166d;

        /* JADX INFO: renamed from: e */
        public int f7167e;

        /* JADX INFO: renamed from: f */
        public int f7168f;

        /* JADX INFO: renamed from: g */
        public int f7169g;

        /* JADX INFO: renamed from: h */
        @Nullable
        public String f7170h;

        /* JADX INFO: renamed from: i */
        @Nullable
        public Metadata f7171i;

        /* JADX INFO: renamed from: j */
        @Nullable
        public String f7172j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f7173k;

        /* JADX INFO: renamed from: l */
        public int f7174l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public List<byte[]> f7175m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public DrmInitData f7176n;

        /* JADX INFO: renamed from: o */
        public long f7177o;

        /* JADX INFO: renamed from: p */
        public int f7178p;

        /* JADX INFO: renamed from: q */
        public int f7179q;

        /* JADX INFO: renamed from: r */
        public float f7180r;

        /* JADX INFO: renamed from: s */
        public int f7181s;

        /* JADX INFO: renamed from: t */
        public float f7182t;

        /* JADX INFO: renamed from: u */
        @Nullable
        public byte[] f7183u;

        /* JADX INFO: renamed from: v */
        public int f7184v;

        /* JADX INFO: renamed from: w */
        @Nullable
        public C2777n f7185w;

        /* JADX INFO: renamed from: x */
        public int f7186x;

        /* JADX INFO: renamed from: y */
        public int f7187y;

        /* JADX INFO: renamed from: z */
        public int f7188z;

        public b() {
            this.f7168f = -1;
            this.f7169g = -1;
            this.f7174l = -1;
            this.f7177o = RecyclerView.FOREVER_NS;
            this.f7178p = -1;
            this.f7179q = -1;
            this.f7180r = -1.0f;
            this.f7182t = 1.0f;
            this.f7184v = -1;
            this.f7186x = -1;
            this.f7187y = -1;
            this.f7188z = -1;
            this.f7161C = -1;
            this.f7162D = 0;
        }

        /* JADX INFO: renamed from: a */
        public C2811j1 m3277a() {
            return new C2811j1(this, null);
        }

        /* JADX INFO: renamed from: b */
        public b m3278b(int i) {
            this.f7163a = Integer.toString(i);
            return this;
        }

        public b(C2811j1 c2811j1, a aVar) {
            this.f7163a = c2811j1.f7144l;
            this.f7164b = c2811j1.f7145m;
            this.f7165c = c2811j1.f7146n;
            this.f7166d = c2811j1.f7147o;
            this.f7167e = c2811j1.f7148p;
            this.f7168f = c2811j1.f7149q;
            this.f7169g = c2811j1.f7150r;
            this.f7170h = c2811j1.f7152t;
            this.f7171i = c2811j1.f7153u;
            this.f7172j = c2811j1.f7154v;
            this.f7173k = c2811j1.f7155w;
            this.f7174l = c2811j1.f7156x;
            this.f7175m = c2811j1.f7157y;
            this.f7176n = c2811j1.f7158z;
            this.f7177o = c2811j1.f7127A;
            this.f7178p = c2811j1.f7128B;
            this.f7179q = c2811j1.f7129C;
            this.f7180r = c2811j1.f7130D;
            this.f7181s = c2811j1.f7131E;
            this.f7182t = c2811j1.f7132F;
            this.f7183u = c2811j1.f7133G;
            this.f7184v = c2811j1.f7134H;
            this.f7185w = c2811j1.f7135I;
            this.f7186x = c2811j1.f7136J;
            this.f7187y = c2811j1.f7137K;
            this.f7188z = c2811j1.f7138L;
            this.f7159A = c2811j1.f7139M;
            this.f7160B = c2811j1.f7140N;
            this.f7161C = c2811j1.f7141O;
            this.f7162D = c2811j1.f7142P;
        }
    }
}
