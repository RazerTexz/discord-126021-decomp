package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class DrawableContainer$BlockInvalidateCallback implements Drawable$Callback {
    private Drawable$Callback mCallback;

    @Override // android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable$Callback drawable$Callback = this.mCallback;
        if (drawable$Callback != null) {
            drawable$Callback.scheduleDrawable(drawable, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable$Callback drawable$Callback = this.mCallback;
        if (drawable$Callback != null) {
            drawable$Callback.unscheduleDrawable(drawable, runnable);
        }
    }

    public Drawable$Callback unwrap() {
        Drawable$Callback drawable$Callback = this.mCallback;
        this.mCallback = null;
        return drawable$Callback;
    }

    public DrawableContainer$BlockInvalidateCallback wrap(Drawable$Callback drawable$Callback) {
        this.mCallback = drawable$Callback;
        return this;
    }
}
