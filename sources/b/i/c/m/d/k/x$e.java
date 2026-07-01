package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$e implements b.i.a.f.n.f<Boolean, Void> {
    public final /* synthetic */ Task a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f1704b;
    public final /* synthetic */ x c;

    public x$e(x xVar, Task task, float f) {
        this.c = xVar;
        this.a = task;
        this.f1704b = f;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable Boolean bool) throws Exception {
        return this.c.m.c(new g0(this, bool));
    }
}
