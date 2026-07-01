package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCommunityGetStartedHeaderBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2181b;

    @NonNull
    public final TextView c;

    public ViewCommunityGetStartedHeaderBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = view;
        this.f2181b = imageView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
