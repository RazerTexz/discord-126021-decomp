package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class RoleIconViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15228a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15229b;

    public RoleIconViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView) {
        this.f15228a = view;
        this.f15229b = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15228a;
    }
}
