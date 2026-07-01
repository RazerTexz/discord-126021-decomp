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
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.C;
import b.i.a.c.a3.LoadEventInfo;
import b.i.a.c.e3.DefaultLoadErrorHandlingPolicy;
import b.i.a.c.e3.LoadErrorHandlingPolicy;
import b.i.a.c.f3.Consumer3;
import b.i.a.c.f3.CopyOnWriteMultiset;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.CryptoConfig;
import b.i.a.c.w2.DrmSessionEventListener;
import b.i.a.c.w2.DrmUtil;
import b.i.a.c.w2.DrmUtil2;
import b.i.a.c.w2.DrmUtil3;
import b.i.a.c.w2.ExoMediaDrm;
import b.i.a.c.w2.HttpMediaDrmCallback;
import b.i.a.c.w2.MediaDrmCallback;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
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

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public class DefaultDrmSession implements DrmSession {

    @Nullable
    public final List<DrmInitData.SchemeData> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExoMediaDrm f2925b;
    public final a c;
    public final b d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap<String, String> h;
    public final CopyOnWriteMultiset<DrmSessionEventListener.a> i;
    public final LoadErrorHandlingPolicy j;
    public final MediaDrmCallback k;
    public final UUID l;
    public final e m;
    public int n;
    public int o;

    @Nullable
    public HandlerThread p;

    @Nullable
    public c q;

    @Nullable
    public CryptoConfig r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public DrmSession.DrmSessionException f2926s;

    @Nullable
    public byte[] t;
    public byte[] u;

    @Nullable
    public ExoMediaDrm.a v;

    @Nullable
    public ExoMediaDrm.d w;

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    public interface a {
    }

    public interface b {
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {

        @GuardedBy("this")
        public boolean a;

        public c(Looper looper) {
            super(looper);
        }

        public void a(int i, Object obj, boolean z2) {
            obtainMessage(i, new d(LoadEventInfo.a.getAndIncrement(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004a  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long jMin;
            boolean z2;
            Object objC;
            d dVar = (d) message.obj;
            boolean z3 = true;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    objC = ((HttpMediaDrmCallback) defaultDrmSession.k).c(defaultDrmSession.l, (ExoMediaDrm.d) dVar.d);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    objC = ((HttpMediaDrmCallback) defaultDrmSession2.k).a(defaultDrmSession2.l, (ExoMediaDrm.a) dVar.d);
                }
            } catch (MediaDrmCallbackException e) {
                d dVar2 = (d) message.obj;
                if (dVar2.f2928b) {
                    int i2 = dVar2.e + 1;
                    dVar2.e = i2;
                    if (i2 > ((DefaultLoadErrorHandlingPolicy) DefaultDrmSession.this.j).a(3)) {
                        z3 = false;
                    } else {
                        SystemClock.elapsedRealtime();
                        SystemClock.elapsedRealtime();
                        Throwable unexpectedDrmSessionException = e.getCause() instanceof IOException ? (IOException) e.getCause() : new UnexpectedDrmSessionException(e.getCause());
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy = DefaultDrmSession.this.j;
                        int i3 = dVar2.e;
                        if ((unexpectedDrmSessionException instanceof ParserException) || (unexpectedDrmSessionException instanceof FileNotFoundException) || (unexpectedDrmSessionException instanceof HttpDataSource$CleartextNotPermittedException) || (unexpectedDrmSessionException instanceof Loader.UnexpectedLoaderException)) {
                            jMin = -9223372036854775807L;
                        } else {
                            int i4 = DataSourceException.j;
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
                                if (this.a) {
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
                    objC = e;
                }
            } catch (Exception e2) {
                Log2.c("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                objC = e2;
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = DefaultDrmSession.this.j;
            long j = dVar.a;
            Objects.requireNonNull(loadErrorHandlingPolicy2);
            synchronized (this) {
                if (!this.a) {
                    DefaultDrmSession.this.m.obtainMessage(message.what, Pair.create(dVar.d, objC)).sendToTarget();
                }
            }
        }
    }

    public static final class d {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2928b;
        public final long c;
        public final Object d;
        public int e;

        public d(long j, boolean z2, long j2, Object obj) {
            this.a = j;
            this.f2928b = z2;
            this.c = j2;
            this.d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class e extends Handler {
        public e(Looper looper) {
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
                if (obj == defaultDrmSession.w) {
                    if (defaultDrmSession.n == 2 || defaultDrmSession.j()) {
                        defaultDrmSession.w = null;
                        if (obj2 instanceof Exception) {
                            ((DefaultDrmSessionManager.e) defaultDrmSession.c).a((Exception) obj2, false);
                            return;
                        }
                        try {
                            defaultDrmSession.f2925b.j((byte[]) obj2);
                            DefaultDrmSessionManager.e eVar = (DefaultDrmSessionManager.e) defaultDrmSession.c;
                            eVar.f2933b = null;
                            ImmutableList2 immutableList2N = ImmutableList2.n(eVar.a);
                            eVar.a.clear();
                            AbstractIndexedListIterator abstractIndexedListIteratorListIterator = immutableList2N.listIterator();
                            while (abstractIndexedListIteratorListIterator.hasNext()) {
                                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) abstractIndexedListIteratorListIterator.next();
                                if (defaultDrmSession2.m()) {
                                    defaultDrmSession2.i(true);
                                }
                            }
                            return;
                        } catch (Exception e) {
                            ((DefaultDrmSessionManager.e) defaultDrmSession.c).a(e, true);
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
            if (obj == defaultDrmSession3.v && defaultDrmSession3.j()) {
                defaultDrmSession3.v = null;
                if (obj2 instanceof Exception) {
                    defaultDrmSession3.l((Exception) obj2, false);
                    return;
                }
                try {
                    byte[] bArr = (byte[]) obj2;
                    if (defaultDrmSession3.e == 3) {
                        ExoMediaDrm exoMediaDrm = defaultDrmSession3.f2925b;
                        byte[] bArr2 = defaultDrmSession3.u;
                        int i2 = Util2.a;
                        exoMediaDrm.i(bArr2, bArr);
                        defaultDrmSession3.h(new Consumer3() { // from class: b.i.a.c.w2.a
                            @Override // b.i.a.c.f3.Consumer3
                            public final void accept(Object obj3) {
                                ((DrmSessionEventListener.a) obj3).b();
                            }
                        });
                        return;
                    }
                    byte[] bArrI = defaultDrmSession3.f2925b.i(defaultDrmSession3.t, bArr);
                    int i3 = defaultDrmSession3.e;
                    if ((i3 == 2 || (i3 == 0 && defaultDrmSession3.u != null)) && bArrI != null && bArrI.length != 0) {
                        defaultDrmSession3.u = bArrI;
                    }
                    defaultDrmSession3.n = 4;
                    defaultDrmSession3.h(new Consumer3() { // from class: b.i.a.c.w2.p
                        @Override // b.i.a.c.f3.Consumer3
                        public final void accept(Object obj3) {
                            ((DrmSessionEventListener.a) obj3).a();
                        }
                    });
                } catch (Exception e2) {
                    defaultDrmSession3.l(e2, true);
                }
            }
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i, boolean z2, boolean z3, @Nullable byte[] bArr, HashMap<String, String> map, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (i == 1 || i == 3) {
            Objects.requireNonNull(bArr);
        }
        this.l = uuid;
        this.c = aVar;
        this.d = bVar;
        this.f2925b = exoMediaDrm;
        this.e = i;
        this.f = z2;
        this.g = z3;
        if (bArr != null) {
            this.u = bArr;
            this.a = null;
        } else {
            Objects.requireNonNull(list);
            this.a = Collections.unmodifiableList(list);
        }
        this.h = map;
        this.k = mediaDrmCallback;
        this.i = new CopyOnWriteMultiset<>();
        this.j = loadErrorHandlingPolicy;
        this.n = 2;
        this.m = new e(looper);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable DrmSessionEventListener.a aVar) {
        int i = this.o;
        if (i < 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Session reference count less than zero: ");
            sb.append(i);
            Log.e("DefaultDrmSession", sb.toString());
            this.o = 0;
        }
        if (aVar != null) {
            CopyOnWriteMultiset<DrmSessionEventListener.a> copyOnWriteMultiset = this.i;
            synchronized (copyOnWriteMultiset.j) {
                ArrayList arrayList = new ArrayList(copyOnWriteMultiset.m);
                arrayList.add(aVar);
                copyOnWriteMultiset.m = Collections.unmodifiableList(arrayList);
                Integer num = copyOnWriteMultiset.k.get(aVar);
                if (num == null) {
                    HashSet hashSet = new HashSet(copyOnWriteMultiset.l);
                    hashSet.add(aVar);
                    copyOnWriteMultiset.l = Collections.unmodifiableSet(hashSet);
                }
                copyOnWriteMultiset.k.put(aVar, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
            }
        }
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 == 1) {
            AnimatableValueParser.D(this.n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = handlerThread;
            handlerThread.start();
            this.q = new c(this.p.getLooper());
            if (m()) {
                i(true);
            }
        } else if (aVar != null && j() && this.i.c(aVar) == 1) {
            aVar.d(this.n);
        }
        DefaultDrmSessionManager.f fVar = (DefaultDrmSessionManager.f) this.d;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.l != -9223372036854775807L) {
            defaultDrmSessionManager.o.remove(this);
            Handler handler = DefaultDrmSessionManager.this.u;
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
    public void b(@Nullable DrmSessionEventListener.a aVar) {
        DefaultDrmSessionManager defaultDrmSessionManager;
        DefaultDrmSessionManager.e eVar;
        DefaultDrmSessionManager defaultDrmSessionManager2;
        int i = this.o;
        if (i <= 0) {
            Log.e("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.o = i2;
        if (i2 == 0) {
            this.n = 0;
            e eVar2 = this.m;
            int i3 = Util2.a;
            eVar2.removeCallbacksAndMessages(null);
            c cVar = this.q;
            synchronized (cVar) {
                cVar.removeCallbacksAndMessages(null);
                cVar.a = true;
            }
            this.q = null;
            this.p.quit();
            this.p = null;
            this.r = null;
            this.f2926s = null;
            this.v = null;
            this.w = null;
            byte[] bArr = this.t;
            if (bArr != null) {
                this.f2925b.g(bArr);
                this.t = null;
            }
        }
        if (aVar != null) {
            CopyOnWriteMultiset<DrmSessionEventListener.a> copyOnWriteMultiset = this.i;
            synchronized (copyOnWriteMultiset.j) {
                Integer num = copyOnWriteMultiset.k.get(aVar);
                if (num != null) {
                    ArrayList arrayList = new ArrayList(copyOnWriteMultiset.m);
                    arrayList.remove(aVar);
                    copyOnWriteMultiset.m = Collections.unmodifiableList(arrayList);
                    if (num.intValue() == 1) {
                        copyOnWriteMultiset.k.remove(aVar);
                        HashSet hashSet = new HashSet(copyOnWriteMultiset.l);
                        hashSet.remove(aVar);
                        copyOnWriteMultiset.l = Collections.unmodifiableSet(hashSet);
                    } else {
                        copyOnWriteMultiset.k.put(aVar, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
            if (this.i.c(aVar) == 0) {
                aVar.f();
            }
        }
        b bVar = this.d;
        int i4 = this.o;
        DefaultDrmSessionManager.f fVar = (DefaultDrmSessionManager.f) bVar;
        if (i4 == 1) {
            DefaultDrmSessionManager defaultDrmSessionManager3 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager3.p > 0 && defaultDrmSessionManager3.l != -9223372036854775807L) {
                defaultDrmSessionManager3.o.add(this);
                Handler handler = DefaultDrmSessionManager.this.u;
                Objects.requireNonNull(handler);
                handler.postAtTime(new Runnable() { // from class: b.i.a.c.w2.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.j.b(null);
                    }
                }, this, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.l);
            } else if (i4 == 0) {
                DefaultDrmSessionManager.this.m.remove(this);
                defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.r == this) {
                    defaultDrmSessionManager.r = null;
                }
                if (defaultDrmSessionManager.f2930s == this) {
                    defaultDrmSessionManager.f2930s = null;
                }
                eVar = defaultDrmSessionManager.i;
                eVar.a.remove(this);
                if (eVar.f2933b == this) {
                    eVar.f2933b = null;
                    if (!eVar.a.isEmpty()) {
                        DefaultDrmSession next = eVar.a.iterator().next();
                        eVar.f2933b = next;
                        next.o();
                    }
                }
                defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager2.l != -9223372036854775807L) {
                    Handler handler2 = defaultDrmSessionManager2.u;
                    Objects.requireNonNull(handler2);
                    handler2.removeCallbacksAndMessages(this);
                    DefaultDrmSessionManager.this.o.remove(this);
                }
            }
        } else if (i4 == 0) {
            DefaultDrmSessionManager.this.m.remove(this);
            defaultDrmSessionManager = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager.r == this) {
                defaultDrmSessionManager.r = null;
            }
            if (defaultDrmSessionManager.f2930s == this) {
                defaultDrmSessionManager.f2930s = null;
            }
            eVar = defaultDrmSessionManager.i;
            eVar.a.remove(this);
            if (eVar.f2933b == this) {
                eVar.f2933b = null;
                if (!eVar.a.isEmpty()) {
                    DefaultDrmSession next2 = eVar.a.iterator().next();
                    eVar.f2933b = next2;
                    next2.o();
                }
            }
            defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager2.l != -9223372036854775807L) {
                Handler handler3 = defaultDrmSessionManager2.u;
                Objects.requireNonNull(handler3);
                handler3.removeCallbacksAndMessages(this);
                DefaultDrmSessionManager.this.o.remove(this);
            }
        }
        DefaultDrmSessionManager.this.k();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean e(String str) {
        ExoMediaDrm exoMediaDrm = this.f2925b;
        byte[] bArr = this.t;
        AnimatableValueParser.H(bArr);
        return exoMediaDrm.e(bArr, str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException f() {
        if (this.n == 1) {
            return this.f2926s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final CryptoConfig g() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    public final void h(Consumer3<DrmSessionEventListener.a> consumer3) {
        Set<DrmSessionEventListener.a> set;
        CopyOnWriteMultiset<DrmSessionEventListener.a> copyOnWriteMultiset = this.i;
        synchronized (copyOnWriteMultiset.j) {
            set = copyOnWriteMultiset.l;
        }
        Iterator<DrmSessionEventListener.a> it = set.iterator();
        while (it.hasNext()) {
            consumer3.accept(it.next());
        }
    }

    @RequiresNonNull({"sessionId"})
    public final void i(boolean z2) {
        long j;
        Pair pair;
        long jMin;
        if (this.g) {
            return;
        }
        byte[] bArr = this.t;
        int i = Util2.a;
        int i2 = this.e;
        boolean z3 = false;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                Objects.requireNonNull(this.u);
                Objects.requireNonNull(this.t);
                n(this.u, 3, z2);
                return;
            }
            byte[] bArr2 = this.u;
            if (bArr2 != null) {
                try {
                    this.f2925b.f(bArr, bArr2);
                    z3 = true;
                } catch (Exception e2) {
                    k(e2, 1);
                }
                if (!z3) {
                    return;
                }
            }
            n(bArr, 2, z2);
            return;
        }
        byte[] bArr3 = this.u;
        if (bArr3 == null) {
            n(bArr, 1, z2);
            return;
        }
        if (this.n != 4) {
            try {
                this.f2925b.f(bArr, bArr3);
                z3 = true;
            } catch (Exception e3) {
                k(e3, 1);
            }
            if (!z3) {
                return;
            }
        }
        if (C.d.equals(this.l)) {
            Map<String, String> mapP = p();
            if (mapP == null) {
                pair = null;
            } else {
                long j2 = -9223372036854775807L;
                try {
                    String str = mapP.get("LicenseDurationRemaining");
                    j = str != null ? Long.parseLong(str) : -9223372036854775807L;
                } catch (NumberFormatException unused) {
                }
                Long lValueOf = Long.valueOf(j);
                try {
                    String str2 = mapP.get("PlaybackDurationRemaining");
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
        if (this.e != 0 || jMin > 60) {
            if (jMin <= 0) {
                k(new KeysExpiredException(), 2);
                return;
            } else {
                this.n = 4;
                h(new Consumer3() { // from class: b.i.a.c.w2.q
                    @Override // b.i.a.c.f3.Consumer3
                    public final void accept(Object obj) {
                        ((DrmSessionEventListener.a) obj).c();
                    }
                });
                return;
            }
        }
        StringBuilder sb = new StringBuilder(88);
        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
        sb.append(jMin);
        Log.d("DefaultDrmSession", sb.toString());
        n(bArr, 2, z2);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean j() {
        int i = this.n;
        return i == 3 || i == 4;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    public final void k(final Exception exc, int i) {
        int iB;
        int i2 = Util2.a;
        if (i2 >= 21 && DrmUtil2.a(exc)) {
            iB = DrmUtil2.b(exc);
        } else if (i2 >= 23 && DrmUtil3.a(exc)) {
            iB = 6006;
        } else if (i2 >= 18 && DrmUtil.b(exc)) {
            iB = 6002;
        } else if (i2 >= 18 && DrmUtil.a(exc)) {
            iB = 6007;
        } else if (exc instanceof UnsupportedDrmException) {
            iB = 6001;
        } else if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            iB = 6003;
        } else if (exc instanceof KeysExpiredException) {
            iB = 6008;
        } else if (i == 1) {
            iB = 6006;
        } else if (i == 2) {
            iB = 6004;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException();
            }
            iB = 6002;
        }
        this.f2926s = new DrmSession.DrmSessionException(exc, iB);
        Log2.b("DefaultDrmSession", "DRM session error", exc);
        h(new Consumer3() { // from class: b.i.a.c.w2.b
            @Override // b.i.a.c.f3.Consumer3
            public final void accept(Object obj) {
                ((DrmSessionEventListener.a) obj).e(exc);
            }
        });
        if (this.n != 4) {
            this.n = 1;
        }
    }

    public final void l(Exception exc, boolean z2) {
        if (!(exc instanceof NotProvisionedException)) {
            k(exc, z2 ? 1 : 2);
            return;
        }
        DefaultDrmSessionManager.e eVar = (DefaultDrmSessionManager.e) this.c;
        eVar.a.add(this);
        if (eVar.f2933b != null) {
            return;
        }
        eVar.f2933b = this;
        o();
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean m() {
        if (j()) {
            return true;
        }
        try {
            byte[] bArrD = this.f2925b.d();
            this.t = bArrD;
            this.r = this.f2925b.c(bArrD);
            final int i = 3;
            this.n = 3;
            h(new Consumer3() { // from class: b.i.a.c.w2.c
                @Override // b.i.a.c.f3.Consumer3
                public final void accept(Object obj) {
                    ((DrmSessionEventListener.a) obj).d(i);
                }
            });
            Objects.requireNonNull(this.t);
            return true;
        } catch (NotProvisionedException unused) {
            DefaultDrmSessionManager.e eVar = (DefaultDrmSessionManager.e) this.c;
            eVar.a.add(this);
            if (eVar.f2933b != null) {
                return false;
            }
            eVar.f2933b = this;
            o();
            return false;
        } catch (Exception e2) {
            k(e2, 1);
            return false;
        }
    }

    public final void n(byte[] bArr, int i, boolean z2) {
        try {
            ExoMediaDrm.a aVarK = this.f2925b.k(bArr, this.a, i, this.h);
            this.v = aVarK;
            c cVar = this.q;
            int i2 = Util2.a;
            Objects.requireNonNull(aVarK);
            cVar.a(1, aVarK, z2);
        } catch (Exception e2) {
            l(e2, true);
        }
    }

    public void o() {
        ExoMediaDrm.d dVarB = this.f2925b.b();
        this.w = dVarB;
        c cVar = this.q;
        int i = Util2.a;
        Objects.requireNonNull(dVarB);
        cVar.a(0, dVarB, true);
    }

    @Nullable
    public Map<String, String> p() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return null;
        }
        return this.f2925b.a(bArr);
    }
}
