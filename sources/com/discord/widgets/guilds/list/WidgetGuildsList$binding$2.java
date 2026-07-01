package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildsListBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildsList$binding$2 extends k implements Function1<View, WidgetGuildsListBinding> {
    public static final WidgetGuildsList$binding$2 INSTANCE = new WidgetGuildsList$binding$2();

    public WidgetGuildsList$binding$2() {
        super(1, WidgetGuildsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildsListBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.guild_list);
        if (recyclerView != null) {
            i = R$id.guild_list_unreads_stub;
            ViewStub viewStub = (ViewStub) view.findViewById(R$id.guild_list_unreads_stub);
            if (viewStub != null) {
                return new WidgetGuildsListBinding((RelativeLayout) view, recyclerView, viewStub);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
