package p007b.p085c.p086a;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.c.a.i */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class CallableC1510i implements Callable<C1517p<C1505d>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InputStream f2364j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f2365k;

    public CallableC1510i(InputStream inputStream, String str) {
        this.f2364j = inputStream;
        this.f2365k = str;
    }

    @Override // java.util.concurrent.Callable
    public C1517p<C1505d> call() throws Exception {
        return C1506e.m675b(this.f2364j, this.f2365k);
    }
}
