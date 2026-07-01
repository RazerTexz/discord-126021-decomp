package com.discord.widgets.hubs;

import com.discord.api.directory.DirectoryEntryGuild;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1 extends o implements Function0<Unit> {
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ HubAddServerState $state$inlined;
    public final /* synthetic */ WidgetHubAddServer$onServerClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1(DirectoryEntryGuild directoryEntryGuild, WidgetHubAddServer$onServerClickListener$1 widgetHubAddServer$onServerClickListener$1, HubAddServerState hubAddServerState) {
        super(0);
        this.$directoryEntry = directoryEntryGuild;
        this.this$0 = widgetHubAddServer$onServerClickListener$1;
        this.$state$inlined = hubAddServerState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.getViewModel().removeGuild(this.this$0.$guildId, this.$directoryEntry.getDirectoryChannelId());
    }
}
