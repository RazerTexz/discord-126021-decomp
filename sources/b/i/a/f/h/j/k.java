package b.i.a.f.h.j;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends a0 {
    public final /* synthetic */ j e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, g gVar) {
        super(gVar);
        this.e = jVar;
    }

    @Override // b.i.a.f.h.j.a0
    public final void c() {
        j jVar = this.e;
        Objects.requireNonNull(jVar);
        b.i.a.f.b.f.b();
        if (jVar.R()) {
            jVar.C("Inactivity, disconnecting from device AnalyticsService");
            jVar.O();
        }
    }
}
