package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Channel, Boolean, Integer, Map<Long, ? extends Integer>, CallModel, Channel, WidgetCallPreviewFullscreenViewModel$StoreState> {
    public final /* synthetic */ Channel $voiceChannel;

    public WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1$1(Channel channel) {
        this.$voiceChannel = channel;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenViewModel$StoreState call(MeUser meUser, Channel channel, Boolean bool, Integer num, Map<Long, ? extends Integer> map, CallModel callModel, Channel channel2) {
        return call2(meUser, channel, bool, num, (Map<Long, Integer>) map, callModel, channel2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetCallPreviewFullscreenViewModel$StoreState call2(MeUser meUser, Channel channel, Boolean bool, Integer num, Map<Long, Integer> map, CallModel callModel, Channel channel2) {
        if (callModel == null || this.$voiceChannel == null || channel == null) {
            return WidgetCallPreviewFullscreenViewModel$StoreState$Invalid.INSTANCE;
        }
        boolean z2 = !StoreStream.Companion.getGuildsNsfw().isGuildNsfwGateAgreed(this.$voiceChannel.getGuildId());
        boolean nsfw = this.$voiceChannel.getNsfw();
        NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
        Channel channel3 = this.$voiceChannel;
        m.checkNotNullExpressionValue(bool, "isTextInVoiceEnabled");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(num, "totalMentionsCount");
        int iIntValue = num.intValue();
        Integer num2 = (Integer) a.d(this.$voiceChannel, map);
        return new WidgetCallPreviewFullscreenViewModel$StoreState$Valid(channel3, channel, zBooleanValue, iIntValue, num2 != null ? num2.intValue() : 0, z2, nsfw, nsfwAllowance, callModel, channel2);
    }
}
