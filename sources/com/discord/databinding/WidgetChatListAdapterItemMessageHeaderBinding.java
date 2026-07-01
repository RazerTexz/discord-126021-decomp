package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemMessageHeaderBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2327b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    @NonNull
    public final Space e;

    public WidgetChatListAdapterItemMessageHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull Space space) {
        this.a = relativeLayout;
        this.f2327b = textView;
        this.c = view;
        this.d = textView2;
        this.e = space;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
