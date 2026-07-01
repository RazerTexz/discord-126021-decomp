package b.f.g.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import b.f.g.b.DeferredReleaser;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.f.g.b.b, reason: use source file name */
/* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class DeferredReleaserConcurrentImpl extends DeferredReleaser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f493b = new Object();
    public final Runnable f = new a();
    public ArrayList<DeferredReleaser.a> d = new ArrayList<>();
    public ArrayList<DeferredReleaser.a> e = new ArrayList<>();
    public final Handler c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b.f.g.b.b$a */
    /* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            ArrayList<DeferredReleaser.a> arrayList;
            synchronized (DeferredReleaserConcurrentImpl.this.f493b) {
                DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = DeferredReleaserConcurrentImpl.this;
                ArrayList<DeferredReleaser.a> arrayList2 = deferredReleaserConcurrentImpl.e;
                arrayList = deferredReleaserConcurrentImpl.d;
                deferredReleaserConcurrentImpl.e = arrayList;
                deferredReleaserConcurrentImpl.d = arrayList2;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                DeferredReleaserConcurrentImpl.this.e.get(i).release();
            }
            DeferredReleaserConcurrentImpl.this.e.clear();
        }
    }

    @Override // b.f.g.b.DeferredReleaser
    @AnyThread
    public void a(DeferredReleaser.a aVar) {
        synchronized (this.f493b) {
            this.d.remove(aVar);
        }
    }
}
