package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import b.d.b.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(20)
public class WindowInsetsCompat$Impl20 extends WindowInsetsCompat$Impl {
    private static Class<?> sAttachInfoClass = null;
    private static Field sAttachInfoField = null;
    private static Method sGetViewRootImplMethod = null;
    private static Class<?> sViewRootImplClass = null;
    private static Field sVisibleInsetsField = null;
    private static boolean sVisibleRectReflectionFetched = false;
    private Insets[] mOverriddenInsets;

    @NonNull
    public final WindowInsets mPlatformInsets;
    public Insets mRootViewVisibleInsets;
    private WindowInsetsCompat mRootWindowInsets;
    private Insets mSystemWindowInsets;

    public WindowInsetsCompat$Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat);
        this.mSystemWindowInsets = null;
        this.mPlatformInsets = windowInsets;
    }

    private Insets getRootStableInsets() {
        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
        return windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : Insets.NONE;
    }

    @Nullable
    private Insets getVisibleInsets(@NonNull View view) {
        if (Build$VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!sVisibleRectReflectionFetched) {
            loadReflectionField();
        }
        Method method = sGetViewRootImplMethod;
        if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(objInvoke));
                if (rect != null) {
                    return Insets.of(rect);
                }
                return null;
            } catch (ReflectiveOperationException e) {
                StringBuilder sbU = a.U("Failed to get visible insets. (Reflection error). ");
                sbU.append(e.getMessage());
                Log.e("WindowInsetsCompat", sbU.toString(), e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void loadReflectionField() {
        try {
            sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            sViewRootImplClass = Class.forName("android.view.ViewRootImpl");
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            sAttachInfoClass = cls;
            sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
            sAttachInfoField = sViewRootImplClass.getDeclaredField("mAttachInfo");
            sVisibleInsetsField.setAccessible(true);
            sAttachInfoField.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            StringBuilder sbU = a.U("Failed to get visible insets. (Reflection error). ");
            sbU.append(e.getMessage());
            Log.e("WindowInsetsCompat", sbU.toString(), e);
        }
        sVisibleRectReflectionFetched = true;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public void copyRootViewBounds(@NonNull View view) {
        Insets visibleInsets = getVisibleInsets(view);
        if (visibleInsets == null) {
            visibleInsets = Insets.NONE;
        }
        setRootViewData(visibleInsets);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
        windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
        windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.mRootViewVisibleInsets, ((WindowInsetsCompat$Impl20) obj).mRootViewVisibleInsets);
        }
        return false;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getInsets(int i) {
        return getInsets(i, false);
    }

    @NonNull
    public Insets getInsetsForType(int i, boolean z2) {
        Insets stableInsets;
        int i2;
        if (i == 1) {
            return z2 ? Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0) : Insets.of(0, getSystemWindowInsets().top, 0, 0);
        }
        if (i == 2) {
            if (z2) {
                Insets rootStableInsets = getRootStableInsets();
                Insets stableInsets2 = getStableInsets();
                return Insets.of(Math.max(rootStableInsets.left, stableInsets2.left), 0, Math.max(rootStableInsets.right, stableInsets2.right), Math.max(rootStableInsets.bottom, stableInsets2.bottom));
            }
            Insets systemWindowInsets = getSystemWindowInsets();
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            stableInsets = windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : null;
            int iMin = systemWindowInsets.bottom;
            if (stableInsets != null) {
                iMin = Math.min(iMin, stableInsets.bottom);
            }
            return Insets.of(systemWindowInsets.left, 0, systemWindowInsets.right, iMin);
        }
        if (i != 8) {
            if (i == 16) {
                return getSystemGestureInsets();
            }
            if (i == 32) {
                return getMandatorySystemGestureInsets();
            }
            if (i == 64) {
                return getTappableElementInsets();
            }
            if (i != 128) {
                return Insets.NONE;
            }
            WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
            DisplayCutoutCompat displayCutout = windowInsetsCompat2 != null ? windowInsetsCompat2.getDisplayCutout() : getDisplayCutout();
            return displayCutout != null ? Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : Insets.NONE;
        }
        Insets[] insetsArr = this.mOverriddenInsets;
        stableInsets = insetsArr != null ? insetsArr[WindowInsetsCompat$Type.indexOf(8)] : null;
        if (stableInsets != null) {
            return stableInsets;
        }
        Insets systemWindowInsets2 = getSystemWindowInsets();
        Insets rootStableInsets2 = getRootStableInsets();
        int i3 = systemWindowInsets2.bottom;
        if (i3 > rootStableInsets2.bottom) {
            return Insets.of(0, 0, 0, i3);
        }
        Insets insets = this.mRootViewVisibleInsets;
        return (insets == null || insets.equals(Insets.NONE) || (i2 = this.mRootViewVisibleInsets.bottom) <= rootStableInsets2.bottom) ? Insets.NONE : Insets.of(0, 0, 0, i2);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        return getInsets(i, true);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public final Insets getSystemWindowInsets() {
        if (this.mSystemWindowInsets == null) {
            this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
        }
        return this.mSystemWindowInsets;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
        windowInsetsCompat$Builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i, i2, i3, i4));
        windowInsetsCompat$Builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i, i2, i3, i4));
        return windowInsetsCompat$Builder.build();
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public boolean isRound() {
        return this.mPlatformInsets.isRound();
    }

    public boolean isTypeVisible(int i) {
        if (i != 1 && i != 2) {
            if (i == 4) {
                return false;
            }
            if (i != 8 && i != 128) {
                return true;
            }
        }
        return !getInsetsForType(i, false).equals(Insets.NONE);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @SuppressLint({"WrongConstant"})
    public boolean isVisible(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0 && !isTypeVisible(i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public void setOverriddenInsets(Insets[] insetsArr) {
        this.mOverriddenInsets = insetsArr;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public void setRootViewData(@NonNull Insets insets) {
        this.mRootViewVisibleInsets = insets;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mRootWindowInsets = windowInsetsCompat;
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    private Insets getInsets(int i, boolean z2) {
        Insets insetsMax = Insets.NONE;
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                insetsMax = Insets.max(insetsMax, getInsetsForType(i2, z2));
            }
        }
        return insetsMax;
    }

    public WindowInsetsCompat$Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat$Impl20 windowInsetsCompat$Impl20) {
        this(windowInsetsCompat, new WindowInsets(windowInsetsCompat$Impl20.mPlatformInsets));
    }
}
