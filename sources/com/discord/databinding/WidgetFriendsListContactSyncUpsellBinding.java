package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListContactSyncUpsellBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final MaterialCardView f16681a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialCardView f16682b;

    public WidgetFriendsListContactSyncUpsellBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f16681a = materialCardView;
        this.f16682b = materialCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16681a;
    }
}
