package f0.e0.n;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import f0.Call2;
import f0.Protocol2;
import f0.e0.Util7;
import f0.e0.f.Task2;
import f0.e0.f.TaskQueue2;
import f0.e0.f.TaskRunner;
import f0.e0.g.Exchange;
import f0.e0.n.WebSocketReader;
import g0.Buffer3;
import g0.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
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
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: renamed from: f0.e0.n.d, reason: use source file name */
/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.a {
    public static final List<Protocol2> a = CollectionsJVM.listOf(Protocol2.HTTP_1_1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3656b;
    public Call2 c;
    public Task2 d;
    public WebSocketReader e;
    public WebSocketWriter f;
    public TaskQueue2 g;
    public String h;
    public c i;
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
    public WebSocketExtensions f3659y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f3660z;

    /* JADX INFO: renamed from: f0.e0.n.d$a */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteString f3661b;
        public final long c;

        public a(int i, ByteString byteString, long j) {
            this.a = i;
            this.f3661b = byteString;
            this.c = j;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$b */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteString f3662b;

        public b(int i, ByteString byteString) {
            Intrinsics3.checkParameterIsNotNull(byteString, "data");
            this.a = i;
            this.f3662b = byteString;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$c */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static abstract class c implements Closeable {
        public final boolean j;
        public final BufferedSource k;
        public final BufferedSink l;

        public c(boolean z2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
            this.j = z2;
            this.k = bufferedSource;
            this.l = bufferedSink;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$d */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public final class d extends Task2 {
        public d() {
            super(outline.J(new StringBuilder(), RealWebSocket.this.h, " writer"), false, 2);
        }

        @Override // f0.e0.f.Task2
        public long a() {
            try {
                return RealWebSocket.this.m() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.this.i(e, null);
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$e */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends Task2 {
        public final /* synthetic */ long e;
        public final /* synthetic */ RealWebSocket f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, long j, RealWebSocket realWebSocket, String str3, c cVar, WebSocketExtensions webSocketExtensions) {
            super(str2, true);
            this.e = j;
            this.f = realWebSocket;
        }

        @Override // f0.e0.f.Task2
        public long a() {
            WebSocketWriter webSocketWriter;
            RealWebSocket realWebSocket = this.f;
            synchronized (realWebSocket) {
                if (!realWebSocket.p && (webSocketWriter = realWebSocket.f) != null) {
                    int i = realWebSocket.t ? realWebSocket.q : -1;
                    realWebSocket.q++;
                    realWebSocket.t = true;
                    if (i != -1) {
                        StringBuilder sbU = outline.U("sent ping but didn't receive pong within ");
                        sbU.append(realWebSocket.f3658x);
                        sbU.append("ms (after ");
                        sbU.append(i - 1);
                        sbU.append(" successful ping/pongs)");
                        realWebSocket.i(new SocketTimeoutException(sbU.toString()), null);
                    } else {
                        try {
                            ByteString byteString = ByteString.j;
                            Intrinsics3.checkParameterIsNotNull(byteString, "payload");
                            webSocketWriter.b(9, byteString);
                        } catch (IOException e) {
                            realWebSocket.i(e, null);
                        }
                    }
                }
            }
            return this.e;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$f */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class f extends Task2 {
        public final /* synthetic */ RealWebSocket e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, RealWebSocket realWebSocket, WebSocketWriter webSocketWriter, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
            super(str2, z3);
            this.e = realWebSocket;
        }

        @Override // f0.e0.f.Task2
        public long a() {
            Call2 call2 = this.e.c;
            if (call2 == null) {
                Intrinsics3.throwNpe();
            }
            call2.cancel();
            return -1L;
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random, long j, WebSocketExtensions webSocketExtensions, long j2) {
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics3.checkParameterIsNotNull(request, "originalRequest");
        Intrinsics3.checkParameterIsNotNull(webSocketListener, "listener");
        Intrinsics3.checkParameterIsNotNull(random, "random");
        this.u = request;
        this.v = webSocketListener;
        this.w = random;
        this.f3658x = j;
        this.f3659y = null;
        this.f3660z = j2;
        this.g = taskRunner.f();
        this.j = new ArrayDeque<>();
        this.k = new ArrayDeque<>();
        this.n = -1;
        if (!Intrinsics3.areEqual(ShareTarget.METHOD_GET, request.method)) {
            StringBuilder sbU = outline.U("Request must be GET: ");
            sbU.append(request.method);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f3656b = ByteString.Companion.d(companion, bArr, 0, 0, 3).f();
    }

    @Override // okhttp3.WebSocket
    public boolean a(String str) {
        Intrinsics3.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ByteString byteStringC = ByteString.INSTANCE.c(str);
        synchronized (this) {
            if (!this.p && !this.m) {
                if (this.l + ((long) byteStringC.j()) > Permission.MOVE_MEMBERS) {
                    e(PointerIconCompat.TYPE_CONTEXT_MENU, null);
                    return false;
                }
                this.l += (long) byteStringC.j();
                this.k.add(new b(1, byteStringC));
                l();
                return true;
            }
            return false;
        }
    }

    @Override // f0.e0.n.WebSocketReader.a
    public void b(ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, "bytes");
        this.v.onMessage(this, byteString);
    }

    @Override // f0.e0.n.WebSocketReader.a
    public void c(String str) throws IOException {
        Intrinsics3.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.v.onMessage(this, str);
    }

    @Override // f0.e0.n.WebSocketReader.a
    public synchronized void d(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "payload");
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
                        Intrinsics3.throwNpe();
                    }
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    byteStringC = ByteString.INSTANCE.c(str);
                    if (!(((long) byteStringC.j()) <= 123)) {
                        throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                    }
                }
                if (!this.p && !this.m) {
                    this.m = true;
                    this.k.add(new a(i, byteStringC, 60000L));
                    l();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f0.e0.n.WebSocketReader.a
    public synchronized void f(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "payload");
        this.f3657s++;
        this.t = false;
    }

    @Override // f0.e0.n.WebSocketReader.a
    public void g(int i, String str) {
        c cVar;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        if (!(i != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (!(this.n == -1)) {
                throw new IllegalStateException("already closed".toString());
            }
            this.n = i;
            this.o = str;
            cVar = null;
            if (this.m && this.k.isEmpty()) {
                c cVar2 = this.i;
                this.i = null;
                webSocketReader = this.e;
                this.e = null;
                webSocketWriter = this.f;
                this.f = null;
                this.g.f();
                cVar = cVar2;
            } else {
                webSocketReader = null;
                webSocketWriter = null;
            }
        }
        try {
            this.v.onClosing(this, i, str);
            if (cVar != null) {
                this.v.onClosed(this, i, str);
            }
            if (cVar != null) {
                byte[] bArr = Util7.a;
                Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
            if (webSocketReader != null) {
                byte[] bArr2 = Util7.a;
                Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                try {
                    webSocketReader.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            if (webSocketWriter != null) {
                byte[] bArr3 = Util7.a;
                Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                try {
                    webSocketWriter.close();
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (cVar != null) {
                byte[] bArr4 = Util7.a;
                Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e5) {
                    throw e5;
                } catch (Exception unused4) {
                }
            }
            if (webSocketReader != null) {
                byte[] bArr5 = Util7.a;
                Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                try {
                    webSocketReader.close();
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused5) {
                }
            }
            if (webSocketWriter == null) {
                throw th;
            }
            byte[] bArr6 = Util7.a;
            Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
            try {
                webSocketWriter.close();
                throw th;
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    public final void h(Response response, Exchange exchange) throws IOException {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 101) {
            StringBuilder sbU = outline.U("Expected HTTP 101 response but was '");
            sbU.append(response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            sbU.append(' ');
            throw new ProtocolException(outline.H(sbU, response.message, '\''));
        }
        String strA = Response.a(response, "Connection", null, 2);
        if (!StringsJVM.equals("Upgrade", strA, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + '\'');
        }
        String strA2 = Response.a(response, "Upgrade", null, 2);
        if (!StringsJVM.equals("websocket", strA2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + '\'');
        }
        String strA3 = Response.a(response, "Sec-WebSocket-Accept", null, 2);
        String strF = ByteString.INSTANCE.c(this.f3656b + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").g(Constants.SHA1).f();
        if (!(!Intrinsics3.areEqual(strF, strA3))) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strF + "' but was '" + strA3 + '\'');
    }

    public final void i(Exception exc, Response response) {
        Intrinsics3.checkParameterIsNotNull(exc, "e");
        synchronized (this) {
            if (this.p) {
                return;
            }
            this.p = true;
            c cVar = this.i;
            this.i = null;
            WebSocketReader webSocketReader = this.e;
            this.e = null;
            WebSocketWriter webSocketWriter = this.f;
            this.f = null;
            this.g.f();
            try {
                this.v.onFailure(this, exc, response);
                if (cVar != null) {
                    byte[] bArr = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused) {
                    }
                }
                if (webSocketReader != null) {
                    byte[] bArr2 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                    try {
                        webSocketReader.close();
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception unused2) {
                    }
                }
                if (webSocketWriter != null) {
                    byte[] bArr3 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                    try {
                        webSocketWriter.close();
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                if (cVar != null) {
                    byte[] bArr4 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused4) {
                    }
                }
                if (webSocketReader != null) {
                    byte[] bArr5 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                    try {
                        webSocketReader.close();
                    } catch (RuntimeException e6) {
                        throw e6;
                    } catch (Exception unused5) {
                    }
                }
                if (webSocketWriter == null) {
                    throw th;
                }
                byte[] bArr6 = Util7.a;
                Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                try {
                    webSocketWriter.close();
                    throw th;
                } catch (RuntimeException e7) {
                    throw e7;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        }
    }

    public final void j(String str, c cVar) throws IOException {
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(cVar, "streams");
        WebSocketExtensions webSocketExtensions = this.f3659y;
        if (webSocketExtensions == null) {
            Intrinsics3.throwNpe();
        }
        synchronized (this) {
            this.h = str;
            this.i = cVar;
            boolean z2 = cVar.j;
            this.f = new WebSocketWriter(z2, cVar.l, this.w, webSocketExtensions.a, z2 ? webSocketExtensions.c : webSocketExtensions.e, this.f3660z);
            this.d = new d();
            long j = this.f3658x;
            if (j != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                String str2 = str + " ping";
                this.g.c(new e(str2, str2, nanos, this, str, cVar, webSocketExtensions), nanos);
            }
            if (!this.k.isEmpty()) {
                l();
            }
        }
        boolean z3 = cVar.j;
        this.e = new WebSocketReader(z3, cVar.k, this, webSocketExtensions.a, z3 ^ true ? webSocketExtensions.c : webSocketExtensions.e);
    }

    public final void k() throws IOException {
        while (this.n == -1) {
            WebSocketReader webSocketReader = this.e;
            if (webSocketReader == null) {
                Intrinsics3.throwNpe();
            }
            webSocketReader.b();
            if (webSocketReader.n) {
                webSocketReader.a();
            } else {
                int i = webSocketReader.k;
                if (i != 1 && i != 2) {
                    StringBuilder sbU = outline.U("Unknown opcode: ");
                    sbU.append(Util7.x(i));
                    throw new ProtocolException(sbU.toString());
                }
                while (true) {
                    if (webSocketReader.j) {
                        throw new IOException("closed");
                    }
                    long j = webSocketReader.l;
                    if (j > 0) {
                        webSocketReader.v.B(webSocketReader.q, j);
                        if (!webSocketReader.u) {
                            Buffer3 buffer3 = webSocketReader.q;
                            Buffer3.a aVar = webSocketReader.t;
                            if (aVar == null) {
                                Intrinsics3.throwNpe();
                            }
                            buffer3.u(aVar);
                            webSocketReader.t.b(webSocketReader.q.k - webSocketReader.l);
                            Buffer3.a aVar2 = webSocketReader.t;
                            byte[] bArr = webSocketReader.f3665s;
                            if (bArr == null) {
                                Intrinsics3.throwNpe();
                            }
                            WebSocketProtocol.a(aVar2, bArr);
                            webSocketReader.t.close();
                        }
                    }
                    if (webSocketReader.m) {
                        if (webSocketReader.o) {
                            MessageInflater messageInflater = webSocketReader.r;
                            if (messageInflater == null) {
                                messageInflater = new MessageInflater(webSocketReader.f3667y);
                                webSocketReader.r = messageInflater;
                            }
                            Buffer3 buffer4 = webSocketReader.q;
                            Intrinsics3.checkParameterIsNotNull(buffer4, "buffer");
                            if (!(messageInflater.j.k == 0)) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            if (messageInflater.m) {
                                messageInflater.k.reset();
                            }
                            messageInflater.j.P(buffer4);
                            messageInflater.j.W(65535);
                            long bytesRead = messageInflater.k.getBytesRead() + messageInflater.j.k;
                            do {
                                messageInflater.l.a(buffer4, RecyclerView.FOREVER_NS);
                            } while (messageInflater.k.getBytesRead() < bytesRead);
                        }
                        if (i != 1) {
                            webSocketReader.w.b(webSocketReader.q.x());
                            break;
                        } else {
                            webSocketReader.w.c(webSocketReader.q.D());
                            break;
                        }
                    }
                    while (!webSocketReader.j) {
                        webSocketReader.b();
                        if (!webSocketReader.n) {
                            break;
                        } else {
                            webSocketReader.a();
                        }
                    }
                    if (webSocketReader.k != 0) {
                        StringBuilder sbU2 = outline.U("Expected continuation opcode. Got: ");
                        sbU2.append(Util7.x(webSocketReader.k));
                        throw new ProtocolException(sbU2.toString());
                    }
                }
            }
        }
    }

    public final void l() {
        byte[] bArr = Util7.a;
        Task2 task2 = this.d;
        if (task2 != null) {
            this.g.c(task2, 0L);
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
        c cVar;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
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
            WebSocketWriter webSocketWriter2 = this.f;
            ByteString byteStringPoll = this.j.poll();
            if (byteStringPoll == null) {
                ?? Poll = this.k.poll();
                ref$ObjectRef6.element = Poll;
                if (Poll instanceof a) {
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
                        long j = ((a) t).c;
                        TaskQueue2 taskQueue2 = this.g;
                        String str = this.h + " cancel";
                        ref$ObjectRef = ref$ObjectRef10;
                        ref$ObjectRef2 = ref$ObjectRef9;
                        taskQueue2.c(new f(str, true, str, true, this, webSocketWriter2, byteStringPoll, ref$ObjectRef6, ref$IntRef, ref$ObjectRef7, ref$ObjectRef8, ref$ObjectRef2, ref$ObjectRef), TimeUnit.MILLISECONDS.toNanos(j));
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
                    ref$ObjectRef4 = webSocketWriter2;
                    T t2 = ref$ObjectRef6.element;
                    if (t2 instanceof b) {
                        if (t2 == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                        }
                        b bVar = (b) t2;
                        if (ref$ObjectRef4 == 0) {
                            Intrinsics3.throwNpe();
                        }
                        ref$ObjectRef4.c(bVar.a, bVar.f3662b);
                        synchronized (this) {
                            this.l -= (long) bVar.f3662b.j();
                        }
                        c cVar2 = (c) ref$ObjectRef4.element;
                        if (cVar2 != null) {
                            byte[] bArr = Util7.a;
                            Intrinsics3.checkParameterIsNotNull(cVar2, "$this$closeQuietly");
                            try {
                                cVar2.close();
                            } catch (RuntimeException e2) {
                                throw e2;
                            } catch (Exception unused) {
                            }
                        }
                        WebSocketReader webSocketReader2 = (WebSocketReader) ref$ObjectRef3.element;
                        if (webSocketReader2 != null) {
                            byte[] bArr2 = Util7.a;
                            Intrinsics3.checkParameterIsNotNull(webSocketReader2, "$this$closeQuietly");
                            try {
                                webSocketReader2.close();
                            } catch (RuntimeException e3) {
                                throw e3;
                            } catch (Exception unused2) {
                            }
                        }
                        WebSocketWriter webSocketWriter3 = (WebSocketWriter) ref$ObjectRef11.element;
                        if (webSocketWriter3 == null) {
                            throw th;
                        }
                        byte[] bArr3 = Util7.a;
                        Intrinsics3.checkParameterIsNotNull(webSocketWriter3, "$this$closeQuietly");
                        try {
                            webSocketWriter3.close();
                            throw th;
                        } catch (RuntimeException e4) {
                            throw e4;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    ref$ObjectRef3 = t2 instanceof a;
                    try {
                        if (ref$ObjectRef3 == 0) {
                            throw new AssertionError();
                        }
                        if (t2 == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        a aVar = (a) t2;
                        if (ref$ObjectRef4 == 0) {
                            Intrinsics3.throwNpe();
                        }
                        ref$ObjectRef4.a(aVar.a, aVar.f3661b);
                        ref$ObjectRef4 = ref$ObjectRef8;
                        try {
                            c cVar3 = (c) ref$ObjectRef4.element;
                            ref$ObjectRef5 = ref$ObjectRef4;
                            if (cVar3 != null) {
                                WebSocketListener webSocketListener = this.v;
                                int i2 = ref$IntRef.element;
                                String str2 = (String) ref$ObjectRef7.element;
                                if (str2 == null) {
                                    Intrinsics3.throwNpe();
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
                    cVar = (c) ref$ObjectRef5.element;
                    if (cVar != null) {
                        byte[] bArr4 = Util7.a;
                        Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                        try {
                            cVar.close();
                        } catch (RuntimeException e5) {
                            throw e5;
                        } catch (Exception unused4) {
                        }
                    }
                    webSocketReader = (WebSocketReader) ref$ObjectRef2.element;
                    if (webSocketReader != null) {
                        byte[] bArr5 = Util7.a;
                        Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                        try {
                            webSocketReader.close();
                        } catch (RuntimeException e6) {
                            throw e6;
                        } catch (Exception unused5) {
                        }
                    }
                    webSocketWriter = (WebSocketWriter) ref$ObjectRef.element;
                    if (webSocketWriter != null) {
                        byte[] bArr6 = Util7.a;
                        Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                        try {
                            webSocketWriter.close();
                        } catch (RuntimeException e7) {
                            throw e7;
                        } catch (Exception unused6) {
                        }
                    }
                    return true;
                }
                if (webSocketWriter2 == 0) {
                    Intrinsics3.throwNpe();
                }
                Objects.requireNonNull(webSocketWriter2);
                Intrinsics3.checkParameterIsNotNull(ref$ObjectRef11, "payload");
                webSocketWriter2.b(10, ref$ObjectRef11);
                ref$ObjectRef5 = ref$ObjectRef8;
                cVar = (c) ref$ObjectRef5.element;
                if (cVar != null) {
                    byte[] bArr7 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    cVar.close();
                }
                webSocketReader = (WebSocketReader) ref$ObjectRef2.element;
                if (webSocketReader != null) {
                    byte[] bArr8 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                    webSocketReader.close();
                }
                webSocketWriter = (WebSocketWriter) ref$ObjectRef.element;
                if (webSocketWriter != null) {
                    byte[] bArr9 = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                    webSocketWriter.close();
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
