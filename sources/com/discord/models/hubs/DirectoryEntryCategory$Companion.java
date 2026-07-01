package com.discord.models.hubs;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DirectoryEntryCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DirectoryEntryCategory$Companion {
    private DirectoryEntryCategory$Companion() {
    }

    public final DirectoryEntryCategory findByKey(int key, boolean isHQDirectoryChannel) {
        Object next;
        Iterator<T> it = getCategories(isHQDirectoryChannel).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((DirectoryEntryCategory) next).getKey() == key));
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) next;
        return directoryEntryCategory != null ? directoryEntryCategory : DirectoryEntryCategory.Uncategorized;
    }

    public final List<DirectoryEntryCategory> getCategories(boolean isHQDirectoryChannel) {
        return isHQDirectoryChannel ? DirectoryEntryCategoryKt.access$getHQ_DIRECTORY_CATEGORIES$p() : DirectoryEntryCategoryKt.access$getHUB_CATEGORIES$p();
    }

    public /* synthetic */ DirectoryEntryCategory$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
