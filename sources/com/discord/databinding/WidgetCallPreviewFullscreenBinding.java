package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C1031q0;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15783a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Toolbar f15784b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppBarLayout f15785c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f15786d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15787e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ConstraintLayout f15788f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ConstraintLayout f15789g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f15790h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f15791i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ViewStub f15792j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final RecyclerView f15793k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final C1031q0 f15794l;

    public WidgetCallPreviewFullscreenBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ViewStub viewStub, @NonNull RecyclerView recyclerView, @NonNull C1031q0 c1031q0) {
        this.f15783a = constraintLayout;
        this.f15784b = toolbar;
        this.f15785c = appBarLayout;
        this.f15786d = constraintLayout2;
        this.f15787e = textView;
        this.f15788f = constraintLayout3;
        this.f15789g = constraintLayout4;
        this.f15790h = materialButton;
        this.f15791i = materialButton2;
        this.f15792j = viewStub;
        this.f15793k = recyclerView;
        this.f15794l = c1031q0;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15783a;
    }
}
