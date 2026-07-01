package com.discord.widgets.voice.fullscreen;

import com.discord.api.application.ApplicationAsset;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.stores.StoreConnectivity$DelayedState;
import com.discord.stores.StoreMediaSettings$NoiseProcessing;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function14;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$observeStoreState$1$1$1 extends o implements Function14<StageCallModel, Long, Float, RtcConnection$Quality, Boolean, Integer, StoreConnectivity$DelayedState, StageRoles, Experiment, Boolean, Channel, Map<Long, ? extends Integer>, Integer, Map<Long, ? extends ApplicationAsset>, WidgetCallFullscreenViewModel$StoreState> {
    public final /* synthetic */ CallModel $callModel;
    public final /* synthetic */ WidgetCallFullscreenViewModel$observeStoreState$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$observeStoreState$1$1$1(WidgetCallFullscreenViewModel$observeStoreState$1$1 widgetCallFullscreenViewModel$observeStoreState$1$1, CallModel callModel) {
        super(14);
        this.this$0 = widgetCallFullscreenViewModel$observeStoreState$1$1;
        this.$callModel = callModel;
    }

    @Override // kotlin.jvm.functions.Function14
    public /* bridge */ /* synthetic */ WidgetCallFullscreenViewModel$StoreState invoke(StageCallModel stageCallModel, Long l, Float f, RtcConnection$Quality rtcConnection$Quality, Boolean bool, Integer num, StoreConnectivity$DelayedState storeConnectivity$DelayedState, StageRoles stageRoles, Experiment experiment, Boolean bool2, Channel channel, Map<Long, ? extends Integer> map, Integer num2, Map<Long, ? extends ApplicationAsset> map2) {
        return invoke(stageCallModel, l, f, rtcConnection$Quality, bool.booleanValue(), num.intValue(), storeConnectivity$DelayedState, stageRoles, experiment, bool2.booleanValue(), channel, (Map<Long, Integer>) map, num2.intValue(), (Map<Long, ApplicationAsset>) map2);
    }

    public final WidgetCallFullscreenViewModel$StoreState invoke(StageCallModel stageCallModel, Long l, Float f, RtcConnection$Quality rtcConnection$Quality, boolean z2, int i, StoreConnectivity$DelayedState storeConnectivity$DelayedState, StageRoles stageRoles, Experiment experiment, boolean z3, Channel channel, Map<Long, Integer> map, int i2, Map<Long, ApplicationAsset> map2) {
        m.checkNotNullParameter(storeConnectivity$DelayedState, "connectivityState");
        m.checkNotNullParameter(map, "mentionsMap");
        m.checkNotNullParameter(map2, "embeddedAppBackgrounds");
        CallModel callModel = this.$callModel;
        if (callModel == null) {
            return WidgetCallFullscreenViewModel$StoreState$Invalid.INSTANCE;
        }
        boolean z4 = callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings$NoiseProcessing.Cancellation;
        CallModel callModel2 = this.$callModel;
        Boolean boolValueOf = Boolean.valueOf(z4);
        m.checkNotNullExpressionValue(f, "streamVolume");
        float fFloatValue = f.floatValue();
        boolean z5 = experiment != null && experiment.getBucket() == 1;
        boolean z6 = channel != null && ChannelUtils.J(channel);
        Integer num = map.get(Long.valueOf(WidgetCallFullscreenViewModel.access$getChannelId$p(this.this$0.this$0.this$0)));
        return new WidgetCallFullscreenViewModel$StoreState$Valid(callModel2, stageCallModel, boolValueOf, l, fFloatValue, rtcConnection$Quality, z2, i, storeConnectivity$DelayedState, stageRoles, z5, z3, z6, num != null ? num.intValue() : 0, i2, map2, null);
    }
}
