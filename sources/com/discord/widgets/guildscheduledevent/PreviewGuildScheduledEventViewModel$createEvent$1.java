package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel$createEvent$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ PreviewGuildScheduledEventViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel$createEvent$1(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel) {
        super(1);
        this.this$0 = previewGuildScheduledEventViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        PreviewGuildScheduledEventViewModel.access$setRequestFinished(this.this$0);
    }
}
