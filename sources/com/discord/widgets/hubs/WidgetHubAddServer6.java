package com.discord.widgets.hubs;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.hubs.WidgetHubAddServer;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ WidgetHubAddServerViewModel2 $state$inlined;
    public final /* synthetic */ WidgetHubAddServer.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer6(DirectoryEntryGuild directoryEntryGuild, WidgetHubAddServer.AnonymousClass1 anonymousClass1, WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
        super(0);
        this.$directoryEntry = directoryEntryGuild;
        this.this$0 = anonymousClass1;
        this.$state$inlined = widgetHubAddServerViewModel2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetHubAddServer.this.getViewModel().removeGuild(this.this$0.$guildId, this.$directoryEntry.getDirectoryChannelId());
    }
}
