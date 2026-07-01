package com.discord.widgets.channels;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSelectorBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSelector$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSelector5 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSelectorBinding> {
    public static final WidgetChannelSelector5 INSTANCE = new WidgetChannelSelector5();

    public WidgetChannelSelector5() {
        super(1, WidgetChannelSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSelectorBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_selector_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.channel_selector_list);
        if (recyclerView != null) {
            i = R.id.guild_actions_overview_header_tv;
            TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
            if (textView != null) {
                return new WidgetChannelSelectorBinding((NestedScrollView) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
