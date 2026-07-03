package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.i.b.k7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4095k7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Bundle f10887j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4072i7 f10888k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4072i7 f10889l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f10890m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C4060h7 f10891n;

    public RunnableC4095k7(C4060h7 c4060h7, Bundle bundle, C4072i7 c4072i7, C4072i7 c4072i8, long j) {
        this.f10891n = c4060h7;
        this.f10887j = bundle;
        this.f10888k = c4072i7;
        this.f10889l = c4072i8;
        this.f10890m = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4060h7 c4060h7 = this.f10891n;
        Bundle bundle = this.f10887j;
        C4072i7 c4072i7 = this.f10888k;
        C4072i7 c4072i8 = this.f10889l;
        long j = this.f10890m;
        Objects.requireNonNull(c4060h7);
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        c4060h7.m5652B(c4072i7, c4072i8, j, true, c4060h7.m5866e().m5929z(null, "screen_view", bundle, null, true));
    }
}
