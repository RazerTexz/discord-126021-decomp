package p007b.p225i.p361c.p398s;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p225i.p361c.p398s.ServiceConnectionC4812d0;

/* JADX INFO: renamed from: b.i.c.s.a0 */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC4806a0 extends Binder {

    /* JADX INFO: renamed from: a */
    public final a f12844a;

    /* JADX INFO: renamed from: b.i.c.s.a0$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public interface a {
    }

    public BinderC4806a0(a aVar) {
        this.f12844a = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m6719a(final ServiceConnectionC4812d0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        a aVar2 = this.f12844a;
        Task taskProcessIntent = EnhancedIntentService.this.processIntent(aVar.f12858a);
        Executor executor = C4817h.f12866a;
        taskProcessIntent.mo6008c(ExecutorC4816g.f12865j, new InterfaceC4357c(aVar) { // from class: b.i.c.s.z

            /* JADX INFO: renamed from: a */
            public final ServiceConnectionC4812d0.a f12917a;

            {
                this.f12917a = aVar;
            }

            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
            public final void onComplete(Task task) {
                this.f12917a.m6723a();
            }
        });
    }
}
