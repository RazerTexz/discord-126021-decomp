package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.c.m.d.k.k, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsBackgroundWorker3<T> implements b.i.a.f.n.a<Void, T> {
    public final /* synthetic */ Callable a;

    public CrashlyticsBackgroundWorker3(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, Callable callable) {
        this.a = callable;
    }

    @Override // b.i.a.f.n.a
    public T a(@NonNull Task<Void> task) throws Exception {
        return (T) this.a.call();
    }
}
