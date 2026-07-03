package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemEmptyPinsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16200a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16201b;

    public WidgetChatListAdapterItemEmptyPinsBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f16200a = relativeLayout;
        this.f16201b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16200a;
    }
}
