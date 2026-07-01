package com.discord.views.steps;

import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsView$e extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ StepsView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f2845b;
    public final /* synthetic */ Function0 c;

    public StepsView$e(StepsView stepsView, Function1 function1, Function0 function0) {
        this.a = stepsView;
        this.f2845b = function1;
        this.c = function0;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageSelected(int i) {
        this.f2845b.invoke(Integer.valueOf(i));
        StepsView stepsView = this.a;
        Function0<Unit> function0 = this.c;
        int i2 = StepsView.j;
        stepsView.c(i, function0);
        this.a.binding.g.setCurrentStepIndex(i);
    }
}
