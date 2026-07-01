package b.i.a.b.j.t.h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {
    public final l j;
    public final b.i.a.b.j.i k;
    public final int l;
    public final Runnable m;

    public g(l lVar, b.i.a.b.j.i iVar, int i, Runnable runnable) {
        this.j = lVar;
        this.k = iVar;
        this.l = i;
        this.m = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.j;
        b.i.a.b.j.i iVar = this.k;
        int i = this.l;
        Runnable runnable = this.m;
        try {
            try {
                b.i.a.b.j.u.a aVar = lVar.f;
                b.i.a.b.j.t.i.c cVar = lVar.c;
                cVar.getClass();
                aVar.a(new j(cVar));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) lVar.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    lVar.a(iVar, i);
                } else {
                    lVar.f.a(new k(lVar, iVar, i));
                }
            } catch (SynchronizationException unused) {
                lVar.d.a(iVar, i + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
