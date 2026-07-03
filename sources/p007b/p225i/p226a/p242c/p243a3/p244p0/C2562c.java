package p007b.p225i.p226a.p242c.p243a3.p244p0;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p243a3.p244p0.C2562c;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.a3.p0.c */
/* JADX INFO: compiled from: AdPlaybackState.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2562c implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2562c f5680j = new C2562c(null, new a[0], 0, -9223372036854775807L, 0);

    /* JADX INFO: renamed from: k */
    public static final a f5681k;

    /* JADX INFO: renamed from: l */
    public static final InterfaceC2963w0.a<C2562c> f5682l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final Object f5683m = null;

    /* JADX INFO: renamed from: n */
    public final int f5684n;

    /* JADX INFO: renamed from: o */
    public final long f5685o;

    /* JADX INFO: renamed from: p */
    public final long f5686p;

    /* JADX INFO: renamed from: q */
    public final int f5687q;

    /* JADX INFO: renamed from: r */
    public final a[] f5688r;

    /* JADX INFO: renamed from: b.i.a.c.a3.p0.c$a */
    /* JADX INFO: compiled from: AdPlaybackState.java */
    public static final class a implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        public static final /* synthetic */ int f5689j = 0;

        /* JADX INFO: renamed from: k */
        public final long f5690k;

        /* JADX INFO: renamed from: l */
        public final int f5691l;

        /* JADX INFO: renamed from: m */
        public final Uri[] f5692m;

        /* JADX INFO: renamed from: n */
        public final int[] f5693n;

        /* JADX INFO: renamed from: o */
        public final long[] f5694o;

        /* JADX INFO: renamed from: p */
        public final long f5695p;

        /* JADX INFO: renamed from: q */
        public final boolean f5696q;

        public a(long j, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z2) {
            C1460d.m531j(iArr.length == uriArr.length);
            this.f5690k = j;
            this.f5691l = i;
            this.f5693n = iArr;
            this.f5692m = uriArr;
            this.f5694o = jArr;
            this.f5695p = j2;
            this.f5696q = z2;
        }

        /* JADX INFO: renamed from: c */
        public static String m2579c(int i) {
            return Integer.toString(i, 36);
        }

        /* JADX INFO: renamed from: a */
        public int m2580a(@IntRange(from = -1) int i) {
            int i2 = i + 1;
            while (true) {
                int[] iArr = this.f5693n;
                if (i2 >= iArr.length || this.f5696q || iArr[i2] == 0 || iArr[i2] == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        /* JADX INFO: renamed from: b */
        public boolean m2581b() {
            if (this.f5691l == -1) {
                return true;
            }
            for (int i = 0; i < this.f5691l; i++) {
                int[] iArr = this.f5693n;
                if (iArr[i] == 0 || iArr[i] == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5690k == aVar.f5690k && this.f5691l == aVar.f5691l && Arrays.equals(this.f5692m, aVar.f5692m) && Arrays.equals(this.f5693n, aVar.f5693n) && Arrays.equals(this.f5694o, aVar.f5694o) && this.f5695p == aVar.f5695p && this.f5696q == aVar.f5696q;
        }

        public int hashCode() {
            int i = this.f5691l * 31;
            long j = this.f5690k;
            int iHashCode = (Arrays.hashCode(this.f5694o) + ((Arrays.hashCode(this.f5693n) + ((((i + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.f5692m)) * 31)) * 31)) * 31;
            long j2 = this.f5695p;
            return ((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f5696q ? 1 : 0);
        }
    }

    static {
        a aVar = new a(0L, -1, new int[0], new Uri[0], new long[0], 0L, false);
        int[] iArr = aVar.f5693n;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = aVar.f5694o;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        f5681k = new a(aVar.f5690k, 0, iArrCopyOf, (Uri[]) Arrays.copyOf(aVar.f5692m, 0), jArrCopyOf, aVar.f5695p, aVar.f5696q);
        f5682l = new InterfaceC2963w0.a() { // from class: b.i.a.c.a3.p0.b
            @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
            /* JADX INFO: renamed from: a */
            public final InterfaceC2963w0 mo2576a(Bundle bundle) {
                C2562c.a[] aVarArr;
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(C2562c.m2577b(1));
                if (parcelableArrayList == null) {
                    aVarArr = new C2562c.a[0];
                } else {
                    C2562c.a[] aVarArr2 = new C2562c.a[parcelableArrayList.size()];
                    for (int i = 0; i < parcelableArrayList.size(); i++) {
                        int i2 = C2562c.a.f5689j;
                        aVarArr2[i] = (C2562c.a) C2560a.f5678a.mo2576a((Bundle) parcelableArrayList.get(i));
                    }
                    aVarArr = aVarArr2;
                }
                return new C2562c(null, aVarArr, bundle.getLong(C2562c.m2577b(2), 0L), bundle.getLong(C2562c.m2577b(3), -9223372036854775807L), bundle.getInt(C2562c.m2577b(4)));
            }
        };
    }

    public C2562c(@Nullable Object obj, a[] aVarArr, long j, long j2, int i) {
        this.f5685o = j;
        this.f5686p = j2;
        this.f5684n = aVarArr.length + i;
        this.f5688r = aVarArr;
        this.f5687q = i;
    }

    /* JADX INFO: renamed from: b */
    public static String m2577b(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: renamed from: a */
    public a m2578a(@IntRange(from = 0) int i) {
        int i2 = this.f5687q;
        return i < i2 ? f5681k : this.f5688r[i - i2];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2562c.class != obj.getClass()) {
            return false;
        }
        C2562c c2562c = (C2562c) obj;
        return C2738e0.m2993a(this.f5683m, c2562c.f5683m) && this.f5684n == c2562c.f5684n && this.f5685o == c2562c.f5685o && this.f5686p == c2562c.f5686p && this.f5687q == c2562c.f5687q && Arrays.equals(this.f5688r, c2562c.f5688r);
    }

    public int hashCode() {
        int i = this.f5684n * 31;
        Object obj = this.f5683m;
        return ((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f5685o)) * 31) + ((int) this.f5686p)) * 31) + this.f5687q) * 31) + Arrays.hashCode(this.f5688r);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AdPlaybackState(adsId=");
        sbM833U.append(this.f5683m);
        sbM833U.append(", adResumePositionUs=");
        sbM833U.append(this.f5685o);
        sbM833U.append(", adGroups=[");
        for (int i = 0; i < this.f5688r.length; i++) {
            sbM833U.append("adGroup(timeUs=");
            sbM833U.append(this.f5688r[i].f5690k);
            sbM833U.append(", ads=[");
            for (int i2 = 0; i2 < this.f5688r[i].f5693n.length; i2++) {
                sbM833U.append("ad(state=");
                int i3 = this.f5688r[i].f5693n[i2];
                if (i3 == 0) {
                    sbM833U.append('_');
                } else if (i3 == 1) {
                    sbM833U.append('R');
                } else if (i3 == 2) {
                    sbM833U.append('S');
                } else if (i3 == 3) {
                    sbM833U.append('P');
                } else if (i3 != 4) {
                    sbM833U.append('?');
                } else {
                    sbM833U.append('!');
                }
                sbM833U.append(", durationUs=");
                sbM833U.append(this.f5688r[i].f5694o[i2]);
                sbM833U.append(')');
                if (i2 < this.f5688r[i].f5693n.length - 1) {
                    sbM833U.append(", ");
                }
            }
            sbM833U.append("])");
            if (i < this.f5688r.length - 1) {
                sbM833U.append(", ");
            }
        }
        sbM833U.append("])");
        return sbM833U.toString();
    }
}
