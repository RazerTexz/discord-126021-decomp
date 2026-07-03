package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputEmojiAutocompleteUpsellItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16117a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final PileView f16118b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16119c;

    public WidgetChatInputEmojiAutocompleteUpsellItemBinding(@NonNull LinearLayout linearLayout, @NonNull PileView pileView, @NonNull TextView textView) {
        this.f16117a = linearLayout;
        this.f16118b = pileView;
        this.f16119c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16117a;
    }
}
