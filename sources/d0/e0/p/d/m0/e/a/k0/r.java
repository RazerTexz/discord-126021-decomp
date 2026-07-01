package d0.e0.p.d.m0.e.a.k0;

import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface r extends q, z {

    /* JADX INFO: compiled from: javaElements.kt */
    public static final class a {
        public static boolean getHasAnnotationParameterDefaultValue(r rVar) {
            Intrinsics3.checkNotNullParameter(rVar, "this");
            return rVar.getAnnotationParameterDefaultValue() != null;
        }
    }

    annotationArguments getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    javaTypes5 getReturnType();

    List<a0> getValueParameters();
}
