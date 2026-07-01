package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Harvest;
import j0.k.b;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$getHarvestStatusGuarded$1<T, R> implements b<Harvest, RestAPI$HarvestState> {
    public static final RestAPI$getHarvestStatusGuarded$1 INSTANCE = new RestAPI$getHarvestStatusGuarded$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ RestAPI$HarvestState call(Harvest harvest) {
        return call2(harvest);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final RestAPI$HarvestState call2(Harvest harvest) {
        return harvest != null ? new RestAPI$HarvestState$LastRequested(harvest) : new RestAPI$HarvestState$NeverRequested();
    }
}
