package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.discord.R;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.databinding.WidgetChatListBotUiButtonComponentBinding;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ButtonComponentView extends ConstraintLayout implements ComponentView<ButtonMessageComponent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ButtonComponentView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ButtonComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_button_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…om(context), root, false)");
            ButtonComponentView buttonComponentView = widgetChatListBotUiButtonComponentBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(buttonComponentView, "WidgetChatListBotUiButto…ntext), root, false).root");
            return buttonComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonComponent2.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonComponent2.UNKNOWN.ordinal()] = 1;
            iArr[ButtonComponent2.PRIMARY.ordinal()] = 2;
            iArr[ButtonComponent2.SECONDARY.ordinal()] = 3;
            iArr[ButtonComponent2.LINK.ordinal()] = 4;
            iArr[ButtonComponent2.DANGER.ordinal()] = 5;
            iArr[ButtonComponent2.SUCCESS.ordinal()] = 6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
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
            label.setPadding(0, 0, (ButtonComponentView2.hasEmoji(messageComponent) && ButtonComponentView2.hasIcon(messageComponent)) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        } else {
            label.setPadding(ButtonComponentView2.hasEmoji(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0, ButtonComponentView2.hasIcon(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        }
    }

    private final void configureLinkIcon(ImageView icon, boolean showIcon) {
        icon.setVisibility(showIcon ? 0 : 8);
    }

    public final void configureStyle(Button button, ButtonComponent2 style) {
        Intrinsics3.checkNotNullParameter(button, "button");
        Intrinsics3.checkNotNullParameter(style, "style");
        int iOrdinal = style.ordinal();
        int i = R.color.uikit_btn_bg_color_selector_secondary;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                i = R.color.uikit_btn_bg_color_selector_brand;
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    i = R.color.uikit_btn_bg_color_selector_green;
                } else if (iOrdinal == 4) {
                    i = R.color.uikit_btn_bg_color_selector_red;
                } else if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        Resources resources = getResources();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        ViewCompat.setBackgroundTintList(button, ResourcesCompat.getColorStateList(resources, i, context.getTheme()));
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.BUTTON;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public void configure(final ButtonMessageComponent component, ComponentProvider componentProvider, final ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        final WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…mponentBinding.bind(this)");
        MaterialButton materialButton = widgetChatListBotUiButtonComponentBindingA.f2344b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.button");
        configureStyle(materialButton, component.getStyle());
        SimpleDraweeView simpleDraweeView = widgetChatListBotUiButtonComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.emoji");
        configureEmoji(simpleDraweeView, component.getEmoji(), component.getStateInteraction() instanceof ActionInteractionComponentState.Loading, component.getEmojiAnimationsEnabled());
        AppCompatImageView appCompatImageView = widgetChatListBotUiButtonComponentBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.linkIcon");
        configureLinkIcon(appCompatImageView, component.getStyle() == ButtonComponent2.LINK);
        MaterialTextView materialTextView = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.label");
        configureLabelPadding(materialTextView, component);
        MaterialTextView materialTextView2 = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.label");
        ViewExtensions.setEnabledAlpha(materialTextView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.5f);
        SimpleDraweeView simpleDraweeView2 = widgetChatListBotUiButtonComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.emoji");
        ViewExtensions.setEnabledAlpha$default(simpleDraweeView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        AppCompatImageView appCompatImageView2 = widgetChatListBotUiButtonComponentBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.linkIcon");
        ViewExtensions.setEnabledAlpha$default(appCompatImageView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        MaterialButton materialButton2 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.button");
        materialButton2.setEnabled(!(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled));
        MaterialTextView materialTextView3 = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.label");
        materialTextView3.setText(component.getLabel());
        MaterialTextView materialTextView4 = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView4, "binding.label");
        materialTextView4.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 4 : 0);
        widgetChatListBotUiButtonComponentBindingA.f2344b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.views.ButtonComponentView.configure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (component.getUrl() == null) {
                    if (component.getCustomId() != null) {
                        componentActionListener.onButtonComponentClick(component.getIndex(), component.getCustomId());
                    }
                } else {
                    MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingA.f2344b;
                    Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.button");
                    Context context = materialButton3.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "binding.button.context");
                    UriHandler.handleOrUntrusted$default(context, component.getUrl(), null, 4, null);
                }
            }
        });
        TypingDots typingDots = widgetChatListBotUiButtonComponentBindingA.f;
        Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.loadingDots");
        typingDots.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 0 : 8);
        if (component.getStateInteraction() instanceof ActionInteractionComponentState.Loading) {
            widgetChatListBotUiButtonComponentBindingA.f.a(false);
            MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingA.f2344b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.button");
            materialButton3.setClickable(false);
            return;
        }
        widgetChatListBotUiButtonComponentBindingA.f.c();
        MaterialButton materialButton4 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.button");
        materialButton4.setClickable(true);
    }
}
