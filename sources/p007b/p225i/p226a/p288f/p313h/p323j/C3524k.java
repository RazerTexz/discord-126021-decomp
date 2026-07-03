package p007b.p225i.p226a.p288f.p313h.p323j;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3180f;

/* JADX INFO: renamed from: b.i.a.f.h.j.k */
/* JADX INFO: loaded from: classes3.dex */
public final class C3524k extends AbstractC3498a0 {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C3522j f9753e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3524k(C3522j c3522j, C3515g c3515g) {
        super(c3515g);
        this.f9753e = c3522j;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3498a0
    /* JADX INFO: renamed from: c */
    public final void mo4418c() {
        C3522j c3522j = this.f9753e;
        Objects.requireNonNull(c3522j);
        C3180f.m3967b();
        if (c3522j.m4458R()) {
            c3522j.m4427C("Inactivity, disconnecting from device AnalyticsService");
            c3522j.m4457O();
        }
    }
}
