package p600f0.p601e0.p613n;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;
import p600f0.InterfaceC12269e;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.AbstractC12277a;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p605g.C12283c;
import p615g0.C12388e;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.n.d */
/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12355d implements WebSocket, C12359h.a {

    /* JADX INFO: renamed from: a */
    public static final List<EnumC12381y> f25821a = C12145m.listOf(EnumC12381y.HTTP_1_1);

    /* JADX INFO: renamed from: b */
    public final String f25822b;

    /* JADX INFO: renamed from: c */
    public InterfaceC12269e f25823c;

    /* JADX INFO: renamed from: d */
    public AbstractC12277a f25824d;

    /* JADX INFO: renamed from: e */
    public C12359h f25825e;

    /* JADX INFO: renamed from: f */
    public C12360i f25826f;

    /* JADX INFO: renamed from: g */
    public C12279c f25827g;

    /* JADX INFO: renamed from: h */
    public String f25828h;

    /* JADX INFO: renamed from: i */
    public c f25829i;

    /* JADX INFO: renamed from: j */
    public final ArrayDeque<ByteString> f25830j;

    /* JADX INFO: renamed from: k */
    public final ArrayDeque<Object> f25831k;

    /* JADX INFO: renamed from: l */
    public long f25832l;

    /* JADX INFO: renamed from: m */
    public boolean f25833m;

    /* JADX INFO: renamed from: n */
    public int f25834n;

    /* JADX INFO: renamed from: o */
    public String f25835o;

    /* JADX INFO: renamed from: p */
    public boolean f25836p;

    /* JADX INFO: renamed from: q */
    public int f25837q;

    /* JADX INFO: renamed from: r */
    public int f25838r;

    /* JADX INFO: renamed from: s */
    public int f25839s;

    /* JADX INFO: renamed from: t */
    public boolean f25840t;

    /* JADX INFO: renamed from: u */
    public final Request f25841u;

    /* JADX INFO: renamed from: v */
    public final WebSocketListener f25842v;

    /* JADX INFO: renamed from: w */
    public final Random f25843w;

    /* JADX INFO: renamed from: x */
    public final long f25844x;

    /* JADX INFO: renamed from: y */
    public C12357f f25845y;

    /* JADX INFO: renamed from: z */
    public long f25846z;

    /* JADX INFO: renamed from: f0.e0.n.d$a */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f25847a;

        /* JADX INFO: renamed from: b */
        public final ByteString f25848b;

        /* JADX INFO: renamed from: c */
        public final long f25849c;

        public a(int i, ByteString byteString, long j) {
            this.f25847a = i;
            this.f25848b = byteString;
            this.f25849c = j;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$b */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f25850a;

        /* JADX INFO: renamed from: b */
        public final ByteString f25851b;

        public b(int i, ByteString byteString) {
            C12238m.checkParameterIsNotNull(byteString, "data");
            this.f25850a = i;
            this.f25851b = byteString;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$c */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static abstract class c implements Closeable {

        /* JADX INFO: renamed from: j */
        public final boolean f25852j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12390g f25853k;

        /* JADX INFO: renamed from: l */
        public final BufferedSink f25854l;

        public c(boolean z2, InterfaceC12390g interfaceC12390g, BufferedSink bufferedSink) {
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            C12238m.checkParameterIsNotNull(bufferedSink, "sink");
            this.f25852j = z2;
            this.f25853k = interfaceC12390g;
            this.f25854l = bufferedSink;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$d */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public final class d extends AbstractC12277a {
        public d() {
            super(C1643a.m822J(new StringBuilder(), C12355d.this.f25828h, " writer"), false, 2);
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            try {
                return C12355d.this.m10357m() ? 0L : -1L;
            } catch (IOException e) {
                C12355d.this.m10353i(e, null);
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$e */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends AbstractC12277a {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ long f25856e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ C12355d f25857f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, long j, C12355d c12355d, String str3, c cVar, C12357f c12357f) {
            super(str2, true);
            this.f25856e = j;
            this.f25857f = c12355d;
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            C12360i c12360i;
            C12355d c12355d = this.f25857f;
            synchronized (c12355d) {
                if (!c12355d.f25836p && (c12360i = c12355d.f25826f) != null) {
                    int i = c12355d.f25840t ? c12355d.f25837q : -1;
                    c12355d.f25837q++;
                    c12355d.f25840t = true;
                    if (i != -1) {
                        StringBuilder sbM833U = C1643a.m833U("sent ping but didn't receive pong within ");
                        sbM833U.append(c12355d.f25844x);
                        sbM833U.append("ms (after ");
                        sbM833U.append(i - 1);
                        sbM833U.append(" successful ping/pongs)");
                        c12355d.m10353i(new SocketTimeoutException(sbM833U.toString()), null);
                    } else {
                        try {
                            ByteString byteString = ByteString.f27592j;
                            C12238m.checkParameterIsNotNull(byteString, "payload");
                            c12360i.m10364b(9, byteString);
                        } catch (IOException e) {
                            c12355d.m10353i(e, null);
                        }
                    }
                }
            }
            return this.f25856e;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$f */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class f extends AbstractC12277a {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ C12355d f25858e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, C12355d c12355d, C12360i c12360i, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
            super(str2, z3);
            this.f25858e = c12355d;
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            InterfaceC12269e interfaceC12269e = this.f25858e.f25823c;
            if (interfaceC12269e == null) {
                C12238m.throwNpe();
            }
            interfaceC12269e.cancel();
            return -1L;
        }
    }

    public C12355d(C12280d c12280d, Request request, WebSocketListener webSocketListener, Random random, long j, C12357f c12357f, long j2) {
        C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
        C12238m.checkParameterIsNotNull(request, "originalRequest");
        C12238m.checkParameterIsNotNull(webSocketListener, "listener");
        C12238m.checkParameterIsNotNull(random, "random");
        this.f25841u = request;
        this.f25842v = webSocketListener;
        this.f25843w = random;
        this.f25844x = j;
        this.f25845y = null;
        this.f25846z = j2;
        this.f25827g = c12280d.m10162f();
        this.f25830j = new ArrayDeque<>();
        this.f25831k = new ArrayDeque<>();
        this.f25834n = -1;
        if (!C12238m.areEqual(ShareTarget.METHOD_GET, request.method)) {
            StringBuilder sbM833U = C1643a.m833U("Request must be GET: ");
            sbM833U.append(request.method);
            throw new IllegalArgumentException(sbM833U.toString().toString());
        }
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f25822b = ByteString.Companion.m11009d(companion, bArr, 0, 0, 3).mo10500f();
    }

    @Override // okhttp3.WebSocket
    /* JADX INFO: renamed from: a */
    public boolean mo10345a(String str) {
        C12238m.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ByteString byteStringM11012c = ByteString.INSTANCE.m11012c(str);
        synchronized (this) {
            if (!this.f25836p && !this.f25833m) {
                if (this.f25832l + ((long) byteStringM11012c.mo10502j()) > Permission.MOVE_MEMBERS) {
                    mo10349e(PointerIconCompat.TYPE_CONTEXT_MENU, null);
                    return false;
                }
                this.f25832l += (long) byteStringM11012c.mo10502j();
                this.f25831k.add(new b(1, byteStringM11012c));
                m10356l();
                return true;
            }
            return false;
        }
    }

    @Override // p600f0.p601e0.p613n.C12359h.a
    /* JADX INFO: renamed from: b */
    public void mo10346b(ByteString byteString) throws IOException {
        C12238m.checkParameterIsNotNull(byteString, "bytes");
        this.f25842v.onMessage(this, byteString);
    }

    @Override // p600f0.p601e0.p613n.C12359h.a
    /* JADX INFO: renamed from: c */
    public void mo10347c(String str) throws IOException {
        C12238m.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.f25842v.onMessage(this, str);
    }

    @Override // p600f0.p601e0.p613n.C12359h.a
    /* JADX INFO: renamed from: d */
    public synchronized void mo10348d(ByteString byteString) {
        C12238m.checkParameterIsNotNull(byteString, "payload");
        if (!this.f25836p && (!this.f25833m || !this.f25831k.isEmpty())) {
            this.f25830j.add(byteString);
            m10356l();
            this.f25838r++;
        }
    }

    @Override // okhttp3.WebSocket
    /* JADX INFO: renamed from: e */
    public boolean mo10349e(int i, String str) {
        String str2;
        synchronized (this) {
            ByteString byteStringM11012c = null;
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
                        C12238m.throwNpe();
                    }
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    byteStringM11012c = ByteString.INSTANCE.m11012c(str);
                    if (!(((long) byteStringM11012c.mo10502j()) <= 123)) {
                        throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                    }
                }
                if (!this.f25836p && !this.f25833m) {
                    this.f25833m = true;
                    this.f25831k.add(new a(i, byteStringM11012c, 60000L));
                    m10356l();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p600f0.p601e0.p613n.C12359h.a
    /* JADX INFO: renamed from: f */
    public synchronized void mo10350f(ByteString byteString) {
        C12238m.checkParameterIsNotNull(byteString, "payload");
        this.f25839s++;
        this.f25840t = false;
    }

    @Override // p600f0.p601e0.p613n.C12359h.a
    /* JADX INFO: renamed from: g */
    public void mo10351g(int i, String str) {
        c cVar;
        C12359h c12359h;
        C12360i c12360i;
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        if (!(i != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (!(this.f25834n == -1)) {
                throw new IllegalStateException("already closed".toString());
            }
            this.f25834n = i;
            this.f25835o = str;
            cVar = null;
            if (this.f25833m && this.f25831k.isEmpty()) {
                c cVar2 = this.f25829i;
                this.f25829i = null;
                c12359h = this.f25825e;
                this.f25825e = null;
                c12360i = this.f25826f;
                this.f25826f = null;
                this.f25827g.m10156f();
                cVar = cVar2;
            } else {
                c12359h = null;
                c12360i = null;
            }
        }
        try {
            this.f25842v.onClosing(this, i, str);
            if (cVar != null) {
                this.f25842v.onClosed(this, i, str);
            }
            if (cVar != null) {
                byte[] bArr = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
            if (c12359h != null) {
                byte[] bArr2 = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(c12359h, "$this$closeQuietly");
                try {
                    c12359h.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            if (c12360i != null) {
                byte[] bArr3 = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(c12360i, "$this$closeQuietly");
                try {
                    c12360i.close();
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (cVar != null) {
                byte[] bArr4 = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e5) {
                    throw e5;
                } catch (Exception unused4) {
                }
            }
            if (c12359h != null) {
                byte[] bArr5 = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(c12359h, "$this$closeQuietly");
                try {
                    c12359h.close();
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused5) {
                }
            }
            if (c12360i == null) {
                throw th;
            }
            byte[] bArr6 = C12272c.f25397a;
            C12238m.checkParameterIsNotNull(c12360i, "$this$closeQuietly");
            try {
                c12360i.close();
                throw th;
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m10352h(Response response, C12283c c12283c) throws IOException {
        C12238m.checkParameterIsNotNull(response, "response");
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 101) {
            StringBuilder sbM833U = C1643a.m833U("Expected HTTP 101 response but was '");
            sbM833U.append(response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            sbM833U.append(' ');
            throw new ProtocolException(C1643a.m820H(sbM833U, response.message, '\''));
        }
        String strM10989a = Response.m10989a(response, "Connection", null, 2);
        if (!C12103t.equals("Upgrade", strM10989a, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strM10989a + '\'');
        }
        String strM10989a2 = Response.m10989a(response, "Upgrade", null, 2);
        if (!C12103t.equals("websocket", strM10989a2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strM10989a2 + '\'');
        }
        String strM10989a3 = Response.m10989a(response, "Sec-WebSocket-Accept", null, 2);
        String strMo10500f = ByteString.INSTANCE.m11012c(this.f25822b + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").mo10501g(Constants.SHA1).mo10500f();
        if (!(!C12238m.areEqual(strMo10500f, strM10989a3))) {
            if (c12283c == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strMo10500f + "' but was '" + strM10989a3 + '\'');
    }

    /* JADX INFO: renamed from: i */
    public final void m10353i(Exception exc, Response response) {
        C12238m.checkParameterIsNotNull(exc, "e");
        synchronized (this) {
            if (this.f25836p) {
                return;
            }
            this.f25836p = true;
            c cVar = this.f25829i;
            this.f25829i = null;
            C12359h c12359h = this.f25825e;
            this.f25825e = null;
            C12360i c12360i = this.f25826f;
            this.f25826f = null;
            this.f25827g.m10156f();
            try {
                this.f25842v.onFailure(this, exc, response);
                if (cVar != null) {
                    byte[] bArr = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused) {
                    }
                }
                if (c12359h != null) {
                    byte[] bArr2 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(c12359h, "$this$closeQuietly");
                    try {
                        c12359h.close();
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception unused2) {
                    }
                }
                if (c12360i != null) {
                    byte[] bArr3 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(c12360i, "$this$closeQuietly");
                    try {
                        c12360i.close();
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                if (cVar != null) {
                    byte[] bArr4 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused4) {
                    }
                }
                if (c12359h != null) {
                    byte[] bArr5 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(c12359h, "$this$closeQuietly");
                    try {
                        c12359h.close();
                    } catch (RuntimeException e6) {
                        throw e6;
                    } catch (Exception unused5) {
                    }
                }
                if (c12360i == null) {
                    throw th;
                }
                byte[] bArr6 = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(c12360i, "$this$closeQuietly");
                try {
                    c12360i.close();
                    throw th;
                } catch (RuntimeException e7) {
                    throw e7;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m10354j(String str, c cVar) throws IOException {
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(cVar, "streams");
        C12357f c12357f = this.f25845y;
        if (c12357f == null) {
            C12238m.throwNpe();
        }
        synchronized (this) {
            this.f25828h = str;
            this.f25829i = cVar;
            boolean z2 = cVar.f25852j;
            this.f25826f = new C12360i(z2, cVar.f25854l, this.f25843w, c12357f.f25861a, z2 ? c12357f.f25863c : c12357f.f25865e, this.f25846z);
            this.f25824d = new d();
            long j = this.f25844x;
            if (j != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                String str2 = str + " ping";
                this.f25827g.m10154c(new e(str2, str2, nanos, this, str, cVar, c12357f), nanos);
            }
            if (!this.f25831k.isEmpty()) {
                m10356l();
            }
        }
        boolean z3 = cVar.f25852j;
        this.f25825e = new C12359h(z3, cVar.f25853k, this, c12357f.f25861a, z3 ^ true ? c12357f.f25863c : c12357f.f25865e);
    }

    /* JADX INFO: renamed from: k */
    public final void m10355k() throws IOException {
        while (this.f25834n == -1) {
            C12359h c12359h = this.f25825e;
            if (c12359h == null) {
                C12238m.throwNpe();
            }
            c12359h.m10362b();
            if (c12359h.f25871n) {
                c12359h.m10361a();
            } else {
                int i = c12359h.f25868k;
                if (i != 1 && i != 2) {
                    StringBuilder sbM833U = C1643a.m833U("Unknown opcode: ");
                    sbM833U.append(C12272c.m10143x(i));
                    throw new ProtocolException(sbM833U.toString());
                }
                while (true) {
                    if (c12359h.f25867j) {
                        throw new IOException("closed");
                    }
                    long j = c12359h.f25869l;
                    if (j > 0) {
                        c12359h.f25879v.mo10428B(c12359h.f25874q, j);
                        if (!c12359h.f25878u) {
                            C12388e c12388e = c12359h.f25874q;
                            C12388e.a aVar = c12359h.f25877t;
                            if (aVar == null) {
                                C12238m.throwNpe();
                            }
                            c12388e.m10469u(aVar);
                            c12359h.f25877t.m10476b(c12359h.f25874q.f26080k - c12359h.f25869l);
                            C12388e.a aVar2 = c12359h.f25877t;
                            byte[] bArr = c12359h.f25876s;
                            if (bArr == null) {
                                C12238m.throwNpe();
                            }
                            C12358g.m10360a(aVar2, bArr);
                            c12359h.f25877t.close();
                        }
                    }
                    if (c12359h.f25870m) {
                        if (c12359h.f25872o) {
                            C12354c c12354c = c12359h.f25875r;
                            if (c12354c == null) {
                                c12354c = new C12354c(c12359h.f25882y);
                                c12359h.f25875r = c12354c;
                            }
                            C12388e c12388e2 = c12359h.f25874q;
                            C12238m.checkParameterIsNotNull(c12388e2, "buffer");
                            if (!(c12354c.f25817j.f26080k == 0)) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            if (c12354c.f25820m) {
                                c12354c.f25818k.reset();
                            }
                            c12354c.f25817j.mo10440P(c12388e2);
                            c12354c.f25817j.m10447W(65535);
                            long bytesRead = c12354c.f25818k.getBytesRead() + c12354c.f25817j.f26080k;
                            do {
                                c12354c.f25819l.m10488a(c12388e2, RecyclerView.FOREVER_NS);
                            } while (c12354c.f25818k.getBytesRead() < bytesRead);
                        }
                        if (i != 1) {
                            c12359h.f25880w.mo10346b(c12359h.f25874q.m10473x());
                            break;
                        } else {
                            c12359h.f25880w.mo10347c(c12359h.f25874q.m10429D());
                            break;
                        }
                    }
                    while (!c12359h.f25867j) {
                        c12359h.m10362b();
                        if (!c12359h.f25871n) {
                            break;
                        } else {
                            c12359h.m10361a();
                        }
                    }
                    if (c12359h.f25868k != 0) {
                        StringBuilder sbM833U2 = C1643a.m833U("Expected continuation opcode. Got: ");
                        sbM833U2.append(C12272c.m10143x(c12359h.f25868k));
                        throw new ProtocolException(sbM833U2.toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m10356l() {
        byte[] bArr = C12272c.f25397a;
        AbstractC12277a abstractC12277a = this.f25824d;
        if (abstractC12277a != null) {
            this.f25827g.m10154c(abstractC12277a, 0L);
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
    /* JADX INFO: renamed from: m */
    public final boolean m10357m() throws Throwable {
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$ObjectRef ref$ObjectRef4;
        Ref$ObjectRef ref$ObjectRef5;
        c cVar;
        C12359h c12359h;
        C12360i c12360i;
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
            if (this.f25836p) {
                return false;
            }
            C12360i c12360i2 = this.f25826f;
            ByteString byteStringPoll = this.f25830j.poll();
            if (byteStringPoll == null) {
                ?? Poll = this.f25831k.poll();
                ref$ObjectRef6.element = Poll;
                if (Poll instanceof a) {
                    int i = this.f25834n;
                    ref$IntRef.element = i;
                    ref$ObjectRef7.element = this.f25835o;
                    if (i != -1) {
                        ref$ObjectRef8.element = this.f25829i;
                        this.f25829i = null;
                        ref$ObjectRef9.element = this.f25825e;
                        this.f25825e = null;
                        ref$ObjectRef10.element = this.f25826f;
                        this.f25826f = null;
                        this.f25827g.m10156f();
                        ref$ObjectRef = ref$ObjectRef10;
                        ref$ObjectRef2 = ref$ObjectRef9;
                    } else {
                        T t = ref$ObjectRef6.element;
                        if (t == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        long j = ((a) t).f25849c;
                        C12279c c12279c = this.f25827g;
                        String str = this.f25828h + " cancel";
                        ref$ObjectRef = ref$ObjectRef10;
                        ref$ObjectRef2 = ref$ObjectRef9;
                        c12279c.m10154c(new f(str, true, str, true, this, c12360i2, byteStringPoll, ref$ObjectRef6, ref$IntRef, ref$ObjectRef7, ref$ObjectRef8, ref$ObjectRef2, ref$ObjectRef), TimeUnit.MILLISECONDS.toNanos(j));
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
                    ref$ObjectRef4 = c12360i2;
                    T t2 = ref$ObjectRef6.element;
                    if (t2 instanceof b) {
                        if (t2 == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                        }
                        b bVar = (b) t2;
                        if (ref$ObjectRef4 == 0) {
                            C12238m.throwNpe();
                        }
                        ref$ObjectRef4.m10365c(bVar.f25850a, bVar.f25851b);
                        synchronized (this) {
                            this.f25832l -= (long) bVar.f25851b.mo10502j();
                        }
                        c cVar2 = (c) ref$ObjectRef4.element;
                        if (cVar2 != null) {
                            byte[] bArr = C12272c.f25397a;
                            C12238m.checkParameterIsNotNull(cVar2, "$this$closeQuietly");
                            try {
                                cVar2.close();
                            } catch (RuntimeException e2) {
                                throw e2;
                            } catch (Exception unused) {
                            }
                        }
                        C12359h c12359h2 = (C12359h) ref$ObjectRef3.element;
                        if (c12359h2 != null) {
                            byte[] bArr2 = C12272c.f25397a;
                            C12238m.checkParameterIsNotNull(c12359h2, "$this$closeQuietly");
                            try {
                                c12359h2.close();
                            } catch (RuntimeException e3) {
                                throw e3;
                            } catch (Exception unused2) {
                            }
                        }
                        C12360i c12360i3 = (C12360i) ref$ObjectRef11.element;
                        if (c12360i3 == null) {
                            throw th;
                        }
                        byte[] bArr3 = C12272c.f25397a;
                        C12238m.checkParameterIsNotNull(c12360i3, "$this$closeQuietly");
                        try {
                            c12360i3.close();
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
                            C12238m.throwNpe();
                        }
                        ref$ObjectRef4.m10363a(aVar.f25847a, aVar.f25848b);
                        ref$ObjectRef4 = ref$ObjectRef8;
                        try {
                            c cVar3 = (c) ref$ObjectRef4.element;
                            ref$ObjectRef5 = ref$ObjectRef4;
                            if (cVar3 != null) {
                                WebSocketListener webSocketListener = this.f25842v;
                                int i2 = ref$IntRef.element;
                                String str2 = (String) ref$ObjectRef7.element;
                                if (str2 == null) {
                                    C12238m.throwNpe();
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
                        byte[] bArr4 = C12272c.f25397a;
                        C12238m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                        try {
                            cVar.close();
                        } catch (RuntimeException e5) {
                            throw e5;
                        } catch (Exception unused4) {
                        }
                    }
                    c12359h = (C12359h) ref$ObjectRef2.element;
                    if (c12359h != null) {
                        byte[] bArr5 = C12272c.f25397a;
                        C12238m.checkParameterIsNotNull(c12359h, "$this$closeQuietly");
                        try {
                            c12359h.close();
                        } catch (RuntimeException e6) {
                            throw e6;
                        } catch (Exception unused5) {
                        }
                    }
                    c12360i = (C12360i) ref$ObjectRef.element;
                    if (c12360i != null) {
                        byte[] bArr6 = C12272c.f25397a;
                        C12238m.checkParameterIsNotNull(c12360i, "$this$closeQuietly");
                        try {
                            c12360i.close();
                        } catch (RuntimeException e7) {
                            throw e7;
                        } catch (Exception unused6) {
                        }
                    }
                    return true;
                }
                if (c12360i2 == 0) {
                    C12238m.throwNpe();
                }
                Objects.requireNonNull(c12360i2);
                C12238m.checkParameterIsNotNull(ref$ObjectRef11, "payload");
                c12360i2.m10364b(10, ref$ObjectRef11);
                ref$ObjectRef5 = ref$ObjectRef8;
                cVar = (c) ref$ObjectRef5.element;
                if (cVar != null) {
                    byte[] bArr7 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    cVar.close();
                }
                c12359h = (C12359h) ref$ObjectRef2.element;
                if (c12359h != null) {
                    byte[] bArr8 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(c12359h, "$this$closeQuietly");
                    c12359h.close();
                }
                c12360i = (C12360i) ref$ObjectRef.element;
                if (c12360i != null) {
                    byte[] bArr9 = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(c12360i, "$this$closeQuietly");
                    c12360i.close();
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
