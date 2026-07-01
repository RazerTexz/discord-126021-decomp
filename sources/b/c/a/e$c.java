package b.c.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class e$c implements Callable<p<d>> {
    public final /* synthetic */ d j;

    public e$c(d dVar) {
        this.j = dVar;
    }

    @Override // java.util.concurrent.Callable
    public p<d> call() throws Exception {
        return new p<>(this.j);
    }
}
