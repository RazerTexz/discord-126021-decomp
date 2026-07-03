package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;

/* JADX INFO: loaded from: classes.dex */
public final class UserAkaViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15321a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15322b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final PileView f15323c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15324d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15325e;

    public UserAkaViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull PileView pileView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15321a = view;
        this.f15322b = textView;
        this.f15323c = pileView;
        this.f15324d = textView2;
        this.f15325e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15321a;
    }
}
