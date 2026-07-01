package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListContactSyncUpsellBinding implements ViewBinding {

    @NonNull
    public final MaterialCardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialCardView f2397b;

    public WidgetFriendsListContactSyncUpsellBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = materialCardView;
        this.f2397b = materialCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
