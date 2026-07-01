package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserSettings;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings$setIsAccessibilityDetectionAllowed$1<T> implements Action1<ModelUserSettings> {
    public final /* synthetic */ boolean $allowAccessibilityDetection;
    public final /* synthetic */ StoreUserSettings this$0;

    public StoreUserSettings$setIsAccessibilityDetectionAllowed$1(StoreUserSettings storeUserSettings, boolean z2) {
        this.this$0 = storeUserSettings;
        this.$allowAccessibilityDetection = z2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelUserSettings modelUserSettings) {
        call2(modelUserSettings);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelUserSettings modelUserSettings) {
        StoreUserSettings.access$updateAllowAccessibilityDetectionInternal(this.this$0, this.$allowAccessibilityDetection);
    }
}
