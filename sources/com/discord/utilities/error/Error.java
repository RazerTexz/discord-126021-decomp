package com.discord.utilities.error;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.a;
import com.discord.utilities.captcha.CaptchaHelper$Failure;
import com.discord.utilities.guildautomod.AutoModBlockFailure;
import com.discord.utilities.images.MGImagesBitmap$ImageNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.functions.Action1;
import rx.functions.Action3;

/* JADX INFO: loaded from: classes2.dex */
public class Error {
    private static Action3<String, Throwable, Map<String, String>> onUnhandledError = null;
    private static boolean unexpectedExceptionsCrashDebug = true;

    @Nullable
    private final String bodyText;

    @Nullable
    private final Map<String, String> metadata;

    @NonNull
    private final Error$Response response;

    @NonNull
    private final Throwable throwable;

    @NonNull
    private final Error$Type type;

    @NonNull
    private final AtomicBoolean showErrorToasts = new AtomicBoolean(true);

    @NonNull
    private final AtomicBoolean shouldLog = new AtomicBoolean(true);

    public Error(@NonNull Throwable th, @NonNull Error$Type error$Type, @NonNull Error$Response error$Response, @Nullable Map<String, String> map, @Nullable String str) {
        Objects.requireNonNull(th, "throwable is marked non-null but is null");
        Objects.requireNonNull(error$Type, "type is marked non-null but is null");
        Objects.requireNonNull(error$Response, "response is marked non-null but is null");
        this.throwable = th;
        this.type = error$Type;
        this.response = error$Response;
        this.metadata = map;
        this.bodyText = str;
    }

    public static Error create(@NonNull Throwable th) {
        Error$Type error$Type;
        Error$Type error$Type2;
        Error$Response error$Response;
        Map<String, String> map;
        String str;
        String requestUrl;
        Headers headers;
        String strD;
        String str2;
        Error$Type error$Type3;
        Map<String, String> map2;
        String message = "";
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            int iA = httpException.a();
            Response<?> response = httpException.j;
            if (response != null) {
                headers = response.a.headers;
                ResponseBody responseBody = response.c;
                if (responseBody != null) {
                    MediaType mediaTypeB = responseBody.b();
                    str2 = mediaTypeB != null ? mediaTypeB.mediaType : "";
                    message = mediaTypeB != null ? mediaTypeB.subtype : "";
                    try {
                        strD = responseBody.d();
                        responseBody.close();
                    } catch (IOException unused) {
                        responseBody.close();
                        strD = null;
                    } catch (Throwable th2) {
                        responseBody.close();
                        throw th2;
                    }
                } else {
                    strD = null;
                    str2 = null;
                }
                requestUrl = getRequestUrl(response.a);
            } else {
                requestUrl = null;
                headers = null;
                strD = null;
                str2 = null;
            }
            if (iA == 500) {
                error$Type3 = Error$Type.INTERNAL_SERVER_ERROR;
            } else if (iA == 502 || iA == 503 || iA == 520 || iA == 521 || iA == 522 || iA == 525) {
                error$Type3 = Error$Type.INTERMITTENT_CLOUD_FLARE;
            } else if (iA == 401) {
                error$Type3 = Error$Type.UNAUTHORIZED;
            } else if (iA == 403 && message.contains("html")) {
                error$Type3 = Error$Type.FORBIDDEN_CLOUD_FLARE;
            } else {
                if (iA == 413) {
                    error$Type3 = Error$Type.REQUEST_TOO_LARGE;
                } else {
                    Error$Response error$Response2 = new Error$Response(strD, null);
                    if (iA == 400) {
                        error$Type3 = Error$Type.DISCORD_BAD_REQUEST;
                    } else if (iA == 403) {
                        error$Type3 = Error$Type.FORBIDDEN_DISCORD;
                    } else if (error$Response2.isKnownResponse()) {
                        error$Type3 = Error$Type.DISCORD_REQUEST_ERROR;
                    } else if (iA == 404) {
                        error$Type3 = Error$Type.DISCORD_REQUEST_RESOURCE_NOT_FOUND;
                    } else if (iA == 429) {
                        error$Type3 = Error$Type.RATE_LIMITED;
                    } else {
                        Error$Type error$Type4 = Error$Type.DISCORD_REQUEST_ERROR_UNKNOWN;
                        Map<String, String> metaData = getMetaData(requestUrl, iA, str2, headers);
                        error$Response = error$Response2;
                        map2 = metaData;
                        error$Type3 = error$Type4;
                    }
                    error$Response = error$Response2;
                    map2 = null;
                }
                error$Type2 = error$Type3;
                map = map2;
                str = strD;
            }
            map2 = null;
            error$Response = null;
            error$Type2 = error$Type3;
            map = map2;
            str = strD;
        } else {
            if (th instanceof UnknownHostException) {
                error$Type = Error$Type.NETWORK;
            } else if (th instanceof IOException) {
                message = th.getMessage() != null ? th.getMessage() : "";
                if (message.contains("Canceled") || message.contains("Connection reset by peer") || message.contains("stream was reset:") || (th instanceof NoRouteToHostException) || (th instanceof SocketException) || (th instanceof InterruptedIOException) || ((th.getCause() != null && (th.getCause() instanceof InterruptedException)) || (th.getCause() instanceof SocketTimeoutException))) {
                    error$Type = Error$Type.NETWORK;
                } else {
                    error$Type = ((th instanceof SSLHandshakeException) || (th instanceof SSLException)) ? Error$Type.SSL : Error$Type.OTHER;
                }
            } else if (th instanceof TimeoutException) {
                error$Type = Error$Type.TIMEOUT;
            } else if (th instanceof CaptchaHelper$Failure) {
                error$Type = Error$Type.CAPTCHA_KNOWN_FAILURE;
            } else if (th instanceof MGImagesBitmap$ImageNotFoundException) {
                error$Type = Error$Type.IMAGE_NOT_FOUND;
            } else {
                error$Type = th instanceof AutoModBlockFailure ? Error$Type.AUTOMOD_MESSAGE_BLOCKED : Error$Type.OTHER;
            }
            error$Type2 = error$Type;
            error$Response = null;
            map = null;
            str = null;
        }
        return new Error(th, error$Type2, error$Response == null ? new Error$Response(null, null) : error$Response, map, str);
    }

    private static Map<String, String> getMetaData(String str, int i, String str2, Headers headers) {
        HashMap map = new HashMap();
        map.put("responseCode", String.valueOf(i));
        map.put("requestUrl", str);
        map.put("content-type", str2);
        map.put("CF-Ray", headers != null ? headers.c("CF-Ray") : null);
        return map;
    }

    @Nullable
    private static String getRequestUrl(@Nullable okhttp3.Response response) {
        if (response == null) {
            return null;
        }
        return response.request.url.l;
    }

    @NonNull
    private List<String> getToastMessages(@NonNull Context context) {
        switch (this.type) {
            case FORBIDDEN_CLOUD_FLARE:
                return Collections.singletonList(context.getString(2131893171));
            case FORBIDDEN_DISCORD:
                return Collections.singletonList(Error$Response.access$100(this.response, context, 2131893173));
            case INTERMITTENT_CLOUD_FLARE:
                return Collections.singletonList(context.getString(2131893170));
            case DISCORD_REQUEST_ERROR:
            case DISCORD_REQUEST_ERROR_UNKNOWN:
                return Collections.singletonList(Error$Response.access$100(this.response, context, 2131893175));
            case DISCORD_REQUEST_RESOURCE_NOT_FOUND:
            default:
                return Collections.singletonList(context.getString(2131893178));
            case DISCORD_BAD_REQUEST:
                return Collections.singletonList(Error$Response.access$100(this.response, context, 2131893169));
            case INTERNAL_SERVER_ERROR:
                return Collections.singletonList(context.getString(2131892203));
            case REQUEST_TOO_LARGE:
                return Collections.singletonList(context.getString(2131893174));
            case UNAUTHORIZED:
                return Collections.singletonList(context.getString(2131893177));
            case RATE_LIMITED:
                return Collections.singletonList(context.getString(2131894684));
            case NETWORK:
                return Collections.singletonList(context.getString(2131893172));
            case SSL:
                return Collections.singletonList(context.getString(2131893176));
            case TIMEOUT:
                return Collections.singletonList(context.getString(2131896402));
        }
    }

    public static void handle(@NonNull Throwable th, @NonNull String str, @Nullable Action1<Error> action1, @Nullable Context context, @Nullable Boolean bool) throws Throwable {
        Error errorCreate = create(th);
        errorCreate.getType();
        Error$Type error$Type = Error$Type.OTHER;
        if (action1 != null) {
            try {
                action1.call(errorCreate);
            } catch (Exception e) {
                StringBuilder sbX = a.X(str, " / ");
                sbX.append(errorCreate.toString());
                onUnhandledError.call(str, new Exception(sbX.toString(), e), null);
                return;
            }
        }
        errorCreate.logError(str);
        if (bool == null || !bool.booleanValue()) {
            errorCreate.showToasts(context);
        }
    }

    public static void init(@NonNull Action3<String, Throwable, Map<String, String>> action3) {
        onUnhandledError = action3;
    }

    private void logError(String str) {
        Action3<String, Throwable, Map<String, String>> action3;
        if (this.shouldLog.get()) {
            int iOrdinal = this.type.ordinal();
            if (iOrdinal != 9) {
                if (iOrdinal == 17 && (action3 = onUnhandledError) != null) {
                    action3.call(str, this.throwable, this.metadata);
                    return;
                }
                return;
            }
            Action3<String, Throwable, Map<String, String>> action4 = onUnhandledError;
            if (action4 != null) {
                action4.call(this.type.name(), this.throwable, this.metadata);
            }
        }
    }

    @VisibleForTesting
    public static void setUnexpectedExceptionsCrashDebug(boolean z2) {
        unexpectedExceptionsCrashDebug = z2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Error;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Error)) {
            return false;
        }
        Error error = (Error) obj;
        if (!error.canEqual(this)) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.showErrorToasts;
        AtomicBoolean atomicBoolean2 = error.showErrorToasts;
        if (atomicBoolean != null ? !atomicBoolean.equals(atomicBoolean2) : atomicBoolean2 != null) {
            return false;
        }
        AtomicBoolean atomicBoolean3 = this.shouldLog;
        AtomicBoolean atomicBoolean4 = error.shouldLog;
        if (atomicBoolean3 != null ? !atomicBoolean3.equals(atomicBoolean4) : atomicBoolean4 != null) {
            return false;
        }
        Throwable throwable = getThrowable();
        Throwable throwable2 = error.getThrowable();
        if (throwable != null ? !throwable.equals(throwable2) : throwable2 != null) {
            return false;
        }
        Error$Type type = getType();
        Error$Type type2 = error.getType();
        if (type != null ? !type.equals(type2) : type2 != null) {
            return false;
        }
        Error$Response response = getResponse();
        Error$Response response2 = error.getResponse();
        if (response != null ? !response.equals(response2) : response2 != null) {
            return false;
        }
        Map<String, String> map = this.metadata;
        Map<String, String> map2 = error.metadata;
        if (map != null ? !map.equals(map2) : map2 != null) {
            return false;
        }
        String bodyText = getBodyText();
        String bodyText2 = error.getBodyText();
        return bodyText != null ? bodyText.equals(bodyText2) : bodyText2 == null;
    }

    @Nullable
    public String getBodyText() {
        return this.bodyText;
    }

    @Nullable
    public String getDisplayString(Context context) {
        List<String> toastMessages = getToastMessages(context);
        if (toastMessages.isEmpty()) {
            return null;
        }
        return toastMessages.get(0);
    }

    @NonNull
    public Error$Response getResponse() {
        return this.response;
    }

    @NonNull
    public Throwable getThrowable() {
        return this.throwable;
    }

    @NonNull
    public Error$Type getType() {
        return this.type;
    }

    public int hashCode() {
        AtomicBoolean atomicBoolean = this.showErrorToasts;
        int iHashCode = atomicBoolean == null ? 43 : atomicBoolean.hashCode();
        AtomicBoolean atomicBoolean2 = this.shouldLog;
        int iHashCode2 = ((iHashCode + 59) * 59) + (atomicBoolean2 == null ? 43 : atomicBoolean2.hashCode());
        Throwable throwable = getThrowable();
        int iHashCode3 = (iHashCode2 * 59) + (throwable == null ? 43 : throwable.hashCode());
        Error$Type type = getType();
        int iHashCode4 = (iHashCode3 * 59) + (type == null ? 43 : type.hashCode());
        Error$Response response = getResponse();
        int iHashCode5 = (iHashCode4 * 59) + (response == null ? 43 : response.hashCode());
        Map<String, String> map = this.metadata;
        int iHashCode6 = (iHashCode5 * 59) + (map == null ? 43 : map.hashCode());
        String bodyText = getBodyText();
        return (iHashCode6 * 59) + (bodyText != null ? bodyText.hashCode() : 43);
    }

    public void setShouldLog(boolean z2) {
        this.shouldLog.set(z2);
    }

    public void setShowErrorToasts(boolean z2) {
        this.showErrorToasts.set(z2);
    }

    @MainThread
    public void showToasts(@Nullable Context context) {
        if (!this.showErrorToasts.get() || context == null) {
            return;
        }
        Iterator<String> it = getToastMessages(context).iterator();
        while (it.hasNext()) {
            Toast.makeText(context, it.next(), 0).show();
        }
    }

    public String toString() {
        StringBuilder sbU = a.U("Error(showErrorToasts=");
        sbU.append(this.showErrorToasts);
        sbU.append(", shouldLog=");
        sbU.append(this.shouldLog);
        sbU.append(", throwable=");
        sbU.append(getThrowable());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(", response=");
        sbU.append(getResponse());
        sbU.append(", metadata=");
        sbU.append(this.metadata);
        sbU.append(", bodyText=");
        sbU.append(getBodyText());
        sbU.append(")");
        return sbU.toString();
    }

    public static void handle(@NonNull Throwable th, @NonNull String str, @Nullable Action1<Error> action1, @Nullable Context context) throws Throwable {
        handle(th, str, action1, context, Boolean.FALSE);
    }
}
