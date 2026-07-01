package com.discord.utilities.rest;

import com.discord.models.domain.Harvest;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$HarvestState$LastRequested extends RestAPI$HarvestState {
    private final Harvest data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestAPI$HarvestState$LastRequested(Harvest harvest) {
        super(null);
        m.checkNotNullParameter(harvest, "data");
        this.data = harvest;
    }

    public final Harvest getData() {
        return this.data;
    }
}
