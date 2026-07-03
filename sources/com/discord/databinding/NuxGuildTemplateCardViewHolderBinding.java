package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class NuxGuildTemplateCardViewHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final MaterialCardView f15197a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialCardView f15198b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15199c;

    public NuxGuildTemplateCardViewHolderBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView) {
        this.f15197a = materialCardView;
        this.f15198b = materialCardView2;
        this.f15199c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15197a;
    }
}
