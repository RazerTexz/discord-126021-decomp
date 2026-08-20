package p007b.p452o.p453a.p472w;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.C11196R;
import java.util.concurrent.ExecutionException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p473x.C5235a;

/* JADX INFO: renamed from: b.o.a.w.j */
/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5234j extends AbstractC5225a<TextureView, SurfaceTexture> {

    /* JADX INFO: renamed from: j */
    public View f14242j;

    /* JADX INFO: renamed from: b.o.a.w.j$a */
    /* JADX INFO: compiled from: TextureCameraPreview.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ AbstractC5225a.b f14243j;

        public a(AbstractC5225a.b bVar) {
            this.f14243j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            float fM7450i;
            C5234j c5234j = C5234j.this;
            if (c5234j.f14213h == 0 || c5234j.f14212g == 0 || (i = c5234j.f14211f) == 0 || (i2 = c5234j.f14210e) == 0) {
                AbstractC5225a.b bVar = this.f14243j;
                if (bVar != null) {
                    bVar.m7442a();
                    return;
                }
                return;
            }
            C5235a c5235aM7447f = C5235a.m7447f(i2, i);
            C5234j c5234j2 = C5234j.this;
            C5235a c5235aM7447f2 = C5235a.m7447f(c5234j2.f14212g, c5234j2.f14213h);
            float fM7450i2 = 1.0f;
            if (c5235aM7447f.m7450i() >= c5235aM7447f2.m7450i()) {
                fM7450i = c5235aM7447f.m7450i() / c5235aM7447f2.m7450i();
            } else {
                fM7450i2 = c5235aM7447f2.m7450i() / c5235aM7447f.m7450i();
                fM7450i = 1.0f;
            }
            ((TextureView) C5234j.this.f14208c).setScaleX(fM7450i2);
            ((TextureView) C5234j.this.f14208c).setScaleY(fM7450i);
            C5234j.this.f14209d = fM7450i2 > 1.02f || fM7450i > 1.02f;
            C5103b c5103b = AbstractC5225a.f14206a;
            c5103b.m7159a(1, "crop:", "applied scaleX=", Float.valueOf(fM7450i2));
            c5103b.m7159a(1, "crop:", "applied scaleY=", Float.valueOf(fM7450i));
            AbstractC5225a.b bVar2 = this.f14243j;
            if (bVar2 != null) {
                bVar2.m7442a();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.j$b */
    /* JADX INFO: compiled from: TextureCameraPreview.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f14245j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ TaskCompletionSource f14246k;

        public b(int i, TaskCompletionSource taskCompletionSource) {
            this.f14245j = i;
            this.f14246k = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = new Matrix();
            C5234j c5234j = C5234j.this;
            int i = c5234j.f14210e;
            float f = i / 2.0f;
            int i2 = c5234j.f14211f;
            float f2 = i2 / 2.0f;
            if (this.f14245j % 180 != 0) {
                float f3 = i2 / i;
                matrix.postScale(f3, 1.0f / f3, f, f2);
            }
            matrix.postRotate(this.f14245j, f, f2);
            ((TextureView) C5234j.this.f14208c).setTransform(matrix);
            this.f14246k.f20845a.m6024s(null);
        }
    }

    public C5234j(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: e */
    public void mo7425e(@Nullable AbstractC5225a.b bVar) {
        ((TextureView) this.f14208c).post(new a(null));
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: i */
    public SurfaceTexture mo7429i() {
        return ((TextureView) this.f14208c).getSurfaceTexture();
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: j */
    public Class<SurfaceTexture> mo7430j() {
        return SurfaceTexture.class;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: k */
    public View mo7431k() {
        return this.f14242j;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: n */
    public View mo7434n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(C11196R.b.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        TextureView textureView = (TextureView) viewInflate.findViewById(C11196R.a.texture_view);
        textureView.setSurfaceTextureListener(new TextureViewSurfaceTextureListenerC5233i(this));
        this.f14242j = viewInflate;
        return textureView;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: r */
    public void mo7438r(int i) {
        this.f14214i = i;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) this.f14208c).post(new b(i, taskCompletionSource));
        try {
            C3404f.m4303j(taskCompletionSource.f20845a);
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: u */
    public boolean mo7441u() {
        return true;
    }
}
