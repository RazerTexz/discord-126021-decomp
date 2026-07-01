package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class k<T> implements b.i.a.f.n.a<Void, T> {
    public final /* synthetic */ Callable a;

    public k(i iVar, Callable callable) {
        this.a = callable;
    }

    @Override // b.i.a.f.n.a
    public T a(@NonNull Task<Void> task) throws Exception {
        return (T) this.a.call();
    }
}
