package lombok.eclipse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lombok.core.ClassLiteral;
import lombok.core.FieldSelect;
import lombok.core.JavaIdentifiers;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Literal;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/Eclipse.SCL.lombok */
public class Eclipse {
    public static final int ECLIPSE_DO_NOT_TOUCH_FLAG = 8388608;
    private static final Annotation[] EMPTY_ANNOTATIONS_ARRAY = new Annotation[0];
    private static final Pattern SPLIT_AT_DOT = Pattern.compile("\\.");
    private static long latestEcjCompilerVersionConstantCached = 0;
    private static int ecjCompilerVersionCached = -1;
    private static boolean caseStatementInit = false;
    private static Field caseStatementConstantExpressions = null;

    private Eclipse() {
    }

    public static String toQualifiedName(char[][] typeName) {
        int len = typeName.length - 1;
        if (len == 0) {
            return new String(typeName[0]);
        }
        for (char[] c : typeName) {
            len += c.length;
        }
        char[] ret = new char[len];
        char[] part = typeName[0];
        System.arraycopy(part, 0, ret, 0, part.length);
        int pos = part.length;
        for (int i = 1; i < typeName.length; i++) {
            int i2 = pos;
            int pos2 = pos + 1;
            ret[i2] = '.';
            char[] part2 = typeName[i];
            System.arraycopy(part2, 0, ret, pos2, part2.length);
            pos = pos2 + part2.length;
        }
        return new String(ret);
    }

    public static char[][] fromQualifiedName(String typeName) {
        String[] split = SPLIT_AT_DOT.split(typeName);
        char[][] result = new char[split.length][];
        for (int i = 0; i < split.length; i++) {
            result[i] = split[i].toCharArray();
        }
        return result;
    }

    public static long pos(ASTNode node) {
        return (((long) node.sourceStart) << 32) | (((long) node.sourceEnd) & 4294967295L);
    }

    public static long[] poss(ASTNode node, int repeat) {
        long p = (((long) node.sourceStart) << 32) | (((long) node.sourceEnd) & 4294967295L);
        long[] out = new long[repeat];
        Arrays.fill(out, p);
        return out;
    }

    public static boolean nameEquals(char[][] typeName, String string) {
        int pos = 0;
        int len = string.length();
        for (int i = 0; i < typeName.length; i++) {
            char[] t = typeName[i];
            if (i > 0) {
                if (pos == len) {
                    return false;
                }
                int i2 = pos;
                pos++;
                if (string.charAt(i2) != '.') {
                    return false;
                }
            }
            for (char c : t) {
                if (pos == len) {
                    return false;
                }
                int i3 = pos;
                pos++;
                if (string.charAt(i3) != c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasClinit(TypeDeclaration parent) {
        if (parent.methods == null) {
            return false;
        }
        for (AbstractMethodDeclaration method : parent.methods) {
            if (method instanceof Clinit) {
                return true;
            }
        }
        return false;
    }

    public static Annotation[] findAnnotations(AbstractVariableDeclaration field, Pattern namePattern) {
        List<Annotation> result = new ArrayList<>();
        if (field.annotations == null) {
            return EMPTY_ANNOTATIONS_ARRAY;
        }
        for (Annotation annotation : field.annotations) {
            TypeReference typeRef = annotation.type;
            if (typeRef != null && typeRef.getTypeName() != null) {
                char[][] typeName = typeRef.getTypeName();
                String suspect = new String(typeName[typeName.length - 1]);
                if (namePattern.matcher(suspect).matches()) {
                    result.add(annotation);
                }
            }
        }
        return (Annotation[]) result.toArray(EMPTY_ANNOTATIONS_ARRAY);
    }

    public static boolean isPrimitive(TypeReference ref) {
        if (ref.dimensions() > 0) {
            return false;
        }
        return JavaIdentifiers.isPrimitive(toQualifiedName(ref.getTypeName()));
    }

    public static Object calculateValue(Expression e) {
        if (e instanceof Literal) {
            ((Literal) e).computeConstant();
            switch (e.constant.typeID()) {
                case 2:
                    return Character.valueOf(e.constant.charValue());
                case 3:
                    return Byte.valueOf(e.constant.byteValue());
                case 4:
                    return Short.valueOf(e.constant.shortValue());
                case 5:
                    return Boolean.valueOf(e.constant.booleanValue());
                case 6:
                default:
                    return null;
                case 7:
                    return Long.valueOf(e.constant.longValue());
                case 8:
                    return Double.valueOf(e.constant.doubleValue());
                case 9:
                    return Float.valueOf(e.constant.floatValue());
                case 10:
                    return Integer.valueOf(e.constant.intValue());
                case 11:
                    return e.constant.stringValue();
            }
        }
        if (e instanceof ClassLiteralAccess) {
            return new ClassLiteral(toQualifiedName(((ClassLiteralAccess) e).type.getTypeName()));
        }
        if (e instanceof SingleNameReference) {
            return new FieldSelect(new String(((SingleNameReference) e).token));
        }
        if (e instanceof QualifiedNameReference) {
            String qName = toQualifiedName(((QualifiedNameReference) e).tokens);
            int idx = qName.lastIndexOf(46);
            return new FieldSelect(idx == -1 ? qName : qName.substring(idx + 1));
        }
        if ((e instanceof UnaryExpression) && "-".equals(((UnaryExpression) e).operatorToString())) {
            Object inner = calculateValue(((UnaryExpression) e).expression);
            if (inner instanceof Integer) {
                return Integer.valueOf(-((Integer) inner).intValue());
            }
            if (inner instanceof Byte) {
                return Integer.valueOf(-((Byte) inner).byteValue());
            }
            if (inner instanceof Short) {
                return Integer.valueOf(-((Short) inner).shortValue());
            }
            if (inner instanceof Long) {
                return Long.valueOf(-((Long) inner).longValue());
            }
            if (inner instanceof Float) {
                return Float.valueOf(-((Float) inner).floatValue());
            }
            if (inner instanceof Double) {
                return Double.valueOf(-((Double) inner).doubleValue());
            }
            return null;
        }
        return null;
    }

    public static long getLatestEcjCompilerVersionConstant() {
        int thisVersion;
        if (latestEcjCompilerVersionConstantCached != 0) {
            return latestEcjCompilerVersionConstantCached;
        }
        int highestVersionSoFar = 0;
        for (Field f : ClassFileConstants.class.getDeclaredFields()) {
            try {
                if (f.getName().startsWith("JDK1_") && (thisVersion = Integer.parseInt(f.getName().substring("JDK1_".length()))) > highestVersionSoFar) {
                    highestVersionSoFar = thisVersion;
                    latestEcjCompilerVersionConstantCached = ((Long) f.get(null)).longValue();
                }
            } catch (Exception unused) {
            }
        }
        if (highestVersionSoFar > 6 && !ecjSupportsJava7Features()) {
            latestEcjCompilerVersionConstantCached = 3276800L;
        }
        return latestEcjCompilerVersionConstantCached;
    }

    public static int getEcjCompilerVersion() {
        if (ecjCompilerVersionCached >= 0) {
            return ecjCompilerVersionCached;
        }
        for (Field f : CompilerOptions.class.getDeclaredFields()) {
            try {
                if (f.getName().startsWith("VERSION_1_")) {
                    ecjCompilerVersionCached = Math.max(ecjCompilerVersionCached, Integer.parseInt(f.getName().substring("VERSION_1_".length())));
                }
            } catch (Exception unused) {
            }
        }
        if (ecjCompilerVersionCached < 5) {
            ecjCompilerVersionCached = 5;
        }
        if (!ecjSupportsJava7Features()) {
            ecjCompilerVersionCached = Math.min(6, ecjCompilerVersionCached);
        }
        return ecjCompilerVersionCached;
    }

    private static boolean ecjSupportsJava7Features() {
        try {
            TryStatement.class.getDeclaredField("resources");
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    public static CaseStatement createCaseStatement(Expression expr) {
        CaseStatement stat = new CaseStatement(expr, 0, 0);
        if (expr == null) {
            return stat;
        }
        if (!caseStatementInit) {
            try {
                caseStatementConstantExpressions = Permit.getField(CaseStatement.class, "constantExpressions");
                caseStatementConstantExpressions.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            caseStatementInit = true;
        }
        if (caseStatementConstantExpressions != null) {
            try {
                caseStatementConstantExpressions.set(stat, new Expression[]{expr});
            } catch (IllegalAccessException unused2) {
            } catch (IllegalArgumentException unused3) {
            }
        }
        return stat;
    }
}
