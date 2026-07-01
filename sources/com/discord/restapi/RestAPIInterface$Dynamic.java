package com.discord.restapi;

import com.google.gson.JsonObject;
import i0.f0.f;
import i0.f0.y;
import rx.Observable;

/* JADX INFO: compiled from: RestAPIInterface.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestAPIInterface$Dynamic {
    @f
    Observable<JsonObject> get(@y String url);
}
