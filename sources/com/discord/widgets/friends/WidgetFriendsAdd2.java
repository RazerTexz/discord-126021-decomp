package com.discord.widgets.friends;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetFriendsAddBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAdd$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAdd2 extends FunctionReferenceImpl implements Function1<View, WidgetFriendsAddBinding> {
    public static final WidgetFriendsAdd2 INSTANCE = new WidgetFriendsAdd2();

    public WidgetFriendsAdd2() {
        super(1, WidgetFriendsAddBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsAddBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFriendsAddBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_tabs;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.action_bar_tabs);
        if (tabLayout != null) {
            i = R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = R.id.add_friend_view_pager;
                SimplePager simplePager = (SimplePager) view.findViewById(R.id.add_friend_view_pager);
                if (simplePager != null) {
                    return new WidgetFriendsAddBinding((CoordinatorLayout) view, tabLayout, appBarLayout, simplePager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
