package p007b.p085c.p086a;

import android.content.Context;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: b.c.a.g */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class CallableC1508g implements Callable<C1517p<C1505d>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Context f2358j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f2359k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f2360l;

    public CallableC1508g(Context context, String str, String str2) {
        this.f2358j = context;
        this.f2359k = str;
        this.f2360l = str2;
    }

    @Override // java.util.concurrent.Callable
    public C1517p<C1505d> call() throws Exception {
        Context context = this.f2358j;
        String str = this.f2359k;
        String str2 = this.f2360l;
        try {
            return str.endsWith(".zip") ? C1506e.m677d(new ZipInputStream(context.getAssets().open(str)), str2) : C1506e.m675b(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new C1517p<>((Throwable) e);
        }
    }
}
