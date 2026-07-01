package com.discord.widgets.chat.input;

import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$5 extends o implements Function1<ApplicationCommandOption, Unit> {
    public final /* synthetic */ WidgetChatInput$configureSendListeners$1 $sendCommand$1;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$5(WidgetChatInput widgetChatInput, WidgetChatInput$configureSendListeners$1 widgetChatInput$configureSendListeners$1) {
        super(1);
        this.this$0 = widgetChatInput;
        this.$sendCommand$1 = widgetChatInput$configureSendListeners$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
        invoke2(applicationCommandOption);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ApplicationCommandOption applicationCommandOption) {
        m.checkNotNullParameter(applicationCommandOption, "it");
        InputAutocomplete inputAutocompleteAccess$getAutocomplete$p = WidgetChatInput.access$getAutocomplete$p(this.this$0);
        ApplicationCommandData applicationCommandData = inputAutocompleteAccess$getAutocomplete$p != null ? inputAutocompleteAccess$getAutocomplete$p.getApplicationCommandData(applicationCommandOption) : null;
        if (applicationCommandData != null) {
            WidgetChatInput$configureSendListeners$1.invoke$default(this.$sendCommand$1, applicationCommandData, h0.emptyMap(), true, null, 8, null);
        }
    }
}
