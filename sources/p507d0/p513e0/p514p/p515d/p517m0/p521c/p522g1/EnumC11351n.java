package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.n */
/* JADX INFO: compiled from: KotlinTarget.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11351n {
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


    /* JADX INFO: renamed from: j */
    public static final HashMap<String, EnumC11351n> f22779j;

    /* JADX INFO: renamed from: k */
    public static final Map<EnumC11342e, EnumC11351n> f22780k;
    private final String description;
    private final boolean isDefault;

    static {
        new Object(null) { // from class: d0.e0.p.d.m0.c.g1.n.a
        };
        f22779j = new HashMap<>();
        EnumC11351n[] enumC11351nArrValuesCustom = valuesCustom();
        int i = 0;
        while (i < 41) {
            EnumC11351n enumC11351n = enumC11351nArrValuesCustom[i];
            i++;
            f22779j.put(enumC11351n.name(), enumC11351n);
        }
        EnumC11351n[] enumC11351nArrValuesCustom2 = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 41; i2++) {
            EnumC11351n enumC11351n2 = enumC11351nArrValuesCustom2[i2];
            if (enumC11351n2.isDefault()) {
                arrayList.add(enumC11351n2);
            }
        }
        C12163u.toSet(arrayList);
        C12141k.toSet(valuesCustom());
        EnumC11342e enumC11342e = EnumC11342e.CONSTRUCTOR_PARAMETER;
        EnumC11351n enumC11351n3 = VALUE_PARAMETER;
        EnumC11342e enumC11342e2 = EnumC11342e.FIELD;
        EnumC11351n enumC11351n4 = FIELD;
        f22780k = C12136h0.mapOf(C12116o.m10073to(enumC11342e, enumC11351n3), C12116o.m10073to(enumC11342e2, enumC11351n4), C12116o.m10073to(EnumC11342e.PROPERTY, PROPERTY), C12116o.m10073to(EnumC11342e.FILE, FILE), C12116o.m10073to(EnumC11342e.PROPERTY_GETTER, PROPERTY_GETTER), C12116o.m10073to(EnumC11342e.PROPERTY_SETTER, PROPERTY_SETTER), C12116o.m10073to(EnumC11342e.RECEIVER, enumC11351n3), C12116o.m10073to(EnumC11342e.SETTER_PARAMETER, enumC11351n3), C12116o.m10073to(EnumC11342e.PROPERTY_DELEGATE_FIELD, enumC11351n4));
    }

    EnumC11351n(String str, boolean z2) {
        this.description = str;
        this.isDefault = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11351n[] valuesCustom() {
        EnumC11351n[] enumC11351nArrValuesCustom = values();
        EnumC11351n[] enumC11351nArr = new EnumC11351n[enumC11351nArrValuesCustom.length];
        System.arraycopy(enumC11351nArrValuesCustom, 0, enumC11351nArr, 0, enumC11351nArrValuesCustom.length);
        return enumC11351nArr;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    EnumC11351n(String str, boolean z2, int i) {
        z2 = (i & 2) != 0 ? true : z2;
        this.description = str;
        this.isDefault = z2;
    }
}
