package com.discord.widgets.status;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel$Companion {
    private WidgetThreadStatusViewModel$Companion() {
    }

    private final Observable<WidgetThreadStatusViewModel$StoreState> observeStoreState(StoreThreadsActiveJoined storeThreadsActiveJoined, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StorePermissions storePermissions, StoreExperiments storeExperiments) {
        Observable<R> observableG = storeChannelsSelected.observeSelectedChannel().y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<WidgetThreadStatusViewModel$StoreState> observableY = observableG.Y(new WidgetThreadStatusViewModel$Companion$observeStoreState$1(storeThreadsActiveJoined, storePermissions, storeChannels, storeExperiments));
        m.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…ntilChanged()\n          }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetThreadStatusViewModel$Companion widgetThreadStatusViewModel$Companion, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StorePermissions storePermissions, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 1) != 0) {
            storeThreadsActiveJoined = StoreStream.Companion.getThreadsActiveJoined();
        }
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.Companion.getChannelsSelected();
        }
        StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
        if ((i & 4) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 8) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        StorePermissions storePermissions2 = storePermissions;
        if ((i & 16) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        return widgetThreadStatusViewModel$Companion.observeStoreState(storeThreadsActiveJoined, storeChannelsSelected2, storeChannels2, storePermissions2, storeExperiments);
    }

    public /* synthetic */ WidgetThreadStatusViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
