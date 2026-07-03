package p600f0.p601e0.p608j;

import com.discord.api.permission.Permission;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.internal.http2.StreamResetException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.C12279c;
import p615g0.C12385b;
import p615g0.C12388e;
import p615g0.C12408y;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.j.n */
/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12320n {

    /* JADX INFO: renamed from: a */
    public long f25712a;

    /* JADX INFO: renamed from: b */
    public long f25713b;

    /* JADX INFO: renamed from: c */
    public long f25714c;

    /* JADX INFO: renamed from: d */
    public long f25715d;

    /* JADX INFO: renamed from: e */
    public final ArrayDeque<Headers> f25716e;

    /* JADX INFO: renamed from: f */
    public boolean f25717f;

    /* JADX INFO: renamed from: g */
    public final b f25718g;

    /* JADX INFO: renamed from: h */
    public final a f25719h;

    /* JADX INFO: renamed from: i */
    public final c f25720i;

    /* JADX INFO: renamed from: j */
    public final c f25721j;

    /* JADX INFO: renamed from: k */
    public EnumC12307a f25722k;

    /* JADX INFO: renamed from: l */
    public IOException f25723l;

    /* JADX INFO: renamed from: m */
    public final int f25724m;

    /* JADX INFO: renamed from: n */
    public final C12311e f25725n;

    /* JADX INFO: renamed from: f0.e0.j.n$a */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class a implements InterfaceC12405v {

        /* JADX INFO: renamed from: j */
        public final C12388e f25726j = new C12388e();

        /* JADX INFO: renamed from: k */
        public boolean f25727k;

        /* JADX INFO: renamed from: l */
        public boolean f25728l;

        public a(boolean z2) {
            this.f25728l = z2;
        }

        /* JADX INFO: renamed from: a */
        public final void m10294a(boolean z2) throws IOException {
            long jMin;
            boolean z3;
            synchronized (C12320n.this) {
                C12320n.this.f25721j.m10424i();
                while (true) {
                    try {
                        C12320n c12320n = C12320n.this;
                        if (c12320n.f25714c < c12320n.f25715d || this.f25728l || this.f25727k || c12320n.m10287f() != null) {
                            break;
                        } else {
                            C12320n.this.m10293l();
                        }
                    } catch (Throwable th) {
                        C12320n.this.f25721j.m10297m();
                        throw th;
                    }
                }
                C12320n.this.f25721j.m10297m();
                C12320n.this.m10283b();
                C12320n c12320n2 = C12320n.this;
                jMin = Math.min(c12320n2.f25715d - c12320n2.f25714c, this.f25726j.f26080k);
                C12320n c12320n3 = C12320n.this;
                c12320n3.f25714c += jMin;
                z3 = z2 && jMin == this.f25726j.f26080k && c12320n3.m10287f() == null;
            }
            C12320n.this.f25721j.m10424i();
            try {
                C12320n c12320n4 = C12320n.this;
                c12320n4.f25725n.m10264n(c12320n4.f25724m, z3, this.f25726j, jMin);
            } finally {
                C12320n.this.f25721j.m10297m();
            }
        }

        @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C12320n c12320n = C12320n.this;
            byte[] bArr = C12272c.f25397a;
            synchronized (c12320n) {
                if (this.f25727k) {
                    return;
                }
                boolean z2 = C12320n.this.m10287f() == null;
                C12320n c12320n2 = C12320n.this;
                if (!c12320n2.f25719h.f25728l) {
                    if (this.f25726j.f26080k > 0) {
                        while (this.f25726j.f26080k > 0) {
                            m10294a(true);
                        }
                    } else if (z2) {
                        c12320n2.f25725n.m10264n(c12320n2.f25724m, true, null, 0L);
                    }
                }
                synchronized (C12320n.this) {
                    this.f25727k = true;
                }
                C12320n.this.f25725n.f25627K.flush();
                C12320n.this.m10282a();
            }
        }

        @Override // p615g0.InterfaceC12405v, java.io.Flushable
        public void flush() throws IOException {
            C12320n c12320n = C12320n.this;
            byte[] bArr = C12272c.f25397a;
            synchronized (c12320n) {
                C12320n.this.m10283b();
            }
            while (this.f25726j.f26080k > 0) {
                m10294a(false);
                C12320n.this.f25725n.f25627K.flush();
            }
        }

        @Override // p615g0.InterfaceC12405v
        public C12408y timeout() {
            return C12320n.this.f25721j;
        }

        @Override // p615g0.InterfaceC12405v
        public void write(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "source");
            byte[] bArr = C12272c.f25397a;
            this.f25726j.write(c12388e, j);
            while (this.f25726j.f26080k >= Permission.EMBED_LINKS) {
                m10294a(false);
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.n$b */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class b implements InterfaceC12407x {

        /* JADX INFO: renamed from: j */
        public final C12388e f25730j = new C12388e();

        /* JADX INFO: renamed from: k */
        public final C12388e f25731k = new C12388e();

        /* JADX INFO: renamed from: l */
        public boolean f25732l;

        /* JADX INFO: renamed from: m */
        public final long f25733m;

        /* JADX INFO: renamed from: n */
        public boolean f25734n;

        public b(long j, boolean z2) {
            this.f25733m = j;
            this.f25734n = z2;
        }

        /* JADX INFO: renamed from: a */
        public final void m10295a(long j) {
            C12320n c12320n = C12320n.this;
            byte[] bArr = C12272c.f25397a;
            c12320n.f25725n.m10263f(j);
        }

        @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            synchronized (C12320n.this) {
                this.f25732l = true;
                C12388e c12388e = this.f25731k;
                j = c12388e.f26080k;
                c12388e.skip(j);
                C12320n c12320n = C12320n.this;
                if (c12320n == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                c12320n.notifyAll();
            }
            if (j > 0) {
                m10295a(j);
            }
            C12320n.this.m10282a();
        }

        @Override // p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws Throwable {
            long jMo10176i0;
            boolean z2;
            long j2;
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            long j3 = 0;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
            }
            while (true) {
                Throwable streamResetException = null;
                synchronized (C12320n.this) {
                    C12320n.this.f25720i.m10424i();
                    try {
                        if (C12320n.this.m10287f() != null && (streamResetException = C12320n.this.f25723l) == null) {
                            EnumC12307a enumC12307aM10287f = C12320n.this.m10287f();
                            if (enumC12307aM10287f == null) {
                                C12238m.throwNpe();
                            }
                            streamResetException = new StreamResetException(enumC12307aM10287f);
                        }
                        if (this.f25732l) {
                            throw new IOException("stream closed");
                        }
                        C12388e c12388e2 = this.f25731k;
                        long j4 = c12388e2.f26080k;
                        if (j4 > j3) {
                            jMo10176i0 = c12388e2.mo10176i0(c12388e, Math.min(j, j4));
                            C12320n c12320n = C12320n.this;
                            long j5 = c12320n.f25712a + jMo10176i0;
                            c12320n.f25712a = j5;
                            long j6 = j5 - c12320n.f25713b;
                            if (streamResetException == null && j6 >= c12320n.f25725n.f25620D.m10312a() / 2) {
                                C12320n c12320n2 = C12320n.this;
                                c12320n2.f25725n.m10267t(c12320n2.f25724m, j6);
                                C12320n c12320n3 = C12320n.this;
                                c12320n3.f25713b = c12320n3.f25712a;
                            }
                        } else {
                            if (this.f25734n || streamResetException != null) {
                                jMo10176i0 = -1;
                            } else {
                                C12320n.this.m10293l();
                                z2 = true;
                                j2 = -1;
                            }
                            C12320n.this.f25720i.m10297m();
                        }
                        j2 = jMo10176i0;
                        z2 = false;
                        C12320n.this.f25720i.m10297m();
                    } catch (Throwable th) {
                        C12320n.this.f25720i.m10297m();
                        throw th;
                    }
                }
                if (!z2) {
                    if (j2 != -1) {
                        m10295a(j2);
                        return j2;
                    }
                    if (streamResetException == null) {
                        return -1L;
                    }
                    throw streamResetException;
                }
                j3 = 0;
            }
        }

        @Override // p615g0.InterfaceC12407x
        public C12408y timeout() {
            return C12320n.this.f25720i;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.n$c */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class c extends C12385b {
        public c() {
        }

        @Override // p615g0.C12385b
        /* JADX INFO: renamed from: k */
        public IOException mo10296k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p615g0.C12385b
        /* JADX INFO: renamed from: l */
        public void mo10191l() {
            C12320n.this.m10286e(EnumC12307a.CANCEL);
            C12311e c12311e = C12320n.this.f25725n;
            synchronized (c12311e) {
                long j = c12311e.f25617A;
                long j2 = c12311e.f25644z;
                if (j < j2) {
                    return;
                }
                c12311e.f25644z = j2 + 1;
                c12311e.f25619C = System.nanoTime() + ((long) 1000000000);
                C12279c c12279c = c12311e.f25638t;
                String strM822J = C1643a.m822J(new StringBuilder(), c12311e.f25633o, " ping");
                c12279c.m10154c(new C12317k(strM822J, true, strM822J, true, c12311e), 0L);
            }
        }

        /* JADX INFO: renamed from: m */
        public final void m10297m() throws IOException {
            if (m10425j()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public C12320n(int i, C12311e c12311e, boolean z2, boolean z3, Headers headers) {
        C12238m.checkParameterIsNotNull(c12311e, "connection");
        this.f25724m = i;
        this.f25725n = c12311e;
        this.f25715d = c12311e.f25621E.m10312a();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.f25716e = arrayDeque;
        this.f25718g = new b(c12311e.f25620D.m10312a(), z3);
        this.f25719h = new a(z2);
        this.f25720i = new c();
        this.f25721j = new c();
        if (headers == null) {
            if (!m10289h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!m10289h())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    /* JADX INFO: renamed from: a */
    public final void m10282a() throws IOException {
        boolean z2;
        boolean zM10290i;
        byte[] bArr = C12272c.f25397a;
        synchronized (this) {
            b bVar = this.f25718g;
            if (bVar.f25734n || !bVar.f25732l) {
                z2 = false;
            } else {
                a aVar = this.f25719h;
                if (aVar.f25728l || aVar.f25727k) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            zM10290i = m10290i();
        }
        if (z2) {
            m10284c(EnumC12307a.CANCEL, null);
        } else {
            if (zM10290i) {
                return;
            }
            this.f25725n.m10261d(this.f25724m);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10283b() throws IOException {
        a aVar = this.f25719h;
        if (aVar.f25727k) {
            throw new IOException("stream closed");
        }
        if (aVar.f25728l) {
            throw new IOException("stream finished");
        }
        if (this.f25722k != null) {
            IOException iOException = this.f25723l;
            if (iOException != null) {
                throw iOException;
            }
            EnumC12307a enumC12307a = this.f25722k;
            if (enumC12307a == null) {
                C12238m.throwNpe();
            }
            throw new StreamResetException(enumC12307a);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m10284c(EnumC12307a enumC12307a, IOException iOException) throws IOException {
        C12238m.checkParameterIsNotNull(enumC12307a, "rstStatusCode");
        if (m10285d(enumC12307a, iOException)) {
            C12311e c12311e = this.f25725n;
            int i = this.f25724m;
            Objects.requireNonNull(c12311e);
            C12238m.checkParameterIsNotNull(enumC12307a, "statusCode");
            c12311e.f25627K.m10304n(i, enumC12307a);
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m10285d(EnumC12307a enumC12307a, IOException iOException) {
        byte[] bArr = C12272c.f25397a;
        synchronized (this) {
            if (this.f25722k != null) {
                return false;
            }
            if (this.f25718g.f25734n && this.f25719h.f25728l) {
                return false;
            }
            this.f25722k = enumC12307a;
            this.f25723l = iOException;
            notifyAll();
            this.f25725n.m10261d(this.f25724m);
            return true;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m10286e(EnumC12307a enumC12307a) {
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
        if (m10285d(enumC12307a, null)) {
            this.f25725n.m10266s(this.f25724m, enumC12307a);
        }
    }

    /* JADX INFO: renamed from: f */
    public final synchronized EnumC12307a m10287f() {
        return this.f25722k;
    }

    /* JADX INFO: renamed from: g */
    public final InterfaceC12405v m10288g() {
        synchronized (this) {
            if (!(this.f25717f || m10289h())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.f25719h;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m10289h() {
        return this.f25725n.f25630l == ((this.f25724m & 1) == 1);
    }

    /* JADX INFO: renamed from: i */
    public final synchronized boolean m10290i() {
        if (this.f25722k != null) {
            return false;
        }
        b bVar = this.f25718g;
        if (bVar.f25734n || bVar.f25732l) {
            a aVar = this.f25719h;
            if ((aVar.f25728l || aVar.f25727k) && this.f25717f) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: j */
    public final void m10291j(Headers headers, boolean z2) {
        boolean zM10290i;
        C12238m.checkParameterIsNotNull(headers, "headers");
        byte[] bArr = C12272c.f25397a;
        synchronized (this) {
            if (this.f25717f && z2) {
                Objects.requireNonNull(this.f25718g);
            } else {
                this.f25717f = true;
                this.f25716e.add(headers);
            }
            if (z2) {
                this.f25718g.f25734n = true;
            }
            zM10290i = m10290i();
            notifyAll();
        }
        if (zM10290i) {
            return;
        }
        this.f25725n.m10261d(this.f25724m);
    }

    /* JADX INFO: renamed from: k */
    public final synchronized void m10292k(EnumC12307a enumC12307a) {
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
        if (this.f25722k == null) {
            this.f25722k = enumC12307a;
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m10293l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
