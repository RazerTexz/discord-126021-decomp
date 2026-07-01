package com.discord.gateway.rest;

import com.discord.models.domain.ModelGateway;
import i0.f0.GET;
import rx.Observable;

/* JADX INFO: compiled from: RestApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestApi {
    @GET("gateway")
    Observable<ModelGateway> getGateway();
}
