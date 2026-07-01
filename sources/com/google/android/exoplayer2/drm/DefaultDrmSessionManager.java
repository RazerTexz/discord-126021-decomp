package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.Format2;
import b.i.a.c.e3.LoadErrorHandlingPolicy;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.DrmSessionEventListener;
import b.i.a.c.w2.DrmSessionManager2;
import b.i.a.c.w2.ErrorStateDrmSession;
import b.i.a.c.w2.ExoMediaDrm;
import b.i.a.c.w2.FrameworkCryptoConfig;
import b.i.a.c.w2.MediaDrmCallback;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.Collections2;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableSet2;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public class DefaultDrmSessionManager implements DrmSessionManager2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UUID f2929b;
    public final ExoMediaDrm.c c;
    public final MediaDrmCallback d;
    public final HashMap<String, String> e;
    public final boolean f;
    public final int[] g;
    public final boolean h;
    public final e i;
    public final LoadErrorHandlingPolicy j;
    public final f k;
    public final long l;
    public final List<DefaultDrmSession> m;
    public final Set<d> n;
    public final Set<DefaultDrmSession> o;
    public int p;

    @Nullable
    public ExoMediaDrm q;

    @Nullable
    public DefaultDrmSession r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f2930s;
    public Looper t;
    public Handler u;
    public int v;

    @Nullable
    public byte[] w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public volatile c f2931x;

    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public MissingSchemeDataException(UUID uuid, a aVar) {
            String strValueOf = String.valueOf(uuid);
            super(outline.j(strValueOf.length() + 29, "Media does not support uuid: ", strValueOf));
        }
    }

    public class b implements ExoMediaDrm.b {
        public b(a aVar) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.m) {
                if (Arrays.equals(defaultDrmSession.t, bArr)) {
                    if (message.what == 2 && defaultDrmSession.e == 0 && defaultDrmSession.n == 4) {
                        int i = Util2.a;
                        defaultDrmSession.i(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public class d implements DrmSessionManager2.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final DrmSessionEventListener.a f2932b;

        @Nullable
        public DrmSession c;
        public boolean d;

        public d(DrmSessionEventListener.a aVar) {
            this.f2932b = aVar;
        }

        @Override // b.i.a.c.w2.DrmSessionManager2.b
        public void release() {
            Handler handler = DefaultDrmSessionManager.this.u;
            Objects.requireNonNull(handler);
            Util2.E(handler, new b.i.a.c.w2.d(this));
        }
    }

    public class e implements DefaultDrmSession.a {
        public final Set<DefaultDrmSession> a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public DefaultDrmSession f2933b;

        public void a(Exception exc, boolean z2) {
            this.f2933b = null;
            ImmutableList2 immutableList2N = ImmutableList2.n(this.a);
            this.a.clear();
            AbstractIndexedListIterator abstractIndexedListIteratorListIterator = immutableList2N.listIterator();
            while (abstractIndexedListIteratorListIterator.hasNext()) {
                ((DefaultDrmSession) abstractIndexedListIteratorListIterator.next()).k(exc, z2 ? 1 : 3);
            }
        }
    }

    public class f implements DefaultDrmSession.b {
        public f(a aVar) {
        }
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.c cVar, MediaDrmCallback mediaDrmCallback, HashMap map, boolean z2, int[] iArr, boolean z3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, a aVar) {
        Objects.requireNonNull(uuid);
        AnimatableValueParser.m(!C.f1158b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f2929b = uuid;
        this.c = cVar;
        this.d = mediaDrmCallback;
        this.e = map;
        this.f = z2;
        this.g = iArr;
        this.h = z3;
        this.j = loadErrorHandlingPolicy;
        this.i = new e();
        this.k = new f(null);
        this.v = 0;
        this.m = new ArrayList();
        this.n = Collections2.c();
        this.o = Collections2.c();
        this.l = j;
    }

    public static boolean f(DrmSession drmSession) {
        DefaultDrmSession defaultDrmSession = (DefaultDrmSession) drmSession;
        if (defaultDrmSession.n == 1) {
            if (Util2.a < 19) {
                return true;
            }
            DrmSession.DrmSessionException drmSessionExceptionF = defaultDrmSession.f();
            Objects.requireNonNull(drmSessionExceptionF);
            if (drmSessionExceptionF.getCause() instanceof ResourceBusyException) {
                return true;
            }
        }
        return false;
    }

    public static List<DrmInitData.SchemeData> i(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.m);
        for (int i = 0; i < drmInitData.m; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.j[i];
            if ((schemeData.a(uuid) || (C.c.equals(uuid) && schemeData.a(C.f1158b))) && (schemeData.n != null || z2)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Override // b.i.a.c.w2.DrmSessionManager2
    public final void a() {
        int i = this.p;
        this.p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.q == null) {
            ExoMediaDrm exoMediaDrmA = this.c.a(this.f2929b);
            this.q = exoMediaDrmA;
            exoMediaDrmA.h(new b(null));
        } else if (this.l != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                this.m.get(i2).a(null);
            }
        }
    }

    @Override // b.i.a.c.w2.DrmSessionManager2
    public DrmSessionManager2.b b(Looper looper, @Nullable DrmSessionEventListener.a aVar, final Format2 format2) {
        AnimatableValueParser.D(this.p > 0);
        j(looper);
        final d dVar = new d(aVar);
        Handler handler = this.u;
        Objects.requireNonNull(handler);
        handler.post(new Runnable() { // from class: b.i.a.c.w2.e
            @Override // java.lang.Runnable
            public final void run() {
                DefaultDrmSessionManager.d dVar2 = dVar;
                Format2 format3 = format2;
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.p == 0 || dVar2.d) {
                    return;
                }
                Looper looper2 = defaultDrmSessionManager.t;
                Objects.requireNonNull(looper2);
                dVar2.c = defaultDrmSessionManager.e(looper2, dVar2.f2932b, format3, false);
                DefaultDrmSessionManager.this.n.add(dVar2);
            }
        });
        return dVar;
    }

    @Override // b.i.a.c.w2.DrmSessionManager2
    @Nullable
    public DrmSession c(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2) {
        AnimatableValueParser.D(this.p > 0);
        j(looper);
        return e(looper, aVar, format2, true);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.w2.DrmSessionManager2
    public int d(Format2 format2) {
        String str;
        ExoMediaDrm exoMediaDrm = this.q;
        Objects.requireNonNull(exoMediaDrm);
        int iL = exoMediaDrm.l();
        DrmInitData drmInitData = format2.f1020z;
        boolean z2 = false;
        if (drmInitData == null) {
            int iG = MimeTypes.g(format2.w);
            int[] iArr = this.g;
            int i = Util2.a;
            int i2 = 0;
            while (i2 < iArr.length) {
                if (iArr[i2] == iG) {
                    if (i2 != -1) {
                        return iL;
                    }
                    return 0;
                }
                i2++;
            }
            i2 = -1;
            if (i2 != -1) {
                return iL;
            }
            return 0;
        }
        if (this.w != null) {
            z2 = true;
        } else if (!((ArrayList) i(drmInitData, this.f2929b, true)).isEmpty()) {
            str = drmInitData.l;
            if (str != null || "cenc".equals(str) || (!"cbcs".equals(str) ? !("cbc1".equals(str) || "cens".equals(str)) : Util2.a >= 25)) {
                z2 = true;
            }
        } else if (drmInitData.m == 1 && drmInitData.j[0].a(C.f1158b)) {
            String strValueOf = String.valueOf(this.f2929b);
            outline.h0(strValueOf.length() + 72, "DrmInitData only contains common PSSH SchemeData. Assuming support for: ", strValueOf, "DefaultDrmSessionMgr");
            str = drmInitData.l;
            if (str != null) {
                z2 = true;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            return iL;
        }
        return 1;
    }

    @Nullable
    public final DrmSession e(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2, boolean z2) {
        List<DrmInitData.SchemeData> listI;
        if (this.f2931x == null) {
            this.f2931x = new c(looper);
        }
        DrmInitData drmInitData = format2.f1020z;
        DefaultDrmSession defaultDrmSessionH = null;
        int i = 0;
        if (drmInitData == null) {
            int iG = MimeTypes.g(format2.w);
            ExoMediaDrm exoMediaDrm = this.q;
            Objects.requireNonNull(exoMediaDrm);
            if (exoMediaDrm.l() == 2 && FrameworkCryptoConfig.a) {
                return null;
            }
            int[] iArr = this.g;
            int i2 = Util2.a;
            while (true) {
                if (i >= iArr.length) {
                    i = -1;
                    break;
                }
                if (iArr[i] == iG) {
                    break;
                }
                i++;
            }
            if (i == -1 || exoMediaDrm.l() == 1) {
                return null;
            }
            DefaultDrmSession defaultDrmSession = this.r;
            if (defaultDrmSession == null) {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                DefaultDrmSession defaultDrmSessionH2 = h(RegularImmutableList.l, true, null, z2);
                this.m.add(defaultDrmSessionH2);
                this.r = defaultDrmSessionH2;
            } else {
                defaultDrmSession.a(null);
            }
            return this.r;
        }
        if (this.w == null) {
            listI = i(drmInitData, this.f2929b, false);
            if (((ArrayList) listI).isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f2929b, null);
                Log2.b("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.e(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listI = null;
        }
        if (this.f) {
            for (DefaultDrmSession defaultDrmSession2 : this.m) {
                if (Util2.a(defaultDrmSession2.a, listI)) {
                    defaultDrmSessionH = defaultDrmSession2;
                    break;
                }
            }
        } else {
            defaultDrmSessionH = this.f2930s;
        }
        if (defaultDrmSessionH == null) {
            defaultDrmSessionH = h(listI, false, aVar, z2);
            if (!this.f) {
                this.f2930s = defaultDrmSessionH;
            }
            this.m.add(defaultDrmSessionH);
        } else {
            defaultDrmSessionH.a(aVar);
        }
        return defaultDrmSessionH;
    }

    public final DefaultDrmSession g(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable DrmSessionEventListener.a aVar) {
        Objects.requireNonNull(this.q);
        boolean z3 = this.h | z2;
        UUID uuid = this.f2929b;
        ExoMediaDrm exoMediaDrm = this.q;
        e eVar = this.i;
        f fVar = this.k;
        int i = this.v;
        byte[] bArr = this.w;
        HashMap<String, String> map = this.e;
        MediaDrmCallback mediaDrmCallback = this.d;
        Looper looper = this.t;
        Objects.requireNonNull(looper);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(uuid, exoMediaDrm, eVar, fVar, list, i, z3, z2, bArr, map, mediaDrmCallback, looper, this.j);
        defaultDrmSession.a(aVar);
        if (this.l != -9223372036854775807L) {
            defaultDrmSession.a(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession h(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable DrmSessionEventListener.a aVar, boolean z3) {
        DefaultDrmSession defaultDrmSessionG = g(list, z2, aVar);
        if (f(defaultDrmSessionG) && !this.o.isEmpty()) {
            l();
            defaultDrmSessionG.b(aVar);
            if (this.l != -9223372036854775807L) {
                defaultDrmSessionG.b(null);
            }
            defaultDrmSessionG = g(list, z2, aVar);
        }
        if (!f(defaultDrmSessionG) || !z3 || this.n.isEmpty()) {
            return defaultDrmSessionG;
        }
        m();
        if (!this.o.isEmpty()) {
            l();
        }
        defaultDrmSessionG.b(aVar);
        if (this.l != -9223372036854775807L) {
            defaultDrmSessionG.b(null);
        }
        return g(list, z2, aVar);
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    public final synchronized void j(Looper looper) {
        Looper looper2 = this.t;
        if (looper2 == null) {
            this.t = looper;
            this.u = new Handler(looper);
        } else {
            AnimatableValueParser.D(looper2 == looper);
            Objects.requireNonNull(this.u);
        }
    }

    public final void k() {
        if (this.q != null && this.p == 0 && this.m.isEmpty() && this.n.isEmpty()) {
            ExoMediaDrm exoMediaDrm = this.q;
            Objects.requireNonNull(exoMediaDrm);
            exoMediaDrm.release();
            this.q = null;
        }
    }

    public final void l() {
        Iterator it = ImmutableSet2.m(this.o).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).b(null);
        }
    }

    public final void m() {
        Iterator it = ImmutableSet2.m(this.n).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            Handler handler = DefaultDrmSessionManager.this.u;
            Objects.requireNonNull(handler);
            Util2.E(handler, new b.i.a.c.w2.d(dVar));
        }
    }

    @Override // b.i.a.c.w2.DrmSessionManager2
    public final void release() {
        int i = this.p - 1;
        this.p = i;
        if (i != 0) {
            return;
        }
        if (this.l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.m);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).b(null);
            }
        }
        m();
        k();
    }
}
