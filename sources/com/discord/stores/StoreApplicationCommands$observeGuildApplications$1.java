package com.discord.stores;

import com.discord.models.commands.Application;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$observeGuildApplications$1 extends o implements Function0<List<? extends Application>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$observeGuildApplications$1(StoreApplicationCommands storeApplicationCommands, long j) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Application> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Application> invoke2() {
        if (StoreApplicationCommands.access$shouldReturnApplicationCommands(this.this$0, StoreApplicationCommands.access$getStorePermissions$p(this.this$0).getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
            return this.this$0.getApplications();
        }
        List<Application> applications = this.this$0.getApplications();
        ArrayList arrayList = new ArrayList();
        for (Object obj : applications) {
            if (((Application) obj).getBuiltIn()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
