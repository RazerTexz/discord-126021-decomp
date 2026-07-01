package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.UserSummaryView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemActiveEventBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2284b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final UserSummaryView h;

    @NonNull
    public final MaterialTextView i;

    public WidgetChannelsListItemActiveEventBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull UserSummaryView userSummaryView, @NonNull MaterialTextView materialTextView) {
        this.a = constraintLayout;
        this.f2284b = imageView;
        this.c = textView;
        this.d = materialButton;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = userSummaryView;
        this.i = materialTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
