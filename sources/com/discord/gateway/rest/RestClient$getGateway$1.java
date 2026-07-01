package com.discord.gateway.rest;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGateway;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: RestClient.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestClient$getGateway$1<T, R> implements b<ModelGateway, String> {
    public static final RestClient$getGateway$1 INSTANCE = new RestClient$getGateway$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(ModelGateway modelGateway) {
        return call2(modelGateway);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(ModelGateway modelGateway) {
        m.checkNotNullExpressionValue(modelGateway, "it");
        return modelGateway.getUrl();
    }
}
