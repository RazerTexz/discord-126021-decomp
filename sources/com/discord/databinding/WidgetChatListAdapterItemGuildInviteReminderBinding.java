package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemGuildInviteReminderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16222a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16223b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16224c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16225d;

    public WidgetChatListAdapterItemGuildInviteReminderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f16222a = constraintLayout;
        this.f16223b = materialButton;
        this.f16224c = textView;
        this.f16225d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16222a;
    }
}
