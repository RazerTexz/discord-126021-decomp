package b.f.g.d.b;

import android.graphics.drawable.Animatable;
import b.f.g.c.BaseControllerListener;
import b.f.g.d.DebugControllerOverlayDrawable;

/* JADX INFO: renamed from: b.f.g.d.b.a, reason: use source file name */
/* JADX INFO: compiled from: ImageLoadingTimeControllerListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    public long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f505b = -1;
    public ImageLoadingTimeListener c;

    public ImageLoadingTimeControllerListener(ImageLoadingTimeListener imageLoadingTimeListener) {
        this.c = imageLoadingTimeListener;
    }

    @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f505b = jCurrentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.c;
        if (imageLoadingTimeListener != null) {
            DebugControllerOverlayDrawable debugControllerOverlayDrawable = (DebugControllerOverlayDrawable) imageLoadingTimeListener;
            debugControllerOverlayDrawable.B = jCurrentTimeMillis - this.a;
            debugControllerOverlayDrawable.invalidateSelf();
        }
    }

    @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.a = System.currentTimeMillis();
    }
}
