package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$adapter$1$onOverflowClicked$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ WidgetDirectoriesSearch$adapter$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearch$adapter$1$onOverflowClicked$1(WidgetDirectoriesSearch$adapter$1 widgetDirectoriesSearch$adapter$1, DirectoryEntryGuild directoryEntryGuild, long j) {
        super(0);
        this.this$0 = widgetDirectoriesSearch$adapter$1;
        this.$directoryEntry = directoryEntryGuild;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.getViewModel().removeGuild(this.$directoryEntry.getGuild().getId(), this.$channelId);
    }
}
