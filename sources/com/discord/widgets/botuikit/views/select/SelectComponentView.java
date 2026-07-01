package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.WidgetChatListBotUiSelectComponentBinding;
import b.a.i.WidgetChatListBotUiSelectComponentPillBinding;
import com.discord.R;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.ComponentView2;
import com.discord.widgets.botuikit.views.ComponentViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentView extends ConstraintLayout implements ComponentView<SelectMessageComponent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SelectComponentView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final SelectComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiSelectComponentBinding widgetChatListBotUiSelectComponentBindingA = WidgetChatListBotUiSelectComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_select_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiSelectComponentBindingA, "WidgetChatListBotUiSelec…om(context), root, false)");
            SelectComponentView selectComponentView = widgetChatListBotUiSelectComponentBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(selectComponentView, "WidgetChatListBotUiSelec…ntext), root, false).root");
            return selectComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.SELECT;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public void configure(final SelectMessageComponent component, ComponentProvider componentProvider, final ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiSelectComponentBinding widgetChatListBotUiSelectComponentBindingA = WidgetChatListBotUiSelectComponentBinding.a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiSelectComponentBindingA, "WidgetChatListBotUiSelec…mponentBinding.bind(this)");
        final String placeholder = component.getPlaceholder();
        if (placeholder == null) {
            placeholder = getResources().getString(R.string.message_select_component_default_placeholder);
            Intrinsics3.checkNotNullExpressionValue(placeholder, "resources.getString(R.st…nent_default_placeholder)");
        }
        if (!(!component.getSelectedOptions().isEmpty())) {
            MaterialTextView materialTextView = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSelectionText");
            materialTextView.setVisibility(0);
            FlexboxLayout flexboxLayout = widgetChatListBotUiSelectComponentBindingA.f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.selectComponentSelectionsRoot");
            flexboxLayout.setVisibility(8);
            widgetChatListBotUiSelectComponentBindingA.e.setTextColor(ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveNormal));
            MaterialTextView materialTextView2 = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSelectionText");
            materialTextView2.setText(placeholder);
        } else if (component.getMaxValues() == 1) {
            MaterialTextView materialTextView3 = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.selectComponentSelectionText");
            materialTextView3.setVisibility(0);
            FlexboxLayout flexboxLayout2 = widgetChatListBotUiSelectComponentBindingA.f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.selectComponentSelectionsRoot");
            flexboxLayout2.setVisibility(8);
            widgetChatListBotUiSelectComponentBindingA.e.setTextColor(ColorCompat.getThemedColor(getContext(), R.attr.colorTextNormal));
            SelectComponent2 selectComponent2 = (SelectComponent2) _Collections.firstOrNull((List) component.getSelectedOptions());
            if (selectComponent2 != null) {
                MaterialTextView materialTextView4 = widgetChatListBotUiSelectComponentBindingA.e;
                Intrinsics3.checkNotNullExpressionValue(materialTextView4, "binding.selectComponentSelectionText");
                materialTextView4.setText(selectComponent2.getLabel());
                ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
                SimpleDraweeView simpleDraweeView = widgetChatListBotUiSelectComponentBindingA.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSelectionIcon");
                componentViewUtils.setEmojiOrHide(simpleDraweeView, selectComponent2.getEmoji(), component.getEmojiAnimationsEnabled());
            }
        } else {
            FlexboxLayout flexboxLayout3 = widgetChatListBotUiSelectComponentBindingA.f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.selectComponentSelectionsRoot");
            MaterialTextView materialTextView5 = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView5, "binding.selectComponentSelectionText");
            materialTextView5.setVisibility(8);
            flexboxLayout3.setVisibility(0);
            flexboxLayout3.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            for (SelectComponent2 selectComponent3 : component.getSelectedOptions()) {
                View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_chat_list_bot_ui_select_component_pill, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                MaterialTextView materialTextView6 = (MaterialTextView) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new WidgetChatListBotUiSelectComponentPillBinding(materialTextView6), "WidgetChatListBotUiSelec…Binding.inflate(inflater)");
                Intrinsics3.checkNotNullExpressionValue(materialTextView6, "WidgetChatListBotUiSelec…ng.inflate(inflater).root");
                materialTextView6.setText(selectComponent3.getLabel());
                flexboxLayout3.addView(materialTextView6);
            }
        }
        boolean z2 = !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled);
        boolean z3 = component.getStateInteraction() instanceof ActionInteractionComponentState.Loading;
        TypingDots typingDots = widgetChatListBotUiSelectComponentBindingA.c;
        if (z3) {
            typingDots.a(false);
        } else {
            typingDots.c();
        }
        TypingDots typingDots2 = widgetChatListBotUiSelectComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(typingDots2, "binding.selectComponentLoading");
        typingDots2.setVisibility(z3 ^ true ? 4 : 0);
        ImageView imageView = widgetChatListBotUiSelectComponentBindingA.f86b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.selectComponentChevron");
        imageView.setVisibility(z3 ? 4 : 0);
        SelectComponentView selectComponentView = widgetChatListBotUiSelectComponentBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(selectComponentView, "binding.root");
        ViewExtensions.setEnabledAlpha(selectComponentView, z2, 0.3f);
        widgetChatListBotUiSelectComponentBindingA.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.views.select.SelectComponentView.configure.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                componentActionListener.onSelectComponentClick(component.getIndex(), component.getCustomId(), placeholder, component.getOptions(), component.getSelectedOptions(), component.getMinValues(), component.getMaxValues(), component.getEmojiAnimationsEnabled());
            }
        });
        SelectComponentView selectComponentView2 = widgetChatListBotUiSelectComponentBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(selectComponentView2, "binding.root");
        selectComponentView2.setClickable(!z3 && z2);
    }
}
