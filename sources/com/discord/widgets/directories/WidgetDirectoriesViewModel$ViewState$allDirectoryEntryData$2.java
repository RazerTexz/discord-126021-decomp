package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import d0.t.n;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$ViewState$allDirectoryEntryData$2 extends o implements Function0<List<? extends DirectoryEntryData>> {
    public final /* synthetic */ WidgetDirectoriesViewModel$ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel$ViewState$allDirectoryEntryData$2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        super(0);
        this.this$0 = widgetDirectoriesViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends DirectoryEntryData> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends DirectoryEntryData> invoke2() {
        List<DirectoryEntryGuild> listInvoke = this.this$0.getDirectories().invoke();
        if (listInvoke == null) {
            listInvoke = n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listInvoke, 10));
        for (DirectoryEntryGuild directoryEntryGuild : listInvoke) {
            arrayList.add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return arrayList;
    }
}
