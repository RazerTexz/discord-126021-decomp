package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonProcessingException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p198b.p204t.C2147i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamReadException extends JsonProcessingException {
    public static final long serialVersionUID = 1;
    public C2147i _requestPayload;

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC2110f mo8737c() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sbM836X = C1643a.m836X(message, "\nRequest payload : ");
        sbM836X.append(this._requestPayload.toString());
        return sbM836X.toString();
    }
}
