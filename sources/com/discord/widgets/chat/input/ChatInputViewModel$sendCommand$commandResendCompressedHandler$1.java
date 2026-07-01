package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ApplicationCommandData $applicationCommandData;
    public final /* synthetic */ Map $attachments;
    public final /* synthetic */ ChatInputViewModel$AttachmentContext $attachmentsContext;
    public final /* synthetic */ boolean $autocomplete;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendCommand$commandResendCompressedHandler$1(ChatInputViewModel chatInputViewModel, Context context, ChatInputViewModel$AttachmentContext chatInputViewModel$AttachmentContext, Map map, MessageManager messageManager, ApplicationCommandData applicationCommandData, boolean z2) {
        super(0);
        this.this$0 = chatInputViewModel;
        this.$context = context;
        this.$attachmentsContext = chatInputViewModel$AttachmentContext;
        this.$attachments = map;
        this.$messageManager = messageManager;
        this.$applicationCommandData = applicationCommandData;
        this.$autocomplete = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SendUtils.INSTANCE.compressImageAttachments(this.$context, this.$attachmentsContext.getAttachments(), new ChatInputViewModel$sendCommand$commandResendCompressedHandler$1$1(this));
    }
}
