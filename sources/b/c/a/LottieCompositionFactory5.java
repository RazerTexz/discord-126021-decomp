package b.c.a;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.c.a.i, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory5 implements Callable<LottieResult<LottieComposition>> {
    public final /* synthetic */ InputStream j;
    public final /* synthetic */ String k;

    public LottieCompositionFactory5(InputStream inputStream, String str) {
        this.j = inputStream;
        this.k = str;
    }

    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        return LottieCompositionFactory.b(this.j, this.k);
    }
}
