package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;

/* JADX INFO: loaded from: classes.dex */
public final class UserAkaViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2162b;

    @NonNull
    public final PileView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public UserAkaViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull PileView pileView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = view;
        this.f2162b = textView;
        this.c = pileView;
        this.d = textView2;
        this.e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
