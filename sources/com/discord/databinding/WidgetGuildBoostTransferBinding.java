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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2408b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final GuildBoostConfirmationView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final GuildBoostConfirmationView h;

    @NonNull
    public final TextView i;

    public WidgetGuildBoostTransferBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildBoostConfirmationView guildBoostConfirmationView, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull GuildBoostConfirmationView guildBoostConfirmationView2, @NonNull TextView textView4) {
        this.a = coordinatorLayout;
        this.f2408b = dimmerView;
        this.c = textView;
        this.d = textView2;
        this.e = guildBoostConfirmationView;
        this.f = textView3;
        this.g = materialButton;
        this.h = guildBoostConfirmationView2;
        this.i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
