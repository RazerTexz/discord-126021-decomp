package com.fasterxml.jackson.databind;

import b.d.b.a.a;
import b.g.a.a.m;
import b.g.a.b.f;
import b.g.a.c.i0.d;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class JsonMappingException extends JsonProcessingException {
    public static final /* synthetic */ int j = 0;
    private static final long serialVersionUID = 1;
    public LinkedList<JsonMappingException$a> _path;
    public transient Closeable k;

    public JsonMappingException(Closeable closeable, String str) {
        super(str);
        this.k = closeable;
        if (closeable instanceof f) {
            this._location = ((f) closeable).a();
        }
    }

    public static JsonMappingException f(Throwable th, JsonMappingException$a jsonMappingException$a) {
        JsonMappingException jsonMappingException;
        if (th instanceof JsonMappingException) {
            jsonMappingException = (JsonMappingException) th;
        } else {
            String strH = d.h(th);
            if (strH == null || strH.isEmpty()) {
                StringBuilder sbU = a.U("(was ");
                sbU.append(th.getClass().getName());
                sbU.append(")");
                strH = sbU.toString();
            }
            Closeable closeable = null;
            if (th instanceof JsonProcessingException) {
                Object objC = ((JsonProcessingException) th).c();
                if (objC instanceof Closeable) {
                    closeable = (Closeable) objC;
                }
            }
            jsonMappingException = new JsonMappingException(closeable, strH, th);
        }
        jsonMappingException.e(jsonMappingException$a);
        return jsonMappingException;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    @m
    public Object c() {
        return this.k;
    }

    public String d() {
        String message = super.getMessage();
        if (this._path == null) {
            return message;
        }
        StringBuilder sb = message == null ? new StringBuilder() : new StringBuilder(message);
        sb.append(" (through reference chain: ");
        LinkedList<JsonMappingException$a> linkedList = this._path;
        if (linkedList != null) {
            Iterator<JsonMappingException$a> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().a());
                if (it.hasNext()) {
                    sb.append("->");
                }
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public void e(JsonMappingException$a jsonMappingException$a) {
        if (this._path == null) {
            this._path = new LinkedList<>();
        }
        if (this._path.size() < 1000) {
            this._path.addFirst(jsonMappingException$a);
        }
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public JsonMappingException(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.k = closeable;
        if (th instanceof JsonProcessingException) {
            this._location = ((JsonProcessingException) th)._location;
        } else if (closeable instanceof f) {
            this._location = ((f) closeable).a();
        }
    }
}
