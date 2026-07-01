package b.i.c.s;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class d0$a {
    public final Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<Void> f1765b = new TaskCompletionSource<>();

    public d0$a(Intent intent) {
        this.a = intent;
    }

    public void a() {
        this.f1765b.b(null);
    }
}
