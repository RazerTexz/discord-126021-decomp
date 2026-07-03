package com.discord.gateway.rest;

import com.discord.models.domain.ModelGateway;
import p630i0.p636f0.InterfaceC12533f;
import p658rx.Observable;

/* JADX INFO: compiled from: RestApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestApi {
    @InterfaceC12533f("gateway")
    Observable<ModelGateway> getGateway();
}
