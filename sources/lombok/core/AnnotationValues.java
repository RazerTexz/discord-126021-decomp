package lombok.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationValues.SCL.lombok */
public class AnnotationValues<A extends Annotation> {
    private final Class<A> type;
    private final Map<String, AnnotationValues$AnnotationValue> values;
    private final LombokNode<?, ?, ?> ast;
    private A cachedInstance = null;

    static /* synthetic */ Map access$0(AnnotationValues annotationValues) {
        return annotationValues.values;
    }

    public AnnotationValues(Class<A> type, Map<String, AnnotationValues$AnnotationValue> values, LombokNode<?, ?, ?> ast) {
        this.type = type;
        this.values = values;
        this.ast = ast;
    }

    public static <A extends Annotation> AnnotationValues<A> of(Class<A> type) {
        return new AnnotationValues<>(type, Collections.emptyMap(), null);
    }

    public static <A extends Annotation> AnnotationValues<A> of(Class<A> type, LombokNode<?, ?, ?> ast) {
        return new AnnotationValues<>(type, Collections.emptyMap(), ast);
    }

    static /* synthetic */ AnnotationValues$AnnotationValueDecodeFail access$1(AnnotationValues$AnnotationValue annotationValues$AnnotationValue, Method method) {
        return makeNoDefaultFail(annotationValues$AnnotationValue, method);
    }

    private static AnnotationValues$AnnotationValueDecodeFail makeNoDefaultFail(AnnotationValues$AnnotationValue owner, Method method) {
        return new AnnotationValues$AnnotationValueDecodeFail(owner, "No value supplied but " + method.getName() + " has no default either.", -1);
    }

    public List<String> getAsStringList(String methodName) {
        AnnotationValues$AnnotationValue v = this.values.get(methodName);
        if (v == null) {
            String[] s2 = (String[]) getDefaultIf(methodName, String[].class, new String[0]);
            return Collections.unmodifiableList(Arrays.asList(s2));
        }
        List<String> out = new ArrayList<>(v.valueGuesses.size());
        Iterator<Object> it = v.valueGuesses.iterator();
        while (it.hasNext()) {
            Object guess = it.next();
            Object result = guess == null ? null : guessToType(guess, String.class, v, 0);
            if (result == null) {
                if (v.valueGuesses.size() == 1) {
                    String[] s3 = (String[]) getDefaultIf(methodName, String[].class, new String[0]);
                    return Collections.unmodifiableList(Arrays.asList(s3));
                }
                throw new AnnotationValues$AnnotationValueDecodeFail(v, "I can't make sense of this annotation value. Try using a fully qualified literal.", 0);
            }
            out.add((String) result);
        }
        return Collections.unmodifiableList(out);
    }

    public String getAsString(String methodName) {
        AnnotationValues$AnnotationValue v = this.values.get(methodName);
        if (v == null || v.valueGuesses.size() != 1) {
            return (String) getDefaultIf(methodName, String.class, "");
        }
        Object guess = guessToType(v.valueGuesses.get(0), String.class, v, 0);
        return guess instanceof String ? (String) guess : (String) getDefaultIf(methodName, String.class, "");
    }

    public boolean getAsBoolean(String methodName) {
        AnnotationValues$AnnotationValue v = this.values.get(methodName);
        if (v == null || v.valueGuesses.size() != 1) {
            return ((Boolean) getDefaultIf(methodName, Boolean.TYPE, false)).booleanValue();
        }
        Object guess = guessToType(v.valueGuesses.get(0), Boolean.TYPE, v, 0);
        return guess instanceof Boolean ? ((Boolean) guess).booleanValue() : ((Boolean) getDefaultIf(methodName, Boolean.TYPE, false)).booleanValue();
    }

    public <T> T getDefaultIf(String methodName, Class<T> type, T defaultValue) {
        try {
            return type.cast(Permit.getMethod(type, methodName, new Class[0]).getDefaultValue());
        } catch (Exception unused) {
            return defaultValue;
        }
    }

    public A getInstance() {
        if (this.cachedInstance != null) {
            return this.cachedInstance;
        }
        AnnotationValues$1 invocations = new AnnotationValues$1(this);
        A a = (A) Proxy.newProxyInstance(this.type.getClassLoader(), new Class[]{this.type}, invocations);
        this.cachedInstance = a;
        return a;
    }

    static /* synthetic */ Object access$2(AnnotationValues annotationValues, Object obj, Class cls, AnnotationValues$AnnotationValue annotationValues$AnnotationValue, int i) {
        return annotationValues.guessToType(obj, cls, annotationValues$AnnotationValue, i);
    }

    private Object guessToType(Object guess, Class<?> expected, AnnotationValues$AnnotationValue v, int pos) {
        if ((expected == Integer.TYPE || expected == Integer.class) && ((guess instanceof Integer) || (guess instanceof Short) || (guess instanceof Byte))) {
            return Integer.valueOf(((Number) guess).intValue());
        }
        if ((expected == Long.TYPE || expected == Long.class) && ((guess instanceof Long) || (guess instanceof Integer) || (guess instanceof Short) || (guess instanceof Byte))) {
            return Long.valueOf(((Number) guess).longValue());
        }
        if ((expected == Short.TYPE || expected == Short.class) && ((guess instanceof Integer) || (guess instanceof Short) || (guess instanceof Byte))) {
            int intVal = ((Number) guess).intValue();
            int shortVal = ((Number) guess).shortValue();
            if (shortVal == intVal) {
                return Integer.valueOf(shortVal);
            }
        }
        if ((expected == Byte.TYPE || expected == Byte.class) && ((guess instanceof Integer) || (guess instanceof Short) || (guess instanceof Byte))) {
            int intVal2 = ((Number) guess).intValue();
            int byteVal = ((Number) guess).byteValue();
            if (byteVal == intVal2) {
                return Integer.valueOf(byteVal);
            }
        }
        if ((expected == Double.TYPE || expected == Double.class) && (guess instanceof Number)) {
            return Double.valueOf(((Number) guess).doubleValue());
        }
        if ((expected == Float.TYPE || expected == Float.class) && (guess instanceof Number)) {
            return Float.valueOf(((Number) guess).floatValue());
        }
        if ((expected == Boolean.TYPE || expected == Boolean.class) && (guess instanceof Boolean)) {
            return Boolean.valueOf(((Boolean) guess).booleanValue());
        }
        if ((expected == Character.TYPE || expected == Character.class) && (guess instanceof Character)) {
            return Character.valueOf(((Character) guess).charValue());
        }
        if (expected == String.class && (guess instanceof String)) {
            return guess;
        }
        if (Enum.class.isAssignableFrom(expected) && (guess instanceof FieldSelect)) {
            String fieldSel = ((FieldSelect) guess).getFinalPart();
            for (Object enumConstant : expected.getEnumConstants()) {
                String target = ((Enum) enumConstant).name();
                if (target.equals(fieldSel)) {
                    return enumConstant;
                }
            }
            throw new AnnotationValues$AnnotationValueDecodeFail(v, "Can't translate " + fieldSel + " to an enum of type " + expected, pos);
        }
        if (expected == Class.class && (guess instanceof ClassLiteral)) {
            try {
                String classLit = ((ClassLiteral) guess).getClassName();
                return Class.forName(toFQ(classLit));
            } catch (ClassNotFoundException unused) {
                throw new AnnotationValues$AnnotationValueDecodeFail(v, "Can't translate " + guess + " to a class object.", pos);
            }
        }
        if (guess instanceof AnnotationValues) {
            return ((AnnotationValues) guess).getInstance();
        }
        if (guess instanceof FieldSelect) {
            throw new AnnotationValues$AnnotationValueDecodeFail(v, "You must use constant literals in lombok annotations; they cannot be references to (static) fields.", pos);
        }
        throw new AnnotationValues$AnnotationValueDecodeFail(v, "Can't translate a " + guess.getClass() + " to the expected " + expected, pos);
    }

    public List<String> getRawExpressions(String annotationMethodName) {
        AnnotationValues$AnnotationValue v = this.values.get(annotationMethodName);
        return v == null ? Collections.emptyList() : v.raws;
    }

    public List<Object> getActualExpressions(String annotationMethodName) {
        AnnotationValues$AnnotationValue v = this.values.get(annotationMethodName);
        return v == null ? Collections.emptyList() : v.expressions;
    }

    public boolean isExplicit(String annotationMethodName) {
        AnnotationValues$AnnotationValue annotationValue = this.values.get(annotationMethodName);
        return annotationValue != null && annotationValue.isExplicit();
    }

    public String getRawExpression(String annotationMethodName) {
        List<String> l = getRawExpressions(annotationMethodName);
        if (l.isEmpty()) {
            return null;
        }
        return l.get(0);
    }

    public Object getActualExpression(String annotationMethodName) {
        List<Object> l = getActualExpressions(annotationMethodName);
        if (l.isEmpty()) {
            return null;
        }
        return l.get(0);
    }

    public Object getValueGuess(String annotationMethodName) {
        AnnotationValues$AnnotationValue v = this.values.get(annotationMethodName);
        if (v == null || v.valueGuesses.isEmpty()) {
            return null;
        }
        return v.valueGuesses.get(0);
    }

    public void setError(String annotationMethodName, String message) {
        setError(annotationMethodName, message, -1);
    }

    public void setWarning(String annotationMethodName, String message) {
        setWarning(annotationMethodName, message, -1);
    }

    public void setError(String annotationMethodName, String message, int index) {
        AnnotationValues$AnnotationValue v = this.values.get(annotationMethodName);
        if (v == null) {
            return;
        }
        v.setError(message, index);
    }

    public void setWarning(String annotationMethodName, String message, int index) {
        AnnotationValues$AnnotationValue v = this.values.get(annotationMethodName);
        if (v == null) {
            return;
        }
        v.setWarning(message, index);
    }

    public List<String> getProbableFQTypes(String annotationMethodName) {
        List<String> result = new ArrayList<>();
        AnnotationValues$AnnotationValue v = this.values.get(annotationMethodName);
        if (v == null) {
            return Collections.emptyList();
        }
        Iterator<Object> it = v.valueGuesses.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            result.add(o == null ? null : toFQ(o.toString()));
        }
        return result;
    }

    public String getProbableFQType(String annotationMethodName) {
        List<String> l = getProbableFQTypes(annotationMethodName);
        if (l.isEmpty()) {
            return null;
        }
        return l.get(0);
    }

    private String toFQ(String typeName) {
        String fqn;
        String prefix = typeName.indexOf(46) > -1 ? typeName.substring(0, typeName.indexOf(46)) : typeName;
        LombokNode<?, ?, ?> lombokNodeUp = this.ast;
        while (true) {
            LombokNode<?, ?, ?> n = lombokNodeUp;
            if (n == null) {
                break;
            }
            if (n.getKind() == AST$Kind.TYPE) {
                String simpleName = n.getName();
                if (prefix.equals(simpleName)) {
                    List<String> outerNames = new ArrayList<>();
                    LombokNode<?, ?, ?> n2 = n.up();
                    if (n2 != null && n2.getKind() != AST$Kind.COMPILATION_UNIT) {
                        if (n2.getKind() != AST$Kind.TYPE) {
                            break;
                        }
                        outerNames.add(n2.getName());
                        break;
                    }
                    StringBuilder result = new StringBuilder();
                    if (this.ast.getPackageDeclaration() != null) {
                        result.append(this.ast.getPackageDeclaration());
                    }
                    if (result.length() > 0) {
                        result.append('.');
                    }
                    Collections.reverse(outerNames);
                    for (String outerName : outerNames) {
                        result.append(outerName).append('.');
                    }
                    result.append(typeName);
                    return result.toString();
                }
            }
            lombokNodeUp = n.up();
        }
        if (prefix.equals(typeName) && (fqn = this.ast.getImportList().getFullyQualifiedNameForSimpleName(typeName)) != null) {
            return fqn;
        }
        for (String potential : this.ast.getImportList().applyNameToStarImports("java", typeName)) {
            try {
                Class<?> c = Class.forName(potential);
                if (c != null) {
                    return c.getName();
                }
                continue;
            } catch (Throwable unused) {
            }
        }
        if (typeName.indexOf(46) == -1) {
            return inLocalPackage(this.ast, typeName);
        }
        char firstChar = typeName.charAt(0);
        if (Character.isTitleCase(firstChar) || Character.isUpperCase(firstChar)) {
            return inLocalPackage(this.ast, typeName);
        }
        return typeName;
    }

    private static String inLocalPackage(LombokNode<?, ?, ?> node, String typeName) {
        StringBuilder result = new StringBuilder();
        if (node != null && node.getPackageDeclaration() != null) {
            result.append(node.getPackageDeclaration());
        }
        if (result.length() > 0) {
            result.append('.');
        }
        result.append(typeName);
        return result.toString();
    }
}
