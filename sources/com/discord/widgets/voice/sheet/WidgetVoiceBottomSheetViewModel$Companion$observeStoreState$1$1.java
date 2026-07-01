package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMediaSettings$NoiseProcessing;
import com.discord.widgets.voice.model.CallModel;
import d0.t.n0;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1$1<T1, T2, T3, R> implements Func3<CallModel, Long, Boolean, WidgetVoiceBottomSheetViewModel$StoreState> {
    public static final WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1$1 INSTANCE = new WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetVoiceBottomSheetViewModel$StoreState call(CallModel callModel, Long l, Boolean bool) {
        return call2(callModel, l, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceBottomSheetViewModel$StoreState call2(CallModel callModel, Long l, Boolean bool) {
        if (callModel != null) {
            if (n0.setOf((Object[]) new Integer[]{2, 13, 1, 3}).contains(Integer.valueOf(callModel.getChannel().getType()))) {
                Boolean boolValueOf = Boolean.valueOf(callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings$NoiseProcessing.Cancellation);
                m.checkNotNullExpressionValue(bool, "textInVoiceEnabled");
                return new WidgetVoiceBottomSheetViewModel$StoreState$Valid(callModel, boolValueOf, l, bool.booleanValue());
            }
        }
        return WidgetVoiceBottomSheetViewModel$StoreState$Invalid.INSTANCE;
    }
}
