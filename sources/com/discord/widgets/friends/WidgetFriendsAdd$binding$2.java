package com.discord.widgets.friends;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetFriendsAddBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAdd$binding$2 extends C12236k implements Function1<View, WidgetFriendsAddBinding> {
    public static final WidgetFriendsAdd$binding$2 INSTANCE = new WidgetFriendsAdd$binding$2();

    public WidgetFriendsAdd$binding$2() {
        super(1, WidgetFriendsAddBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsAddBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFriendsAddBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_tabs;
        TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.action_bar_tabs);
        if (tabLayout != null) {
            i = C5419R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = C5419R.id.add_friend_view_pager;
                SimplePager simplePager = (SimplePager) view.findViewById(C5419R.id.add_friend_view_pager);
                if (simplePager != null) {
                    return new WidgetFriendsAddBinding((CoordinatorLayout) view, tabLayout, appBarLayout, simplePager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
