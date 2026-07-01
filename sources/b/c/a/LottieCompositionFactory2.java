package b.c.a;

import android.content.Context;
import androidx.core.util.Pair;
import b.c.a.b0.Logger2;
import b.c.a.z.FileExtension;
import b.c.a.z.NetworkCache;
import b.c.a.z.NetworkFetcher;
import b.d.b.a.outline;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: b.c.a.f, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory2 implements Callable<LottieResult<LottieComposition>> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public LottieCompositionFactory2(Context context, String str, String str2) {
        this.j = context;
        this.k = str;
        this.l = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public LottieResult<LottieComposition> call() throws Exception {
        Pair pair;
        NetworkFetcher networkFetcher = new NetworkFetcher(this.j, this.k, this.l);
        FileExtension fileExtension = FileExtension.ZIP;
        NetworkCache networkCache = networkFetcher.c;
        LottieComposition lottieComposition = null;
        if (networkCache != null) {
            String str = networkFetcher.f447b;
            try {
                File fileB = networkCache.b();
                FileExtension fileExtension2 = FileExtension.JSON;
                File file = new File(fileB, NetworkCache.a(str, fileExtension2, false));
                if (!file.exists()) {
                    file = new File(networkCache.b(), NetworkCache.a(str, fileExtension, false));
                    if (!file.exists()) {
                        file = null;
                    }
                }
                if (file == null) {
                    pair = null;
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (file.getAbsolutePath().endsWith(".zip")) {
                        fileExtension2 = fileExtension;
                    }
                    StringBuilder sbY = outline.Y("Cache hit for ", str, " at ");
                    sbY.append(file.getAbsolutePath());
                    Logger2.a(sbY.toString());
                    pair = new Pair(fileExtension2, fileInputStream);
                }
            } catch (FileNotFoundException unused) {
            }
            if (pair != null) {
                FileExtension fileExtension3 = (FileExtension) pair.first;
                InputStream inputStream = (InputStream) pair.second;
                LottieComposition lottieComposition2 = (fileExtension3 == fileExtension ? LottieCompositionFactory.d(new ZipInputStream(inputStream), networkFetcher.f447b) : LottieCompositionFactory.b(inputStream, networkFetcher.f447b)).a;
                if (lottieComposition2 != null) {
                    lottieComposition = lottieComposition2;
                }
            }
        }
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        StringBuilder sbU = outline.U("Animation for ");
        sbU.append(networkFetcher.f447b);
        sbU.append(" not found in cache. Fetching from network.");
        Logger2.a(sbU.toString());
        try {
            return networkFetcher.a();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }
}
