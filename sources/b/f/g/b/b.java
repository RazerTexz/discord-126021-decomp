package b.f.g.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import java.util.ArrayList;

/* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f493b = new Object();
    public final Runnable f = new b$a(this);
    public ArrayList<a$a> d = new ArrayList<>();
    public ArrayList<a$a> e = new ArrayList<>();
    public final Handler c = new Handler(Looper.getMainLooper());

    @Override // b.f.g.b.a
    @AnyThread
    public void a(a$a a_a) {
        synchronized (this.f493b) {
            this.d.remove(a_a);
        }
    }
}
