package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ReactionView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetForumPostStatusBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ProgressBar f2389b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ReactionView f;

    @NonNull
    public final View g;

    public WidgetForumPostStatusBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull ReactionView reactionView, @NonNull View view, @NonNull View view2) {
        this.a = constraintLayout;
        this.f2389b = progressBar;
        this.c = textView;
        this.d = linearLayout;
        this.e = textView2;
        this.f = reactionView;
        this.g = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
