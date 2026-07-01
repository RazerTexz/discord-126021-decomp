package com.discord.utilities.view.recycler;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: ViewPager2Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2Extensions {

    /* JADX INFO: renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$setUpWithViewPager2$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewPager2Extensions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            Intrinsics3.checkNotNullParameter(tab, "<anonymous parameter 0>");
        }
    }

    public static final void setUpWithViewPager2(TabLayout tabLayout, ViewPager2 viewPager2, final Function2<? super TabLayout.Tab, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(tabLayout, "$this$setUpWithViewPager2");
        Intrinsics3.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics3.checkNotNullParameter(function2, "configureTab");
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final /* synthetic */ void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                Intrinsics3.checkNotNullParameter(tab, "p0");
                Intrinsics3.checkNotNullExpressionValue(function2.invoke(tab, Integer.valueOf(i)), "invoke(...)");
            }
        }).attach();
    }

    public static /* synthetic */ void setUpWithViewPager2$default(TabLayout tabLayout, ViewPager2 viewPager2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = AnonymousClass1.INSTANCE;
        }
        setUpWithViewPager2(tabLayout, viewPager2, function2);
    }
}
