package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserMutualGuildsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMutualGuilds$binding$2 extends C12236k implements Function1<View, WidgetUserMutualGuildsBinding> {
    public static final WidgetUserMutualGuilds$binding$2 INSTANCE = new WidgetUserMutualGuilds$binding$2();

    public WidgetUserMutualGuilds$binding$2() {
        super(1, WidgetUserMutualGuildsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMutualGuildsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.user_mutual_guilds_recycler_view);
        if (recyclerView != null) {
            return new WidgetUserMutualGuildsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.user_mutual_guilds_recycler_view)));
    }
}
