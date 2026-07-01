package com.fasterxml.jackson.databind;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JsonMappingException$a implements Serializable {
    private static final long serialVersionUID = 2;
    public String _desc;
    public String _fieldName;
    public int _index;
    public transient Object j;

    public JsonMappingException$a() {
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

    public JsonMappingException$a(Object obj, String str) {
        this._index = -1;
        this.j = obj;
        Objects.requireNonNull(str, "Cannot pass null fieldName");
        this._fieldName = str;
    }

    public JsonMappingException$a(Object obj, int i) {
        this._index = -1;
        this.j = obj;
        this._index = i;
    }
}
