package com.discord.utilities.rest;

import com.discord.BuildConfig;
import com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$AppHeadersProvider implements RequiredHeadersInterceptor$HeadersProvider {
    public static final RestAPI$AppHeadersProvider INSTANCE = new RestAPI$AppHeadersProvider();
    public static Function0<String> authTokenProvider = RestAPI$AppHeadersProvider$authTokenProvider$1.INSTANCE;
    public static Function0<String> fingerprintProvider = RestAPI$AppHeadersProvider$fingerprintProvider$1.INSTANCE;
    public static Function0<String> localeProvider = RestAPI$AppHeadersProvider$localeProvider$1.INSTANCE;
    public static Function0<String> acceptLanguageProvider = RestAPI$AppHeadersProvider$acceptLanguageProvider$1.INSTANCE;
    public static Function0<String> spotifyTokenProvider = RestAPI$AppHeadersProvider$spotifyTokenProvider$1.INSTANCE;

    private RestAPI$AppHeadersProvider() {
    }

    @Override // com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider
    public String getAcceptLanguages() {
        return acceptLanguageProvider.invoke();
    }

    @Override // com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider
    public String getAuthToken() {
        return authTokenProvider.invoke();
    }

    @Override // com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider
    public String getFingerprint() {
        return fingerprintProvider.invoke();
    }

    @Override // com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider
    public String getLocale() {
        return localeProvider.invoke();
    }

    @Override // com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider
    public String getSpotifyToken() {
        return spotifyTokenProvider.invoke();
    }

    @Override // com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider
    public String getUserAgent() {
        return BuildConfig.USER_AGENT;
    }
}
