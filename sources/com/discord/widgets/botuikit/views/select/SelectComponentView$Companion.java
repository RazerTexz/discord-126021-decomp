package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b.a.i.b5;
import com.discord.R$layout;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentView$Companion {
    private SelectComponentView$Companion() {
    }

    public final SelectComponentView inflateComponent(Context context, ViewGroup root) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(root, "root");
        b5 b5VarA = b5.a(LayoutInflater.from(context).inflate(R$layout.widget_chat_list_bot_ui_select_component, root, false));
        m.checkNotNullExpressionValue(b5VarA, "WidgetChatListBotUiSelec…om(context), root, false)");
        SelectComponentView selectComponentView = b5VarA.a;
        m.checkNotNullExpressionValue(selectComponentView, "WidgetChatListBotUiSelec…ntext), root, false).root");
        return selectComponentView;
    }

    public /* synthetic */ SelectComponentView$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
