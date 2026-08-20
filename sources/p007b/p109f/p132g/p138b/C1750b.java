package p007b.p109f.p132g.p138b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.f.g.b.b */
/* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C1750b extends AbstractC1749a {

    /* JADX INFO: renamed from: b */
    public final Object f3254b = new Object();

    /* JADX INFO: renamed from: f */
    public final Runnable f3258f = new a();

    /* JADX INFO: renamed from: d */
    public ArrayList<AbstractC1749a.a> f3256d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    public ArrayList<AbstractC1749a.a> f3257e = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    public final Handler f3255c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b.f.g.b.b$a */
    /* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            ArrayList<AbstractC1749a.a> arrayList;
            synchronized (C1750b.this.f3254b) {
                C1750b c1750b = C1750b.this;
                ArrayList<AbstractC1749a.a> arrayList2 = c1750b.f3257e;
                arrayList = c1750b.f3256d;
                c1750b.f3257e = arrayList;
                c1750b.f3256d = arrayList2;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                C1750b.this.f3257e.get(i).release();
            }
            C1750b.this.f3257e.clear();
        }
    }

    @Override // p007b.p109f.p132g.p138b.AbstractC1749a
    @AnyThread
    /* JADX INFO: renamed from: a */
    public void mo1083a(AbstractC1749a.a aVar) {
        synchronized (this.f3254b) {
            this.f3256d.remove(aVar);
        }
    }
}
