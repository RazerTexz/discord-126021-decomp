package com.fasterxml.jackson.core.exc;

import b.d.b.a.a;
import b.g.a.b.f;
import b.g.a.b.t.i;
import com.fasterxml.jackson.core.JsonProcessingException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamReadException extends JsonProcessingException {
    public static final long serialVersionUID = 1;
    public i _requestPayload;

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public /* bridge */ /* synthetic */ Object c() {
        return d();
    }

    public f d() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sbX = a.X(message, "\nRequest payload : ");
        sbX.append(this._requestPayload.toString());
        return sbX.toString();
    }
}
