package com.discord.widgets.channels;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelSelectorBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSelector$binding$2 extends k implements Function1<View, WidgetChannelSelectorBinding> {
    public static final WidgetChannelSelector$binding$2 INSTANCE = new WidgetChannelSelector$binding$2();

    public WidgetChannelSelector$binding$2() {
        super(1, WidgetChannelSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSelectorBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.channel_selector_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.channel_selector_list);
        if (recyclerView != null) {
            i = R$id.guild_actions_overview_header_tv;
            TextView textView = (TextView) view.findViewById(R$id.guild_actions_overview_header_tv);
            if (textView != null) {
                return new WidgetChannelSelectorBinding((NestedScrollView) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
