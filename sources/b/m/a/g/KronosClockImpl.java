package b.m.a.g;

import b.m.a.Clock5;
import b.m.a.Clock6;
import b.m.a.g.d.SntpService;
import com.lyft.kronos.Clock8;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.g.b, reason: use source file name */
/* JADX INFO: compiled from: KronosClockImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KronosClockImpl implements Clock8 {
    public final SntpService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Clock5 f1905b;

    public KronosClockImpl(SntpService sntpService, Clock5 clock5) {
        Intrinsics3.checkParameterIsNotNull(sntpService, "ntpService");
        Intrinsics3.checkParameterIsNotNull(clock5, "fallbackClock");
        this.a = sntpService;
        this.f1905b = clock5;
    }

    @Override // com.lyft.kronos.Clock8, b.m.a.Clock5
    public long a() {
        return c().a;
    }

    @Override // b.m.a.Clock5
    public long b() {
        return this.f1905b.b();
    }

    public Clock6 c() {
        Clock6 clock6A = this.a.a();
        return clock6A != null ? clock6A : new Clock6(this.f1905b.a(), null);
    }
}
