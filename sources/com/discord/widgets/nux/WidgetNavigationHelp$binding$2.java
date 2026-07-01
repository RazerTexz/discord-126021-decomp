package com.discord.widgets.nux;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R$id;
import com.discord.databinding.WidgetNavigationHelpBinding;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNavigationHelp$binding$2 extends k implements Function1<View, WidgetNavigationHelpBinding> {
    public static final WidgetNavigationHelp$binding$2 INSTANCE = new WidgetNavigationHelp$binding$2();

    public WidgetNavigationHelp$binding$2() {
        super(1, WidgetNavigationHelpBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNavigationHelpBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNavigationHelpBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNavigationHelpBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.navigation_help_close;
        ImageView imageView = (ImageView) view.findViewById(R$id.navigation_help_close);
        if (imageView != null) {
            i = R$id.navigation_help_indicators;
            TabLayout tabLayout = (TabLayout) view.findViewById(R$id.navigation_help_indicators);
            if (tabLayout != null) {
                i = R$id.navigation_help_nux_pager;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R$id.navigation_help_nux_pager);
                if (viewPager2 != null) {
                    return new WidgetNavigationHelpBinding((LinearLayout) view, imageView, tabLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
