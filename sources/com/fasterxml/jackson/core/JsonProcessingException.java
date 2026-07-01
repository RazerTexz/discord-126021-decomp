package com.fasterxml.jackson.core;

import b.g.a.b.JsonLocation;

/* JADX INFO: loaded from: classes3.dex */
public class JsonProcessingException extends JacksonException {
    private static final long serialVersionUID = 123;
    public JsonLocation _location;

    public JsonProcessingException(String str, JsonLocation jsonLocation) {
        super(str, null);
        this._location = null;
    }

    public String a() {
        return null;
    }

    public String b() {
        return super.getMessage();
    }

    public Object c() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        JsonLocation jsonLocation = this._location;
        String strA = a();
        if (jsonLocation == null && strA == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (strA != null) {
            sb.append(strA);
        }
        if (jsonLocation != null) {
            sb.append('\n');
            sb.append(" at ");
            sb.append(jsonLocation.toString());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public JsonProcessingException(String str, Throwable th) {
        super(str, th);
        this._location = null;
    }

    public JsonProcessingException(String str) {
        super(str);
    }
}
