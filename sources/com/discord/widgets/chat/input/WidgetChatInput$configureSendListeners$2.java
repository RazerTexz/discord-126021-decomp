package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.lytefast.flexinput.model.Attachment;
import d0.d0.f;
import d0.t.g0;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$2 extends o implements Function3<List<? extends Attachment<?>>, ApplicationCommandData, Function1<? super Boolean, ? extends Unit>, Unit> {
    public final /* synthetic */ WidgetChatInputEditText $chatInput;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$2(WidgetChatInput widgetChatInput, WidgetChatInputEditText widgetChatInputEditText, Context context, MessageManager messageManager) {
        super(3);
        this.this$0 = widgetChatInput;
        this.$chatInput = widgetChatInputEditText;
        this.$context = context;
        this.$messageManager = messageManager;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, ? extends Unit> function1) {
        invoke2(list, applicationCommandData, (Function1<? super Boolean, Unit>) function1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, Unit> function1) {
        MessageContent messageContent;
        MessageContent messageContent2;
        ApplicationCommand applicationCommand;
        String strInvoke;
        m.checkNotNullParameter(list, "attachmentsRaw");
        m.checkNotNullParameter(function1, "onValidationResult");
        InputAutocomplete inputAutocompleteAccess$getAutocomplete$p = WidgetChatInput.access$getAutocomplete$p(this.this$0);
        if (inputAutocompleteAccess$getAutocomplete$p == null || (messageContent = inputAutocompleteAccess$getAutocomplete$p.getInputContent()) == null) {
            messageContent = new MessageContent(this.$chatInput.getText(), n.emptyList());
        }
        if (applicationCommandData == null || (applicationCommand = applicationCommandData.getApplicationCommand()) == null || !applicationCommand.getBuiltIn()) {
            messageContent2 = messageContent;
        } else {
            ApplicationCommand applicationCommand2 = applicationCommandData.getApplicationCommand();
            List<ApplicationCommandValue> values = applicationCommandData.getValues();
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(values, 10)), 16));
            for (Object obj : values) {
                linkedHashMap.put(((ApplicationCommandValue) obj).getName(), obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
            for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
                linkedHashMap2.put(map$Entry.getKey(), ((ApplicationCommandValue) map$Entry.getValue()).getValue());
            }
            WidgetChatInput.access$getViewModel$p(this.this$0).onCommandUsed(applicationCommandData);
            Function1<Map<String, ? extends Object>, String> execute = applicationCommand2.getExecute();
            if (execute == null || (strInvoke = execute.invoke(linkedHashMap2)) == null) {
                strInvoke = "";
            }
            messageContent2 = new MessageContent(strInvoke, messageContent.getMentionedUsers());
        }
        ChatInputViewModel.sendMessage$default(WidgetChatInput.access$getViewModel$p(this.this$0), this.$context, this.$messageManager, messageContent2, list, false, function1, 16, null);
    }
}
