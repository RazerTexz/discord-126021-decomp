package lombok.core.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.ConfigurationKeys;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.With;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.JavaIdentifiers;
import lombok.core.LombokNode;
import lombok.core.configuration.AllowHelper;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.configuration.FlagUsageType;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/* JADX INFO: loaded from: app.apk:lombok/core/handlers/HandlerUtil.SCL.lombok */
public class HandlerUtil {
    public static final String DEFAULT_EXCEPTION_FOR_NON_NULL = "java.lang.NullPointerException";
    public static final List<String> NONNULL_ANNOTATIONS = Collections.unmodifiableList(Arrays.asList("androidx.annotation.NonNull", "android.support.annotation.NonNull", "com.sun.istack.internal.NotNull", "edu.umd.cs.findbugs.annotations.NonNull", "javax.annotation.Nonnull", "lombok.NonNull", "org.checkerframework.checker.nullness.qual.NonNull", "org.eclipse.jdt.annotation.NonNull", "org.eclipse.jgit.annotations.NonNull", "org.jetbrains.annotations.NotNull", "org.jmlspecs.annotation.NonNull", "org.netbeans.api.annotations.common.NonNull", "org.springframework.lang.NonNull"));
    public static final List<String> BASE_COPYABLE_ANNOTATIONS = Collections.unmodifiableList(Arrays.asList("androidx.annotation.NonNull", "androidx.annotation.Nullable", "android.support.annotation.NonNull", "android.support.annotation.Nullable", "edu.umd.cs.findbugs.annotations.NonNull", "edu.umd.cs.findbugs.annotations.Nullable", "edu.umd.cs.findbugs.annotations.UnknownNullness", "javax.annotation.CheckForNull", "javax.annotation.Nonnull", "javax.annotation.Nullable", "lombok.NonNull", "org.jmlspecs.annotation.NonNull", "org.jmlspecs.annotation.Nullable", "org.checkerframework.checker.compilermsgs.qual.CompilerMessageKey", "org.checkerframework.checker.compilermsgs.qual.CompilerMessageKeyBottom", "org.checkerframework.checker.compilermsgs.qual.UnknownCompilerMessageKey", "org.checkerframework.checker.fenum.qual.AwtAlphaCompositingRule", "org.checkerframework.checker.fenum.qual.AwtColorSpace", "org.checkerframework.checker.fenum.qual.AwtCursorType", "org.checkerframework.checker.fenum.qual.AwtFlowLayout", "org.checkerframework.checker.fenum.qual.Fenum", "org.checkerframework.checker.fenum.qual.FenumBottom", "org.checkerframework.checker.fenum.qual.FenumTop", "org.checkerframework.checker.fenum.qual.PolyFenum", "org.checkerframework.checker.fenum.qual.SwingBoxOrientation", "org.checkerframework.checker.fenum.qual.SwingCompassDirection", "org.checkerframework.checker.fenum.qual.SwingElementOrientation", "org.checkerframework.checker.fenum.qual.SwingHorizontalOrientation", "org.checkerframework.checker.fenum.qual.SwingSplitPaneOrientation", "org.checkerframework.checker.fenum.qual.SwingTextOrientation", "org.checkerframework.checker.fenum.qual.SwingTitleJustification", "org.checkerframework.checker.fenum.qual.SwingTitlePosition", "org.checkerframework.checker.fenum.qual.SwingVerticalOrientation", "org.checkerframework.checker.formatter.qual.Format", "org.checkerframework.checker.formatter.qual.FormatBottom", "org.checkerframework.checker.formatter.qual.InvalidFormat", "org.checkerframework.checker.guieffect.qual.AlwaysSafe", "org.checkerframework.checker.guieffect.qual.PolyUI", "org.checkerframework.checker.guieffect.qual.UI", "org.checkerframework.checker.i18nformatter.qual.I18nFormat", "org.checkerframework.checker.i18nformatter.qual.I18nFormatBottom", "org.checkerframework.checker.i18nformatter.qual.I18nFormatFor", "org.checkerframework.checker.i18nformatter.qual.I18nInvalidFormat", "org.checkerframework.checker.i18nformatter.qual.I18nUnknownFormat", "org.checkerframework.checker.i18n.qual.LocalizableKey", "org.checkerframework.checker.i18n.qual.LocalizableKeyBottom", "org.checkerframework.checker.i18n.qual.Localized", "org.checkerframework.checker.i18n.qual.UnknownLocalizableKey", "org.checkerframework.checker.i18n.qual.UnknownLocalized", "org.checkerframework.checker.index.qual.GTENegativeOne", "org.checkerframework.checker.index.qual.IndexFor", "org.checkerframework.checker.index.qual.IndexOrHigh", "org.checkerframework.checker.index.qual.IndexOrLow", "org.checkerframework.checker.index.qual.LengthOf", "org.checkerframework.checker.index.qual.LessThan", "org.checkerframework.checker.index.qual.LessThanBottom", "org.checkerframework.checker.index.qual.LessThanUnknown", "org.checkerframework.checker.index.qual.LowerBoundBottom", "org.checkerframework.checker.index.qual.LowerBoundUnknown", "org.checkerframework.checker.index.qual.LTEqLengthOf", "org.checkerframework.checker.index.qual.LTLengthOf", "org.checkerframework.checker.index.qual.LTOMLengthOf", "org.checkerframework.checker.index.qual.NegativeIndexFor", "org.checkerframework.checker.index.qual.NonNegative", "org.checkerframework.checker.index.qual.PolyIndex", "org.checkerframework.checker.index.qual.PolyLength", "org.checkerframework.checker.index.qual.PolyLowerBound", "org.checkerframework.checker.index.qual.PolySameLen", "org.checkerframework.checker.index.qual.PolyUpperBound", "org.checkerframework.checker.index.qual.Positive", "org.checkerframework.checker.index.qual.SameLen", "org.checkerframework.checker.index.qual.SameLenBottom", "org.checkerframework.checker.index.qual.SameLenUnknown", "org.checkerframework.checker.index.qual.SearchIndexBottom", "org.checkerframework.checker.index.qual.SearchIndexFor", "org.checkerframework.checker.index.qual.SearchIndexUnknown", "org.checkerframework.checker.index.qual.SubstringIndexBottom", "org.checkerframework.checker.index.qual.SubstringIndexFor", "org.checkerframework.checker.index.qual.SubstringIndexUnknown", "org.checkerframework.checker.index.qual.UpperBoundBottom", "org.checkerframework.checker.index.qual.UpperBoundUnknown", "org.checkerframework.checker.initialization.qual.FBCBottom", "org.checkerframework.checker.initialization.qual.Initialized", "org.checkerframework.checker.initialization.qual.UnderInitialization", "org.checkerframework.checker.initialization.qual.UnknownInitialization", "org.checkerframework.checker.interning.qual.Interned", "org.checkerframework.checker.interning.qual.InternedDistinct", "org.checkerframework.checker.interning.qual.PolyInterned", "org.checkerframework.checker.interning.qual.UnknownInterned", "org.checkerframework.checker.lock.qual.GuardedBy", "org.checkerframework.checker.lock.qual.GuardedByBottom", "org.checkerframework.checker.lock.qual.GuardedByUnknown", "org.checkerframework.checker.lock.qual.GuardSatisfied", "org.checkerframework.checker.nullness.qual.KeyFor", "org.checkerframework.checker.nullness.qual.KeyForBottom", "org.checkerframework.checker.nullness.qual.MonotonicNonNull", "org.checkerframework.checker.nullness.qual.NonNull", "org.checkerframework.checker.nullness.qual.NonRaw", "org.checkerframework.checker.nullness.qual.Nullable", "org.checkerframework.checker.nullness.qual.PolyKeyFor", "org.checkerframework.checker.nullness.qual.PolyNull", "org.checkerframework.checker.nullness.qual.PolyRaw", "org.checkerframework.checker.nullness.qual.Raw", "org.checkerframework.checker.nullness.qual.UnknownKeyFor", "org.checkerframework.checker.optional.qual.MaybePresent", "org.checkerframework.checker.optional.qual.PolyPresent", "org.checkerframework.checker.optional.qual.Present", "org.checkerframework.checker.propkey.qual.PropertyKey", "org.checkerframework.checker.propkey.qual.PropertyKeyBottom", "org.checkerframework.checker.propkey.qual.UnknownPropertyKey", "org.checkerframework.checker.regex.qual.PolyRegex", "org.checkerframework.checker.regex.qual.Regex", "org.checkerframework.checker.regex.qual.RegexBottom", "org.checkerframework.checker.regex.qual.UnknownRegex", "org.checkerframework.checker.signature.qual.BinaryName", "org.checkerframework.checker.signature.qual.BinaryNameInUnnamedPackage", "org.checkerframework.checker.signature.qual.ClassGetName", "org.checkerframework.checker.signature.qual.ClassGetSimpleName", "org.checkerframework.checker.signature.qual.DotSeparatedIdentifiers", "org.checkerframework.checker.signature.qual.FieldDescriptor", "org.checkerframework.checker.signature.qual.FieldDescriptorForPrimitive", "org.checkerframework.checker.signature.qual.FieldDescriptorForPrimitiveOrArrayInUnnamedPackage", "org.checkerframework.checker.signature.qual.FqBinaryName", "org.checkerframework.checker.signature.qual.FullyQualifiedName", "org.checkerframework.checker.signature.qual.Identifier", "org.checkerframework.checker.signature.qual.IdentifierOrArray", "org.checkerframework.checker.signature.qual.InternalForm", "org.checkerframework.checker.signature.qual.MethodDescriptor", "org.checkerframework.checker.signature.qual.PolySignature", "org.checkerframework.checker.signature.qual.SignatureBottom", "org.checkerframework.checker.signedness.qual.Constant", "org.checkerframework.checker.signedness.qual.PolySignedness", "org.checkerframework.checker.signedness.qual.PolySigned", "org.checkerframework.checker.signedness.qual.Signed", "org.checkerframework.checker.signedness.qual.SignednessBottom", "org.checkerframework.checker.signedness.qual.SignednessGlb", "org.checkerframework.checker.signedness.qual.SignedPositive", "org.checkerframework.checker.signedness.qual.UnknownSignedness", "org.checkerframework.checker.signedness.qual.Unsigned", "org.checkerframework.checker.tainting.qual.PolyTainted", "org.checkerframework.checker.tainting.qual.Tainted", "org.checkerframework.checker.tainting.qual.Untainted", "org.checkerframework.checker.units.qual.A", "org.checkerframework.checker.units.qual.Acceleration", "org.checkerframework.checker.units.qual.Angle", "org.checkerframework.checker.units.qual.Area", "org.checkerframework.checker.units.qual.C", "org.checkerframework.checker.units.qual.cd", "org.checkerframework.checker.units.qual.Current", "org.checkerframework.checker.units.qual.degrees", "org.checkerframework.checker.units.qual.g", "org.checkerframework.checker.units.qual.h", "org.checkerframework.checker.units.qual.K", "org.checkerframework.checker.units.qual.kg", "org.checkerframework.checker.units.qual.km", "org.checkerframework.checker.units.qual.km2", "org.checkerframework.checker.units.qual.kmPERh", "org.checkerframework.checker.units.qual.Length", "org.checkerframework.checker.units.qual.Luminance", "org.checkerframework.checker.units.qual.m", "org.checkerframework.checker.units.qual.m2", "org.checkerframework.checker.units.qual.Mass", "org.checkerframework.checker.units.qual.min", "org.checkerframework.checker.units.qual.mm", "org.checkerframework.checker.units.qual.mm2", "org.checkerframework.checker.units.qual.mol", "org.checkerframework.checker.units.qual.mPERs", "org.checkerframework.checker.units.qual.mPERs2", "org.checkerframework.checker.units.qual.PolyUnit", "org.checkerframework.checker.units.qual.radians", "org.checkerframework.checker.units.qual.s", "org.checkerframework.checker.units.qual.Speed", "org.checkerframework.checker.units.qual.Substance", "org.checkerframework.checker.units.qual.Temperature", "org.checkerframework.checker.units.qual.Time", "org.checkerframework.checker.units.qual.UnitsBottom", "org.checkerframework.checker.units.qual.UnknownUnits", "org.checkerframework.common.aliasing.qual.LeakedToResult", "org.checkerframework.common.aliasing.qual.MaybeAliased", "org.checkerframework.common.aliasing.qual.NonLeaked", CheckerFrameworkVersion.NAME__UNIQUE, "org.checkerframework.common.reflection.qual.ClassBound", "org.checkerframework.common.reflection.qual.ClassVal", "org.checkerframework.common.reflection.qual.ClassValBottom", "org.checkerframework.common.reflection.qual.MethodVal", "org.checkerframework.common.reflection.qual.MethodValBottom", "org.checkerframework.common.reflection.qual.UnknownClass", "org.checkerframework.common.reflection.qual.UnknownMethod", "org.checkerframework.common.subtyping.qual.Bottom", "org.checkerframework.common.util.report.qual.ReportUnqualified", "org.checkerframework.common.value.qual.ArrayLen", "org.checkerframework.common.value.qual.ArrayLenRange", "org.checkerframework.common.value.qual.BoolVal", "org.checkerframework.common.value.qual.BottomVal", "org.checkerframework.common.value.qual.DoubleVal", "org.checkerframework.common.value.qual.IntRange", "org.checkerframework.common.value.qual.IntVal", "org.checkerframework.common.value.qual.MinLen", "org.checkerframework.common.value.qual.PolyValue", "org.checkerframework.common.value.qual.StringVal", "org.checkerframework.common.value.qual.UnknownVal", "org.checkerframework.framework.qual.PolyAll", "org.checkerframework.framework.util.PurityUnqualified", "org.eclipse.jdt.annotation.NonNull", "org.eclipse.jdt.annotation.Nullable", "org.jetbrains.annotations.NotNull", "org.jetbrains.annotations.Nullable", "org.springframework.lang.NonNull", "org.springframework.lang.Nullable", "org.netbeans.api.annotations.common.NonNull", "org.netbeans.api.annotations.common.NullAllowed"));
    public static final List<String> COPY_TO_SETTER_ANNOTATIONS = Collections.unmodifiableList(Arrays.asList("com.fasterxml.jackson.annotation.JacksonInject", "com.fasterxml.jackson.annotation.JsonAlias", "com.fasterxml.jackson.annotation.JsonFormat", "com.fasterxml.jackson.annotation.JsonIgnore", "com.fasterxml.jackson.annotation.JsonIgnoreProperties", "com.fasterxml.jackson.annotation.JsonProperty", "com.fasterxml.jackson.annotation.JsonSetter", "com.fasterxml.jackson.annotation.JsonSubTypes", "com.fasterxml.jackson.annotation.JsonTypeInfo", "com.fasterxml.jackson.annotation.JsonView", "com.fasterxml.jackson.databind.annotation.JsonDeserialize", "com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty"));
    public static final List<String> COPY_TO_BUILDER_SINGULAR_SETTER_ANNOTATIONS = Collections.unmodifiableList(Arrays.asList("com.fasterxml.jackson.annotation.JsonAnySetter"));
    public static final List<String> JACKSON_COPY_TO_BUILDER_ANNOTATIONS = Collections.unmodifiableList(Arrays.asList("com.fasterxml.jackson.annotation.JsonAutoDetect", "com.fasterxml.jackson.annotation.JsonFormat", "com.fasterxml.jackson.annotation.JsonIgnoreProperties", "com.fasterxml.jackson.annotation.JsonIgnoreType", "com.fasterxml.jackson.annotation.JsonPropertyOrder", "com.fasterxml.jackson.annotation.JsonRootName", "com.fasterxml.jackson.annotation.JsonSubTypes", "com.fasterxml.jackson.annotation.JsonTypeInfo", "com.fasterxml.jackson.annotation.JsonTypeName", "com.fasterxml.jackson.annotation.JsonView", "com.fasterxml.jackson.databind.annotation.JsonNaming"));
    public static final List<String> INVALID_ON_BUILDERS = Collections.unmodifiableList(Arrays.asList(Getter.class.getName(), Setter.class.getName(), With.class.getName(), "lombok.experimental.Wither", ToString.class.getName(), EqualsAndHashCode.class.getName(), RequiredArgsConstructor.class.getName(), AllArgsConstructor.class.getName(), NoArgsConstructor.class.getName(), Data.class.getName(), Value.class.getName(), "lombok.experimental.Value", FieldDefaults.class.getName()));
    private static final Pattern PRIMITIVE_WRAPPER_TYPE_NAME_PATTERN = Pattern.compile("^(?:java\\.lang\\.)?(?:Boolean|Byte|Short|Integer|Long|Float|Double|Character)$");
    private static final Pattern SECTION_FINDER = Pattern.compile("^\\s*\\**\\s*[-*][-*]+\\s*([GS]ETTER|WITH(?:ER)?)\\s*[-*][-*]+\\s*\\**\\s*$", 10);
    private static final Pattern LINE_BREAK_FINDER = Pattern.compile("(\\r?\\n)?");
    private static final Pattern FIND_RETURN = Pattern.compile("^\\s*\\**\\s*@returns?\\s+.*$", 10);

    /* JADX INFO: loaded from: app.apk:lombok/core/handlers/HandlerUtil$FieldAccess.SCL.lombok */
    public enum FieldAccess {
        GETTER,
        PREFER_FIELD,
        ALWAYS_FIELD;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static FieldAccess[] valuesCustom() {
            FieldAccess[] fieldAccessArrValuesCustom = values();
            int length = fieldAccessArrValuesCustom.length;
            FieldAccess[] fieldAccessArr = new FieldAccess[length];
            System.arraycopy(fieldAccessArrValuesCustom, 0, fieldAccessArr, 0, length);
            return fieldAccessArr;
        }
    }

    private HandlerUtil() {
    }

    public static int primeForHashcode() {
        return 59;
    }

    public static int primeForTrue() {
        return 79;
    }

    public static int primeForFalse() {
        return 97;
    }

    public static int primeForNull() {
        return 43;
    }

    public static boolean checkName(String nameSpec, String identifier, LombokNode<?, ?, ?> errorNode) {
        if (identifier.isEmpty()) {
            errorNode.addError(String.valueOf(nameSpec) + " cannot be the empty string.");
            return false;
        }
        if (!JavaIdentifiers.isValidJavaIdentifier(identifier)) {
            errorNode.addError(String.valueOf(nameSpec) + " must be a valid java identifier.");
            return false;
        }
        return true;
    }

    public static String autoSingularize(String plural) {
        return Singulars.autoSingularize(plural);
    }

    public static void handleFlagUsage(LombokNode<?, ?, ?> node, ConfigurationKey<FlagUsageType> key, String featureName) {
        FlagUsageType fut = (FlagUsageType) node.getAst().readConfiguration(key);
        if (fut == null && AllowHelper.isAllowable(key)) {
            node.addError("Use of " + featureName + " is disabled by default. Please add '" + key.getKeyName() + " = " + FlagUsageType.ALLOW + "' to 'lombok.config' if you want to enable is.");
        }
        if (fut != null) {
            String msg = "Use of " + featureName + " is flagged according to lombok configuration.";
            if (fut != FlagUsageType.WARNING) {
                if (fut == FlagUsageType.ERROR) {
                    node.addError(msg);
                    return;
                }
                return;
            }
            node.addWarning(msg);
        }
    }

    public static boolean shouldAddGenerated(LombokNode<?, ?, ?> node) {
        Boolean add = (Boolean) node.getAst().readConfiguration(ConfigurationKeys.ADD_JAVAX_GENERATED_ANNOTATIONS);
        return add != null ? add.booleanValue() : Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_GENERATED_ANNOTATIONS));
    }

    public static void handleExperimentalFlagUsage(LombokNode<?, ?, ?> node, ConfigurationKey<FlagUsageType> key, String featureName) {
        handleFlagUsage(node, key, featureName, ConfigurationKeys.EXPERIMENTAL_FLAG_USAGE, "any lombok.experimental feature");
    }

    public static void handleFlagUsage(LombokNode<?, ?, ?> node, ConfigurationKey<FlagUsageType> key1, String featureName1, ConfigurationKey<FlagUsageType> key2, String featureName2) {
        FlagUsageType fut;
        String featureName;
        FlagUsageType fut1 = (FlagUsageType) node.getAst().readConfiguration(key1);
        FlagUsageType fut2 = (FlagUsageType) node.getAst().readConfiguration(key2);
        if (fut1 == FlagUsageType.ERROR) {
            fut = fut1;
            featureName = featureName1;
        } else if (fut2 != FlagUsageType.ERROR && fut1 == FlagUsageType.WARNING) {
            fut = fut1;
            featureName = featureName1;
        } else {
            fut = fut2;
            featureName = featureName2;
        }
        if (fut != null) {
            String msg = "Use of " + featureName + " is flagged according to lombok configuration.";
            if (fut != FlagUsageType.WARNING) {
                if (fut == FlagUsageType.ERROR) {
                    node.addError(msg);
                    return;
                }
                return;
            }
            node.addWarning(msg);
        }
    }

    public static boolean shouldReturnThis0(AnnotationValues<Accessors> accessors, AST<?, ?, ?> ast) {
        Boolean fluentConfig;
        Boolean chainConfig;
        boolean chainForced = accessors.isExplicit("chain");
        boolean fluentForced = accessors.isExplicit("fluent");
        Accessors instance = accessors.getInstance();
        boolean chain = instance.chain();
        boolean fluent = instance.fluent();
        if (chainForced) {
            return chain;
        }
        if (!chainForced && (chainConfig = (Boolean) ast.readConfiguration(ConfigurationKeys.ACCESSORS_CHAIN)) != null) {
            return chainConfig.booleanValue();
        }
        if (!fluentForced && (fluentConfig = (Boolean) ast.readConfiguration(ConfigurationKeys.ACCESSORS_FLUENT)) != null) {
            fluent = fluentConfig.booleanValue();
        }
        return chain || fluent;
    }

    public static CharSequence removePrefix(CharSequence fieldName, List<String> prefixes) {
        if (prefixes == null || prefixes.isEmpty()) {
            return fieldName;
        }
        CharSequence fieldName2 = fieldName.toString();
        for (String prefix : prefixes) {
            if (prefix.length() == 0) {
                return fieldName2;
            }
            if (fieldName2.length() > prefix.length()) {
                int i = 0;
                while (true) {
                    if (i < prefix.length()) {
                        if (fieldName2.charAt(i) != prefix.charAt(i)) {
                            break;
                        }
                        i++;
                    } else {
                        char followupChar = fieldName2.charAt(prefix.length());
                        if (Character.isLetter(prefix.charAt(prefix.length() - 1)) && Character.isLowerCase(followupChar)) {
                            break;
                        }
                        return new StringBuilder().append(Character.toLowerCase(followupChar)).append((Object) fieldName2.subSequence(prefix.length() + 1, fieldName2.length())).toString();
                    }
                }
            }
        }
        return null;
    }

    public static String toGetterName(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return toAccessorName(ast, accessors, fieldName, isBoolean, "is", "get", true);
    }

    public static String toSetterName(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return toAccessorName(ast, accessors, fieldName, isBoolean, "set", "set", true);
    }

    public static String toWithName(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return toAccessorName(ast, accessors, fieldName, isBoolean, "with", "with", false);
    }

    public static String toWithByName(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return String.valueOf(toAccessorName(ast, accessors, fieldName, isBoolean, "with", "with", false)) + "By";
    }

    private static String toAccessorName(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean, String booleanPrefix, String normalPrefix, boolean adhereToFluent) {
        CharSequence fieldName2 = fieldName.toString();
        if (fieldName2.length() == 0) {
            return null;
        }
        if (Boolean.TRUE.equals(ast.readConfiguration(ConfigurationKeys.GETTER_CONSEQUENT_BOOLEAN))) {
            isBoolean = false;
        }
        boolean explicitPrefix = accessors != null && accessors.isExplicit("prefix");
        boolean explicitFluent = accessors != null && accessors.isExplicit("fluent");
        Accessors ac = (explicitPrefix || explicitFluent) ? accessors.getInstance() : null;
        List<String> prefix = explicitPrefix ? Arrays.asList(ac.prefix()) : (List) ast.readConfiguration(ConfigurationKeys.ACCESSORS_PREFIX);
        boolean fluent = explicitFluent ? ac.fluent() : Boolean.TRUE.equals(ast.readConfiguration(ConfigurationKeys.ACCESSORS_FLUENT));
        CharSequence fieldName3 = removePrefix(fieldName2, prefix);
        if (fieldName3 == null) {
            return null;
        }
        String fName = fieldName3.toString();
        if (adhereToFluent && fluent) {
            return fName;
        }
        if (!isBoolean || !fName.startsWith("is") || fieldName3.length() <= 2 || Character.isLowerCase(fieldName3.charAt(2))) {
            return buildAccessorName(isBoolean ? booleanPrefix : normalPrefix, fName);
        }
        return String.valueOf(booleanPrefix) + fName.substring(2);
    }

    public static List<String> toAllGetterNames(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return toAllAccessorNames(ast, accessors, fieldName, isBoolean, "is", "get", true);
    }

    public static List<String> toAllSetterNames(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return toAllAccessorNames(ast, accessors, fieldName, isBoolean, "set", "set", true);
    }

    public static List<String> toAllWithNames(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        return toAllAccessorNames(ast, accessors, fieldName, isBoolean, "with", "with", false);
    }

    public static List<String> toAllWithByNames(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean) {
        List<String> in = toAllAccessorNames(ast, accessors, fieldName, isBoolean, "with", "with", false);
        if (!(in instanceof ArrayList)) {
            in = new ArrayList(in);
        }
        for (int i = 0; i < in.size(); i++) {
            in.set(i, String.valueOf(in.get(i)) + "By");
        }
        return in;
    }

    private static List<String> toAllAccessorNames(AST<?, ?, ?> ast, AnnotationValues<Accessors> accessors, CharSequence fieldName, boolean isBoolean, String booleanPrefix, String normalPrefix, boolean adhereToFluent) {
        if (Boolean.TRUE.equals(ast.readConfiguration(ConfigurationKeys.GETTER_CONSEQUENT_BOOLEAN))) {
            isBoolean = false;
        }
        if (!isBoolean) {
            String accessorName = toAccessorName(ast, accessors, fieldName, false, booleanPrefix, normalPrefix, adhereToFluent);
            return accessorName == null ? Collections.emptyList() : Collections.singletonList(accessorName);
        }
        boolean explicitPrefix = accessors != null && accessors.isExplicit("prefix");
        boolean explicitFluent = accessors != null && accessors.isExplicit("fluent");
        Accessors ac = (explicitPrefix || explicitFluent) ? accessors.getInstance() : null;
        List<String> prefix = explicitPrefix ? Arrays.asList(ac.prefix()) : (List) ast.readConfiguration(ConfigurationKeys.ACCESSORS_PREFIX);
        boolean fluent = explicitFluent ? ac.fluent() : Boolean.TRUE.equals(ast.readConfiguration(ConfigurationKeys.ACCESSORS_FLUENT));
        CharSequence fieldName2 = removePrefix(fieldName, prefix);
        if (fieldName2 == null) {
            return Collections.emptyList();
        }
        List<String> baseNames = toBaseNames(fieldName2, isBoolean, fluent);
        Set<String> names = new HashSet<>();
        for (String baseName : baseNames) {
            if (adhereToFluent && fluent) {
                names.add(baseName);
            } else {
                names.add(buildAccessorName(normalPrefix, baseName));
                if (!normalPrefix.equals(booleanPrefix)) {
                    names.add(buildAccessorName(booleanPrefix, baseName));
                }
            }
        }
        return new ArrayList(names);
    }

    private static List<String> toBaseNames(CharSequence fieldName, boolean isBoolean, boolean fluent) {
        List<String> baseNames = new ArrayList<>();
        baseNames.add(fieldName.toString());
        String fName = fieldName.toString();
        if (fName.startsWith("is") && fName.length() > 2 && !Character.isLowerCase(fName.charAt(2))) {
            String baseName = fName.substring(2);
            if (fluent) {
                baseNames.add(Character.toLowerCase(baseName.charAt(0)) + baseName.substring(1));
            } else {
                baseNames.add(baseName);
            }
        }
        return baseNames;
    }

    public static String buildAccessorName(String prefix, String suffix) {
        if (suffix.length() == 0) {
            return prefix;
        }
        if (prefix.length() == 0) {
            return suffix;
        }
        char first = suffix.charAt(0);
        if (Character.isLowerCase(first)) {
            boolean useUpperCase = suffix.length() > 2 && (Character.isTitleCase(suffix.charAt(1)) || Character.isUpperCase(suffix.charAt(1)));
            Object[] objArr = new Object[2];
            objArr[0] = Character.valueOf(useUpperCase ? Character.toUpperCase(first) : Character.toTitleCase(first));
            objArr[1] = suffix.subSequence(1, suffix.length());
            suffix = String.format("%s%s", objArr);
        }
        return String.format("%s%s", prefix, suffix);
    }

    public static String camelCaseToConstant(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            return "";
        }
        StringBuilder b2 = new StringBuilder();
        b2.append(Character.toUpperCase(fieldName.charAt(0)));
        for (int i = 1; i < fieldName.length(); i++) {
            char c = fieldName.charAt(i);
            if (Character.isUpperCase(c)) {
                b2.append('_');
            }
            b2.append(Character.toUpperCase(c));
        }
        return b2.toString();
    }

    public static int defaultEqualsAndHashcodeIncludeRank(String typeName) {
        if (JavaIdentifiers.isPrimitive(typeName)) {
            return 1000;
        }
        return PRIMITIVE_WRAPPER_TYPE_NAME_PATTERN.matcher(typeName).matches() ? 800 : 0;
    }

    public static String stripLinesWithTagFromJavadoc(String javadoc, String regexpFragment) {
        Pattern p = Pattern.compile("^\\s*\\**\\s*" + regexpFragment + "\\s*\\**\\s*$", 10);
        Matcher m = p.matcher(javadoc);
        return m.replaceAll("");
    }

    public static String stripSectionsFromJavadoc(String javadoc) {
        Matcher sectionMatcher = SECTION_FINDER.matcher(javadoc);
        return !sectionMatcher.find() ? javadoc : javadoc.substring(0, sectionMatcher.start());
    }

    public static String getJavadocSection(String javadoc, String sectionNameSpec) {
        String[] sectionNames = sectionNameSpec.split("\\|");
        Matcher sectionMatcher = SECTION_FINDER.matcher(javadoc);
        Matcher lineBreakMatcher = LINE_BREAK_FINDER.matcher(javadoc);
        int sectionStart = -1;
        int sectionEnd = -1;
        while (sectionMatcher.find()) {
            boolean found = false;
            for (String sectionName : sectionNames) {
                if (sectionMatcher.group(1).equalsIgnoreCase(sectionName)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                lineBreakMatcher.find(sectionMatcher.end());
                sectionStart = lineBreakMatcher.end();
            } else if (sectionStart != -1) {
                sectionEnd = sectionMatcher.start();
            }
        }
        if (sectionStart != -1) {
            return sectionEnd != -1 ? javadoc.substring(sectionStart, sectionEnd) : javadoc.substring(sectionStart);
        }
        return null;
    }

    public static String addReturnsThisIfNeeded(String in) {
        return FIND_RETURN.matcher(in).find() ? in : addJavadocLine(in, "@return {@code this}.");
    }

    public static String addReturnsUpdatedSelfIfNeeded(String in) {
        return FIND_RETURN.matcher(in).find() ? in : addJavadocLine(in, "@return a clone of this object, except with this updated property (returns {@code this} if an identical value is passed).");
    }

    public static String addJavadocLine(String in, String line) {
        return in.endsWith("\n") ? String.valueOf(in) + line + "\n" : String.valueOf(in) + "\n" + line;
    }
}
