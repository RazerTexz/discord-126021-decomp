package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCreateChannelAddMemberBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16417a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FragmentContainerView f16418b;

    public WidgetCreateChannelAddMemberBinding(@NonNull LinearLayout linearLayout, @NonNull FragmentContainerView fragmentContainerView) {
        this.f16417a = linearLayout;
        this.f16418b = fragmentContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16417a;
    }
}
