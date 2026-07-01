package com.fasterxml.jackson.core;

import b.g.a.b.e;

/* JADX INFO: loaded from: classes3.dex */
public class JsonProcessingException extends JacksonException {
    private static final long serialVersionUID = 123;
    public e _location;

    public JsonProcessingException(String str, e eVar) {
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
        e eVar = this._location;
        String strA = a();
        if (eVar == null && strA == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (strA != null) {
            sb.append(strA);
        }
        if (eVar != null) {
            sb.append('\n');
            sb.append(" at ");
            sb.append(eVar.toString());
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
