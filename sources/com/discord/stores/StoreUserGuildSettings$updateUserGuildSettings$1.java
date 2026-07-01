package com.discord.stores;

import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$updateUserGuildSettings$1 extends o implements Function1<ModelNotificationSettings, Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreUserGuildSettings$SettingsUpdateType $settingsUpdateType;
    public final /* synthetic */ StoreUserGuildSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$updateUserGuildSettings$1(StoreUserGuildSettings storeUserGuildSettings, Long l, StoreUserGuildSettings$SettingsUpdateType storeUserGuildSettings$SettingsUpdateType) {
        super(1);
        this.this$0 = storeUserGuildSettings;
        this.$channelId = l;
        this.$settingsUpdateType = storeUserGuildSettings$SettingsUpdateType;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelNotificationSettings modelNotificationSettings) {
        invoke2(modelNotificationSettings);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelNotificationSettings modelNotificationSettings) {
        m.checkNotNullParameter(modelNotificationSettings, "notifSettings");
        StoreUserGuildSettings.access$getAnalytics$p(this.this$0).onNotificationSettingsUpdated(modelNotificationSettings, this.$channelId);
        StoreUserGuildSettings.access$getEventSubject$p(this.this$0).k.onNext((T) new StoreUserGuildSettings$Event$SettingsUpdated(this.$settingsUpdateType));
    }
}
