package b.f.j.p;

import android.content.ContentResolver;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
public class j0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f618b;

    public j0(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f618b = contentResolver;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", "thumbnail_bitmap");
        j0$a j0_a = new j0$a(this, lVar, z0VarO, x0Var, "LocalThumbnailBitmapProducer", z0VarO, x0Var, imageRequestE, new CancellationSignal());
        x0Var.f(new j0$b(this, j0_a));
        this.a.execute(j0_a);
    }
}
