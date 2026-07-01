package b.o.a.v;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.PictureResult;
import b.o.a.o.Filter2;
import b.o.a.r.GlTextureDrawer;
import b.o.a.r.WorkerHandler;
import b.o.a.u.Overlay;
import b.o.a.u.OverlayDrawer;
import b.o.a.u.OverlayLayout;
import b.o.a.v.PictureRecorder;
import b.o.a.w.RendererCameraPreview;
import b.o.a.w.RendererFrameCallback;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import b.o.b.f.GlTexture2;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.v.g, reason: use source file name */
/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SnapshotGlPictureRecorder extends SnapshotPictureRecorder {
    public RendererCameraPreview n;
    public AspectRatio2 o;
    public Overlay p;
    public boolean q;
    public OverlayDrawer r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public GlTextureDrawer f1956s;

    /* JADX INFO: renamed from: b.o.a.v.g$a */
    /* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
    public class a implements RendererFrameCallback {
        public a() {
        }

        @Override // b.o.a.w.RendererFrameCallback
        public void a(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2) {
            SnapshotGlPictureRecorder.this.n.d(this);
            SnapshotGlPictureRecorder snapshotGlPictureRecorder = SnapshotGlPictureRecorder.this;
            Objects.requireNonNull(snapshotGlPictureRecorder);
            WorkerHandler.a(new SnapshotGlPictureRecorder2(snapshotGlPictureRecorder, surfaceTexture, i, f, f2, EGL14.eglGetCurrentContext()));
        }

        @Override // b.o.a.w.RendererFrameCallback
        public void b(int i) {
            SnapshotGlPictureRecorder snapshotGlPictureRecorder = SnapshotGlPictureRecorder.this;
            Objects.requireNonNull(snapshotGlPictureRecorder);
            snapshotGlPictureRecorder.f1956s = new GlTextureDrawer(new GlTexture2(33984, 36197, Integer.valueOf(i)));
            Rect rectL = b.i.a.f.e.o.f.L(snapshotGlPictureRecorder.j.d, snapshotGlPictureRecorder.o);
            snapshotGlPictureRecorder.j.d = new Size3(rectL.width(), rectL.height());
            if (snapshotGlPictureRecorder.q) {
                snapshotGlPictureRecorder.r = new OverlayDrawer(snapshotGlPictureRecorder.p, snapshotGlPictureRecorder.j.d);
            }
        }

        @Override // b.o.a.w.RendererFrameCallback
        public void c(@NonNull Filter2 filter2) {
            SnapshotGlPictureRecorder.this.f1956s.d = filter2.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public SnapshotGlPictureRecorder(@NonNull PictureResult.a aVar, @Nullable PictureRecorder.a aVar2, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull AspectRatio2 aspectRatio2, @Nullable Overlay overlay) {
        boolean z2;
        super(aVar, aVar2);
        this.n = rendererCameraPreview;
        this.o = aspectRatio2;
        this.p = overlay;
        if (overlay != null) {
            if (((OverlayLayout) overlay).b(Overlay.a.PICTURE_SNAPSHOT)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.q = z2;
    }

    @Override // b.o.a.v.PictureRecorder
    public void b() {
        this.o = null;
        super.b();
    }

    @Override // b.o.a.v.PictureRecorder
    @TargetApi(19)
    public void c() {
        this.n.b(new a());
    }
}
