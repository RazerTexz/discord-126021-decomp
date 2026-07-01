package b.c.a;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements Callable<p<d>> {
    public final /* synthetic */ WeakReference j;
    public final /* synthetic */ Context k;
    public final /* synthetic */ int l;

    public h(WeakReference weakReference, Context context, int i) {
        this.j = weakReference;
        this.k = context;
        this.l = i;
    }

    @Override // java.util.concurrent.Callable
    public p<d> call() throws Exception {
        Context context = (Context) this.j.get();
        if (context == null) {
            context = this.k;
        }
        int i = this.l;
        try {
            return e.b(context.getResources().openRawResource(i), e.f(context, i));
        } catch (Resources$NotFoundException e) {
            return new p<>((Throwable) e);
        }
    }
}
