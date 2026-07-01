package b.c.a;

import android.content.Context;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.c.a.h, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory4 implements Callable<LottieResult<LottieComposition>> {
    public final /* synthetic */ WeakReference j;
    public final /* synthetic */ Context k;
    public final /* synthetic */ int l;

    public LottieCompositionFactory4(WeakReference weakReference, Context context, int i) {
        this.j = weakReference;
        this.k = context;
        this.l = i;
    }

    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        Context context = (Context) this.j.get();
        if (context == null) {
            context = this.k;
        }
        int i = this.l;
        try {
            return LottieCompositionFactory.b(context.getResources().openRawResource(i), LottieCompositionFactory.f(context, i));
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }
}
