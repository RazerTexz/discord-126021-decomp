package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.a5;
import b.a.i.m2;
import com.discord.api.botuikit.ComponentType;
import com.discord.models.botuikit.ActionInteractionComponentState$Failed;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.MessageComponentUtils;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBotComponentRowKt;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ActionRowComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActionRowComponentView extends LinearLayout implements ComponentView<ActionRowMessageComponent> {
    public static final ActionRowComponentView$Companion Companion = new ActionRowComponentView$Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        configure((ActionRowMessageComponent) messageComponent, componentProvider, componentActionListener);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.ACTION_ROW;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(ActionRowMessageComponent component, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(componentProvider, "componentProvider");
        m.checkNotNullParameter(componentActionListener, "componentActionListener");
        a5 a5VarA = a5.a(this);
        m.checkNotNullExpressionValue(a5VarA, "WidgetChatListBotUiActio…mponentBinding.bind(this)");
        List<MessageComponent> components = component.getComponents();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(components, 10));
        int i = 0;
        for (Object obj : components) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            arrayList.add(componentProvider.getConfiguredComponentView(componentActionListener, (MessageComponent) obj, this, i));
            i = i2;
        }
        FlexboxLayout flexboxLayout = a5VarA.f78b;
        m.checkNotNullExpressionValue(flexboxLayout, "binding.actionRowComponentViewGroup");
        WidgetChatListAdapterItemBotComponentRowKt.replaceViews(flexboxLayout, u.filterNotNull(arrayList));
        ActionInteractionComponentState$Failed childError = MessageComponentUtils.INSTANCE.getChildError(component);
        m2 m2Var = a5VarA.c;
        m.checkNotNullExpressionValue(m2Var, "binding.actionRowComponentViewGroupErrorRow");
        ConstraintLayout constraintLayout = m2Var.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.actionRowComponentViewGroupErrorRow.root");
        constraintLayout.setVisibility(childError != null ? 0 : 8);
        if (childError != null) {
            String errorMessage = childError.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = getResources().getString(2131886511);
                m.checkNotNullExpressionValue(errorMessage, "resources.getString(R.st…plication_command_failed)");
            }
            TextView textView = a5VarA.c.f159b;
            m.checkNotNullExpressionValue(textView, "binding.actionRowCompone…ractionFailedLabelMessage");
            textView.setText(errorMessage);
        }
    }
}
