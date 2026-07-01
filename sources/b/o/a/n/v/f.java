package b.o.a.n.v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends a {
    public e f;
    public e g;
    public int h;

    public f(@NonNull a$b a_b) {
        super(a_b);
        e eVar = e.OFF;
        this.f = eVar;
        this.g = eVar;
        this.h = 0;
    }

    @NonNull
    public <T> Task<T> f(@NonNull e eVar, @NonNull e eVar2, boolean z2, @NonNull Callable<Task<T>> callable) {
        String str;
        int i = this.h + 1;
        this.h = i;
        this.g = eVar2;
        boolean z3 = !eVar2.f(eVar);
        if (z3) {
            str = eVar.name() + " << " + eVar2.name();
        } else {
            str = eVar.name() + " >> " + eVar2.name();
        }
        Task<T> taskD = d(str, z2, 0L, new f$b(this, eVar, str, eVar2, callable, z3));
        taskD.b(new f$a(this, i));
        return taskD;
    }
}
