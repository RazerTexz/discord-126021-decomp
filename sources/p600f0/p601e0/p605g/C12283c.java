package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSink;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.p601e0.p606h.InterfaceC12298d;
import p600f0.p601e0.p608j.EnumC12307a;
import p600f0.p601e0.p613n.C12355d;
import p615g0.AbstractC12392i;
import p615g0.AbstractC12393j;
import p615g0.C12388e;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.g.c */
/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12283c {

    /* JADX INFO: renamed from: a */
    public boolean f25437a;

    /* JADX INFO: renamed from: b */
    public final C12290j f25438b;

    /* JADX INFO: renamed from: c */
    public final C12285e f25439c;

    /* JADX INFO: renamed from: d */
    public final AbstractC12376t f25440d;

    /* JADX INFO: renamed from: e */
    public final C12284d f25441e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC12298d f25442f;

    /* JADX INFO: renamed from: f0.e0.g.c$a */
    /* JADX INFO: compiled from: Exchange.kt */
    public final class a extends AbstractC12392i {

        /* JADX INFO: renamed from: j */
        public boolean f25443j;

        /* JADX INFO: renamed from: k */
        public long f25444k;

        /* JADX INFO: renamed from: l */
        public boolean f25445l;

        /* JADX INFO: renamed from: m */
        public final long f25446m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ C12283c f25447n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C12283c c12283c, InterfaceC12405v interfaceC12405v, long j) {
            super(interfaceC12405v);
            C12238m.checkParameterIsNotNull(interfaceC12405v, "delegate");
            this.f25447n = c12283c;
            this.f25446m = j;
        }

        /* JADX INFO: renamed from: a */
        public final <E extends IOException> E m10174a(E e) {
            if (this.f25443j) {
                return e;
            }
            this.f25443j = true;
            return (E) this.f25447n.m10167a(this.f25444k, false, true, e);
        }

        @Override // p615g0.AbstractC12392i, p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25445l) {
                return;
            }
            this.f25445l = true;
            long j = this.f25446m;
            if (j != -1 && this.f25444k != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m10174a(null);
            } catch (IOException e) {
                throw m10174a(e);
            }
        }

        @Override // p615g0.AbstractC12392i, p615g0.InterfaceC12405v, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw m10174a(e);
            }
        }

        @Override // p615g0.AbstractC12392i, p615g0.InterfaceC12405v
        public void write(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "source");
            if (!(!this.f25445l)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f25446m;
            if (j2 == -1 || this.f25444k + j <= j2) {
                try {
                    super.write(c12388e, j);
                    this.f25444k += j;
                    return;
                } catch (IOException e) {
                    throw m10174a(e);
                }
            }
            StringBuilder sbM833U = C1643a.m833U("expected ");
            sbM833U.append(this.f25446m);
            sbM833U.append(" bytes but received ");
            sbM833U.append(this.f25444k + j);
            throw new ProtocolException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.c$b */
    /* JADX INFO: compiled from: Exchange.kt */
    public final class b extends AbstractC12393j {

        /* JADX INFO: renamed from: k */
        public long f25448k;

        /* JADX INFO: renamed from: l */
        public boolean f25449l;

        /* JADX INFO: renamed from: m */
        public boolean f25450m;

        /* JADX INFO: renamed from: n */
        public boolean f25451n;

        /* JADX INFO: renamed from: o */
        public final long f25452o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ C12283c f25453p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C12283c c12283c, InterfaceC12407x interfaceC12407x, long j) {
            super(interfaceC12407x);
            C12238m.checkParameterIsNotNull(interfaceC12407x, "delegate");
            this.f25453p = c12283c;
            this.f25452o = j;
            this.f25449l = true;
            if (j == 0) {
                m10175a(null);
            }
        }

        /* JADX INFO: renamed from: a */
        public final <E extends IOException> E m10175a(E e) {
            if (this.f25450m) {
                return e;
            }
            this.f25450m = true;
            if (e == null && this.f25449l) {
                this.f25449l = false;
                C12283c c12283c = this.f25453p;
                AbstractC12376t abstractC12376t = c12283c.f25440d;
                C12285e c12285e = c12283c.f25439c;
                Objects.requireNonNull(abstractC12376t);
                C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            }
            return (E) this.f25453p.m10167a(this.f25448k, true, false, e);
        }

        @Override // p615g0.AbstractC12393j, p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25451n) {
                return;
            }
            this.f25451n = true;
            try {
                this.f26093j.close();
                m10175a(null);
            } catch (IOException e) {
                throw m10175a(e);
            }
        }

        @Override // p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            if (!(!this.f25451n)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jMo10176i0 = this.f26093j.mo10176i0(c12388e, j);
                if (this.f25449l) {
                    this.f25449l = false;
                    C12283c c12283c = this.f25453p;
                    AbstractC12376t abstractC12376t = c12283c.f25440d;
                    C12285e c12285e = c12283c.f25439c;
                    Objects.requireNonNull(abstractC12376t);
                    C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
                }
                if (jMo10176i0 == -1) {
                    m10175a(null);
                    return -1L;
                }
                long j2 = this.f25448k + jMo10176i0;
                long j3 = this.f25452o;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.f25452o + " bytes but received " + j2);
                }
                this.f25448k = j2;
                if (j2 == j3) {
                    m10175a(null);
                }
                return jMo10176i0;
            } catch (IOException e) {
                throw m10175a(e);
            }
        }
    }

    public C12283c(C12285e c12285e, AbstractC12376t abstractC12376t, C12284d c12284d, InterfaceC12298d interfaceC12298d) {
        C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(abstractC12376t, "eventListener");
        C12238m.checkParameterIsNotNull(c12284d, "finder");
        C12238m.checkParameterIsNotNull(interfaceC12298d, "codec");
        this.f25439c = c12285e;
        this.f25440d = abstractC12376t;
        this.f25441e = c12284d;
        this.f25442f = interfaceC12298d;
        this.f25438b = interfaceC12298d.mo10217e();
    }

    /* JADX INFO: renamed from: a */
    public final <E extends IOException> E m10167a(long j, boolean z2, boolean z3, E e) {
        if (e != null) {
            m10173g(e);
        }
        if (z3) {
            if (e != null) {
                AbstractC12376t abstractC12376t = this.f25440d;
                C12285e c12285e = this.f25439c;
                Objects.requireNonNull(abstractC12376t);
                C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
                C12238m.checkParameterIsNotNull(e, "ioe");
            } else {
                AbstractC12376t abstractC12376t2 = this.f25440d;
                C12285e c12285e2 = this.f25439c;
                Objects.requireNonNull(abstractC12376t2);
                C12238m.checkParameterIsNotNull(c12285e2, NotificationCompat.CATEGORY_CALL);
            }
        }
        if (z2) {
            if (e != null) {
                AbstractC12376t abstractC12376t3 = this.f25440d;
                C12285e c12285e3 = this.f25439c;
                Objects.requireNonNull(abstractC12376t3);
                C12238m.checkParameterIsNotNull(c12285e3, NotificationCompat.CATEGORY_CALL);
                C12238m.checkParameterIsNotNull(e, "ioe");
            } else {
                AbstractC12376t abstractC12376t4 = this.f25440d;
                C12285e c12285e4 = this.f25439c;
                Objects.requireNonNull(abstractC12376t4);
                C12238m.checkParameterIsNotNull(c12285e4, NotificationCompat.CATEGORY_CALL);
            }
        }
        return (E) this.f25439c.m10186k(this, z3, z2, e);
    }

    /* JADX INFO: renamed from: b */
    public final InterfaceC12405v m10168b(Request request, boolean z2) throws IOException {
        C12238m.checkParameterIsNotNull(request, "request");
        this.f25437a = z2;
        RequestBody requestBody = request.body;
        if (requestBody == null) {
            C12238m.throwNpe();
        }
        long jContentLength = requestBody.contentLength();
        AbstractC12376t abstractC12376t = this.f25440d;
        C12285e c12285e = this.f25439c;
        Objects.requireNonNull(abstractC12376t);
        C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
        return new a(this, this.f25442f.mo10220h(request, jContentLength), jContentLength);
    }

    /* JADX INFO: renamed from: c */
    public final void m10169c() throws IOException {
        try {
            this.f25442f.mo10218f();
        } catch (IOException e) {
            AbstractC12376t abstractC12376t = this.f25440d;
            C12285e c12285e = this.f25439c;
            Objects.requireNonNull(abstractC12376t);
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(e, "ioe");
            m10173g(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: d */
    public final C12355d.c m10170d() throws SocketException {
        this.f25439c.m10189n();
        C12290j c12290jMo10217e = this.f25442f.mo10217e();
        Objects.requireNonNull(c12290jMo10217e);
        C12238m.checkParameterIsNotNull(this, "exchange");
        Socket socket = c12290jMo10217e.f25492c;
        if (socket == null) {
            C12238m.throwNpe();
        }
        InterfaceC12390g interfaceC12390g = c12290jMo10217e.f25496g;
        if (interfaceC12390g == null) {
            C12238m.throwNpe();
        }
        BufferedSink bufferedSink = c12290jMo10217e.f25497h;
        if (bufferedSink == null) {
            C12238m.throwNpe();
        }
        socket.setSoTimeout(0);
        c12290jMo10217e.m10203l();
        return new C12289i(this, interfaceC12390g, bufferedSink, true, interfaceC12390g, bufferedSink);
    }

    /* JADX INFO: renamed from: e */
    public final Response.C12937a m10171e(boolean z2) throws IOException {
        try {
            Response.C12937a c12937aMo10216d = this.f25442f.mo10216d(z2);
            if (c12937aMo10216d != null) {
                C12238m.checkParameterIsNotNull(this, "deferredTrailers");
                c12937aMo10216d.f27577m = this;
            }
            return c12937aMo10216d;
        } catch (IOException e) {
            AbstractC12376t abstractC12376t = this.f25440d;
            C12285e c12285e = this.f25439c;
            Objects.requireNonNull(abstractC12376t);
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(e, "ioe");
            m10173g(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m10172f() {
        AbstractC12376t abstractC12376t = this.f25440d;
        C12285e c12285e = this.f25439c;
        Objects.requireNonNull(abstractC12376t);
        C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
    }

    /* JADX INFO: renamed from: g */
    public final void m10173g(IOException iOException) {
        this.f25441e.m10179c(iOException);
        C12290j c12290jMo10217e = this.f25442f.mo10217e();
        C12285e c12285e = this.f25439c;
        synchronized (c12290jMo10217e) {
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == EnumC12307a.REFUSED_STREAM) {
                    int i = c12290jMo10217e.f25502m + 1;
                    c12290jMo10217e.f25502m = i;
                    if (i > 1) {
                        c12290jMo10217e.f25498i = true;
                        c12290jMo10217e.f25500k++;
                    }
                } else if (((StreamResetException) iOException).errorCode != EnumC12307a.CANCEL || !c12285e.f25477v) {
                    c12290jMo10217e.f25498i = true;
                    c12290jMo10217e.f25500k++;
                }
            } else if (!c12290jMo10217e.m10201j() || (iOException instanceof ConnectionShutdownException)) {
                c12290jMo10217e.f25498i = true;
                if (c12290jMo10217e.f25501l == 0) {
                    c12290jMo10217e.m10195d(c12285e.f25480y, c12290jMo10217e.f25506q, iOException);
                    c12290jMo10217e.f25500k++;
                }
            }
        }
    }
}
