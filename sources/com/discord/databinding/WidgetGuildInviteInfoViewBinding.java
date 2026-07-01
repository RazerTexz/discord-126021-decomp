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

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2415b;

    @NonNull
    public final GuildView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final ServerMemberCount e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetGuildInviteInfoViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull GuildView guildView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ServerMemberCount serverMemberCount, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout) {
        this.a = view;
        this.f2415b = materialButton;
        this.c = guildView;
        this.d = simpleDraweeView;
        this.e = serverMemberCount;
        this.f = textView;
        this.g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
