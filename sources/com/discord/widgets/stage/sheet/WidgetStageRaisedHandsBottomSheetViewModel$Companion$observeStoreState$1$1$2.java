package com.discord.widgets.stage.sheet;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.guilds.RoleUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$2 extends o implements Function1<StoreVoiceParticipants$VoiceUser, WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant> {
    public final /* synthetic */ Map $members;
    public final /* synthetic */ Map $roles;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$2(WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1 widgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1, Map map, Map map2) {
        super(1);
        this.this$0 = widgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1;
        this.$members = map;
        this.$roles = map2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        return invoke2(storeVoiceParticipants$VoiceUser);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        UtcDateTime utcDateTime;
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceUser");
        VoiceState voiceState = storeVoiceParticipants$VoiceUser.getVoiceState();
        if (voiceState == null || (utcDateTime = voiceState.getRequestToSpeakTimestamp()) == null) {
            utcDateTime = new UtcDateTime(this.this$0.this$0.$clock.currentTimeMillis());
        }
        GuildMember guildMember = (GuildMember) this.$members.get(Long.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId()));
        Map map = this.$roles;
        m.checkNotNullExpressionValue(map, "roles");
        return new WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant(storeVoiceParticipants$VoiceUser, utcDateTime, guildMember, RoleUtils.getHighestHoistedRole(map, (GuildMember) this.$members.get(Long.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId()))));
    }
}
