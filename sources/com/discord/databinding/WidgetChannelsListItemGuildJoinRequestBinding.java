package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemGuildJoinRequestBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16041a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ConstraintLayout f16042b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16043c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16044d;

    public WidgetChannelsListItemGuildJoinRequestBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialButton materialButton, @NonNull TextView textView) {
        this.f16041a = constraintLayout;
        this.f16042b = constraintLayout2;
        this.f16043c = materialButton;
        this.f16044d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16041a;
    }
}
