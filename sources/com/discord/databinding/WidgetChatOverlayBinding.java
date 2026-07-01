package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.WidgetChatInputStickerSuggestionsBinding;
import com.discord.views.typing.TypingDots;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatOverlayBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FloatingActionButton f2345b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final TypingDots d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final WidgetChatInputStickerSuggestionsBinding h;

    public WidgetChatOverlayBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull RelativeLayout relativeLayout, @NonNull TypingDots typingDots, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding) {
        this.a = constraintLayout;
        this.f2345b = floatingActionButton;
        this.c = relativeLayout;
        this.d = typingDots;
        this.e = textView;
        this.f = imageView;
        this.g = textView2;
        this.h = widgetChatInputStickerSuggestionsBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
