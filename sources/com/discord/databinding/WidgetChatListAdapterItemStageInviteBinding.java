package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.stages.StageCardSpeakersView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemStageInviteBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16282a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16283b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16284c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f16285d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16286e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f16287f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16288g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final StageCardSpeakersView f16289h;

    public WidgetChatListAdapterItemStageInviteBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView4, @NonNull MaterialButton materialButton, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView5, @NonNull StageCardSpeakersView stageCardSpeakersView) {
        this.f16282a = constraintLayout;
        this.f16283b = textView;
        this.f16284c = textView2;
        this.f16285d = simpleDraweeView;
        this.f16286e = textView4;
        this.f16287f = materialButton;
        this.f16288g = textView5;
        this.f16289h = stageCardSpeakersView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16282a;
    }
}
