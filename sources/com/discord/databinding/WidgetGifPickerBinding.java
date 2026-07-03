package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.input.gifpicker.GifLoadingView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGifPickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16698a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16699b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f16700c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GifLoadingView f16701d;

    public WidgetGifPickerBinding(@NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout2, @NonNull GifLoadingView gifLoadingView) {
        this.f16698a = frameLayout;
        this.f16699b = recyclerView;
        this.f16700c = frameLayout2;
        this.f16701d = gifLoadingView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16698a;
    }
}
