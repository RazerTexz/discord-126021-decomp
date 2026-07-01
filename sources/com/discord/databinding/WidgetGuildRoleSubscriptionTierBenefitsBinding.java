package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionTierBenefitsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialRadioButton f2439b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final RadioGroup f;

    @NonNull
    public final MaterialRadioButton g;

    @NonNull
    public final RecyclerView h;

    public WidgetGuildRoleSubscriptionTierBenefitsBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RadioGroup radioGroup, @NonNull MaterialRadioButton materialRadioButton2, @NonNull RecyclerView recyclerView) {
        this.a = linearLayout;
        this.f2439b = materialRadioButton;
        this.c = view;
        this.d = textView;
        this.e = textView2;
        this.f = radioGroup;
        this.g = materialRadioButton2;
        this.h = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
