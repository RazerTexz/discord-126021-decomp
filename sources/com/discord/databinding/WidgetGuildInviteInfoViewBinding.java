package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteInfoViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f16787a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16788b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildView f16789c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f16790d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ServerMemberCount f16791e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16792f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16793g;

    public WidgetGuildInviteInfoViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull GuildView guildView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ServerMemberCount serverMemberCount, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout) {
        this.f16787a = view;
        this.f16788b = materialButton;
        this.f16789c = guildView;
        this.f16790d = simpleDraweeView;
        this.f16791e = serverMemberCount;
        this.f16792f = textView;
        this.f16793g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16787a;
    }
}
