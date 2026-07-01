package lombok.javac;

import com.discord.api.permission.Permission;
import com.sun.source.util.Trees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.List;
import java.io.PrintStream;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacASTVisitor$Printer.SCL.lombok */
public class JavacASTVisitor$Printer implements JavacASTVisitor {
    private final PrintStream out;
    private final boolean printContent;
    private int disablePrinting;
    private int indent;

    public JavacASTVisitor$Printer(boolean printContent) {
        this(printContent, System.out);
    }

    public JavacASTVisitor$Printer(boolean printContent, PrintStream out) {
        this.disablePrinting = 0;
        this.indent = 0;
        this.printContent = printContent;
        this.out = out;
    }

    @Override // lombok.javac.JavacASTVisitor
    public void setTrees(Trees trees) {
    }

    private void forcePrint(String text, Object... params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.indent; i++) {
            sb.append("  ");
        }
        this.out.printf(sb.append(text).append('\n').toString(), params);
        this.out.flush();
    }

    private void print(String text, Object... params) {
        if (this.disablePrinting == 0) {
            forcePrint(text, params);
        }
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitCompilationUnit(JavacNode LombokNode, JCTree$JCCompilationUnit unit) {
        this.out.println("---------------------------------------------------------");
        print("<CU %s>", LombokNode.getFileName());
        this.indent++;
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitCompilationUnit(JavacNode node, JCTree$JCCompilationUnit unit) {
        this.indent--;
        print("</CUD>", new Object[0]);
    }

    private String printFlags(long f) {
        return Flags.toString(f);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitType(JavacNode node, JCTree$JCClassDecl type) {
        print("<TYPE %s> %s", type.name, printFlags(type.mods.flags));
        this.indent++;
        if (this.printContent) {
            print("%s", type);
            this.disablePrinting++;
        }
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnType(JCTree$JCClassDecl type, JavacNode node, JCTree$JCAnnotation annotation) {
        forcePrint("<ANNOTATION: %s />", annotation);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitType(JavacNode node, JCTree$JCClassDecl type) {
        if (this.printContent) {
            this.disablePrinting--;
        }
        this.indent--;
        print("</TYPE %s>", type.name);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitInitializer(JavacNode node, JCTree$JCBlock initializer) {
        Object[] objArr = new Object[1];
        objArr[0] = initializer.isStatic() ? "static" : "instance";
        print("<%s INITIALIZER>", objArr);
        this.indent++;
        if (this.printContent) {
            print("%s", initializer);
            this.disablePrinting++;
        }
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitInitializer(JavacNode node, JCTree$JCBlock initializer) {
        if (this.printContent) {
            this.disablePrinting--;
        }
        this.indent--;
        Object[] objArr = new Object[1];
        objArr[0] = initializer.isStatic() ? "static" : "instance";
        print("</%s INITIALIZER>", objArr);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitField(JavacNode node, JCTree$JCVariableDecl field) {
        print("<FIELD %s %s> %s", field.vartype, field.name, printFlags(field.mods.flags));
        this.indent++;
        if (this.printContent) {
            if (field.init != null) {
                print("%s", field.init);
            }
            this.disablePrinting++;
        }
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnField(JCTree$JCVariableDecl field, JavacNode node, JCTree$JCAnnotation annotation) {
        forcePrint("<ANNOTATION: %s />", annotation);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitField(JavacNode node, JCTree$JCVariableDecl field) {
        if (this.printContent) {
            this.disablePrinting--;
        }
        this.indent--;
        print("</FIELD %s %s>", field.vartype, field.name);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitMethod(JavacNode node, JCTree$JCMethodDecl method) {
        String type;
        JCTree$JCVariableDecl recv;
        if (method.name.contentEquals("<init>")) {
            type = (method.mods.flags & Permission.CREATE_PRIVATE_THREADS) != 0 ? "DEFAULTCONSTRUCTOR" : "CONSTRUCTOR";
        } else {
            type = "METHOD";
        }
        print("<%s %s> %s returns: %s", type, method.name, printFlags(method.mods.flags), method.restype);
        this.indent++;
        try {
            Field f = JCTree$JCMethodDecl.class.getField("recvparam");
            recv = (JCTree$JCVariableDecl) f.get(method);
        } catch (Exception unused) {
            recv = null;
        }
        if (recv != null) {
            List<JCTree$JCAnnotation> annotations = recv.mods.annotations;
            if (recv.mods != null) {
                annotations = recv.mods.annotations;
            }
            boolean innerContent = annotations != null && annotations.isEmpty();
            Object[] objArr = new Object[5];
            objArr[0] = recv.vartype == null ? "null" : recv.vartype.getClass().toString();
            objArr[1] = recv.vartype;
            objArr[2] = recv.name;
            objArr[3] = innerContent ? "" : " /";
            objArr[4] = printFlags(recv.mods.flags);
            print("<RECEIVER-PARAM (%s) %s %s%s> %s", objArr);
            if (innerContent) {
                this.indent++;
                for (JCTree$JCAnnotation ann : annotations) {
                    print("<ANNOTATION: %s />", ann);
                }
                this.indent--;
                print("</RECEIVER-PARAM>", new Object[0]);
            }
        }
        if (this.printContent) {
            if (method.body == null) {
                print("(ABSTRACT)", new Object[0]);
            } else {
                print("%s", method.body);
            }
            this.disablePrinting++;
        }
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnMethod(JCTree$JCMethodDecl method, JavacNode node, JCTree$JCAnnotation annotation) {
        forcePrint("<ANNOTATION: %s />", annotation);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitMethod(JavacNode node, JCTree$JCMethodDecl method) {
        if (this.printContent) {
            this.disablePrinting--;
        }
        this.indent--;
        print("</%s %s>", "METHOD", method.name);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitMethodArgument(JavacNode node, JCTree$JCVariableDecl arg, JCTree$JCMethodDecl method) {
        print("<METHODARG (%s) %s %s> %s", arg.vartype.getClass().toString(), arg.vartype, arg.name, printFlags(arg.mods.flags));
        this.indent++;
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnMethodArgument(JCTree$JCVariableDecl arg, JCTree$JCMethodDecl method, JavacNode nodeAnnotation, JCTree$JCAnnotation annotation) {
        forcePrint("<ANNOTATION: %s />", annotation);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitMethodArgument(JavacNode node, JCTree$JCVariableDecl arg, JCTree$JCMethodDecl method) {
        this.indent--;
        print("</METHODARG %s %s>", arg.vartype, arg.name);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitLocal(JavacNode node, JCTree$JCVariableDecl local) {
        print("<LOCAL %s %s> %s", local.vartype, local.name, printFlags(local.mods.flags));
        this.indent++;
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnLocal(JCTree$JCVariableDecl local, JavacNode node, JCTree$JCAnnotation annotation) {
        print("<ANNOTATION: %s />", annotation);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitLocal(JavacNode node, JCTree$JCVariableDecl local) {
        this.indent--;
        print("</LOCAL %s %s>", local.vartype, local.name);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitTypeUse(JavacNode node, JCTree typeUse) {
        print("<TYPE %s>", typeUse.getClass());
        this.indent++;
        print("%s", typeUse);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnTypeUse(JCTree typeUse, JavacNode node, JCTree$JCAnnotation annotation) {
        print("<ANNOTATION: %s />", annotation);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitTypeUse(JavacNode node, JCTree typeUse) {
        this.indent--;
        print("</TYPE %s>", typeUse.getClass());
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitStatement(JavacNode node, JCTree statement) {
        print("<%s>", statement.getClass());
        this.indent++;
        print("%s", statement);
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitStatement(JavacNode node, JCTree statement) {
        this.indent--;
        print("</%s>", statement.getClass());
    }
}
