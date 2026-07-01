package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputEmojiAutocompleteUpsellItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final PileView f2306b;

    @NonNull
    public final TextView c;

    public WidgetChatInputEmojiAutocompleteUpsellItemBinding(@NonNull LinearLayout linearLayout, @NonNull PileView pileView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f2306b = pileView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
