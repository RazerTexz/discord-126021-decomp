package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewInteractionFailedLabelBinding;
import b.a.i.WidgetChatListBotUiActionRowComponentBinding;
import com.discord.R;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.MessageComponent4;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBotComponentRow2;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ActionRowComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActionRowComponentView extends LinearLayout implements ComponentView<ActionRowMessageComponent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ActionRowComponentView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ActionRowComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiActionRowComponentBinding widgetChatListBotUiActionRowComponentBindingA = WidgetChatListBotUiActionRowComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_action_row_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiActionRowComponentBindingA, "WidgetChatListBotUiActio…om(context), root, false)");
            ActionRowComponentView actionRowComponentView = widgetChatListBotUiActionRowComponentBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(actionRowComponentView, "WidgetChatListBotUiActio…ntext), root, false).root");
            return actionRowComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.ACTION_ROW;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public void configure(ActionRowMessageComponent component, ComponentProvider componentProvider, ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiActionRowComponentBinding widgetChatListBotUiActionRowComponentBindingA = WidgetChatListBotUiActionRowComponentBinding.a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiActionRowComponentBindingA, "WidgetChatListBotUiActio…mponentBinding.bind(this)");
        List<MessageComponent> components = component.getComponents();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(components, 10));
        int i = 0;
        for (Object obj : components) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(componentProvider.getConfiguredComponentView(componentActionListener, (MessageComponent) obj, this, i));
            i = i2;
        }
        FlexboxLayout flexboxLayout = widgetChatListBotUiActionRowComponentBindingA.f78b;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.actionRowComponentViewGroup");
        WidgetChatListAdapterItemBotComponentRow2.replaceViews(flexboxLayout, _Collections.filterNotNull(arrayList));
        ActionInteractionComponentState.Failed childError = MessageComponent4.INSTANCE.getChildError(component);
        ViewInteractionFailedLabelBinding viewInteractionFailedLabelBinding = widgetChatListBotUiActionRowComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(viewInteractionFailedLabelBinding, "binding.actionRowComponentViewGroupErrorRow");
        ConstraintLayout constraintLayout = viewInteractionFailedLabelBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.actionRowComponentViewGroupErrorRow.root");
        constraintLayout.setVisibility(childError != null ? 0 : 8);
        if (childError != null) {
            String errorMessage = childError.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = getResources().getString(R.string.application_command_failed);
                Intrinsics3.checkNotNullExpressionValue(errorMessage, "resources.getString(R.st…plication_command_failed)");
            }
            TextView textView = widgetChatListBotUiActionRowComponentBindingA.c.f159b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.actionRowCompone…ractionFailedLabelMessage");
            textView.setText(errorMessage);
        }
    }
}
