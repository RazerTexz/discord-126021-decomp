package com.discord.widgets.auth;

import android.net.Uri;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$Companion$createOauthAuthorize$1 extends o implements Function2<Uri, String, String> {
    public static final WidgetOauth2Authorize$Companion$createOauthAuthorize$1 INSTANCE = new WidgetOauth2Authorize$Companion$createOauthAuthorize$1();

    public WidgetOauth2Authorize$Companion$createOauthAuthorize$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(Uri uri, String str) {
        return invoke2(uri, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Uri uri, String str) {
        m.checkNotNullParameter(uri, "$this$getQueryParameterOrThrow");
        m.checkNotNullParameter(str, "parameterName");
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            return queryParameter;
        }
        throw new IllegalArgumentException(str);
    }
}
