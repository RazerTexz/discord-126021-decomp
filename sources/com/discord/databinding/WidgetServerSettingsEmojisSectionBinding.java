package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEmojisSectionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17653a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17654b;

    public WidgetServerSettingsEmojisSectionBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f17653a = linearLayout;
        this.f17654b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17653a;
    }
}
