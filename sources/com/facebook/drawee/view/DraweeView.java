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
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1686i;
import p007b.p109f.p132g.p138b.C1751c;
import p007b.p109f.p161j.p183r.C2030b;

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
            C2030b.m1527b();
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
            C2030b.m1527b();
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
        draweeHolder.f19530f.m1084a(C1751c.a.ON_HOLDER_ATTACH);
        draweeHolder.f19526b = true;
        draweeHolder.m8688b();
    }

    public void doDetach() {
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        draweeHolder.f19530f.m1084a(C1751c.a.ON_HOLDER_DETACH);
        draweeHolder.f19526b = false;
        draweeHolder.m8688b();
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public DraweeController getController() {
        return this.mDraweeHolder.f19529e;
    }

    public DH getHierarchy() {
        DH dh = this.mDraweeHolder.f19528d;
        Objects.requireNonNull(dh);
        return dh;
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.m8690d();
    }

    public boolean hasController() {
        return this.mDraweeHolder.f19529e != null;
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.f19528d != null;
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
        aspectRatioMeasure$Spec.f19523a = i;
        aspectRatioMeasure$Spec.f19524b = i2;
        float f = this.mAspectRatio;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (f > 0.0f && layoutParams != null) {
            int i3 = layoutParams.height;
            boolean z2 = true;
            if (i3 == 0 || i3 == -2) {
                aspectRatioMeasure$Spec.f19524b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(aspectRatioMeasure$Spec.f19523a) - paddingRight) / f) + paddingBottom), aspectRatioMeasure$Spec.f19524b), BasicMeasure.EXACTLY);
            } else {
                int i4 = layoutParams.width;
                if (i4 != 0 && i4 != -2) {
                    z2 = false;
                }
                if (z2) {
                    aspectRatioMeasure$Spec.f19523a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(aspectRatioMeasure$Spec.f19524b) - paddingBottom) * f) + paddingRight), aspectRatioMeasure$Spec.f19523a), BasicMeasure.EXACTLY);
                }
            }
        }
        AspectRatioMeasure$Spec aspectRatioMeasure$Spec2 = this.mMeasureSpec;
        super.onMeasure(aspectRatioMeasure$Spec2.f19523a, aspectRatioMeasure$Spec2.f19524b);
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
        if (!draweeHolder.m8691e() ? false : draweeHolder.f19529e.onTouchEvent(motionEvent)) {
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
        this.mDraweeHolder.m8693g(draweeController);
        super.setImageDrawable(this.mDraweeHolder.m8690d());
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.m8694h(dh);
        super.setImageDrawable(this.mDraweeHolder.m8690d());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.m8693g(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.m8693g(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.m8693g(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.m8693g(null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z2) {
        this.mLegacyVisibilityHandlingEnabled = z2;
    }

    @Override // android.view.View
    public String toString() {
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        c1686iM526h2.m971c("holder", draweeHolder != null ? draweeHolder.toString() : "<no holder set>");
        return c1686iM526h2.toString();
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
