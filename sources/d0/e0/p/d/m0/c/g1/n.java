package d0.e0.p.d.m0.c.g1;

import d0.o;
import d0.t.h0;
import d0.t.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: KotlinTarget.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum n {
    CLASS("class", false, 2),
    ANNOTATION_CLASS("annotation class", false, 2),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2),
    FIELD("field", false, 2),
    LOCAL_VARIABLE("local variable", false, 2),
    VALUE_PARAMETER("value parameter", false, 2),
    CONSTRUCTOR("constructor", false, 2),
    FUNCTION("function", false, 2),
    PROPERTY_GETTER("getter", false, 2),
    PROPERTY_SETTER("setter", false, 2),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);

    public static final HashMap<String, n> j;
    public static final Map<e, n> k;
    private final String description;
    private final boolean isDefault;

    static {
        new n$a(null);
        j = new HashMap<>();
        n[] nVarArrValuesCustom = valuesCustom();
        int i = 0;
        while (i < 41) {
            n nVar = nVarArrValuesCustom[i];
            i++;
            j.put(nVar.name(), nVar);
        }
        n[] nVarArrValuesCustom2 = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 41; i2++) {
            n nVar2 = nVarArrValuesCustom2[i2];
            if (nVar2.isDefault()) {
                arrayList.add(nVar2);
            }
        }
        u.toSet(arrayList);
        d0.t.k.toSet(valuesCustom());
        e eVar = e.CONSTRUCTOR_PARAMETER;
        n nVar3 = VALUE_PARAMETER;
        e eVar2 = e.FIELD;
        n nVar4 = FIELD;
        k = h0.mapOf(o.to(eVar, nVar3), o.to(eVar2, nVar4), o.to(e.PROPERTY, PROPERTY), o.to(e.FILE, FILE), o.to(e.PROPERTY_GETTER, PROPERTY_GETTER), o.to(e.PROPERTY_SETTER, PROPERTY_SETTER), o.to(e.RECEIVER, nVar3), o.to(e.SETTER_PARAMETER, nVar3), o.to(e.PROPERTY_DELEGATE_FIELD, nVar4));
    }

    n(String str, boolean z2) {
        this.description = str;
        this.isDefault = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static n[] valuesCustom() {
        n[] nVarArrValuesCustom = values();
        n[] nVarArr = new n[nVarArrValuesCustom.length];
        System.arraycopy(nVarArrValuesCustom, 0, nVarArr, 0, nVarArrValuesCustom.length);
        return nVarArr;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    n(String str, boolean z2, int i) {
        z2 = (i & 2) != 0 ? true : z2;
        this.description = str;
        this.isDefault = z2;
    }
}
