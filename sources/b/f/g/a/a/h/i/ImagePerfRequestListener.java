package b.f.g.a.a.h.i;

import b.f.d.k.MonotonicClock;
import b.f.g.a.a.h.ImagePerfState;
import b.f.j.k.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.g.a.a.h.i.c, reason: use source file name */
/* JADX INFO: compiled from: ImagePerfRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePerfRequestListener extends BaseRequestListener {
    public final MonotonicClock a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImagePerfState f492b;

    public ImagePerfRequestListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState) {
        this.a = monotonicClock;
        this.f492b = imagePerfState;
    }

    @Override // b.f.j.k.BaseRequestListener, b.f.j.k.RequestListener
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        this.f492b.n = this.a.now();
        ImagePerfState imagePerfState = this.f492b;
        imagePerfState.c = imageRequest;
        imagePerfState.d = obj;
        imagePerfState.f486b = str;
        imagePerfState.r = z2;
    }

    @Override // b.f.j.k.BaseRequestListener, b.f.j.k.RequestListener
    public void c(ImageRequest imageRequest, String str, boolean z2) {
        this.f492b.o = this.a.now();
        ImagePerfState imagePerfState = this.f492b;
        imagePerfState.c = imageRequest;
        imagePerfState.f486b = str;
        imagePerfState.r = z2;
    }

    @Override // b.f.j.k.BaseRequestListener, b.f.j.k.RequestListener
    public void g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        this.f492b.o = this.a.now();
        ImagePerfState imagePerfState = this.f492b;
        imagePerfState.c = imageRequest;
        imagePerfState.f486b = str;
        imagePerfState.r = z2;
    }

    @Override // b.f.j.k.BaseRequestListener, b.f.j.k.RequestListener
    public void k(String str) {
        this.f492b.o = this.a.now();
        this.f492b.f486b = str;
    }
}
