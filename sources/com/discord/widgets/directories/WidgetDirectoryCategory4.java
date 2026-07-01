package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$adapter$1$onOverflowClicked$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryCategory4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ WidgetDirectoryCategory3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryCategory4(WidgetDirectoryCategory3 widgetDirectoryCategory3, DirectoryEntryGuild directoryEntryGuild, long j) {
        super(0);
        this.this$0 = widgetDirectoryCategory3;
        this.$directoryEntry = directoryEntryGuild;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.getViewModel().removeGuild(this.$directoryEntry.getGuild().getId(), this.$channelId);
    }
}
