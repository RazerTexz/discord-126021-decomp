package com.discord.utilities.error;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import b.a.x.a.a;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import com.discord.utilities.rest.RestAPIAbortMessages;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes2.dex */
public class Error$Response implements Model {
    private int code;
    private boolean global;

    @Nullable
    private String message;

    @NonNull
    private Map<String, List<String>> messages;
    private double retryAfter;

    @Nullable
    private Error$SkemaError skemaError;

    public /* synthetic */ Error$Response(String str, Error$1 error$1) {
        this(str);
    }

    public static /* synthetic */ String access$100(Error$Response error$Response, Context context, int i) {
        return error$Response.getMessageToast(context, i);
    }

    @SuppressLint({"ResourceType"})
    private String getMessageToast(Context context, @StringRes int i) {
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(this.code);
        if (abortCodeMessageResId != null) {
            return context.getString(abortCodeMessageResId.intValue());
        }
        Error$SkemaError error$SkemaError = this.skemaError;
        if (error$SkemaError != null) {
            if (!Error$SkemaError.access$400(error$SkemaError).isEmpty()) {
                return Error$SkemaErrorItem.access$500((Error$SkemaErrorItem) Error$SkemaError.access$400(this.skemaError).get(0));
            }
            for (Error$SkemaError error$SkemaError2 : Error$SkemaError.access$600(this.skemaError).values()) {
                if (!Error$SkemaError.access$400(error$SkemaError2).isEmpty()) {
                    return Error$SkemaErrorItem.access$500((Error$SkemaErrorItem) Error$SkemaError.access$400(error$SkemaError2).get(0));
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
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "errors":
                Error$SkemaError error$SkemaError = (Error$SkemaError) model$JsonReader.parse(new Error$SkemaError(null));
                this.skemaError = error$SkemaError;
                if (!Error$SkemaError.access$400(error$SkemaError).isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = Error$SkemaError.access$400(this.skemaError).iterator();
                    while (it.hasNext()) {
                        arrayList.add(Error$SkemaErrorItem.access$500((Error$SkemaErrorItem) it.next()));
                    }
                    this.messages.put("_misc", arrayList);
                }
                for (Map$Entry map$Entry : Error$SkemaError.access$600(this.skemaError).entrySet()) {
                    ArrayList arrayList2 = new ArrayList();
                    String str = (String) map$Entry.getKey();
                    Error$SkemaError error$SkemaError2 = (Error$SkemaError) map$Entry.getValue();
                    if (!Error$SkemaError.access$400(error$SkemaError2).isEmpty()) {
                        Iterator it2 = Error$SkemaError.access$400(error$SkemaError2).iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(Error$SkemaErrorItem.access$500((Error$SkemaErrorItem) it2.next()));
                        }
                    }
                    arrayList2.addAll(Error$SkemaError.access$600(error$SkemaError2).keySet());
                    this.messages.put(str, arrayList2);
                }
                break;
            case "global":
                this.global = model$JsonReader.nextBoolean(this.global);
                break;
            case "retry_after":
                this.retryAfter = model$JsonReader.nextDouble(this.retryAfter);
                break;
            case "code":
                this.code = model$JsonReader.nextInt(this.code);
                break;
            case "message":
                this.message = model$JsonReader.nextString(this.message);
                break;
            default:
                this.messages.put(strNextName, model$JsonReader.nextList(new a(model$JsonReader)));
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Error$Response;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Error$Response)) {
            return false;
        }
        Error$Response error$Response = (Error$Response) obj;
        if (!error$Response.canEqual(this) || getCode() != error$Response.getCode() || Double.compare(this.retryAfter, error$Response.retryAfter) != 0 || this.global != error$Response.global) {
            return false;
        }
        Error$SkemaError error$SkemaError = this.skemaError;
        Error$SkemaError error$SkemaError2 = error$Response.skemaError;
        if (error$SkemaError != null ? !error$SkemaError.equals(error$SkemaError2) : error$SkemaError2 != null) {
            return false;
        }
        Map<String, List<String>> messages = getMessages();
        Map<String, List<String>> messages2 = error$Response.getMessages();
        if (messages != null ? !messages.equals(messages2) : messages2 != null) {
            return false;
        }
        String message = getMessage();
        String message2 = error$Response.getMessage();
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
        Error$SkemaError error$SkemaError = this.skemaError;
        int iHashCode = (i * 59) + (error$SkemaError == null ? 43 : error$SkemaError.hashCode());
        Map<String, List<String>> messages = getMessages();
        int iHashCode2 = (iHashCode * 59) + (messages == null ? 43 : messages.hashCode());
        String message = getMessage();
        return (iHashCode2 * 59) + (message != null ? message.hashCode() : 43);
    }

    public boolean isKnownResponse() {
        return this.code > 0 || !this.messages.isEmpty();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Error.Response(code=");
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

    private Error$Response(@Nullable String str) {
        this.messages = new HashMap();
        if (str != null) {
            try {
                new Model$JsonReader(new StringReader(str)).parse(this);
            } catch (Exception unused) {
            }
        }
    }
}
