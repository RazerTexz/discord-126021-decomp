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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16643a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ProgressBar f16644b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16645c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinearLayout f16646d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16647e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ReactionView f16648f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final View f16649g;

    public WidgetForumPostStatusBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull ReactionView reactionView, @NonNull View view, @NonNull View view2) {
        this.f16643a = constraintLayout;
        this.f16644b = progressBar;
        this.f16645c = textView;
        this.f16646d = linearLayout;
        this.f16647e = textView2;
        this.f16648f = reactionView;
        this.f16649g = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16643a;
    }
}
