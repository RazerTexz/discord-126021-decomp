package androidx.core.view;

import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat$5 extends ViewCompat$AccessibilityViewProperty<Boolean> {
    public ViewCompat$5(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    @RequiresApi(28)
    public /* bridge */ /* synthetic */ Boolean frameworkGet(View view) {
        return frameworkGet(view);
    }

    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    @RequiresApi(28)
    public /* bridge */ /* synthetic */ void frameworkSet(View view, Boolean bool) {
        frameworkSet2(view, bool);
    }

    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    public /* bridge */ /* synthetic */ boolean shouldUpdate(Boolean bool, Boolean bool2) {
        return shouldUpdate2(bool, bool2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    @RequiresApi(28)
    public Boolean frameworkGet(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    @RequiresApi(28)
    /* JADX INFO: renamed from: frameworkSet, reason: avoid collision after fix types in other method */
    public void frameworkSet2(View view, Boolean bool) {
        view.setAccessibilityHeading(bool.booleanValue());
    }

    /* JADX INFO: renamed from: shouldUpdate, reason: avoid collision after fix types in other method */
    public boolean shouldUpdate2(Boolean bool, Boolean bool2) {
        return !booleanNullToFalseEquals(bool, bool2);
    }
}
