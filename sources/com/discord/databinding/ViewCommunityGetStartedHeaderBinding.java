package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCommunityGetStartedHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15401a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15402b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15403c;

    public ViewCommunityGetStartedHeaderBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f15401a = view;
        this.f15402b = imageView;
        this.f15403c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15401a;
    }
}
