package b.i.a.f.d;

import android.os.Bundle;
import com.google.android.gms.cloudmessaging.zzp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends q<Void> {
    public o(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // b.i.a.f.d.q
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            c(null);
        } else {
            b(new zzp(4, "Invalid response to one way request"));
        }
    }

    @Override // b.i.a.f.d.q
    public final boolean d() {
        return true;
    }
}
