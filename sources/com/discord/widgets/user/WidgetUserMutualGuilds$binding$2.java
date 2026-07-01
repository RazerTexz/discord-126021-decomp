package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetUserMutualGuildsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMutualGuilds$binding$2 extends k implements Function1<View, WidgetUserMutualGuildsBinding> {
    public static final WidgetUserMutualGuilds$binding$2 INSTANCE = new WidgetUserMutualGuilds$binding$2();

    public WidgetUserMutualGuilds$binding$2() {
        super(1, WidgetUserMutualGuildsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMutualGuildsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMutualGuildsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.user_mutual_guilds_recycler_view);
        if (recyclerView != null) {
            return new WidgetUserMutualGuildsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.user_mutual_guilds_recycler_view)));
    }
}
