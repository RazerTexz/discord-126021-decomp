package b.i.c;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$d implements Executor {
    public static final Handler j = new Handler(Looper.getMainLooper());

    public c$d(c$a c_a) {
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        j.post(runnable);
    }
}
