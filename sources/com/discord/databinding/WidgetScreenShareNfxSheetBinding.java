package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17416a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17417b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17418c;

    public WidgetScreenShareNfxSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull MaterialButton materialButton) {
        this.f17416a = nestedScrollView;
        this.f17417b = textView;
        this.f17418c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17416a;
    }
}
