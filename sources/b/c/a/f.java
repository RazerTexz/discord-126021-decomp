package b.c.a;

import android.content.Context;
import androidx.core.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Callable<p<d>> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public f(Context context, String str, String str2) {
        this.j = context;
        this.k = str;
        this.l = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public p<d> call() throws Exception {
        Pair pair;
        b.c.a.z.c cVar = new b.c.a.z.c(this.j, this.k, this.l);
        b.c.a.z.a aVar = b.c.a.z.a.ZIP;
        b.c.a.z.b bVar = cVar.c;
        d dVar = null;
        if (bVar != null) {
            String str = cVar.f447b;
            try {
                File fileB = bVar.b();
                b.c.a.z.a aVar2 = b.c.a.z.a.JSON;
                File file = new File(fileB, b.c.a.z.b.a(str, aVar2, false));
                if (!file.exists()) {
                    file = new File(bVar.b(), b.c.a.z.b.a(str, aVar, false));
                    if (!file.exists()) {
                        file = null;
                    }
                }
                if (file == null) {
                    pair = null;
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (file.getAbsolutePath().endsWith(".zip")) {
                        aVar2 = aVar;
                    }
                    StringBuilder sbY = b.d.b.a.a.Y("Cache hit for ", str, " at ");
                    sbY.append(file.getAbsolutePath());
                    b.c.a.b0.c.a(sbY.toString());
                    pair = new Pair(aVar2, fileInputStream);
                }
            } catch (FileNotFoundException unused) {
            }
            if (pair != null) {
                b.c.a.z.a aVar3 = (b.c.a.z.a) pair.first;
                InputStream inputStream = (InputStream) pair.second;
                d dVar2 = (aVar3 == aVar ? e.d(new ZipInputStream(inputStream), cVar.f447b) : e.b(inputStream, cVar.f447b)).a;
                if (dVar2 != null) {
                    dVar = dVar2;
                }
            }
        }
        if (dVar != null) {
            return new p<>(dVar);
        }
        StringBuilder sbU = b.d.b.a.a.U("Animation for ");
        sbU.append(cVar.f447b);
        sbU.append(" not found in cache. Fetching from network.");
        b.c.a.b0.c.a(sbU.toString());
        try {
            return cVar.a();
        } catch (IOException e) {
            return new p<>((Throwable) e);
        }
    }
}
