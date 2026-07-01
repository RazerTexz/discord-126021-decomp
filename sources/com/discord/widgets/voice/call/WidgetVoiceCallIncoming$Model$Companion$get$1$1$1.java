package com.discord.widgets.voice.call;

import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$Model$Companion$get$1$1$1 extends o implements Function1<StoreVoiceParticipants$VoiceUser, Boolean> {
    public final /* synthetic */ CallModel $callModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceCallIncoming$Model$Companion$get$1$1$1(CallModel callModel) {
        super(1);
        this.$callModel = callModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        return Boolean.valueOf(invoke2(storeVoiceParticipants$VoiceUser));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "participant");
        if (ChannelUtils.z(this.$callModel.getChannel())) {
            if (storeVoiceParticipants$VoiceUser.isConnected() || storeVoiceParticipants$VoiceUser.isRinging()) {
                return true;
            }
        } else if (!storeVoiceParticipants$VoiceUser.isMe()) {
            return true;
        }
        return false;
    }
}
