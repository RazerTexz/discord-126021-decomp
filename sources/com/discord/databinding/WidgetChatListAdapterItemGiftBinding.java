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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16209a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f16210b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16211c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f16212d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16213e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16214f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final SimpleDraweeView f16215g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final SimpleDraweeView f16216h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final View f16217i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f16218j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final MaterialButton f16219k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f16220l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final MaterialButton f16221m;

    public WidgetChatListAdapterItemGiftBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull View view, @NonNull TextView textView3, @NonNull MaterialButton materialButton3, @NonNull TextView textView4, @NonNull MaterialButton materialButton4, @NonNull ConstraintLayout constraintLayout2) {
        this.f16209a = constraintLayout;
        this.f16210b = frameLayout;
        this.f16211c = materialButton;
        this.f16212d = materialButton2;
        this.f16213e = textView;
        this.f16214f = textView2;
        this.f16215g = simpleDraweeView;
        this.f16216h = simpleDraweeView2;
        this.f16217i = view;
        this.f16218j = textView3;
        this.f16219k = materialButton3;
        this.f16220l = textView4;
        this.f16221m = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16209a;
    }
}
