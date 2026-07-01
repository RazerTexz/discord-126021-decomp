package b.c.a;

import android.content.Context;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: b.c.a.g, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory3 implements Callable<LottieResult<LottieComposition>> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public LottieCompositionFactory3(Context context, String str, String str2) {
        this.j = context;
        this.k = str;
        this.l = str2;
    }

    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        Context context = this.j;
        String str = this.k;
        String str2 = this.l;
        try {
            return str.endsWith(".zip") ? LottieCompositionFactory.d(new ZipInputStream(context.getAssets().open(str)), str2) : LottieCompositionFactory.b(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }
}
