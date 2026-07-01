package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b.a.i.a5;
import com.discord.R$layout;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ActionRowComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActionRowComponentView$Companion {
    private ActionRowComponentView$Companion() {
    }

    public final ActionRowComponentView inflateComponent(Context context, ViewGroup root) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(root, "root");
        a5 a5VarA = a5.a(LayoutInflater.from(context).inflate(R$layout.widget_chat_list_bot_ui_action_row_component, root, false));
        m.checkNotNullExpressionValue(a5VarA, "WidgetChatListBotUiActio…om(context), root, false)");
        ActionRowComponentView actionRowComponentView = a5VarA.a;
        m.checkNotNullExpressionValue(actionRowComponentView, "WidgetChatListBotUiActio…ntext), root, false).root");
        return actionRowComponentView;
    }

    public /* synthetic */ ActionRowComponentView$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
