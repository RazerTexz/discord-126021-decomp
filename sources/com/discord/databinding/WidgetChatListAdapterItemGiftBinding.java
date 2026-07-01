package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemGiftBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2320b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final SimpleDraweeView g;

    @NonNull
    public final SimpleDraweeView h;

    @NonNull
    public final View i;

    @NonNull
    public final TextView j;

    @NonNull
    public final MaterialButton k;

    @NonNull
    public final TextView l;

    @NonNull
    public final MaterialButton m;

    public WidgetChatListAdapterItemGiftBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull View view, @NonNull TextView textView3, @NonNull MaterialButton materialButton3, @NonNull TextView textView4, @NonNull MaterialButton materialButton4, @NonNull ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.f2320b = frameLayout;
        this.c = materialButton;
        this.d = materialButton2;
        this.e = textView;
        this.f = textView2;
        this.g = simpleDraweeView;
        this.h = simpleDraweeView2;
        this.i = view;
        this.j = textView3;
        this.k = materialButton3;
        this.l = textView4;
        this.m = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
