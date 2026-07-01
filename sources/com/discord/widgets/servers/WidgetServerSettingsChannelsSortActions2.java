package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsChannelsSortActionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannelsSortActions2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsChannelsSortActionsBinding> {
    public static final WidgetServerSettingsChannelsSortActions2 INSTANCE = new WidgetServerSettingsChannelsSortActions2();

    public WidgetServerSettingsChannelsSortActions2() {
        super(1, WidgetServerSettingsChannelsSortActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsChannelsSortActionsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.server_settings_channels_sort_actions_category;
            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_channels_sort_actions_category);
            if (textView2 != null) {
                i = R.id.server_settings_channels_sort_actions_text;
                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_channels_sort_actions_text);
                if (textView3 != null) {
                    i = R.id.server_settings_channels_sort_actions_voice;
                    TextView textView4 = (TextView) view.findViewById(R.id.server_settings_channels_sort_actions_voice);
                    if (textView4 != null) {
                        return new WidgetServerSettingsChannelsSortActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
