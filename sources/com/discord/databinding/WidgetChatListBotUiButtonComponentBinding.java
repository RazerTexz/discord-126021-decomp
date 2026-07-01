package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListBotUiButtonComponentBinding implements ViewBinding {

    @NonNull
    public final ButtonComponentView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2344b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final MaterialTextView d;

    @NonNull
    public final AppCompatImageView e;

    @NonNull
    public final TypingDots f;

    public WidgetChatListBotUiButtonComponentBinding(@NonNull ButtonComponentView buttonComponentView, @NonNull MaterialButton materialButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull TypingDots typingDots) {
        this.a = buttonComponentView;
        this.f2344b = materialButton;
        this.c = simpleDraweeView;
        this.d = materialTextView;
        this.e = appCompatImageView;
        this.f = typingDots;
    }

    @NonNull
    public static WidgetChatListBotUiButtonComponentBinding a(@NonNull View view) {
        int i = R.id.button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.button);
        if (materialButton != null) {
            i = R.id.emoji;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.emoji);
            if (simpleDraweeView != null) {
                i = R.id.label;
                MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.label);
                if (materialTextView != null) {
                    i = R.id.link_icon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.link_icon);
                    if (appCompatImageView != null) {
                        i = R.id.loading_dots;
                        TypingDots typingDots = (TypingDots) view.findViewById(R.id.loading_dots);
                        if (typingDots != null) {
                            return new WidgetChatListBotUiButtonComponentBinding((ButtonComponentView) view, materialButton, simpleDraweeView, materialTextView, appCompatImageView, typingDots);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
