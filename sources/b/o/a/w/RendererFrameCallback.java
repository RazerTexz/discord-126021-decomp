package b.o.a.w;

import android.graphics.SurfaceTexture;
import androidx.annotation.NonNull;
import b.o.a.o.Filter2;

/* JADX INFO: renamed from: b.o.a.w.f, reason: use source file name */
/* JADX INFO: compiled from: RendererFrameCallback.java */
/* JADX INFO: loaded from: classes3.dex */
public interface RendererFrameCallback {
    void a(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2);

    void b(int i);

    void c(@NonNull Filter2 filter2);
}
