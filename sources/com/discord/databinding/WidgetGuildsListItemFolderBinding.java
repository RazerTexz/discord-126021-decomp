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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17098a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ServerFolderView f17099b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f17100c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f17101d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17102e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final View f17103f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f17104g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ImageView f17105h;

    public WidgetGuildsListItemFolderBinding(@NonNull RelativeLayout relativeLayout, @NonNull ServerFolderView serverFolderView, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull TextView textView, @NonNull View view2, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f17098a = relativeLayout;
        this.f17099b = serverFolderView;
        this.f17100c = frameLayout;
        this.f17101d = view;
        this.f17102e = textView;
        this.f17103f = view2;
        this.f17104g = imageView;
        this.f17105h = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17098a;
    }
}
