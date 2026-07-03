package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemMessageHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16256a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16257b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16258c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16259d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final Space f16260e;

    public WidgetChatListAdapterItemMessageHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull Space space) {
        this.f16256a = relativeLayout;
        this.f16257b = textView;
        this.f16258c = view;
        this.f16259d = textView2;
        this.f16260e = space;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16256a;
    }
}
