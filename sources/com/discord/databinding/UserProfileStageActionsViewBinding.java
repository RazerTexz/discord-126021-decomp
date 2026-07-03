package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class UserProfileStageActionsViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15352a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15353b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15354c;

    public UserProfileStageActionsViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15352a = linearLayout;
        this.f15353b = textView;
        this.f15354c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15352a;
    }
}
