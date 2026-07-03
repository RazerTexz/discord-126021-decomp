package p007b.p195g.p196a.p197a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.z */
/* JADX INFO: compiled from: JsonSetter.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2104z {

    /* JADX INFO: renamed from: b.g.a.a.z$a */
    /* JADX INFO: compiled from: JsonSetter.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f4443j;
        private static final long serialVersionUID = 1;
        private final EnumC2080h0 _contentNulls;
        private final EnumC2080h0 _nulls;

        static {
            EnumC2080h0 enumC2080h0 = EnumC2080h0.DEFAULT;
            f4443j = new a(enumC2080h0, enumC2080h0);
        }

        public a(EnumC2080h0 enumC2080h0, EnumC2080h0 enumC2080h1) {
            this._nulls = enumC2080h0;
            this._contentNulls = enumC2080h1;
        }

        /* JADX INFO: renamed from: a */
        public EnumC2080h0 m1620a() {
            EnumC2080h0 enumC2080h0 = this._contentNulls;
            if (enumC2080h0 == EnumC2080h0.DEFAULT) {
                return null;
            }
            return enumC2080h0;
        }

        /* JADX INFO: renamed from: b */
        public EnumC2080h0 m1621b() {
            EnumC2080h0 enumC2080h0 = this._nulls;
            if (enumC2080h0 == EnumC2080h0.DEFAULT) {
                return null;
            }
            return enumC2080h0;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return aVar._nulls == this._nulls && aVar._contentNulls == this._contentNulls;
        }

        public int hashCode() {
            return this._nulls.ordinal() + (this._contentNulls.ordinal() << 2);
        }

        public Object readResolve() {
            EnumC2080h0 enumC2080h0 = this._nulls;
            EnumC2080h0 enumC2080h1 = this._contentNulls;
            EnumC2080h0 enumC2080h2 = EnumC2080h0.DEFAULT;
            return enumC2080h0 == enumC2080h2 && enumC2080h1 == enumC2080h2 ? f4443j : this;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this._nulls, this._contentNulls);
        }
    }

    EnumC2080h0 contentNulls() default EnumC2080h0.DEFAULT;

    EnumC2080h0 nulls() default EnumC2080h0.DEFAULT;

    String value() default "";
}
