package b.i.a.f.d;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zzp;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q<T> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<T> f1341b = new TaskCompletionSource<>();
    public final int c;
    public final Bundle d;

    public q(int i, int i2, Bundle bundle) {
        this.a = i;
        this.c = i2;
        this.d = bundle;
    }

    public abstract void a(Bundle bundle);

    public final void b(zzp zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzpVar);
            Log.d("MessengerIpcClient", b.d.b.a.a.l(strValueOf2.length() + strValueOf.length() + 14, "Failing ", strValueOf, " with ", strValueOf2));
        }
        this.f1341b.a.t(zzpVar);
    }

    public final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", b.d.b.a.a.l(strValueOf2.length() + strValueOf.length() + 16, "Finishing ", strValueOf, " with ", strValueOf2));
        }
        this.f1341b.a.s(t);
    }

    public abstract boolean d();

    public String toString() {
        int i = this.c;
        int i2 = this.a;
        boolean zD = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(zD);
        sb.append("}");
        return sb.toString();
    }
}
