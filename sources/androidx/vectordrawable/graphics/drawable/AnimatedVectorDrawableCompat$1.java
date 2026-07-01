package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat$1 implements Drawable$Callback {
    public final /* synthetic */ AnimatedVectorDrawableCompat this$0;

    public AnimatedVectorDrawableCompat$1(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.this$0 = animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(Drawable drawable) {
        this.this$0.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.this$0.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.this$0.unscheduleSelf(runnable);
    }
}
