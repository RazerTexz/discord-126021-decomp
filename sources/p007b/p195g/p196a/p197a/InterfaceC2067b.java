package p007b.p195g.p196a.p197a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.b */
/* JADX INFO: compiled from: JacksonInject.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2067b {

    /* JADX INFO: renamed from: b.g.a.a.b$a */
    /* JADX INFO: compiled from: JacksonInject.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f4365j = new a(null, null);
        private static final long serialVersionUID = 1;
        public final Object _id;
        public final Boolean _useInput;

        public a(Object obj, Boolean bool) {
            this._id = obj;
            this._useInput = bool;
        }

        /* JADX INFO: renamed from: a */
        public static a m1593a(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            return obj == null && bool == null ? f4365j : new a(obj, bool);
        }

        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                Boolean bool = this._useInput;
                Boolean bool2 = aVar._useInput;
                if (bool == null) {
                    zEquals = bool2 == null;
                } else {
                    zEquals = bool.equals(bool2);
                }
                if (zEquals) {
                    Object obj2 = this._id;
                    if (obj2 == null) {
                        return aVar._id == null;
                    }
                    return obj2.equals(aVar._id);
                }
            }
            return false;
        }

        public int hashCode() {
            Object obj = this._id;
            int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
            Boolean bool = this._useInput;
            return bool != null ? iHashCode + bool.hashCode() : iHashCode;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", this._id, this._useInput);
        }
    }

    EnumC2090m0 useInput() default EnumC2090m0.DEFAULT;

    String value() default "";
}
