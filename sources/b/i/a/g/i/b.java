package b.i.a.g.i;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$TabView;

/* JADX INFO: compiled from: TabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.isTabIndicatorFullWidth() || !(view instanceof TabLayout$TabView)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        TabLayout$TabView tabLayout$TabView = (TabLayout$TabView) view;
        int contentWidth = tabLayout$TabView.getContentWidth();
        int contentHeight = tabLayout$TabView.getContentHeight();
        int iDpToPx = (int) ViewUtils.dpToPx(tabLayout$TabView.getContext(), 24);
        if (contentWidth < iDpToPx) {
            contentWidth = iDpToPx;
        }
        int right = (tabLayout$TabView.getRight() + tabLayout$TabView.getLeft()) / 2;
        int bottom = (tabLayout$TabView.getBottom() + tabLayout$TabView.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    public void b(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f, @NonNull Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.lerp((int) rectFA.left, (int) rectFA2.left, f), drawable.getBounds().top, AnimationUtils.lerp((int) rectFA.right, (int) rectFA2.right, f), drawable.getBounds().bottom);
    }
}
