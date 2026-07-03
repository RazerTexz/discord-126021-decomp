package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.SelectItem;
import com.discord.models.botuikit.ActionInteractionComponentState;
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
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C0925b5;
import p007b.p008a.p025i.C0933c5;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(root, "root");
            C0925b5 c0925b5M197a = C0925b5.m197a(LayoutInflater.from(context).inflate(C5419R.layout.widget_chat_list_bot_ui_select_component, root, false));
            C12238m.checkNotNullExpressionValue(c0925b5M197a, "WidgetChatListBotUiSelec…om(context), root, false)");
            SelectComponentView selectComponentView = c0925b5M197a.f713a;
            C12238m.checkNotNullExpressionValue(selectComponentView, "WidgetChatListBotUiSelec…ntext), root, false).root");
            return selectComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.SELECT;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public void configure(final SelectMessageComponent component, ComponentProvider componentProvider, final ComponentActionListener componentActionListener) {
        C12238m.checkNotNullParameter(component, "component");
        C12238m.checkNotNullParameter(componentProvider, "componentProvider");
        C12238m.checkNotNullParameter(componentActionListener, "componentActionListener");
        C0925b5 c0925b5M197a = C0925b5.m197a(this);
        C12238m.checkNotNullExpressionValue(c0925b5M197a, "WidgetChatListBotUiSelec…mponentBinding.bind(this)");
        final String placeholder = component.getPlaceholder();
        if (placeholder == null) {
            placeholder = getResources().getString(C5419R.string.message_select_component_default_placeholder);
            C12238m.checkNotNullExpressionValue(placeholder, "resources.getString(R.st…nent_default_placeholder)");
        }
        if (!(!component.getSelectedOptions().isEmpty())) {
            MaterialTextView materialTextView = c0925b5M197a.f717e;
            C12238m.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSelectionText");
            materialTextView.setVisibility(0);
            FlexboxLayout flexboxLayout = c0925b5M197a.f718f;
            C12238m.checkNotNullExpressionValue(flexboxLayout, "binding.selectComponentSelectionsRoot");
            flexboxLayout.setVisibility(8);
            c0925b5M197a.f717e.setTextColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorInteractiveNormal));
            MaterialTextView materialTextView2 = c0925b5M197a.f717e;
            C12238m.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSelectionText");
            materialTextView2.setText(placeholder);
        } else if (component.getMaxValues() == 1) {
            MaterialTextView materialTextView3 = c0925b5M197a.f717e;
            C12238m.checkNotNullExpressionValue(materialTextView3, "binding.selectComponentSelectionText");
            materialTextView3.setVisibility(0);
            FlexboxLayout flexboxLayout2 = c0925b5M197a.f718f;
            C12238m.checkNotNullExpressionValue(flexboxLayout2, "binding.selectComponentSelectionsRoot");
            flexboxLayout2.setVisibility(8);
            c0925b5M197a.f717e.setTextColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextNormal));
            SelectItem selectItem = (SelectItem) C12163u.firstOrNull((List) component.getSelectedOptions());
            if (selectItem != null) {
                MaterialTextView materialTextView4 = c0925b5M197a.f717e;
                C12238m.checkNotNullExpressionValue(materialTextView4, "binding.selectComponentSelectionText");
                materialTextView4.setText(selectItem.getLabel());
                ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
                SimpleDraweeView simpleDraweeView = c0925b5M197a.f716d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSelectionIcon");
                componentViewUtils.setEmojiOrHide(simpleDraweeView, selectItem.getEmoji(), component.getEmojiAnimationsEnabled());
            }
        } else {
            FlexboxLayout flexboxLayout3 = c0925b5M197a.f718f;
            C12238m.checkNotNullExpressionValue(flexboxLayout3, "binding.selectComponentSelectionsRoot");
            MaterialTextView materialTextView5 = c0925b5M197a.f717e;
            C12238m.checkNotNullExpressionValue(materialTextView5, "binding.selectComponentSelectionText");
            materialTextView5.setVisibility(8);
            flexboxLayout3.setVisibility(0);
            flexboxLayout3.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            for (SelectItem selectItem2 : component.getSelectedOptions()) {
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.widget_chat_list_bot_ui_select_component_pill, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                MaterialTextView materialTextView6 = (MaterialTextView) viewInflate;
                C12238m.checkNotNullExpressionValue(new C0933c5(materialTextView6), "WidgetChatListBotUiSelec…Binding.inflate(inflater)");
                C12238m.checkNotNullExpressionValue(materialTextView6, "WidgetChatListBotUiSelec…ng.inflate(inflater).root");
                materialTextView6.setText(selectItem2.getLabel());
                flexboxLayout3.addView(materialTextView6);
            }
        }
        boolean z2 = !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled);
        boolean z3 = component.getStateInteraction() instanceof ActionInteractionComponentState.Loading;
        TypingDots typingDots = c0925b5M197a.f715c;
        if (z3) {
            typingDots.m8619a(false);
        } else {
            typingDots.m8620c();
        }
        TypingDots typingDots2 = c0925b5M197a.f715c;
        C12238m.checkNotNullExpressionValue(typingDots2, "binding.selectComponentLoading");
        typingDots2.setVisibility(z3 ^ true ? 4 : 0);
        ImageView imageView = c0925b5M197a.f714b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.selectComponentChevron");
        imageView.setVisibility(z3 ? 4 : 0);
        SelectComponentView selectComponentView = c0925b5M197a.f713a;
        C12238m.checkNotNullExpressionValue(selectComponentView, "binding.root");
        ViewExtensions.setEnabledAlpha(selectComponentView, z2, 0.3f);
        c0925b5M197a.f713a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.views.select.SelectComponentView.configure.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                componentActionListener.onSelectComponentClick(component.getIndex(), component.getCustomId(), placeholder, component.getOptions(), component.getSelectedOptions(), component.getMinValues(), component.getMaxValues(), component.getEmojiAnimationsEnabled());
            }
        });
        SelectComponentView selectComponentView2 = c0925b5M197a.f713a;
        C12238m.checkNotNullExpressionValue(selectComponentView2, "binding.root");
        selectComponentView2.setClickable(!z3 && z2);
    }
}
