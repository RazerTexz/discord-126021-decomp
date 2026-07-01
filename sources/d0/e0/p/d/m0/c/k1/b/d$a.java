package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public d$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final d create(Object obj, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(obj, "value");
        if (b.isEnumClassOrSpecializedEnumEntryClass(obj.getClass())) {
            return new o(eVar, (Enum) obj);
        }
        if (obj instanceof Annotation) {
            return new e(eVar, (Annotation) obj);
        }
        if (obj instanceof Object[]) {
            return new h(eVar, (Object[]) obj);
        }
        return obj instanceof Class ? new k(eVar, (Class) obj) : new q(eVar, obj);
    }
}
