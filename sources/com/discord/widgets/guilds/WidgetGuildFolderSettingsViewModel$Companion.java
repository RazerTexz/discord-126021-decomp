package com.discord.widgets.guilds;

import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel$Companion {
    private WidgetGuildFolderSettingsViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetGuildFolderSettingsViewModel$Companion widgetGuildFolderSettingsViewModel$Companion, long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
        return widgetGuildFolderSettingsViewModel$Companion.observeStoreState(j, storeUserSettings, storeGuildsSorted);
    }

    private final Observable<WidgetGuildFolderSettingsViewModel$StoreState> observeStoreState(long folderId, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
        Observable<WidgetGuildFolderSettingsViewModel$StoreState> observableJ = Observable.j(storeUserSettings.observeGuildFolders(), storeGuildsSorted.observeEntries(), new WidgetGuildFolderSettingsViewModel$Companion$observeStoreState$1(folderId));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…Guilds)\n        }\n      }");
        return observableJ;
    }

    public /* synthetic */ WidgetGuildFolderSettingsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
