package com.discord.stores;

import com.discord.api.commands.ApplicationCommand;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$getApplicationCommandsViaRest$1 extends o implements Function1<List<? extends ApplicationCommand>, Unit> {
    public final /* synthetic */ long $applicationId;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$getApplicationCommandsViaRest$1(StoreApplicationCommands storeApplicationCommands, long j) {
        super(1);
        this.this$0 = storeApplicationCommands;
        this.$applicationId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApplicationCommand> list) {
        invoke2((List<ApplicationCommand>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ApplicationCommand> list) {
        StoreApplicationCommands.access$getDispatcher$p(this.this$0).schedule(new StoreApplicationCommands$getApplicationCommandsViaRest$1$1(this, list));
    }
}
