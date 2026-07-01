package b.o.a.w;

import android.graphics.Matrix;
import android.view.TextureView;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$b implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ TaskCompletionSource k;
    public final /* synthetic */ j l;

    public j$b(j jVar, int i, TaskCompletionSource taskCompletionSource) {
        this.l = jVar;
        this.j = i;
        this.k = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = new Matrix();
        j jVar = this.l;
        int i = jVar.e;
        float f = i / 2.0f;
        int i2 = jVar.f;
        float f2 = i2 / 2.0f;
        if (this.j % 180 != 0) {
            float f3 = i2 / i;
            matrix.postScale(f3, 1.0f / f3, f, f2);
        }
        matrix.postRotate(this.j, f, f2);
        ((TextureView) this.l.c).setTransform(matrix);
        this.k.a.s(null);
    }
}
