package com.discord.restapi;

import d0.o;
import d0.t.g0;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: RestAPIInterface.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIInterface$DefaultImpls {
    public static /* synthetic */ Observable getInviteCode$default(RestAPIInterface restAPIInterface, String str, boolean z2, Long l, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInviteCode");
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return restAPIInterface.getInviteCode(str, z2, l);
    }

    public static /* synthetic */ Observable getMyEntitlements$default(RestAPIInterface restAPIInterface, long j, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyEntitlements");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return restAPIInterface.getMyEntitlements(j, z2);
    }

    public static /* synthetic */ Observable getOauth2Authorize$default(RestAPIInterface restAPIInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if (obj == null) {
            return restAPIInterface.getOauth2Authorize(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? "consent" : str5, str6, (i & 64) != 0 ? null : str7);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOauth2Authorize");
    }

    public static /* synthetic */ Observable getOauth2SamsungAuthorize$default(RestAPIInterface restAPIInterface, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOauth2SamsungAuthorize");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str5 = "consent";
        }
        return restAPIInterface.getOauth2SamsungAuthorize(str, str2, str7, str4, str5, str6);
    }

    public static /* synthetic */ Observable joinGuild$default(RestAPIInterface restAPIInterface, long j, boolean z2, String str, Long l, RestAPIParams$InviteCode restAPIParams$InviteCode, String str2, int i, Object obj) {
        if (obj == null) {
            return restAPIInterface.joinGuild(j, z2, str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : restAPIParams$InviteCode, (i & 32) != 0 ? null : str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinGuild");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable postOauth2Authorize$default(RestAPIInterface restAPIInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map map, int i, Object obj) {
        if (obj == null) {
            return restAPIInterface.postOauth2Authorize(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? "consent" : str5, str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? g0.mapOf(o.to("authorize", "true")) : map);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOauth2Authorize");
    }

    public static /* synthetic */ Observable report$default(RestAPIInterface restAPIInterface, Long l, Long l2, Long l3, Long l4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
        }
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            l2 = null;
        }
        if ((i & 4) != 0) {
            l3 = null;
        }
        if ((i & 8) != 0) {
            l4 = null;
        }
        return restAPIInterface.report(l, l2, l3, l4);
    }

    public static /* synthetic */ Observable userProfileGet$default(RestAPIInterface restAPIInterface, long j, boolean z2, Long l, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userProfileGet");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return restAPIInterface.userProfileGet(j, z2, l);
    }
}
