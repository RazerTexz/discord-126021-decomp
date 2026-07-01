package com.discord.stores;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.Success;
import d0.t.n;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$removeServerFromDirectory$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreDirectories$removeServerFromDirectory$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$removeServerFromDirectory$2$1(StoreDirectories$removeServerFromDirectory$2 storeDirectories$removeServerFromDirectory$2) {
        super(0);
        this.this$0 = storeDirectories$removeServerFromDirectory$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map mapAccess$getDirectoriesMap$p = StoreDirectories.access$getDirectoriesMap$p(this.this$0.this$0);
        Long lValueOf = Long.valueOf(this.this$0.$channelId);
        RestCallState restCallState = (RestCallState) StoreDirectories.access$getDirectoriesMap$p(this.this$0.this$0).get(Long.valueOf(this.this$0.$channelId));
        List listEmptyList = restCallState != null ? (List) restCallState.invoke() : null;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            GuildPreview guild = ((DirectoryEntryGuild) obj).getGuild();
            if (guild == null || guild.getId() != this.this$0.$guildId) {
                arrayList.add(obj);
            }
        }
        mapAccess$getDirectoriesMap$p.put(lValueOf, new Success(arrayList));
        this.this$0.this$0.markChanged();
    }
}
