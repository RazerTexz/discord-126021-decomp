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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2332b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final TextView g;

    @NonNull
    public final StageCardSpeakersView h;

    public WidgetChatListAdapterItemStageInviteBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView4, @NonNull MaterialButton materialButton, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView5, @NonNull StageCardSpeakersView stageCardSpeakersView) {
        this.a = constraintLayout;
        this.f2332b = textView;
        this.c = textView2;
        this.d = simpleDraweeView;
        this.e = textView4;
        this.f = materialButton;
        this.g = textView5;
        this.h = stageCardSpeakersView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
