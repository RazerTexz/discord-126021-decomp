package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$PageAwareAccessibilityProvider$2 implements AccessibilityViewCommand {
    public final /* synthetic */ ViewPager2$PageAwareAccessibilityProvider this$1;

    public ViewPager2$PageAwareAccessibilityProvider$2(ViewPager2$PageAwareAccessibilityProvider viewPager2$PageAwareAccessibilityProvider) {
        this.this$1 = viewPager2$PageAwareAccessibilityProvider;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments) {
        this.this$1.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() - 1);
        return true;
    }
}
