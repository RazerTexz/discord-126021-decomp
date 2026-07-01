package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsChannelsSortActionsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannelsSortActions$binding$2 extends k implements Function1<View, WidgetServerSettingsChannelsSortActionsBinding> {
    public static final WidgetServerSettingsChannelsSortActions$binding$2 INSTANCE = new WidgetServerSettingsChannelsSortActions$binding$2();

    public WidgetServerSettingsChannelsSortActions$binding$2() {
        super(1, WidgetServerSettingsChannelsSortActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsSortActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsSortActionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R$id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R$id.server_settings_channels_sort_actions_category;
            TextView textView2 = (TextView) view.findViewById(R$id.server_settings_channels_sort_actions_category);
            if (textView2 != null) {
                i = R$id.server_settings_channels_sort_actions_text;
                TextView textView3 = (TextView) view.findViewById(R$id.server_settings_channels_sort_actions_text);
                if (textView3 != null) {
                    i = R$id.server_settings_channels_sort_actions_voice;
                    TextView textView4 = (TextView) view.findViewById(R$id.server_settings_channels_sort_actions_voice);
                    if (textView4 != null) {
                        return new WidgetServerSettingsChannelsSortActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
