package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelFollowSuccessDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f15841a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15842b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15843c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15844d;

    public WidgetChannelFollowSuccessDialogBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f15841a = nestedScrollView;
        this.f15842b = materialButton;
        this.f15843c = simpleDraweeView;
        this.f15844d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15841a;
    }
}
