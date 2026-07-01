package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.api.botuikit.ComponentType;
import com.discord.databinding.WidgetChatListBotUiButtonComponentBinding;
import com.discord.models.botuikit.ActionInteractionComponentState$Disabled;
import com.discord.models.botuikit.ActionInteractionComponentState$Loading;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ButtonComponentView extends ConstraintLayout implements ComponentView<ButtonMessageComponent> {
    public static final ButtonComponentView$Companion Companion = new ButtonComponentView$Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    private final void configureEmoji(SimpleDraweeView emojiView, ComponentEmoji emoji, boolean isLoading, boolean emojiAnimationsEnabled) {
        if (emoji == null || !isLoading) {
            ComponentViewUtils.INSTANCE.setEmojiOrHide(emojiView, emoji, emojiAnimationsEnabled);
        } else {
            emojiView.setVisibility(4);
        }
    }

    private final void configureLabelPadding(TextView label, ButtonMessageComponent messageComponent) {
        if (messageComponent.getLabel() == null) {
            label.setPadding(0, 0, (ButtonComponentViewKt.hasEmoji(messageComponent) && ButtonComponentViewKt.hasIcon(messageComponent)) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        } else {
            label.setPadding(ButtonComponentViewKt.hasEmoji(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0, ButtonComponentViewKt.hasIcon(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        }
    }

    private final void configureLinkIcon(ImageView icon, boolean showIcon) {
        icon.setVisibility(showIcon ? 0 : 8);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        configure((ButtonMessageComponent) messageComponent, componentProvider, componentActionListener);
    }

    public final void configureStyle(Button button, ButtonStyle style) {
        m.checkNotNullParameter(button, "button");
        m.checkNotNullParameter(style, "style");
        int iOrdinal = style.ordinal();
        int i = 2131100473;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                i = 2131100470;
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    i = 2131100471;
                } else if (iOrdinal == 4) {
                    i = 2131100472;
                } else if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        Resources resources = getResources();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        ViewCompat.setBackgroundTintList(button, ResourcesCompat.getColorStateList(resources, i, context.getTheme()));
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.BUTTON;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(ButtonMessageComponent component, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(componentProvider, "componentProvider");
        m.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(this);
        m.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…mponentBinding.bind(this)");
        MaterialButton materialButton = widgetChatListBotUiButtonComponentBindingA.f2344b;
        m.checkNotNullExpressionValue(materialButton, "binding.button");
        configureStyle(materialButton, component.getStyle());
        SimpleDraweeView simpleDraweeView = widgetChatListBotUiButtonComponentBindingA.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.emoji");
        configureEmoji(simpleDraweeView, component.getEmoji(), component.getStateInteraction() instanceof ActionInteractionComponentState$Loading, component.getEmojiAnimationsEnabled());
        AppCompatImageView appCompatImageView = widgetChatListBotUiButtonComponentBindingA.e;
        m.checkNotNullExpressionValue(appCompatImageView, "binding.linkIcon");
        configureLinkIcon(appCompatImageView, component.getStyle() == ButtonStyle.LINK);
        MaterialTextView materialTextView = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView, "binding.label");
        configureLabelPadding(materialTextView, component);
        MaterialTextView materialTextView2 = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView2, "binding.label");
        ViewExtensions.setEnabledAlpha(materialTextView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState$Disabled), 0.5f);
        SimpleDraweeView simpleDraweeView2 = widgetChatListBotUiButtonComponentBindingA.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emoji");
        ViewExtensions.setEnabledAlpha$default(simpleDraweeView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState$Disabled), 0.0f, 2, null);
        AppCompatImageView appCompatImageView2 = widgetChatListBotUiButtonComponentBindingA.e;
        m.checkNotNullExpressionValue(appCompatImageView2, "binding.linkIcon");
        ViewExtensions.setEnabledAlpha$default(appCompatImageView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState$Disabled), 0.0f, 2, null);
        MaterialButton materialButton2 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        m.checkNotNullExpressionValue(materialButton2, "binding.button");
        materialButton2.setEnabled(!(component.getStateInteraction() instanceof ActionInteractionComponentState$Disabled));
        MaterialTextView materialTextView3 = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView3, "binding.label");
        materialTextView3.setText(component.getLabel());
        MaterialTextView materialTextView4 = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView4, "binding.label");
        materialTextView4.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState$Loading ? 4 : 0);
        widgetChatListBotUiButtonComponentBindingA.f2344b.setOnClickListener(new ButtonComponentView$configure$1(component, widgetChatListBotUiButtonComponentBindingA, componentActionListener));
        TypingDots typingDots = widgetChatListBotUiButtonComponentBindingA.f;
        m.checkNotNullExpressionValue(typingDots, "binding.loadingDots");
        typingDots.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState$Loading ? 0 : 8);
        if (component.getStateInteraction() instanceof ActionInteractionComponentState$Loading) {
            widgetChatListBotUiButtonComponentBindingA.f.a(false);
            MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingA.f2344b;
            m.checkNotNullExpressionValue(materialButton3, "binding.button");
            materialButton3.setClickable(false);
            return;
        }
        widgetChatListBotUiButtonComponentBindingA.f.c();
        MaterialButton materialButton4 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        m.checkNotNullExpressionValue(materialButton4, "binding.button");
        materialButton4.setClickable(true);
    }
}
