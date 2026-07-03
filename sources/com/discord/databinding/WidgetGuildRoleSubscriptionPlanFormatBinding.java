package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanFormatRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionPlanFormatBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16933a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16934b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16935c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16936d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GuildRoleSubscriptionPlanFormatRadioButton f16937e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final GuildRoleSubscriptionPlanFormatRadioButton f16938f;

    public WidgetGuildRoleSubscriptionPlanFormatBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton, @NonNull GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2) {
        this.f16933a = linearLayout;
        this.f16934b = view;
        this.f16935c = textView;
        this.f16936d = textView2;
        this.f16937e = guildRoleSubscriptionPlanFormatRadioButton;
        this.f16938f = guildRoleSubscriptionPlanFormatRadioButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16933a;
    }
}
