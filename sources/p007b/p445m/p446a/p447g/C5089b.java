package p007b.p445m.p446a.p447g;

import com.lyft.kronos.KronosClock;
import p007b.p445m.p446a.C5085d;
import p007b.p445m.p446a.InterfaceC5083b;
import p007b.p445m.p446a.p447g.p448d.InterfaceC5098h;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.g.b */
/* JADX INFO: compiled from: KronosClockImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5089b implements KronosClock {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5098h f13646a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5083b f13647b;

    public C5089b(InterfaceC5098h interfaceC5098h, InterfaceC5083b interfaceC5083b) {
        C12238m.checkParameterIsNotNull(interfaceC5098h, "ntpService");
        C12238m.checkParameterIsNotNull(interfaceC5083b, "fallbackClock");
        this.f13646a = interfaceC5098h;
        this.f13647b = interfaceC5083b;
    }

    @Override // com.lyft.kronos.KronosClock, p007b.p445m.p446a.InterfaceC5083b
    /* JADX INFO: renamed from: a */
    public long mo7128a() {
        return m7139c().f13644a;
    }

    @Override // p007b.p445m.p446a.InterfaceC5083b
    /* JADX INFO: renamed from: b */
    public long mo7129b() {
        return this.f13647b.mo7129b();
    }

    /* JADX INFO: renamed from: c */
    public C5085d m7139c() {
        C5085d c5085dMo7150a = this.f13646a.mo7150a();
        return c5085dMo7150a != null ? c5085dMo7150a : new C5085d(this.f13647b.mo7128a(), null);
    }
}
