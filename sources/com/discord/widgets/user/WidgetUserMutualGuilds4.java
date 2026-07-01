package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetUserMutualGuildsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMutualGuilds$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMutualGuilds4 extends FunctionReferenceImpl implements Function1<View, WidgetUserMutualGuildsBinding> {
    public static final WidgetUserMutualGuilds4 INSTANCE = new WidgetUserMutualGuilds4();

    public WidgetUserMutualGuilds4() {
        super(1, WidgetUserMutualGuildsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMutualGuildsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.user_mutual_guilds_recycler_view);
        if (recyclerView != null) {
            return new WidgetUserMutualGuildsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.user_mutual_guilds_recycler_view)));
    }
}
