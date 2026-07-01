package b.i.d;

import b.i.d.q.q;
import com.google.gson.JsonElement;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends JsonElement {
    public final Object a;

    public k(Boolean bool) {
        Objects.requireNonNull(bool);
        this.a = bool;
    }

    public static boolean j(k kVar) {
        Object obj = kVar.a;
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
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.a == null) {
            return kVar.a == null;
        }
        if (j(this) && j(kVar)) {
            return i().longValue() == kVar.i().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(kVar.a instanceof Number)) {
            return obj2.equals(kVar.a);
        }
        double dDoubleValue = i().doubleValue();
        double dDoubleValue2 = kVar.i().doubleValue();
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
        return obj instanceof String ? new q((String) this.a) : (Number) obj;
    }

    public k(Number number) {
        Objects.requireNonNull(number);
        this.a = number;
    }

    public k(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }
}
