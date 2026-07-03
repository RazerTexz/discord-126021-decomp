package com.discord.widgets.auth;

import android.net.Uri;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$Companion$createOauthAuthorize$1 extends AbstractC12240o implements Function2<Uri, String, String> {
    public static final WidgetOauth2Authorize$Companion$createOauthAuthorize$1 INSTANCE = new WidgetOauth2Authorize$Companion$createOauthAuthorize$1();

    public WidgetOauth2Authorize$Companion$createOauthAuthorize$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final String invoke(Uri uri, String str) {
        C12238m.checkNotNullParameter(uri, "$this$getQueryParameterOrThrow");
        C12238m.checkNotNullParameter(str, "parameterName");
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            return queryParameter;
        }
        throw new IllegalArgumentException(str);
    }
}
