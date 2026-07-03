package com.discord.widgets.nux;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.databinding.WidgetNavigationHelpBinding;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNavigationHelp$binding$2 extends C12236k implements Function1<View, WidgetNavigationHelpBinding> {
    public static final WidgetNavigationHelp$binding$2 INSTANCE = new WidgetNavigationHelp$binding$2();

    public WidgetNavigationHelp$binding$2() {
        super(1, WidgetNavigationHelpBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNavigationHelpBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetNavigationHelpBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.navigation_help_close;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.navigation_help_close);
        if (imageView != null) {
            i = C5419R.id.navigation_help_indicators;
            TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.navigation_help_indicators);
            if (tabLayout != null) {
                i = C5419R.id.navigation_help_nux_pager;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C5419R.id.navigation_help_nux_pager);
                if (viewPager2 != null) {
                    return new WidgetNavigationHelpBinding((LinearLayout) view, imageView, tabLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
