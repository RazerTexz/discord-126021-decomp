package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class SettingsChannelListCategoryItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15230a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15231b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15232c;

    public SettingsChannelListCategoryItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f15230a = relativeLayout;
        this.f15231b = imageView;
        this.f15232c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15230a;
    }
}
