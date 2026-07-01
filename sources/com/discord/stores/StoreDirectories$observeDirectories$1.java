package com.discord.stores;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$observeDirectories$1 extends o implements Function0<Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>>> {
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$observeDirectories$1(StoreDirectories storeDirectories) {
        super(0);
        this.this$0 = storeDirectories;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> invoke2() {
        return StoreDirectories.access$getDirectoriesMapSnapshot$p(this.this$0);
    }
}
