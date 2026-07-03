package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackStoreSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18183a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RelativeLayout f18184b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f18185c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f18186d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LoadingButton f18187e;

    public WidgetStickerPackStoreSheetBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LoadingButton loadingButton) {
        this.f18183a = relativeLayout;
        this.f18184b = relativeLayout2;
        this.f18185c = recyclerView;
        this.f18186d = simpleDraweeView;
        this.f18187e = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18183a;
    }
}
