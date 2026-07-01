package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.stage.StageRoles;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, StageRoles, WidgetStageRaisedHandsBottomSheetViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1 this$0;

    public WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1(WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1 widgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1, Channel channel) {
        this.this$0 = widgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1;
        this.$channel = channel;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$StoreState call(Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map3, StageRoles stageRoles) {
        return call2((Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, StoreVoiceParticipants$VoiceUser>) map3, stageRoles);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetStageRaisedHandsBottomSheetViewModel$StoreState call2(Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, StoreVoiceParticipants$VoiceUser> map3, StageRoles stageRoles) {
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(channel, "channel");
        m.checkNotNullExpressionValue(map, "roles");
        return new WidgetStageRaisedHandsBottomSheetViewModel$StoreState(channel, map, q.toList(q.sortedWith(q.map(q.filter(u.asSequence(map3.values()), WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1.INSTANCE), new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$2(this, map2, map)), new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$$special$$inlined$sortedBy$1())), stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.Companion.m37getAUDIENCE1LxfuJo(), null);
    }
}
