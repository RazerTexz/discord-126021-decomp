package com.discord.utilities.view.recycler;

import com.google.android.material.tabs.TabLayout$Tab;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewPager2Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2ExtensionsKt$setUpWithViewPager2$1 extends o implements Function2<TabLayout$Tab, Integer, Unit> {
    public static final ViewPager2ExtensionsKt$setUpWithViewPager2$1 INSTANCE = new ViewPager2ExtensionsKt$setUpWithViewPager2$1();

    public ViewPager2ExtensionsKt$setUpWithViewPager2$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout$Tab tabLayout$Tab, Integer num) {
        invoke(tabLayout$Tab, num.intValue());
        return Unit.a;
    }

    public final void invoke(TabLayout$Tab tabLayout$Tab, int i) {
        m.checkNotNullParameter(tabLayout$Tab, "<anonymous parameter 0>");
    }
}
