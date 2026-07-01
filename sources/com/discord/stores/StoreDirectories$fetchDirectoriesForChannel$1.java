package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.directory.DirectoryEntryGuild;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$fetchDirectoriesForChannel$1<T, R> implements b<List<? extends DirectoryEntryGuild>, List<? extends DirectoryEntryGuild>> {
    public static final StoreDirectories$fetchDirectoriesForChannel$1 INSTANCE = new StoreDirectories$fetchDirectoriesForChannel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends DirectoryEntryGuild> call(List<? extends DirectoryEntryGuild> list) {
        return call2((List<DirectoryEntryGuild>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<DirectoryEntryGuild> call2(List<DirectoryEntryGuild> list) {
        m.checkNotNullExpressionValue(list, "entries");
        return u.sortedWith(list, new StoreDirectories$fetchDirectoriesForChannel$1$$special$$inlined$sortedByDescending$1());
    }
}
