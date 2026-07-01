package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemMentionFooterBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2326b;

    @NonNull
    public final View c;

    public WidgetChatListAdapterItemMentionFooterBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull View view2) {
        this.a = linearLayout;
        this.f2326b = view;
        this.c = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
