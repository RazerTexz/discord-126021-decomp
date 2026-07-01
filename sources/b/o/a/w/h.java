package b.o.a.w;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.R$a;
import com.otaliastudios.cameraview.R$b;

/* JADX INFO: compiled from: SurfaceCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends a<SurfaceView, SurfaceHolder> {
    public static final b.o.a.b j = new b.o.a.b(h.class.getSimpleName());
    public boolean k;
    public View l;

    public h(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // b.o.a.w.a
    @NonNull
    public SurfaceHolder i() {
        return ((SurfaceView) this.c).getHolder();
    }

    @Override // b.o.a.w.a
    @NonNull
    public Class<SurfaceHolder> j() {
        return SurfaceHolder.class;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View k() {
        return this.l;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R$b.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        SurfaceView surfaceView = (SurfaceView) viewInflate.findViewById(R$a.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new g(this));
        this.l = viewInflate;
        return surfaceView;
    }
}
