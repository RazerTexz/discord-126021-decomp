package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelAudienceRoleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18137a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18138b;

    public WidgetStageChannelAudienceRoleBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.f18137a = constraintLayout;
        this.f18138b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18137a;
    }
}
