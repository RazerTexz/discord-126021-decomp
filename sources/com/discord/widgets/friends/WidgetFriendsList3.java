package com.discord.widgets.friends;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetFriendsListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsList3 extends FunctionReferenceImpl implements Function1<View, WidgetFriendsListBinding> {
    public static final WidgetFriendsList3 INSTANCE = new WidgetFriendsList3();

    public WidgetFriendsList3() {
        super(1, WidgetFriendsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFriendsListBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.friends_list_empty_friends_state_view;
        EmptyFriendsStateView emptyFriendsStateView = (EmptyFriendsStateView) view.findViewById(R.id.friends_list_empty_friends_state_view);
        if (emptyFriendsStateView != null) {
            i = R.id.friends_list_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.friends_list_flipper);
            if (appViewFlipper != null) {
                i = R.id.friends_list_loading;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.friends_list_loading);
                if (recyclerView != null) {
                    i = R.id.friends_list_recycler;
                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.friends_list_recycler);
                    if (recyclerView2 != null) {
                        return new WidgetFriendsListBinding((RelativeLayout) view, emptyFriendsStateView, appViewFlipper, recyclerView, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
