package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.models.commands.ApplicationCommandLocalSendData$toRestApiApplicationCommandDataParam$attachmentConvertedOptions$1 */
/* JADX INFO: compiled from: ApplicationCommandLocalSendData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C5530xb14bfc1 extends AbstractC12240o implements Function1<ApplicationCommandValue, ApplicationCommandValue> {
    public final /* synthetic */ Ref$IntRef $attachmentCounter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5530xb14bfc1(Ref$IntRef ref$IntRef) {
        super(1);
        this.$attachmentCounter = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ApplicationCommandValue invoke(ApplicationCommandValue applicationCommandValue) {
        C12238m.checkNotNullParameter(applicationCommandValue, "it");
        if (applicationCommandValue.getType() != 11) {
            return applicationCommandValue;
        }
        ApplicationCommandValue applicationCommandValueM7739a = ApplicationCommandValue.m7739a(applicationCommandValue, null, String.valueOf(this.$attachmentCounter.element), 0, null, null, 29);
        this.$attachmentCounter.element++;
        return applicationCommandValueM7739a;
    }
}
