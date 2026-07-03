package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.C1009n;

/* JADX INFO: loaded from: classes.dex */
public final class CommandCategoryItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15018a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15019b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1009n f15020c;

    public CommandCategoryItemBinding(@NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull C1009n c1009n) {
        this.f15018a = frameLayout;
        this.f15019b = simpleDraweeView;
        this.f15020c = c1009n;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15018a;
    }
}
