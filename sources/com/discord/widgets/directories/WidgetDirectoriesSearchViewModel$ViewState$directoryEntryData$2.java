package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.WidgetDirectoriesSearchViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2 extends AbstractC12240o implements Function0<List<? extends DirectoryEntryData>> {
    public final /* synthetic */ WidgetDirectoriesSearchViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2(WidgetDirectoriesSearchViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends DirectoryEntryData> invoke() {
        List<DirectoryEntryGuild> directories = this.this$0.getDirectories();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(directories, 10));
        for (DirectoryEntryGuild directoryEntryGuild : directories) {
            arrayList.add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return arrayList;
    }
}
