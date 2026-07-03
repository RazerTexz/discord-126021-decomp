package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2807i1;

/* JADX INFO: renamed from: b.i.a.c.e3.n */
/* JADX INFO: compiled from: DataSpec.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2712n {

    /* JADX INFO: renamed from: a */
    public final Uri f6542a;

    /* JADX INFO: renamed from: b */
    public final long f6543b;

    /* JADX INFO: renamed from: c */
    public final int f6544c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final byte[] f6545d;

    /* JADX INFO: renamed from: e */
    public final Map<String, String> f6546e;

    /* JADX INFO: renamed from: f */
    public final long f6547f;

    /* JADX INFO: renamed from: g */
    public final long f6548g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public final String f6549h;

    /* JADX INFO: renamed from: i */
    public final int f6550i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public final Object f6551j;

    /* JADX INFO: renamed from: b.i.a.c.e3.n$b */
    /* JADX INFO: compiled from: DataSpec.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        @Nullable
        public Uri f6552a;

        /* JADX INFO: renamed from: b */
        public long f6553b;

        /* JADX INFO: renamed from: c */
        public int f6554c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public byte[] f6555d;

        /* JADX INFO: renamed from: e */
        public Map<String, String> f6556e;

        /* JADX INFO: renamed from: f */
        public long f6557f;

        /* JADX INFO: renamed from: g */
        public long f6558g;

        /* JADX INFO: renamed from: h */
        @Nullable
        public String f6559h;

        /* JADX INFO: renamed from: i */
        public int f6560i;

        /* JADX INFO: renamed from: j */
        @Nullable
        public Object f6561j;

        public b(C2712n c2712n, a aVar) {
            this.f6552a = c2712n.f6542a;
            this.f6553b = c2712n.f6543b;
            this.f6554c = c2712n.f6544c;
            this.f6555d = c2712n.f6545d;
            this.f6556e = c2712n.f6546e;
            this.f6557f = c2712n.f6547f;
            this.f6558g = c2712n.f6548g;
            this.f6559h = c2712n.f6549h;
            this.f6560i = c2712n.f6550i;
            this.f6561j = c2712n.f6551j;
        }

        /* JADX INFO: renamed from: a */
        public C2712n m2857a() {
            if (this.f6552a != null) {
                return new C2712n(this.f6552a, this.f6553b, this.f6554c, this.f6555d, this.f6556e, this.f6557f, this.f6558g, this.f6559h, this.f6560i, this.f6561j);
            }
            throw new IllegalStateException("The uri must be set.");
        }
    }

    static {
        C2807i1.m3272a("goog.exo.datasource");
    }

    public C2712n(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        boolean z2 = true;
        C1460d.m531j(j + j2 >= 0);
        C1460d.m531j(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z2 = false;
        }
        C1460d.m531j(z2);
        this.f6542a = uri;
        this.f6543b = j;
        this.f6544c = i;
        this.f6545d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f6546e = Collections.unmodifiableMap(new HashMap(map));
        this.f6547f = j2;
        this.f6548g = j3;
        this.f6549h = str;
        this.f6550i = i2;
        this.f6551j = obj;
    }

    /* JADX INFO: renamed from: b */
    public static String m2854b(int i) {
        if (i == 1) {
            return ShareTarget.METHOD_GET;
        }
        if (i == 2) {
            return ShareTarget.METHOD_POST;
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: a */
    public b m2855a() {
        return new b(this, null);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2856c(int i) {
        return (this.f6550i & i) == i;
    }

    public String toString() {
        String strM2854b = m2854b(this.f6544c);
        String strValueOf = String.valueOf(this.f6542a);
        long j = this.f6547f;
        long j2 = this.f6548g;
        String str = this.f6549h;
        int i = this.f6550i;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str, strValueOf.length() + strM2854b.length() + 70), "DataSpec[", strM2854b, " ", strValueOf);
        sbM831S.append(", ");
        sbM831S.append(j);
        sbM831S.append(", ");
        sbM831S.append(j2);
        sbM831S.append(", ");
        sbM831S.append(str);
        sbM831S.append(", ");
        sbM831S.append(i);
        sbM831S.append("]");
        return sbM831S.toString();
    }
}
