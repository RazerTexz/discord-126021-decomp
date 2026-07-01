package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import d0.t.h0;
import java.util.Map;
import java.util.Set;
import rx.functions.Func3;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1<T1, T2, T3, R> implements Func3<CallModel, Map<Long, ? extends Integer>, Map<Long, ? extends StageRoles>, StageAudienceBlockedBottomSheetViewModel$StoreState> {
    public final /* synthetic */ long $channelId;

    public StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1(long j) {
        this.$channelId = j;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StageAudienceBlockedBottomSheetViewModel$StoreState call(CallModel callModel, Map<Long, ? extends Integer> map, Map<Long, ? extends StageRoles> map2) {
        return call2(callModel, (Map<Long, Integer>) map, (Map<Long, StageRoles>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StageAudienceBlockedBottomSheetViewModel$StoreState call2(CallModel callModel, Map<Long, Integer> map, Map<Long, StageRoles> map2) {
        long j = this.$channelId;
        Set<Long> setKeySet = map.keySet();
        if (map2 == null) {
            map2 = h0.emptyMap();
        }
        return new StageAudienceBlockedBottomSheetViewModel$StoreState(j, callModel, setKeySet, map2);
    }
}
