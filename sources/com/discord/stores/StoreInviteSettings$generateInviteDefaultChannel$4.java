package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$generateInviteDefaultChannel$4<T, R> implements b<Long, Observable<? extends ModelInvite>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreInviteSettings this$0;

    public StoreInviteSettings$generateInviteDefaultChannel$4(StoreInviteSettings storeInviteSettings, long j) {
        this.this$0 = storeInviteSettings;
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModelInvite> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelInvite> call2(Long l) {
        if (l != null) {
            long jLongValue = l.longValue();
            StoreInviteSettings storeInviteSettings = this.this$0;
            Observable<ModelInvite> observableGenerateInvite = storeInviteSettings.generateInvite(jLongValue, storeInviteSettings.getInviteSettings(this.$guildId));
            if (observableGenerateInvite != null) {
                return observableGenerateInvite;
            }
        }
        return new k(null);
    }
}
