package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.b;
import b.o.a.n.i$g;
import b.o.a.q.a;
import b.o.a.q.c$a;
import b.o.a.r.f$c;

/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class CameraView$b implements i$g, f$c, c$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3177b;
    public final /* synthetic */ CameraView c;

    public CameraView$b(CameraView cameraView) {
        this.c = cameraView;
        String simpleName = CameraView$b.class.getSimpleName();
        this.a = simpleName;
        this.f3177b = new b(simpleName);
    }

    public void a(CameraException cameraException) {
        this.f3177b.a(1, "dispatchError", cameraException);
        this.c.u.post(new CameraView$b$d(this, cameraException));
    }

    public void b(@NonNull b.o.a.p.b bVar) {
        this.f3177b.a(0, "dispatchFrame:", Long.valueOf(bVar.a()), "processors:", Integer.valueOf(this.c.E.size()));
        if (this.c.E.isEmpty()) {
            bVar.b();
        } else {
            this.c.v.execute(new CameraView$b$c(this, bVar));
        }
    }

    public void c(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
        this.f3177b.a(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f));
        this.c.u.post(new CameraView$b$b(this, f, fArr, pointFArr));
    }

    public void d(@Nullable a aVar, boolean z2, @NonNull PointF pointF) {
        this.f3177b.a(1, "dispatchOnFocusEnd", aVar, Boolean.valueOf(z2), pointF);
        this.c.u.post(new CameraView$b$g(this, z2, aVar, pointF));
    }

    public void e(@Nullable a aVar, @NonNull PointF pointF) {
        this.f3177b.a(1, "dispatchOnFocusStart", aVar, pointF);
        this.c.u.post(new CameraView$b$f(this, pointF, aVar));
    }

    public void f(float f, @Nullable PointF[] pointFArr) {
        this.f3177b.a(1, "dispatchOnZoomChanged", Float.valueOf(f));
        this.c.u.post(new CameraView$b$a(this, f, pointFArr));
    }

    @NonNull
    public Context g() {
        return this.c.getContext();
    }

    public void h() {
        b.o.a.x.b bVarC = this.c.f3176z.C(b.o.a.n.t.b.VIEW);
        if (bVarC == null) {
            throw new RuntimeException("Preview stream size should not be null here.");
        }
        if (bVarC.equals(this.c.A)) {
            this.f3177b.a(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", bVarC);
        } else {
            this.f3177b.a(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", bVarC);
            this.c.u.post(new CameraView$b$e(this));
        }
    }
}
