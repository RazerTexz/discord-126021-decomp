package b.g.a.a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: JacksonInject.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JacksonInject {

    /* JADX INFO: renamed from: b.g.a.a.b$a */
    /* JADX INFO: compiled from: JacksonInject.java */
    public static class a implements Serializable {
        public static final a j = new a(null, null);
        private static final long serialVersionUID = 1;
        public final Object _id;
        public final Boolean _useInput;

        public a(Object obj, Boolean bool) {
            this._id = obj;
            this._useInput = bool;
        }

        public static a a(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            return obj == null && bool == null ? j : new a(obj, bool);
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

    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";
}
