package com.discord.widgets.friends;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetFriendsListBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsList$binding$2 extends C12236k implements Function1<View, WidgetFriendsListBinding> {
    public static final WidgetFriendsList$binding$2 INSTANCE = new WidgetFriendsList$binding$2();

    public WidgetFriendsList$binding$2() {
        super(1, WidgetFriendsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFriendsListBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.friends_list_empty_friends_state_view;
        EmptyFriendsStateView emptyFriendsStateView = (EmptyFriendsStateView) view.findViewById(C5419R.id.friends_list_empty_friends_state_view);
        if (emptyFriendsStateView != null) {
            i = C5419R.id.friends_list_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.friends_list_flipper);
            if (appViewFlipper != null) {
                i = C5419R.id.friends_list_loading;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.friends_list_loading);
                if (recyclerView != null) {
                    i = C5419R.id.friends_list_recycler;
                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.friends_list_recycler);
                    if (recyclerView2 != null) {
                        return new WidgetFriendsListBinding((RelativeLayout) view, emptyFriendsStateView, appViewFlipper, recyclerView, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
