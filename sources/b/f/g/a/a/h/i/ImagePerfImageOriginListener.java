package b.f.g.a.a.h.i;

import b.f.g.a.a.h.ImageOriginListener;
import b.f.g.a.a.h.ImagePerfMonitor;
import b.f.g.a.a.h.ImagePerfState;

/* JADX INFO: renamed from: b.f.g.a.a.h.i.b, reason: use source file name */
/* JADX INFO: compiled from: ImagePerfImageOriginListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePerfImageOriginListener implements ImageOriginListener {
    public final ImagePerfState a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImagePerfMonitor f491b;

    public ImagePerfImageOriginListener(ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.a = imagePerfState;
        this.f491b = imagePerfMonitor;
    }

    @Override // b.f.g.a.a.h.ImageOriginListener
    public void a(String str, int i, boolean z2, String str2) {
        ImagePerfState imagePerfState = this.a;
        imagePerfState.p = i;
        imagePerfState.q = str2;
        this.f491b.b(imagePerfState, 1);
    }
}
