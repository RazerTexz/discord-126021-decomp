package com.discord.utilities.captcha;

import b.i.a.f.e.o.f;
import b.i.d.c;
import b.i.d.e;
import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CaptchaErrorBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaErrorBody$Companion {
    private CaptchaErrorBody$Companion() {
    }

    public final CaptchaErrorBody createFromError(Error error) {
        m.checkNotNullParameter(error, "error");
        String bodyText = error.getBodyText();
        if (bodyText == null) {
            return null;
        }
        e eVar = new e();
        eVar.c = c.m;
        try {
            return (CaptchaErrorBody) f.E1(CaptchaErrorBody.class).cast(eVar.a().g(bodyText, CaptchaErrorBody.class));
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "failed to parse captcha error body", e, null, 4, null);
            return null;
        }
    }

    public final CaptchaErrorBody createFromString(String errorString) {
        m.checkNotNullParameter(errorString, "errorString");
        e eVar = new e();
        eVar.c = c.m;
        try {
            return (CaptchaErrorBody) f.E1(CaptchaErrorBody.class).cast(eVar.a().g(errorString, CaptchaErrorBody.class));
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "failed to parse captcha error body", e, null, 4, null);
            return null;
        }
    }

    public /* synthetic */ CaptchaErrorBody$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
