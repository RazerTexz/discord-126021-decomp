package b.o.a.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$d implements b.i.a.f.n.c<Void> {
    public final /* synthetic */ CountDownLatch a;

    public i$d(i iVar, CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    @Override // b.i.a.f.n.c
    public void onComplete(@NonNull Task<Void> task) {
        this.a.countDown();
    }
}
