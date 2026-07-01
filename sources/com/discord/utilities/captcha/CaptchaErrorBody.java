package com.discord.utilities.captcha;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CaptchaErrorBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CaptchaErrorBody implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> captchaKey;
    private final String captchaRqdata;
    private final String captchaRqtoken;
    private final CaptchaService captchaService;
    private final String captchaSitekey;

    /* JADX INFO: compiled from: CaptchaErrorBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public final CaptchaErrorBody createFromError(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            String bodyText = error.getBodyText();
            if (bodyText == null) {
                return null;
            }
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.c = FieldNamingPolicy.m;
            try {
                return (CaptchaErrorBody) f.E1(CaptchaErrorBody.class).cast(gsonBuilder.a().g(bodyText, CaptchaErrorBody.class));
            } catch (Exception e) {
                Logger.e$default(AppLog.g, "failed to parse captcha error body", e, null, 4, null);
                return null;
            }
        }

        public final CaptchaErrorBody createFromString(String errorString) {
            Intrinsics3.checkNotNullParameter(errorString, "errorString");
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.c = FieldNamingPolicy.m;
            try {
                return (CaptchaErrorBody) f.E1(CaptchaErrorBody.class).cast(gsonBuilder.a().g(errorString, CaptchaErrorBody.class));
            } catch (Exception e) {
                Logger.e$default(AppLog.g, "failed to parse captcha error body", e, null, 4, null);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CaptchaErrorBody(List<String> list, String str, CaptchaService captchaService, String str2, String str3) {
        this.captchaKey = list;
        this.captchaSitekey = str;
        this.captchaService = captchaService;
        this.captchaRqdata = str2;
        this.captchaRqtoken = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CaptchaErrorBody copy$default(CaptchaErrorBody captchaErrorBody, List list, String str, CaptchaService captchaService, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = captchaErrorBody.captchaKey;
        }
        if ((i & 2) != 0) {
            str = captchaErrorBody.captchaSitekey;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            captchaService = captchaErrorBody.captchaService;
        }
        CaptchaService captchaService2 = captchaService;
        if ((i & 8) != 0) {
            str2 = captchaErrorBody.captchaRqdata;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = captchaErrorBody.captchaRqtoken;
        }
        return captchaErrorBody.copy(list, str4, captchaService2, str5, str3);
    }

    public final List<String> component1() {
        return this.captchaKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCaptchaSitekey() {
        return this.captchaSitekey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CaptchaService getCaptchaService() {
        return this.captchaService;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCaptchaRqdata() {
        return this.captchaRqdata;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaErrorBody copy(List<String> captchaKey, String captchaSitekey, CaptchaService captchaService, String captchaRqdata, String captchaRqtoken) {
        return new CaptchaErrorBody(captchaKey, captchaSitekey, captchaService, captchaRqdata, captchaRqtoken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptchaErrorBody)) {
            return false;
        }
        CaptchaErrorBody captchaErrorBody = (CaptchaErrorBody) other;
        return Intrinsics3.areEqual(this.captchaKey, captchaErrorBody.captchaKey) && Intrinsics3.areEqual(this.captchaSitekey, captchaErrorBody.captchaSitekey) && Intrinsics3.areEqual(this.captchaService, captchaErrorBody.captchaService) && Intrinsics3.areEqual(this.captchaRqdata, captchaErrorBody.captchaRqdata) && Intrinsics3.areEqual(this.captchaRqtoken, captchaErrorBody.captchaRqtoken);
    }

    public final List<String> getCaptchaKey() {
        return this.captchaKey;
    }

    public final String getCaptchaRqdata() {
        return this.captchaRqdata;
    }

    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaService getCaptchaService() {
        return this.captchaService;
    }

    public final String getCaptchaSitekey() {
        return this.captchaSitekey;
    }

    public int hashCode() {
        List<String> list = this.captchaKey;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.captchaSitekey;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        CaptchaService captchaService = this.captchaService;
        int iHashCode3 = (iHashCode2 + (captchaService != null ? captchaService.hashCode() : 0)) * 31;
        String str2 = this.captchaRqdata;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.captchaRqtoken;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CaptchaErrorBody(captchaKey=");
        sbU.append(this.captchaKey);
        sbU.append(", captchaSitekey=");
        sbU.append(this.captchaSitekey);
        sbU.append(", captchaService=");
        sbU.append(this.captchaService);
        sbU.append(", captchaRqdata=");
        sbU.append(this.captchaRqdata);
        sbU.append(", captchaRqtoken=");
        return outline.J(sbU, this.captchaRqtoken, ")");
    }
}
