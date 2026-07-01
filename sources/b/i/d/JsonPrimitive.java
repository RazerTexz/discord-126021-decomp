package b.i.d;

import b.i.d.q.LazilyParsedNumber;
import com.google.gson.JsonElement;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.d.k, reason: use source file name */
/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonPrimitive extends JsonElement {
    public final Object a;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.a = bool;
    }

    public static boolean j(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gson.JsonElement
    public int c() {
        return this.a instanceof Number ? i().intValue() : Integer.parseInt(g());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.a == null) {
            return jsonPrimitive.a == null;
        }
        if (j(this) && j(jsonPrimitive)) {
            return i().longValue() == jsonPrimitive.i().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(jsonPrimitive.a instanceof Number)) {
            return obj2.equals(jsonPrimitive.a);
        }
        double dDoubleValue = i().doubleValue();
        double dDoubleValue2 = jsonPrimitive.i().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public String g() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return i().toString();
        }
        return obj instanceof Boolean ? ((Boolean) obj).toString() : (String) obj;
    }

    public boolean h() {
        Object obj = this.a;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(g());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (j(this)) {
            jDoubleToLongBits = i().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(i().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public Number i() {
        Object obj = this.a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.a) : (Number) obj;
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.a = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }
}
