package com.discord.widgets.hubs;

import android.content.Context;
import b.a.d.j;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.utilities.directories.DirectoryUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$onServerClickListener$1 extends o implements Function1<HubAddServerState, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $isNewGuild;
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer$onServerClickListener$1(WidgetHubAddServer widgetHubAddServer, long j, Context context, long j2, boolean z2) {
        super(1);
        this.this$0 = widgetHubAddServer;
        this.$guildId = j;
        this.$context = context;
        this.$channelId = j2;
        this.$isNewGuild = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubAddServerState hubAddServerState) {
        invoke2(hubAddServerState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubAddServerState hubAddServerState) {
        Object next;
        m.checkNotNullParameter(hubAddServerState, "state");
        Iterator<T> it = hubAddServerState.getAddedDirectories().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((DirectoryEntryGuild) next).getGuild().getId() == this.$guildId));
        DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) next;
        if (directoryEntryGuild != null) {
            DirectoryUtils.INSTANCE.showServerOptions(this.this$0, directoryEntryGuild, hubAddServerState.getHubName(), true, new WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1(directoryEntryGuild, this, hubAddServerState));
        } else {
            WidgetHubAddServer widgetHubAddServer = this.this$0;
            j.g(j.g, widgetHubAddServer.getParentFragmentManager(), this.$context, WidgetHubDescription.class, 0, true, null, new HubDescriptionArgs(this.$guildId, this.$channelId, false, widgetHubAddServer.getViewModel().getHubName(), this.$isNewGuild, null, null, 96, null), 40);
        }
    }
}
