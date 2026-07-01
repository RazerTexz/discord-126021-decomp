package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Objects2;
import b.f.g.b.DraweeEventTracker;
import b.f.j.r.FrescoSystrace;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled = false;
    private float mAspectRatio;
    private DraweeHolder<DH> mDraweeHolder;
    private boolean mInitialised;
    private boolean mLegacyVisibilityHandlingEnabled;
    private final AspectRatioMeasure$Spec mMeasureSpec;

    public DraweeView(Context context) {
        super(context);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        init(context);
    }

    private void init(Context context) {
        try {
            FrescoSystrace.b();
            if (this.mInitialised) {
                return;
            }
            boolean z2 = true;
            this.mInitialised = true;
            this.mDraweeHolder = new DraweeHolder<>(null);
            ColorStateList imageTintList = getImageTintList();
            if (imageTintList == null) {
                return;
            }
            setColorFilter(imageTintList.getDefaultColor());
            if (!sGlobalLegacyVisibilityHandlingEnabled || context.getApplicationInfo().targetSdkVersion < 24) {
                z2 = false;
            }
            this.mLegacyVisibilityHandlingEnabled = z2;
        } finally {
            FrescoSystrace.b();
        }
    }

    private void maybeOverrideVisibilityHandling() {
        Drawable drawable;
        if (!this.mLegacyVisibilityHandlingEnabled || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setVisible(getVisibility() == 0, false);
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z2) {
        sGlobalLegacyVisibilityHandlingEnabled = z2;
    }

    public void doAttach() {
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        draweeHolder.f.a(DraweeEventTracker.a.ON_HOLDER_ATTACH);
        draweeHolder.f2893b = true;
        draweeHolder.b();
    }

    public void doDetach() {
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        draweeHolder.f.a(DraweeEventTracker.a.ON_HOLDER_DETACH);
        draweeHolder.f2893b = false;
        draweeHolder.b();
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public DraweeController getController() {
        return this.mDraweeHolder.e;
    }

    public DH getHierarchy() {
        DH dh = this.mDraweeHolder.d;
        Objects.requireNonNull(dh);
        return dh;
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.d();
    }

    public boolean hasController() {
        return this.mDraweeHolder.e != null;
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.d != null;
    }

    public void onAttach() {
        doAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    public void onDetach() {
        doDetach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        AspectRatioMeasure$Spec aspectRatioMeasure$Spec = this.mMeasureSpec;
        aspectRatioMeasure$Spec.a = i;
        aspectRatioMeasure$Spec.f2892b = i2;
        float f = this.mAspectRatio;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (f > 0.0f && layoutParams != null) {
            int i3 = layoutParams.height;
            boolean z2 = true;
            if (i3 == 0 || i3 == -2) {
                aspectRatioMeasure$Spec.f2892b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(aspectRatioMeasure$Spec.a) - paddingRight) / f) + paddingBottom), aspectRatioMeasure$Spec.f2892b), BasicMeasure.EXACTLY);
            } else {
                int i4 = layoutParams.width;
                if (i4 != 0 && i4 != -2) {
                    z2 = false;
                }
                if (z2) {
                    aspectRatioMeasure$Spec.a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(aspectRatioMeasure$Spec.f2892b) - paddingBottom) * f) + paddingRight), aspectRatioMeasure$Spec.a), BasicMeasure.EXACTLY);
                }
            }
        }
        AspectRatioMeasure$Spec aspectRatioMeasure$Spec2 = this.mMeasureSpec;
        super.onMeasure(aspectRatioMeasure$Spec2.a, aspectRatioMeasure$Spec2.f2892b);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        if (!draweeHolder.e() ? false : draweeHolder.e.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        maybeOverrideVisibilityHandling();
    }

    public void setAspectRatio(float f) {
        if (f == this.mAspectRatio) {
            return;
        }
        this.mAspectRatio = f;
        requestLayout();
    }

    public void setController(DraweeController draweeController) {
        this.mDraweeHolder.g(draweeController);
        super.setImageDrawable(this.mDraweeHolder.d());
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.h(dh);
        super.setImageDrawable(this.mDraweeHolder.d());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.g(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.g(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.g(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.g(null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z2) {
        this.mLegacyVisibilityHandlingEnabled = z2;
    }

    @Override // android.view.View
    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        objects2H2.c("holder", draweeHolder != null ? draweeHolder.toString() : "<no holder set>");
        return objects2H2.toString();
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        init(context);
    }
}
