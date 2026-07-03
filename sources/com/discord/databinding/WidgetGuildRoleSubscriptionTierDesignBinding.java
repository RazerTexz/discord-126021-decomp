package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionTierDesignBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16963a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16964b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f16965c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16966d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16967e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16968f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final GuildSubscriptionRoleImageUploadView f16969g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final GuildRoleSubscriptionMemberPreview f16970h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final GuildRoleSubscriptionMemberPreview f16971i;

    public WidgetGuildRoleSubscriptionTierDesignBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, @NonNull GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview, @NonNull GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview2) {
        this.f16963a = linearLayout;
        this.f16964b = view;
        this.f16965c = linearLayout2;
        this.f16966d = textView;
        this.f16967e = textView2;
        this.f16968f = textView3;
        this.f16969g = guildSubscriptionRoleImageUploadView;
        this.f16970h = guildRoleSubscriptionMemberPreview;
        this.f16971i = guildRoleSubscriptionMemberPreview2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16963a;
    }
}
