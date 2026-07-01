package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.d;
import b.i.a.c.e3.w;
import b.i.a.c.f3.k;
import b.i.a.c.f3.l;
import b.i.a.c.v2.b;
import b.i.a.c.w2.a0;
import b.i.a.c.w2.a0$a;
import b.i.a.c.w2.a0$d;
import b.i.a.c.w2.c;
import b.i.a.c.w2.e0;
import b.i.a.c.w2.f;
import b.i.a.c.w2.q;
import b.i.a.c.w2.s$a;
import b.i.a.c.w2.v;
import b.i.a.c.w2.x;
import b.i.a.c.x0;
import com.discord.utilities.auth.GoogleSmartLockManager;
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
    public final List<DrmInitData$SchemeData> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f2925b;
    public final DefaultDrmSession$a c;
    public final DefaultDrmSession$b d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap<String, String> h;
    public final l<s$a> i;
    public final w j;
    public final e0 k;
    public final UUID l;
    public final DefaultDrmSession$e m;
    public int n;
    public int o;

    @Nullable
    public HandlerThread p;

    @Nullable
    public DefaultDrmSession$c q;

    @Nullable
    public b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public DrmSession$DrmSessionException f2926s;

    @Nullable
    public byte[] t;
    public byte[] u;

    @Nullable
    public a0$a v;

    @Nullable
    public a0$d w;

    public DefaultDrmSession(UUID uuid, a0 a0Var, DefaultDrmSession$a defaultDrmSession$a, DefaultDrmSession$b defaultDrmSession$b, @Nullable List<DrmInitData$SchemeData> list, int i, boolean z2, boolean z3, @Nullable byte[] bArr, HashMap<String, String> map, e0 e0Var, Looper looper, w wVar) {
        if (i == 1 || i == 3) {
            Objects.requireNonNull(bArr);
        }
        this.l = uuid;
        this.c = defaultDrmSession$a;
        this.d = defaultDrmSession$b;
        this.f2925b = a0Var;
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
        this.k = e0Var;
        this.i = new l<>();
        this.j = wVar;
        this.n = 2;
        this.m = new DefaultDrmSession$e(this, looper);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable s$a s_a) {
        int i = this.o;
        if (i < 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Session reference count less than zero: ");
            sb.append(i);
            Log.e("DefaultDrmSession", sb.toString());
            this.o = 0;
        }
        if (s_a != null) {
            l<s$a> lVar = this.i;
            synchronized (lVar.j) {
                ArrayList arrayList = new ArrayList(lVar.m);
                arrayList.add(s_a);
                lVar.m = Collections.unmodifiableList(arrayList);
                Integer num = lVar.k.get(s_a);
                if (num == null) {
                    HashSet hashSet = new HashSet(lVar.l);
                    hashSet.add(s_a);
                    lVar.l = Collections.unmodifiableSet(hashSet);
                }
                lVar.k.put(s_a, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
            }
        }
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 == 1) {
            d.D(this.n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = handlerThread;
            handlerThread.start();
            this.q = new DefaultDrmSession$c(this, this.p.getLooper());
            if (m()) {
                i(true);
            }
        } else if (s_a != null && j() && this.i.c(s_a) == 1) {
            s_a.d(this.n);
        }
        DefaultDrmSessionManager$f defaultDrmSessionManager$f = (DefaultDrmSessionManager$f) this.d;
        DefaultDrmSessionManager defaultDrmSessionManager = defaultDrmSessionManager$f.a;
        if (defaultDrmSessionManager.l != -9223372036854775807L) {
            defaultDrmSessionManager.o.remove(this);
            Handler handler = defaultDrmSessionManager$f.a.u;
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
    public void b(@Nullable s$a s_a) {
        DefaultDrmSessionManager defaultDrmSessionManager;
        DefaultDrmSessionManager$e defaultDrmSessionManager$e;
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
            DefaultDrmSession$e defaultDrmSession$e = this.m;
            int i3 = b.i.a.c.f3.e0.a;
            defaultDrmSession$e.removeCallbacksAndMessages(null);
            DefaultDrmSession$c defaultDrmSession$c = this.q;
            synchronized (defaultDrmSession$c) {
                defaultDrmSession$c.removeCallbacksAndMessages(null);
                defaultDrmSession$c.a = true;
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
        if (s_a != null) {
            l<s$a> lVar = this.i;
            synchronized (lVar.j) {
                Integer num = lVar.k.get(s_a);
                if (num != null) {
                    ArrayList arrayList = new ArrayList(lVar.m);
                    arrayList.remove(s_a);
                    lVar.m = Collections.unmodifiableList(arrayList);
                    if (num.intValue() == 1) {
                        lVar.k.remove(s_a);
                        HashSet hashSet = new HashSet(lVar.l);
                        hashSet.remove(s_a);
                        lVar.l = Collections.unmodifiableSet(hashSet);
                    } else {
                        lVar.k.put(s_a, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
            if (this.i.c(s_a) == 0) {
                s_a.f();
            }
        }
        DefaultDrmSession$b defaultDrmSession$b = this.d;
        int i4 = this.o;
        DefaultDrmSessionManager$f defaultDrmSessionManager$f = (DefaultDrmSessionManager$f) defaultDrmSession$b;
        if (i4 == 1) {
            DefaultDrmSessionManager defaultDrmSessionManager3 = defaultDrmSessionManager$f.a;
            if (defaultDrmSessionManager3.p > 0 && defaultDrmSessionManager3.l != -9223372036854775807L) {
                defaultDrmSessionManager3.o.add(this);
                Handler handler = defaultDrmSessionManager$f.a.u;
                Objects.requireNonNull(handler);
                handler.postAtTime(new f(this), this, SystemClock.uptimeMillis() + defaultDrmSessionManager$f.a.l);
            } else if (i4 == 0) {
                defaultDrmSessionManager$f.a.m.remove(this);
                defaultDrmSessionManager = defaultDrmSessionManager$f.a;
                if (defaultDrmSessionManager.r == this) {
                    defaultDrmSessionManager.r = null;
                }
                if (defaultDrmSessionManager.f2930s == this) {
                    defaultDrmSessionManager.f2930s = null;
                }
                defaultDrmSessionManager$e = defaultDrmSessionManager.i;
                defaultDrmSessionManager$e.a.remove(this);
                if (defaultDrmSessionManager$e.f2933b == this) {
                    defaultDrmSessionManager$e.f2933b = null;
                    if (!defaultDrmSessionManager$e.a.isEmpty()) {
                        DefaultDrmSession next = defaultDrmSessionManager$e.a.iterator().next();
                        defaultDrmSessionManager$e.f2933b = next;
                        next.o();
                    }
                }
                defaultDrmSessionManager2 = defaultDrmSessionManager$f.a;
                if (defaultDrmSessionManager2.l != -9223372036854775807L) {
                    Handler handler2 = defaultDrmSessionManager2.u;
                    Objects.requireNonNull(handler2);
                    handler2.removeCallbacksAndMessages(this);
                    defaultDrmSessionManager$f.a.o.remove(this);
                }
            }
        } else if (i4 == 0) {
            defaultDrmSessionManager$f.a.m.remove(this);
            defaultDrmSessionManager = defaultDrmSessionManager$f.a;
            if (defaultDrmSessionManager.r == this) {
                defaultDrmSessionManager.r = null;
            }
            if (defaultDrmSessionManager.f2930s == this) {
                defaultDrmSessionManager.f2930s = null;
            }
            defaultDrmSessionManager$e = defaultDrmSessionManager.i;
            defaultDrmSessionManager$e.a.remove(this);
            if (defaultDrmSessionManager$e.f2933b == this) {
                defaultDrmSessionManager$e.f2933b = null;
                if (!defaultDrmSessionManager$e.a.isEmpty()) {
                    DefaultDrmSession next2 = defaultDrmSessionManager$e.a.iterator().next();
                    defaultDrmSessionManager$e.f2933b = next2;
                    next2.o();
                }
            }
            defaultDrmSessionManager2 = defaultDrmSessionManager$f.a;
            if (defaultDrmSessionManager2.l != -9223372036854775807L) {
                Handler handler3 = defaultDrmSessionManager2.u;
                Objects.requireNonNull(handler3);
                handler3.removeCallbacksAndMessages(this);
                defaultDrmSessionManager$f.a.o.remove(this);
            }
        }
        defaultDrmSessionManager$f.a.k();
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
        a0 a0Var = this.f2925b;
        byte[] bArr = this.t;
        d.H(bArr);
        return a0Var.e(bArr, str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession$DrmSessionException f() {
        if (this.n == 1) {
            return this.f2926s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final b g() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    public final void h(k<s$a> kVar) {
        Set<s$a> set;
        l<s$a> lVar = this.i;
        synchronized (lVar.j) {
            set = lVar.l;
        }
        Iterator<s$a> it = set.iterator();
        while (it.hasNext()) {
            kVar.accept(it.next());
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
        int i = b.i.a.c.f3.e0.a;
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
                } catch (Exception e) {
                    k(e, 1);
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
            } catch (Exception e2) {
                k(e2, 1);
            }
            if (!z3) {
                return;
            }
        }
        if (x0.d.equals(this.l)) {
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
                h(q.a);
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
    public final void k(Exception exc, int i) {
        int iB;
        int i2 = b.i.a.c.f3.e0.a;
        if (i2 >= 21 && b.i.a.c.w2.w.a(exc)) {
            iB = b.i.a.c.w2.w.b(exc);
        } else if (i2 >= 23 && x.a(exc)) {
            iB = 6006;
        } else if (i2 >= 18 && v.b(exc)) {
            iB = 6002;
        } else if (i2 >= 18 && v.a(exc)) {
            iB = 6007;
        } else if (exc instanceof UnsupportedDrmException) {
            iB = 6001;
        } else if (exc instanceof DefaultDrmSessionManager$MissingSchemeDataException) {
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
        this.f2926s = new DrmSession$DrmSessionException(exc, iB);
        b.i.a.c.f3.q.b("DefaultDrmSession", "DRM session error", exc);
        h(new b.i.a.c.w2.b(exc));
        if (this.n != 4) {
            this.n = 1;
        }
    }

    public final void l(Exception exc, boolean z2) {
        if (!(exc instanceof NotProvisionedException)) {
            k(exc, z2 ? 1 : 2);
            return;
        }
        DefaultDrmSessionManager$e defaultDrmSessionManager$e = (DefaultDrmSessionManager$e) this.c;
        defaultDrmSessionManager$e.a.add(this);
        if (defaultDrmSessionManager$e.f2933b != null) {
            return;
        }
        defaultDrmSessionManager$e.f2933b = this;
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
            this.n = 3;
            h(new c(3));
            Objects.requireNonNull(this.t);
            return true;
        } catch (NotProvisionedException unused) {
            DefaultDrmSessionManager$e defaultDrmSessionManager$e = (DefaultDrmSessionManager$e) this.c;
            defaultDrmSessionManager$e.a.add(this);
            if (defaultDrmSessionManager$e.f2933b != null) {
                return false;
            }
            defaultDrmSessionManager$e.f2933b = this;
            o();
            return false;
        } catch (Exception e) {
            k(e, 1);
            return false;
        }
    }

    public final void n(byte[] bArr, int i, boolean z2) {
        try {
            a0$a a0_aK = this.f2925b.k(bArr, this.a, i, this.h);
            this.v = a0_aK;
            DefaultDrmSession$c defaultDrmSession$c = this.q;
            int i2 = b.i.a.c.f3.e0.a;
            Objects.requireNonNull(a0_aK);
            defaultDrmSession$c.a(1, a0_aK, z2);
        } catch (Exception e) {
            l(e, true);
        }
    }

    public void o() {
        a0$d a0_dB = this.f2925b.b();
        this.w = a0_dB;
        DefaultDrmSession$c defaultDrmSession$c = this.q;
        int i = b.i.a.c.f3.e0.a;
        Objects.requireNonNull(a0_dB);
        defaultDrmSession$c.a(0, a0_dB, true);
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
