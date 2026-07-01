package b.f.h.a.b.e;

import android.graphics.Bitmap$Config;
import android.util.SparseArray;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: DefaultBitmapFramePreparer.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b {
    public final PlatformBitmapFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.h.a.b.c f530b;
    public final Bitmap$Config c;
    public final ExecutorService d;
    public final SparseArray<Runnable> e = new SparseArray<>();

    public c(PlatformBitmapFactory platformBitmapFactory, b.f.h.a.b.c cVar, Bitmap$Config bitmap$Config, ExecutorService executorService) {
        this.a = platformBitmapFactory;
        this.f530b = cVar;
        this.c = bitmap$Config;
        this.d = executorService;
    }
}
