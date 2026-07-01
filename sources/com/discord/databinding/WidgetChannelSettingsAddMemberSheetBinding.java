package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberSheetBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2272b;

    @NonNull
    public final FragmentContainerView c;

    @NonNull
    public final TextView d;

    public WidgetChannelSettingsAddMemberSheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull FragmentContainerView fragmentContainerView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f2272b = textView;
        this.c = fragmentContainerView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
