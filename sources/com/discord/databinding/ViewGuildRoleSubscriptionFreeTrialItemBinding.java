package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionFreeTrialItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15468a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15469b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15470c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15471d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f15472e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15473f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15474g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15475h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f15476i;

    public ViewGuildRoleSubscriptionFreeTrialItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7) {
        this.f15468a = linearLayout;
        this.f15469b = textView;
        this.f15470c = textView2;
        this.f15471d = textView3;
        this.f15472e = checkedSetting;
        this.f15473f = textView4;
        this.f15474g = textView5;
        this.f15475h = textView6;
        this.f15476i = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15468a;
    }
}
