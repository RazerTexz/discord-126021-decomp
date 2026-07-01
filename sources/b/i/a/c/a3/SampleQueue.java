package b.i.a.c.a3;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.a3.SampleDataQueue;
import b.i.a.c.a3.SampleQueue;
import b.i.a.c.e3.Allocation;
import b.i.a.c.e3.DataReader;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.f3.Consumer3;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.DrmSessionEventListener;
import b.i.a.c.w2.DrmSessionManager2;
import b.i.a.c.x2.TrackOutput;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.h0, reason: use source file name */
/* JADX INFO: compiled from: SampleQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class SampleQueue implements TrackOutput2 {

    @Nullable
    public Format2 A;

    @Nullable
    public Format2 B;
    public boolean C;
    public boolean D;
    public final SampleDataQueue a;

    @Nullable
    public final DrmSessionManager2 d;

    @Nullable
    public final DrmSessionEventListener.a e;

    @Nullable
    public final Looper f;

    @Nullable
    public d g;

    @Nullable
    public Format2 h;

    @Nullable
    public DrmSession i;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f820s;
    public int t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f821x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f819b = new b();
    public int j = 1000;
    public int[] k = new int[1000];
    public long[] l = new long[1000];
    public long[] o = new long[1000];
    public int[] n = new int[1000];
    public int[] m = new int[1000];
    public TrackOutput2.a[] p = new TrackOutput2.a[1000];
    public final SpannedData<c> c = new SpannedData<>(new Consumer3() { // from class: b.i.a.c.a3.k
        @Override // b.i.a.c.f3.Consumer3
        public final void accept(Object obj) {
            ((SampleQueue.c) obj).f825b.release();
        }
    });
    public long u = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public long w = Long.MIN_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f823z = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f822y = true;

    /* JADX INFO: renamed from: b.i.a.c.a3.h0$b */
    /* JADX INFO: compiled from: SampleQueue.java */
    public static final class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f824b;

        @Nullable
        public TrackOutput2.a c;
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.h0$c */
    /* JADX INFO: compiled from: SampleQueue.java */
    public static final class c {
        public final Format2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DrmSessionManager2.b f825b;

        public c(Format2 format2, DrmSessionManager2.b bVar, a aVar) {
            this.a = format2;
            this.f825b = bVar;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.h0$d */
    /* JADX INFO: compiled from: SampleQueue.java */
    public interface d {
    }

    public SampleQueue(DefaultAllocator defaultAllocator, @Nullable Looper looper, @Nullable DrmSessionManager2 drmSessionManager2, @Nullable DrmSessionEventListener.a aVar) {
        this.f = looper;
        this.d = drmSessionManager2;
        this.e = aVar;
        this.a = new SampleDataQueue(defaultAllocator);
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public final int a(DataReader dataReader, int i, boolean z2, int i2) throws IOException {
        SampleDataQueue sampleDataQueue = this.a;
        int iC = sampleDataQueue.c(i);
        SampleDataQueue.a aVar = sampleDataQueue.f;
        int i3 = dataReader.read(aVar.d.a, aVar.a(sampleDataQueue.g), iC);
        if (i3 != -1) {
            sampleDataQueue.b(i3);
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public /* synthetic */ int b(DataReader dataReader, int i, boolean z2) {
        return TrackOutput.a(this, dataReader, i, z2);
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i) {
        TrackOutput.b(this, parsableByteArray, i);
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public void d(long j, int i, int i2, int i3, @Nullable TrackOutput2.a aVar) {
        DrmSessionManager2.b bVarB;
        int i4 = i & 1;
        boolean z2 = i4 != 0;
        if (this.f822y) {
            if (!z2) {
                return;
            } else {
                this.f822y = false;
            }
        }
        long j2 = j + 0;
        if (this.C) {
            if (j2 < this.u) {
                return;
            }
            if (i4 == 0) {
                if (!this.D) {
                    String strValueOf = String.valueOf(this.B);
                    outline.h0(strValueOf.length() + 50, "Overriding unexpected non-sync sample for format: ", strValueOf, "SampleQueue");
                    this.D = true;
                }
                i |= 1;
            }
        }
        long j3 = (this.a.g - ((long) i2)) - ((long) i3);
        synchronized (this) {
            int i5 = this.q;
            if (i5 > 0) {
                int iL = l(i5 - 1);
                AnimatableValueParser.j(this.l[iL] + ((long) this.m[iL]) <= j3);
            }
            this.f821x = (536870912 & i) != 0;
            this.w = Math.max(this.w, j2);
            int iL2 = l(this.q);
            this.o[iL2] = j2;
            this.l[iL2] = j3;
            this.m[iL2] = i2;
            this.n[iL2] = i;
            this.p[iL2] = aVar;
            this.k[iL2] = 0;
            if ((this.c.f829b.size() == 0) || !this.c.c().a.equals(this.B)) {
                DrmSessionManager2 drmSessionManager2 = this.d;
                if (drmSessionManager2 != null) {
                    Looper looper = this.f;
                    Objects.requireNonNull(looper);
                    bVarB = drmSessionManager2.b(looper, this.e, this.B);
                } else {
                    bVarB = b.i.a.c.w2.m.f1153b;
                }
                SpannedData<c> spannedData = this.c;
                int iN = n();
                Format2 format2 = this.B;
                Objects.requireNonNull(format2);
                spannedData.a(iN, new c(format2, bVarB, null));
            }
            int i6 = this.q + 1;
            this.q = i6;
            int i7 = this.j;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                int[] iArr = new int[i8];
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                int[] iArr2 = new int[i8];
                int[] iArr3 = new int[i8];
                TrackOutput2.a[] aVarArr = new TrackOutput2.a[i8];
                int i9 = this.f820s;
                int i10 = i7 - i9;
                System.arraycopy(this.l, i9, jArr, 0, i10);
                System.arraycopy(this.o, this.f820s, jArr2, 0, i10);
                System.arraycopy(this.n, this.f820s, iArr2, 0, i10);
                System.arraycopy(this.m, this.f820s, iArr3, 0, i10);
                System.arraycopy(this.p, this.f820s, aVarArr, 0, i10);
                System.arraycopy(this.k, this.f820s, iArr, 0, i10);
                int i11 = this.f820s;
                System.arraycopy(this.l, 0, jArr, i10, i11);
                System.arraycopy(this.o, 0, jArr2, i10, i11);
                System.arraycopy(this.n, 0, iArr2, i10, i11);
                System.arraycopy(this.m, 0, iArr3, i10, i11);
                System.arraycopy(this.p, 0, aVarArr, i10, i11);
                System.arraycopy(this.k, 0, iArr, i10, i11);
                this.l = jArr;
                this.o = jArr2;
                this.n = iArr2;
                this.m = iArr3;
                this.p = aVarArr;
                this.k = iArr;
                this.f820s = 0;
                this.j = i8;
            }
        }
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public final void e(Format2 format2) {
        boolean z2;
        this.A = format2;
        synchronized (this) {
            z2 = false;
            this.f823z = false;
            if (!Util2.a(format2, this.B)) {
                if ((this.c.f829b.size() == 0) || !this.c.c().a.equals(format2)) {
                    this.B = format2;
                } else {
                    this.B = this.c.c().a;
                }
                Format2 format3 = this.B;
                this.C = MimeTypes.a(format3.w, format3.t);
                this.D = false;
                z2 = true;
            }
        }
        d dVar = this.g;
        if (dVar == null || !z2) {
            return;
        }
        ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) dVar;
        progressiveMediaPeriod.A.post(progressiveMediaPeriod.f811y);
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public final void f(ParsableByteArray parsableByteArray, int i, int i2) {
        SampleDataQueue sampleDataQueue = this.a;
        Objects.requireNonNull(sampleDataQueue);
        while (i > 0) {
            int iC = sampleDataQueue.c(i);
            SampleDataQueue.a aVar = sampleDataQueue.f;
            parsableByteArray.e(aVar.d.a, aVar.a(sampleDataQueue.g), iC);
            i -= iC;
            sampleDataQueue.b(iC);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @GuardedBy("this")
    public final long g(int i) {
        this.v = Math.max(this.v, j(i));
        this.q -= i;
        int i2 = this.r + i;
        this.r = i2;
        int i3 = this.f820s + i;
        this.f820s = i3;
        int i4 = this.j;
        if (i3 >= i4) {
            this.f820s = i3 - i4;
        }
        int i5 = this.t - i;
        this.t = i5;
        int i6 = 0;
        if (i5 < 0) {
            this.t = 0;
        }
        SpannedData<c> spannedData = this.c;
        while (i6 < spannedData.f829b.size() - 1) {
            int i7 = i6 + 1;
            if (i2 < spannedData.f829b.keyAt(i7)) {
                break;
            }
            spannedData.c.accept((V) spannedData.f829b.valueAt(i6));
            spannedData.f829b.removeAt(i6);
            int i8 = spannedData.a;
            if (i8 > 0) {
                spannedData.a = i8 - 1;
            }
            i6 = i7;
        }
        if (this.q != 0) {
            return this.l[this.f820s];
        }
        int i9 = this.f820s;
        if (i9 == 0) {
            i9 = this.j;
        }
        int i10 = i9 - 1;
        return this.l[i10] + ((long) this.m[i10]);
    }

    public final void h() {
        long jG;
        SampleDataQueue sampleDataQueue = this.a;
        synchronized (this) {
            int i = this.q;
            jG = i == 0 ? -1L : g(i);
        }
        sampleDataQueue.a(jG);
    }

    public final int i(int i, int i2, long j, boolean z2) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long[] jArr = this.o;
            if (jArr[i] > j) {
                return i3;
            }
            if (!z2 || (this.n[i] & 1) != 0) {
                if (jArr[i] == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.j) {
                i = 0;
            }
        }
        return i3;
    }

    public final long j(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iL = l(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.o[iL]);
            if ((this.n[iL] & 1) != 0) {
                break;
            }
            iL--;
            if (iL == -1) {
                iL = this.j - 1;
            }
        }
        return jMax;
    }

    public final int k() {
        return this.r + this.t;
    }

    public final int l(int i) {
        int i2 = this.f820s + i;
        int i3 = this.j;
        return i2 < i3 ? i2 : i2 - i3;
    }

    @Nullable
    public final synchronized Format2 m() {
        return this.f823z ? null : this.B;
    }

    public final int n() {
        return this.r + this.q;
    }

    public final boolean o() {
        return this.t != this.q;
    }

    @CallSuper
    public synchronized boolean p(boolean z2) {
        Format2 format2;
        boolean z3 = true;
        if (o()) {
            if (this.c.b(k()).a != this.h) {
                return true;
            }
            return q(l(this.t));
        }
        if (!z2 && !this.f821x && ((format2 = this.B) == null || format2 == this.h)) {
            z3 = false;
        }
        return z3;
    }

    public final boolean q(int i) {
        DrmSession drmSession = this.i;
        return drmSession == null || drmSession.getState() == 4 || ((this.n[i] & BasicMeasure.EXACTLY) == 0 && this.i.d());
    }

    public final void r(Format2 format2, FormatHolder formatHolder) {
        Format2 format2A;
        Format2 format3 = this.h;
        boolean z2 = format3 == null;
        DrmInitData drmInitData = z2 ? null : format3.f1020z;
        this.h = format2;
        DrmInitData drmInitData2 = format2.f1020z;
        DrmSessionManager2 drmSessionManager2 = this.d;
        if (drmSessionManager2 != null) {
            int iD = drmSessionManager2.d(format2);
            Format2.b bVarA = format2.a();
            bVarA.D = iD;
            format2A = bVarA.a();
        } else {
            format2A = format2;
        }
        formatHolder.f1027b = format2A;
        formatHolder.a = this.i;
        if (this.d == null) {
            return;
        }
        if (z2 || !Util2.a(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.i;
            DrmSessionManager2 drmSessionManager3 = this.d;
            Looper looper = this.f;
            Objects.requireNonNull(looper);
            DrmSession drmSessionC = drmSessionManager3.c(looper, this.e, format2);
            this.i = drmSessionC;
            formatHolder.a = drmSessionC;
            if (drmSession != null) {
                drmSession.b(this.e);
            }
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @CallSuper
    public void s(boolean z2) {
        SampleDataQueue sampleDataQueue = this.a;
        SampleDataQueue.a aVar = sampleDataQueue.d;
        if (aVar.c) {
            SampleDataQueue.a aVar2 = sampleDataQueue.f;
            int i = (((int) (aVar2.a - aVar.a)) / sampleDataQueue.f817b) + aVar2.c;
            Allocation[] allocationArr = new Allocation[i];
            int i2 = 0;
            while (i2 < i) {
                allocationArr[i2] = aVar.d;
                aVar.d = null;
                SampleDataQueue.a aVar3 = aVar.e;
                aVar.e = null;
                i2++;
                aVar = aVar3;
            }
            sampleDataQueue.a.a(allocationArr);
        }
        SampleDataQueue.a aVar4 = new SampleDataQueue.a(0L, sampleDataQueue.f817b);
        sampleDataQueue.d = aVar4;
        sampleDataQueue.e = aVar4;
        sampleDataQueue.f = aVar4;
        sampleDataQueue.g = 0L;
        sampleDataQueue.a.c();
        this.q = 0;
        this.r = 0;
        this.f820s = 0;
        this.t = 0;
        this.f822y = true;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = Long.MIN_VALUE;
        this.f821x = false;
        SpannedData<c> spannedData = this.c;
        for (int i3 = 0; i3 < spannedData.f829b.size(); i3++) {
            spannedData.c.accept((V) spannedData.f829b.valueAt(i3));
        }
        spannedData.a = -1;
        spannedData.f829b.clear();
        if (z2) {
            this.A = null;
            this.B = null;
            this.f823z = true;
        }
    }

    public final synchronized boolean t(long j, boolean z2) {
        synchronized (this) {
            this.t = 0;
            SampleDataQueue sampleDataQueue = this.a;
            sampleDataQueue.e = sampleDataQueue.d;
        }
        int iL = l(0);
        if (o() && j >= this.o[iL] && (j <= this.w || z2)) {
            int i = i(iL, this.q - this.t, j, true);
            if (i == -1) {
                return false;
            }
            this.u = j;
            this.t += i;
            return true;
        }
        return false;
    }
}
