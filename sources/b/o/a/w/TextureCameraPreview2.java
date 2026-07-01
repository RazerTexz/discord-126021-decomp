package b.o.a.w;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.CameraLogger;
import b.o.a.w.CameraPreview;
import b.o.a.x.AspectRatio2;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.R;
import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: b.o.a.w.j, reason: use source file name */
/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class TextureCameraPreview2 extends CameraPreview<TextureView, SurfaceTexture> {
    public View j;

    /* JADX INFO: renamed from: b.o.a.w.j$a */
    /* JADX INFO: compiled from: TextureCameraPreview.java */
    public class a implements Runnable {
        public final /* synthetic */ CameraPreview.b j;

        public a(CameraPreview.b bVar) {
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            float fI;
            TextureCameraPreview2 textureCameraPreview2 = TextureCameraPreview2.this;
            if (textureCameraPreview2.h == 0 || textureCameraPreview2.g == 0 || (i = textureCameraPreview2.f) == 0 || (i2 = textureCameraPreview2.e) == 0) {
                CameraPreview.b bVar = this.j;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            AspectRatio2 aspectRatio2F = AspectRatio2.f(i2, i);
            TextureCameraPreview2 textureCameraPreview3 = TextureCameraPreview2.this;
            AspectRatio2 aspectRatio2F2 = AspectRatio2.f(textureCameraPreview3.g, textureCameraPreview3.h);
            float fI2 = 1.0f;
            if (aspectRatio2F.i() >= aspectRatio2F2.i()) {
                fI = aspectRatio2F.i() / aspectRatio2F2.i();
            } else {
                fI2 = aspectRatio2F2.i() / aspectRatio2F.i();
                fI = 1.0f;
            }
            ((TextureView) TextureCameraPreview2.this.c).setScaleX(fI2);
            ((TextureView) TextureCameraPreview2.this.c).setScaleY(fI);
            TextureCameraPreview2.this.d = fI2 > 1.02f || fI > 1.02f;
            CameraLogger cameraLogger = CameraPreview.a;
            cameraLogger.a(1, "crop:", "applied scaleX=", Float.valueOf(fI2));
            cameraLogger.a(1, "crop:", "applied scaleY=", Float.valueOf(fI));
            CameraPreview.b bVar2 = this.j;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.j$b */
    /* JADX INFO: compiled from: TextureCameraPreview.java */
    public class b implements Runnable {
        public final /* synthetic */ int j;
        public final /* synthetic */ TaskCompletionSource k;

        public b(int i, TaskCompletionSource taskCompletionSource) {
            this.j = i;
            this.k = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = new Matrix();
            TextureCameraPreview2 textureCameraPreview2 = TextureCameraPreview2.this;
            int i = textureCameraPreview2.e;
            float f = i / 2.0f;
            int i2 = textureCameraPreview2.f;
            float f2 = i2 / 2.0f;
            if (this.j % 180 != 0) {
                float f3 = i2 / i;
                matrix.postScale(f3, 1.0f / f3, f, f2);
            }
            matrix.postRotate(this.j, f, f2);
            ((TextureView) TextureCameraPreview2.this.c).setTransform(matrix);
            this.k.a.s(null);
        }
    }

    public TextureCameraPreview2(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // b.o.a.w.CameraPreview
    public void e(@Nullable CameraPreview.b bVar) {
        ((TextureView) this.c).post(new a(null));
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public SurfaceTexture i() {
        return ((TextureView) this.c).getSurfaceTexture();
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public Class<SurfaceTexture> j() {
        return SurfaceTexture.class;
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public View k() {
        return this.j;
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.b.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        TextureView textureView = (TextureView) viewInflate.findViewById(R.a.texture_view);
        textureView.setSurfaceTextureListener(new TextureCameraPreview(this));
        this.j = viewInflate;
        return textureView;
    }

    @Override // b.o.a.w.CameraPreview
    public void r(int i) {
        this.i = i;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) this.c).post(new b(i, taskCompletionSource));
        try {
            b.i.a.f.e.o.f.j(taskCompletionSource.a);
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // b.o.a.w.CameraPreview
    public boolean u() {
        return true;
    }
}
