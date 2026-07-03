package p007b.p225i.p226a.p288f.p299e.p304k;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: renamed from: b.i.a.f.e.k.z */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3393z extends AbstractC3360i0<Boolean> {

    /* JADX INFO: renamed from: d */
    public final int f9574d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final Bundle f9575e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ AbstractC3345b f9576f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public AbstractC3393z(AbstractC3345b abstractC3345b, @Nullable int i, Bundle bundle) {
        super(abstractC3345b, Boolean.TRUE);
        this.f9576f = abstractC3345b;
        this.f9574d = i;
        this.f9575e = bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3360i0
    /* JADX INFO: renamed from: a */
    public final void mo4159a() {
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3360i0
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void mo4160b(Boolean bool) {
        ConnectionResult connectionResult;
        if (this.f9574d != 0) {
            this.f9576f.m4127F(1, null);
            Bundle bundle = this.f9575e;
            connectionResult = new ConnectionResult(this.f9574d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
        } else {
            if (mo4171d()) {
                return;
            }
            this.f9576f.m4127F(1, null);
            connectionResult = new ConnectionResult(8, null);
        }
        mo4172e(connectionResult);
    }

    /* JADX INFO: renamed from: d */
    public abstract boolean mo4171d();

    /* JADX INFO: renamed from: e */
    public abstract void mo4172e(ConnectionResult connectionResult);
}
