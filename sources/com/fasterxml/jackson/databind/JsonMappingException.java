package com.fasterxml.jackson.databind;

import b.d.b.a.outline;
import b.g.a.a.JsonIgnore;
import b.g.a.b.JsonParser;
import b.g.a.c.i0.ClassUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JsonMappingException extends JsonProcessingException {
    public static final /* synthetic */ int j = 0;
    private static final long serialVersionUID = 1;
    public LinkedList<a> _path;
    public transient Closeable k;

    public JsonMappingException(Closeable closeable, String str) {
        super(str);
        this.k = closeable;
        if (closeable instanceof JsonParser) {
            this._location = ((JsonParser) closeable).a();
        }
    }

    public static JsonMappingException f(Throwable th, a aVar) {
        JsonMappingException jsonMappingException;
        if (th instanceof JsonMappingException) {
            jsonMappingException = (JsonMappingException) th;
        } else {
            String strH = ClassUtil.h(th);
            if (strH == null || strH.isEmpty()) {
                StringBuilder sbU = outline.U("(was ");
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
        jsonMappingException.e(aVar);
        return jsonMappingException;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    @JsonIgnore
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
        LinkedList<a> linkedList = this._path;
        if (linkedList != null) {
            Iterator<a> it = linkedList.iterator();
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

    public void e(a aVar) {
        if (this._path == null) {
            this._path = new LinkedList<>();
        }
        if (this._path.size() < 1000) {
            this._path.addFirst(aVar);
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

    public static class a implements Serializable {
        private static final long serialVersionUID = 2;
        public String _desc;
        public String _fieldName;
        public int _index;
        public transient Object j;

        public a() {
            this._index = -1;
        }

        public String a() {
            if (this._desc == null) {
                StringBuilder sb = new StringBuilder();
                Object obj = this.j;
                if (obj != null) {
                    Class<?> componentType = obj instanceof Class ? (Class) obj : obj.getClass();
                    int i = 0;
                    while (componentType.isArray()) {
                        componentType = componentType.getComponentType();
                        i++;
                    }
                    sb.append(componentType.getName());
                    while (true) {
                        i--;
                        if (i < 0) {
                            break;
                        }
                        sb.append("[]");
                    }
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append('[');
                if (this._fieldName != null) {
                    sb.append('\"');
                    sb.append(this._fieldName);
                    sb.append('\"');
                } else {
                    int i2 = this._index;
                    if (i2 >= 0) {
                        sb.append(i2);
                    } else {
                        sb.append('?');
                    }
                }
                sb.append(']');
                this._desc = sb.toString();
            }
            return this._desc;
        }

        public String toString() {
            return a();
        }

        public Object writeReplace() {
            a();
            return this;
        }

        public a(Object obj, String str) {
            this._index = -1;
            this.j = obj;
            Objects.requireNonNull(str, "Cannot pass null fieldName");
            this._fieldName = str;
        }

        public a(Object obj, int i) {
            this._index = -1;
            this.j = obj;
            this._index = i;
        }
    }

    public JsonMappingException(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.k = closeable;
        if (th instanceof JsonProcessingException) {
            this._location = ((JsonProcessingException) th)._location;
        } else if (closeable instanceof JsonParser) {
            this._location = ((JsonParser) closeable).a();
        }
    }
}
