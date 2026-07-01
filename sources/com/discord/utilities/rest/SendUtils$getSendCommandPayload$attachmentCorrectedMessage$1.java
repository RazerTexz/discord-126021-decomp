package com.discord.utilities.rest;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils$getSendCommandPayload$attachmentCorrectedMessage$1 extends o implements Function1<ApplicationCommandValue, ApplicationCommandValue> {
    public final /* synthetic */ List $fileAttachments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils$getSendCommandPayload$attachmentCorrectedMessage$1(List list) {
        super(1);
        this.$fileAttachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandValue invoke(ApplicationCommandValue applicationCommandValue) {
        return invoke2(applicationCommandValue);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandValue invoke2(ApplicationCommandValue applicationCommandValue) {
        m.checkNotNullParameter(applicationCommandValue, "value");
        if (applicationCommandValue.getType() != ApplicationCommandType.ATTACHMENT.getType()) {
            return applicationCommandValue;
        }
        for (Attachment attachment : this.$fileAttachments) {
            if (m.areEqual(attachment.getUri().toString(), applicationCommandValue.getValue())) {
                return ApplicationCommandValue.copy$default(applicationCommandValue, null, attachment.getDisplayName(), 0, null, null, 29, null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
