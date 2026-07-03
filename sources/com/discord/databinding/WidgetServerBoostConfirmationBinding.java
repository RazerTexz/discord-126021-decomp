package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerBoostConfirmationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17461a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildBoostConfirmationView f17462b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17463c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17464d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f17465e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final DimmerView f17466f;

    public WidgetServerBoostConfirmationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull GuildBoostConfirmationView guildBoostConfirmationView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull DimmerView dimmerView) {
        this.f17461a = coordinatorLayout;
        this.f17462b = guildBoostConfirmationView;
        this.f17463c = textView;
        this.f17464d = textView2;
        this.f17465e = materialButton;
        this.f17466f = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17461a;
    }
}
