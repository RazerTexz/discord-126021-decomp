package lombok.delombok;

import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.tree.DocCommentTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.javac.CommentInfo;
import lombok.javac.Javac;
import lombok.javac.JavacTreeMaker;
import lombok.javac.PackageName;
import lombok.permit.Permit;

/* JADX INFO: loaded from: discord-126021.apk:lombok/delombok/PrettyPrinter.SCL.lombok */
public class PrettyPrinter extends JCTree.Visitor {
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final Map<JavacTreeMaker.TreeTag, String> OPERATORS;
    private final Writer out;
    private final JCTree.JCCompilationUnit compilationUnit;
    private List<CommentInfo> comments;
    private final int[] textBlockStarts;
    private final FormatPreferences formatPreferences;
    private final Map<JCTree, String> docComments;
    private final DocCommentTable docTable;
    private boolean needsAlign;
    private boolean needsNewLine;
    private boolean needsSpace;
    private boolean aligned;
    private Name __INIT__;
    private Name __VALUE__;
    private Name currentTypeName;
    private static final long DEFAULT = 8796093022208L;
    private static final int PREFIX = 14;
    private static final Method getExtendsClause;
    private static final Method getEndPosition;
    private static final Method storeEnd;
    private static final Map<Class<?>, Map<String, Field>> reflectionCache;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$CommentInfo$StartConnection;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$CommentInfo$EndConnection;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$sun$source$tree$Tree$Kind;
    private int indent = 0;
    private boolean onNewLine = true;
    private boolean innermostArrayBracketsAreVarargs = false;
    private long flagMod = -1;
    private boolean jcAnnotatedTypeInit = false;
    private Class<?> jcAnnotatedTypeClass = null;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$CommentInfo$StartConnection() {
        int[] iArr = $SWITCH_TABLE$lombok$javac$CommentInfo$StartConnection;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CommentInfo.StartConnection.valuesCustom().length];
        try {
            iArr2[CommentInfo.StartConnection.AFTER_PREVIOUS.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CommentInfo.StartConnection.DIRECT_AFTER_PREVIOUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CommentInfo.StartConnection.ON_NEXT_LINE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[CommentInfo.StartConnection.START_OF_LINE.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$lombok$javac$CommentInfo$StartConnection = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$CommentInfo$EndConnection() {
        int[] iArr = $SWITCH_TABLE$lombok$javac$CommentInfo$EndConnection;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CommentInfo.EndConnection.valuesCustom().length];
        try {
            iArr2[CommentInfo.EndConnection.AFTER_COMMENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CommentInfo.EndConnection.DIRECT_AFTER_COMMENT.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CommentInfo.EndConnection.ON_NEXT_LINE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$javac$CommentInfo$EndConnection = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$sun$source$tree$Tree$Kind() {
        int[] iArr = $SWITCH_TABLE$com$sun$source$tree$Tree$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Tree.Kind.values().length];
        try {
            iArr2[Tree.Kind.AND.ordinal()] = 64;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Tree.Kind.AND_ASSIGNMENT.ordinal()] = 77;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Tree.Kind.ANNOTATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Tree.Kind.ARRAY_ACCESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Tree.Kind.ARRAY_TYPE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Tree.Kind.ASSERT.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Tree.Kind.ASSIGNMENT.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[Tree.Kind.BITWISE_COMPLEMENT.ordinal()] = 48;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[Tree.Kind.BLOCK.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[Tree.Kind.BOOLEAN_LITERAL.ordinal()] = 84;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[Tree.Kind.BREAK.ordinal()] = 7;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[Tree.Kind.CASE.ordinal()] = 8;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[Tree.Kind.CATCH.ordinal()] = 9;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[Tree.Kind.CHAR_LITERAL.ordinal()] = 85;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[Tree.Kind.CLASS.ordinal()] = 10;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[Tree.Kind.COMPILATION_UNIT.ordinal()] = 11;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_AND.ordinal()] = 67;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_EXPRESSION.ordinal()] = 12;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_OR.ordinal()] = 68;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr2[Tree.Kind.CONTINUE.ordinal()] = 13;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr2[Tree.Kind.DIVIDE.ordinal()] = 51;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr2[Tree.Kind.DIVIDE_ASSIGNMENT.ordinal()] = 70;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr2[Tree.Kind.DOUBLE_LITERAL.ordinal()] = 83;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr2[Tree.Kind.DO_WHILE_LOOP.ordinal()] = 14;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr2[Tree.Kind.EMPTY_STATEMENT.ordinal()] = 32;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr2[Tree.Kind.ENHANCED_FOR_LOOP.ordinal()] = 15;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            iArr2[Tree.Kind.EQUAL_TO.ordinal()] = 62;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            iArr2[Tree.Kind.ERRONEOUS.ordinal()] = 91;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            iArr2[Tree.Kind.EXPRESSION_STATEMENT.ordinal()] = 16;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            iArr2[Tree.Kind.EXTENDS_WILDCARD.ordinal()] = 89;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            iArr2[Tree.Kind.FLOAT_LITERAL.ordinal()] = 82;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            iArr2[Tree.Kind.FOR_LOOP.ordinal()] = 18;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            iArr2[Tree.Kind.GREATER_THAN.ordinal()] = 59;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            iArr2[Tree.Kind.GREATER_THAN_EQUAL.ordinal()] = 61;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            iArr2[Tree.Kind.IDENTIFIER.ordinal()] = 19;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            iArr2[Tree.Kind.IF.ordinal()] = 20;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            iArr2[Tree.Kind.IMPORT.ordinal()] = 21;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            iArr2[Tree.Kind.INSTANCE_OF.ordinal()] = 22;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            iArr2[Tree.Kind.INT_LITERAL.ordinal()] = 80;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            iArr2[Tree.Kind.LABELED_STATEMENT.ordinal()] = 23;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            iArr2[Tree.Kind.LEFT_SHIFT.ordinal()] = 55;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            iArr2[Tree.Kind.LEFT_SHIFT_ASSIGNMENT.ordinal()] = 74;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            iArr2[Tree.Kind.LESS_THAN.ordinal()] = 58;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            iArr2[Tree.Kind.LESS_THAN_EQUAL.ordinal()] = 60;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            iArr2[Tree.Kind.LOGICAL_COMPLEMENT.ordinal()] = 49;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            iArr2[Tree.Kind.LONG_LITERAL.ordinal()] = 81;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            iArr2[Tree.Kind.MEMBER_SELECT.ordinal()] = 17;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            iArr2[Tree.Kind.METHOD.ordinal()] = 24;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            iArr2[Tree.Kind.METHOD_INVOCATION.ordinal()] = 25;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            iArr2[Tree.Kind.MINUS.ordinal()] = 54;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            iArr2[Tree.Kind.MINUS_ASSIGNMENT.ordinal()] = 73;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            iArr2[Tree.Kind.MODIFIERS.ordinal()] = 26;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            iArr2[Tree.Kind.MULTIPLY.ordinal()] = 50;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            iArr2[Tree.Kind.MULTIPLY_ASSIGNMENT.ordinal()] = 69;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            iArr2[Tree.Kind.NEW_ARRAY.ordinal()] = 27;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            iArr2[Tree.Kind.NEW_CLASS.ordinal()] = 28;
        } catch (NoSuchFieldError unused56) {
        }
        try {
            iArr2[Tree.Kind.NOT_EQUAL_TO.ordinal()] = 63;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            iArr2[Tree.Kind.NULL_LITERAL.ordinal()] = 87;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            iArr2[Tree.Kind.OR.ordinal()] = 66;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            iArr2[Tree.Kind.OR_ASSIGNMENT.ordinal()] = 79;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            iArr2[Tree.Kind.OTHER.ordinal()] = 92;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            iArr2[Tree.Kind.PARAMETERIZED_TYPE.ordinal()] = 37;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            iArr2[Tree.Kind.PARENTHESIZED.ordinal()] = 29;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            iArr2[Tree.Kind.PLUS.ordinal()] = 53;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            iArr2[Tree.Kind.PLUS_ASSIGNMENT.ordinal()] = 72;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            iArr2[Tree.Kind.POSTFIX_DECREMENT.ordinal()] = 43;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            iArr2[Tree.Kind.POSTFIX_INCREMENT.ordinal()] = 42;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            iArr2[Tree.Kind.PREFIX_DECREMENT.ordinal()] = 45;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            iArr2[Tree.Kind.PREFIX_INCREMENT.ordinal()] = 44;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            iArr2[Tree.Kind.PRIMITIVE_TYPE.ordinal()] = 30;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            iArr2[Tree.Kind.REMAINDER.ordinal()] = 52;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            iArr2[Tree.Kind.REMAINDER_ASSIGNMENT.ordinal()] = 71;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            iArr2[Tree.Kind.RETURN.ordinal()] = 31;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            iArr2[Tree.Kind.RIGHT_SHIFT.ordinal()] = 56;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            iArr2[Tree.Kind.RIGHT_SHIFT_ASSIGNMENT.ordinal()] = 75;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            iArr2[Tree.Kind.STRING_LITERAL.ordinal()] = 86;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            iArr2[Tree.Kind.SUPER_WILDCARD.ordinal()] = 90;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            iArr2[Tree.Kind.SWITCH.ordinal()] = 33;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            iArr2[Tree.Kind.SYNCHRONIZED.ordinal()] = 34;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            iArr2[Tree.Kind.THROW.ordinal()] = 35;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            iArr2[Tree.Kind.TRY.ordinal()] = 36;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            iArr2[Tree.Kind.TYPE_CAST.ordinal()] = 38;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            iArr2[Tree.Kind.TYPE_PARAMETER.ordinal()] = 39;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            iArr2[Tree.Kind.UNARY_MINUS.ordinal()] = 47;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            iArr2[Tree.Kind.UNARY_PLUS.ordinal()] = 46;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            iArr2[Tree.Kind.UNBOUNDED_WILDCARD.ordinal()] = 88;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            iArr2[Tree.Kind.UNSIGNED_RIGHT_SHIFT.ordinal()] = 57;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            iArr2[Tree.Kind.UNSIGNED_RIGHT_SHIFT_ASSIGNMENT.ordinal()] = 76;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            iArr2[Tree.Kind.VARIABLE.ordinal()] = 40;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            iArr2[Tree.Kind.WHILE_LOOP.ordinal()] = 41;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            iArr2[Tree.Kind.XOR.ordinal()] = 65;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            iArr2[Tree.Kind.XOR_ASSIGNMENT.ordinal()] = 78;
        } catch (NoSuchFieldError unused92) {
        }
        $SWITCH_TABLE$com$sun$source$tree$Tree$Kind = iArr2;
        return iArr2;
    }

    static {
        Method storeEndMethodTemp;
        Map<JavacTreeMaker.TreeTag, String> map = new HashMap<>();
        map.put(JavacTreeMaker.TreeTag.treeTag("POS"), BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        map.put(JavacTreeMaker.TreeTag.treeTag("NEG"), "-");
        map.put(JavacTreeMaker.TreeTag.treeTag("NOT"), "!");
        map.put(JavacTreeMaker.TreeTag.treeTag("COMPL"), "~");
        map.put(JavacTreeMaker.TreeTag.treeTag("PREINC"), "++");
        map.put(JavacTreeMaker.TreeTag.treeTag("PREDEC"), "--");
        map.put(JavacTreeMaker.TreeTag.treeTag("POSTINC"), "++");
        map.put(JavacTreeMaker.TreeTag.treeTag("POSTDEC"), "--");
        map.put(JavacTreeMaker.TreeTag.treeTag("NULLCHK"), "<*nullchk*>");
        map.put(JavacTreeMaker.TreeTag.treeTag("OR"), "||");
        map.put(JavacTreeMaker.TreeTag.treeTag("AND"), "&&");
        map.put(JavacTreeMaker.TreeTag.treeTag("EQ"), "==");
        map.put(JavacTreeMaker.TreeTag.treeTag("NE"), "!=");
        map.put(JavacTreeMaker.TreeTag.treeTag("LT"), "<");
        map.put(JavacTreeMaker.TreeTag.treeTag("GT"), ">");
        map.put(JavacTreeMaker.TreeTag.treeTag("LE"), "<=");
        map.put(JavacTreeMaker.TreeTag.treeTag("GE"), ">=");
        map.put(JavacTreeMaker.TreeTag.treeTag("BITOR"), "|");
        map.put(JavacTreeMaker.TreeTag.treeTag("BITXOR"), "^");
        map.put(JavacTreeMaker.TreeTag.treeTag("BITAND"), "&");
        map.put(JavacTreeMaker.TreeTag.treeTag("SL"), "<<");
        map.put(JavacTreeMaker.TreeTag.treeTag("SR"), ">>");
        map.put(JavacTreeMaker.TreeTag.treeTag("USR"), ">>>");
        map.put(JavacTreeMaker.TreeTag.treeTag("PLUS"), BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        map.put(JavacTreeMaker.TreeTag.treeTag("MINUS"), "-");
        map.put(JavacTreeMaker.TreeTag.treeTag("MUL"), "*");
        map.put(JavacTreeMaker.TreeTag.treeTag("DIV"), AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        map.put(JavacTreeMaker.TreeTag.treeTag("MOD"), "%");
        map.put(JavacTreeMaker.TreeTag.treeTag("BITOR_ASG"), "|=");
        map.put(JavacTreeMaker.TreeTag.treeTag("BITXOR_ASG"), "^=");
        map.put(JavacTreeMaker.TreeTag.treeTag("BITAND_ASG"), "&=");
        map.put(JavacTreeMaker.TreeTag.treeTag("SL_ASG"), "<<=");
        map.put(JavacTreeMaker.TreeTag.treeTag("SR_ASG"), ">>=");
        map.put(JavacTreeMaker.TreeTag.treeTag("USR_ASG"), ">>>=");
        map.put(JavacTreeMaker.TreeTag.treeTag("PLUS_ASG"), "+=");
        map.put(JavacTreeMaker.TreeTag.treeTag("MINUS_ASG"), "-=");
        map.put(JavacTreeMaker.TreeTag.treeTag("MUL_ASG"), "*=");
        map.put(JavacTreeMaker.TreeTag.treeTag("DIV_ASG"), "/=");
        map.put(JavacTreeMaker.TreeTag.treeTag("MOD_ASG"), "%=");
        OPERATORS = map;
        getExtendsClause = getMethod((Class<?>) JCTree.JCClassDecl.class, "getExtendsClause", (Class<?>[]) new Class[0]);
        if (Javac.getJavaCompilerVersion() < 8) {
            getEndPosition = getMethod((Class<?>) JCDiagnostic.DiagnosticPosition.class, "getEndPosition", (Class<?>[]) new Class[]{Map.class});
            storeEnd = getMethod((Class<?>) Map.class, "put", (Class<?>[]) new Class[]{Object.class, Object.class});
        } else {
            getEndPosition = getMethod((Class<?>) JCDiagnostic.DiagnosticPosition.class, "getEndPosition", "com.sun.tools.javac.tree.EndPosTable");
            try {
                Class<?> endPosTable = Class.forName("com.sun.tools.javac.tree.EndPosTable");
                try {
                    storeEndMethodTemp = Permit.getMethod(endPosTable, "storeEnd", JCTree.class, Integer.TYPE);
                } catch (NoSuchMethodException unused) {
                    try {
                        Class<?> endPosTable2 = Class.forName("com.sun.tools.javac.parser.JavacParser$AbstractEndPosTable");
                        storeEndMethodTemp = Permit.getMethod(endPosTable2, "storeEnd", JCTree.class, Integer.TYPE);
                    } catch (ClassNotFoundException ex) {
                        throw sneakyThrow(ex);
                    } catch (NoSuchMethodException ex2) {
                        throw sneakyThrow(ex2);
                    }
                }
                storeEnd = storeEndMethodTemp;
            } catch (ClassNotFoundException ex3) {
                throw sneakyThrow(ex3);
            }
        }
        Permit.setAccessible(getEndPosition);
        Permit.setAccessible(storeEnd);
        reflectionCache = new HashMap();
    }

    public PrettyPrinter(Writer out, JCTree.JCCompilationUnit cu, List<CommentInfo> comments, int[] textBlockStarts, FormatPreferences preferences) {
        this.out = out;
        this.comments = comments;
        this.textBlockStarts = textBlockStarts;
        this.compilationUnit = cu;
        this.formatPreferences = preferences;
        Object dc = Javac.getDocComments(this.compilationUnit);
        if (dc instanceof Map) {
            this.docComments = (Map) dc;
            this.docTable = null;
        } else if (dc instanceof DocCommentTable) {
            this.docComments = null;
            this.docTable = (DocCommentTable) dc;
        } else {
            this.docComments = null;
            this.docTable = null;
        }
    }

    private int endPos(JCTree tree) {
        return Javac.getEndPosition(tree, this.compilationUnit);
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/delombok/PrettyPrinter$UncheckedIOException.SCL.lombok */
    public static final class UncheckedIOException extends RuntimeException {
        UncheckedIOException(IOException source) {
            super(toMsg(source));
            setStackTrace(source.getStackTrace());
        }

        private static String toMsg(Throwable t) {
            String msg = t.getMessage();
            String n = t.getClass().getSimpleName();
            return (msg == null || msg.isEmpty()) ? n : String.valueOf(n) + ": " + msg;
        }
    }

    private void align() {
        if (this.onNewLine) {
            for (int i = 0; i < this.indent; i++) {
                try {
                    this.out.write(this.formatPreferences.indent());
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            this.onNewLine = false;
            this.aligned = true;
            this.needsAlign = false;
        }
    }

    private void print(JCTree tree) {
        if (tree == null) {
            print("/*missing*/");
            return;
        }
        consumeComments(tree);
        tree.accept(this);
        consumeTrailingComments(endPos(tree));
    }

    private void print(List<? extends JCTree> trees, String infix) {
        boolean first = true;
        JCTree prev = null;
        for (JCTree tree : trees) {
            if (!suppress(tree)) {
                if (!first && infix != null && !infix.isEmpty()) {
                    if ("\n".equals(infix)) {
                        println(prev);
                    } else {
                        print(infix);
                    }
                }
                first = false;
                print(tree);
                prev = tree;
            }
        }
    }

    private boolean suppress(JCTree tree) {
        if (tree instanceof JCTree.JCBlock) {
            JCTree.JCBlock block = (JCTree.JCBlock) tree;
            return -1 == block.pos && block.stats.isEmpty();
        }
        if (tree instanceof JCTree.JCExpressionStatement) {
            JCTree.JCMethodInvocation jCMethodInvocation = ((JCTree.JCExpressionStatement) tree).expr;
            if (jCMethodInvocation instanceof JCTree.JCMethodInvocation) {
                JCTree.JCMethodInvocation inv = jCMethodInvocation;
                if (inv.typeargs.isEmpty() && inv.args.isEmpty() && (inv.meth instanceof JCTree.JCIdent) && tree.pos == ((JCTree.JCExpression) jCMethodInvocation).pos) {
                    return inv.meth.name.toString().equals("super");
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void print(CharSequence s2) {
        boolean align = this.needsAlign;
        if (this.needsNewLine && !this.onNewLine) {
            println();
        }
        if (align && !this.aligned) {
            align();
        }
        try {
            if (this.needsSpace && !this.onNewLine && !this.aligned) {
                this.out.write(32);
            }
            this.out.write(s2.toString());
            this.needsSpace = false;
            this.onNewLine = false;
            this.aligned = false;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void println() {
        try {
            this.out.write(LINE_SEP);
            this.onNewLine = true;
            this.aligned = false;
            this.needsNewLine = false;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void println(JCTree completed) {
        if (completed != null) {
            int endPos = endPos(completed);
            consumeTrailingComments(endPos);
        }
        try {
            this.out.write(LINE_SEP);
            this.onNewLine = true;
            this.aligned = false;
            this.needsNewLine = false;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void println(CharSequence s2) {
        print(s2);
        println();
    }

    private void println(CharSequence s2, JCTree completed) {
        print(s2);
        println(completed);
    }

    private void aPrint(CharSequence s2) {
        align();
        print(s2);
    }

    private void aPrintln(CharSequence s2) {
        align();
        print(s2);
        println();
    }

    private void aPrintln(CharSequence s2, JCTree completed) {
        align();
        print(s2);
        println(completed);
    }

    private void consumeComments(int until) {
        Object obj = this.comments.head;
        while (true) {
            CommentInfo head = (CommentInfo) obj;
            if (this.comments.nonEmpty() && head.pos < until) {
                printComment(head);
                this.comments = this.comments.tail;
                obj = this.comments.head;
            } else {
                return;
            }
        }
    }

    private void consumeComments(JCTree tree) {
        consumeComments(tree.pos);
    }

    private void consumeTrailingComments(int from) {
        boolean prevNewLine = this.onNewLine;
        CommentInfo head = (CommentInfo) this.comments.head;
        boolean stop = false;
        while (this.comments.nonEmpty() && head.prevEndPos == from && !stop && head.start != CommentInfo.StartConnection.ON_NEXT_LINE && head.start != CommentInfo.StartConnection.START_OF_LINE) {
            from = head.endPos;
            printComment(head);
            stop = head.end == CommentInfo.EndConnection.ON_NEXT_LINE;
            this.comments = this.comments.tail;
            head = (CommentInfo) this.comments.head;
        }
        if (!this.onNewLine && prevNewLine) {
            println();
        }
    }

    private String getJavadocFor(JCTree node) {
        if (this.docComments != null) {
            return this.docComments.get(node);
        }
        if (this.docTable != null) {
            return this.docTable.getCommentText(node);
        }
        return null;
    }

    private int dims(JCTree.JCExpression vartype) {
        if (vartype instanceof JCTree.JCArrayTypeTree) {
            return 1 + dims(((JCTree.JCArrayTypeTree) vartype).elemtype);
        }
        if (isJcAnnotatedType(vartype)) {
            JCTree.JCArrayTypeTree jCArrayTypeTree = (JCTree) readObject(vartype, "underlyingType", null);
            if (jCArrayTypeTree instanceof JCTree.JCArrayTypeTree) {
                return 1 + dims(jCArrayTypeTree.elemtype);
            }
            return 0;
        }
        return 0;
    }

    private void printComment(CommentInfo comment) {
        switch ($SWITCH_TABLE$lombok$javac$CommentInfo$StartConnection()[comment.start.ordinal()]) {
            case 1:
                this.needsNewLine = true;
                this.needsAlign = false;
                break;
            case 2:
                if (!this.onNewLine) {
                    this.needsNewLine = true;
                    this.needsAlign = true;
                } else if (!this.aligned) {
                    this.needsAlign = true;
                }
                break;
            case 3:
                this.needsSpace = false;
                break;
            case 4:
                this.needsSpace = true;
                break;
        }
        if (this.onNewLine && !this.aligned && comment.start != CommentInfo.StartConnection.START_OF_LINE) {
            this.needsAlign = true;
        }
        print(comment.content);
        switch ($SWITCH_TABLE$lombok$javac$CommentInfo$EndConnection()[comment.end.ordinal()]) {
            case 2:
                this.needsSpace = true;
                break;
            case 3:
                if (!this.aligned) {
                    this.needsNewLine = true;
                    this.needsAlign = true;
                }
                break;
        }
    }

    private void printDocComment(JCTree tree) {
        String dc = getJavadocFor(tree);
        if (dc == null) {
            return;
        }
        aPrintln("/**");
        boolean atStart = true;
        for (String line : dc.split("\\r?\\n")) {
            if (atStart && line.trim().isEmpty()) {
                atStart = false;
            } else {
                atStart = false;
                aPrint(" *");
                if (!line.isEmpty() && !Character.isWhitespace(line.charAt(0))) {
                    print(" ");
                }
                println(line);
            }
        }
        aPrintln(" */");
    }

    private Name name_init(Name someName) {
        if (this.__INIT__ == null) {
            this.__INIT__ = someName.table.fromChars("<init>".toCharArray(), 0, 6);
        }
        return this.__INIT__;
    }

    private Name name_value(Name someName) {
        if (this.__VALUE__ == null) {
            this.__VALUE__ = someName.table.fromChars("value".toCharArray(), 0, 5);
        }
        return this.__VALUE__;
    }

    public void visitTopLevel(JCTree.JCCompilationUnit tree) {
        printDocComment(tree);
        JCTree n = PackageName.getPackageNode(tree);
        if (n != null) {
            consumeComments((JCTree) tree);
            aPrint("package ");
            print(n);
            println(";", n);
        }
        boolean first = true;
        for (JCTree child : tree.defs) {
            if (child instanceof JCTree.JCImport) {
                if (first) {
                    println();
                }
                first = false;
                print(child);
            }
        }
        for (JCTree child2 : tree.defs) {
            if (!(child2 instanceof JCTree.JCImport)) {
                print(child2);
            }
        }
        consumeComments(Integer.MAX_VALUE);
    }

    public void visitImport(JCTree.JCImport tree) {
        if (tree.qualid instanceof JCTree.JCFieldAccess) {
            JCTree.JCFieldAccess fa = tree.qualid;
            if (fa.name.length() == 1 && fa.name.contentEquals("*") && (fa.selected instanceof JCTree.JCFieldAccess)) {
                JCTree.JCFieldAccess lombokExperimental = fa.selected;
                if (lombokExperimental.name.contentEquals("experimental") && (lombokExperimental.selected instanceof JCTree.JCIdent) && lombokExperimental.selected.name.contentEquals("lombok")) {
                    return;
                }
            }
        }
        aPrint("import ");
        if (tree.staticImport) {
            print("static ");
        }
        print(tree.qualid);
        println(";", tree);
    }

    public void visitClassDef(JCTree.JCClassDecl tree) {
        println();
        printDocComment(tree);
        align();
        print((JCTree) tree.mods);
        boolean isInterface = (tree.mods.flags & 512) != 0;
        boolean isAnnotationInterface = isInterface && (tree.mods.flags & Permission.MANAGE_MESSAGES) != 0;
        boolean isEnum = (tree.mods.flags & Permission.EMBED_LINKS) != 0;
        if (isAnnotationInterface) {
            print("@interface ");
        } else if (isInterface) {
            print("interface ");
        } else if (isEnum) {
            print("enum ");
        } else {
            print("class ");
        }
        print((CharSequence) tree.name);
        Name prevTypeName = this.currentTypeName;
        this.currentTypeName = tree.name;
        if (tree.typarams.nonEmpty()) {
            print("<");
            print(tree.typarams, ", ");
            print(">");
        }
        JCTree extendsClause = getExtendsClause(tree);
        if (extendsClause != null) {
            print(" extends ");
            print(extendsClause);
        }
        if (tree.implementing.nonEmpty()) {
            print(isInterface ? " extends " : " implements ");
            print(tree.implementing, ", ");
        }
        println(" {");
        this.indent++;
        printClassMembers(tree.defs, isEnum, isInterface);
        consumeComments(endPos(tree));
        this.indent--;
        aPrintln("}", tree);
        this.currentTypeName = prevTypeName;
    }

    private void printClassMembers(List<JCTree> members, boolean isEnum, boolean isInterface) {
        Class<?> prefType = null;
        int typeOfPrevEnumMember = isEnum ? 3 : 0;
        boolean prevWasEnumMember = isEnum;
        Iterator it = members.iterator();
        while (it.hasNext()) {
            JCTree.JCMethodDecl jCMethodDecl = (JCTree) it.next();
            if (typeOfPrevEnumMember != 3 || !(jCMethodDecl instanceof JCTree.JCMethodDecl) || (jCMethodDecl.mods.flags & Permission.CREATE_PRIVATE_THREADS) == 0) {
                boolean isEnumVar = isEnum && (jCMethodDecl instanceof JCTree.JCVariableDecl) && (((JCTree.JCVariableDecl) jCMethodDecl).mods.flags & Permission.EMBED_LINKS) != 0;
                if (!isEnumVar && prevWasEnumMember) {
                    prevWasEnumMember = false;
                    if (typeOfPrevEnumMember == 3) {
                        align();
                    }
                    println(";");
                }
                if (isEnumVar) {
                    if (prefType != null && prefType != JCTree.JCVariableDecl.class) {
                        println();
                    }
                    switch (typeOfPrevEnumMember) {
                        case 1:
                            print(", ");
                            break;
                        case 2:
                            println(",");
                            align();
                            break;
                    }
                    print((JCTree) jCMethodDecl);
                    JCTree.JCNewClass jCNewClass = ((JCTree.JCVariableDecl) jCMethodDecl).init;
                    typeOfPrevEnumMember = (!(jCNewClass instanceof JCTree.JCNewClass) || jCNewClass.def == null) ? 1 : 2;
                } else if (jCMethodDecl instanceof JCTree.JCVariableDecl) {
                    if (prefType != null && prefType != JCTree.JCVariableDecl.class) {
                        println();
                    }
                    if (isInterface) {
                        this.flagMod = -26L;
                    }
                    print((JCTree) jCMethodDecl);
                } else if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    if ((jCMethodDecl.mods.flags & Permission.CREATE_PRIVATE_THREADS) == 0) {
                        if (prefType != null) {
                            println();
                        }
                        if (isInterface) {
                            this.flagMod = -1026L;
                        }
                        print((JCTree) jCMethodDecl);
                    }
                } else if (jCMethodDecl instanceof JCTree.JCClassDecl) {
                    if (prefType != null) {
                        println();
                    }
                    if (isInterface) {
                        this.flagMod = -10L;
                    }
                    print((JCTree) jCMethodDecl);
                } else {
                    if (prefType != null) {
                        println();
                    }
                    print((JCTree) jCMethodDecl);
                }
                prefType = jCMethodDecl.getClass();
            }
        }
        if (prevWasEnumMember) {
            if (typeOfPrevEnumMember == 3) {
                align();
            }
            println(";");
        }
    }

    public void visitTypeParameter(JCTree.JCTypeParameter tree) {
        List<? extends JCTree> list = (List) readObject(tree, "annotations", List.nil());
        if (!list.isEmpty()) {
            print(list, " ");
            print(" ");
        }
        print((CharSequence) tree.name);
        if (tree.bounds.nonEmpty()) {
            print(" extends ");
            print(tree.bounds, " & ");
        }
        consumeComments((JCTree) tree);
    }

    public void visitVarDef(JCTree.JCVariableDecl tree) {
        printDocComment(tree);
        align();
        if ((tree.mods.flags & Permission.EMBED_LINKS) != 0) {
            printEnumMember(tree);
            return;
        }
        printAnnotations(tree.mods.annotations, true);
        printModifierKeywords(tree.mods);
        printVarDef0(tree);
        println(";", tree);
    }

    private void printVarDefInline(JCTree.JCVariableDecl tree) {
        printAnnotations(tree.mods.annotations, false);
        printModifierKeywords(tree.mods);
        printVarDef0(tree);
    }

    private void printVarDef0(JCTree.JCVariableDecl tree) {
        boolean varargs = (tree.mods.flags & Permission.MANAGE_THREADS) != 0;
        try {
            this.innermostArrayBracketsAreVarargs = varargs;
            if (tree.vartype == null || tree.vartype.pos == -1) {
                print("var");
            } else {
                print((JCTree) tree.vartype);
            }
            this.innermostArrayBracketsAreVarargs = false;
            print(" ");
            print((CharSequence) tree.name);
            if (tree.init != null) {
                print(" = ");
                print((JCTree) tree.init);
            }
        } catch (Throwable th) {
            this.innermostArrayBracketsAreVarargs = false;
            throw th;
        }
    }

    private void printEnumMember(JCTree.JCVariableDecl tree) {
        printAnnotations(tree.mods.annotations, true);
        print((CharSequence) tree.name);
        if (tree.init instanceof JCTree.JCNewClass) {
            JCTree.JCNewClass constructor = tree.init;
            if (constructor.args != null && constructor.args.nonEmpty()) {
                print("(");
                print(constructor.args, ", ");
                print(")");
            }
            if (constructor.def != null && constructor.def.defs != null) {
                println(" {");
                this.indent++;
                printClassMembers(constructor.def.defs, false, false);
                consumeComments(endPos(tree));
                this.indent--;
                aPrint("}");
            }
        }
    }

    public void visitTypeApply(JCTree.JCTypeApply tree) {
        print((JCTree) tree.clazz);
        print("<");
        boolean temp = this.innermostArrayBracketsAreVarargs;
        this.innermostArrayBracketsAreVarargs = false;
        print(tree.arguments, ", ");
        this.innermostArrayBracketsAreVarargs = temp;
        print(">");
    }

    public void visitWildcard(JCTree.JCWildcard tree) {
        switch ($SWITCH_TABLE$com$sun$source$tree$Tree$Kind()[tree.getKind().ordinal()]) {
            case 88:
            default:
                print("?");
                break;
            case 89:
                print("? extends ");
                print(tree.inner);
                break;
            case 90:
                print("? super ");
                print(tree.inner);
                break;
        }
    }

    public void visitLiteral(JCTree.JCLiteral tree) {
        JavacTreeMaker.TypeTag typeTag = JavacTreeMaker.TypeTag.typeTag((JCTree) tree);
        if (!Javac.CTC_INT.equals(typeTag)) {
            if (!Javac.CTC_LONG.equals(typeTag)) {
                if (!Javac.CTC_FLOAT.equals(typeTag)) {
                    if (!Javac.CTC_DOUBLE.equals(typeTag)) {
                        if (Javac.CTC_CHAR.equals(typeTag)) {
                            print("'" + quoteChar((char) ((Number) tree.value).intValue()) + "'");
                            return;
                        }
                        if (!Javac.CTC_BOOLEAN.equals(typeTag)) {
                            if (!Javac.CTC_BOT.equals(typeTag)) {
                                if (Arrays.binarySearch(this.textBlockStarts, tree.pos) < 0) {
                                    print("\"" + quoteChars(tree.value.toString()) + "\"");
                                    return;
                                } else {
                                    printTextBlock(tree.value.toString());
                                    return;
                                }
                            }
                            print("null");
                            return;
                        }
                        print(((Number) tree.value).intValue() == 1 ? "true" : "false");
                        return;
                    }
                    print(new StringBuilder().append(tree.value).toString());
                    return;
                }
                print(tree.value + "F");
                return;
            }
            print(tree.value + "L");
            return;
        }
        print(new StringBuilder().append(tree.value).toString());
    }

    private void printTextBlock(String s2) {
        println("\"\"\"");
        this.needsAlign = true;
        this.indent++;
        StringBuilder sb = new StringBuilder();
        boolean lineStart = true;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (c != ' ' && c != '\t') {
                lineStart = false;
            }
            if (c == '\n') {
                println(sb);
                sb.setLength(0);
                this.needsAlign = true;
                lineStart = true;
            } else if (c == '\t' && lineStart) {
                sb.append("\t");
            } else {
                sb.append(quoteChar(s2.charAt(i)));
            }
        }
        print(sb);
        print("\"\"\"");
        this.indent--;
    }

    public void visitMethodDef(JCTree.JCMethodDecl tree) {
        boolean isConstructor = tree.name == name_init(tree.name);
        if (!isConstructor || (tree.mods.flags & Permission.CREATE_PRIVATE_THREADS) == 0) {
            printDocComment(tree);
            align();
            print((JCTree) tree.mods);
            if (tree.typarams != null && tree.typarams.nonEmpty()) {
                print("<");
                print(tree.typarams, ", ");
                print("> ");
            }
            if (isConstructor) {
                print(this.currentTypeName == null ? "<init>" : this.currentTypeName);
            } else {
                print((JCTree) tree.restype);
                print(" ");
                print((CharSequence) tree.name);
            }
            boolean first = true;
            print("(");
            JCTree.JCVariableDecl recvparam = (JCTree.JCVariableDecl) readObject(tree, "recvparam", null);
            if (recvparam != null) {
                printVarDefInline(recvparam);
                first = false;
            }
            for (JCTree.JCVariableDecl param : tree.params) {
                if (!first) {
                    print(", ");
                }
                first = false;
                printVarDefInline(param);
            }
            print(")");
            if (tree.thrown.nonEmpty()) {
                print(" throws ");
                print(tree.thrown, ", ");
            }
            if (tree.defaultValue != null) {
                print(" default ");
                print((JCTree) tree.defaultValue);
            }
            if (tree.body != null) {
                print(" ");
                print((JCTree) tree.body);
            } else {
                println(";", tree);
            }
        }
    }

    public void visitSkip(JCTree.JCSkip that) {
        if (this.onNewLine && !this.aligned) {
            align();
        }
        println(";");
    }

    public void visitAnnotation(JCTree.JCAnnotation tree) {
        print("@");
        print(tree.annotationType);
        if (tree.args.isEmpty()) {
            return;
        }
        print("(");
        boolean done = false;
        if (tree.args.length() == 1 && (tree.args.get(0) instanceof JCTree.JCAssign)) {
            JCTree.JCAssign arg1 = (JCTree.JCAssign) tree.args.get(0);
            JCTree.JCIdent arg1Name = arg1.lhs instanceof JCTree.JCIdent ? (JCTree.JCIdent) arg1.lhs : null;
            if (arg1Name != null && arg1Name.name == name_value(arg1Name.name)) {
                print((JCTree) arg1.rhs);
                done = true;
            }
        }
        if (!done) {
            print(tree.args, ", ");
        }
        print(")");
    }

    public void visitTypeArray(JCTree.JCArrayTypeTree tree) {
        printTypeArray0(tree);
    }

    public void visitNewArray(JCTree.JCNewArray tree) {
        JCTree.JCExpression jCExpression = tree.elemtype;
        int dims = 0;
        if (jCExpression != null) {
            print("new ");
            while (jCExpression instanceof JCTree.JCArrayTypeTree) {
                dims++;
                jCExpression = ((JCTree.JCArrayTypeTree) jCExpression).elemtype;
            }
            print((JCTree) jCExpression);
            for (JCTree.JCExpression expr : tree.dims) {
                print("[");
                print((JCTree) expr);
                print("]");
            }
        }
        for (int i = 0; i < dims; i++) {
            print("[]");
        }
        if (tree.elems != null) {
            if (jCExpression != null) {
                print("[] ");
            }
            print("{");
            print(tree.elems, ", ");
            print("}");
        }
    }

    public void visitNewClass(JCTree.JCNewClass tree) {
        if (tree.encl != null) {
            print((JCTree) tree.encl);
            print(".");
        }
        boolean moveFirstParameter = tree.args.nonEmpty() && (tree.args.head instanceof JCTree.JCUnary) && ((JCTree.JCExpression) tree.args.head).toString().startsWith("<*nullchk*>");
        if (moveFirstParameter) {
            print((JCTree) ((JCTree.JCUnary) tree.args.head).arg);
            print(".");
        }
        print("new ");
        if (!tree.typeargs.isEmpty()) {
            print("<");
            print(tree.typeargs, ", ");
            print(">");
        }
        print((JCTree) tree.clazz);
        print("(");
        if (moveFirstParameter) {
            print(tree.args.tail, ", ");
        } else {
            print(tree.args, ", ");
        }
        print(")");
        if (tree.def != null) {
            Name previousTypeName = this.currentTypeName;
            this.currentTypeName = null;
            println(" {");
            this.indent++;
            print(tree.def.defs, "");
            this.indent--;
            aPrint("}");
            this.currentTypeName = previousTypeName;
        }
    }

    public void visitIndexed(JCTree.JCArrayAccess tree) {
        print((JCTree) tree.indexed);
        print("[");
        print((JCTree) tree.index);
        print("]");
    }

    public void visitTypeIdent(JCTree.JCPrimitiveTypeTree tree) {
        JavacTreeMaker.TypeTag typeTag = JavacTreeMaker.TypeTag.typeTag((JCTree) tree);
        if (!Javac.CTC_BYTE.equals(typeTag)) {
            if (!Javac.CTC_CHAR.equals(typeTag)) {
                if (!Javac.CTC_SHORT.equals(typeTag)) {
                    if (!Javac.CTC_INT.equals(typeTag)) {
                        if (!Javac.CTC_LONG.equals(typeTag)) {
                            if (!Javac.CTC_FLOAT.equals(typeTag)) {
                                if (!Javac.CTC_DOUBLE.equals(typeTag)) {
                                    if (!Javac.CTC_BOOLEAN.equals(typeTag)) {
                                        if (!Javac.CTC_VOID.equals(typeTag)) {
                                            print("error");
                                            return;
                                        } else {
                                            print("void");
                                            return;
                                        }
                                    }
                                    print("boolean");
                                    return;
                                }
                                print("double");
                                return;
                            }
                            print("float");
                            return;
                        }
                        print(Constants.LONG);
                        return;
                    }
                    print("int");
                    return;
                }
                print("short");
                return;
            }
            print("char");
            return;
        }
        print("byte");
    }

    public void visitLabelled(JCTree.JCLabeledStatement tree) {
        aPrint(tree.label);
        print(":");
        if ((tree.body instanceof JCTree.JCSkip) || suppress(tree)) {
            println(" ;", tree);
        } else if (tree.body instanceof JCTree.JCBlock) {
            print(" ");
            print((JCTree) tree.body);
        } else {
            println((JCTree) tree);
            print((JCTree) tree.body);
        }
    }

    public void visitModifiers(JCTree.JCModifiers tree) {
        printAnnotations(tree.annotations, true);
        printModifierKeywords(tree);
    }

    private void printAnnotations(List<JCTree.JCAnnotation> annotations, boolean newlines) {
        for (JCTree.JCAnnotation ann : annotations) {
            print((JCTree) ann);
            if (newlines) {
                println();
                align();
            } else {
                print(" ");
            }
        }
    }

    private void printModifierKeywords(JCTree.JCModifiers tree) {
        long v = this.flagMod & tree.flags;
        this.flagMod = -1L;
        if ((v & Permission.SEND_TTS_MESSAGES) != 0) {
            print("/* synthetic */ ");
        }
        if ((v & 1) != 0) {
            print("public ");
        }
        if ((v & 2) != 0) {
            print("private ");
        }
        if ((v & 4) != 0) {
            print("protected ");
        }
        if ((v & 8) != 0) {
            print("static ");
        }
        if ((v & 16) != 0) {
            print("final ");
        }
        if ((v & 32) != 0) {
            print("synchronized ");
        }
        if ((v & 64) != 0) {
            print("volatile ");
        }
        if ((v & 128) != 0) {
            print("transient ");
        }
        if ((v & 256) != 0) {
            print("native ");
        }
        if ((v & Permission.VIEW_CHANNEL) != 0) {
            print("abstract ");
        }
        if ((v & Permission.SEND_MESSAGES) != 0) {
            print("strictfp ");
        }
        if ((v & DEFAULT) == 0 || (v & 512) != 0) {
            return;
        }
        print("default ");
    }

    public void visitSelect(JCTree.JCFieldAccess tree) {
        print((JCTree) tree.selected);
        print(".");
        print((CharSequence) tree.name);
    }

    public void visitIdent(JCTree.JCIdent tree) {
        print((CharSequence) tree.name);
    }

    public void visitApply(JCTree.JCMethodInvocation tree) {
        if (tree.typeargs.nonEmpty()) {
            if (tree.meth instanceof JCTree.JCFieldAccess) {
                JCTree.JCFieldAccess fa = tree.meth;
                print((JCTree) fa.selected);
                print(".<");
                print(tree.typeargs, ", ");
                print(">");
                print((CharSequence) fa.name);
            } else {
                print("<");
                print(tree.typeargs, ", ");
                print(">");
                print((JCTree) tree.meth);
            }
        } else {
            print((JCTree) tree.meth);
        }
        print("(");
        print(tree.args, ", ");
        print(")");
    }

    public void visitAssert(JCTree.JCAssert tree) {
        aPrint("assert ");
        print((JCTree) tree.cond);
        if (tree.detail != null) {
            print(" : ");
            print((JCTree) tree.detail);
        }
        println(";", tree);
    }

    public void visitAssign(JCTree.JCAssign tree) {
        print((JCTree) tree.lhs);
        print(" = ");
        print((JCTree) tree.rhs);
    }

    public void visitAssignop(JCTree.JCAssignOp tree) {
        print((JCTree) tree.lhs);
        String opname = operator(JavacTreeMaker.TreeTag.treeTag((JCTree) tree));
        print(" " + opname + " ");
        print((JCTree) tree.rhs);
    }

    public void visitUnary(JCTree.JCUnary tree) {
        String op = operator(JavacTreeMaker.TreeTag.treeTag((JCTree) tree));
        if (JavacTreeMaker.TreeTag.treeTag((JCTree) tree).getOperatorPrecedenceLevel() == 14) {
            print(op);
            print((JCTree) tree.arg);
        } else {
            print((JCTree) tree.arg);
            print(op);
        }
    }

    public void visitBinary(JCTree.JCBinary tree) {
        String op = operator(JavacTreeMaker.TreeTag.treeTag((JCTree) tree));
        print((JCTree) tree.lhs);
        print(" ");
        print(op);
        print(" ");
        print((JCTree) tree.rhs);
    }

    public void visitTypeTest(JCTree.JCInstanceOf tree) {
        print((JCTree) tree.expr);
        print(" instanceof ");
        JCTree c = (JCTree) readObject(tree, "clazz", null);
        if (c == null) {
            c = (JCTree) readObject(tree, "pattern", null);
        }
        print(c);
    }

    public void visitTypeCast(JCTree.JCTypeCast tree) {
        print("(");
        print(tree.clazz);
        print(") ");
        print((JCTree) tree.expr);
    }

    public void visitBlock(JCTree.JCBlock tree) {
        if (tree.pos == -1 && tree.stats.isEmpty()) {
            return;
        }
        if (this.onNewLine) {
            align();
        }
        if ((tree.flags & 8) != 0) {
            print("static ");
        }
        println("{");
        this.indent++;
        print(tree.stats, "");
        consumeComments(endPos(tree));
        this.indent--;
        aPrintln("}", tree);
    }

    public void visitBreak(JCTree.JCBreak tree) {
        aPrint("break");
        JCTree.JCExpression value = (JCTree.JCExpression) readObject(tree, "value", null);
        if (value != null) {
            print(" ");
            print((JCTree) value);
        } else {
            Name label = (Name) readObject(tree, "label", null);
            if (label != null) {
                print(" ");
                print((CharSequence) label);
            }
        }
        println(";", tree);
    }

    public void visitContinue(JCTree.JCContinue tree) {
        aPrint("continue");
        if (tree.label != null) {
            print(" ");
            print((CharSequence) tree.label);
        }
        println(";", tree);
    }

    public void visitConditional(JCTree.JCConditional tree) {
        print((JCTree) tree.cond);
        print(" ? ");
        print((JCTree) tree.truepart);
        print(" : ");
        print((JCTree) tree.falsepart);
    }

    public void visitParens(JCTree.JCParens tree) {
        print("(");
        print((JCTree) tree.expr);
        print(")");
    }

    public void visitReturn(JCTree.JCReturn tree) {
        aPrint("return");
        if (tree.expr != null) {
            print(" ");
            print((JCTree) tree.expr);
        }
        println(";", tree);
    }

    public void visitThrow(JCTree.JCThrow tree) {
        aPrint("throw ");
        print((JCTree) tree.expr);
        println(";", tree);
    }

    public void visitWhileLoop(JCTree.JCWhileLoop tree) {
        aPrint("while ");
        if (tree.cond instanceof JCTree.JCParens) {
            print((JCTree) tree.cond);
        } else {
            print("(");
            print((JCTree) tree.cond);
            print(")");
        }
        print(" ");
        print((JCTree) tree.body);
    }

    public void visitForLoop(JCTree.JCForLoop tree) {
        aPrint("for (");
        if (tree.init.nonEmpty()) {
            if (tree.init.head instanceof JCTree.JCVariableDecl) {
                boolean first = true;
                int dims = 0;
                for (JCTree.JCStatement i : tree.init) {
                    JCTree.JCVariableDecl vd = (JCTree.JCVariableDecl) i;
                    if (first) {
                        printVarDefInline(vd);
                        dims = dims(vd.vartype);
                    } else {
                        print(", ");
                        print((CharSequence) vd.name);
                        int dimDiff = dims(vd.vartype) - dims;
                        for (int j = 0; j < dimDiff; j++) {
                            print("[]");
                        }
                        if (vd.init != null) {
                            print(" = ");
                            print((JCTree) vd.init);
                        }
                    }
                    first = false;
                }
            } else {
                boolean first2 = true;
                for (JCTree.JCExpressionStatement jCExpressionStatement : tree.init) {
                    if (!first2) {
                        print(", ");
                    }
                    first2 = false;
                    print((JCTree) jCExpressionStatement.expr);
                }
            }
        }
        print("; ");
        if (tree.cond != null) {
            print((JCTree) tree.cond);
        }
        print("; ");
        boolean first3 = true;
        for (JCTree.JCExpressionStatement exprStatement : tree.step) {
            if (!first3) {
                print(", ");
            }
            first3 = false;
            print((JCTree) exprStatement.expr);
        }
        print(") ");
        print((JCTree) tree.body);
    }

    public void visitForeachLoop(JCTree.JCEnhancedForLoop tree) {
        aPrint("for (");
        printVarDefInline(tree.var);
        print(" : ");
        print((JCTree) tree.expr);
        print(") ");
        print((JCTree) tree.body);
    }

    public void visitIf(JCTree.JCIf tree) {
        aPrint("if ");
        if (tree.cond instanceof JCTree.JCParens) {
            print((JCTree) tree.cond);
        } else {
            print("(");
            print((JCTree) tree.cond);
            print(")");
        }
        print(" ");
        if (tree.thenpart instanceof JCTree.JCBlock) {
            println("{");
            this.indent++;
            print(tree.thenpart.stats, "");
            this.indent--;
            if (tree.elsepart == null) {
                aPrintln("}", tree);
            } else {
                aPrint("}");
            }
        } else {
            print((JCTree) tree.thenpart);
        }
        if (tree.elsepart != null) {
            aPrint(" else ");
            print((JCTree) tree.elsepart);
        }
    }

    public void visitExec(JCTree.JCExpressionStatement tree) {
        align();
        print((JCTree) tree.expr);
        println(";", tree);
    }

    public void visitDoLoop(JCTree.JCDoWhileLoop tree) {
        aPrint("do ");
        if (tree.body instanceof JCTree.JCBlock) {
            println("{");
            this.indent++;
            print(tree.body.stats, "");
            this.indent--;
            aPrint("}");
        } else {
            print((JCTree) tree.body);
        }
        print(" while ");
        if (tree.cond instanceof JCTree.JCParens) {
            print((JCTree) tree.cond);
        } else {
            print("(");
            print((JCTree) tree.cond);
            print(")");
        }
        println(";", tree);
    }

    public void visitSynchronized(JCTree.JCSynchronized tree) {
        aPrint("synchronized ");
        if (tree.lock instanceof JCTree.JCParens) {
            print((JCTree) tree.lock);
        } else {
            print("(");
            print((JCTree) tree.lock);
            print(")");
        }
        print(" ");
        print((JCTree) tree.body);
    }

    public void visitCase(JCTree.JCCase tree) {
        List<? extends JCTree> listNil = (List) readObject(tree, "pats", null);
        if (listNil == null) {
            JCTree.JCExpression pat = (JCTree.JCExpression) readObject(tree, "pat", null);
            listNil = pat == null ? List.nil() : List.of(pat);
        }
        if (listNil.isEmpty()) {
            aPrint("default");
        } else {
            aPrint("case ");
            print(listNil, ", ");
        }
        Enum<?> caseKind = (Enum) readObject(tree, "caseKind", null);
        if (caseKind != null && caseKind.name().equalsIgnoreCase("RULE")) {
            print(" -> ");
            if (tree.stats.head instanceof JCTree.JCBreak) {
                JCTree.JCBreak b2 = (JCTree.JCBreak) tree.stats.head;
                print((JCTree) readObject(b2, "value", null));
                print(";");
                this.needsNewLine = true;
                this.needsAlign = true;
                return;
            }
            if (((JCTree.JCStatement) tree.stats.head).getClass().getName().endsWith("$JCYield")) {
                print((JCTree) readObject((JCTree) tree.stats.head, "value", null));
                print(";");
                this.needsNewLine = true;
                this.needsAlign = true;
                return;
            }
            print((JCTree) tree.stats.head);
            if (tree.stats.head instanceof JCTree.JCBlock) {
                this.needsNewLine = false;
                return;
            }
            return;
        }
        println(": ");
        this.indent++;
        print(tree.stats, "");
        this.indent--;
    }

    public void visitCatch(JCTree.JCCatch tree) {
        print(" catch (");
        print((JCTree) tree.param);
        print(") ");
        print((JCTree) tree.body);
    }

    public void visitSwitch(JCTree.JCSwitch tree) {
        aPrint("switch ");
        if (tree.selector instanceof JCTree.JCParens) {
            print((JCTree) tree.selector);
        } else {
            print("(");
            print((JCTree) tree.selector);
            print(")");
        }
        println(" {");
        boolean ruleStyle = isCaseRuleStyle((JCTree.JCCase) tree.cases.head);
        if (ruleStyle) {
            this.indent++;
        }
        print(tree.cases, "");
        if (ruleStyle) {
            this.indent--;
        }
        aPrintln("}", tree);
    }

    void printSwitchExpression(JCTree tree) {
        aPrint("switch ");
        JCTree.JCExpression selector = (JCTree.JCExpression) readObject(tree, "selector", null);
        if (selector instanceof JCTree.JCParens) {
            print((JCTree) selector);
        } else {
            print("(");
            print((JCTree) selector);
            print(")");
        }
        println(" {");
        List<? extends JCTree> list = (List) readObject(tree, "cases", null);
        boolean ruleStyle = isCaseRuleStyle((JCTree.JCCase) list.head);
        if (ruleStyle) {
            this.indent++;
        }
        print(list, "");
        if (ruleStyle) {
            this.indent--;
        }
        aPrint("}");
    }

    void printYieldExpression(JCTree tree) {
        aPrint("yield ");
        JCTree.JCExpression value = (JCTree.JCExpression) readObject(tree, "value", null);
        print((JCTree) value);
        println(";", tree);
    }

    void printBindingPattern(JCTree tree) {
        print((JCTree) readObject(tree, "vartype", null));
        print(" ");
        print((CharSequence) readObject(tree, ModelAuditLogEntry.CHANGE_KEY_NAME, null));
    }

    public void visitTry(JCTree.JCTry tree) {
        aPrint("try ");
        List<?> resources = (List) readObject(tree, "resources", List.nil());
        int len = resources.length();
        switch (len) {
            case 0:
                break;
            case 1:
                print("(");
                JCTree resource = (JCTree) resources.get(0);
                if (resource instanceof JCTree.JCVariableDecl) {
                    JCTree.JCVariableDecl decl = (JCTree.JCVariableDecl) resource;
                    this.flagMod = -17L;
                    printVarDefInline(decl);
                } else {
                    print(resource);
                }
                print(") ");
                break;
            default:
                println("(");
                this.indent++;
                int c = 0;
                for (Object i : resources) {
                    align();
                    if (i instanceof JCTree.JCVariableDecl) {
                        this.flagMod = -17L;
                        printVarDefInline((JCTree.JCVariableDecl) i);
                    } else {
                        print((JCTree) i);
                    }
                    c++;
                    if (c == len) {
                        print(") ");
                    } else {
                        println(";", (JCTree) i);
                    }
                }
                this.indent--;
                break;
        }
        println("{");
        this.indent++;
        for (JCTree.JCStatement stat : tree.body.stats) {
            print((JCTree) stat);
        }
        this.indent--;
        aPrint("}");
        for (JCTree.JCCatch catchBlock : tree.catchers) {
            printCatch(catchBlock);
        }
        if (tree.finalizer != null) {
            println(" finally {");
            this.indent++;
            for (JCTree.JCStatement stat2 : tree.finalizer.stats) {
                print((JCTree) stat2);
            }
            this.indent--;
            aPrint("}");
        }
        println((JCTree) tree);
    }

    private void printCatch(JCTree.JCCatch catchBlock) {
        print(" catch (");
        printVarDefInline(catchBlock.param);
        println(") {");
        this.indent++;
        for (JCTree.JCStatement stat : catchBlock.body.stats) {
            print((JCTree) stat);
        }
        this.indent--;
        aPrint("}");
    }

    public void visitErroneous(JCTree.JCErroneous tree) {
        print("(ERROR)");
    }

    private static String operator(JavacTreeMaker.TreeTag tag) {
        String op = OPERATORS.get(tag);
        return op == null ? "(?op?)" : op;
    }

    private static String quoteChars(String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            sb.append(quoteChar(s2.charAt(i)));
        }
        return sb.toString();
    }

    private static String quoteChar(char ch) {
        switch (ch) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            case '\f':
                return "\\f";
            case '\r':
                return "\\r";
            case '\"':
                return "\\\"";
            case '\'':
                return "\\'";
            case '\\':
                return "\\\\";
            default:
                return ch < ' ' ? String.format("\\%03o", Integer.valueOf(ch)) : String.valueOf(ch);
        }
    }

    private static Method getMethod(Class<?> clazz, String name, Class<?>... clsArr) {
        try {
            return Permit.getMethod(clazz, name, clsArr);
        } catch (NoSuchMethodException e) {
            throw sneakyThrow(e);
        }
    }

    private static Method getMethod(Class<?> clazz, String name, String... paramTypes) {
        try {
            Class[] c = new Class[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                c[i] = Class.forName(paramTypes[i]);
            }
            return Permit.getMethod(clazz, name, c);
        } catch (ClassNotFoundException e) {
            throw sneakyThrow(e);
        } catch (NoSuchMethodException e2) {
            throw sneakyThrow(e2);
        }
    }

    public static JCTree getExtendsClause(JCTree.JCClassDecl decl) {
        try {
            return (JCTree) getExtendsClause.invoke(decl, new Object[0]);
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw sneakyThrow(e2.getCause());
        }
    }

    static RuntimeException sneakyThrow(Throwable t) throws Throwable {
        if (t == null) {
            throw new NullPointerException("t");
        }
        sneakyThrow0(t);
        return null;
    }

    private static <T extends Throwable> void sneakyThrow0(Throwable t) throws Throwable {
        throw t;
    }

    private <T> T readObject(JCTree jCTree, String str, T t) {
        Class<?> cls = jCTree.getClass();
        Map<String, Field> map = reflectionCache.get(cls);
        if (map == null) {
            Map<Class<?>, Map<String, Field>> map2 = reflectionCache;
            HashMap map3 = new HashMap();
            map = map3;
            map2.put(cls, map3);
        }
        Field field = map.get(str);
        if (field == null) {
            try {
                field = Permit.getField(cls, str);
                map.put(str, field);
            } catch (Exception unused) {
                return t;
            }
        }
        try {
            return (T) field.get(jCTree);
        } catch (Exception unused2) {
            return t;
        }
    }

    public void visitTypeBoundKind(JCTree.TypeBoundKind tree) {
        print(String.valueOf(tree.kind));
    }

    public void visitTree(JCTree tree) {
        String className = tree.getClass().getName();
        if (className.endsWith("$JCTypeUnion")) {
            print((List) readObject(tree, "alternatives", List.nil()), " | ");
            return;
        }
        if (className.endsWith("$JCTypeIntersection")) {
            print((List) readObject(tree, "bounds", List.nil()), " & ");
            return;
        }
        if (className.endsWith("$JCMemberReference")) {
            printMemberReference0(tree);
            return;
        }
        if (className.endsWith("$JCLambda")) {
            printLambda0(tree);
            return;
        }
        if (className.endsWith("$JCAnnotatedType")) {
            printAnnotatedType0(tree);
            return;
        }
        if (!className.endsWith("$JCPackageDecl")) {
            if (className.endsWith("$JCSwitchExpression")) {
                printSwitchExpression(tree);
            } else if (className.endsWith("$JCYield")) {
                printYieldExpression(tree);
            } else {
                if (className.endsWith("$JCBindingPattern")) {
                    printBindingPattern(tree);
                    return;
                }
                throw new AssertionError("Unhandled tree type: " + tree.getClass() + ": " + tree);
            }
        }
    }

    private boolean isCaseRuleStyle(JCTree.JCCase tree) {
        Enum<?> caseKind;
        return (tree == null || (caseKind = (Enum) readObject(tree, "caseKind", null)) == null || !caseKind.name().equalsIgnoreCase("RULE")) ? false : true;
    }

    private boolean isJcAnnotatedType(Object o) {
        if (o == null) {
            return false;
        }
        if (this.jcAnnotatedTypeInit) {
            return this.jcAnnotatedTypeClass == o.getClass();
        }
        Class<?> c = o.getClass();
        if (c.getName().endsWith("$JCAnnotatedType")) {
            this.jcAnnotatedTypeClass = c;
            this.jcAnnotatedTypeInit = true;
            return true;
        }
        return false;
    }

    private void printMemberReference0(JCTree tree) {
        print((JCTree) readObject(tree, "expr", null));
        print("::");
        List<? extends JCTree> list = (List) readObject(tree, "typeargs", List.nil());
        if (list != null && !list.isEmpty()) {
            print("<");
            print(list, ", ");
            print(">");
        }
        print(readObject(tree, "mode", new Object()).toString().equals("INVOKE") ? (CharSequence) readObject(tree, ModelAuditLogEntry.CHANGE_KEY_NAME, null) : "new");
    }

    private void printLambda0(JCTree tree) {
        List<JCTree.JCVariableDecl> params = (List) readObject(tree, "params", List.nil());
        boolean explicit = true;
        int paramLength = params.size();
        try {
            explicit = readObject(tree, "paramKind", new Object()).toString().equals("EXPLICIT");
        } catch (Exception unused) {
        }
        boolean useParens = paramLength != 1 || explicit;
        if (useParens) {
            print("(");
        }
        if (explicit) {
            boolean first = true;
            for (JCTree.JCVariableDecl vd : params) {
                if (!first) {
                    print(", ");
                }
                first = false;
                printVarDefInline(vd);
            }
        } else {
            String sep = "";
            for (JCTree.JCVariableDecl param : params) {
                print(sep);
                print((CharSequence) param.name);
                sep = ", ";
            }
        }
        if (useParens) {
            print(")");
        }
        print(" -> ");
        JCTree.JCBlock jCBlock = (JCTree) readObject(tree, "body", null);
        if (jCBlock instanceof JCTree.JCBlock) {
            println("{");
            this.indent++;
            print(jCBlock.stats, "");
            this.indent--;
            aPrint("}");
            return;
        }
        print((JCTree) jCBlock);
    }

    private void printAnnotatedType0(JCTree tree) {
        JCTree.JCFieldAccess jCFieldAccess = (JCTree) readObject(tree, "underlyingType", null);
        if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
            print((JCTree) jCFieldAccess.selected);
            print(".");
            print((List) readObject(tree, "annotations", List.nil()), " ");
            print(" ");
            print((CharSequence) jCFieldAccess.name);
            return;
        }
        if (jCFieldAccess instanceof JCTree.JCArrayTypeTree) {
            printTypeArray0(tree);
            return;
        }
        print((List) readObject(tree, "annotations", List.nil()), " ");
        print(" ");
        print((JCTree) jCFieldAccess);
    }

    private void printTypeArray0(JCTree tree) {
        JCTree inner = tree;
        int dimCount = 0;
        while (true) {
            if (inner instanceof JCTree.JCArrayTypeTree) {
                inner = ((JCTree.JCArrayTypeTree) inner).elemtype;
                dimCount++;
            } else {
                if (!isJcAnnotatedType(inner)) {
                    break;
                }
                JCTree.JCArrayTypeTree jCArrayTypeTree = (JCTree) readObject(inner, "underlyingType", null);
                if (!(jCArrayTypeTree instanceof JCTree.JCArrayTypeTree)) {
                    break;
                }
                inner = jCArrayTypeTree.elemtype;
                dimCount++;
            }
        }
        print(inner);
        JCTree jCTree = tree;
        while (true) {
            JCTree inner2 = jCTree;
            if (inner2 instanceof JCTree.JCArrayTypeTree) {
                dimCount--;
                print((dimCount == 0 && this.innermostArrayBracketsAreVarargs) ? "..." : "[]");
                jCTree = ((JCTree.JCArrayTypeTree) inner2).elemtype;
            } else if (isJcAnnotatedType(inner2)) {
                JCTree.JCArrayTypeTree jCArrayTypeTree2 = (JCTree) readObject(inner2, "underlyingType", null);
                if (jCArrayTypeTree2 instanceof JCTree.JCArrayTypeTree) {
                    dimCount--;
                    print(" ");
                    print((List) readObject(inner2, "annotations", List.nil()), " ");
                    print(" ");
                    print((dimCount == 0 && this.innermostArrayBracketsAreVarargs) ? "..." : "[]");
                    jCTree = jCArrayTypeTree2.elemtype;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
