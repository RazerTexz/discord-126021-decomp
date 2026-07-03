package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.p9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4152p9 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f11132j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Bundle f11133k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4130n9 f11134l;

    public RunnableC4152p9(C4130n9 c4130n9, String str, Bundle bundle) {
        this.f11134l = c4130n9;
        this.f11132j = str;
        this.f11133k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        C4196t9 c4196t9M5949t = this.f11134l.f10997a.f10906k.m5949t();
        String str = this.f11132j;
        Bundle bundle = this.f11133k;
        Objects.requireNonNull((C3401c) this.f11134l.f10997a.f10906k.f11267o);
        this.f11134l.f10997a.m5732m(c4196t9M5949t.m5890B(str, "_err", bundle, "auto", System.currentTimeMillis(), false, false), this.f11132j);
    }
}
