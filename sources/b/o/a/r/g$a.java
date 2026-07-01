package b.o.a.r;

import android.os.HandlerThread;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: WorkerHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a extends HandlerThread {
    public g$a(g gVar, String str) {
        super(str);
    }

    @Override // java.lang.Thread
    @NonNull
    public String toString() {
        return super.toString() + "[" + getThreadId() + "]";
    }
}
