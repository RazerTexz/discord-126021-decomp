package com.discord.widgets.chat.input;

import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$7 implements FlexInputListener {
    public final /* synthetic */ WidgetChatInput$configureSendListeners$4 $sendMessageError$4;
    public final /* synthetic */ WidgetChatInput$configureSendListeners$3 $trySend$3;
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureSendListeners$7(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded, WidgetChatInput$configureSendListeners$4 widgetChatInput$configureSendListeners$4, WidgetChatInput$configureSendListeners$3 widgetChatInput$configureSendListeners$3) {
        this.this$0 = widgetChatInput;
        this.$viewState = chatInputViewModel$ViewState$Loaded;
        this.$sendMessageError$4 = widgetChatInput$configureSendListeners$4;
        this.$trySend$3 = widgetChatInput$configureSendListeners$3;
    }

    @Override // com.lytefast.flexinput.FlexInputListener
    public final void onSend(String str, List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(function1, "onSendResult");
        if (this.$viewState.isOnCooldown() && !this.$viewState.isEditing() && this.$viewState.getSelectedThreadDraft() == null) {
            function1.invoke(Boolean.valueOf(this.$sendMessageError$4.invoke(2131887611)));
            return;
        }
        if (this.$viewState.isEditing() && (!list.isEmpty())) {
            function1.invoke(Boolean.valueOf(this.$sendMessageError$4.invoke(2131888646)));
        } else if (this.$viewState.getAbleToSendMessage()) {
            this.$trySend$3.invoke2(list, (Function1<? super Boolean, Unit>) new WidgetChatInput$configureSendListeners$7$1(this, function1));
        } else {
            function1.invoke(Boolean.valueOf(this.$sendMessageError$4.invoke(2131893282)));
        }
    }
}
