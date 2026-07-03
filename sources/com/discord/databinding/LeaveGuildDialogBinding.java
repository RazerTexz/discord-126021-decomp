package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class LeaveGuildDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15177a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15178b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f15179c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15180d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15181e;

    public LeaveGuildDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f15177a = linearLayout;
        this.f15178b = materialButton;
        this.f15179c = loadingButton;
        this.f15180d = textView;
        this.f15181e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15177a;
    }
}
