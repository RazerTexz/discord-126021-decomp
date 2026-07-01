package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.ViewSettingsPremiumGuildNoGuildsBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsBoostBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewSettingsPremiumGuildNoGuildsBinding f2612b;

    @NonNull
    public final AppViewFlipper c;

    @NonNull
    public final GuildBoostMarketingView d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final RecyclerView g;

    @NonNull
    public final LinkifiedTextView h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final GuildBoostSubscriptionUpsellView j;

    public WidgetSettingsBoostBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ViewSettingsPremiumGuildNoGuildsBinding viewSettingsPremiumGuildNoGuildsBinding, @NonNull AppViewFlipper appViewFlipper, @NonNull GuildBoostMarketingView guildBoostMarketingView, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton, @NonNull RecyclerView recyclerView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout, @NonNull GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView) {
        this.a = coordinatorLayout;
        this.f2612b = viewSettingsPremiumGuildNoGuildsBinding;
        this.c = appViewFlipper;
        this.d = guildBoostMarketingView;
        this.e = recyclerView;
        this.f = materialButton;
        this.g = recyclerView2;
        this.h = linkifiedTextView;
        this.i = linearLayout;
        this.j = guildBoostSubscriptionUpsellView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
