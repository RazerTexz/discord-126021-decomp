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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2440b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final GuildSubscriptionRoleImageUploadView g;

    @NonNull
    public final GuildRoleSubscriptionMemberPreview h;

    @NonNull
    public final GuildRoleSubscriptionMemberPreview i;

    public WidgetGuildRoleSubscriptionTierDesignBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, @NonNull GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview, @NonNull GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview2) {
        this.a = linearLayout;
        this.f2440b = view;
        this.c = linearLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = guildSubscriptionRoleImageUploadView;
        this.h = guildRoleSubscriptionMemberPreview;
        this.i = guildRoleSubscriptionMemberPreview2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
