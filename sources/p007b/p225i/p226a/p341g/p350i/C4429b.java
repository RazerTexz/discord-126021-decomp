package p007b.p225i.p226a.p341g.p350i;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: renamed from: b.i.a.g.i.b */
/* JADX INFO: compiled from: TabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4429b {
    /* JADX INFO: renamed from: a */
    public static RectF m6145a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.isTabIndicatorFullWidth() || !(view instanceof TabLayout.TabView)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        TabLayout.TabView tabView = (TabLayout.TabView) view;
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int iDpToPx = (int) ViewUtils.dpToPx(tabView.getContext(), 24);
        if (contentWidth < iDpToPx) {
            contentWidth = iDpToPx;
        }
        int right = (tabView.getRight() + tabView.getLeft()) / 2;
        int bottom = (tabView.getBottom() + tabView.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    /* JADX INFO: renamed from: b */
    public void mo6144b(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @NonNull Drawable drawable) {
        RectF rectFM6145a = m6145a(tabLayout, view);
        RectF rectFM6145a2 = m6145a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.lerp((int) rectFM6145a.left, (int) rectFM6145a2.left, f), drawable.getBounds().top, AnimationUtils.lerp((int) rectFM6145a.right, (int) rectFM6145a2.right, f), drawable.getBounds().bottom);
    }
}
