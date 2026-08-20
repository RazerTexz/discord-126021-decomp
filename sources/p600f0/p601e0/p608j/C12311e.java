package p600f0.p601e0.p608j;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSink;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.AbstractC12277a;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p609k.C12333h;
import p615g0.C12388e;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.j.e */
/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12311e implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final C12325s f25615j;

    /* JADX INFO: renamed from: k */
    public static final C12311e f25616k = null;

    /* JADX INFO: renamed from: A */
    public long f25617A;

    /* JADX INFO: renamed from: B */
    public long f25618B;

    /* JADX INFO: renamed from: C */
    public long f25619C;

    /* JADX INFO: renamed from: D */
    public final C12325s f25620D;

    /* JADX INFO: renamed from: E */
    public C12325s f25621E;

    /* JADX INFO: renamed from: F */
    public long f25622F;

    /* JADX INFO: renamed from: G */
    public long f25623G;

    /* JADX INFO: renamed from: H */
    public long f25624H;

    /* JADX INFO: renamed from: I */
    public long f25625I;

    /* JADX INFO: renamed from: J */
    public final Socket f25626J;

    /* JADX INFO: renamed from: K */
    public final C12321o f25627K;

    /* JADX INFO: renamed from: L */
    public final d f25628L;

    /* JADX INFO: renamed from: M */
    public final Set<Integer> f25629M;

    /* JADX INFO: renamed from: l */
    public final boolean f25630l;

    /* JADX INFO: renamed from: m */
    public final c f25631m;

    /* JADX INFO: renamed from: n */
    public final Map<Integer, C12320n> f25632n;

    /* JADX INFO: renamed from: o */
    public final String f25633o;

    /* JADX INFO: renamed from: p */
    public int f25634p;

    /* JADX INFO: renamed from: q */
    public int f25635q;

    /* JADX INFO: renamed from: r */
    public boolean f25636r;

    /* JADX INFO: renamed from: s */
    public final C12280d f25637s;

    /* JADX INFO: renamed from: t */
    public final C12279c f25638t;

    /* JADX INFO: renamed from: u */
    public final C12279c f25639u;

    /* JADX INFO: renamed from: v */
    public final C12279c f25640v;

    /* JADX INFO: renamed from: w */
    public final InterfaceC12324r f25641w;

    /* JADX INFO: renamed from: x */
    public long f25642x;

    /* JADX INFO: renamed from: y */
    public long f25643y;

    /* JADX INFO: renamed from: z */
    public long f25644z;

    /* JADX INFO: renamed from: f0.e0.j.e$a */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class a extends AbstractC12277a {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ C12311e f25645e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ long f25646f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, C12311e c12311e, long j) {
            super(str2, true);
            this.f25645e = c12311e;
            this.f25646f = j;
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            C12311e c12311e;
            boolean z2;
            synchronized (this.f25645e) {
                c12311e = this.f25645e;
                long j = c12311e.f25643y;
                long j2 = c12311e.f25642x;
                if (j < j2) {
                    z2 = true;
                } else {
                    c12311e.f25642x = j2 + 1;
                    z2 = false;
                }
            }
            if (!z2) {
                c12311e.m10265q(false, 1, 0);
                return this.f25646f;
            }
            EnumC12307a enumC12307a = EnumC12307a.PROTOCOL_ERROR;
            c12311e.m10258a(enumC12307a, enumC12307a, null);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$b */
    /* JADX INFO: compiled from: Http2Connection.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public Socket f25647a;

        /* JADX INFO: renamed from: b */
        public String f25648b;

        /* JADX INFO: renamed from: c */
        public InterfaceC12390g f25649c;

        /* JADX INFO: renamed from: d */
        public BufferedSink f25650d;

        /* JADX INFO: renamed from: e */
        public c f25651e;

        /* JADX INFO: renamed from: f */
        public InterfaceC12324r f25652f;

        /* JADX INFO: renamed from: g */
        public int f25653g;

        /* JADX INFO: renamed from: h */
        public boolean f25654h;

        /* JADX INFO: renamed from: i */
        public final C12280d f25655i;

        public b(boolean z2, C12280d c12280d) {
            C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
            this.f25654h = z2;
            this.f25655i = c12280d;
            this.f25651e = c.f25656a;
            this.f25652f = InterfaceC12324r.f25751a;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$c */
    /* JADX INFO: compiled from: Http2Connection.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a */
        public static final c f25656a = new a();

        /* JADX INFO: renamed from: f0.e0.j.e$c$a */
        /* JADX INFO: compiled from: Http2Connection.kt */
        public static final class a extends c {
            @Override // p600f0.p601e0.p608j.C12311e.c
            /* JADX INFO: renamed from: b */
            public void mo10193b(C12320n c12320n) throws IOException {
                C12238m.checkParameterIsNotNull(c12320n, "stream");
                c12320n.m10284c(EnumC12307a.REFUSED_STREAM, null);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo10192a(C12311e c12311e, C12325s c12325s) {
            C12238m.checkParameterIsNotNull(c12311e, "connection");
            C12238m.checkParameterIsNotNull(c12325s, "settings");
        }

        /* JADX INFO: renamed from: b */
        public abstract void mo10193b(C12320n c12320n) throws IOException;
    }

    /* JADX INFO: renamed from: f0.e0.j.e$d */
    /* JADX INFO: compiled from: Http2Connection.kt */
    public final class d implements C12319m.b, Function0<Unit> {

        /* JADX INFO: renamed from: j */
        public final C12319m f25657j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ C12311e f25658k;

        /* JADX INFO: renamed from: f0.e0.j.e$d$a */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class a extends AbstractC12277a {

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ C12320n f25659e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ d f25660f;

            /* JADX INFO: renamed from: g */
            public final /* synthetic */ List f25661g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z2, String str2, boolean z3, C12320n c12320n, d dVar, C12320n c12320n2, int i, List list, boolean z4) {
                super(str2, z3);
                this.f25659e = c12320n;
                this.f25660f = dVar;
                this.f25661g = list;
            }

            @Override // p600f0.p601e0.p604f.AbstractC12277a
            /* JADX INFO: renamed from: a */
            public long mo10150a() {
                try {
                    this.f25660f.f25658k.f25631m.mo10193b(this.f25659e);
                    return -1L;
                } catch (IOException e) {
                    C12333h.a aVar = C12333h.f25785c;
                    C12333h c12333h = C12333h.f25783a;
                    StringBuilder sbM833U = C1643a.m833U("Http2Connection.Listener failure for ");
                    sbM833U.append(this.f25660f.f25658k.f25633o);
                    c12333h.m10330i(sbM833U.toString(), 4, e);
                    try {
                        this.f25659e.m10284c(EnumC12307a.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: f0.e0.j.e$d$b */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class b extends AbstractC12277a {

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ d f25662e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ int f25663f;

            /* JADX INFO: renamed from: g */
            public final /* synthetic */ int f25664g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z2, String str2, boolean z3, d dVar, int i, int i2) {
                super(str2, z3);
                this.f25662e = dVar;
                this.f25663f = i;
                this.f25664g = i2;
            }

            @Override // p600f0.p601e0.p604f.AbstractC12277a
            /* JADX INFO: renamed from: a */
            public long mo10150a() {
                this.f25662e.f25658k.m10265q(true, this.f25663f, this.f25664g);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: f0.e0.j.e$d$c */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class c extends AbstractC12277a {

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ d f25665e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ boolean f25666f;

            /* JADX INFO: renamed from: g */
            public final /* synthetic */ C12325s f25667g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z2, String str2, boolean z3, d dVar, boolean z4, C12325s c12325s) {
                super(str2, z3);
                this.f25665e = dVar;
                this.f25666f = z4;
                this.f25667g = c12325s;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, f0.e0.j.s, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v0, types: [T, f0.e0.j.s] */
            @Override // p600f0.p601e0.p604f.AbstractC12277a
            /* JADX INFO: renamed from: a */
            public long mo10150a() throws Throwable {
                C12321o c12321o;
                C12311e c12311e;
                T t;
                d dVar = this.f25665e;
                boolean z2 = this.f25666f;
                ?? r10 = this.f25667g;
                Objects.requireNonNull(dVar);
                C12238m.checkParameterIsNotNull(r10, "settings");
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                C12321o c12321o2 = dVar.f25658k.f25627K;
                synchronized (c12321o2) {
                    try {
                        C12311e c12311e2 = dVar.f25658k;
                        try {
                            synchronized (c12311e2) {
                                try {
                                    C12325s c12325s = dVar.f25658k.f25621E;
                                    if (z2) {
                                        ref$ObjectRef2.element = r10;
                                    } else {
                                        ?? c12325s2 = new C12325s();
                                        c12325s2.m10313b(c12325s);
                                        c12325s2.m10313b(r10);
                                        ref$ObjectRef2.element = c12325s2;
                                    }
                                    long jM10312a = ((long) ((C12325s) ref$ObjectRef2.element).m10312a()) - ((long) c12325s.m10312a());
                                    ref$LongRef.element = jM10312a;
                                    if (jM10312a == 0 || dVar.f25658k.f25632n.isEmpty()) {
                                        t = 0;
                                    } else {
                                        Object[] array = dVar.f25658k.f25632n.values().toArray(new C12320n[0]);
                                        if (array == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                        t = (C12320n[]) array;
                                    }
                                    ref$ObjectRef.element = t;
                                    C12311e c12311e3 = dVar.f25658k;
                                    C12325s c12325s3 = (C12325s) ref$ObjectRef2.element;
                                    Objects.requireNonNull(c12311e3);
                                    C12238m.checkParameterIsNotNull(c12325s3, "<set-?>");
                                    c12311e3.f25621E = c12325s3;
                                    C12279c c12279c = dVar.f25658k.f25640v;
                                    String str = dVar.f25658k.f25633o + " onSettings";
                                    c12311e = c12311e2;
                                    c12321o = c12321o2;
                                    try {
                                        c12279c.m10154c(new C12312f(str, true, str, true, dVar, z2, ref$ObjectRef2, r10, ref$LongRef, ref$ObjectRef), 0L);
                                        try {
                                            dVar.f25658k.f25627K.m10298a((C12325s) ref$ObjectRef2.element);
                                        } catch (IOException e) {
                                            C12311e c12311e4 = dVar.f25658k;
                                            EnumC12307a enumC12307a = EnumC12307a.PROTOCOL_ERROR;
                                            c12311e4.m10258a(enumC12307a, enumC12307a, e);
                                        }
                                        C12320n[] c12320nArr = (C12320n[]) ref$ObjectRef.element;
                                        if (c12320nArr == null) {
                                            return -1L;
                                        }
                                        if (c12320nArr == null) {
                                            C12238m.throwNpe();
                                        }
                                        for (C12320n c12320n : c12320nArr) {
                                            synchronized (c12320n) {
                                                long j = ref$LongRef.element;
                                                c12320n.f25715d += j;
                                                if (j > 0) {
                                                    c12320n.notifyAll();
                                                }
                                            }
                                        }
                                        return -1L;
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    c12311e = c12311e2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        c12321o = c12321o2;
                    }
                }
            }
        }

        public d(C12311e c12311e, C12319m c12319m) {
            C12238m.checkParameterIsNotNull(c12319m, "reader");
            this.f25658k = c12311e;
            this.f25657j = c12319m;
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: a */
        public void mo10268a() {
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: b */
        public void mo10269b(boolean z2, C12325s c12325s) {
            C12238m.checkParameterIsNotNull(c12325s, "settings");
            C12279c c12279c = this.f25658k.f25638t;
            String strM822J = C1643a.m822J(new StringBuilder(), this.f25658k.f25633o, " applyAndAckSettings");
            c12279c.m10154c(new c(strM822J, true, strM822J, true, this, z2, c12325s), 0L);
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: c */
        public void mo10270c(boolean z2, int i, int i2, List<C12308b> list) {
            C12238m.checkParameterIsNotNull(list, "headerBlock");
            if (this.f25658k.m10260c(i)) {
                C12311e c12311e = this.f25658k;
                Objects.requireNonNull(c12311e);
                C12238m.checkParameterIsNotNull(list, "requestHeaders");
                C12279c c12279c = c12311e.f25639u;
                String str = c12311e.f25633o + '[' + i + "] onHeaders";
                c12279c.m10154c(new C12314h(str, true, str, true, c12311e, i, list, z2), 0L);
                return;
            }
            synchronized (this.f25658k) {
                C12320n c12320nM10259b = this.f25658k.m10259b(i);
                if (c12320nM10259b != null) {
                    c12320nM10259b.m10291j(C12272c.m10142w(list), z2);
                    return;
                }
                C12311e c12311e2 = this.f25658k;
                if (c12311e2.f25636r) {
                    return;
                }
                if (i <= c12311e2.f25634p) {
                    return;
                }
                if (i % 2 == c12311e2.f25635q % 2) {
                    return;
                }
                C12320n c12320n = new C12320n(i, this.f25658k, false, z2, C12272c.m10142w(list));
                C12311e c12311e3 = this.f25658k;
                c12311e3.f25634p = i;
                c12311e3.f25632n.put(Integer.valueOf(i), c12320n);
                C12279c c12279cM10162f = this.f25658k.f25637s.m10162f();
                String str2 = this.f25658k.f25633o + '[' + i + "] onStream";
                c12279cM10162f.m10154c(new a(str2, true, str2, true, c12320n, this, c12320nM10259b, i, list, z2), 0L);
            }
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: d */
        public void mo10271d(int i, long j) {
            if (i == 0) {
                synchronized (this.f25658k) {
                    C12311e c12311e = this.f25658k;
                    c12311e.f25625I += j;
                    c12311e.notifyAll();
                }
                return;
            }
            C12320n c12320nM10259b = this.f25658k.m10259b(i);
            if (c12320nM10259b != null) {
                synchronized (c12320nM10259b) {
                    c12320nM10259b.f25715d += j;
                    if (j > 0) {
                        c12320nM10259b.notifyAll();
                    }
                }
            }
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: e */
        public void mo10272e(boolean z2, int i, InterfaceC12390g interfaceC12390g, int i2) throws IOException {
            boolean z3;
            boolean z4;
            long j;
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            if (this.f25658k.m10260c(i)) {
                C12311e c12311e = this.f25658k;
                Objects.requireNonNull(c12311e);
                C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
                C12388e c12388e = new C12388e();
                long j2 = i2;
                interfaceC12390g.mo10463p0(j2);
                interfaceC12390g.mo10176i0(c12388e, j2);
                C12279c c12279c = c12311e.f25639u;
                String str = c12311e.f25633o + '[' + i + "] onData";
                c12279c.m10154c(new C12313g(str, true, str, true, c12311e, i, c12388e, i2, z2), 0L);
                return;
            }
            C12320n c12320nM10259b = this.f25658k.m10259b(i);
            if (c12320nM10259b == null) {
                this.f25658k.m10266s(i, EnumC12307a.PROTOCOL_ERROR);
                long j3 = i2;
                this.f25658k.m10263f(j3);
                interfaceC12390g.skip(j3);
                return;
            }
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            byte[] bArr = C12272c.f25397a;
            C12320n.b bVar = c12320nM10259b.f25718g;
            long j4 = i2;
            Objects.requireNonNull(bVar);
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            while (true) {
                boolean z5 = true;
                if (j4 <= 0) {
                    break;
                }
                synchronized (C12320n.this) {
                    z3 = bVar.f25734n;
                    z4 = bVar.f25731k.f26080k + j4 > bVar.f25733m;
                }
                if (z4) {
                    interfaceC12390g.skip(j4);
                    C12320n.this.m10286e(EnumC12307a.FLOW_CONTROL_ERROR);
                    break;
                }
                if (z3) {
                    interfaceC12390g.skip(j4);
                    break;
                }
                long jMo10176i0 = interfaceC12390g.mo10176i0(bVar.f25730j, j4);
                if (jMo10176i0 == -1) {
                    throw new EOFException();
                }
                j4 -= jMo10176i0;
                synchronized (C12320n.this) {
                    if (bVar.f25732l) {
                        C12388e c12388e2 = bVar.f25730j;
                        j = c12388e2.f26080k;
                        c12388e2.skip(j);
                    } else {
                        C12388e c12388e3 = bVar.f25731k;
                        if (c12388e3.f26080k != 0) {
                            z5 = false;
                        }
                        c12388e3.mo10440P(bVar.f25730j);
                        if (z5) {
                            C12320n c12320n = C12320n.this;
                            if (c12320n == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                            c12320n.notifyAll();
                        }
                        j = 0;
                    }
                }
                if (j > 0) {
                    bVar.m10295a(j);
                }
            }
            if (z2) {
                c12320nM10259b.m10291j(C12272c.f25398b, true);
            }
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: f */
        public void mo10273f(boolean z2, int i, int i2) {
            if (!z2) {
                C12279c c12279c = this.f25658k.f25638t;
                String strM822J = C1643a.m822J(new StringBuilder(), this.f25658k.f25633o, " ping");
                c12279c.m10154c(new b(strM822J, true, strM822J, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.f25658k) {
                try {
                    if (i == 1) {
                        this.f25658k.f25643y++;
                    } else if (i == 2) {
                        this.f25658k.f25617A++;
                    } else if (i == 3) {
                        C12311e c12311e = this.f25658k;
                        c12311e.f25618B++;
                        c12311e.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: g */
        public void mo10274g(int i, int i2, int i3, boolean z2) {
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: h */
        public void mo10275h(int i, EnumC12307a enumC12307a) {
            C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
            if (!this.f25658k.m10260c(i)) {
                C12320n c12320nM10261d = this.f25658k.m10261d(i);
                if (c12320nM10261d != null) {
                    c12320nM10261d.m10292k(enumC12307a);
                    return;
                }
                return;
            }
            C12311e c12311e = this.f25658k;
            Objects.requireNonNull(c12311e);
            C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
            C12279c c12279c = c12311e.f25639u;
            String str = c12311e.f25633o + '[' + i + "] onReset";
            c12279c.m10154c(new C12316j(str, true, str, true, c12311e, i, enumC12307a), 0L);
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: i */
        public void mo10276i(int i, int i2, List<C12308b> list) {
            C12238m.checkParameterIsNotNull(list, "requestHeaders");
            C12311e c12311e = this.f25658k;
            Objects.requireNonNull(c12311e);
            C12238m.checkParameterIsNotNull(list, "requestHeaders");
            synchronized (c12311e) {
                if (c12311e.f25629M.contains(Integer.valueOf(i2))) {
                    c12311e.m10266s(i2, EnumC12307a.PROTOCOL_ERROR);
                    return;
                }
                c12311e.f25629M.add(Integer.valueOf(i2));
                C12279c c12279c = c12311e.f25639u;
                String str = c12311e.f25633o + '[' + i2 + "] onRequest";
                c12279c.m10154c(new C12315i(str, true, str, true, c12311e, i2, list), 0L);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [f0.e0.j.a] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit] */
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
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws Throwable {
            Throwable th;
            EnumC12307a enumC12307a;
            EnumC12307a enumC12307a2 = EnumC12307a.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.f25657j.m10279b(this);
                    while (this.f25657j.m10278a(false, this)) {
                    }
                    EnumC12307a enumC12307a3 = EnumC12307a.NO_ERROR;
                    try {
                        this.f25658k.m10258a(enumC12307a3, EnumC12307a.CANCEL, null);
                        enumC12307a = enumC12307a3;
                    } catch (IOException e2) {
                        e = e2;
                        EnumC12307a enumC12307a4 = EnumC12307a.PROTOCOL_ERROR;
                        C12311e c12311e = this.f25658k;
                        c12311e.m10258a(enumC12307a4, enumC12307a4, e);
                        enumC12307a = c12311e;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f25658k.m10258a(enumC12307a, enumC12307a2, e);
                    C12272c.m10123d(this.f25657j);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                enumC12307a = enumC12307a2;
                this.f25658k.m10258a(enumC12307a, enumC12307a2, e);
                C12272c.m10123d(this.f25657j);
                throw th;
            }
            C12272c.m10123d(this.f25657j);
            enumC12307a2 = Unit.f27425a;
            return enumC12307a2;
        }

        @Override // p600f0.p601e0.p608j.C12319m.b
        /* JADX INFO: renamed from: j */
        public void mo10277j(int i, EnumC12307a enumC12307a, ByteString byteString) {
            int i2;
            C12320n[] c12320nArr;
            C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
            C12238m.checkParameterIsNotNull(byteString, "debugData");
            byteString.mo10502j();
            synchronized (this.f25658k) {
                Object[] array = this.f25658k.f25632n.values().toArray(new C12320n[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c12320nArr = (C12320n[]) array;
                this.f25658k.f25636r = true;
            }
            for (C12320n c12320n : c12320nArr) {
                if (c12320n.f25724m > i && c12320n.m10289h()) {
                    c12320n.m10292k(EnumC12307a.REFUSED_STREAM);
                    this.f25658k.m10261d(c12320n.f25724m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$e */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends AbstractC12277a {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ C12311e f25668e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ int f25669f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ EnumC12307a f25670g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z2, String str2, boolean z3, C12311e c12311e, int i, EnumC12307a enumC12307a) {
            super(str2, z3);
            this.f25668e = c12311e;
            this.f25669f = i;
            this.f25670g = enumC12307a;
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            try {
                C12311e c12311e = this.f25668e;
                int i = this.f25669f;
                EnumC12307a enumC12307a = this.f25670g;
                Objects.requireNonNull(c12311e);
                C12238m.checkParameterIsNotNull(enumC12307a, "statusCode");
                c12311e.f25627K.m10304n(i, enumC12307a);
                return -1L;
            } catch (IOException e) {
                C12311e c12311e2 = this.f25668e;
                EnumC12307a enumC12307a2 = EnumC12307a.PROTOCOL_ERROR;
                c12311e2.m10258a(enumC12307a2, enumC12307a2, e);
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$f */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class f extends AbstractC12277a {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ C12311e f25671e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ int f25672f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ long f25673g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, C12311e c12311e, int i, long j) {
            super(str2, z3);
            this.f25671e = c12311e;
            this.f25672f = i;
            this.f25673g = j;
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            try {
                this.f25671e.f25627K.m10305q(this.f25672f, this.f25673g);
                return -1L;
            } catch (IOException e) {
                C12311e c12311e = this.f25671e;
                EnumC12307a enumC12307a = EnumC12307a.PROTOCOL_ERROR;
                c12311e.m10258a(enumC12307a, enumC12307a, e);
                return -1L;
            }
        }
    }

    static {
        C12325s c12325s = new C12325s();
        c12325s.m10314c(7, 65535);
        c12325s.m10314c(5, 16384);
        f25615j = c12325s;
    }

    public C12311e(b bVar) {
        C12238m.checkParameterIsNotNull(bVar, "builder");
        boolean z2 = bVar.f25654h;
        this.f25630l = z2;
        this.f25631m = bVar.f25651e;
        this.f25632n = new LinkedHashMap();
        String str = bVar.f25648b;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("connectionName");
        }
        this.f25633o = str;
        this.f25635q = bVar.f25654h ? 3 : 2;
        C12280d c12280d = bVar.f25655i;
        this.f25637s = c12280d;
        C12279c c12279cM10162f = c12280d.m10162f();
        this.f25638t = c12279cM10162f;
        this.f25639u = c12280d.m10162f();
        this.f25640v = c12280d.m10162f();
        this.f25641w = bVar.f25652f;
        C12325s c12325s = new C12325s();
        if (bVar.f25654h) {
            c12325s.m10314c(7, 16777216);
        }
        this.f25620D = c12325s;
        C12325s c12325s2 = f25615j;
        this.f25621E = c12325s2;
        this.f25625I = c12325s2.m10312a();
        Socket socket = bVar.f25647a;
        if (socket == null) {
            C12238m.throwUninitializedPropertyAccessException("socket");
        }
        this.f25626J = socket;
        BufferedSink bufferedSink = bVar.f25650d;
        if (bufferedSink == null) {
            C12238m.throwUninitializedPropertyAccessException("sink");
        }
        this.f25627K = new C12321o(bufferedSink, z2);
        InterfaceC12390g interfaceC12390g = bVar.f25649c;
        if (interfaceC12390g == null) {
            C12238m.throwUninitializedPropertyAccessException("source");
        }
        this.f25628L = new d(this, new C12319m(interfaceC12390g, z2));
        this.f25629M = new LinkedHashSet();
        int i = bVar.f25653g;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            String strM883w = C1643a.m883w(str, " ping");
            c12279cM10162f.m10154c(new a(strM883w, strM883w, this, nanos), nanos);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m10258a(EnumC12307a enumC12307a, EnumC12307a enumC12307a2, IOException iOException) {
        int i;
        C12238m.checkParameterIsNotNull(enumC12307a, "connectionCode");
        C12238m.checkParameterIsNotNull(enumC12307a2, "streamCode");
        byte[] bArr = C12272c.f25397a;
        try {
            m10262e(enumC12307a);
        } catch (IOException unused) {
        }
        C12320n[] c12320nArr = null;
        synchronized (this) {
            if (!this.f25632n.isEmpty()) {
                Object[] array = this.f25632n.values().toArray(new C12320n[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c12320nArr = (C12320n[]) array;
                this.f25632n.clear();
            }
        }
        if (c12320nArr != null) {
            for (C12320n c12320n : c12320nArr) {
                try {
                    c12320n.m10284c(enumC12307a2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f25627K.close();
        } catch (IOException unused3) {
        }
        try {
            this.f25626J.close();
        } catch (IOException unused4) {
        }
        this.f25638t.m10156f();
        this.f25639u.m10156f();
        this.f25640v.m10156f();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized C12320n m10259b(int i) {
        return this.f25632n.get(Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: c */
    public final boolean m10260c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m10258a(EnumC12307a.NO_ERROR, EnumC12307a.CANCEL, null);
    }

    /* JADX INFO: renamed from: d */
    public final synchronized C12320n m10261d(int i) {
        C12320n c12320nRemove;
        c12320nRemove = this.f25632n.remove(Integer.valueOf(i));
        notifyAll();
        return c12320nRemove;
    }

    /* JADX INFO: renamed from: e */
    public final void m10262e(EnumC12307a enumC12307a) throws IOException {
        C12238m.checkParameterIsNotNull(enumC12307a, "statusCode");
        synchronized (this.f25627K) {
            synchronized (this) {
                if (this.f25636r) {
                    return;
                }
                this.f25636r = true;
                this.f25627K.m10301d(this.f25634p, enumC12307a, C12272c.f25397a);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final synchronized void m10263f(long j) {
        long j2 = this.f25622F + j;
        this.f25622F = j2;
        long j3 = j2 - this.f25623G;
        if (j3 >= this.f25620D.m10312a() / 2) {
            m10267t(0, j3);
            this.f25623G += j3;
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m10264n(int i, boolean z2, C12388e c12388e, long j) throws IOException {
        long j2;
        long j3;
        int iMin;
        if (j == 0) {
            this.f25627K.m10299b(z2, i, c12388e, 0);
            return;
        }
        while (j > 0) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.f25624H;
                        j3 = this.f25625I;
                        if (j2 >= j3) {
                            if (!this.f25632n.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                int iMin2 = (int) Math.min(j, j3 - j2);
                ref$IntRef.element = iMin2;
                iMin = Math.min(iMin2, this.f25627K.f25739l);
                ref$IntRef.element = iMin;
                this.f25624H += (long) iMin;
            }
            j -= (long) iMin;
            this.f25627K.m10299b(z2 && j == 0, i, c12388e, iMin);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m10265q(boolean z2, int i, int i2) {
        try {
            this.f25627K.m10303f(z2, i, i2);
        } catch (IOException e2) {
            EnumC12307a enumC12307a = EnumC12307a.PROTOCOL_ERROR;
            m10258a(enumC12307a, enumC12307a, e2);
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m10266s(int i, EnumC12307a enumC12307a) {
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
        C12279c c12279c = this.f25638t;
        String str = this.f25633o + '[' + i + "] writeSynReset";
        c12279c.m10154c(new e(str, true, str, true, this, i, enumC12307a), 0L);
    }

    /* JADX INFO: renamed from: t */
    public final void m10267t(int i, long j) {
        C12279c c12279c = this.f25638t;
        String str = this.f25633o + '[' + i + "] windowUpdate";
        c12279c.m10154c(new f(str, true, str, true, this, i, j), 0L);
    }
}
