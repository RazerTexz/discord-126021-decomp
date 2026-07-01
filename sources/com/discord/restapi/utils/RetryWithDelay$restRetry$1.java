package com.discord.restapi.utils;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.HttpException;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay$restRetry$1 extends o implements Function1<Throwable, Boolean> {
    public static final RetryWithDelay$restRetry$1 INSTANCE = new RetryWithDelay$restRetry$1();

    public RetryWithDelay$restRetry$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke2(th));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Throwable th) {
        Response response;
        Request request;
        String str;
        m.checkNotNullParameter(th, "throwable");
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            int iA = httpException.a();
            retrofit2.Response<?> response2 = httpException.j;
            if ((response2 != null && (response = response2.a) != null && (request = response.request) != null && (str = request.method) != null && (!m.areEqual(str, ShareTarget.METHOD_GET))) || iA == 401 || iA == 429 || iA == 503 || iA == 403 || iA == 404) {
                return false;
            }
        } else if (th instanceof TimeoutException) {
            return false;
        }
        return th instanceof IOException;
    }
}
