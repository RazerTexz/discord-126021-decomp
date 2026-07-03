package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanFormatBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanFormat$binding$2 extends C12236k implements Function1<View, WidgetGuildRoleSubscriptionPlanFormatBinding> {
    public static final WidgetGuildRoleSubscriptionPlanFormat$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionPlanFormat$binding$2();

    public WidgetGuildRoleSubscriptionPlanFormat$binding$2() {
        super(1, WidgetGuildRoleSubscriptionPlanFormatBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanFormatBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionPlanFormatBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_role_subscription_format_divider;
        View viewFindViewById = view.findViewById(C5419R.id.guild_role_subscription_format_divider);
        if (viewFindViewById != null) {
            i = C5419R.id.guild_role_subscription_format_subtitle;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_role_subscription_format_subtitle);
            if (textView != null) {
                i = C5419R.id.guild_role_subscription_format_title;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_format_title);
                if (textView2 != null) {
                    i = C5419R.id.guild_role_subscription_plan_entire_server_format;
                    GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton = (GuildRoleSubscriptionPlanFormatRadioButton) view.findViewById(C5419R.id.guild_role_subscription_plan_entire_server_format);
                    if (guildRoleSubscriptionPlanFormatRadioButton != null) {
                        i = C5419R.id.guild_role_subscription_plan_some_channels_format;
                        GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2 = (GuildRoleSubscriptionPlanFormatRadioButton) view.findViewById(C5419R.id.guild_role_subscription_plan_some_channels_format);
                        if (guildRoleSubscriptionPlanFormatRadioButton2 != null) {
                            return new WidgetGuildRoleSubscriptionPlanFormatBinding((LinearLayout) view, viewFindViewById, textView, textView2, guildRoleSubscriptionPlanFormatRadioButton, guildRoleSubscriptionPlanFormatRadioButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
