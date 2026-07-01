package com.discord.stores;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$observeDirectoriesForChannel$1 extends o implements Function0<RestCallState<? extends List<? extends DirectoryEntryGuild>>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$observeDirectoriesForChannel$1(StoreDirectories storeDirectories, long j) {
        super(0);
        this.this$0 = storeDirectories;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RestCallState<? extends List<? extends DirectoryEntryGuild>> invoke2() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final RestCallState<? extends List<? extends DirectoryEntryGuild>> invoke() {
        return (RestCallState) StoreDirectories.access$getDirectoriesMapSnapshot$p(this.this$0).get(Long.valueOf(this.$channelId));
    }
}
