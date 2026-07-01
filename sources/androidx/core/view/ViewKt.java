package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.f0.l;
import d0.f0.n;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, function1));
        }
    }

    public static final void doOnDetach(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, function1));
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnLayout(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "action");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(function1));
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "action");
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(function1));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "action");
        OneShotPreDrawListener oneShotPreDrawListenerAdd = OneShotPreDrawListener.add(view, new ViewKt$doOnPreDraw$1(function1, view));
        m.checkNotNullExpressionValue(oneShotPreDrawListenerAdd, "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
        return oneShotPreDrawListenerAdd;
    }

    public static final Bitmap drawToBitmap(View view, Bitmap$Config bitmap$Config) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(bitmap$Config, "config");
        if (!ViewCompat.isLaidOut(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), bitmap$Config);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap$Config bitmap$Config, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        return drawToBitmap(view, bitmap$Config);
    }

    public static final Sequence<View> getAllViews(View view) {
        m.checkNotNullParameter(view, "<this>");
        return l.sequence(new ViewKt$allViews$1(view, null));
    }

    public static final Sequence<ViewParent> getAncestors(View view) {
        m.checkNotNullParameter(view, "<this>");
        return n.generateSequence(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View view) {
        m.checkNotNullParameter(view, "<this>");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = layoutParams instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams : null;
        if (viewGroup$MarginLayoutParams == null) {
            return 0;
        }
        return viewGroup$MarginLayoutParams.bottomMargin;
    }

    public static final int getMarginEnd(View view) {
        m.checkNotNullParameter(view, "<this>");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup$MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        m.checkNotNullParameter(view, "<this>");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = layoutParams instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams : null;
        if (viewGroup$MarginLayoutParams == null) {
            return 0;
        }
        return viewGroup$MarginLayoutParams.leftMargin;
    }

    public static final int getMarginRight(View view) {
        m.checkNotNullParameter(view, "<this>");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = layoutParams instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams : null;
        if (viewGroup$MarginLayoutParams == null) {
            return 0;
        }
        return viewGroup$MarginLayoutParams.rightMargin;
    }

    public static final int getMarginStart(View view) {
        m.checkNotNullParameter(view, "<this>");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup$MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        m.checkNotNullParameter(view, "<this>");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = layoutParams instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams : null;
        if (viewGroup$MarginLayoutParams == null) {
            return 0;
        }
        return viewGroup$MarginLayoutParams.topMargin;
    }

    public static final boolean isGone(View view) {
        m.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        m.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        m.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j, Function0<Unit> function0) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function0, "action");
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(function0);
        view.postDelayed(viewKt$postDelayed$runnable$1, j);
        return viewKt$postDelayed$runnable$1;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view, long j, Function0<Unit> function0) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function0, "action");
        ViewKt$postOnAnimationDelayed$runnable$1 viewKt$postOnAnimationDelayed$runnable$1 = new ViewKt$postOnAnimationDelayed$runnable$1(function0);
        view.postOnAnimationDelayed(viewKt$postOnAnimationDelayed$runnable$1, j);
        return viewKt$postOnAnimationDelayed$runnable$1;
    }

    public static final void setGone(View view, boolean z2) {
        m.checkNotNullParameter(view, "<this>");
        view.setVisibility(z2 ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z2) {
        m.checkNotNullParameter(view, "<this>");
        view.setVisibility(z2 ? 4 : 0);
    }

    public static final void setPadding(View view, @Px int i) {
        m.checkNotNullParameter(view, "<this>");
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view, boolean z2) {
        m.checkNotNullParameter(view, "<this>");
        view.setVisibility(z2 ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, Function1<? super ViewGroup$LayoutParams, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "block");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final /* synthetic */ <T extends ViewGroup$LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        m.checkNotNullParameter(view, "<this>");
        m.checkNotNullParameter(function1, "block");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        m.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        m.checkNotNullParameter(view, "<this>");
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        m.checkNotNullParameter(view, "<this>");
        view.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        m.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        m.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
