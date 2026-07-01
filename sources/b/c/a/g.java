package b.c.a;

import android.content.Context;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements Callable<p<d>> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public g(Context context, String str, String str2) {
        this.j = context;
        this.k = str;
        this.l = str2;
    }

    @Override // java.util.concurrent.Callable
    public p<d> call() throws Exception {
        Context context = this.j;
        String str = this.k;
        String str2 = this.l;
        try {
            return str.endsWith(".zip") ? e.d(new ZipInputStream(context.getAssets().open(str)), str2) : e.b(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new p<>((Throwable) e);
        }
    }
}
