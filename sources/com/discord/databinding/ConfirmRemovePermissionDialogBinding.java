package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ConfirmRemovePermissionDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15021a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15022b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15023c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LoadingButton f15024d;

    public ConfirmRemovePermissionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull LinearLayout linearLayout2) {
        this.f15021a = linearLayout;
        this.f15022b = textView;
        this.f15023c = materialButton;
        this.f15024d = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15021a;
    }
}
