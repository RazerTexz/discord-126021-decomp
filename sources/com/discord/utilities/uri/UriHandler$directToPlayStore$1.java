package com.discord.utilities.uri;

import android.net.Uri;
import android.net.Uri$Builder;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$directToPlayStore$1 extends o implements Function1<String, String> {
    public final /* synthetic */ String $packageName;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UriHandler$directToPlayStore$1(String str, String str2) {
        super(1);
        this.$packageName = str;
        this.$source = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        Uri$Builder uri$BuilderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_ID, this.$packageName);
        StringBuilder sbU = a.U("utm_source=");
        sbU.append(this.$source);
        String string = uri$BuilderAppendQueryParameter.appendQueryParameter(Constants.REFERRER, sbU.toString()).build().toString();
        m.checkNotNullExpressionValue(string, "Uri.parse(uri).buildUpon…ild()\n        .toString()");
        return string;
    }
}
