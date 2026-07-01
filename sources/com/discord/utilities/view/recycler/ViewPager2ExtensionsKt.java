package com.discord.utilities.view.recycler;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$Tab;
import com.google.android.material.tabs.TabLayoutMediator;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewPager2Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2ExtensionsKt {
    public static final void setUpWithViewPager2(TabLayout tabLayout, ViewPager2 viewPager2, Function2<? super TabLayout$Tab, ? super Integer, Unit> function2) {
        m.checkNotNullParameter(tabLayout, "$this$setUpWithViewPager2");
        m.checkNotNullParameter(viewPager2, "viewPager2");
        m.checkNotNullParameter(function2, "configureTab");
        new TabLayoutMediator(tabLayout, viewPager2, new ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0(function2)).attach();
    }

    public static /* synthetic */ void setUpWithViewPager2$default(TabLayout tabLayout, ViewPager2 viewPager2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = ViewPager2ExtensionsKt$setUpWithViewPager2$1.INSTANCE;
        }
        setUpWithViewPager2(tabLayout, viewPager2, function2);
    }
}
