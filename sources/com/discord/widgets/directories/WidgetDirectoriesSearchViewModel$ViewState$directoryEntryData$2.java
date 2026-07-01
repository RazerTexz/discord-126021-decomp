package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2 extends o implements Function0<List<? extends DirectoryEntryData>> {
    public final /* synthetic */ WidgetDirectoriesSearchViewModel$ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2(WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        super(0);
        this.this$0 = widgetDirectoriesSearchViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends DirectoryEntryData> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends DirectoryEntryData> invoke2() {
        List<DirectoryEntryGuild> directories = this.this$0.getDirectories();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(directories, 10));
        for (DirectoryEntryGuild directoryEntryGuild : directories) {
            arrayList.add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return arrayList;
    }
}
