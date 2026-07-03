package com.discord.widgets.channels;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelSelectorBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSelector$binding$2 extends C12236k implements Function1<View, WidgetChannelSelectorBinding> {
    public static final WidgetChannelSelector$binding$2 INSTANCE = new WidgetChannelSelector$binding$2();

    public WidgetChannelSelector$binding$2() {
        super(1, WidgetChannelSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSelectorBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_selector_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.channel_selector_list);
        if (recyclerView != null) {
            i = C5419R.id.guild_actions_overview_header_tv;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
            if (textView != null) {
                return new WidgetChannelSelectorBinding((NestedScrollView) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
