package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.Rect;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.d.b.a.a;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 2;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final CircularRevealHelper$Delegate delegate;
    private boolean hasCircularRevealCache;

    @Nullable
    private Drawable overlayDrawable;

    @Nullable
    private CircularRevealWidget$RevealInfo revealInfo;

    @NonNull
    private final Paint revealPaint;

    @NonNull
    private final Path revealPath;

    @NonNull
    private final Paint scrimPaint;

    @NonNull
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(CircularRevealHelper$Delegate circularRevealHelper$Delegate) {
        this.delegate = circularRevealHelper$Delegate;
        View view = (View) circularRevealHelper$Delegate;
        this.view = view;
        view.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas canvas, int i, float f) {
        this.debugPaint.setColor(i);
        this.debugPaint.setStrokeWidth(f);
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
        canvas.drawCircle(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo.radius - (f / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas canvas) {
        this.delegate.actualDraw(canvas);
        if (shouldDrawScrim()) {
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
            canvas.drawCircle(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo.radius, this.scrimPaint);
        }
        if (shouldDrawCircularReveal()) {
            drawDebugCircle(canvas, ViewCompat.MEASURED_STATE_MASK, 10.0f);
            drawDebugCircle(canvas, -65536, 5.0f);
        }
        drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(@NonNull Canvas canvas) {
        if (shouldDrawOverlayDrawable()) {
            Rect bounds = this.overlayDrawable.getBounds();
            float fWidth = this.revealInfo.centerX - (bounds.width() / 2.0f);
            float fHeight = this.revealInfo.centerY - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        return MathUtils.distanceToFurthestCorner(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY == 1) {
            this.revealPath.rewind();
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
            if (circularRevealWidget$RevealInfo != null) {
                this.revealPath.addCircle(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo.radius, Path$Direction.CW);
            }
        }
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
        boolean z2 = circularRevealWidget$RevealInfo == null || circularRevealWidget$RevealInfo.isInvalid();
        if (STRATEGY == 0) {
            return !z2 && this.hasCircularRevealCache;
        }
        return !z2;
    }

    private boolean shouldDrawOverlayDrawable() {
        return (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true;
    }

    private boolean shouldDrawScrim() {
        return (this.buildingCircularRevealCache || Color.alpha(this.scrimPaint.getColor()) == 0) ? false : true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (drawingCache == null && this.view.getWidth() != 0 && this.view.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap$Config.ARGB_8888);
                this.view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.revealPaint;
                Shader$TileMode shader$TileMode = Shader$TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, shader$TileMode, shader$TileMode));
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader(null);
            this.view.invalidate();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (shouldDrawCircularReveal()) {
            int i = STRATEGY;
            if (i == 0) {
                CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
                canvas.drawCircle(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo.radius, this.revealPaint);
                if (shouldDrawScrim()) {
                    CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2 = this.revealInfo;
                    canvas.drawCircle(circularRevealWidget$RevealInfo2.centerX, circularRevealWidget$RevealInfo2.centerY, circularRevealWidget$RevealInfo2.radius, this.scrimPaint);
                }
            } else if (i == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.revealPath);
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
                }
                canvas.restoreToCount(iSave);
            } else {
                if (i != 2) {
                    throw new IllegalStateException(a.q("Unsupported strategy ", i));
                }
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
                }
            }
        } else {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
            }
        }
        drawOverlayDrawable(canvas);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget$RevealInfo getRevealInfo() {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
        if (circularRevealWidget$RevealInfo == null) {
            return null;
        }
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2 = new CircularRevealWidget$RevealInfo(circularRevealWidget$RevealInfo);
        if (circularRevealWidget$RevealInfo2.isInvalid()) {
            circularRevealWidget$RevealInfo2.radius = getDistanceToFurthestCorner(circularRevealWidget$RevealInfo2);
        }
        return circularRevealWidget$RevealInfo2;
    }

    public boolean isOpaque() {
        return this.delegate.actualIsOpaque() && !shouldDrawCircularReveal();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.overlayDrawable = drawable;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i) {
        this.scrimPaint.setColor(i);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        if (circularRevealWidget$RevealInfo == null) {
            this.revealInfo = null;
        } else {
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2 = this.revealInfo;
            if (circularRevealWidget$RevealInfo2 == null) {
                this.revealInfo = new CircularRevealWidget$RevealInfo(circularRevealWidget$RevealInfo);
            } else {
                circularRevealWidget$RevealInfo2.set(circularRevealWidget$RevealInfo);
            }
            if (MathUtils.geq(circularRevealWidget$RevealInfo.radius, getDistanceToFurthestCorner(circularRevealWidget$RevealInfo), 1.0E-4f)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        invalidateRevealInfo();
    }
}
