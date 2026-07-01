package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap$e;
import j0.k.b;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$getClientVersion$1<T, R> implements b<JsonObject, Integer> {
    public static final RestAPI$getClientVersion$1 INSTANCE = new RestAPI$getClientVersion$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(JsonObject jsonObject) {
        return call2(jsonObject);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(JsonObject jsonObject) {
        int iC;
        if (jsonObject == null) {
            iC = 0;
        } else {
            LinkedTreeMap$e<String, JsonElement> linkedTreeMap$eC = jsonObject.a.c("discord_android_min_version");
            JsonElement jsonElement = linkedTreeMap$eC != null ? linkedTreeMap$eC.p : null;
            if (jsonElement != null) {
                iC = jsonElement.c();
            } else {
                iC = 0;
            }
        }
        return Integer.valueOf(iC);
    }
}
