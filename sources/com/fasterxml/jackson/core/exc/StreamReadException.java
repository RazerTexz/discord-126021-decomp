package com.fasterxml.jackson.core.exc;

import b.d.b.a.outline;
import b.g.a.b.JsonParser;
import b.g.a.b.t.RequestPayload;
import com.fasterxml.jackson.core.JsonProcessingException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamReadException extends JsonProcessingException {
    public static final long serialVersionUID = 1;
    public RequestPayload _requestPayload;

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public JsonParser c() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sbX = outline.X(message, "\nRequest payload : ");
        sbX.append(this._requestPayload.toString());
        return sbX.toString();
    }
}
