package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildScheduledEventListBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17009a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17010b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f17011c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f17012d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17013e;

    public WidgetGuildScheduledEventListBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView4) {
        this.f17009a = constraintLayout;
        this.f17010b = textView;
        this.f17011c = constraintLayout2;
        this.f17012d = recyclerView;
        this.f17013e = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17009a;
    }
}
