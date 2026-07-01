package b.i.c.s;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import b.i.c.s.d0;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a0 extends Binder {
    public final a a;

    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public interface a {
    }

    public a0(a aVar) {
        this.a = aVar;
    }

    public void a(final d0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        a aVar2 = this.a;
        Task taskProcessIntent = EnhancedIntentService.this.processIntent(aVar.a);
        Executor executor = h.a;
        taskProcessIntent.c(g.j, new b.i.a.f.n.c(aVar) { // from class: b.i.c.s.z
            public final d0.a a;

            {
                this.a = aVar;
            }

            @Override // b.i.a.f.n.c
            public final void onComplete(Task task) {
                this.a.a();
            }
        });
    }
}
