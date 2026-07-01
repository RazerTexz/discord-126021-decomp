package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserRelationships;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel$Companion {
    private StageAudienceBlockedBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(StageAudienceBlockedBottomSheetViewModel$Companion stageAudienceBlockedBottomSheetViewModel$Companion, long j, StoreUserRelationships storeUserRelationships, StoreStageChannels storeStageChannels) {
        return stageAudienceBlockedBottomSheetViewModel$Companion.observeStores(j, storeUserRelationships, storeStageChannels);
    }

    private final Observable<StageAudienceBlockedBottomSheetViewModel$StoreState> observeStores(long channelId, StoreUserRelationships userRelationshipsStore, StoreStageChannels stageStore) {
        Observable<StageAudienceBlockedBottomSheetViewModel$StoreState> observableI = Observable.i(CallModel.Companion.get(channelId), userRelationshipsStore.observeForType(2), stageStore.observeStageRolesByChannel(channelId), new StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1(channelId));
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest… emptyMap()\n      )\n    }");
        return observableI;
    }

    public /* synthetic */ StageAudienceBlockedBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
