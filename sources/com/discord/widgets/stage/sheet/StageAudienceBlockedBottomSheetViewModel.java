package com.discord.widgets.stage.sheet;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel extends d0<StageAudienceBlockedBottomSheetViewModel$ViewState> {
    public static final StageAudienceBlockedBottomSheetViewModel$Companion Companion = new StageAudienceBlockedBottomSheetViewModel$Companion(null);
    private final long channelId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StageAudienceBlockedBottomSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            StageAudienceBlockedBottomSheetViewModel$Companion stageAudienceBlockedBottomSheetViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = StageAudienceBlockedBottomSheetViewModel$Companion.access$observeStores(stageAudienceBlockedBottomSheetViewModel$Companion, j, storeStream$Companion.getUserRelationships(), storeStream$Companion.getStageChannels());
        }
        this(j, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel, StageAudienceBlockedBottomSheetViewModel$StoreState stageAudienceBlockedBottomSheetViewModel$StoreState) {
        stageAudienceBlockedBottomSheetViewModel.handleStoreState(stageAudienceBlockedBottomSheetViewModel$StoreState);
    }

    private final void handleStoreState(StageAudienceBlockedBottomSheetViewModel$StoreState storeState) {
        StageAudienceBlockedBottomSheetViewModel$ViewState stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded;
        CallModel callModel = storeState.getCallModel();
        if (callModel != null) {
            Map<Long, StoreVoiceParticipants$VoiceUser> participants = callModel.getParticipants();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map$Entry<Long, StoreVoiceParticipants$VoiceUser>> it = participants.entrySet().iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map$Entry<Long, StoreVoiceParticipants$VoiceUser> next = it.next();
                long jLongValue = next.getKey().longValue();
                if (next.getValue().isConnected() && storeState.getBlockedUsers().contains(Long.valueOf(jLongValue))) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
                long jLongValue2 = ((Number) map$Entry.getKey()).longValue();
                StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = (StoreVoiceParticipants$VoiceUser) map$Entry.getValue();
                StageRoles stageRoles = storeState.getStageRoles().get(Long.valueOf(jLongValue2));
                arrayList.add(new StageAudienceBlockedBottomSheetAdapter$ListItem$Participant(storeVoiceParticipants$VoiceUser, stageRoles != null && StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())));
            }
            Channel channel = callModel.getChannel();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new StageAudienceBlockedBottomSheetAdapter$ListItem$Header(arrayList.size()));
            arrayList2.addAll(arrayList);
            stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded = new StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded(channel, arrayList2);
        } else {
            stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded = StageAudienceBlockedBottomSheetViewModel$ViewState$Invalid.INSTANCE;
        }
        updateViewState(stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetViewModel(long j, Observable<StageAudienceBlockedBottomSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StageAudienceBlockedBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StageAudienceBlockedBottomSheetViewModel$1(this), 62, (Object) null);
    }
}
