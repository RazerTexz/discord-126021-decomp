package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;
import com.google.android.gms.cloudmessaging.zzp;

/* JADX INFO: renamed from: b.i.a.f.d.o */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3240o extends AbstractC3242q<Void> {
    public C3240o(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // p007b.p225i.p226a.p288f.p298d.AbstractC3242q
    /* JADX INFO: renamed from: a */
    public final void mo4006a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            m4009c(null);
        } else {
            m4008b(new zzp(4, "Invalid response to one way request"));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p298d.AbstractC3242q
    /* JADX INFO: renamed from: d */
    public final boolean mo4007d() {
        return true;
    }
}
