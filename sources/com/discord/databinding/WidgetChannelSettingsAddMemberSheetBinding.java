package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15904a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15905b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FragmentContainerView f15906c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15907d;

    public WidgetChannelSettingsAddMemberSheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull FragmentContainerView fragmentContainerView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15904a = linearLayout;
        this.f15905b = textView;
        this.f15906c = fragmentContainerView;
        this.f15907d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15904a;
    }
}
