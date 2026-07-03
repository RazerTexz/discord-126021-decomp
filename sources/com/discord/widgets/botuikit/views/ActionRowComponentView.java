package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.botuikit.ComponentType;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.MessageComponentUtils;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBotComponentRowKt;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C0917a5;
import p007b.p008a.p025i.C1005m2;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(root, "root");
            C0917a5 c0917a5M195a = C0917a5.m195a(LayoutInflater.from(context).inflate(C5419R.layout.widget_chat_list_bot_ui_action_row_component, root, false));
            C12238m.checkNotNullExpressionValue(c0917a5M195a, "WidgetChatListBotUiActio…om(context), root, false)");
            ActionRowComponentView actionRowComponentView = c0917a5M195a.f679a;
            C12238m.checkNotNullExpressionValue(actionRowComponentView, "WidgetChatListBotUiActio…ntext), root, false).root");
            return actionRowComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.ACTION_ROW;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public void configure(ActionRowMessageComponent component, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        C12238m.checkNotNullParameter(component, "component");
        C12238m.checkNotNullParameter(componentProvider, "componentProvider");
        C12238m.checkNotNullParameter(componentActionListener, "componentActionListener");
        C0917a5 c0917a5M195a = C0917a5.m195a(this);
        C12238m.checkNotNullExpressionValue(c0917a5M195a, "WidgetChatListBotUiActio…mponentBinding.bind(this)");
        List<MessageComponent> components = component.getComponents();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(components, 10));
        int i = 0;
        for (Object obj : components) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList.add(componentProvider.getConfiguredComponentView(componentActionListener, (MessageComponent) obj, this, i));
            i = i2;
        }
        FlexboxLayout flexboxLayout = c0917a5M195a.f680b;
        C12238m.checkNotNullExpressionValue(flexboxLayout, "binding.actionRowComponentViewGroup");
        WidgetChatListAdapterItemBotComponentRowKt.replaceViews(flexboxLayout, C12163u.filterNotNull(arrayList));
        ActionInteractionComponentState.Failed childError = MessageComponentUtils.INSTANCE.getChildError(component);
        C1005m2 c1005m2 = c0917a5M195a.f681c;
        C12238m.checkNotNullExpressionValue(c1005m2, "binding.actionRowComponentViewGroupErrorRow");
        ConstraintLayout constraintLayout = c1005m2.f1047a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.actionRowComponentViewGroupErrorRow.root");
        constraintLayout.setVisibility(childError != null ? 0 : 8);
        if (childError != null) {
            String errorMessage = childError.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = getResources().getString(C5419R.string.application_command_failed);
                C12238m.checkNotNullExpressionValue(errorMessage, "resources.getString(R.st…plication_command_failed)");
            }
            TextView textView = c0917a5M195a.f681c.f1048b;
            C12238m.checkNotNullExpressionValue(textView, "binding.actionRowCompone…ractionFailedLabelMessage");
            textView.setText(errorMessage);
        }
    }
}
