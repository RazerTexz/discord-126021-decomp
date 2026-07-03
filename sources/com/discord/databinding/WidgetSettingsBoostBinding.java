package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C1055t3;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsBoostBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17920a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1055t3 f17921b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f17922c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GuildBoostMarketingView f17923d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f17924e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f17925f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final RecyclerView f17926g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LinkifiedTextView f17927h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final LinearLayout f17928i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final GuildBoostSubscriptionUpsellView f17929j;

    public WidgetSettingsBoostBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull C1055t3 c1055t3, @NonNull AppViewFlipper appViewFlipper, @NonNull GuildBoostMarketingView guildBoostMarketingView, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton, @NonNull RecyclerView recyclerView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout, @NonNull GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView) {
        this.f17920a = coordinatorLayout;
        this.f17921b = c1055t3;
        this.f17922c = appViewFlipper;
        this.f17923d = guildBoostMarketingView;
        this.f17924e = recyclerView;
        this.f17925f = materialButton;
        this.f17926g = recyclerView2;
        this.f17927h = linkifiedTextView;
        this.f17928i = linearLayout;
        this.f17929j = guildBoostSubscriptionUpsellView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17920a;
    }
}
