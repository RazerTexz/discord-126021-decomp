package f0.e0.j;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$IntRef;
import okio.BufferedSink;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Closeable {
    public static final s j;
    public static final e k = null;
    public long A;
    public long B;
    public long C;
    public final s D;
    public s E;
    public long F;
    public long G;
    public long H;
    public long I;
    public final Socket J;
    public final o K;
    public final e$d L;
    public final Set<Integer> M;
    public final boolean l;
    public final e$c m;
    public final Map<Integer, n> n;
    public final String o;
    public int p;
    public int q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f0.e0.f.d f3638s;
    public final f0.e0.f.c t;
    public final f0.e0.f.c u;
    public final f0.e0.f.c v;
    public final r w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f3639x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f3640y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f3641z;

    static {
        s sVar = new s();
        sVar.c(7, 65535);
        sVar.c(5, 16384);
        j = sVar;
    }

    public e(e$b e_b) {
        d0.z.d.m.checkParameterIsNotNull(e_b, "builder");
        boolean z2 = e_b.h;
        this.l = z2;
        this.m = e_b.e;
        this.n = new LinkedHashMap();
        String str = e_b.f3642b;
        if (str == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("connectionName");
        }
        this.o = str;
        this.q = e_b.h ? 3 : 2;
        f0.e0.f.d dVar = e_b.i;
        this.f3638s = dVar;
        f0.e0.f.c cVarF = dVar.f();
        this.t = cVarF;
        this.u = dVar.f();
        this.v = dVar.f();
        this.w = e_b.f;
        s sVar = new s();
        if (e_b.h) {
            sVar.c(7, 16777216);
        }
        this.D = sVar;
        s sVar2 = j;
        this.E = sVar2;
        this.I = sVar2.a();
        Socket socket = e_b.a;
        if (socket == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("socket");
        }
        this.J = socket;
        BufferedSink bufferedSink = e_b.d;
        if (bufferedSink == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("sink");
        }
        this.K = new o(bufferedSink, z2);
        g0.g gVar = e_b.c;
        if (gVar == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("source");
        }
        this.L = new e$d(this, new m(gVar, z2));
        this.M = new LinkedHashSet();
        int i = e_b.g;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            String strW = b.d.b.a.a.w(str, " ping");
            cVarF.c(new e$a(strW, strW, this, nanos), nanos);
        }
    }

    public final void a(a aVar, a aVar2, IOException iOException) {
        int i;
        d0.z.d.m.checkParameterIsNotNull(aVar, "connectionCode");
        d0.z.d.m.checkParameterIsNotNull(aVar2, "streamCode");
        byte[] bArr = f0.e0.c.a;
        try {
            e(aVar);
        } catch (IOException unused) {
        }
        n[] nVarArr = null;
        synchronized (this) {
            if (!this.n.isEmpty()) {
                Object[] array = this.n.values().toArray(new n[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                nVarArr = (n[]) array;
                this.n.clear();
            }
        }
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                try {
                    nVar.c(aVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.K.close();
        } catch (IOException unused3) {
        }
        try {
            this.J.close();
        } catch (IOException unused4) {
        }
        this.t.f();
        this.u.f();
        this.v.f();
    }

    public final synchronized n b(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    public final boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(a.NO_ERROR, a.CANCEL, null);
    }

    public final synchronized n d(int i) {
        n nVarRemove;
        nVarRemove = this.n.remove(Integer.valueOf(i));
        notifyAll();
        return nVarRemove;
    }

    public final void e(a aVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(aVar, "statusCode");
        synchronized (this.K) {
            synchronized (this) {
                if (this.r) {
                    return;
                }
                this.r = true;
                this.K.d(this.p, aVar, f0.e0.c.a);
            }
        }
    }

    public final synchronized void f(long j2) {
        long j3 = this.F + j2;
        this.F = j3;
        long j4 = j3 - this.G;
        if (j4 >= this.D.a() / 2) {
            t(0, j4);
            this.G += j4;
        }
    }

    public final void n(int i, boolean z2, g0.e eVar, long j2) throws IOException {
        long j3;
        long j4;
        int iMin;
        if (j2 == 0) {
            this.K.b(z2, i, eVar, 0);
            return;
        }
        while (j2 > 0) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                while (true) {
                    try {
                        j3 = this.H;
                        j4 = this.I;
                        if (j3 >= j4) {
                            if (!this.n.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                int iMin2 = (int) Math.min(j2, j4 - j3);
                ref$IntRef.element = iMin2;
                iMin = Math.min(iMin2, this.K.l);
                ref$IntRef.element = iMin;
                this.H += (long) iMin;
            }
            j2 -= (long) iMin;
            this.K.b(z2 && j2 == 0, i, eVar, iMin);
        }
    }

    public final void q(boolean z2, int i, int i2) {
        try {
            this.K.f(z2, i, i2);
        } catch (IOException e) {
            a aVar = a.PROTOCOL_ERROR;
            a(aVar, aVar, e);
        }
    }

    public final void s(int i, a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        f0.e0.f.c cVar = this.t;
        String str = this.o + '[' + i + "] writeSynReset";
        cVar.c(new e$e(str, true, str, true, this, i, aVar), 0L);
    }

    public final void t(int i, long j2) {
        f0.e0.f.c cVar = this.t;
        String str = this.o + '[' + i + "] windowUpdate";
        cVar.c(new e$f(str, true, str, true, this, i, j2), 0L);
    }
}
