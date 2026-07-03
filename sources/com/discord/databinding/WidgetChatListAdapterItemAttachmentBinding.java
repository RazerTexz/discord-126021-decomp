package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.list.InlineMediaView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemAttachmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16144a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16145b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16146c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialCardView f16147d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16148e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16149f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f16150g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final InlineMediaView f16151h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f16152i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final FrameLayout f16153j;

    public WidgetChatListAdapterItemAttachmentBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull Barrier barrier, @NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull InlineMediaView inlineMediaView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull Guideline guideline) {
        this.f16144a = constraintLayout;
        this.f16145b = view;
        this.f16146c = view2;
        this.f16147d = materialCardView;
        this.f16148e = textView;
        this.f16149f = imageView;
        this.f16150g = imageView2;
        this.f16151h = inlineMediaView;
        this.f16152i = textView2;
        this.f16153j = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16144a;
    }
}
