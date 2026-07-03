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
import com.discord.C5419R;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.api.botuikit.ComponentType;
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
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(root, "root");
            WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingM8411a = WidgetChatListBotUiButtonComponentBinding.m8411a(LayoutInflater.from(context).inflate(C5419R.layout.widget_chat_list_bot_ui_button_component, root, false));
            C12238m.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingM8411a, "WidgetChatListBotUiButto…om(context), root, false)");
            ButtonComponentView buttonComponentView = widgetChatListBotUiButtonComponentBindingM8411a.f16356a;
            C12238m.checkNotNullExpressionValue(buttonComponentView, "WidgetChatListBotUiButto…ntext), root, false).root");
            return buttonComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonStyle.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonStyle.UNKNOWN.ordinal()] = 1;
            iArr[ButtonStyle.PRIMARY.ordinal()] = 2;
            iArr[ButtonStyle.SECONDARY.ordinal()] = 3;
            iArr[ButtonStyle.LINK.ordinal()] = 4;
            iArr[ButtonStyle.DANGER.ordinal()] = 5;
            iArr[ButtonStyle.SUCCESS.ordinal()] = 6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
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

    public final void configureStyle(Button button, ButtonStyle style) {
        C12238m.checkNotNullParameter(button, "button");
        C12238m.checkNotNullParameter(style, "style");
        int iOrdinal = style.ordinal();
        int i = C5419R.color.uikit_btn_bg_color_selector_secondary;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                i = C5419R.color.uikit_btn_bg_color_selector_brand;
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    i = C5419R.color.uikit_btn_bg_color_selector_green;
                } else if (iOrdinal == 4) {
                    i = C5419R.color.uikit_btn_bg_color_selector_red;
                } else if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        Resources resources = getResources();
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        ViewCompat.setBackgroundTintList(button, ResourcesCompat.getColorStateList(resources, i, context.getTheme()));
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.BUTTON;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public void configure(final ButtonMessageComponent component, ComponentProvider componentProvider, final ComponentActionListener componentActionListener) {
        C12238m.checkNotNullParameter(component, "component");
        C12238m.checkNotNullParameter(componentProvider, "componentProvider");
        C12238m.checkNotNullParameter(componentActionListener, "componentActionListener");
        final WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingM8411a = WidgetChatListBotUiButtonComponentBinding.m8411a(this);
        C12238m.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingM8411a, "WidgetChatListBotUiButto…mponentBinding.bind(this)");
        MaterialButton materialButton = widgetChatListBotUiButtonComponentBindingM8411a.f16357b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.button");
        configureStyle(materialButton, component.getStyle());
        SimpleDraweeView simpleDraweeView = widgetChatListBotUiButtonComponentBindingM8411a.f16358c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.emoji");
        configureEmoji(simpleDraweeView, component.getEmoji(), component.getStateInteraction() instanceof ActionInteractionComponentState.Loading, component.getEmojiAnimationsEnabled());
        AppCompatImageView appCompatImageView = widgetChatListBotUiButtonComponentBindingM8411a.f16360e;
        C12238m.checkNotNullExpressionValue(appCompatImageView, "binding.linkIcon");
        configureLinkIcon(appCompatImageView, component.getStyle() == ButtonStyle.LINK);
        MaterialTextView materialTextView = widgetChatListBotUiButtonComponentBindingM8411a.f16359d;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.label");
        configureLabelPadding(materialTextView, component);
        MaterialTextView materialTextView2 = widgetChatListBotUiButtonComponentBindingM8411a.f16359d;
        C12238m.checkNotNullExpressionValue(materialTextView2, "binding.label");
        ViewExtensions.setEnabledAlpha(materialTextView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.5f);
        SimpleDraweeView simpleDraweeView2 = widgetChatListBotUiButtonComponentBindingM8411a.f16358c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emoji");
        ViewExtensions.setEnabledAlpha$default(simpleDraweeView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        AppCompatImageView appCompatImageView2 = widgetChatListBotUiButtonComponentBindingM8411a.f16360e;
        C12238m.checkNotNullExpressionValue(appCompatImageView2, "binding.linkIcon");
        ViewExtensions.setEnabledAlpha$default(appCompatImageView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        MaterialButton materialButton2 = widgetChatListBotUiButtonComponentBindingM8411a.f16357b;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.button");
        materialButton2.setEnabled(!(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled));
        MaterialTextView materialTextView3 = widgetChatListBotUiButtonComponentBindingM8411a.f16359d;
        C12238m.checkNotNullExpressionValue(materialTextView3, "binding.label");
        materialTextView3.setText(component.getLabel());
        MaterialTextView materialTextView4 = widgetChatListBotUiButtonComponentBindingM8411a.f16359d;
        C12238m.checkNotNullExpressionValue(materialTextView4, "binding.label");
        materialTextView4.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 4 : 0);
        widgetChatListBotUiButtonComponentBindingM8411a.f16357b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.views.ButtonComponentView.configure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (component.getUrl() == null) {
                    if (component.getCustomId() != null) {
                        componentActionListener.onButtonComponentClick(component.getIndex(), component.getCustomId());
                    }
                } else {
                    MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingM8411a.f16357b;
                    C12238m.checkNotNullExpressionValue(materialButton3, "binding.button");
                    Context context = materialButton3.getContext();
                    C12238m.checkNotNullExpressionValue(context, "binding.button.context");
                    UriHandler.handleOrUntrusted$default(context, component.getUrl(), null, 4, null);
                }
            }
        });
        TypingDots typingDots = widgetChatListBotUiButtonComponentBindingM8411a.f16361f;
        C12238m.checkNotNullExpressionValue(typingDots, "binding.loadingDots");
        typingDots.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 0 : 8);
        if (component.getStateInteraction() instanceof ActionInteractionComponentState.Loading) {
            widgetChatListBotUiButtonComponentBindingM8411a.f16361f.m8619a(false);
            MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingM8411a.f16357b;
            C12238m.checkNotNullExpressionValue(materialButton3, "binding.button");
            materialButton3.setClickable(false);
            return;
        }
        widgetChatListBotUiButtonComponentBindingM8411a.f16361f.m8620c();
        MaterialButton materialButton4 = widgetChatListBotUiButtonComponentBindingM8411a.f16357b;
        C12238m.checkNotNullExpressionValue(materialButton4, "binding.button");
        materialButton4.setClickable(true);
    }
}
