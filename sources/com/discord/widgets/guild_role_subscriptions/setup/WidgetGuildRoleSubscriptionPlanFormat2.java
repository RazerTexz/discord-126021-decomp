package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanFormatBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanFormat2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionPlanFormatBinding> {
    public static final WidgetGuildRoleSubscriptionPlanFormat2 INSTANCE = new WidgetGuildRoleSubscriptionPlanFormat2();

    public WidgetGuildRoleSubscriptionPlanFormat2() {
        super(1, WidgetGuildRoleSubscriptionPlanFormatBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanFormatBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionPlanFormatBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_format_divider;
        View viewFindViewById = view.findViewById(R.id.guild_role_subscription_format_divider);
        if (viewFindViewById != null) {
            i = R.id.guild_role_subscription_format_subtitle;
            TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_format_subtitle);
            if (textView != null) {
                i = R.id.guild_role_subscription_format_title;
                TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_format_title);
                if (textView2 != null) {
                    i = R.id.guild_role_subscription_plan_entire_server_format;
                    GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton = (GuildRoleSubscriptionPlanFormatRadioButton) view.findViewById(R.id.guild_role_subscription_plan_entire_server_format);
                    if (guildRoleSubscriptionPlanFormatRadioButton != null) {
                        i = R.id.guild_role_subscription_plan_some_channels_format;
                        GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2 = (GuildRoleSubscriptionPlanFormatRadioButton) view.findViewById(R.id.guild_role_subscription_plan_some_channels_format);
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
