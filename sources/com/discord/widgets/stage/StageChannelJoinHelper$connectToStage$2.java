package com.discord.widgets.stage;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet;
import d0.f0.q;
import d0.t.h0;
import d0.t.u;
import d0.z.d.o;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$connectToStage$2 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ boolean $launchFullscreen;
    public final /* synthetic */ Function0 $onCompleted;
    public final /* synthetic */ StoreUserRelationships $userRelationshipsStore;
    public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
    public final /* synthetic */ StoreVoiceStates $voiceStatesStore;
    public final /* synthetic */ boolean $warnedAboutBlockedUsers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$connectToStage$2(StoreChannels storeChannels, long j, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, boolean z2, StoreVoiceChannelSelected storeVoiceChannelSelected, FragmentManager fragmentManager, boolean z3, Function0 function0, Context context) {
        super(0);
        this.$channelsStore = storeChannels;
        this.$channelId = j;
        this.$voiceStatesStore = storeVoiceStates;
        this.$userRelationshipsStore = storeUserRelationships;
        this.$warnedAboutBlockedUsers = z2;
        this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.$fragmentManager = fragmentManager;
        this.$launchFullscreen = z3;
        this.$onCompleted = function0;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z2;
        Object next;
        Integer num;
        Channel channel = this.$channelsStore.getChannel(this.$channelId);
        if (channel != null) {
            Map mapEmptyMap = (Map) a.c(channel, this.$voiceStatesStore.get());
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
            }
            Sequence map = q.map(q.filter(u.asSequence(mapEmptyMap.values()), new StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$1(channel)), StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2.INSTANCE);
            Map<Long, Integer> relationships = this.$userRelationshipsStore.getRelationships();
            if (!this.$warnedAboutBlockedUsers) {
                Iterator it = map.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        num = relationships.get(Long.valueOf(((Number) next).longValue()));
                    }
                } while (!(num != null && num.intValue() == 2));
                z2 = (next == null || this.$voiceChannelSelectedStore.getSelectedVoiceChannelId() == this.$channelId) ? false : true;
            }
            if (!z2) {
                ObservableExtensionsKt.appSubscribe$default(this.$voiceChannelSelectedStore.selectVoiceChannel(this.$channelId), StageChannelJoinHelper.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StageChannelJoinHelper$connectToStage$2$1(this), 62, (Object) null);
            } else {
                WidgetStageAudienceBlockedBottomSheet.Companion.show(this.$fragmentManager, this.$channelId, this.$launchFullscreen);
                this.$onCompleted.invoke();
            }
        }
    }
}
