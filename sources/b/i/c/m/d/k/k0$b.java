package b.i.c.m.d.k;

import android.util.Log;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class k0$b implements Callable<Boolean> {
    public final /* synthetic */ k0 j;

    public k0$b(k0 k0Var) {
        this.j = k0Var;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        try {
            boolean zDelete = this.j.e.b().delete();
            b.i.c.m.d.b.a.b("Initialization marker file removed: " + zDelete);
            return Boolean.valueOf(zDelete);
        } catch (Exception e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
            }
            return Boolean.FALSE;
        }
    }
}
