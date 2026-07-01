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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2213b;

    @NonNull
    public final View c;

    @NonNull
    public final GuildBoostProgressView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final TextView g;

    public ViewSettingsBoostedGuildListitemBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull View view, @NonNull GuildBoostProgressView guildBoostProgressView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2213b = simpleDraweeView;
        this.c = view;
        this.d = guildBoostProgressView;
        this.e = textView;
        this.f = simpleDraweeView2;
        this.g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
