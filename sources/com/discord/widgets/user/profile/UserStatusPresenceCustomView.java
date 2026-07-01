package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewUserStatusPresenceCustomBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.fresco.GrayscalePostprocessor;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserStatusPresenceCustomView extends LinearLayout {
    private final ViewUserStatusPresenceCustomBinding binding;
    public static final UserStatusPresenceCustomView$Companion Companion = new UserStatusPresenceCustomView$Companion(null);
    private static final GrayscalePostprocessor CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR = new GrayscalePostprocessor();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStatusPresenceCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_user_status_presence_custom, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.user_status_presence_custom_clear;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R$id.user_status_presence_custom_clear);
        if (appCompatImageView != null) {
            i = R$id.user_status_presence_custom_emoji;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.user_status_presence_custom_emoji);
            if (simpleDraweeView != null) {
                i = R$id.user_status_presence_custom_text;
                TextView textView = (TextView) viewInflate.findViewById(R$id.user_status_presence_custom_text);
                if (textView != null) {
                    ViewUserStatusPresenceCustomBinding viewUserStatusPresenceCustomBinding = new ViewUserStatusPresenceCustomBinding((LinearLayout) viewInflate, appCompatImageView, simpleDraweeView, textView);
                    m.checkNotNullExpressionValue(viewUserStatusPresenceCustomBinding, "ViewUserStatusPresenceCu…rom(context), this, true)");
                    this.binding = viewUserStatusPresenceCustomBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ GrayscalePostprocessor access$getCUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR$cp() {
        return CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR;
    }

    private final void configurePlaceholderEmoji(ModelEmojiUnicode placeholderEmoji) {
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiUnicode.getImageUri(placeholderEmoji.getCodePoints(), getContext()), 0, 0, false, UserStatusPresenceCustomView$configurePlaceholderEmoji$1.INSTANCE, null, 92, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(0);
    }

    private final void configureStatusEmoji(UserStatusPresenceCustomView$Emoji emoji) {
        String imageUri = null;
        if (emoji != null) {
            if (emoji.getId() != null) {
                imageUri = ModelEmojiCustom.getImageUri(Long.parseLong(emoji.getId()), emoji.isAnimated(), IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(2131165341)));
            } else {
                ModelEmojiUnicode modelEmojiUnicode = StoreStream.Companion.getEmojis().getUnicodeEmojiSurrogateMap().get(emoji.getName());
                if (modelEmojiUnicode != null) {
                    imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode.getCodePoints(), getContext());
                }
            }
        }
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(imageUri != null ? 0 : 8);
    }

    public final void setOnClear(Function0<Unit> onClear) {
        m.checkNotNullParameter(onClear, "onClear");
        this.binding.f2216b.setOnClickListener(new UserStatusPresenceCustomView$setOnClear$1(onClear));
    }

    public final void updateViewState(UserStatusPresenceCustomView$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof UserStatusPresenceCustomView$ViewState$WithStatus)) {
            if (viewState instanceof UserStatusPresenceCustomView$ViewState$WithPlaceholder) {
                configurePlaceholderEmoji(((UserStatusPresenceCustomView$ViewState$WithPlaceholder) viewState).getPlaceholderEmoji());
                this.binding.d.setText(2131888312);
                AppCompatImageView appCompatImageView = this.binding.f2216b;
                m.checkNotNullExpressionValue(appCompatImageView, "binding.userStatusPresenceCustomClear");
                appCompatImageView.setVisibility(8);
                return;
            }
            return;
        }
        UserStatusPresenceCustomView$ViewState$WithStatus userStatusPresenceCustomView$ViewState$WithStatus = (UserStatusPresenceCustomView$ViewState$WithStatus) viewState;
        configureStatusEmoji(userStatusPresenceCustomView$ViewState$WithStatus.getEmoji());
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.userStatusPresenceCustomText");
        textView.setText(userStatusPresenceCustomView$ViewState$WithStatus.getStatusText());
        AppCompatImageView appCompatImageView2 = this.binding.f2216b;
        m.checkNotNullExpressionValue(appCompatImageView2, "binding.userStatusPresenceCustomClear");
        appCompatImageView2.setVisibility(0);
    }
}
