package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandValue;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: ApplicationCommandLocalSendData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandLocalSendData$toRestApiApplicationCommandDataParam$attachmentConvertedOptions$1 extends o implements Function1<ApplicationCommandValue, ApplicationCommandValue> {
    public final /* synthetic */ Ref$IntRef $attachmentCounter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandLocalSendData$toRestApiApplicationCommandDataParam$attachmentConvertedOptions$1(Ref$IntRef ref$IntRef) {
        super(1);
        this.$attachmentCounter = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandValue invoke(ApplicationCommandValue applicationCommandValue) {
        return invoke2(applicationCommandValue);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandValue invoke2(ApplicationCommandValue applicationCommandValue) {
        m.checkNotNullParameter(applicationCommandValue, "it");
        if (applicationCommandValue.getType() != 11) {
            return applicationCommandValue;
        }
        ApplicationCommandValue applicationCommandValueA = ApplicationCommandValue.a(applicationCommandValue, null, String.valueOf(this.$attachmentCounter.element), 0, null, null, 29);
        this.$attachmentCounter.element++;
        return applicationCommandValueA;
    }
}
