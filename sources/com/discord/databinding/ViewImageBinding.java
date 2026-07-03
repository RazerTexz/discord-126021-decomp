package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final SimpleDraweeView f15498a;

    public ViewImageBinding(@NonNull SimpleDraweeView simpleDraweeView) {
        this.f15498a = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15498a;
    }
}
