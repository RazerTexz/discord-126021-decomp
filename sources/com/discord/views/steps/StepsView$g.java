package com.discord.views.steps;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.viewpager2.widget.ViewPager2;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsView$g implements View$OnClickListener {
    public final /* synthetic */ StepsView j;
    public final /* synthetic */ List k;
    public final /* synthetic */ int l;
    public final /* synthetic */ Function0 m;

    public StepsView$g(StepsView stepsView, List list, int i, Function0 function0) {
        this.j = stepsView;
        this.k = list;
        this.l = i;
        this.m = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<View, Unit> function1 = ((StepsView$b) this.k.get(this.l)).e;
        if (function1 != null) {
            m.checkNotNullExpressionValue(view, "it");
            function1.invoke(view);
            return;
        }
        ViewPager2 viewPager2 = this.j.binding.i;
        m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        if (viewPager2.getCurrentItem() == 0) {
            this.m.invoke();
            return;
        }
        ViewPager2 viewPager3 = this.j.binding.i;
        m.checkNotNullExpressionValue(viewPager3, "binding.stepsViewpager");
        ViewPager2 viewPager4 = this.j.binding.i;
        m.checkNotNullExpressionValue(viewPager4, "binding.stepsViewpager");
        viewPager3.setCurrentItem(viewPager4.getCurrentItem() - 1);
    }
}
