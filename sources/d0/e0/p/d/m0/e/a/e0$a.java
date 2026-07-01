package d0.e0.p.d.m0.e.a;

import d0.t.h0;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$a {
    public e0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final e0$a$a access$method(e0$a e0_a, String str, String str2, String str3, String str4) {
        Objects.requireNonNull(e0_a);
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str2);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(name)");
        return new e0$a$a(eVarIdentifier, d0.e0.p.d.m0.e.b.w.a.signature(str, str2 + '(' + str3 + ')' + str4));
    }

    public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
        return e0.access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp();
    }

    public final Set<d0.e0.p.d.m0.g.e> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
        return e0.access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp();
    }

    public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
        return e0.access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp();
    }

    public final Map<d0.e0.p.d.m0.g.e, List<d0.e0.p.d.m0.g.e>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
        return e0.access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp();
    }

    public final List<d0.e0.p.d.m0.g.e> getORIGINAL_SHORT_NAMES() {
        return e0.access$getORIGINAL_SHORT_NAMES$cp();
    }

    public final e0$a$a getREMOVE_AT_NAME_AND_SIGNATURE() {
        return e0.access$getREMOVE_AT_NAME_AND_SIGNATURE$cp();
    }

    public final Map<String, e0$c> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
        return e0.access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp();
    }

    public final Map<String, d0.e0.p.d.m0.g.e> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
        return e0.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp();
    }

    public final e0$b getSpecialSignatureInfo(String str) {
        d0.z.d.m.checkNotNullParameter(str, "builtinSignature");
        if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
            return e0$b.ONE_COLLECTION_PARAMETER;
        }
        return ((e0$c) h0.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == e0$c.j ? e0$b.OBJECT_PARAMETER_GENERIC : e0$b.OBJECT_PARAMETER_NON_GENERIC;
    }
}
