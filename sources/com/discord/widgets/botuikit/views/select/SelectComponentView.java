package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.b5;
import b.a.i.c5;
import com.discord.R$layout;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.SelectItem;
import com.discord.models.botuikit.ActionInteractionComponentState$Disabled;
import com.discord.models.botuikit.ActionInteractionComponentState$Loading;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.botuikit.views.ComponentActionListener;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.ComponentViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SelectComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentView extends ConstraintLayout implements ComponentView<SelectMessageComponent> {
    public static final SelectComponentView$Companion Companion = new SelectComponentView$Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        configure((SelectMessageComponent) messageComponent, componentProvider, componentActionListener);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.SELECT;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(SelectMessageComponent component, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(componentProvider, "componentProvider");
        m.checkNotNullParameter(componentActionListener, "componentActionListener");
        b5 b5VarA = b5.a(this);
        m.checkNotNullExpressionValue(b5VarA, "WidgetChatListBotUiSelec…mponentBinding.bind(this)");
        String placeholder = component.getPlaceholder();
        if (placeholder == null) {
            placeholder = getResources().getString(2131892970);
            m.checkNotNullExpressionValue(placeholder, "resources.getString(R.st…nent_default_placeholder)");
        }
        if (!(!component.getSelectedOptions().isEmpty())) {
            MaterialTextView materialTextView = b5VarA.e;
            m.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSelectionText");
            materialTextView.setVisibility(0);
            FlexboxLayout flexboxLayout = b5VarA.f;
            m.checkNotNullExpressionValue(flexboxLayout, "binding.selectComponentSelectionsRoot");
            flexboxLayout.setVisibility(8);
            b5VarA.e.setTextColor(ColorCompat.getThemedColor(getContext(), 2130969008));
            MaterialTextView materialTextView2 = b5VarA.e;
            m.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSelectionText");
            materialTextView2.setText(placeholder);
        } else if (component.getMaxValues() == 1) {
            MaterialTextView materialTextView3 = b5VarA.e;
            m.checkNotNullExpressionValue(materialTextView3, "binding.selectComponentSelectionText");
            materialTextView3.setVisibility(0);
            FlexboxLayout flexboxLayout2 = b5VarA.f;
            m.checkNotNullExpressionValue(flexboxLayout2, "binding.selectComponentSelectionsRoot");
            flexboxLayout2.setVisibility(8);
            b5VarA.e.setTextColor(ColorCompat.getThemedColor(getContext(), 2130969057));
            SelectItem selectItem = (SelectItem) u.firstOrNull((List) component.getSelectedOptions());
            if (selectItem != null) {
                MaterialTextView materialTextView4 = b5VarA.e;
                m.checkNotNullExpressionValue(materialTextView4, "binding.selectComponentSelectionText");
                materialTextView4.setText(selectItem.getLabel());
                ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
                SimpleDraweeView simpleDraweeView = b5VarA.d;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSelectionIcon");
                componentViewUtils.setEmojiOrHide(simpleDraweeView, selectItem.getEmoji(), component.getEmojiAnimationsEnabled());
            }
        } else {
            FlexboxLayout flexboxLayout3 = b5VarA.f;
            m.checkNotNullExpressionValue(flexboxLayout3, "binding.selectComponentSelectionsRoot");
            MaterialTextView materialTextView5 = b5VarA.e;
            m.checkNotNullExpressionValue(materialTextView5, "binding.selectComponentSelectionText");
            materialTextView5.setVisibility(8);
            flexboxLayout3.setVisibility(0);
            flexboxLayout3.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            for (SelectItem selectItem2 : component.getSelectedOptions()) {
                View viewInflate = layoutInflaterFrom.inflate(R$layout.widget_chat_list_bot_ui_select_component_pill, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                MaterialTextView materialTextView6 = (MaterialTextView) viewInflate;
                m.checkNotNullExpressionValue(new c5(materialTextView6), "WidgetChatListBotUiSelec…Binding.inflate(inflater)");
                m.checkNotNullExpressionValue(materialTextView6, "WidgetChatListBotUiSelec…ng.inflate(inflater).root");
                materialTextView6.setText(selectItem2.getLabel());
                flexboxLayout3.addView(materialTextView6);
            }
        }
        boolean z2 = !(component.getStateInteraction() instanceof ActionInteractionComponentState$Disabled);
        boolean z3 = component.getStateInteraction() instanceof ActionInteractionComponentState$Loading;
        TypingDots typingDots = b5VarA.c;
        if (z3) {
            typingDots.a(false);
        } else {
            typingDots.c();
        }
        TypingDots typingDots2 = b5VarA.c;
        m.checkNotNullExpressionValue(typingDots2, "binding.selectComponentLoading");
        typingDots2.setVisibility(z3 ^ true ? 4 : 0);
        ImageView imageView = b5VarA.f86b;
        m.checkNotNullExpressionValue(imageView, "binding.selectComponentChevron");
        imageView.setVisibility(z3 ? 4 : 0);
        SelectComponentView selectComponentView = b5VarA.a;
        m.checkNotNullExpressionValue(selectComponentView, "binding.root");
        ViewExtensions.setEnabledAlpha(selectComponentView, z2, 0.3f);
        b5VarA.a.setOnClickListener(new SelectComponentView$configure$3(componentActionListener, component, placeholder));
        SelectComponentView selectComponentView2 = b5VarA.a;
        m.checkNotNullExpressionValue(selectComponentView2, "binding.root");
        selectComponentView2.setClickable(!z3 && z2);
    }
}
