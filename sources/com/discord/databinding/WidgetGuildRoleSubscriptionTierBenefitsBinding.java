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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16955a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialRadioButton f16956b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16957c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16958d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16959e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RadioGroup f16960f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialRadioButton f16961g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final RecyclerView f16962h;

    public WidgetGuildRoleSubscriptionTierBenefitsBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RadioGroup radioGroup, @NonNull MaterialRadioButton materialRadioButton2, @NonNull RecyclerView recyclerView) {
        this.f16955a = linearLayout;
        this.f16956b = materialRadioButton;
        this.f16957c = view;
        this.f16958d = textView;
        this.f16959e = textView2;
        this.f16960f = radioGroup;
        this.f16961g = materialRadioButton2;
        this.f16962h = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16955a;
    }
}
