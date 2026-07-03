package p007b.p085c.p086a;

import android.content.Context;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.c.a.h */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class CallableC1509h implements Callable<C1517p<C1505d>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ WeakReference f2361j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Context f2362k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ int f2363l;

    public CallableC1509h(WeakReference weakReference, Context context, int i) {
        this.f2361j = weakReference;
        this.f2362k = context;
        this.f2363l = i;
    }

    @Override // java.util.concurrent.Callable
    public C1517p<C1505d> call() throws Exception {
        Context context = (Context) this.f2361j.get();
        if (context == null) {
            context = this.f2362k;
        }
        int i = this.f2363l;
        try {
            return C1506e.m675b(context.getResources().openRawResource(i), C1506e.m679f(context, i));
        } catch (Resources.NotFoundException e) {
            return new C1517p<>((Throwable) e);
        }
    }
}
