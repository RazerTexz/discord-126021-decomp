package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewSettingsBoostedGuildListitemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15573a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15574b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f15575c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GuildBoostProgressView f15576d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15577e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f15578f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15579g;

    public ViewSettingsBoostedGuildListitemBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull View view, @NonNull GuildBoostProgressView guildBoostProgressView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2) {
        this.f15573a = linearLayout;
        this.f15574b = simpleDraweeView;
        this.f15575c = view;
        this.f15576d = guildBoostProgressView;
        this.f15577e = textView;
        this.f15578f = simpleDraweeView2;
        this.f15579g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15573a;
    }
}
