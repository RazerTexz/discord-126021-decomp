package com.discord.stores;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$fetchDirectoriesForChannel$2 extends o implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$fetchDirectoriesForChannel$2(StoreDirectories storeDirectories, long j) {
        super(1);
        this.this$0 = storeDirectories;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
        invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
        m.checkNotNullParameter(restCallState, "entriesResponse");
        StoreDirectories.access$getDispatcher$p(this.this$0).schedule(new StoreDirectories$fetchDirectoriesForChannel$2$1(this, restCallState));
    }
}
