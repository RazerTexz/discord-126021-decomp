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

    @NonNull
    public final ContentResizingCoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ContentResizingCoordinatorLayout f2400b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final GifLoadingView d;

    @NonNull
    public final TextView e;

    public WidgetGifCategoryBinding(@NonNull ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, @NonNull ContentResizingCoordinatorLayout contentResizingCoordinatorLayout2, @NonNull RecyclerView recyclerView, @NonNull GifLoadingView gifLoadingView, @NonNull TextView textView) {
        this.a = contentResizingCoordinatorLayout;
        this.f2400b = contentResizingCoordinatorLayout2;
        this.c = recyclerView;
        this.d = gifLoadingView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
