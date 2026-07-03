package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class GuildTemplateChannelsItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15156a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15157b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15158c;

    public GuildTemplateChannelsItemViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f15156a = linearLayout;
        this.f15157b = imageView;
        this.f15158c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15156a;
    }
}
