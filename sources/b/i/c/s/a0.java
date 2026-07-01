package b.i.c.s;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.messaging.EnhancedIntentService$a;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a0 extends Binder {
    public final a0$a a;

    public a0(a0$a a0_a) {
        this.a = a0_a;
    }

    public void a(d0$a d0_a) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        a0$a a0_a = this.a;
        Task taskAccess$000 = EnhancedIntentService.access$000(((EnhancedIntentService$a) a0_a).a, d0_a.a);
        Executor executor = h.a;
        taskAccess$000.c(g.j, new z(d0_a));
    }
}
