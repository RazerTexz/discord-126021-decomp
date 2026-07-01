package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.R$layout;
import com.discord.databinding.WidgetChatListBotUiButtonComponentBinding;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ButtonComponentView$Companion {
    private ButtonComponentView$Companion() {
    }

    public final ButtonComponentView inflateComponent(Context context, ViewGroup root) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(root, "root");
        WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(LayoutInflater.from(context).inflate(R$layout.widget_chat_list_bot_ui_button_component, root, false));
        m.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…om(context), root, false)");
        ButtonComponentView buttonComponentView = widgetChatListBotUiButtonComponentBindingA.a;
        m.checkNotNullExpressionValue(buttonComponentView, "WidgetChatListBotUiButto…ntext), root, false).root");
        return buttonComponentView;
    }

    public /* synthetic */ ButtonComponentView$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
