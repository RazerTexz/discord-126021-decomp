package com.discord.utilities.error;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildautomod.AutoModUtils2;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.rest.RestAPIAbortMessages;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.StringReader;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
    private final Response response;

    @NonNull
    private final Throwable throwable;

    @NonNull
    private final Type type;

    @NonNull
    private final AtomicBoolean showErrorToasts = new AtomicBoolean(true);

    @NonNull
    private final AtomicBoolean shouldLog = new AtomicBoolean(true);

    /* JADX INFO: renamed from: com.discord.utilities.error.Error$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$discord$utilities$error$Error$Type;

        static {
            Type.values();
            int[] iArr = new int[18];
            $SwitchMap$com$discord$utilities$error$Error$Type = iArr;
            try {
                iArr[Type.DISCORD_REQUEST_ERROR_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.INTERMITTENT_CLOUD_FLARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.FORBIDDEN_CLOUD_FLARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.RATE_LIMITED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.FORBIDDEN_DISCORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.DISCORD_REQUEST_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.DISCORD_BAD_REQUEST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.NETWORK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.SSL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.TIMEOUT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.REQUEST_TOO_LARGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.UNAUTHORIZED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$discord$utilities$error$Error$Type[Type.INTERNAL_SERVER_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static class Response implements Model {
        private int code;
        private boolean global;

        @Nullable
        private String message;

        @NonNull
        private Map<String, List<String>> messages;
        private double retryAfter;

        @Nullable
        private SkemaError skemaError;

        public /* synthetic */ Response(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        @SuppressLint({"ResourceType"})
        private String getMessageToast(Context context, @StringRes int i) {
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(this.code);
            if (abortCodeMessageResId != null) {
                return context.getString(abortCodeMessageResId.intValue());
            }
            SkemaError skemaError = this.skemaError;
            if (skemaError != null) {
                if (!skemaError.errors.isEmpty()) {
                    return ((SkemaErrorItem) this.skemaError.errors.get(0)).message;
                }
                for (SkemaError skemaError2 : this.skemaError.subErrors.values()) {
                    if (!skemaError2.errors.isEmpty()) {
                        return ((SkemaErrorItem) skemaError2.errors.get(0)).message;
                    }
                }
            }
            String str = this.message;
            if (str != null) {
                return str;
            }
            Iterator<List<String>> it = this.messages.values().iterator();
            while (it.hasNext()) {
                for (String str2 : it.next()) {
                    if (str2 != null) {
                        return str2;
                    }
                }
            }
            return context.getString(i);
        }

        @Override // com.discord.models.domain.Model
        public void assignField(final Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "errors":
                    SkemaError skemaError = (SkemaError) jsonReader.parse(new SkemaError(null));
                    this.skemaError = skemaError;
                    if (!skemaError.errors.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = this.skemaError.errors.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((SkemaErrorItem) it.next()).message);
                        }
                        this.messages.put("_misc", arrayList);
                    }
                    for (Map.Entry entry : this.skemaError.subErrors.entrySet()) {
                        ArrayList arrayList2 = new ArrayList();
                        String str = (String) entry.getKey();
                        SkemaError skemaError2 = (SkemaError) entry.getValue();
                        if (!skemaError2.errors.isEmpty()) {
                            Iterator it2 = skemaError2.errors.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(((SkemaErrorItem) it2.next()).message);
                            }
                        }
                        arrayList2.addAll(skemaError2.subErrors.keySet());
                        this.messages.put(str, arrayList2);
                    }
                    break;
                case "global":
                    this.global = jsonReader.nextBoolean(this.global);
                    break;
                case "retry_after":
                    this.retryAfter = jsonReader.nextDouble(this.retryAfter);
                    break;
                case "code":
                    this.code = jsonReader.nextInt(this.code);
                    break;
                case "message":
                    this.message = jsonReader.nextString(this.message);
                    break;
                default:
                    this.messages.put(strNextName, jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.x.a.a
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final Object get() {
                            return jsonReader.nextString(null);
                        }
                    }));
                    break;
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Response;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return false;
            }
            Response response = (Response) obj;
            if (!response.canEqual(this) || getCode() != response.getCode() || Double.compare(this.retryAfter, response.retryAfter) != 0 || this.global != response.global) {
                return false;
            }
            SkemaError skemaError = this.skemaError;
            SkemaError skemaError2 = response.skemaError;
            if (skemaError != null ? !skemaError.equals(skemaError2) : skemaError2 != null) {
                return false;
            }
            Map<String, List<String>> messages = getMessages();
            Map<String, List<String>> messages2 = response.getMessages();
            if (messages != null ? !messages.equals(messages2) : messages2 != null) {
                return false;
            }
            String message = getMessage();
            String message2 = response.getMessage();
            return message != null ? message.equals(message2) : message2 == null;
        }

        public int getCode() {
            return this.code;
        }

        @Nullable
        public String getMessage() {
            return this.message;
        }

        @NonNull
        public Map<String, List<String>> getMessages() {
            return this.messages;
        }

        @Nullable
        public Long getRetryAfterMs() {
            double d = this.retryAfter;
            if (d > 0.0d) {
                return Long.valueOf((long) (d * 1000.0d));
            }
            return null;
        }

        public int hashCode() {
            int code = getCode() + 59;
            long jDoubleToLongBits = Double.doubleToLongBits(this.retryAfter);
            int i = (((code * 59) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 59) + (this.global ? 79 : 97);
            SkemaError skemaError = this.skemaError;
            int iHashCode = (i * 59) + (skemaError == null ? 43 : skemaError.hashCode());
            Map<String, List<String>> messages = getMessages();
            int iHashCode2 = (iHashCode * 59) + (messages == null ? 43 : messages.hashCode());
            String message = getMessage();
            return (iHashCode2 * 59) + (message != null ? message.hashCode() : 43);
        }

        public boolean isKnownResponse() {
            return this.code > 0 || !this.messages.isEmpty();
        }

        public String toString() {
            StringBuilder sbU = outline.U("Error.Response(code=");
            sbU.append(getCode());
            sbU.append(", retryAfter=");
            sbU.append(this.retryAfter);
            sbU.append(", global=");
            sbU.append(this.global);
            sbU.append(", skemaError=");
            sbU.append(this.skemaError);
            sbU.append(", messages=");
            sbU.append(getMessages());
            sbU.append(", message=");
            sbU.append(getMessage());
            sbU.append(")");
            return sbU.toString();
        }

        private Response(@Nullable String str) {
            this.messages = new HashMap();
            if (str != null) {
                try {
                    new Model.JsonReader(new StringReader(str)).parse(this);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class SkemaErrorItem implements Model {
        private String code;
        private String message;

        private SkemaErrorItem() {
        }

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                this.code = jsonReader.nextString(null);
            } else if (strNextName.equals("message")) {
                this.message = jsonReader.nextString(null);
            } else {
                jsonReader.skipValue();
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof SkemaErrorItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SkemaErrorItem)) {
                return false;
            }
            SkemaErrorItem skemaErrorItem = (SkemaErrorItem) obj;
            if (!skemaErrorItem.canEqual(this)) {
                return false;
            }
            String str = this.code;
            String str2 = skemaErrorItem.code;
            if (str != null ? !str.equals(str2) : str2 != null) {
                return false;
            }
            String str3 = this.message;
            String str4 = skemaErrorItem.message;
            return str3 != null ? str3.equals(str4) : str4 == null;
        }

        public int hashCode() {
            String str = this.code;
            int iHashCode = str == null ? 43 : str.hashCode();
            String str2 = this.message;
            return ((iHashCode + 59) * 59) + (str2 != null ? str2.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Error.SkemaErrorItem(code=");
            sbU.append(this.code);
            sbU.append(", message=");
            return outline.J(sbU, this.message, ")");
        }

        public /* synthetic */ SkemaErrorItem(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public enum Type {
        FORBIDDEN_CLOUD_FLARE,
        FORBIDDEN_DISCORD,
        INTERMITTENT_CLOUD_FLARE,
        DISCORD_REQUEST_ERROR,
        DISCORD_REQUEST_RESOURCE_NOT_FOUND,
        DISCORD_BAD_REQUEST,
        INTERNAL_SERVER_ERROR,
        REQUEST_TOO_LARGE,
        UNAUTHORIZED,
        DISCORD_REQUEST_ERROR_UNKNOWN,
        RATE_LIMITED,
        NETWORK,
        SSL,
        TIMEOUT,
        CAPTCHA_KNOWN_FAILURE,
        IMAGE_NOT_FOUND,
        AUTOMOD_MESSAGE_BLOCKED,
        OTHER
    }

    public Error(@NonNull Throwable th, @NonNull Type type, @NonNull Response response, @Nullable Map<String, String> map, @Nullable String str) {
        Objects.requireNonNull(th, "throwable is marked non-null but is null");
        Objects.requireNonNull(type, "type is marked non-null but is null");
        Objects.requireNonNull(response, "response is marked non-null but is null");
        this.throwable = th;
        this.type = type;
        this.response = response;
        this.metadata = map;
        this.bodyText = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Error create(@NonNull Throwable th) {
        Type type;
        Type type2;
        Response response;
        Map<String, String> map;
        String str;
        String requestUrl;
        Headers headers;
        String strD;
        String str2;
        Type type3;
        Map<String, String> map2;
        String message = "";
        String str3 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            int iA = httpException.a();
            retrofit2.Response<?> response2 = httpException.j;
            if (response2 != null) {
                headers = response2.a.headers;
                ResponseBody responseBody = response2.c;
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
                requestUrl = getRequestUrl(response2.a);
            } else {
                requestUrl = null;
                headers = null;
                strD = null;
                str2 = null;
            }
            if (iA == 500) {
                type3 = Type.INTERNAL_SERVER_ERROR;
            } else if (iA == 502 || iA == 503 || iA == 520 || iA == 521 || iA == 522 || iA == 525) {
                type3 = Type.INTERMITTENT_CLOUD_FLARE;
            } else if (iA == 401) {
                type3 = Type.UNAUTHORIZED;
            } else if (iA == 403 && message.contains("html")) {
                type3 = Type.FORBIDDEN_CLOUD_FLARE;
            } else {
                if (iA == 413) {
                    type3 = Type.REQUEST_TOO_LARGE;
                } else {
                    Response response3 = new Response(strD, objArr == true ? 1 : 0);
                    if (iA == 400) {
                        type3 = Type.DISCORD_BAD_REQUEST;
                    } else if (iA == 403) {
                        type3 = Type.FORBIDDEN_DISCORD;
                    } else if (response3.isKnownResponse()) {
                        type3 = Type.DISCORD_REQUEST_ERROR;
                    } else if (iA == 404) {
                        type3 = Type.DISCORD_REQUEST_RESOURCE_NOT_FOUND;
                    } else if (iA == 429) {
                        type3 = Type.RATE_LIMITED;
                    } else {
                        Type type4 = Type.DISCORD_REQUEST_ERROR_UNKNOWN;
                        Map<String, String> metaData = getMetaData(requestUrl, iA, str2, headers);
                        response = response3;
                        map2 = metaData;
                        type3 = type4;
                    }
                    response = response3;
                    map2 = null;
                }
                type2 = type3;
                map = map2;
                str = strD;
            }
            map2 = null;
            response = null;
            type2 = type3;
            map = map2;
            str = strD;
        } else {
            if (th instanceof UnknownHostException) {
                type = Type.NETWORK;
            } else if (th instanceof IOException) {
                message = th.getMessage() != null ? th.getMessage() : "";
                if (message.contains("Canceled") || message.contains("Connection reset by peer") || message.contains("stream was reset:") || (th instanceof NoRouteToHostException) || (th instanceof SocketException) || (th instanceof InterruptedIOException) || ((th.getCause() != null && (th.getCause() instanceof InterruptedException)) || (th.getCause() instanceof SocketTimeoutException))) {
                    type = Type.NETWORK;
                } else {
                    type = ((th instanceof SSLHandshakeException) || (th instanceof SSLException)) ? Type.SSL : Type.OTHER;
                }
            } else if (th instanceof TimeoutException) {
                type = Type.TIMEOUT;
            } else if (th instanceof CaptchaHelper.Failure) {
                type = Type.CAPTCHA_KNOWN_FAILURE;
            } else if (th instanceof MGImagesBitmap.ImageNotFoundException) {
                type = Type.IMAGE_NOT_FOUND;
            } else {
                type = th instanceof AutoModUtils2 ? Type.AUTOMOD_MESSAGE_BLOCKED : Type.OTHER;
            }
            type2 = type;
            response = null;
            map = null;
            str = null;
        }
        return new Error(th, type2, response == null ? new Response(str3, objArr2 == true ? 1 : 0) : response, map, str);
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
                return Collections.singletonList(context.getString(R.string.network_error_cloudflare_unauthorized));
            case FORBIDDEN_DISCORD:
                return Collections.singletonList(this.response.getMessageToast(context, R.string.network_error_forbidden));
            case INTERMITTENT_CLOUD_FLARE:
                return Collections.singletonList(context.getString(R.string.network_error_cloudflare_intermittent));
            case DISCORD_REQUEST_ERROR:
            case DISCORD_REQUEST_ERROR_UNKNOWN:
                return Collections.singletonList(this.response.getMessageToast(context, R.string.network_error_rest_request));
            case DISCORD_REQUEST_RESOURCE_NOT_FOUND:
            default:
                return Collections.singletonList(context.getString(R.string.network_error_unknown));
            case DISCORD_BAD_REQUEST:
                return Collections.singletonList(this.response.getMessageToast(context, R.string.network_error_bad_request));
            case INTERNAL_SERVER_ERROR:
                return Collections.singletonList(context.getString(R.string.internal_server_error));
            case REQUEST_TOO_LARGE:
                return Collections.singletonList(context.getString(R.string.network_error_request_too_large));
            case UNAUTHORIZED:
                return Collections.singletonList(context.getString(R.string.network_error_unauthorized));
            case RATE_LIMITED:
                return Collections.singletonList(context.getString(R.string.rate_limited));
            case NETWORK:
                return Collections.singletonList(context.getString(R.string.network_error_connection));
            case SSL:
                return Collections.singletonList(context.getString(R.string.network_error_ssl));
            case TIMEOUT:
                return Collections.singletonList(context.getString(R.string.timeout_error));
        }
    }

    public static void handle(@NonNull Throwable th, @NonNull String str, @Nullable Action1<Error> action1, @Nullable Context context, @Nullable Boolean bool) throws Throwable {
        Error errorCreate = create(th);
        errorCreate.getType();
        Type type = Type.OTHER;
        if (action1 != null) {
            try {
                action1.call(errorCreate);
            } catch (Exception e) {
                StringBuilder sbX = outline.X(str, " / ");
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
        Type type = getType();
        Type type2 = error.getType();
        if (type != null ? !type.equals(type2) : type2 != null) {
            return false;
        }
        Response response = getResponse();
        Response response2 = error.getResponse();
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
    public Response getResponse() {
        return this.response;
    }

    @NonNull
    public Throwable getThrowable() {
        return this.throwable;
    }

    @NonNull
    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        AtomicBoolean atomicBoolean = this.showErrorToasts;
        int iHashCode = atomicBoolean == null ? 43 : atomicBoolean.hashCode();
        AtomicBoolean atomicBoolean2 = this.shouldLog;
        int iHashCode2 = ((iHashCode + 59) * 59) + (atomicBoolean2 == null ? 43 : atomicBoolean2.hashCode());
        Throwable throwable = getThrowable();
        int iHashCode3 = (iHashCode2 * 59) + (throwable == null ? 43 : throwable.hashCode());
        Type type = getType();
        int iHashCode4 = (iHashCode3 * 59) + (type == null ? 43 : type.hashCode());
        Response response = getResponse();
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
        StringBuilder sbU = outline.U("Error(showErrorToasts=");
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

    public static class SkemaError implements Model {

        @NonNull
        private List<SkemaErrorItem> errors;

        @NonNull
        private Map<String, SkemaError> subErrors;

        private SkemaError() {
            this.errors = Collections.emptyList();
            this.subErrors = new HashMap();
        }

        @Override // com.discord.models.domain.Model
        public void assignField(final Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            if ("_errors".equals(strNextName)) {
                this.errors = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.x.a.b
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (Error.SkemaErrorItem) jsonReader.parse(new Error.SkemaErrorItem(null));
                    }
                });
            } else {
                this.subErrors.put(strNextName, (SkemaError) jsonReader.parse(new SkemaError()));
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof SkemaError;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SkemaError)) {
                return false;
            }
            SkemaError skemaError = (SkemaError) obj;
            if (!skemaError.canEqual(this)) {
                return false;
            }
            List<SkemaErrorItem> list = this.errors;
            List<SkemaErrorItem> list2 = skemaError.errors;
            if (list != null ? !list.equals(list2) : list2 != null) {
                return false;
            }
            Map<String, SkemaError> map = this.subErrors;
            Map<String, SkemaError> map2 = skemaError.subErrors;
            return map != null ? map.equals(map2) : map2 == null;
        }

        public int hashCode() {
            List<SkemaErrorItem> list = this.errors;
            int iHashCode = list == null ? 43 : list.hashCode();
            Map<String, SkemaError> map = this.subErrors;
            return ((iHashCode + 59) * 59) + (map != null ? map.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Error.SkemaError(errors=");
            sbU.append(this.errors);
            sbU.append(", subErrors=");
            return outline.M(sbU, this.subErrors, ")");
        }

        public /* synthetic */ SkemaError(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void handle(@NonNull Throwable th, @NonNull String str, @Nullable Action1<Error> action1, @Nullable Context context) throws Throwable {
        handle(th, str, action1, context, Boolean.FALSE);
    }
}
