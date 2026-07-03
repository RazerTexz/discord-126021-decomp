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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15152a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15153b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15154c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15155d;

    public GuildScheduledEventRsvpUserListAdapterItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull TextView textView2) {
        this.f15152a = relativeLayout;
        this.f15153b = simpleDraweeView;
        this.f15154c = textView;
        this.f15155d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15152a;
    }
}
