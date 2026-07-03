package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemResultCountBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f16272a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16273b;

    public WidgetChatListAdapterItemResultCountBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f16272a = textView;
        this.f16273b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16272a;
    }
}
