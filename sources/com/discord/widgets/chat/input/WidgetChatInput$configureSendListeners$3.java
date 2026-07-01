package com.discord.widgets.chat.input;

import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$3 extends o implements Function2<List<? extends Attachment<?>>, Function1<? super Boolean, ? extends Unit>, Unit> {
    public final /* synthetic */ WidgetChatInput$configureSendListeners$1 $sendCommand$1;
    public final /* synthetic */ WidgetChatInput$configureSendListeners$2 $sendMessage$2;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$3(WidgetChatInput widgetChatInput, WidgetChatInput$configureSendListeners$1 widgetChatInput$configureSendListeners$1, WidgetChatInput$configureSendListeners$2 widgetChatInput$configureSendListeners$2) {
        super(2);
        this.this$0 = widgetChatInput;
        this.$sendCommand$1 = widgetChatInput$configureSendListeners$1;
        this.$sendMessage$2 = widgetChatInput$configureSendListeners$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, Function1<? super Boolean, ? extends Unit> function1) {
        invoke2(list, (Function1<? super Boolean, Unit>) function1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
        m.checkNotNullParameter(list, "attachmentsRaw");
        m.checkNotNullParameter(function1, "onValidationResult");
        InputAutocomplete inputAutocompleteAccess$getAutocomplete$p = WidgetChatInput.access$getAutocomplete$p(this.this$0);
        ApplicationCommandData applicationCommandData$default = inputAutocompleteAccess$getAutocomplete$p != null ? InputAutocomplete.getApplicationCommandData$default(inputAutocompleteAccess$getAutocomplete$p, null, 1, null) : null;
        if (applicationCommandData$default != null && !applicationCommandData$default.getValidInputs()) {
            WidgetChatInput.access$getViewModel$p(this.this$0).onCommandInputsInvalid();
            return;
        }
        if (applicationCommandData$default == null || applicationCommandData$default.getApplicationCommand().getBuiltIn()) {
            this.$sendMessage$2.invoke2(list, applicationCommandData$default, function1);
            return;
        }
        WidgetChatInput$configureSendListeners$1 widgetChatInput$configureSendListeners$1 = this.$sendCommand$1;
        InputAutocomplete inputAutocompleteAccess$getAutocomplete$p2 = WidgetChatInput.access$getAutocomplete$p(this.this$0);
        Map<ApplicationCommandOption, Attachment<?>> commandAttachments = inputAutocompleteAccess$getAutocomplete$p2 != null ? inputAutocompleteAccess$getAutocomplete$p2.getCommandAttachments() : null;
        if (commandAttachments == null) {
            commandAttachments = h0.emptyMap();
        }
        widgetChatInput$configureSendListeners$1.invoke(applicationCommandData$default, (Map<ApplicationCommandOption, ? extends Attachment<?>>) commandAttachments, false, function1);
    }
}
