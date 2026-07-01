package com.discord.stores;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.Success;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$addServerToDirectory$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$addServerToDirectory$1(StoreDirectories storeDirectories, long j, DirectoryEntryGuild directoryEntryGuild) {
        super(0);
        this.this$0 = storeDirectories;
        this.$channelId = j;
        this.$directoryEntry = directoryEntryGuild;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map mapAccess$getDirectoriesMap$p = StoreDirectories.access$getDirectoriesMap$p(this.this$0);
        Long lValueOf = Long.valueOf(this.$channelId);
        RestCallState restCallState = (RestCallState) StoreDirectories.access$getDirectoriesMap$p(this.this$0).get(Long.valueOf(this.$channelId));
        List<DirectoryEntryGuild> listEmptyList = restCallState != null ? (List) restCallState.invoke() : null;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listEmptyList, 10));
        boolean z2 = false;
        for (DirectoryEntryGuild directoryEntryGuild : listEmptyList) {
            if (directoryEntryGuild.getGuild().getId() == this.$directoryEntry.getGuild().getId()) {
                z2 = true;
                directoryEntryGuild = this.$directoryEntry;
            }
            arrayList.add(directoryEntryGuild);
        }
        mapAccess$getDirectoriesMap$p.put(lValueOf, new Success(u.plus((Collection) arrayList, (Iterable) n.listOfNotNull(z2 ? null : this.$directoryEntry))));
        this.this$0.markChanged();
    }
}
