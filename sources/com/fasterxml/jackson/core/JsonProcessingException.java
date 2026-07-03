package com.fasterxml.jackson.core;

import p007b.p195g.p196a.p198b.C2109e;

/* JADX INFO: loaded from: classes3.dex */
public class JsonProcessingException extends JacksonException {
    private static final long serialVersionUID = 123;
    public C2109e _location;

    public JsonProcessingException(String str, C2109e c2109e) {
        super(str, null);
        this._location = null;
    }

    /* JADX INFO: renamed from: a */
    public String mo8739a() {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public String m8740b() {
        return super.getMessage();
    }

    /* JADX INFO: renamed from: c */
    public Object mo8737c() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        C2109e c2109e = this._location;
        String strMo8739a = mo8739a();
        if (c2109e == null && strMo8739a == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (strMo8739a != null) {
            sb.append(strMo8739a);
        }
        if (c2109e != null) {
            sb.append('\n');
            sb.append(" at ");
            sb.append(c2109e.toString());
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
