package b.i.a.c.a3;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.SeekParameters;
import b.i.a.c.a3.IcyDataSource;
import b.i.a.c.a3.MediaPeriod;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.a3.SampleQueue;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.e3.DataReader;
import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.DefaultLoadErrorHandlingPolicy;
import b.i.a.c.e3.LoadErrorHandlingPolicy;
import b.i.a.c.e3.StatsDataSource;
import b.i.a.c.f3.ConditionVariable;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.DrmSessionEventListener;
import b.i.a.c.w2.DrmSessionManager2;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.h0.Mp3Extractor;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: b.i.a.c.a3.e0, reason: use source file name */
/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.b<a>, Loader.f, SampleQueue.d {
    public static final Map<String, String> j;
    public static final Format2 k;

    @Nullable
    public MediaPeriod.a B;

    @Nullable
    public IcyHeaders C;
    public boolean F;
    public boolean G;
    public boolean H;
    public e I;
    public SeekMap J;
    public boolean L;
    public boolean N;
    public boolean O;
    public int P;
    public long R;
    public boolean T;
    public int U;
    public boolean V;
    public boolean W;
    public final Uri l;
    public final DataSource3 m;
    public final DrmSessionManager2 n;
    public final LoadErrorHandlingPolicy o;
    public final MediaSourceEventListener.a p;
    public final DrmSessionEventListener.a q;
    public final b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DefaultAllocator f809s;

    @Nullable
    public final String t;
    public final long u;
    public final ProgressiveMediaExtractor w;
    public final Loader v = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConditionVariable f810x = new ConditionVariable();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f811y = new Runnable() { // from class: b.i.a.c.a3.g
        @Override // java.lang.Runnable
        public final void run() {
            this.j.x();
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Runnable f812z = new Runnable() { // from class: b.i.a.c.a3.i
        @Override // java.lang.Runnable
        public final void run() {
            ProgressiveMediaPeriod progressiveMediaPeriod = this.j;
            if (progressiveMediaPeriod.W) {
                return;
            }
            MediaPeriod.a aVar = progressiveMediaPeriod.B;
            Objects.requireNonNull(aVar);
            aVar.a(progressiveMediaPeriod);
        }
    };
    public final Handler A = Util2.j();
    public d[] E = new d[0];
    public SampleQueue[] D = new SampleQueue[0];
    public long S = -9223372036854775807L;
    public long Q = -1;
    public long K = -9223372036854775807L;
    public int M = 1;

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$a */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public final class a implements Loader.e, IcyDataSource.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f813b;
        public final StatsDataSource c;
        public final ProgressiveMediaExtractor d;
        public final ExtractorOutput e;
        public final ConditionVariable f;
        public volatile boolean h;
        public long j;

        @Nullable
        public TrackOutput2 m;
        public boolean n;
        public final PositionHolder g = new PositionHolder();
        public boolean i = true;
        public long l = -1;
        public final long a = LoadEventInfo.a.getAndIncrement();
        public DataSpec k = a(0);

        public a(Uri uri, DataSource3 dataSource3, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f813b = uri;
            this.c = new StatsDataSource(dataSource3);
            this.d = progressiveMediaExtractor;
            this.e = extractorOutput;
            this.f = conditionVariable;
        }

        public final DataSpec a(long j) {
            Collections.emptyMap();
            Uri uri = this.f813b;
            String str = ProgressiveMediaPeriod.this.t;
            Map<String, String> map = ProgressiveMediaPeriod.j;
            if (uri != null) {
                return new DataSpec(uri, 0L, 1, null, map, j, -1L, str, 6, null);
            }
            throw new IllegalStateException("The uri must be set.");
        }

        public void b() throws IOException {
            DataReader icyDataSource;
            int i;
            int iE = 0;
            while (iE == 0 && !this.h) {
                try {
                    long j = this.g.a;
                    DataSpec dataSpecA = a(j);
                    this.k = dataSpecA;
                    long jA = this.c.a(dataSpecA);
                    this.l = jA;
                    if (jA != -1) {
                        this.l = jA + j;
                    }
                    ProgressiveMediaPeriod.this.C = IcyHeaders.a(this.c.j());
                    StatsDataSource statsDataSource = this.c;
                    IcyHeaders icyHeaders = ProgressiveMediaPeriod.this.C;
                    if (icyHeaders == null || (i = icyHeaders.o) == -1) {
                        icyDataSource = statsDataSource;
                    } else {
                        icyDataSource = new IcyDataSource(statsDataSource, i, this);
                        TrackOutput2 trackOutput2B = ProgressiveMediaPeriod.this.B(new d(0, true));
                        this.m = trackOutput2B;
                        ((SampleQueue) trackOutput2B).e(ProgressiveMediaPeriod.k);
                    }
                    long jA2 = j;
                    ((BundledExtractorsAdapter) this.d).b(icyDataSource, this.f813b, this.c.j(), j, this.l, this.e);
                    if (ProgressiveMediaPeriod.this.C != null) {
                        Extractor extractor = ((BundledExtractorsAdapter) this.d).f828b;
                        if (extractor instanceof Mp3Extractor) {
                            ((Mp3Extractor) extractor).f1206s = true;
                        }
                    }
                    if (this.i) {
                        ProgressiveMediaExtractor progressiveMediaExtractor = this.d;
                        long j2 = this.j;
                        Extractor extractor2 = ((BundledExtractorsAdapter) progressiveMediaExtractor).f828b;
                        Objects.requireNonNull(extractor2);
                        extractor2.g(jA2, j2);
                        this.i = false;
                    }
                    while (true) {
                        long j3 = jA2;
                        while (true) {
                            if (iE != 0 || this.h) {
                                break;
                            }
                            try {
                                ConditionVariable conditionVariable = this.f;
                                synchronized (conditionVariable) {
                                    while (!conditionVariable.f971b) {
                                        try {
                                            conditionVariable.wait();
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                                ProgressiveMediaExtractor progressiveMediaExtractor2 = this.d;
                                PositionHolder positionHolder = this.g;
                                BundledExtractorsAdapter bundledExtractorsAdapter = (BundledExtractorsAdapter) progressiveMediaExtractor2;
                                Extractor extractor3 = bundledExtractorsAdapter.f828b;
                                Objects.requireNonNull(extractor3);
                                ExtractorInput extractorInput = bundledExtractorsAdapter.c;
                                Objects.requireNonNull(extractorInput);
                                iE = extractor3.e(extractorInput, positionHolder);
                                jA2 = ((BundledExtractorsAdapter) this.d).a();
                                if (jA2 > ProgressiveMediaPeriod.this.u + j3) {
                                    this.f.a();
                                    ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
                                    progressiveMediaPeriod.A.post(progressiveMediaPeriod.f812z);
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                    }
                    if (iE == 1) {
                        iE = 0;
                    } else if (((BundledExtractorsAdapter) this.d).a() != -1) {
                        this.g.a = ((BundledExtractorsAdapter) this.d).a();
                    }
                    StatsDataSource statsDataSource2 = this.c;
                    if (statsDataSource2 != null) {
                        try {
                            statsDataSource2.a.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    if (iE != 1 && ((BundledExtractorsAdapter) this.d).a() != -1) {
                        this.g.a = ((BundledExtractorsAdapter) this.d).a();
                    }
                    StatsDataSource statsDataSource3 = this.c;
                    if (statsDataSource3 != null) {
                        try {
                            statsDataSource3.a.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$b */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$c */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public final class c implements SampleStream {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        @Override // b.i.a.c.a3.SampleStream
        public int a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            int i3 = this.a;
            if (progressiveMediaPeriod.D()) {
                return -3;
            }
            progressiveMediaPeriod.y(i3);
            SampleQueue sampleQueue = progressiveMediaPeriod.D[i3];
            boolean z2 = progressiveMediaPeriod.V;
            boolean z3 = (i & 2) != 0;
            SampleQueue.b bVar = sampleQueue.f819b;
            synchronized (sampleQueue) {
                decoderInputBuffer.m = false;
                i2 = -5;
                if (sampleQueue.o()) {
                    Format2 format2 = sampleQueue.c.b(sampleQueue.k()).a;
                    if (z3 || format2 != sampleQueue.h) {
                        sampleQueue.r(format2, formatHolder);
                    } else {
                        int iL = sampleQueue.l(sampleQueue.t);
                        if (sampleQueue.q(iL)) {
                            decoderInputBuffer.j = sampleQueue.n[iL];
                            long j = sampleQueue.o[iL];
                            decoderInputBuffer.n = j;
                            if (j < sampleQueue.u) {
                                decoderInputBuffer.j(Integer.MIN_VALUE);
                            }
                            bVar.a = sampleQueue.m[iL];
                            bVar.f824b = sampleQueue.l[iL];
                            bVar.c = sampleQueue.p[iL];
                            i2 = -4;
                        } else {
                            decoderInputBuffer.m = true;
                            i2 = -3;
                        }
                    }
                } else if (z2 || sampleQueue.f821x) {
                    decoderInputBuffer.j = 4;
                    i2 = -4;
                } else {
                    Format2 format3 = sampleQueue.B;
                    if (format3 == null || (!z3 && format3 == sampleQueue.h)) {
                        i2 = -3;
                    } else {
                        sampleQueue.r(format3, formatHolder);
                    }
                }
            }
            if (i2 == -4 && !decoderInputBuffer.n()) {
                boolean z4 = (i & 1) != 0;
                if ((i & 4) == 0) {
                    if (z4) {
                        SampleDataQueue sampleDataQueue = sampleQueue.a;
                        SampleDataQueue.f(sampleDataQueue.e, decoderInputBuffer, sampleQueue.f819b, sampleDataQueue.c);
                    } else {
                        SampleDataQueue sampleDataQueue2 = sampleQueue.a;
                        sampleDataQueue2.e = SampleDataQueue.f(sampleDataQueue2.e, decoderInputBuffer, sampleQueue.f819b, sampleDataQueue2.c);
                    }
                }
                if (!z4) {
                    sampleQueue.t++;
                }
            }
            if (i2 == -3) {
                progressiveMediaPeriod.z(i3);
            }
            return i2;
        }

        @Override // b.i.a.c.a3.SampleStream
        public void b() throws IOException {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            SampleQueue sampleQueue = progressiveMediaPeriod.D[this.a];
            DrmSession drmSession = sampleQueue.i;
            if (drmSession == null || drmSession.getState() != 1) {
                progressiveMediaPeriod.A();
            } else {
                DrmSession.DrmSessionException drmSessionExceptionF = sampleQueue.i.f();
                Objects.requireNonNull(drmSessionExceptionF);
                throw drmSessionExceptionF;
            }
        }

        @Override // b.i.a.c.a3.SampleStream
        public int c(long j) {
            int i;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            int i2 = this.a;
            boolean z2 = false;
            if (progressiveMediaPeriod.D()) {
                return 0;
            }
            progressiveMediaPeriod.y(i2);
            SampleQueue sampleQueue = progressiveMediaPeriod.D[i2];
            boolean z3 = progressiveMediaPeriod.V;
            synchronized (sampleQueue) {
                int iL = sampleQueue.l(sampleQueue.t);
                if (sampleQueue.o() && j >= sampleQueue.o[iL]) {
                    if (j <= sampleQueue.w || !z3) {
                        i = sampleQueue.i(iL, sampleQueue.q - sampleQueue.t, j, true);
                        if (i == -1) {
                        }
                    } else {
                        i = sampleQueue.q - sampleQueue.t;
                    }
                }
                i = 0;
            }
            synchronized (sampleQueue) {
                if (i >= 0) {
                    if (sampleQueue.t + i <= sampleQueue.q) {
                        z2 = true;
                    }
                }
                AnimatableValueParser.j(z2);
                sampleQueue.t += i;
            }
            if (i == 0) {
                progressiveMediaPeriod.z(i2);
            }
            return i;
        }

        @Override // b.i.a.c.a3.SampleStream
        public boolean d() {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            return !progressiveMediaPeriod.D() && progressiveMediaPeriod.D[this.a].p(progressiveMediaPeriod.V);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$d */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public static final class d {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f815b;

        public d(int i, boolean z2) {
            this.a = i;
            this.f815b = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.f815b == dVar.f815b;
        }

        public int hashCode() {
            return (this.a * 31) + (this.f815b ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$e */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public static final class e {
        public final TrackGroupArray a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f816b;
        public final boolean[] c;
        public final boolean[] d;

        public e(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.a = trackGroupArray;
            this.f816b = zArr;
            int i = trackGroupArray.k;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        j = Collections.unmodifiableMap(map);
        Format2.b bVar = new Format2.b();
        bVar.a = "icy";
        bVar.k = "application/x-icy";
        k = bVar.a();
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource3 dataSource3, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager2 drmSessionManager2, DrmSessionEventListener.a aVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar2, b bVar, DefaultAllocator defaultAllocator, @Nullable String str, int i) {
        this.l = uri;
        this.m = dataSource3;
        this.n = drmSessionManager2;
        this.q = aVar;
        this.o = loadErrorHandlingPolicy;
        this.p = aVar2;
        this.r = bVar;
        this.f809s = defaultAllocator;
        this.t = str;
        this.u = i;
        this.w = progressiveMediaExtractor;
    }

    public void A() throws IOException {
        Loader loader = this.v;
        int iA = ((DefaultLoadErrorHandlingPolicy) this.o).a(this.M);
        IOException iOException = loader.e;
        if (iOException != null) {
            throw iOException;
        }
        Loader.d<? extends Loader.e> dVar = loader.d;
        if (dVar != null) {
            if (iA == Integer.MIN_VALUE) {
                iA = dVar.j;
            }
            IOException iOException2 = dVar.n;
            if (iOException2 != null && dVar.o > iA) {
                throw iOException2;
            }
        }
    }

    public final TrackOutput2 B(d dVar) {
        int length = this.D.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.E[i])) {
                return this.D[i];
            }
        }
        DefaultAllocator defaultAllocator = this.f809s;
        Looper looper = this.A.getLooper();
        DrmSessionManager2 drmSessionManager2 = this.n;
        DrmSessionEventListener.a aVar = this.q;
        Objects.requireNonNull(looper);
        Objects.requireNonNull(drmSessionManager2);
        Objects.requireNonNull(aVar);
        SampleQueue sampleQueue = new SampleQueue(defaultAllocator, looper, drmSessionManager2, aVar);
        sampleQueue.g = this;
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.E, i2);
        dVarArr[length] = dVar;
        int i3 = Util2.a;
        this.E = dVarArr;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.D, i2);
        sampleQueueArr[length] = sampleQueue;
        this.D = sampleQueueArr;
        return sampleQueue;
    }

    public final void C() {
        a aVar = new a(this.l, this.m, this.w, this, this.f810x);
        if (this.G) {
            AnimatableValueParser.D(w());
            long j2 = this.K;
            if (j2 != -9223372036854775807L && this.S > j2) {
                this.V = true;
                this.S = -9223372036854775807L;
                return;
            }
            SeekMap seekMap = this.J;
            Objects.requireNonNull(seekMap);
            long j3 = seekMap.h(this.S).a.c;
            long j4 = this.S;
            aVar.g.a = j3;
            aVar.j = j4;
            aVar.i = true;
            aVar.n = false;
            for (SampleQueue sampleQueue : this.D) {
                sampleQueue.u = this.S;
            }
            this.S = -9223372036854775807L;
        }
        this.U = u();
        Loader loader = this.v;
        int iA = ((DefaultLoadErrorHandlingPolicy) this.o).a(this.M);
        Objects.requireNonNull(loader);
        Looper looperMyLooper = Looper.myLooper();
        AnimatableValueParser.H(looperMyLooper);
        loader.e = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        loader.new d(looperMyLooper, aVar, this, iA, jElapsedRealtime).b(0L);
        DataSpec dataSpec = aVar.k;
        MediaSourceEventListener.a aVar2 = this.p;
        aVar2.f(new LoadEventInfo(aVar.a, dataSpec, jElapsedRealtime), new MediaLoadData(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)));
    }

    public final boolean D() {
        return this.O || w();
    }

    @Override // b.i.a.c.x2.ExtractorOutput
    public void a(final SeekMap seekMap) {
        this.A.post(new Runnable() { // from class: b.i.a.c.a3.h
            @Override // java.lang.Runnable
            public final void run() {
                ProgressiveMediaPeriod progressiveMediaPeriod = this.j;
                SeekMap seekMap2 = seekMap;
                progressiveMediaPeriod.J = progressiveMediaPeriod.C == null ? seekMap2 : new SeekMap.b(-9223372036854775807L, 0L);
                progressiveMediaPeriod.K = seekMap2.i();
                boolean z2 = progressiveMediaPeriod.Q == -1 && seekMap2.i() == -9223372036854775807L;
                progressiveMediaPeriod.L = z2;
                progressiveMediaPeriod.M = z2 ? 7 : 1;
                ((ProgressiveMediaSource) progressiveMediaPeriod.r).u(progressiveMediaPeriod.K, seekMap2.c(), progressiveMediaPeriod.L);
                if (progressiveMediaPeriod.G) {
                    return;
                }
                progressiveMediaPeriod.x();
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    public void b(Loader.e eVar, long j2, long j3, boolean z2) {
        a aVar = (a) eVar;
        StatsDataSource statsDataSource = aVar.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar.a, aVar.k, statsDataSource.c, statsDataSource.d, j2, j3, statsDataSource.f956b);
        Objects.requireNonNull(this.o);
        MediaSourceEventListener.a aVar2 = this.p;
        aVar2.c(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)));
        if (z2) {
            return;
        }
        if (this.Q == -1) {
            this.Q = aVar.l;
        }
        for (SampleQueue sampleQueue : this.D) {
            sampleQueue.s(false);
        }
        if (this.P > 0) {
            MediaPeriod.a aVar3 = this.B;
            Objects.requireNonNull(aVar3);
            aVar3.a(this);
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long c() {
        if (this.P == 0) {
            return Long.MIN_VALUE;
        }
        return q();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    public void d(Loader.e eVar, long j2, long j3) {
        SeekMap seekMap;
        a aVar = (a) eVar;
        if (this.K == -9223372036854775807L && (seekMap = this.J) != null) {
            boolean zC = seekMap.c();
            long jV = v();
            long j4 = jV == Long.MIN_VALUE ? 0L : jV + 10000;
            this.K = j4;
            ((ProgressiveMediaSource) this.r).u(j4, zC, this.L);
        }
        StatsDataSource statsDataSource = aVar.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar.a, aVar.k, statsDataSource.c, statsDataSource.d, j2, j3, statsDataSource.f956b);
        Objects.requireNonNull(this.o);
        MediaSourceEventListener.a aVar2 = this.p;
        aVar2.d(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)));
        if (this.Q == -1) {
            this.Q = aVar.l;
        }
        this.V = true;
        MediaPeriod.a aVar3 = this.B;
        Objects.requireNonNull(aVar3);
        aVar3.a(this);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void e() throws IOException {
        A();
        if (this.V && !this.G) {
            throw ParserException.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long f(long j2) {
        boolean z2;
        t();
        boolean[] zArr = this.I.f816b;
        if (!this.J.c()) {
            j2 = 0;
        }
        this.O = false;
        this.R = j2;
        if (w()) {
            this.S = j2;
            return j2;
        }
        if (this.M != 7) {
            int length = this.D.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = true;
                    break;
                }
                if (!this.D[i].t(j2, false) && (zArr[i] || !this.H)) {
                    z2 = false;
                    break;
                }
                i++;
            }
            if (z2) {
                return j2;
            }
        }
        this.T = false;
        this.S = j2;
        this.V = false;
        if (this.v.b()) {
            for (SampleQueue sampleQueue : this.D) {
                sampleQueue.h();
            }
            Loader.d<? extends Loader.e> dVar = this.v.d;
            AnimatableValueParser.H(dVar);
            dVar.a(false);
        } else {
            this.v.e = null;
            for (SampleQueue sampleQueue2 : this.D) {
                sampleQueue2.s(false);
            }
        }
        return j2;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public boolean g(long j2) {
        if (!this.V) {
            if (!(this.v.e != null) && !this.T && (!this.G || this.P != 0)) {
                boolean zB = this.f810x.b();
                if (this.v.b()) {
                    return zB;
                }
                C();
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public boolean h() {
        boolean z2;
        if (this.v.b()) {
            ConditionVariable conditionVariable = this.f810x;
            synchronized (conditionVariable) {
                z2 = conditionVariable.f971b;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long i(long j2, SeekParameters seekParameters) {
        t();
        if (!this.J.c()) {
            return 0L;
        }
        SeekMap.a aVarH = this.J.h(j2);
        long j3 = aVarH.a.f1298b;
        long j4 = aVarH.f1296b.f1298b;
        long j5 = seekParameters.c;
        if (j5 == 0 && seekParameters.d == 0) {
            return j2;
        }
        int i = Util2.a;
        long j6 = j2 - j5;
        long j7 = ((j5 ^ j2) & (j2 ^ j6)) >= 0 ? j6 : Long.MIN_VALUE;
        long j8 = seekParameters.d;
        long j9 = RecyclerView.FOREVER_NS;
        long j10 = j2 + j8;
        if (((j8 ^ j10) & (j2 ^ j10)) >= 0) {
            j9 = j10;
        }
        boolean z2 = false;
        boolean z3 = j7 <= j3 && j3 <= j9;
        if (j7 <= j4 && j4 <= j9) {
            z2 = true;
        }
        if (z3 && z2) {
            if (Math.abs(j3 - j2) <= Math.abs(j4 - j2)) {
                return j3;
            }
        } else {
            if (z3) {
                return j3;
            }
            if (!z2) {
                return j7;
            }
        }
        return j4;
    }

    @Override // b.i.a.c.x2.ExtractorOutput
    public void j() {
        this.F = true;
        this.A.post(this.f811y);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long k() {
        if (!this.O) {
            return -9223372036854775807L;
        }
        if (!this.V && u() <= this.U) {
            return -9223372036854775807L;
        }
        this.O = false;
        return this.R;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void l(MediaPeriod.a aVar, long j2) {
        this.B = aVar;
        this.f810x.b();
        C();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        t();
        e eVar = this.I;
        TrackGroupArray trackGroupArray = eVar.a;
        boolean[] zArr3 = eVar.c;
        int i = this.P;
        for (int i2 = 0; i2 < exoTrackSelection2Arr.length; i2++) {
            if (sampleStreamArr[i2] != null && (exoTrackSelection2Arr[i2] == null || !zArr[i2])) {
                int i3 = ((c) sampleStreamArr[i2]).a;
                AnimatableValueParser.D(zArr3[i3]);
                this.P--;
                zArr3[i3] = false;
                sampleStreamArr[i2] = null;
            }
        }
        boolean z2 = !this.N ? j2 == 0 : i != 0;
        for (int i4 = 0; i4 < exoTrackSelection2Arr.length; i4++) {
            if (sampleStreamArr[i4] == null && exoTrackSelection2Arr[i4] != null) {
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i4];
                AnimatableValueParser.D(exoTrackSelection2.length() == 1);
                AnimatableValueParser.D(exoTrackSelection2.f(0) == 0);
                int iA = trackGroupArray.a(exoTrackSelection2.a());
                AnimatableValueParser.D(!zArr3[iA]);
                this.P++;
                zArr3[iA] = true;
                sampleStreamArr[i4] = new c(iA);
                zArr2[i4] = true;
                if (!z2) {
                    SampleQueue sampleQueue = this.D[iA];
                    z2 = (sampleQueue.t(j2, true) || sampleQueue.k() == 0) ? false : true;
                }
            }
        }
        if (this.P == 0) {
            this.T = false;
            this.O = false;
            if (this.v.b()) {
                for (SampleQueue sampleQueue2 : this.D) {
                    sampleQueue2.h();
                }
                Loader.d<? extends Loader.e> dVar = this.v.d;
                AnimatableValueParser.H(dVar);
                dVar.a(false);
            } else {
                for (SampleQueue sampleQueue3 : this.D) {
                    sampleQueue3.s(false);
                }
            }
        } else if (z2) {
            j2 = f(j2);
            for (int i5 = 0; i5 < sampleStreamArr.length; i5++) {
                if (sampleStreamArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.N = true;
        return j2;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public TrackGroupArray n() {
        t();
        return this.I.a;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    @Override // com.google.android.exoplayer2.upstream.Loader.b
    public Loader.c o(Loader.e eVar, long j2, long j3, IOException iOException, int i) {
        long jMin;
        boolean z2;
        Loader.c cVarA;
        SeekMap seekMap;
        boolean z3;
        a aVar = (a) eVar;
        if (this.Q == -1) {
            this.Q = aVar.l;
        }
        StatsDataSource statsDataSource = aVar.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar.a, aVar.k, statsDataSource.c, statsDataSource.d, j2, j3, statsDataSource.f956b);
        Util2.M(aVar.j);
        Util2.M(this.K);
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            jMin = -9223372036854775807L;
        } else {
            int i2 = DataSourceException.j;
            Throwable cause = iOException;
            while (true) {
                if (cause == null) {
                    z3 = false;
                    break;
                }
                if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008) {
                    z3 = true;
                    break;
                }
                cause = cause.getCause();
            }
            if (z3) {
                jMin = -9223372036854775807L;
            } else {
                jMin = Math.min((i - 1) * 1000, 5000);
            }
        }
        if (jMin == -9223372036854775807L) {
            cVarA = Loader.f2978b;
        } else {
            int iU = u();
            boolean z4 = iU > this.U;
            if (this.Q == -1 && ((seekMap = this.J) == null || seekMap.i() == -9223372036854775807L)) {
                if (!this.G || D()) {
                    this.O = this.G;
                    this.R = 0L;
                    this.U = 0;
                    for (SampleQueue sampleQueue : this.D) {
                        sampleQueue.s(false);
                    }
                    aVar.g.a = 0L;
                    aVar.j = 0L;
                    aVar.i = true;
                    aVar.n = false;
                } else {
                    this.T = true;
                    z2 = false;
                }
                if (z2) {
                    cVarA = Loader.a(z4, jMin);
                } else {
                    cVarA = Loader.a;
                }
            } else {
                this.U = iU;
            }
            z2 = true;
            if (z2) {
                cVarA = Loader.a(z4, jMin);
            } else {
                cVarA = Loader.a;
            }
        }
        int i3 = cVarA.a;
        boolean z5 = !(i3 == 0 || i3 == 1);
        MediaSourceEventListener.a aVar2 = this.p;
        aVar2.e(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)), iOException, z5);
        if (z5) {
            Objects.requireNonNull(this.o);
        }
        return cVarA;
    }

    @Override // b.i.a.c.x2.ExtractorOutput
    public TrackOutput2 p(int i, int i2) {
        return B(new d(i, false));
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long q() {
        long jV;
        boolean z2;
        long j2;
        t();
        boolean[] zArr = this.I.f816b;
        if (this.V) {
            return Long.MIN_VALUE;
        }
        if (w()) {
            return this.S;
        }
        if (this.H) {
            int length = this.D.length;
            jV = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    SampleQueue sampleQueue = this.D[i];
                    synchronized (sampleQueue) {
                        z2 = sampleQueue.f821x;
                    }
                    if (z2) {
                        continue;
                    } else {
                        SampleQueue sampleQueue2 = this.D[i];
                        synchronized (sampleQueue2) {
                            j2 = sampleQueue2.w;
                        }
                        jV = Math.min(jV, j2);
                    }
                }
            }
        } else {
            jV = Long.MAX_VALUE;
        }
        if (jV == RecyclerView.FOREVER_NS) {
            jV = v();
        }
        return jV == Long.MIN_VALUE ? this.R : jV;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void r(long j2, boolean z2) {
        long jG;
        int i;
        t();
        if (w()) {
            return;
        }
        boolean[] zArr = this.I.c;
        int length = this.D.length;
        for (int i2 = 0; i2 < length; i2++) {
            SampleQueue sampleQueue = this.D[i2];
            boolean z3 = zArr[i2];
            SampleDataQueue sampleDataQueue = sampleQueue.a;
            synchronized (sampleQueue) {
                int i3 = sampleQueue.q;
                jG = -1;
                if (i3 != 0) {
                    long[] jArr = sampleQueue.o;
                    int i4 = sampleQueue.f820s;
                    if (j2 >= jArr[i4]) {
                        int i5 = sampleQueue.i(i4, (!z3 || (i = sampleQueue.t) == i3) ? i3 : i + 1, j2, z2);
                        if (i5 != -1) {
                            jG = sampleQueue.g(i5);
                        }
                    }
                }
            }
            sampleDataQueue.a(jG);
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void s(long j2) {
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void t() {
        AnimatableValueParser.D(this.G);
        Objects.requireNonNull(this.I);
        Objects.requireNonNull(this.J);
    }

    public final int u() {
        int iN = 0;
        for (SampleQueue sampleQueue : this.D) {
            iN += sampleQueue.n();
        }
        return iN;
    }

    public final long v() {
        long j2;
        long jMax = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.D) {
            synchronized (sampleQueue) {
                j2 = sampleQueue.w;
            }
            jMax = Math.max(jMax, j2);
        }
        return jMax;
    }

    public final boolean w() {
        return this.S != -9223372036854775807L;
    }

    public final void x() {
        if (this.W || this.G || !this.F || this.J == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.D) {
            if (sampleQueue.m() == null) {
                return;
            }
        }
        this.f810x.a();
        int length = this.D.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            Format2 format2M = this.D[i].m();
            Objects.requireNonNull(format2M);
            String str = format2M.w;
            boolean zH = MimeTypes.h(str);
            boolean z2 = zH || MimeTypes.j(str);
            zArr[i] = z2;
            this.H = z2 | this.H;
            IcyHeaders icyHeaders = this.C;
            if (icyHeaders != null) {
                if (zH || this.E[i].f815b) {
                    Metadata metadata = format2M.u;
                    Metadata metadata2 = metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders);
                    Format2.b bVarA = format2M.a();
                    bVarA.i = metadata2;
                    format2M = bVarA.a();
                }
                if (zH && format2M.q == -1 && format2M.r == -1 && icyHeaders.j != -1) {
                    Format2.b bVarA2 = format2M.a();
                    bVarA2.f = icyHeaders.j;
                    format2M = bVarA2.a();
                }
            }
            int iD = this.n.d(format2M);
            Format2.b bVarA3 = format2M.a();
            bVarA3.D = iD;
            trackGroupArr[i] = new TrackGroup(bVarA3.a());
        }
        this.I = new e(new TrackGroupArray(trackGroupArr), zArr);
        this.G = true;
        MediaPeriod.a aVar = this.B;
        Objects.requireNonNull(aVar);
        aVar.b(this);
    }

    public final void y(int i) {
        t();
        e eVar = this.I;
        boolean[] zArr = eVar.d;
        if (zArr[i]) {
            return;
        }
        Format2 format2 = eVar.a.l[i].l[0];
        MediaSourceEventListener.a aVar = this.p;
        aVar.b(new MediaLoadData(1, MimeTypes.g(format2.w), format2, 0, null, aVar.a(this.R), -9223372036854775807L));
        zArr[i] = true;
    }

    public final void z(int i) {
        t();
        boolean[] zArr = this.I.f816b;
        if (this.T && zArr[i] && !this.D[i].p(false)) {
            this.S = 0L;
            this.T = false;
            this.O = true;
            this.R = 0L;
            this.U = 0;
            for (SampleQueue sampleQueue : this.D) {
                sampleQueue.s(false);
            }
            MediaPeriod.a aVar = this.B;
            Objects.requireNonNull(aVar);
            aVar.a(this);
        }
    }
}
