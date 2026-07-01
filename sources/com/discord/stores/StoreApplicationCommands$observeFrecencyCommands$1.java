package com.discord.stores;

import com.discord.models.commands.ApplicationCommand;
import com.discord.models.experiments.domain.Experiment;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$observeFrecencyCommands$1 extends o implements Function0<List<? extends ApplicationCommand>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$observeFrecencyCommands$1(StoreApplicationCommands storeApplicationCommands, long j) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ApplicationCommand> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ApplicationCommand> invoke2() {
        Experiment userExperiment = StoreApplicationCommands.access$getStoreExperiments$p(this.this$0).getUserExperiment("2021-09_android_app_commands_frecency", false);
        return (userExperiment == null || userExperiment.getBucket() != 1) ? n.emptyList() : u.take(this.this$0.getFrecencyCommands(this.$guildId), 5);
    }
}
