package com.discord.widgets.nux;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R;
import com.discord.databinding.WidgetNavigationHelpBinding;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNavigationHelp$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNavigationHelp2 extends FunctionReferenceImpl implements Function1<View, WidgetNavigationHelpBinding> {
    public static final WidgetNavigationHelp2 INSTANCE = new WidgetNavigationHelp2();

    public WidgetNavigationHelp2() {
        super(1, WidgetNavigationHelpBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNavigationHelpBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetNavigationHelpBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.navigation_help_close;
        ImageView imageView = (ImageView) view.findViewById(R.id.navigation_help_close);
        if (imageView != null) {
            i = R.id.navigation_help_indicators;
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.navigation_help_indicators);
            if (tabLayout != null) {
                i = R.id.navigation_help_nux_pager;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.navigation_help_nux_pager);
                if (viewPager2 != null) {
                    return new WidgetNavigationHelpBinding((LinearLayout) view, imageView, tabLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
