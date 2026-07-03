package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetConfirmRemoveCommunityDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16402a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16403b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16404c;

    public WidgetConfirmRemoveCommunityDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton2) {
        this.f16402a = linearLayout;
        this.f16403b = materialButton;
        this.f16404c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16402a;
    }
}
