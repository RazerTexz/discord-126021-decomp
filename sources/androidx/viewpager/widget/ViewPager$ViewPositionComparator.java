package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager$ViewPositionComparator implements Comparator<View> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(View view, View view2) {
        return compare2(view, view2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(View view, View view2) {
        ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams) view.getLayoutParams();
        ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams) view2.getLayoutParams();
        boolean z2 = viewPager$LayoutParams.isDecor;
        if (z2 != viewPager$LayoutParams2.isDecor) {
            return z2 ? 1 : -1;
        }
        return viewPager$LayoutParams.position - viewPager$LayoutParams2.position;
    }
}
