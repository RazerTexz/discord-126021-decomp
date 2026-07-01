package b.g.a.a;

import b.d.b.a.outline;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.p, reason: use source file name */
/* JADX INFO: compiled from: JsonInclude.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    /* JADX INFO: renamed from: b.g.a.a.p$a */
    /* JADX INFO: compiled from: JsonInclude.java */
    public enum a {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    /* JADX INFO: renamed from: b.g.a.a.p$b */
    /* JADX INFO: compiled from: JsonInclude.java */
    public static class b implements Serializable {
        public static final b j;
        private static final long serialVersionUID = 1;
        public final Class<?> _contentFilter;
        public final a _contentInclusion;
        public final Class<?> _valueFilter;
        public final a _valueInclusion;

        static {
            a aVar = a.USE_DEFAULTS;
            j = new b(aVar, aVar, null, null);
        }

        public b(a aVar, a aVar2, Class<?> cls, Class<?> cls2) {
            a aVar3 = a.USE_DEFAULTS;
            this._valueInclusion = aVar == null ? aVar3 : aVar;
            this._contentInclusion = aVar2 == null ? aVar3 : aVar2;
            this._valueFilter = cls == Void.class ? null : cls;
            this._contentFilter = cls2 == Void.class ? null : cls2;
        }

        public b a(b bVar) {
            a aVar = a.USE_DEFAULTS;
            if (bVar != null && bVar != j) {
                a aVar2 = bVar._valueInclusion;
                a aVar3 = bVar._contentInclusion;
                Class<?> cls = bVar._valueFilter;
                Class<?> cls2 = bVar._contentFilter;
                a aVar4 = this._valueInclusion;
                boolean z2 = true;
                boolean z3 = (aVar2 == aVar4 || aVar2 == aVar) ? false : true;
                a aVar5 = this._contentInclusion;
                boolean z4 = (aVar3 == aVar5 || aVar3 == aVar) ? false : true;
                Class<?> cls3 = this._valueFilter;
                if (cls == cls3 && cls2 == cls3) {
                    z2 = false;
                }
                if (z3) {
                    return z4 ? new b(aVar2, aVar3, cls, cls2) : new b(aVar2, aVar5, cls, cls2);
                }
                if (z4) {
                    return new b(aVar4, aVar3, cls, cls2);
                }
                if (z2) {
                    return new b(aVar4, aVar5, cls, cls2);
                }
            }
            return this;
        }

        public b b(a aVar) {
            return aVar == this._valueInclusion ? this : new b(aVar, this._contentInclusion, this._valueFilter, this._contentFilter);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return bVar._valueInclusion == this._valueInclusion && bVar._contentInclusion == this._contentInclusion && bVar._valueFilter == this._valueFilter && bVar._contentFilter == this._contentFilter;
        }

        public int hashCode() {
            return this._contentInclusion.hashCode() + (this._valueInclusion.hashCode() << 2);
        }

        public Object readResolve() {
            a aVar = this._valueInclusion;
            a aVar2 = a.USE_DEFAULTS;
            return (aVar == aVar2 && this._contentInclusion == aVar2 && this._valueFilter == null && this._contentFilter == null) ? j : this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(80);
            sb.append("JsonInclude.Value(value=");
            sb.append(this._valueInclusion);
            sb.append(",content=");
            sb.append(this._contentInclusion);
            if (this._valueFilter != null) {
                sb.append(",valueFilter=");
                outline.k0(this._valueFilter, sb, ".class");
            }
            if (this._contentFilter != null) {
                sb.append(",contentFilter=");
                outline.k0(this._contentFilter, sb, ".class");
            }
            sb.append(')');
            return sb.toString();
        }
    }

    a content() default a.ALWAYS;

    Class<?> contentFilter() default Void.class;

    a value() default a.ALWAYS;

    Class<?> valueFilter() default Void.class;
}
