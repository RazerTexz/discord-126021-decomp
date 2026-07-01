package com.discord.widgets.guilds.contextmenu;

import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FolderContextMenuViewModel$Companion {
    private FolderContextMenuViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(FolderContextMenuViewModel$Companion folderContextMenuViewModel$Companion, long j, StoreUserSettings storeUserSettings, StoreReadStates storeReadStates) {
        return folderContextMenuViewModel$Companion.observeStoreState(j, storeUserSettings, storeReadStates);
    }

    private final Observable<FolderContextMenuViewModel$StoreState> observeStoreState(long folderId, StoreUserSettings userSettingsStore, StoreReadStates readStateStore) {
        Observable<FolderContextMenuViewModel$StoreState> observableJ = Observable.j(userSettingsStore.observeGuildFolders(), readStateStore.getUnreadGuildIds(), new FolderContextMenuViewModel$Companion$observeStoreState$1(folderId));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      )\n        }\n      }");
        return observableJ;
    }

    public /* synthetic */ FolderContextMenuViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
