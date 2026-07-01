package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class VectorDrawableCompat$VectorDrawableCompatState extends Drawable$ConstantState {
    public boolean mAutoMirrored;
    public boolean mCacheDirty;
    public boolean mCachedAutoMirrored;
    public Bitmap mCachedBitmap;
    public int mCachedRootAlpha;
    public int[] mCachedThemeAttrs;
    public ColorStateList mCachedTint;
    public PorterDuff$Mode mCachedTintMode;
    public int mChangingConfigurations;
    public Paint mTempPaint;
    public ColorStateList mTint;
    public PorterDuff$Mode mTintMode;
    public VectorDrawableCompat$VPathRenderer mVPathRenderer;

    public VectorDrawableCompat$VectorDrawableCompatState(VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState) {
        this.mTint = null;
        this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
        if (vectorDrawableCompat$VectorDrawableCompatState != null) {
            this.mChangingConfigurations = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
            VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = new VectorDrawableCompat$VPathRenderer(vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer);
            this.mVPathRenderer = vectorDrawableCompat$VPathRenderer;
            if (vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                vectorDrawableCompat$VPathRenderer.mFillPaint = new Paint(vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mFillPaint);
            }
            if (vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mStrokePaint);
            }
            this.mTint = vectorDrawableCompat$VectorDrawableCompatState.mTint;
            this.mTintMode = vectorDrawableCompat$VectorDrawableCompatState.mTintMode;
            this.mAutoMirrored = vectorDrawableCompat$VectorDrawableCompatState.mAutoMirrored;
        }
    }

    public boolean canReuseBitmap(int i, int i2) {
        return i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight();
    }

    public boolean canReuseCache() {
        return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
    }

    public void createCachedBitmapIfNeeded(int i, int i2) {
        if (this.mCachedBitmap == null || !canReuseBitmap(i, i2)) {
            this.mCachedBitmap = Bitmap.createBitmap(i, i2, Bitmap$Config.ARGB_8888);
            this.mCacheDirty = true;
        }
    }

    public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.mCachedBitmap, (Rect) null, rect, getPaint(colorFilter));
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public Paint getPaint(ColorFilter colorFilter) {
        if (!hasTranslucentRoot() && colorFilter == null) {
            return null;
        }
        if (this.mTempPaint == null) {
            Paint paint = new Paint();
            this.mTempPaint = paint;
            paint.setFilterBitmap(true);
        }
        this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
        this.mTempPaint.setColorFilter(colorFilter);
        return this.mTempPaint;
    }

    public boolean hasTranslucentRoot() {
        return this.mVPathRenderer.getRootAlpha() < 255;
    }

    public boolean isStateful() {
        return this.mVPathRenderer.isStateful();
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable() {
        return new VectorDrawableCompat(this);
    }

    public boolean onStateChanged(int[] iArr) {
        boolean zOnStateChanged = this.mVPathRenderer.onStateChanged(iArr);
        this.mCacheDirty |= zOnStateChanged;
        return zOnStateChanged;
    }

    public void updateCacheStates() {
        this.mCachedTint = this.mTint;
        this.mCachedTintMode = this.mTintMode;
        this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
        this.mCachedAutoMirrored = this.mAutoMirrored;
        this.mCacheDirty = false;
    }

    public void updateCachedBitmap(int i, int i2) {
        this.mCachedBitmap.eraseColor(0);
        this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), i, i2, null);
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable(Resources resources) {
        return new VectorDrawableCompat(this);
    }

    public VectorDrawableCompat$VectorDrawableCompatState() {
        this.mTint = null;
        this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
        this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
    }
}
