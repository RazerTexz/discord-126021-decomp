package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCreationIntentBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialCardView f2360b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialCardView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LinkifiedTextView f;

    public WidgetCreationIntentBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView2, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = coordinatorLayout;
        this.f2360b = materialCardView;
        this.c = textView;
        this.d = materialCardView2;
        this.e = textView2;
        this.f = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
