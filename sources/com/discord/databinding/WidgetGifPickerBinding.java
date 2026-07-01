package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.input.gifpicker.GifLoadingView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGifPickerBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2401b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final GifLoadingView d;

    public WidgetGifPickerBinding(@NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout2, @NonNull GifLoadingView gifLoadingView) {
        this.a = frameLayout;
        this.f2401b = recyclerView;
        this.c = frameLayout2;
        this.d = gifLoadingView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
