package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ServerFolderView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemFolderBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ServerFolderView f2460b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final View d;

    @NonNull
    public final TextView e;

    @NonNull
    public final View f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    public WidgetGuildsListItemFolderBinding(@NonNull RelativeLayout relativeLayout, @NonNull ServerFolderView serverFolderView, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull TextView textView, @NonNull View view2, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.a = relativeLayout;
        this.f2460b = serverFolderView;
        this.c = frameLayout;
        this.d = view;
        this.e = textView;
        this.f = view2;
        this.g = imageView;
        this.h = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
