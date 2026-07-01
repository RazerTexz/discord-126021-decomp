package com.discord.restapi;


/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RequiredHeadersInterceptor$HeadersProvider {
    String getAcceptLanguages();

    String getAuthToken();

    String getFingerprint();

    String getLocale();

    String getSpotifyToken();

    String getUserAgent();
}
