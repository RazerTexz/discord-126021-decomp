package com.discord.utilities.view.recycler;

import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout$Tab;
import com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewPager2Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0 implements TabLayoutMediator$TabConfigurationStrategy {
    private final /* synthetic */ Function2 function;

    public ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0(Function2 function2) {
        this.function = function2;
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy
    public final /* synthetic */ void onConfigureTab(@NonNull TabLayout$Tab tabLayout$Tab, int i) {
        m.checkNotNullParameter(tabLayout$Tab, "p0");
        m.checkNotNullExpressionValue(this.function.invoke(tabLayout$Tab, Integer.valueOf(i)), "invoke(...)");
    }
}
