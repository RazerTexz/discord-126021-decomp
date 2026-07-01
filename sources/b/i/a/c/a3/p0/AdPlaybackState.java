package b.i.a.c.a3.p0;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Bundleable;
import b.i.a.c.a3.p0.AdPlaybackState;
import b.i.a.c.f3.Util2;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.a3.p0.c, reason: use source file name */
/* JADX INFO: compiled from: AdPlaybackState.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AdPlaybackState implements Bundleable {
    public static final AdPlaybackState j = new AdPlaybackState(null, new a[0], 0, -9223372036854775807L, 0);
    public static final a k;
    public static final Bundleable.a<AdPlaybackState> l;

    @Nullable
    public final Object m = null;
    public final int n;
    public final long o;
    public final long p;
    public final int q;
    public final a[] r;

    /* JADX INFO: renamed from: b.i.a.c.a3.p0.c$a */
    /* JADX INFO: compiled from: AdPlaybackState.java */
    public static final class a implements Bundleable {
        public static final /* synthetic */ int j = 0;
        public final long k;
        public final int l;
        public final Uri[] m;
        public final int[] n;
        public final long[] o;
        public final long p;
        public final boolean q;

        public a(long j2, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j3, boolean z2) {
            AnimatableValueParser.j(iArr.length == uriArr.length);
            this.k = j2;
            this.l = i;
            this.n = iArr;
            this.m = uriArr;
            this.o = jArr;
            this.p = j3;
            this.q = z2;
        }

        public static String c(int i) {
            return Integer.toString(i, 36);
        }

        public int a(@IntRange(from = -1) int i) {
            int i2 = i + 1;
            while (true) {
                int[] iArr = this.n;
                if (i2 >= iArr.length || this.q || iArr[i2] == 0 || iArr[i2] == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        public boolean b() {
            if (this.l == -1) {
                return true;
            }
            for (int i = 0; i < this.l; i++) {
                int[] iArr = this.n;
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
            return this.k == aVar.k && this.l == aVar.l && Arrays.equals(this.m, aVar.m) && Arrays.equals(this.n, aVar.n) && Arrays.equals(this.o, aVar.o) && this.p == aVar.p && this.q == aVar.q;
        }

        public int hashCode() {
            int i = this.l * 31;
            long j2 = this.k;
            int iHashCode = (Arrays.hashCode(this.o) + ((Arrays.hashCode(this.n) + ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.m)) * 31)) * 31)) * 31;
            long j3 = this.p;
            return ((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.q ? 1 : 0);
        }
    }

    static {
        a aVar = new a(0L, -1, new int[0], new Uri[0], new long[0], 0L, false);
        int[] iArr = aVar.n;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = aVar.o;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        k = new a(aVar.k, 0, iArrCopyOf, (Uri[]) Arrays.copyOf(aVar.m, 0), jArrCopyOf, aVar.p, aVar.q);
        l = new Bundleable.a() { // from class: b.i.a.c.a3.p0.b
            @Override // b.i.a.c.Bundleable.a
            public final Bundleable a(Bundle bundle) {
                AdPlaybackState.a[] aVarArr;
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(AdPlaybackState.b(1));
                if (parcelableArrayList == null) {
                    aVarArr = new AdPlaybackState.a[0];
                } else {
                    AdPlaybackState.a[] aVarArr2 = new AdPlaybackState.a[parcelableArrayList.size()];
                    for (int i = 0; i < parcelableArrayList.size(); i++) {
                        int i2 = AdPlaybackState.a.j;
                        aVarArr2[i] = (AdPlaybackState.a) a.a.a((Bundle) parcelableArrayList.get(i));
                    }
                    aVarArr = aVarArr2;
                }
                return new AdPlaybackState(null, aVarArr, bundle.getLong(AdPlaybackState.b(2), 0L), bundle.getLong(AdPlaybackState.b(3), -9223372036854775807L), bundle.getInt(AdPlaybackState.b(4)));
            }
        };
    }

    public AdPlaybackState(@Nullable Object obj, a[] aVarArr, long j2, long j3, int i) {
        this.o = j2;
        this.p = j3;
        this.n = aVarArr.length + i;
        this.r = aVarArr;
        this.q = i;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public a a(@IntRange(from = 0) int i) {
        int i2 = this.q;
        return i < i2 ? k : this.r[i - i2];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        return Util2.a(this.m, adPlaybackState.m) && this.n == adPlaybackState.n && this.o == adPlaybackState.o && this.p == adPlaybackState.p && this.q == adPlaybackState.q && Arrays.equals(this.r, adPlaybackState.r);
    }

    public int hashCode() {
        int i = this.n * 31;
        Object obj = this.m;
        return ((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.o)) * 31) + ((int) this.p)) * 31) + this.q) * 31) + Arrays.hashCode(this.r);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AdPlaybackState(adsId=");
        sbU.append(this.m);
        sbU.append(", adResumePositionUs=");
        sbU.append(this.o);
        sbU.append(", adGroups=[");
        for (int i = 0; i < this.r.length; i++) {
            sbU.append("adGroup(timeUs=");
            sbU.append(this.r[i].k);
            sbU.append(", ads=[");
            for (int i2 = 0; i2 < this.r[i].n.length; i2++) {
                sbU.append("ad(state=");
                int i3 = this.r[i].n[i2];
                if (i3 == 0) {
                    sbU.append('_');
                } else if (i3 == 1) {
                    sbU.append('R');
                } else if (i3 == 2) {
                    sbU.append('S');
                } else if (i3 == 3) {
                    sbU.append('P');
                } else if (i3 != 4) {
                    sbU.append('?');
                } else {
                    sbU.append('!');
                }
                sbU.append(", durationUs=");
                sbU.append(this.r[i].o[i2]);
                sbU.append(')');
                if (i2 < this.r[i].n.length - 1) {
                    sbU.append(", ");
                }
            }
            sbU.append("])");
            if (i < this.r.length - 1) {
                sbU.append(", ");
            }
        }
        sbU.append("])");
        return sbU.toString();
    }
}
