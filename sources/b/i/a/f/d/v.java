package b.i.a.f.d;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v implements b.i.a.f.n.a {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f1343b;

    public v(b bVar, Bundle bundle) {
        this.a = bVar;
        this.f1343b = bundle;
    }

    @Override // b.i.a.f.n.a
    public final Object a(Task task) {
        b bVar = this.a;
        Bundle bundle = this.f1343b;
        Objects.requireNonNull(bVar);
        if (!task.p()) {
            return task;
        }
        Bundle bundle2 = (Bundle) task.l();
        return !(bundle2 != null && bundle2.containsKey("google.messenger")) ? task : bVar.b(bundle).r(z.j, w.a);
    }
}
