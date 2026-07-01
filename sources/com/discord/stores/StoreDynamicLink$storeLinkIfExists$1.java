package com.discord.stores;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.m0.a;
import com.discord.utilities.intent.IntentUtils;
import d0.g0.t;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.ListIterator;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$storeLinkIfExists$1<T, R> implements b<Uri, StoreDynamicLink$DynamicLinkData> {
    public static final StoreDynamicLink$storeLinkIfExists$1 INSTANCE = new StoreDynamicLink$storeLinkIfExists$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreDynamicLink$DynamicLinkData call(Uri uri) {
        return call2(uri);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x009b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0112  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreDynamicLink$DynamicLinkData call2(Uri uri) {
        String str;
        String str2;
        String queryParameter;
        String queryParameter2;
        List<String> groupValues;
        String strPrevious;
        String path;
        List<String> groupValues2;
        String strPrevious2;
        String path2;
        String queryParameter3 = null;
        if (m.areEqual(uri, Uri.EMPTY)) {
            return null;
        }
        IntentUtils intentUtils = IntentUtils.INSTANCE;
        m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        Uri uri2 = intentUtils.isHttpDomainUrl(uri) ? uri : null;
        a aVar = a.G;
        m.checkNotNullParameter(uri, "$this$isInviteLink");
        boolean z2 = false;
        if (t.equals(uri.getHost(), a.d, true) || ((t.equals(uri.getHost(), a.a, true) || t.equals(uri.getHost(), a.f60b, true)) && (path2 = uri.getPath()) != null && a.n.matches(path2))) {
            Regex regex = a.n;
            String path3 = uri.getPath();
            if (path3 == null) {
                path3 = "";
            }
            m.checkNotNullExpressionValue(path3, "uri.path ?: \"\"");
            MatchResult matchResultMatchEntire = regex.matchEntire(path3);
            if (matchResultMatchEntire == null || (groupValues2 = matchResultMatchEntire.getGroupValues()) == null) {
                str = null;
            } else {
                ListIterator<String> listIterator = groupValues2.listIterator(groupValues2.size());
                do {
                    if (!listIterator.hasPrevious()) {
                        strPrevious2 = null;
                        break;
                    }
                    strPrevious2 = listIterator.previous();
                } while (!(!t.isBlank(strPrevious2)));
                str = strPrevious2;
            }
        } else {
            str = null;
        }
        a aVar2 = a.G;
        m.checkNotNullParameter(uri, "$this$isGuildTemplateLink");
        if (t.equals(uri.getHost(), a.e, true) || ((t.equals(uri.getHost(), a.a, true) || t.equals(uri.getHost(), a.f60b, true)) && (path = uri.getPath()) != null && a.p.matches(path))) {
            z2 = true;
        }
        if (z2) {
            Regex regex2 = a.p;
            String path4 = uri.getPath();
            String str3 = path4 != null ? path4 : "";
            m.checkNotNullExpressionValue(str3, "uri.path ?: \"\"");
            MatchResult matchResultMatchEntire2 = regex2.matchEntire(str3);
            if (matchResultMatchEntire2 == null || (groupValues = matchResultMatchEntire2.getGroupValues()) == null) {
                str2 = null;
            } else {
                ListIterator<String> listIterator2 = groupValues.listIterator(groupValues.size());
                do {
                    if (!listIterator2.hasPrevious()) {
                        strPrevious = null;
                        break;
                    }
                    strPrevious = listIterator2.previous();
                } while (!(!t.isBlank(strPrevious)));
                str2 = strPrevious;
            }
        } else {
            str2 = null;
        }
        try {
            queryParameter = uri.getQueryParameter("fingerprint");
        } catch (Exception unused) {
            queryParameter = null;
        }
        try {
            queryParameter2 = uri.getQueryParameter("attemptId");
        } catch (Exception unused2) {
            queryParameter2 = null;
        }
        try {
            queryParameter3 = uri.getQueryParameter("auth_token");
        } catch (Exception unused3) {
        }
        return new StoreDynamicLink$DynamicLinkData(uri2, queryParameter, queryParameter2, str, str2, queryParameter3);
    }
}
