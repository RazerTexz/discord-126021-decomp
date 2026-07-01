package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources$Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState extends Drawable$ConstantState {
    private final Drawable$ConstantState mDelegateState;

    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(Drawable$ConstantState drawable$ConstantState) {
        this.mDelegateState = drawable$ConstantState;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public boolean canApplyTheme() {
        return this.mDelegateState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return this.mDelegateState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        Drawable drawableNewDrawable = this.mDelegateState.newDrawable();
        animatedVectorDrawableCompat.mDelegateDrawable = drawableNewDrawable;
        drawableNewDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable(Resources resources) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        Drawable drawableNewDrawable = this.mDelegateState.newDrawable(resources);
        animatedVectorDrawableCompat.mDelegateDrawable = drawableNewDrawable;
        drawableNewDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable(Resources resources, Resources$Theme resources$Theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        Drawable drawableNewDrawable = this.mDelegateState.newDrawable(resources, resources$Theme);
        animatedVectorDrawableCompat.mDelegateDrawable = drawableNewDrawable;
        drawableNewDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }
}
