package b.o.a.w;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.R$a;
import com.otaliastudios.cameraview.R$b;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends a<TextureView, SurfaceTexture> {
    public View j;

    public j(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // b.o.a.w.a
    public void e(@Nullable a$b a_b) {
        ((TextureView) this.c).post(new j$a(this, null));
    }

    @Override // b.o.a.w.a
    @NonNull
    public SurfaceTexture i() {
        return ((TextureView) this.c).getSurfaceTexture();
    }

    @Override // b.o.a.w.a
    @NonNull
    public Class<SurfaceTexture> j() {
        return SurfaceTexture.class;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View k() {
        return this.j;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R$b.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        TextureView textureView = (TextureView) viewInflate.findViewById(R$a.texture_view);
        textureView.setSurfaceTextureListener(new i(this));
        this.j = viewInflate;
        return textureView;
    }

    @Override // b.o.a.w.a
    public void r(int i) {
        this.i = i;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) this.c).post(new j$b(this, i, taskCompletionSource));
        try {
            b.i.a.f.e.o.f.j(taskCompletionSource.a);
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // b.o.a.w.a
    public boolean u() {
        return true;
    }
}
