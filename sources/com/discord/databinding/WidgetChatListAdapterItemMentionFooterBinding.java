package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemMentionFooterBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16253a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16254b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16255c;

    public WidgetChatListAdapterItemMentionFooterBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull View view2) {
        this.f16253a = linearLayout;
        this.f16254b = view;
        this.f16255c = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16253a;
    }
}
