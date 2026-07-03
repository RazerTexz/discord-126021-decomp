package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p243a3.C2566t;
import p007b.p225i.p226a.p242c.p257e3.C2717s;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2721w;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2745l;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k;
import p007b.p225i.p226a.p242c.p265v2.InterfaceC2954b;
import p007b.p225i.p226a.p242c.p266w2.C2972d0;
import p007b.p225i.p226a.p242c.p266w2.C2991v;
import p007b.p225i.p226a.p242c.p266w2.C2992w;
import p007b.p225i.p226a.p242c.p266w2.C2993x;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2974e0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public class DefaultDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final List<DrmInitData.SchemeData> f19784a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2966a0 f19785b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC10699a f19786c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC10700b f19787d;

    /* JADX INFO: renamed from: e */
    public final int f19788e;

    /* JADX INFO: renamed from: f */
    public final boolean f19789f;

    /* JADX INFO: renamed from: g */
    public final boolean f19790g;

    /* JADX INFO: renamed from: h */
    public final HashMap<String, String> f19791h;

    /* JADX INFO: renamed from: i */
    public final C2745l<InterfaceC2988s.a> f19792i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC2721w f19793j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC2974e0 f19794k;

    /* JADX INFO: renamed from: l */
    public final UUID f19795l;

    /* JADX INFO: renamed from: m */
    public final HandlerC10703e f19796m;

    /* JADX INFO: renamed from: n */
    public int f19797n;

    /* JADX INFO: renamed from: o */
    public int f19798o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public HandlerThread f19799p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public HandlerC10701c f19800q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public InterfaceC2954b f19801r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public DrmSession.DrmSessionException f19802s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public byte[] f19803t;

    /* JADX INFO: renamed from: u */
    public byte[] f19804u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public InterfaceC2966a0.a f19805v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public InterfaceC2966a0.d f19806w;

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSession$a */
    public interface InterfaceC10699a {
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSession$b */
    public interface InterfaceC10700b {
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSession$c */
    @SuppressLint({"HandlerLeak"})
    public class HandlerC10701c extends Handler {

        /* JADX INFO: renamed from: a */
        @GuardedBy("this")
        public boolean f19807a;

        public HandlerC10701c(Looper looper) {
            super(looper);
        }

        /* JADX INFO: renamed from: a */
        public void m8824a(int i, Object obj, boolean z2) {
            obtainMessage(i, new C10702d(C2566t.f5703a.getAndIncrement(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004a  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long jMin;
            boolean z2;
            Object objM3585c;
            C10702d c10702d = (C10702d) message.obj;
            boolean z3 = true;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    objM3585c = ((C2972d0) defaultDrmSession.f19794k).m3585c(defaultDrmSession.f19795l, (InterfaceC2966a0.d) c10702d.f19812d);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    objM3585c = ((C2972d0) defaultDrmSession2.f19794k).m3584a(defaultDrmSession2.f19795l, (InterfaceC2966a0.a) c10702d.f19812d);
                }
            } catch (MediaDrmCallbackException e) {
                C10702d c10702d2 = (C10702d) message.obj;
                if (c10702d2.f19810b) {
                    int i2 = c10702d2.f19813e + 1;
                    c10702d2.f19813e = i2;
                    if (i2 > ((C2717s) DefaultDrmSession.this.f19793j).m2873a(3)) {
                        z3 = false;
                    } else {
                        SystemClock.elapsedRealtime();
                        SystemClock.elapsedRealtime();
                        Throwable unexpectedDrmSessionException = e.getCause() instanceof IOException ? (IOException) e.getCause() : new UnexpectedDrmSessionException(e.getCause());
                        InterfaceC2721w interfaceC2721w = DefaultDrmSession.this.f19793j;
                        int i3 = c10702d2.f19813e;
                        if ((unexpectedDrmSessionException instanceof ParserException) || (unexpectedDrmSessionException instanceof FileNotFoundException) || (unexpectedDrmSessionException instanceof HttpDataSource$CleartextNotPermittedException) || (unexpectedDrmSessionException instanceof Loader.UnexpectedLoaderException)) {
                            jMin = -9223372036854775807L;
                        } else {
                            int i4 = DataSourceException.f20224j;
                            while (true) {
                                if (unexpectedDrmSessionException == null) {
                                    z2 = false;
                                    break;
                                } else {
                                    if ((unexpectedDrmSessionException instanceof DataSourceException) && ((DataSourceException) unexpectedDrmSessionException).reason == 2008) {
                                        z2 = true;
                                        break;
                                    }
                                    unexpectedDrmSessionException = unexpectedDrmSessionException.getCause();
                                }
                            }
                            if (z2) {
                                jMin = -9223372036854775807L;
                            } else {
                                jMin = Math.min((i3 - 1) * 1000, 5000);
                            }
                        }
                        if (jMin == -9223372036854775807L) {
                            z3 = false;
                        } else {
                            synchronized (this) {
                                if (this.f19807a) {
                                    z3 = false;
                                } else {
                                    sendMessageDelayed(Message.obtain(message), jMin);
                                }
                            }
                        }
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    return;
                } else {
                    objM3585c = e;
                }
            } catch (Exception e2) {
                C2750q.m3040c("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                objM3585c = e2;
            }
            InterfaceC2721w interfaceC2721w2 = DefaultDrmSession.this.f19793j;
            long j = c10702d.f19809a;
            Objects.requireNonNull(interfaceC2721w2);
            synchronized (this) {
                if (!this.f19807a) {
                    DefaultDrmSession.this.f19796m.obtainMessage(message.what, Pair.create(c10702d.f19812d, objM3585c)).sendToTarget();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSession$d */
    public static final class C10702d {

        /* JADX INFO: renamed from: a */
        public final long f19809a;

        /* JADX INFO: renamed from: b */
        public final boolean f19810b;

        /* JADX INFO: renamed from: c */
        public final long f19811c;

        /* JADX INFO: renamed from: d */
        public final Object f19812d;

        /* JADX INFO: renamed from: e */
        public int f19813e;

        public C10702d(long j, boolean z2, long j2, Object obj) {
            this.f19809a = j;
            this.f19810b = z2;
            this.f19811c = j2;
            this.f19812d = obj;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSession$e */
    @SuppressLint({"HandlerLeak"})
    public class HandlerC10703e extends Handler {
        public HandlerC10703e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                if (obj == defaultDrmSession.f19806w) {
                    if (defaultDrmSession.f19797n == 2 || defaultDrmSession.m8817j()) {
                        defaultDrmSession.f19806w = null;
                        if (obj2 instanceof Exception) {
                            ((DefaultDrmSessionManager.C10708e) defaultDrmSession.f19786c).m8834a((Exception) obj2, false);
                            return;
                        }
                        try {
                            defaultDrmSession.f19785b.mo3578j((byte[]) obj2);
                            DefaultDrmSessionManager.C10708e c10708e = (DefaultDrmSessionManager.C10708e) defaultDrmSession.f19786c;
                            c10708e.f19845b = null;
                            AbstractC4523p abstractC4523pM6264n = AbstractC4523p.m6264n(c10708e.f19844a);
                            c10708e.f19844a.clear();
                            AbstractC4493a abstractC4493aListIterator = abstractC4523pM6264n.listIterator();
                            while (abstractC4493aListIterator.hasNext()) {
                                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) abstractC4493aListIterator.next();
                                if (defaultDrmSession2.m8820m()) {
                                    defaultDrmSession2.m8816i(true);
                                }
                            }
                            return;
                        } catch (Exception e) {
                            ((DefaultDrmSessionManager.C10708e) defaultDrmSession.f19786c).m8834a(e, true);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i != 1) {
                return;
            }
            DefaultDrmSession defaultDrmSession3 = DefaultDrmSession.this;
            if (obj == defaultDrmSession3.f19805v && defaultDrmSession3.m8817j()) {
                defaultDrmSession3.f19805v = null;
                if (obj2 instanceof Exception) {
                    defaultDrmSession3.m8819l((Exception) obj2, false);
                    return;
                }
                try {
                    byte[] bArr = (byte[]) obj2;
                    if (defaultDrmSession3.f19788e == 3) {
                        InterfaceC2966a0 interfaceC2966a0 = defaultDrmSession3.f19785b;
                        byte[] bArr2 = defaultDrmSession3.f19804u;
                        int i2 = C2738e0.f6708a;
                        interfaceC2966a0.mo3577i(bArr2, bArr);
                        defaultDrmSession3.m8815h(new InterfaceC2744k() { // from class: b.i.a.c.w2.a
                            @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k
                            public final void accept(Object obj3) {
                                ((InterfaceC2988s.a) obj3).m3588b();
                            }
                        });
                        return;
                    }
                    byte[] bArrMo3577i = defaultDrmSession3.f19785b.mo3577i(defaultDrmSession3.f19803t, bArr);
                    int i3 = defaultDrmSession3.f19788e;
                    if ((i3 == 2 || (i3 == 0 && defaultDrmSession3.f19804u != null)) && bArrMo3577i != null && bArrMo3577i.length != 0) {
                        defaultDrmSession3.f19804u = bArrMo3577i;
                    }
                    defaultDrmSession3.f19797n = 4;
                    defaultDrmSession3.m8815h(new InterfaceC2744k() { // from class: b.i.a.c.w2.p
                        @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k
                        public final void accept(Object obj3) {
                            ((InterfaceC2988s.a) obj3).m3587a();
                        }
                    });
                } catch (Exception e2) {
                    defaultDrmSession3.m8819l(e2, true);
                }
            }
        }
    }

    public DefaultDrmSession(UUID uuid, InterfaceC2966a0 interfaceC2966a0, InterfaceC10699a interfaceC10699a, InterfaceC10700b interfaceC10700b, @Nullable List<DrmInitData.SchemeData> list, int i, boolean z2, boolean z3, @Nullable byte[] bArr, HashMap<String, String> map, InterfaceC2974e0 interfaceC2974e0, Looper looper, InterfaceC2721w interfaceC2721w) {
        if (i == 1 || i == 3) {
            Objects.requireNonNull(bArr);
        }
        this.f19795l = uuid;
        this.f19786c = interfaceC10699a;
        this.f19787d = interfaceC10700b;
        this.f19785b = interfaceC2966a0;
        this.f19788e = i;
        this.f19789f = z2;
        this.f19790g = z3;
        if (bArr != null) {
            this.f19804u = bArr;
            this.f19784a = null;
        } else {
            Objects.requireNonNull(list);
            this.f19784a = Collections.unmodifiableList(list);
        }
        this.f19791h = map;
        this.f19794k = interfaceC2974e0;
        this.f19792i = new C2745l<>();
        this.f19793j = interfaceC2721w;
        this.f19797n = 2;
        this.f19796m = new HandlerC10703e(looper);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: a */
    public void mo3606a(@Nullable InterfaceC2988s.a aVar) {
        int i = this.f19798o;
        if (i < 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Session reference count less than zero: ");
            sb.append(i);
            Log.e("DefaultDrmSession", sb.toString());
            this.f19798o = 0;
        }
        if (aVar != null) {
            C2745l<InterfaceC2988s.a> c2745l = this.f19792i;
            synchronized (c2745l.f6729j) {
                ArrayList arrayList = new ArrayList(c2745l.f6732m);
                arrayList.add(aVar);
                c2745l.f6732m = Collections.unmodifiableList(arrayList);
                Integer num = c2745l.f6730k.get(aVar);
                if (num == null) {
                    HashSet hashSet = new HashSet(c2745l.f6731l);
                    hashSet.add(aVar);
                    c2745l.f6731l = Collections.unmodifiableSet(hashSet);
                }
                c2745l.f6730k.put(aVar, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
            }
        }
        int i2 = this.f19798o + 1;
        this.f19798o = i2;
        if (i2 == 1) {
            C1460d.m426D(this.f19797n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f19799p = handlerThread;
            handlerThread.start();
            this.f19800q = new HandlerC10701c(this.f19799p.getLooper());
            if (m8820m()) {
                m8816i(true);
            }
        } else if (aVar != null && m8817j() && this.f19792i.m3027c(aVar) == 1) {
            aVar.m3590d(this.f19797n);
        }
        DefaultDrmSessionManager.C10709f c10709f = (DefaultDrmSessionManager.C10709f) this.f19787d;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.f19825l != -9223372036854775807L) {
            defaultDrmSessionManager.f19828o.remove(this);
            Handler handler = DefaultDrmSessionManager.this.f19834u;
            Objects.requireNonNull(handler);
            handler.removeCallbacksAndMessages(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:54:0x0106  */
    /* JADX WARN: Code duplicated, block: B:57:0x011f  */
    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: b */
    public void mo3607b(@Nullable InterfaceC2988s.a aVar) {
        DefaultDrmSessionManager defaultDrmSessionManager;
        DefaultDrmSessionManager.C10708e c10708e;
        DefaultDrmSessionManager defaultDrmSessionManager2;
        int i = this.f19798o;
        if (i <= 0) {
            Log.e("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.f19798o = i2;
        if (i2 == 0) {
            this.f19797n = 0;
            HandlerC10703e handlerC10703e = this.f19796m;
            int i3 = C2738e0.f6708a;
            handlerC10703e.removeCallbacksAndMessages(null);
            HandlerC10701c handlerC10701c = this.f19800q;
            synchronized (handlerC10701c) {
                handlerC10701c.removeCallbacksAndMessages(null);
                handlerC10701c.f19807a = true;
            }
            this.f19800q = null;
            this.f19799p.quit();
            this.f19799p = null;
            this.f19801r = null;
            this.f19802s = null;
            this.f19805v = null;
            this.f19806w = null;
            byte[] bArr = this.f19803t;
            if (bArr != null) {
                this.f19785b.mo3575g(bArr);
                this.f19803t = null;
            }
        }
        if (aVar != null) {
            C2745l<InterfaceC2988s.a> c2745l = this.f19792i;
            synchronized (c2745l.f6729j) {
                Integer num = c2745l.f6730k.get(aVar);
                if (num != null) {
                    ArrayList arrayList = new ArrayList(c2745l.f6732m);
                    arrayList.remove(aVar);
                    c2745l.f6732m = Collections.unmodifiableList(arrayList);
                    if (num.intValue() == 1) {
                        c2745l.f6730k.remove(aVar);
                        HashSet hashSet = new HashSet(c2745l.f6731l);
                        hashSet.remove(aVar);
                        c2745l.f6731l = Collections.unmodifiableSet(hashSet);
                    } else {
                        c2745l.f6730k.put(aVar, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
            if (this.f19792i.m3027c(aVar) == 0) {
                aVar.m3592f();
            }
        }
        InterfaceC10700b interfaceC10700b = this.f19787d;
        int i4 = this.f19798o;
        DefaultDrmSessionManager.C10709f c10709f = (DefaultDrmSessionManager.C10709f) interfaceC10700b;
        if (i4 == 1) {
            DefaultDrmSessionManager defaultDrmSessionManager3 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager3.f19829p > 0 && defaultDrmSessionManager3.f19825l != -9223372036854775807L) {
                defaultDrmSessionManager3.f19828o.add(this);
                Handler handler = DefaultDrmSessionManager.this.f19834u;
                Objects.requireNonNull(handler);
                handler.postAtTime(new Runnable() { // from class: b.i.a.c.w2.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7988j.mo3607b(null);
                    }
                }, this, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f19825l);
            } else if (i4 == 0) {
                DefaultDrmSessionManager.this.f19826m.remove(this);
                defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.f19831r == this) {
                    defaultDrmSessionManager.f19831r = null;
                }
                if (defaultDrmSessionManager.f19832s == this) {
                    defaultDrmSessionManager.f19832s = null;
                }
                c10708e = defaultDrmSessionManager.f19822i;
                c10708e.f19844a.remove(this);
                if (c10708e.f19845b == this) {
                    c10708e.f19845b = null;
                    if (!c10708e.f19844a.isEmpty()) {
                        DefaultDrmSession next = c10708e.f19844a.iterator().next();
                        c10708e.f19845b = next;
                        next.m8822o();
                    }
                }
                defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager2.f19825l != -9223372036854775807L) {
                    Handler handler2 = defaultDrmSessionManager2.f19834u;
                    Objects.requireNonNull(handler2);
                    handler2.removeCallbacksAndMessages(this);
                    DefaultDrmSessionManager.this.f19828o.remove(this);
                }
            }
        } else if (i4 == 0) {
            DefaultDrmSessionManager.this.f19826m.remove(this);
            defaultDrmSessionManager = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager.f19831r == this) {
                defaultDrmSessionManager.f19831r = null;
            }
            if (defaultDrmSessionManager.f19832s == this) {
                defaultDrmSessionManager.f19832s = null;
            }
            c10708e = defaultDrmSessionManager.f19822i;
            c10708e.f19844a.remove(this);
            if (c10708e.f19845b == this) {
                c10708e.f19845b = null;
                if (!c10708e.f19844a.isEmpty()) {
                    DefaultDrmSession next2 = c10708e.f19844a.iterator().next();
                    c10708e.f19845b = next2;
                    next2.m8822o();
                }
            }
            defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager2.f19825l != -9223372036854775807L) {
                Handler handler3 = defaultDrmSessionManager2.f19834u;
                Objects.requireNonNull(handler3);
                handler3.removeCallbacksAndMessages(this);
                DefaultDrmSessionManager.this.f19828o.remove(this);
            }
        }
        DefaultDrmSessionManager.this.m8831k();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: c */
    public final UUID mo3608c() {
        return this.f19795l;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: d */
    public boolean mo3609d() {
        return this.f19789f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    /* JADX INFO: renamed from: e */
    public boolean mo3610e(String str) {
        InterfaceC2966a0 interfaceC2966a0 = this.f19785b;
        byte[] bArr = this.f19803t;
        C1460d.m438H(bArr);
        return interfaceC2966a0.mo3573e(bArr, str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    /* JADX INFO: renamed from: f */
    public final DrmSession.DrmSessionException mo3611f() {
        if (this.f19797n == 1) {
            return this.f19802s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    /* JADX INFO: renamed from: g */
    public final InterfaceC2954b mo3612g() {
        return this.f19801r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f19797n;
    }

    /* JADX INFO: renamed from: h */
    public final void m8815h(InterfaceC2744k<InterfaceC2988s.a> interfaceC2744k) {
        Set<InterfaceC2988s.a> set;
        C2745l<InterfaceC2988s.a> c2745l = this.f19792i;
        synchronized (c2745l.f6729j) {
            set = c2745l.f6731l;
        }
        Iterator<InterfaceC2988s.a> it = set.iterator();
        while (it.hasNext()) {
            interfaceC2744k.accept(it.next());
        }
    }

    @RequiresNonNull({"sessionId"})
    /* JADX INFO: renamed from: i */
    public final void m8816i(boolean z2) {
        long j;
        Pair pair;
        long jMin;
        if (this.f19790g) {
            return;
        }
        byte[] bArr = this.f19803t;
        int i = C2738e0.f6708a;
        int i2 = this.f19788e;
        boolean z3 = false;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                Objects.requireNonNull(this.f19804u);
                Objects.requireNonNull(this.f19803t);
                m8821n(this.f19804u, 3, z2);
                return;
            }
            byte[] bArr2 = this.f19804u;
            if (bArr2 != null) {
                try {
                    this.f19785b.mo3574f(bArr, bArr2);
                    z3 = true;
                } catch (Exception e) {
                    m8818k(e, 1);
                }
                if (!z3) {
                    return;
                }
            }
            m8821n(bArr, 2, z2);
            return;
        }
        byte[] bArr3 = this.f19804u;
        if (bArr3 == null) {
            m8821n(bArr, 1, z2);
            return;
        }
        if (this.f19797n != 4) {
            try {
                this.f19785b.mo3574f(bArr, bArr3);
                z3 = true;
            } catch (Exception e2) {
                m8818k(e2, 1);
            }
            if (!z3) {
                return;
            }
        }
        if (C2997x0.f8024d.equals(this.f19795l)) {
            Map<String, String> mapM8823p = m8823p();
            if (mapM8823p == null) {
                pair = null;
            } else {
                long j2 = -9223372036854775807L;
                try {
                    String str = mapM8823p.get("LicenseDurationRemaining");
                    j = str != null ? Long.parseLong(str) : -9223372036854775807L;
                } catch (NumberFormatException unused) {
                }
                Long lValueOf = Long.valueOf(j);
                try {
                    String str2 = mapM8823p.get("PlaybackDurationRemaining");
                    if (str2 != null) {
                        j2 = Long.parseLong(str2);
                    }
                } catch (NumberFormatException unused2) {
                }
                pair = new Pair(lValueOf, Long.valueOf(j2));
            }
            Objects.requireNonNull(pair);
            jMin = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        } else {
            jMin = RecyclerView.FOREVER_NS;
        }
        if (this.f19788e != 0 || jMin > 60) {
            if (jMin <= 0) {
                m8818k(new KeysExpiredException(), 2);
                return;
            } else {
                this.f19797n = 4;
                m8815h(new InterfaceC2744k() { // from class: b.i.a.c.w2.q
                    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k
                    public final void accept(Object obj) {
                        ((InterfaceC2988s.a) obj).m3589c();
                    }
                });
                return;
            }
        }
        StringBuilder sb = new StringBuilder(88);
        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
        sb.append(jMin);
        Log.d("DefaultDrmSession", sb.toString());
        m8821n(bArr, 2, z2);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    /* JADX INFO: renamed from: j */
    public final boolean m8817j() {
        int i = this.f19797n;
        return i == 3 || i == 4;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX INFO: renamed from: k */
    public final void m8818k(final Exception exc, int i) {
        int iM3604b;
        int i2 = C2738e0.f6708a;
        if (i2 >= 21 && C2992w.m3603a(exc)) {
            iM3604b = C2992w.m3604b(exc);
        } else if (i2 >= 23 && C2993x.m3605a(exc)) {
            iM3604b = 6006;
        } else if (i2 >= 18 && C2991v.m3602b(exc)) {
            iM3604b = 6002;
        } else if (i2 >= 18 && C2991v.m3601a(exc)) {
            iM3604b = 6007;
        } else if (exc instanceof UnsupportedDrmException) {
            iM3604b = 6001;
        } else if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            iM3604b = 6003;
        } else if (exc instanceof KeysExpiredException) {
            iM3604b = 6008;
        } else if (i == 1) {
            iM3604b = 6006;
        } else if (i == 2) {
            iM3604b = 6004;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException();
            }
            iM3604b = 6002;
        }
        this.f19802s = new DrmSession.DrmSessionException(exc, iM3604b);
        C2750q.m3039b("DefaultDrmSession", "DRM session error", exc);
        m8815h(new InterfaceC2744k() { // from class: b.i.a.c.w2.b
            @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k
            public final void accept(Object obj) {
                ((InterfaceC2988s.a) obj).m3591e(exc);
            }
        });
        if (this.f19797n != 4) {
            this.f19797n = 1;
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m8819l(Exception exc, boolean z2) {
        if (!(exc instanceof NotProvisionedException)) {
            m8818k(exc, z2 ? 1 : 2);
            return;
        }
        DefaultDrmSessionManager.C10708e c10708e = (DefaultDrmSessionManager.C10708e) this.f19786c;
        c10708e.f19844a.add(this);
        if (c10708e.f19845b != null) {
            return;
        }
        c10708e.f19845b = this;
        m8822o();
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    /* JADX INFO: renamed from: m */
    public final boolean m8820m() {
        if (m8817j()) {
            return true;
        }
        try {
            byte[] bArrMo3572d = this.f19785b.mo3572d();
            this.f19803t = bArrMo3572d;
            this.f19801r = this.f19785b.mo3571c(bArrMo3572d);
            final int i = 3;
            this.f19797n = 3;
            m8815h(new InterfaceC2744k() { // from class: b.i.a.c.w2.c
                @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k
                public final void accept(Object obj) {
                    ((InterfaceC2988s.a) obj).m3590d(i);
                }
            });
            Objects.requireNonNull(this.f19803t);
            return true;
        } catch (NotProvisionedException unused) {
            DefaultDrmSessionManager.C10708e c10708e = (DefaultDrmSessionManager.C10708e) this.f19786c;
            c10708e.f19844a.add(this);
            if (c10708e.f19845b != null) {
                return false;
            }
            c10708e.f19845b = this;
            m8822o();
            return false;
        } catch (Exception e) {
            m8818k(e, 1);
            return false;
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m8821n(byte[] bArr, int i, boolean z2) {
        try {
            InterfaceC2966a0.a aVarMo3579k = this.f19785b.mo3579k(bArr, this.f19784a, i, this.f19791h);
            this.f19805v = aVarMo3579k;
            HandlerC10701c handlerC10701c = this.f19800q;
            int i2 = C2738e0.f6708a;
            Objects.requireNonNull(aVarMo3579k);
            handlerC10701c.m8824a(1, aVarMo3579k, z2);
        } catch (Exception e) {
            m8819l(e, true);
        }
    }

    /* JADX INFO: renamed from: o */
    public void m8822o() {
        InterfaceC2966a0.d dVarMo3570b = this.f19785b.mo3570b();
        this.f19806w = dVarMo3570b;
        HandlerC10701c handlerC10701c = this.f19800q;
        int i = C2738e0.f6708a;
        Objects.requireNonNull(dVarMo3570b);
        handlerC10701c.m8824a(0, dVarMo3570b, true);
    }

    @Nullable
    /* JADX INFO: renamed from: p */
    public Map<String, String> m8823p() {
        byte[] bArr = this.f19803t;
        if (bArr == null) {
            return null;
        }
        return this.f19785b.mo3569a(bArr);
    }
}
