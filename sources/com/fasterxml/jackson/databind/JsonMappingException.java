package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2089m;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: loaded from: classes3.dex */
public class JsonMappingException extends JsonProcessingException {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19661j = 0;
    private static final long serialVersionUID = 1;
    public LinkedList<C10677a> _path;

    /* JADX INFO: renamed from: k */
    public transient Closeable f19662k;

    public JsonMappingException(Closeable closeable, String str) {
        super(str);
        this.f19662k = closeable;
        if (closeable instanceof AbstractC2110f) {
            this._location = ((AbstractC2110f) closeable).mo1671a();
        }
    }

    /* JADX INFO: renamed from: f */
    public static JsonMappingException m8741f(Throwable th, C10677a c10677a) {
        JsonMappingException jsonMappingException;
        if (th instanceof JsonMappingException) {
            jsonMappingException = (JsonMappingException) th;
        } else {
            String strM2176h = C2342d.m2176h(th);
            if (strM2176h == null || strM2176h.isEmpty()) {
                StringBuilder sbM833U = C1643a.m833U("(was ");
                sbM833U.append(th.getClass().getName());
                sbM833U.append(")");
                strM2176h = sbM833U.toString();
            }
            Closeable closeable = null;
            if (th instanceof JsonProcessingException) {
                Object objMo8737c = ((JsonProcessingException) th).mo8737c();
                if (objMo8737c instanceof Closeable) {
                    closeable = (Closeable) objMo8737c;
                }
            }
            jsonMappingException = new JsonMappingException(closeable, strM2176h, th);
        }
        jsonMappingException.m8743e(c10677a);
        return jsonMappingException;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    @InterfaceC2089m
    /* JADX INFO: renamed from: c */
    public Object mo8737c() {
        return this.f19662k;
    }

    /* JADX INFO: renamed from: d */
    public String m8742d() {
        String message = super.getMessage();
        if (this._path == null) {
            return message;
        }
        StringBuilder sb = message == null ? new StringBuilder() : new StringBuilder(message);
        sb.append(" (through reference chain: ");
        LinkedList<C10677a> linkedList = this._path;
        if (linkedList != null) {
            Iterator<C10677a> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().m8744a());
                if (it.hasNext()) {
                    sb.append("->");
                }
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public void m8743e(C10677a c10677a) {
        if (this._path == null) {
            this._path = new LinkedList<>();
        }
        if (this._path.size() < 1000) {
            this._path.addFirst(c10677a);
        }
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return m8742d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return m8742d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.JsonMappingException$a */
    public static class C10677a implements Serializable {
        private static final long serialVersionUID = 2;
        public String _desc;
        public String _fieldName;
        public int _index;

        /* JADX INFO: renamed from: j */
        public transient Object f19663j;

        public C10677a() {
            this._index = -1;
        }

        /* JADX INFO: renamed from: a */
        public String m8744a() {
            if (this._desc == null) {
                StringBuilder sb = new StringBuilder();
                Object obj = this.f19663j;
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
            return m8744a();
        }

        public Object writeReplace() {
            m8744a();
            return this;
        }

        public C10677a(Object obj, String str) {
            this._index = -1;
            this.f19663j = obj;
            Objects.requireNonNull(str, "Cannot pass null fieldName");
            this._fieldName = str;
        }

        public C10677a(Object obj, int i) {
            this._index = -1;
            this.f19663j = obj;
            this._index = i;
        }
    }

    public JsonMappingException(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.f19662k = closeable;
        if (th instanceof JsonProcessingException) {
            this._location = ((JsonProcessingException) th)._location;
        } else if (closeable instanceof AbstractC2110f) {
            this._location = ((AbstractC2110f) closeable).mo1671a();
        }
    }
}
