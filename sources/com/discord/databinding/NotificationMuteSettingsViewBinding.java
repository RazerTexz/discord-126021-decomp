package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationMuteSettingsViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15193a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15194b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15195c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15196d;

    public NotificationMuteSettingsViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15193a = linearLayout;
        this.f15194b = textView;
        this.f15195c = textView2;
        this.f15196d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15193a;
    }
}
