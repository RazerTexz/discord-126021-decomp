package b.i.a.f.d;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements Runnable {
    public final TaskCompletionSource j;

    public u(TaskCompletionSource taskCompletionSource) {
        this.j = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.j.a(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
