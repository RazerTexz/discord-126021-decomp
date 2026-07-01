package b.c.a;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements Callable<p<d>> {
    public final /* synthetic */ InputStream j;
    public final /* synthetic */ String k;

    public i(InputStream inputStream, String str) {
        this.j = inputStream;
        this.k = str;
    }

    @Override // java.util.concurrent.Callable
    public p<d> call() throws Exception {
        return e.b(this.j, this.k);
    }
}
