package com.discord.models.hubs;

import d0.t.n;
import java.util.List;

/* JADX INFO: compiled from: DirectoryEntryCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DirectoryEntryCategoryKt {
    private static final List<DirectoryEntryCategory> HUB_CATEGORIES = n.listOf((Object[]) new DirectoryEntryCategory[]{DirectoryEntryCategory.SchoolClub, DirectoryEntryCategory.Class, DirectoryEntryCategory.StudySocial, DirectoryEntryCategory.Misc});
    private static final List<DirectoryEntryCategory> HQ_DIRECTORY_CATEGORIES = n.listOf((Object[]) new DirectoryEntryCategory[]{DirectoryEntryCategory.HQSocial, DirectoryEntryCategory.HQErgs, DirectoryEntryCategory.HQMisc, DirectoryEntryCategory.HQArchives});

    public static final /* synthetic */ List access$getHQ_DIRECTORY_CATEGORIES$p() {
        return HQ_DIRECTORY_CATEGORIES;
    }

    public static final /* synthetic */ List access$getHUB_CATEGORIES$p() {
        return HUB_CATEGORIES;
    }
}
