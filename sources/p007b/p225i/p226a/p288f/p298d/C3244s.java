package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;

/* JADX INFO: renamed from: b.i.a.f.d.s */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3244s extends AbstractC3242q<Bundle> {
    public C3244s(int i, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // p007b.p225i.p226a.p288f.p298d.AbstractC3242q
    /* JADX INFO: renamed from: a */
    public final void mo4006a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        m4009c(bundle2);
    }

    @Override // p007b.p225i.p226a.p288f.p298d.AbstractC3242q
    /* JADX INFO: renamed from: d */
    public final boolean mo4007d() {
        return false;
    }
}
