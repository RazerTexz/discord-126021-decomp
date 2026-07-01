package com.discord.views.steps;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.viewpager2.widget.ViewPager2;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class StepsView$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Object m;

    public StepsView$a(int i, int i2, Object obj, Object obj2) {
        this.j = i;
        this.k = i2;
        this.l = obj;
        this.m = obj2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i != 0) {
            if (i != 1) {
                throw null;
            }
            Function1<View, Unit> function1 = ((StepsView$b) ((List) this.l).get(this.k)).f;
            if (function1 == null) {
                ((Function0) this.m).invoke();
                return;
            } else {
                m.checkNotNullExpressionValue(view, "it");
                function1.invoke(view);
                return;
            }
        }
        Function1<View, Unit> function2 = ((StepsView$b) ((List) this.m).get(this.k)).d;
        if (function2 != null) {
            m.checkNotNullExpressionValue(view, "it");
            function2.invoke(view);
            return;
        }
        ViewPager2 viewPager2 = ((StepsView) this.l).binding.i;
        m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        int currentItem = viewPager2.getCurrentItem();
        StepsView$d stepsView$d = ((StepsView) this.l).pagerAdapter;
        if (stepsView$d == null || currentItem != stepsView$d.getItemCount() - 1) {
            ViewPager2 viewPager3 = ((StepsView) this.l).binding.i;
            m.checkNotNullExpressionValue(viewPager3, "binding.stepsViewpager");
            ViewPager2 viewPager4 = ((StepsView) this.l).binding.i;
            m.checkNotNullExpressionValue(viewPager4, "binding.stepsViewpager");
            viewPager3.setCurrentItem(viewPager4.getCurrentItem() + 1);
        }
    }
}
