package com.discord.utilities.view.recycler;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewPager2Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2ExtensionsKt {

    /* JADX INFO: renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$setUpWithViewPager2$1 */
    /* JADX INFO: compiled from: ViewPager2Extensions.kt */
    public static final class C70081 extends AbstractC12240o implements Function2<TabLayout.Tab, Integer, Unit> {
        public static final C70081 INSTANCE = new C70081();

        public C70081() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            C12238m.checkNotNullParameter(tab, "<anonymous parameter 0>");
        }
    }

    public static final void setUpWithViewPager2(TabLayout tabLayout, ViewPager2 viewPager2, final Function2<? super TabLayout.Tab, ? super Integer, Unit> function2) {
        C12238m.checkNotNullParameter(tabLayout, "$this$setUpWithViewPager2");
        C12238m.checkNotNullParameter(viewPager2, "viewPager2");
        C12238m.checkNotNullParameter(function2, "configureTab");
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final /* synthetic */ void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                C12238m.checkNotNullParameter(tab, "p0");
                C12238m.checkNotNullExpressionValue(function2.invoke(tab, Integer.valueOf(i)), "invoke(...)");
            }
        }).attach();
    }

    public static /* synthetic */ void setUpWithViewPager2$default(TabLayout tabLayout, ViewPager2 viewPager2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = C70081.INSTANCE;
        }
        setUpWithViewPager2(tabLayout, viewPager2, function2);
    }
}
