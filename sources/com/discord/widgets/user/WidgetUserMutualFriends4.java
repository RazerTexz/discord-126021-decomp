package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetUserMutualFriendsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMutualFriends$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMutualFriends4 extends FunctionReferenceImpl implements Function1<View, WidgetUserMutualFriendsBinding> {
    public static final WidgetUserMutualFriends4 INSTANCE = new WidgetUserMutualFriends4();

    public WidgetUserMutualFriends4() {
        super(1, WidgetUserMutualFriendsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMutualFriendsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMutualFriendsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.user_mutual_friends_recycler_view);
        if (recyclerView != null) {
            return new WidgetUserMutualFriendsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.user_mutual_friends_recycler_view)));
    }
}
