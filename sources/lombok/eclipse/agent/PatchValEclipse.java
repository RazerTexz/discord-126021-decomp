package lombok.eclipse.agent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lombok.Lombok;
import lombok.permit.Permit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Modifier$ModifierKeyword;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.parser.Parser;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchValEclipse.SCL.lombok */
public class PatchValEclipse {
    private static final Field FIELD_NAME_INDEX;

    public static void copyInitializationOfForEachIterable(Parser parser) {
        try {
            ForeachStatement[] foreachStatementArr = (ASTNode[]) PatchValEclipse$Reflection.access$0().get(parser);
            int astPtr = ((Integer) PatchValEclipse$Reflection.access$1().get(parser)).intValue();
            ForeachStatement foreachDecl = foreachStatementArr[astPtr];
            Expression expression = foreachDecl.collection;
            if (expression == null) {
                return;
            }
            ImportReference[] importReferenceArr = (parser == null || parser.compilationUnit == null) ? null : parser.compilationUnit.imports;
            boolean val = couldBeVal(importReferenceArr, foreachDecl.elementVariable.type);
            ImportReference[] importReferenceArr2 = (parser == null || parser.compilationUnit == null) ? null : parser.compilationUnit.imports;
            boolean var = couldBeVar(importReferenceArr2, foreachDecl.elementVariable.type);
            if (foreachDecl.elementVariable != null) {
                if (val || var) {
                    try {
                        if (PatchValEclipse$Reflection.access$2() != null) {
                            PatchValEclipse$Reflection.access$2().set(foreachDecl.elementVariable, expression);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void copyInitializationOfLocalDeclaration(Parser parser) {
        Expression expression;
        try {
            AbstractVariableDeclaration[] abstractVariableDeclarationArr = (ASTNode[]) PatchValEclipse$Reflection.access$0().get(parser);
            int astPtr = ((Integer) PatchValEclipse$Reflection.access$1().get(parser)).intValue();
            AbstractVariableDeclaration variableDecl = abstractVariableDeclarationArr[astPtr];
            if ((variableDecl instanceof LocalDeclaration) && (expression = variableDecl.initialization) != null) {
                ImportReference[] importReferenceArr = (parser == null || parser.compilationUnit == null) ? null : parser.compilationUnit.imports;
                boolean val = couldBeVal(importReferenceArr, variableDecl.type);
                ImportReference[] importReferenceArr2 = (parser == null || parser.compilationUnit == null) ? null : parser.compilationUnit.imports;
                boolean var = couldBeVar(importReferenceArr2, variableDecl.type);
                if (val || var) {
                    try {
                        if (PatchValEclipse$Reflection.access$3() != null) {
                            PatchValEclipse$Reflection.access$3().set(variableDecl, expression);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static boolean couldBeVal(ImportReference[] imports, TypeReference type) {
        return PatchVal.couldBe(imports, "lombok.val", type);
    }

    private static boolean couldBeVar(ImportReference[] imports, TypeReference type) {
        return PatchVal.couldBe(imports, "lombok.experimental.var", type) || PatchVal.couldBe(imports, "lombok.var", type);
    }

    public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, SingleVariableDeclaration out, LocalDeclaration in) {
        List<IExtendedModifier> modifiers = out.modifiers();
        addFinalAndValAnnotationToModifierList(converter, modifiers, out.getAST(), in);
    }

    public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, VariableDeclarationStatement out, LocalDeclaration in) {
        List<IExtendedModifier> modifiers = out.modifiers();
        addFinalAndValAnnotationToModifierList(converter, modifiers, out.getAST(), in);
    }

    public static void addFinalAndValAnnotationToModifierList(Object converter, List<IExtendedModifier> modifiers, AST ast, LocalDeclaration in) {
        Name typeName;
        if (in.annotations == null) {
            return;
        }
        boolean found = false;
        Annotation valAnnotation = null;
        Annotation varAnnotation = null;
        for (Annotation ann : in.annotations) {
            if (couldBeVal(null, ann.type)) {
                found = true;
                valAnnotation = ann;
            }
            if (couldBeVar(null, ann.type)) {
                found = true;
                varAnnotation = ann;
            }
        }
        if (found && modifiers != null) {
            boolean finalIsPresent = false;
            boolean valIsPresent = false;
            boolean varIsPresent = false;
            for (Object present : modifiers) {
                if (present instanceof Modifier) {
                    Modifier$ModifierKeyword keyword = ((Modifier) present).getKeyword();
                    if (keyword != null) {
                        if (keyword.toFlagValue() == 16) {
                            finalIsPresent = true;
                        }
                    }
                }
                if ((present instanceof org.eclipse.jdt.core.dom.Annotation) && (typeName = ((org.eclipse.jdt.core.dom.Annotation) present).getTypeName()) != null) {
                    String fullyQualifiedName = typeName.getFullyQualifiedName();
                    if ("val".equals(fullyQualifiedName) || "lombok.val".equals(fullyQualifiedName)) {
                        valIsPresent = true;
                    }
                    if ("var".equals(fullyQualifiedName) || "lombok.var".equals(fullyQualifiedName) || "lombok.experimental.var".equals(fullyQualifiedName)) {
                        varIsPresent = true;
                    }
                }
            }
            if (!finalIsPresent && valAnnotation != null) {
                modifiers.add(createModifier(ast, Modifier$ModifierKeyword.FINAL_KEYWORD, valAnnotation.sourceStart, valAnnotation.sourceEnd));
            }
            if (!valIsPresent && valAnnotation != null) {
                MarkerAnnotation newAnnotation = createValVarAnnotation(ast, valAnnotation, valAnnotation.sourceStart, valAnnotation.sourceEnd);
                try {
                    PatchValEclipse$Reflection.access$4().invoke(converter, newAnnotation, valAnnotation);
                    PatchValEclipse$Reflection.access$4().invoke(converter, newAnnotation.getTypeName(), valAnnotation.type);
                    modifiers.add(newAnnotation);
                } catch (IllegalAccessException e) {
                    throw Lombok.sneakyThrow(e);
                } catch (InvocationTargetException e2) {
                    throw Lombok.sneakyThrow(e2.getCause());
                }
            }
            if (!varIsPresent && varAnnotation != null) {
                MarkerAnnotation newAnnotation2 = createValVarAnnotation(ast, varAnnotation, varAnnotation.sourceStart, varAnnotation.sourceEnd);
                try {
                    PatchValEclipse$Reflection.access$4().invoke(converter, newAnnotation2, varAnnotation);
                    PatchValEclipse$Reflection.access$4().invoke(converter, newAnnotation2.getTypeName(), varAnnotation.type);
                    modifiers.add(newAnnotation2);
                } catch (IllegalAccessException e3) {
                    throw Lombok.sneakyThrow(e3);
                } catch (InvocationTargetException e4) {
                    throw Lombok.sneakyThrow(e4.getCause());
                }
            }
        }
    }

    public static Modifier createModifier(AST ast, Modifier$ModifierKeyword keyword, int start, int end) {
        try {
            Modifier modifier = (Modifier) PatchValEclipse$Reflection.access$5().newInstance(ast);
            if (modifier != null) {
                modifier.setKeyword(keyword);
                modifier.setSourceRange(start, (end - start) + 1);
            }
            return modifier;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw Lombok.sneakyThrow(e2);
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    public static MarkerAnnotation createValVarAnnotation(AST ast, Annotation original, int start, int end) {
        char[][] tokens;
        try {
            MarkerAnnotation out = (MarkerAnnotation) PatchValEclipse$Reflection.access$6().newInstance(ast);
            if (original.type instanceof SingleTypeReference) {
                tokens = new char[][]{original.type.token};
            } else if (original.type instanceof QualifiedTypeReference) {
                tokens = original.type.tokens;
            } else {
                return null;
            }
            if (out != null) {
                SimpleName valName = ast.newSimpleName(new String(tokens[tokens.length - 1]));
                valName.setSourceRange(start, (end - start) + 1);
                if (tokens.length == 1) {
                    out.setTypeName(valName);
                    setIndex(valName, 1);
                } else if (tokens.length == 2) {
                    SimpleName lombokName = ast.newSimpleName("lombok");
                    lombokName.setSourceRange(start, (end - start) + 1);
                    setIndex(lombokName, 1);
                    setIndex(valName, 2);
                    QualifiedName fullName = ast.newQualifiedName(lombokName, valName);
                    setIndex(fullName, 1);
                    fullName.setSourceRange(start, (end - start) + 1);
                    out.setTypeName(fullName);
                } else {
                    SimpleName lombokName2 = ast.newSimpleName("lombok");
                    lombokName2.setSourceRange(start, (end - start) + 1);
                    SimpleName experimentalName = ast.newSimpleName("experimental");
                    lombokName2.setSourceRange(start, (end - start) + 1);
                    setIndex(lombokName2, 1);
                    setIndex(experimentalName, 2);
                    setIndex(valName, 3);
                    QualifiedName lombokExperimentalName = ast.newQualifiedName(lombokName2, experimentalName);
                    lombokExperimentalName.setSourceRange(start, (end - start) + 1);
                    setIndex(lombokExperimentalName, 1);
                    QualifiedName fullName2 = ast.newQualifiedName(lombokExperimentalName, valName);
                    setIndex(fullName2, 1);
                    fullName2.setSourceRange(start, (end - start) + 1);
                    out.setTypeName(fullName2);
                }
                out.setSourceRange(start, (end - start) + 1);
            }
            return out;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw Lombok.sneakyThrow(e2);
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    static {
        Field f = null;
        try {
            f = Permit.getField(Name.class, "index");
        } catch (Throwable unused) {
        }
        FIELD_NAME_INDEX = f;
    }

    private static void setIndex(Name name, int index) {
        try {
            if (FIELD_NAME_INDEX != null) {
                FIELD_NAME_INDEX.set(name, Integer.valueOf(index));
            }
        } catch (Exception unused) {
        }
    }
}
