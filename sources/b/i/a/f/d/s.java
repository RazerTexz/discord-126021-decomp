package b.i.a.f.d;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends q<Bundle> {
    public s(int i, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // b.i.a.f.d.q
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        c(bundle2);
    }

    @Override // b.i.a.f.d.q
    public final boolean d() {
        return false;
    }
}
