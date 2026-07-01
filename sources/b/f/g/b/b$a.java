package b.f.g.b;

import androidx.annotation.MainThread;
import java.util.ArrayList;

/* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b$a implements Runnable {
    public final /* synthetic */ b j;

    public b$a(b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    @MainThread
    public void run() {
        ArrayList<a$a> arrayList;
        synchronized (this.j.f493b) {
            b bVar = this.j;
            ArrayList<a$a> arrayList2 = bVar.e;
            arrayList = bVar.d;
            bVar.e = arrayList;
            bVar.d = arrayList2;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.j.e.get(i).release();
        }
        this.j.e.clear();
    }
}
