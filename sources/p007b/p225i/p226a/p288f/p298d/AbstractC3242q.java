package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zzp;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.d.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3242q<T> {

    /* JADX INFO: renamed from: a */
    public final int f9279a;

    /* JADX INFO: renamed from: b */
    public final TaskCompletionSource<T> f9280b = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: c */
    public final int f9281c;

    /* JADX INFO: renamed from: d */
    public final Bundle f9282d;

    public AbstractC3242q(int i, int i2, Bundle bundle) {
        this.f9279a = i;
        this.f9281c = i2;
        this.f9282d = bundle;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo4006a(Bundle bundle);

    /* JADX INFO: renamed from: b */
    public final void m4008b(zzp zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzpVar);
            Log.d("MessengerIpcClient", C1643a.m861l(strValueOf2.length() + strValueOf.length() + 14, "Failing ", strValueOf, " with ", strValueOf2));
        }
        this.f9280b.f20845a.m6025t(zzpVar);
    }

    /* JADX INFO: renamed from: c */
    public final void m4009c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", C1643a.m861l(strValueOf2.length() + strValueOf.length() + 16, "Finishing ", strValueOf, " with ", strValueOf2));
        }
        this.f9280b.f20845a.m6024s(t);
    }

    /* JADX INFO: renamed from: d */
    public abstract boolean mo4007d();

    public String toString() {
        int i = this.f9281c;
        int i2 = this.f9279a;
        boolean zMo4007d = mo4007d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(zMo4007d);
        sb.append("}");
        return sb.toString();
    }
}
