package com.discord.stores;

import com.discord.models.commands.ApplicationCommand;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$observeQueryCommands$1 extends o implements Function0<List<? extends ApplicationCommand>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$observeQueryCommands$1(StoreApplicationCommands storeApplicationCommands, long j) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ApplicationCommand> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ApplicationCommand> invoke2() {
        if (StoreApplicationCommands.access$shouldReturnApplicationCommands(this.this$0, StoreApplicationCommands.access$getStorePermissions$p(this.this$0).getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
            return this.this$0.getQueryCommands();
        }
        List<ApplicationCommand> queryCommands = this.this$0.getQueryCommands();
        ArrayList arrayList = new ArrayList();
        for (Object obj : queryCommands) {
            if (((ApplicationCommand) obj).getBuiltIn()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
