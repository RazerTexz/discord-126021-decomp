package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserMutualFriendsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMutualFriends$binding$2 extends C12236k implements Function1<View, WidgetUserMutualFriendsBinding> {
    public static final WidgetUserMutualFriends$binding$2 INSTANCE = new WidgetUserMutualFriends$binding$2();

    public WidgetUserMutualFriends$binding$2() {
        super(1, WidgetUserMutualFriendsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMutualFriendsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMutualFriendsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.user_mutual_friends_recycler_view);
        if (recyclerView != null) {
            return new WidgetUserMutualFriendsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.user_mutual_friends_recycler_view)));
    }
}
