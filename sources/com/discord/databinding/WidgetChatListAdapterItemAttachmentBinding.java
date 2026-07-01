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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2309b;

    @NonNull
    public final View c;

    @NonNull
    public final MaterialCardView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final InlineMediaView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final FrameLayout j;

    public WidgetChatListAdapterItemAttachmentBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull Barrier barrier, @NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull InlineMediaView inlineMediaView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull Guideline guideline) {
        this.a = constraintLayout;
        this.f2309b = view;
        this.c = view2;
        this.d = materialCardView;
        this.e = textView;
        this.f = imageView;
        this.g = imageView2;
        this.h = inlineMediaView;
        this.i = textView2;
        this.j = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
