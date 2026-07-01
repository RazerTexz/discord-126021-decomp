package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanFormatRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionPlanFormatBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2437b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final GuildRoleSubscriptionPlanFormatRadioButton e;

    @NonNull
    public final GuildRoleSubscriptionPlanFormatRadioButton f;

    public WidgetGuildRoleSubscriptionPlanFormatBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton, @NonNull GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2) {
        this.a = linearLayout;
        this.f2437b = view;
        this.c = textView;
        this.d = textView2;
        this.e = guildRoleSubscriptionPlanFormatRadioButton;
        this.f = guildRoleSubscriptionPlanFormatRadioButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
