package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import j0.k.b;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1$1<T, R> implements b<StageRoles, WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid> {
    public final /* synthetic */ CallModel $callModel;

    public WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1$1(CallModel callModel) {
        this.$callModel = callModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid call(StageRoles stageRoles) {
        return call2(stageRoles);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid call2(StageRoles stageRoles) {
        return new WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid(this.$callModel, stageRoles, null);
    }
}
