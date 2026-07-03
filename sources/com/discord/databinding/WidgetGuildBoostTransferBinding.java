package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildBoostTransferBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16740a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f16741b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16742c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16743d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GuildBoostConfirmationView f16744e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16745f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f16746g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final GuildBoostConfirmationView f16747h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f16748i;

    public WidgetGuildBoostTransferBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildBoostConfirmationView guildBoostConfirmationView, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull GuildBoostConfirmationView guildBoostConfirmationView2, @NonNull TextView textView4) {
        this.f16740a = coordinatorLayout;
        this.f16741b = dimmerView;
        this.f16742c = textView;
        this.f16743d = textView2;
        this.f16744e = guildBoostConfirmationView;
        this.f16745f = textView3;
        this.f16746g = materialButton;
        this.f16747h = guildBoostConfirmationView2;
        this.f16748i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16740a;
    }
}
