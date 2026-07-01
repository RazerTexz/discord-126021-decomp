package b.i.c.w;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.EnhancedIntentService;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final EnhancedIntentService j;
    public final Intent k;
    public final TaskCompletionSource l;

    public d(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.j = enhancedIntentService;
        this.k = intent;
        this.l = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.lambda$processIntent$0$EnhancedIntentService(this.k, this.l);
    }
}
