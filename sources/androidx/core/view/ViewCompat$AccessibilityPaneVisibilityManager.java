package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import androidx.annotation.RequiresApi;
import java.util.Map$Entry;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat$AccessibilityPaneVisibilityManager implements ViewTreeObserver$OnGlobalLayoutListener, View$OnAttachStateChangeListener {
    private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

    @RequiresApi(19)
    private void checkPaneVisibility(View view, boolean z2) {
        boolean z3 = view.getVisibility() == 0;
        if (z2 != z3) {
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, z3 ? 16 : 32);
            this.mPanesToVisible.put(view, Boolean.valueOf(z3));
        }
    }

    @RequiresApi(19)
    private void registerForLayoutCallback(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @RequiresApi(19)
    private void unregisterForLayoutCallback(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @RequiresApi(19)
    public void addAccessibilityPane(View view) {
        this.mPanesToVisible.put(view, Boolean.valueOf(view.getVisibility() == 0));
        view.addOnAttachStateChangeListener(this);
        if (view.isAttachedToWindow()) {
            registerForLayoutCallback(view);
        }
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    @RequiresApi(19)
    public void onGlobalLayout() {
        if (Build$VERSION.SDK_INT < 28) {
            for (Map$Entry<View, Boolean> map$Entry : this.mPanesToVisible.entrySet()) {
                checkPaneVisibility(map$Entry.getKey(), map$Entry.getValue().booleanValue());
            }
        }
    }

    @Override // android.view.View$OnAttachStateChangeListener
    @RequiresApi(19)
    public void onViewAttachedToWindow(View view) {
        registerForLayoutCallback(view);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }

    @RequiresApi(19)
    public void removeAccessibilityPane(View view) {
        this.mPanesToVisible.remove(view);
        view.removeOnAttachStateChangeListener(this);
        unregisterForLayoutCallback(view);
    }
}
