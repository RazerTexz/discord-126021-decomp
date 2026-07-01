package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel$Companion {
    private WidgetStageStartEventBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetStageStartEventBottomSheetViewModel$Companion widgetStageStartEventBottomSheetViewModel$Companion, long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances) {
        return widgetStageStartEventBottomSheetViewModel$Companion.observeStoreState(j, storeChannels, storeStageInstances);
    }

    private final Observable<WidgetStageStartEventBottomSheetViewModel$StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreStageInstances stageInstanceStore) {
        Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<WidgetStageStartEventBottomSheetViewModel$StoreState> observableJ = Observable.j(observableG, stageInstanceStore.observeStageInstanceForChannel(channelId).z(), WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… stageInstance)\n        }");
        return observableJ;
    }

    public /* synthetic */ WidgetStageStartEventBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
