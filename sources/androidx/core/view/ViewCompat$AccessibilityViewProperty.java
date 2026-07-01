package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewCompat$AccessibilityViewProperty<T> {
    private final int mContentChangeType;
    private final int mFrameworkMinimumSdk;
    private final int mTagKey;
    private final Class<T> mType;

    public ViewCompat$AccessibilityViewProperty(int i, Class<T> cls, int i2) {
        this(i, cls, 0, i2);
    }

    private boolean extrasAvailable() {
        return true;
    }

    private boolean frameworkAvailable() {
        return Build$VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
    }

    public boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
        return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
    }

    public abstract T frameworkGet(View view);

    public abstract void frameworkSet(View view, T t);

    public T get(View view) {
        if (frameworkAvailable()) {
            return frameworkGet(view);
        }
        if (!extrasAvailable()) {
            return null;
        }
        T t = (T) view.getTag(this.mTagKey);
        if (this.mType.isInstance(t)) {
            return t;
        }
        return null;
    }

    public void set(View view, T t) {
        if (frameworkAvailable()) {
            frameworkSet(view, t);
        } else if (extrasAvailable() && shouldUpdate(get(view), t)) {
            ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
            view.setTag(this.mTagKey, t);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
        }
    }

    public boolean shouldUpdate(T t, T t2) {
        return !t2.equals(t);
    }

    public ViewCompat$AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
        this.mTagKey = i;
        this.mType = cls;
        this.mContentChangeType = i2;
        this.mFrameworkMinimumSdk = i3;
    }
}
