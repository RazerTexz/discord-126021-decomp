package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemBlockedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16167a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16168b;

    public WidgetChatListAdapterItemBlockedBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.f16167a = relativeLayout;
        this.f16168b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16167a;
    }
}
