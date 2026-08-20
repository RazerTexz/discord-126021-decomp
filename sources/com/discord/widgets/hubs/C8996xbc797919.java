package com.discord.widgets.hubs;

import com.discord.api.directory.DirectoryEntryGuild;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8996xbc797919 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ HubAddServerState $state$inlined;
    public final /* synthetic */ WidgetHubAddServer.C89951 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8996xbc797919(DirectoryEntryGuild directoryEntryGuild, WidgetHubAddServer.C89951 c89951, HubAddServerState hubAddServerState) {
        super(0);
        this.$directoryEntry = directoryEntryGuild;
        this.this$0 = c89951;
        this.$state$inlined = hubAddServerState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetHubAddServer.this.getViewModel().removeGuild(this.this$0.$guildId, this.$directoryEntry.getDirectoryChannelId());
    }
}
