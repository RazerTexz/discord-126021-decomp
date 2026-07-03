package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListBotUiButtonComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ButtonComponentView f16356a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16357b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f16358c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialTextView f16359d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppCompatImageView f16360e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TypingDots f16361f;

    public WidgetChatListBotUiButtonComponentBinding(@NonNull ButtonComponentView buttonComponentView, @NonNull MaterialButton materialButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull TypingDots typingDots) {
        this.f16356a = buttonComponentView;
        this.f16357b = materialButton;
        this.f16358c = simpleDraweeView;
        this.f16359d = materialTextView;
        this.f16360e = appCompatImageView;
        this.f16361f = typingDots;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChatListBotUiButtonComponentBinding m8411a(@NonNull View view) {
        int i = C5419R.id.button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.button);
        if (materialButton != null) {
            i = C5419R.id.emoji;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.emoji);
            if (simpleDraweeView != null) {
                i = C5419R.id.label;
                MaterialTextView materialTextView = (MaterialTextView) view.findViewById(C5419R.id.label);
                if (materialTextView != null) {
                    i = C5419R.id.link_icon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.link_icon);
                    if (appCompatImageView != null) {
                        i = C5419R.id.loading_dots;
                        TypingDots typingDots = (TypingDots) view.findViewById(C5419R.id.loading_dots);
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
        return this.f16356a;
    }
}
