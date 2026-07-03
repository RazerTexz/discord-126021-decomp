package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.C10817R;
import p007b.p225i.p226a.p341g.p347f.C4414b;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.ViewUtils$a */
    public static class RunnableC10948a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ View f21047j;

        public RunnableC10948a(View view) {
            this.f21047j = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f21047j.getContext().getSystemService("input_method")).showSoftInput(this.f21047j, 1);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.ViewUtils$b */
    public static class C10949b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ boolean f21048a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ boolean f21049b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ boolean f21050c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ OnApplyWindowInsetsListener f21051d;

        public C10949b(boolean z2, boolean z3, boolean z4, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            this.f21048a = z2;
            this.f21049b = z3;
            this.f21050c = z4;
            this.f21051d = onApplyWindowInsetsListener;
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull RelativePadding relativePadding) {
            if (this.f21048a) {
                relativePadding.bottom = windowInsetsCompat.getSystemWindowInsetBottom() + relativePadding.bottom;
            }
            boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view);
            if (this.f21049b) {
                if (zIsLayoutRtl) {
                    relativePadding.end = windowInsetsCompat.getSystemWindowInsetLeft() + relativePadding.end;
                } else {
                    relativePadding.start = windowInsetsCompat.getSystemWindowInsetLeft() + relativePadding.start;
                }
            }
            if (this.f21050c) {
                if (zIsLayoutRtl) {
                    relativePadding.start = windowInsetsCompat.getSystemWindowInsetRight() + relativePadding.start;
                } else {
                    relativePadding.end = windowInsetsCompat.getSystemWindowInsetRight() + relativePadding.end;
                }
            }
            relativePadding.applyToView(view);
            OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f21051d;
            return onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat, relativePadding) : windowInsetsCompat;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.ViewUtils$c */
    public static class C10950c implements androidx.core.view.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ OnApplyWindowInsetsListener f21052a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ RelativePadding f21053b;

        public C10950c(OnApplyWindowInsetsListener onApplyWindowInsetsListener, RelativePadding relativePadding) {
            this.f21052a = onApplyWindowInsetsListener;
            this.f21053b = relativePadding;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.f21052a.onApplyWindowInsets(view, windowInsetsCompat, new RelativePadding(this.f21053b));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.ViewUtils$d */
    public static class ViewOnAttachStateChangeListenerC10951d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    private ViewUtils() {
    }

    public static void addOnGlobalLayoutListener(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i, int i2) {
        doOnApplyWindowInsets(view, attributeSet, i, i2, null);
    }

    public static float dpToPx(@NonNull Context context, @Dimension(unit = 0) int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static ViewGroup getContentView(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static ViewOverlayImpl getContentViewOverlay(@NonNull View view) {
        return getOverlay(getContentView(view));
    }

    @Nullable
    public static ViewOverlayImpl getOverlay(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return new C4414b(view);
    }

    public static float getParentAbsoluteElevation(@NonNull View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ViewCompat.getElevation((View) parent);
        }
        return elevation;
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void removeOnGlobalLayoutListener(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            removeOnGlobalLayoutListener(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void requestApplyInsetsWhenAttached(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC10951d());
        }
    }

    public static void requestFocusAndShowKeyboard(@NonNull View view) {
        view.requestFocus();
        view.post(new RunnableC10948a(view));
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i, int i2, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, C10817R.styleable.Insets, i, i2);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new C10949b(z2, z3, z4, onApplyWindowInsetsListener));
    }

    public static void removeOnGlobalLayoutListener(@NonNull ViewTreeObserver viewTreeObserver, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public void applyToView(View view) {
            ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @NonNull OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new C10950c(onApplyWindowInsetsListener, new RelativePadding(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        requestApplyInsetsWhenAttached(view);
    }
}
