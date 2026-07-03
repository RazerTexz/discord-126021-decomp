package p007b.p452o.p453a.p472w;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.C11196R;
import p007b.p452o.p453a.C5103b;

/* JADX INFO: renamed from: b.o.a.w.h */
/* JADX INFO: compiled from: SurfaceCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5232h extends AbstractC5225a<SurfaceView, SurfaceHolder> {

    /* JADX INFO: renamed from: j */
    public static final C5103b f14238j = new C5103b(C5232h.class.getSimpleName());

    /* JADX INFO: renamed from: k */
    public boolean f14239k;

    /* JADX INFO: renamed from: l */
    public View f14240l;

    public C5232h(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: i */
    public SurfaceHolder mo7429i() {
        return ((SurfaceView) this.f14208c).getHolder();
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: j */
    public Class<SurfaceHolder> mo7430j() {
        return SurfaceHolder.class;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: k */
    public View mo7431k() {
        return this.f14240l;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: n */
    public View mo7434n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(C11196R.b.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        SurfaceView surfaceView = (SurfaceView) viewInflate.findViewById(C11196R.a.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new SurfaceHolderCallbackC5231g(this));
        this.f14240l = viewInflate;
        return surfaceView;
    }
}
