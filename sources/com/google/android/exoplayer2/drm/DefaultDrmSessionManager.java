package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2721w;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p266w2.C2968b0;
import p007b.p225i.p226a.p242c.p266w2.C2995z;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2974e0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u;
import p007b.p225i.p226a.p242c.p266w2.RunnableC2971d;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.AbstractC4527r;
import p007b.p225i.p355b.p357b.C4507h;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public class DefaultDrmSessionManager implements InterfaceC2990u {

    /* JADX INFO: renamed from: b */
    public final UUID f19815b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2966a0.c f19816c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2974e0 f19817d;

    /* JADX INFO: renamed from: e */
    public final HashMap<String, String> f19818e;

    /* JADX INFO: renamed from: f */
    public final boolean f19819f;

    /* JADX INFO: renamed from: g */
    public final int[] f19820g;

    /* JADX INFO: renamed from: h */
    public final boolean f19821h;

    /* JADX INFO: renamed from: i */
    public final C10708e f19822i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC2721w f19823j;

    /* JADX INFO: renamed from: k */
    public final C10709f f19824k;

    /* JADX INFO: renamed from: l */
    public final long f19825l;

    /* JADX INFO: renamed from: m */
    public final List<DefaultDrmSession> f19826m;

    /* JADX INFO: renamed from: n */
    public final Set<C10707d> f19827n;

    /* JADX INFO: renamed from: o */
    public final Set<DefaultDrmSession> f19828o;

    /* JADX INFO: renamed from: p */
    public int f19829p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public InterfaceC2966a0 f19830q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public DefaultDrmSession f19831r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public DefaultDrmSession f19832s;

    /* JADX INFO: renamed from: t */
    public Looper f19833t;

    /* JADX INFO: renamed from: u */
    public Handler f19834u;

    /* JADX INFO: renamed from: v */
    public int f19835v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public byte[] f19836w;

    /* JADX INFO: renamed from: x */
    @Nullable
    public volatile HandlerC10706c f19837x;

    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public MissingSchemeDataException(UUID uuid, C10704a c10704a) {
            String strValueOf = String.valueOf(uuid);
            super(C1643a.m857j(strValueOf.length() + 29, "Media does not support uuid: ", strValueOf));
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$b */
    public class C10705b implements InterfaceC2966a0.b {
        public C10705b(C10704a c10704a) {
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$c */
    @SuppressLint({"HandlerLeak"})
    public class HandlerC10706c extends Handler {
        public HandlerC10706c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f19826m) {
                if (Arrays.equals(defaultDrmSession.f19803t, bArr)) {
                    if (message.what == 2 && defaultDrmSession.f19788e == 0 && defaultDrmSession.f19797n == 4) {
                        int i = C2738e0.f6708a;
                        defaultDrmSession.m8816i(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$d */
    public class C10707d implements InterfaceC2990u.b {

        /* JADX INFO: renamed from: b */
        @Nullable
        public final InterfaceC2988s.a f19840b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public DrmSession f19841c;

        /* JADX INFO: renamed from: d */
        public boolean f19842d;

        public C10707d(InterfaceC2988s.a aVar) {
            this.f19840b = aVar;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u.b
        public void release() {
            Handler handler = DefaultDrmSessionManager.this.f19834u;
            Objects.requireNonNull(handler);
            C2738e0.m2984E(handler, new RunnableC2971d(this));
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$e */
    public class C10708e implements DefaultDrmSession.InterfaceC10699a {

        /* JADX INFO: renamed from: a */
        public final Set<DefaultDrmSession> f19844a = new HashSet();

        /* JADX INFO: renamed from: b */
        @Nullable
        public DefaultDrmSession f19845b;

        /* JADX INFO: renamed from: a */
        public void m8834a(Exception exc, boolean z2) {
            this.f19845b = null;
            AbstractC4523p abstractC4523pM6264n = AbstractC4523p.m6264n(this.f19844a);
            this.f19844a.clear();
            AbstractC4493a abstractC4493aListIterator = abstractC4523pM6264n.listIterator();
            while (abstractC4493aListIterator.hasNext()) {
                ((DefaultDrmSession) abstractC4493aListIterator.next()).m8818k(exc, z2 ? 1 : 3);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$f */
    public class C10709f implements DefaultDrmSession.InterfaceC10700b {
        public C10709f(C10704a c10704a) {
        }
    }

    public DefaultDrmSessionManager(UUID uuid, InterfaceC2966a0.c cVar, InterfaceC2974e0 interfaceC2974e0, HashMap map, boolean z2, int[] iArr, boolean z3, InterfaceC2721w interfaceC2721w, long j, C10704a c10704a) {
        Objects.requireNonNull(uuid);
        C1460d.m543m(!C2997x0.f8022b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f19815b = uuid;
        this.f19816c = cVar;
        this.f19817d = interfaceC2974e0;
        this.f19818e = map;
        this.f19819f = z2;
        this.f19820g = iArr;
        this.f19821h = z3;
        this.f19823j = interfaceC2721w;
        this.f19822i = new C10708e();
        this.f19824k = new C10709f(null);
        this.f19835v = 0;
        this.f19826m = new ArrayList();
        this.f19827n = C4507h.m6240c();
        this.f19828o = C4507h.m6240c();
        this.f19825l = j;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m8825f(DrmSession drmSession) {
        DefaultDrmSession defaultDrmSession = (DefaultDrmSession) drmSession;
        if (defaultDrmSession.f19797n == 1) {
            if (C2738e0.f6708a < 19) {
                return true;
            }
            DrmSession.DrmSessionException drmSessionExceptionMo3611f = defaultDrmSession.mo3611f();
            Objects.requireNonNull(drmSessionExceptionMo3611f);
            if (drmSessionExceptionMo3611f.getCause() instanceof ResourceBusyException) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public static List<DrmInitData.SchemeData> m8826i(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.f19850m);
        for (int i = 0; i < drmInitData.f19850m; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.f19847j[i];
            if ((schemeData.m8836a(uuid) || (C2997x0.f8023c.equals(uuid) && schemeData.m8836a(C2997x0.f8022b))) && (schemeData.f19855n != null || z2)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
    /* JADX INFO: renamed from: a */
    public final void mo3597a() {
        int i = this.f19829p;
        this.f19829p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.f19830q == null) {
            InterfaceC2966a0 interfaceC2966a0Mo3581a = this.f19816c.mo3581a(this.f19815b);
            this.f19830q = interfaceC2966a0Mo3581a;
            interfaceC2966a0Mo3581a.mo3576h(new C10705b(null));
        } else if (this.f19825l != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.f19826m.size(); i2++) {
                this.f19826m.get(i2).mo3606a(null);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
    /* JADX INFO: renamed from: b */
    public InterfaceC2990u.b mo3598b(Looper looper, @Nullable InterfaceC2988s.a aVar, final C2811j1 c2811j1) {
        C1460d.m426D(this.f19829p > 0);
        m8830j(looper);
        final C10707d c10707d = new C10707d(aVar);
        Handler handler = this.f19834u;
        Objects.requireNonNull(handler);
        handler.post(new Runnable() { // from class: b.i.a.c.w2.e
            @Override // java.lang.Runnable
            public final void run() {
                DefaultDrmSessionManager.C10707d c10707d2 = c10707d;
                C2811j1 c2811j2 = c2811j1;
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.f19829p == 0 || c10707d2.f19842d) {
                    return;
                }
                Looper looper2 = defaultDrmSessionManager.f19833t;
                Objects.requireNonNull(looper2);
                c10707d2.f19841c = defaultDrmSessionManager.m8827e(looper2, c10707d2.f19840b, c2811j2, false);
                DefaultDrmSessionManager.this.f19827n.add(c10707d2);
            }
        });
        return c10707d;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
    @Nullable
    /* JADX INFO: renamed from: c */
    public DrmSession mo3599c(Looper looper, @Nullable InterfaceC2988s.a aVar, C2811j1 c2811j1) {
        C1460d.m426D(this.f19829p > 0);
        m8830j(looper);
        return m8827e(looper, aVar, c2811j1, true);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
    /* JADX INFO: renamed from: d */
    public int mo3600d(C2811j1 c2811j1) {
        String str;
        InterfaceC2966a0 interfaceC2966a0 = this.f19830q;
        Objects.requireNonNull(interfaceC2966a0);
        int iMo3580l = interfaceC2966a0.mo3580l();
        DrmInitData drmInitData = c2811j1.f7158z;
        boolean z2 = false;
        if (drmInitData == null) {
            int iM3049g = C2753t.m3049g(c2811j1.f7155w);
            int[] iArr = this.f19820g;
            int i = C2738e0.f6708a;
            int i2 = 0;
            while (i2 < iArr.length) {
                if (iArr[i2] == iM3049g) {
                    if (i2 != -1) {
                        return iMo3580l;
                    }
                    return 0;
                }
                i2++;
            }
            i2 = -1;
            if (i2 != -1) {
                return iMo3580l;
            }
            return 0;
        }
        if (this.f19836w != null) {
            z2 = true;
        } else if (!((ArrayList) m8826i(drmInitData, this.f19815b, true)).isEmpty()) {
            str = drmInitData.f19849l;
            if (str != null || "cenc".equals(str) || (!"cbcs".equals(str) ? !("cbc1".equals(str) || "cens".equals(str)) : C2738e0.f6708a >= 25)) {
                z2 = true;
            }
        } else if (drmInitData.f19850m == 1 && drmInitData.f19847j[0].m8836a(C2997x0.f8022b)) {
            String strValueOf = String.valueOf(this.f19815b);
            C1643a.m854h0(strValueOf.length() + 72, "DrmInitData only contains common PSSH SchemeData. Assuming support for: ", strValueOf, "DefaultDrmSessionMgr");
            str = drmInitData.f19849l;
            if (str != null) {
                z2 = true;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            return iMo3580l;
        }
        return 1;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public final DrmSession m8827e(Looper looper, @Nullable InterfaceC2988s.a aVar, C2811j1 c2811j1, boolean z2) {
        List<DrmInitData.SchemeData> listM8826i;
        if (this.f19837x == null) {
            this.f19837x = new HandlerC10706c(looper);
        }
        DrmInitData drmInitData = c2811j1.f7158z;
        DefaultDrmSession defaultDrmSessionM8829h = null;
        int i = 0;
        if (drmInitData == null) {
            int iM3049g = C2753t.m3049g(c2811j1.f7155w);
            InterfaceC2966a0 interfaceC2966a0 = this.f19830q;
            Objects.requireNonNull(interfaceC2966a0);
            if (interfaceC2966a0.mo3580l() == 2 && C2968b0.f7972a) {
                return null;
            }
            int[] iArr = this.f19820g;
            int i2 = C2738e0.f6708a;
            while (true) {
                if (i >= iArr.length) {
                    i = -1;
                    break;
                }
                if (iArr[i] == iM3049g) {
                    break;
                }
                i++;
            }
            if (i == -1 || interfaceC2966a0.mo3580l() == 1) {
                return null;
            }
            DefaultDrmSession defaultDrmSession = this.f19831r;
            if (defaultDrmSession == null) {
                AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
                DefaultDrmSession defaultDrmSessionM8829h2 = m8829h(C4508h0.f12012l, true, null, z2);
                this.f19826m.add(defaultDrmSessionM8829h2);
                this.f19831r = defaultDrmSessionM8829h2;
            } else {
                defaultDrmSession.mo3606a(null);
            }
            return this.f19831r;
        }
        if (this.f19836w == null) {
            listM8826i = m8826i(drmInitData, this.f19815b, false);
            if (((ArrayList) listM8826i).isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f19815b, null);
                C2750q.m3039b("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.m3591e(missingSchemeDataException);
                }
                return new C2995z(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listM8826i = null;
        }
        if (this.f19819f) {
            for (DefaultDrmSession defaultDrmSession2 : this.f19826m) {
                if (C2738e0.m2993a(defaultDrmSession2.f19784a, listM8826i)) {
                    defaultDrmSessionM8829h = defaultDrmSession2;
                    break;
                }
            }
        } else {
            defaultDrmSessionM8829h = this.f19832s;
        }
        if (defaultDrmSessionM8829h == null) {
            defaultDrmSessionM8829h = m8829h(listM8826i, false, aVar, z2);
            if (!this.f19819f) {
                this.f19832s = defaultDrmSessionM8829h;
            }
            this.f19826m.add(defaultDrmSessionM8829h);
        } else {
            defaultDrmSessionM8829h.mo3606a(aVar);
        }
        return defaultDrmSessionM8829h;
    }

    /* JADX INFO: renamed from: g */
    public final DefaultDrmSession m8828g(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable InterfaceC2988s.a aVar) {
        Objects.requireNonNull(this.f19830q);
        boolean z3 = this.f19821h | z2;
        UUID uuid = this.f19815b;
        InterfaceC2966a0 interfaceC2966a0 = this.f19830q;
        C10708e c10708e = this.f19822i;
        C10709f c10709f = this.f19824k;
        int i = this.f19835v;
        byte[] bArr = this.f19836w;
        HashMap<String, String> map = this.f19818e;
        InterfaceC2974e0 interfaceC2974e0 = this.f19817d;
        Looper looper = this.f19833t;
        Objects.requireNonNull(looper);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(uuid, interfaceC2966a0, c10708e, c10709f, list, i, z3, z2, bArr, map, interfaceC2974e0, looper, this.f19823j);
        defaultDrmSession.mo3606a(aVar);
        if (this.f19825l != -9223372036854775807L) {
            defaultDrmSession.mo3606a(null);
        }
        return defaultDrmSession;
    }

    /* JADX INFO: renamed from: h */
    public final DefaultDrmSession m8829h(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable InterfaceC2988s.a aVar, boolean z3) {
        DefaultDrmSession defaultDrmSessionM8828g = m8828g(list, z2, aVar);
        if (m8825f(defaultDrmSessionM8828g) && !this.f19828o.isEmpty()) {
            m8832l();
            defaultDrmSessionM8828g.mo3607b(aVar);
            if (this.f19825l != -9223372036854775807L) {
                defaultDrmSessionM8828g.mo3607b(null);
            }
            defaultDrmSessionM8828g = m8828g(list, z2, aVar);
        }
        if (!m8825f(defaultDrmSessionM8828g) || !z3 || this.f19827n.isEmpty()) {
            return defaultDrmSessionM8828g;
        }
        m8833m();
        if (!this.f19828o.isEmpty()) {
            m8832l();
        }
        defaultDrmSessionM8828g.mo3607b(aVar);
        if (this.f19825l != -9223372036854775807L) {
            defaultDrmSessionM8828g.mo3607b(null);
        }
        return m8828g(list, z2, aVar);
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    /* JADX INFO: renamed from: j */
    public final synchronized void m8830j(Looper looper) {
        Looper looper2 = this.f19833t;
        if (looper2 == null) {
            this.f19833t = looper;
            this.f19834u = new Handler(looper);
        } else {
            C1460d.m426D(looper2 == looper);
            Objects.requireNonNull(this.f19834u);
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m8831k() {
        if (this.f19830q != null && this.f19829p == 0 && this.f19826m.isEmpty() && this.f19827n.isEmpty()) {
            InterfaceC2966a0 interfaceC2966a0 = this.f19830q;
            Objects.requireNonNull(interfaceC2966a0);
            interfaceC2966a0.release();
            this.f19830q = null;
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m8832l() {
        Iterator it = AbstractC4527r.m6281m(this.f19828o).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).mo3607b(null);
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m8833m() {
        Iterator it = AbstractC4527r.m6281m(this.f19827n).iterator();
        while (it.hasNext()) {
            C10707d c10707d = (C10707d) it.next();
            Handler handler = DefaultDrmSessionManager.this.f19834u;
            Objects.requireNonNull(handler);
            C2738e0.m2984E(handler, new RunnableC2971d(c10707d));
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
    public final void release() {
        int i = this.f19829p - 1;
        this.f19829p = i;
        if (i != 0) {
            return;
        }
        if (this.f19825l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f19826m);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).mo3607b(null);
            }
        }
        m8833m();
        m8831k();
    }
}
