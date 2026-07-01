package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class NuxGuildTemplateCardViewHolderBinding implements ViewBinding {

    @NonNull
    public final MaterialCardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialCardView f2132b;

    @NonNull
    public final TextView c;

    public NuxGuildTemplateCardViewHolderBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView) {
        this.a = materialCardView;
        this.f2132b = materialCardView2;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
