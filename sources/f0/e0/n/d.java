package f0.e0.n;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.t.m;
import f0.y;
import g0.e$a;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements WebSocket, h$a {
    public static final List<y> a = m.listOf(y.HTTP_1_1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3656b;
    public f0.e c;
    public f0.e0.f.a d;
    public h e;
    public i f;
    public f0.e0.f.c g;
    public String h;
    public d$c i;
    public final ArrayDeque<ByteString> j;
    public final ArrayDeque<Object> k;
    public long l;
    public boolean m;
    public int n;
    public String o;
    public boolean p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3657s;
    public boolean t;
    public final Request u;
    public final WebSocketListener v;
    public final Random w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f3658x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f3659y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f3660z;

    public d(f0.e0.f.d dVar, Request request, WebSocketListener webSocketListener, Random random, long j, f fVar, long j2) {
        d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
        d0.z.d.m.checkParameterIsNotNull(request, "originalRequest");
        d0.z.d.m.checkParameterIsNotNull(webSocketListener, "listener");
        d0.z.d.m.checkParameterIsNotNull(random, "random");
        this.u = request;
        this.v = webSocketListener;
        this.w = random;
        this.f3658x = j;
        this.f3659y = null;
        this.f3660z = j2;
        this.g = dVar.f();
        this.j = new ArrayDeque<>();
        this.k = new ArrayDeque<>();
        this.n = -1;
        if (!d0.z.d.m.areEqual(ShareTarget.METHOD_GET, request.method)) {
            StringBuilder sbU = b.d.b.a.a.U("Request must be GET: ");
            sbU.append(request.method);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        ByteString$a byteString$a = ByteString.k;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f3656b = ByteString$a.d(byteString$a, bArr, 0, 0, 3).f();
    }

    @Override // okhttp3.WebSocket
    public boolean a(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        ByteString byteStringC = ByteString.k.c(str);
        synchronized (this) {
            if (!this.p && !this.m) {
                if (this.l + ((long) byteStringC.j()) > Permission.MOVE_MEMBERS) {
                    e(PointerIconCompat.TYPE_CONTEXT_MENU, null);
                    return false;
                }
                this.l += (long) byteStringC.j();
                this.k.add(new d$b(1, byteStringC));
                l();
                return true;
            }
            return false;
        }
    }

    @Override // f0.e0.n.h$a
    public void b(ByteString byteString) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteString, "bytes");
        this.v.onMessage(this, byteString);
    }

    @Override // f0.e0.n.h$a
    public void c(String str) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.v.onMessage(this, str);
    }

    @Override // f0.e0.n.h$a
    public synchronized void d(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "payload");
        if (!this.p && (!this.m || !this.k.isEmpty())) {
            this.j.add(byteString);
            l();
            this.r++;
        }
    }

    @Override // okhttp3.WebSocket
    public boolean e(int i, String str) {
        String str2;
        synchronized (this) {
            ByteString byteStringC = null;
            try {
                if (i < 1000 || i >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i;
                } else if ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i + " is reserved and may not be used.";
                }
                if (!(str2 == null)) {
                    if (str2 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    byteStringC = ByteString.k.c(str);
                    if (!(((long) byteStringC.j()) <= 123)) {
                        throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                    }
                }
                if (!this.p && !this.m) {
                    this.m = true;
                    this.k.add(new d$a(i, byteStringC, 60000L));
                    l();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f0.e0.n.h$a
    public synchronized void f(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "payload");
        this.f3657s++;
        this.t = false;
    }

    @Override // f0.e0.n.h$a
    public void g(int i, String str) {
        d$c d_c;
        h hVar;
        i iVar;
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        if (!(i != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (!(this.n == -1)) {
                throw new IllegalStateException("already closed".toString());
            }
            this.n = i;
            this.o = str;
            d_c = null;
            if (this.m && this.k.isEmpty()) {
                d$c d_c2 = this.i;
                this.i = null;
                hVar = this.e;
                this.e = null;
                iVar = this.f;
                this.f = null;
                this.g.f();
                d_c = d_c2;
            } else {
                hVar = null;
                iVar = null;
            }
        }
        try {
            this.v.onClosing(this, i, str);
            if (d_c != null) {
                this.v.onClosed(this, i, str);
            }
            if (d_c != null) {
                byte[] bArr = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(d_c, "$this$closeQuietly");
                try {
                    d_c.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
            if (hVar != null) {
                byte[] bArr2 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                try {
                    hVar.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused2) {
                }
            }
            if (iVar != null) {
                byte[] bArr3 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                try {
                    iVar.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (d_c != null) {
                byte[] bArr4 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(d_c, "$this$closeQuietly");
                try {
                    d_c.close();
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception unused4) {
                }
            }
            if (hVar != null) {
                byte[] bArr5 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                try {
                    hVar.close();
                } catch (RuntimeException e5) {
                    throw e5;
                } catch (Exception unused5) {
                }
            }
            if (iVar == null) {
                throw th;
            }
            byte[] bArr6 = f0.e0.c.a;
            d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
            try {
                iVar.close();
                throw th;
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    public final void h(Response response, f0.e0.g.c cVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 101) {
            StringBuilder sbU = b.d.b.a.a.U("Expected HTTP 101 response but was '");
            sbU.append(response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            sbU.append(' ');
            throw new ProtocolException(b.d.b.a.a.H(sbU, response.message, '\''));
        }
        String strA = Response.a(response, "Connection", null, 2);
        if (!t.equals("Upgrade", strA, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + '\'');
        }
        String strA2 = Response.a(response, "Upgrade", null, 2);
        if (!t.equals("websocket", strA2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + '\'');
        }
        String strA3 = Response.a(response, "Sec-WebSocket-Accept", null, 2);
        String strF = ByteString.k.c(this.f3656b + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").g(Constants.SHA1).f();
        if (!(!d0.z.d.m.areEqual(strF, strA3))) {
            if (cVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strF + "' but was '" + strA3 + '\'');
    }

    public final void i(Exception exc, Response response) {
        d0.z.d.m.checkParameterIsNotNull(exc, "e");
        synchronized (this) {
            if (this.p) {
                return;
            }
            this.p = true;
            d$c d_c = this.i;
            this.i = null;
            h hVar = this.e;
            this.e = null;
            i iVar = this.f;
            this.f = null;
            this.g.f();
            try {
                this.v.onFailure(this, exc, response);
                if (d_c != null) {
                    byte[] bArr = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(d_c, "$this$closeQuietly");
                    try {
                        d_c.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                if (hVar != null) {
                    byte[] bArr2 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                    try {
                        hVar.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                if (iVar != null) {
                    byte[] bArr3 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                    try {
                        iVar.close();
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                if (d_c != null) {
                    byte[] bArr4 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(d_c, "$this$closeQuietly");
                    try {
                        d_c.close();
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused4) {
                    }
                }
                if (hVar != null) {
                    byte[] bArr5 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                    try {
                        hVar.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused5) {
                    }
                }
                if (iVar == null) {
                    throw th;
                }
                byte[] bArr6 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                try {
                    iVar.close();
                    throw th;
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        }
    }

    public final void j(String str, d$c d_c) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(d_c, "streams");
        f fVar = this.f3659y;
        if (fVar == null) {
            d0.z.d.m.throwNpe();
        }
        synchronized (this) {
            this.h = str;
            this.i = d_c;
            boolean z2 = d_c.j;
            this.f = new i(z2, d_c.l, this.w, fVar.a, z2 ? fVar.c : fVar.e, this.f3660z);
            this.d = new d$d(this);
            long j = this.f3658x;
            if (j != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                String str2 = str + " ping";
                this.g.c(new d$e(str2, str2, nanos, this, str, d_c, fVar), nanos);
            }
            if (!this.k.isEmpty()) {
                l();
            }
        }
        boolean z3 = d_c.j;
        this.e = new h(z3, d_c.k, this, fVar.a, z3 ^ true ? fVar.c : fVar.e);
    }

    public final void k() throws IOException {
        while (this.n == -1) {
            h hVar = this.e;
            if (hVar == null) {
                d0.z.d.m.throwNpe();
            }
            hVar.b();
            if (hVar.n) {
                hVar.a();
            } else {
                int i = hVar.k;
                if (i != 1 && i != 2) {
                    StringBuilder sbU = b.d.b.a.a.U("Unknown opcode: ");
                    sbU.append(f0.e0.c.x(i));
                    throw new ProtocolException(sbU.toString());
                }
                while (true) {
                    if (hVar.j) {
                        throw new IOException("closed");
                    }
                    long j = hVar.l;
                    if (j > 0) {
                        hVar.v.B(hVar.q, j);
                        if (!hVar.u) {
                            g0.e eVar = hVar.q;
                            e$a e_a = hVar.t;
                            if (e_a == null) {
                                d0.z.d.m.throwNpe();
                            }
                            eVar.u(e_a);
                            hVar.t.b(hVar.q.k - hVar.l);
                            e$a e_a2 = hVar.t;
                            byte[] bArr = hVar.f3665s;
                            if (bArr == null) {
                                d0.z.d.m.throwNpe();
                            }
                            g.a(e_a2, bArr);
                            hVar.t.close();
                        }
                    }
                    if (hVar.m) {
                        if (hVar.o) {
                            c cVar = hVar.r;
                            if (cVar == null) {
                                cVar = new c(hVar.f3667y);
                                hVar.r = cVar;
                            }
                            g0.e eVar2 = hVar.q;
                            d0.z.d.m.checkParameterIsNotNull(eVar2, "buffer");
                            if (!(cVar.j.k == 0)) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            if (cVar.m) {
                                cVar.k.reset();
                            }
                            cVar.j.P(eVar2);
                            cVar.j.W(65535);
                            long bytesRead = cVar.k.getBytesRead() + cVar.j.k;
                            do {
                                cVar.l.a(eVar2, RecyclerView.FOREVER_NS);
                            } while (cVar.k.getBytesRead() < bytesRead);
                        }
                        if (i != 1) {
                            hVar.w.b(hVar.q.x());
                            break;
                        } else {
                            hVar.w.c(hVar.q.D());
                            break;
                        }
                    }
                    while (!hVar.j) {
                        hVar.b();
                        if (!hVar.n) {
                            break;
                        } else {
                            hVar.a();
                        }
                    }
                    if (hVar.k != 0) {
                        StringBuilder sbU2 = b.d.b.a.a.U("Expected continuation opcode. Got: ");
                        sbU2.append(f0.e0.c.x(hVar.k));
                        throw new ProtocolException(sbU2.toString());
                    }
                }
            }
        }
    }

    public final void l() {
        byte[] bArr = f0.e0.c.a;
        f0.e0.f.a aVar = this.d;
        if (aVar != null) {
            this.g.c(aVar, 0L);
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0177  */
    /* JADX WARN: Code duplicated, block: B:73:0x018d  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [f0.e0.n.i] */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v25, types: [T, f0.e0.n.d$c] */
    /* JADX WARN: Type inference failed for: r2v26, types: [T, f0.e0.n.h] */
    /* JADX WARN: Type inference failed for: r2v27, types: [T, f0.e0.n.i] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, okio.ByteString] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean m() throws Throwable {
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$ObjectRef ref$ObjectRef4;
        Ref$ObjectRef ref$ObjectRef5;
        d$c d_c;
        h hVar;
        i iVar;
        Ref$ObjectRef ref$ObjectRef6 = new Ref$ObjectRef();
        ref$ObjectRef6.element = null;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
        ref$ObjectRef7.element = null;
        Ref$ObjectRef ref$ObjectRef8 = new Ref$ObjectRef();
        ref$ObjectRef8.element = null;
        Ref$ObjectRef ref$ObjectRef9 = new Ref$ObjectRef();
        ref$ObjectRef9.element = null;
        Ref$ObjectRef ref$ObjectRef10 = new Ref$ObjectRef();
        ref$ObjectRef10.element = null;
        synchronized (this) {
            if (this.p) {
                return false;
            }
            i iVar2 = this.f;
            ByteString byteStringPoll = this.j.poll();
            if (byteStringPoll == null) {
                ?? Poll = this.k.poll();
                ref$ObjectRef6.element = Poll;
                if (Poll instanceof d$a) {
                    int i = this.n;
                    ref$IntRef.element = i;
                    ref$ObjectRef7.element = this.o;
                    if (i != -1) {
                        ref$ObjectRef8.element = this.i;
                        this.i = null;
                        ref$ObjectRef9.element = this.e;
                        this.e = null;
                        ref$ObjectRef10.element = this.f;
                        this.f = null;
                        this.g.f();
                        ref$ObjectRef = ref$ObjectRef10;
                        ref$ObjectRef2 = ref$ObjectRef9;
                    } else {
                        T t = ref$ObjectRef6.element;
                        if (t == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        long j = ((d$a) t).c;
                        f0.e0.f.c cVar = this.g;
                        String str = this.h + " cancel";
                        ref$ObjectRef = ref$ObjectRef10;
                        ref$ObjectRef2 = ref$ObjectRef9;
                        cVar.c(new d$f(str, true, str, true, this, iVar2, byteStringPoll, ref$ObjectRef6, ref$IntRef, ref$ObjectRef7, ref$ObjectRef8, ref$ObjectRef2, ref$ObjectRef), TimeUnit.MILLISECONDS.toNanos(j));
                    }
                } else {
                    ref$ObjectRef = ref$ObjectRef10;
                    ref$ObjectRef2 = ref$ObjectRef9;
                    if (Poll == 0) {
                        return false;
                    }
                }
            } else {
                ref$ObjectRef = ref$ObjectRef10;
                ref$ObjectRef2 = ref$ObjectRef9;
            }
            Ref$ObjectRef ref$ObjectRef11 = byteStringPoll;
            try {
                if (ref$ObjectRef11 == 0) {
                    ref$ObjectRef4 = iVar2;
                    T t2 = ref$ObjectRef6.element;
                    if (t2 instanceof d$b) {
                        if (t2 == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                        }
                        d$b d_b = (d$b) t2;
                        if (ref$ObjectRef4 == 0) {
                            d0.z.d.m.throwNpe();
                        }
                        ref$ObjectRef4.c(d_b.a, d_b.f3662b);
                        synchronized (this) {
                            this.l -= (long) d_b.f3662b.j();
                        }
                        d$c d_c2 = (d$c) ref$ObjectRef4.element;
                        if (d_c2 != null) {
                            byte[] bArr = f0.e0.c.a;
                            d0.z.d.m.checkParameterIsNotNull(d_c2, "$this$closeQuietly");
                            try {
                                d_c2.close();
                            } catch (RuntimeException e) {
                                throw e;
                            } catch (Exception unused) {
                            }
                        }
                        h hVar2 = (h) ref$ObjectRef3.element;
                        if (hVar2 != null) {
                            byte[] bArr2 = f0.e0.c.a;
                            d0.z.d.m.checkParameterIsNotNull(hVar2, "$this$closeQuietly");
                            try {
                                hVar2.close();
                            } catch (RuntimeException e2) {
                                throw e2;
                            } catch (Exception unused2) {
                            }
                        }
                        i iVar3 = (i) ref$ObjectRef11.element;
                        if (iVar3 == null) {
                            throw th;
                        }
                        byte[] bArr3 = f0.e0.c.a;
                        d0.z.d.m.checkParameterIsNotNull(iVar3, "$this$closeQuietly");
                        try {
                            iVar3.close();
                            throw th;
                        } catch (RuntimeException e3) {
                            throw e3;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    ref$ObjectRef3 = t2 instanceof d$a;
                    try {
                        if (ref$ObjectRef3 == 0) {
                            throw new AssertionError();
                        }
                        if (t2 == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        d$a d_a = (d$a) t2;
                        if (ref$ObjectRef4 == 0) {
                            d0.z.d.m.throwNpe();
                        }
                        ref$ObjectRef4.a(d_a.a, d_a.f3661b);
                        ref$ObjectRef4 = ref$ObjectRef8;
                        try {
                            d$c d_c3 = (d$c) ref$ObjectRef4.element;
                            ref$ObjectRef5 = ref$ObjectRef4;
                            if (d_c3 != null) {
                                WebSocketListener webSocketListener = this.v;
                                int i2 = ref$IntRef.element;
                                String str2 = (String) ref$ObjectRef7.element;
                                if (str2 == null) {
                                    d0.z.d.m.throwNpe();
                                }
                                webSocketListener.onClosed(this, i2, str2);
                                ref$ObjectRef5 = ref$ObjectRef4;
                            }
                        } catch (Throwable th) {
                            th = th;
                            ref$ObjectRef11 = ref$ObjectRef;
                            ref$ObjectRef3 = ref$ObjectRef2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    d_c = (d$c) ref$ObjectRef5.element;
                    if (d_c != null) {
                        byte[] bArr4 = f0.e0.c.a;
                        d0.z.d.m.checkParameterIsNotNull(d_c, "$this$closeQuietly");
                        try {
                            d_c.close();
                        } catch (RuntimeException e4) {
                            throw e4;
                        } catch (Exception unused4) {
                        }
                    }
                    hVar = (h) ref$ObjectRef2.element;
                    if (hVar != null) {
                        byte[] bArr5 = f0.e0.c.a;
                        d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                        try {
                            hVar.close();
                        } catch (RuntimeException e5) {
                            throw e5;
                        } catch (Exception unused5) {
                        }
                    }
                    iVar = (i) ref$ObjectRef.element;
                    if (iVar != null) {
                        byte[] bArr6 = f0.e0.c.a;
                        d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                        try {
                            iVar.close();
                        } catch (RuntimeException e6) {
                            throw e6;
                        } catch (Exception unused6) {
                        }
                    }
                    return true;
                }
                if (iVar2 == 0) {
                    d0.z.d.m.throwNpe();
                }
                Objects.requireNonNull(iVar2);
                d0.z.d.m.checkParameterIsNotNull(ref$ObjectRef11, "payload");
                iVar2.b(10, ref$ObjectRef11);
                ref$ObjectRef5 = ref$ObjectRef8;
                d_c = (d$c) ref$ObjectRef5.element;
                if (d_c != null) {
                    byte[] bArr7 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(d_c, "$this$closeQuietly");
                    d_c.close();
                }
                hVar = (h) ref$ObjectRef2.element;
                if (hVar != null) {
                    byte[] bArr8 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                    hVar.close();
                }
                iVar = (i) ref$ObjectRef.element;
                if (iVar != null) {
                    byte[] bArr9 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                    iVar.close();
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                ref$ObjectRef11 = ref$ObjectRef;
                ref$ObjectRef3 = ref$ObjectRef2;
                ref$ObjectRef4 = ref$ObjectRef8;
            }
        }
    }
}
