package d0.e0.p.d.m0.c.g1;

import d0.Tuples;
import d0.t.Maps6;
import d0.t._Arrays;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.n, reason: use source file name */
/* JADX INFO: compiled from: KotlinTarget.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum KotlinTarget {
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

    public static final HashMap<String, KotlinTarget> j;
    public static final Map<AnnotationUseSiteTarget, KotlinTarget> k;
    private final String description;
    private final boolean isDefault;

    static {
        new Object(null) { // from class: d0.e0.p.d.m0.c.g1.n.a
        };
        j = new HashMap<>();
        KotlinTarget[] kotlinTargetArrValuesCustom = valuesCustom();
        int i = 0;
        while (i < 41) {
            KotlinTarget kotlinTarget = kotlinTargetArrValuesCustom[i];
            i++;
            j.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] kotlinTargetArrValuesCustom2 = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 41; i2++) {
            KotlinTarget kotlinTarget2 = kotlinTargetArrValuesCustom2[i2];
            if (kotlinTarget2.isDefault()) {
                arrayList.add(kotlinTarget2);
            }
        }
        _Collections.toSet(arrayList);
        _Arrays.toSet(valuesCustom());
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget3 = VALUE_PARAMETER;
        AnnotationUseSiteTarget annotationUseSiteTarget2 = AnnotationUseSiteTarget.FIELD;
        KotlinTarget kotlinTarget4 = FIELD;
        k = Maps6.mapOf(Tuples.to(annotationUseSiteTarget, kotlinTarget3), Tuples.to(annotationUseSiteTarget2, kotlinTarget4), Tuples.to(AnnotationUseSiteTarget.PROPERTY, PROPERTY), Tuples.to(AnnotationUseSiteTarget.FILE, FILE), Tuples.to(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), Tuples.to(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), Tuples.to(AnnotationUseSiteTarget.RECEIVER, kotlinTarget3), Tuples.to(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget3), Tuples.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget4));
    }

    KotlinTarget(String str, boolean z2) {
        this.description = str;
        this.isDefault = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static KotlinTarget[] valuesCustom() {
        KotlinTarget[] kotlinTargetArrValuesCustom = values();
        KotlinTarget[] kotlinTargetArr = new KotlinTarget[kotlinTargetArrValuesCustom.length];
        System.arraycopy(kotlinTargetArrValuesCustom, 0, kotlinTargetArr, 0, kotlinTargetArrValuesCustom.length);
        return kotlinTargetArr;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    KotlinTarget(String str, boolean z2, int i) {
        z2 = (i & 2) != 0 ? true : z2;
        this.description = str;
        this.isDefault = z2;
    }
}
