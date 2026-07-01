package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewImageBinding implements ViewBinding {

    @NonNull
    public final SimpleDraweeView a;

    public ViewImageBinding(@NonNull SimpleDraweeView simpleDraweeView) {
        this.a = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
