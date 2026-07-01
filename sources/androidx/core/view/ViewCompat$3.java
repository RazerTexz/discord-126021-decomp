package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat$3 extends ViewCompat$AccessibilityViewProperty<CharSequence> {
    public ViewCompat$3(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    @RequiresApi(28)
    public /* bridge */ /* synthetic */ CharSequence frameworkGet(View view) {
        return frameworkGet(view);
    }

    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    @RequiresApi(28)
    public /* bridge */ /* synthetic */ void frameworkSet(View view, CharSequence charSequence) {
        frameworkSet2(view, charSequence);
    }

    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    public /* bridge */ /* synthetic */ boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
        return shouldUpdate2(charSequence, charSequence2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.view.ViewCompat$AccessibilityViewProperty
    @RequiresApi(28)
    public CharSequence frameworkGet(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @RequiresApi(28)
    /* JADX INFO: renamed from: frameworkSet, reason: avoid collision after fix types in other method */
    public void frameworkSet2(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    /* JADX INFO: renamed from: shouldUpdate, reason: avoid collision after fix types in other method */
    public boolean shouldUpdate2(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
