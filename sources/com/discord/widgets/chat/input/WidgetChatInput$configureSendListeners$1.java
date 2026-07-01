package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$1 extends o implements Function4<ApplicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>>, Boolean, Function1<? super Boolean, ? extends Unit>, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$1(WidgetChatInput widgetChatInput, Context context, MessageManager messageManager) {
        super(4);
        this.this$0 = widgetChatInput;
        this.$context = context;
        this.$messageManager = messageManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void invoke$default(WidgetChatInput$configureSendListeners$1 widgetChatInput$configureSendListeners$1, ApplicationCommandData applicationCommandData, Map map, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            function1 = WidgetChatInput$configureSendListeners$1$1.INSTANCE;
        }
        widgetChatInput$configureSendListeners$1.invoke(applicationCommandData, (Map<ApplicationCommandOption, ? extends Attachment<?>>) map, z2, (Function1<? super Boolean, Unit>) function1);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, Boolean bool, Function1<? super Boolean, ? extends Unit> function1) {
        invoke(applicationCommandData, map, bool.booleanValue(), (Function1<? super Boolean, Unit>) function1);
        return Unit.a;
    }

    public final void invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, boolean z2, Function1<? super Boolean, Unit> function1) {
        m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        m.checkNotNullParameter(map, "attachments");
        m.checkNotNullParameter(function1, "onValidationResult");
        WidgetChatInput.access$getViewModel$p(this.this$0).sendCommand(this.$context, this.$messageManager, applicationCommandData, map, z2, false, function1);
    }
}
