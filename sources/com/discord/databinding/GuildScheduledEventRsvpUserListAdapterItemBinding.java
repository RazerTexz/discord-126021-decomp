package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventRsvpUserListAdapterItemBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2122b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public GuildScheduledEventRsvpUserListAdapterItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull TextView textView2) {
        this.a = relativeLayout;
        this.f2122b = simpleDraweeView;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
