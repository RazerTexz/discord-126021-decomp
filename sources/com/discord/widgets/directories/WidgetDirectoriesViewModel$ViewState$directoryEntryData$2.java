package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$ViewState$directoryEntryData$2 extends AbstractC12240o implements Function0<Map<Integer, ? extends List<? extends DirectoryEntryData>>> {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel$ViewState$directoryEntryData$2(WidgetDirectoriesViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<Integer, ? extends List<? extends DirectoryEntryData>> invoke() {
        List<DirectoryEntryGuild> listInvoke = this.this$0.getDirectories().invoke();
        if (listInvoke == null) {
            listInvoke = C12147n.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (DirectoryEntryGuild directoryEntryGuild : listInvoke) {
            Integer numValueOf = Integer.valueOf(directoryEntryGuild.getPrimaryCategoryId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return linkedHashMap;
    }
}
