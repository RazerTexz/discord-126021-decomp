package b.i.c.w;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements b.i.a.f.n.c {
    public final EnhancedIntentService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f1795b;

    public f(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.a = enhancedIntentService;
        this.f1795b = intent;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task task) {
        this.a.lambda$onStartCommand$1$EnhancedIntentService(this.f1795b, task);
    }
}
