package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import com.discord.widgets.chat.input.gifpicker.GifLoadingView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGifCategoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ContentResizingCoordinatorLayout f16693a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ContentResizingCoordinatorLayout f16694b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f16695c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GifLoadingView f16696d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16697e;

    public WidgetGifCategoryBinding(@NonNull ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, @NonNull ContentResizingCoordinatorLayout contentResizingCoordinatorLayout2, @NonNull RecyclerView recyclerView, @NonNull GifLoadingView gifLoadingView, @NonNull TextView textView) {
        this.f16693a = contentResizingCoordinatorLayout;
        this.f16694b = contentResizingCoordinatorLayout2;
        this.f16695c = recyclerView;
        this.f16696d = gifLoadingView;
        this.f16697e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16693a;
    }
}
