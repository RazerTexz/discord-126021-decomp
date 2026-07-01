package lombok.launch;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import lombok.eclipse.EcjAugments;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.core.SourceField;
import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.RewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.TokenScanner;
import org.eclipse.jdt.internal.corext.refactoring.SearchResultGroup;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$PatchFixes.SCL.lombok */
public final class PatchFixesHider$PatchFixes {
    public static final int ALREADY_PROCESSED_FLAG = 8388608;

    public static boolean isGenerated(ASTNode node) {
        boolean result = false;
        try {
            result = ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
            if (!result && node.getParent() != null && (node.getParent() instanceof QualifiedName)) {
                result = isGenerated(node.getParent());
            }
        } catch (Exception unused) {
        }
        return result;
    }

    public static boolean isGenerated(org.eclipse.jdt.internal.compiler.ast.ASTNode node) {
        boolean result = false;
        try {
            result = node.getClass().getField("$generatedBy").get(node) != null;
        } catch (Exception unused) {
        }
        return result;
    }

    public static boolean isListRewriteOnGeneratedNode(ListRewrite rewrite) {
        return isGenerated(rewrite.getParent());
    }

    public static boolean returnFalse(Object object) {
        return false;
    }

    public static boolean returnTrue(Object object) {
        return true;
    }

    public static List removeGeneratedNodes(List list) {
        try {
            List realNodes = new ArrayList(list.size());
            for (Object node : list) {
                if (!isGenerated((ASTNode) node)) {
                    realNodes.add(node);
                }
            }
            return realNodes;
        } catch (Exception unused) {
            return list;
        }
    }

    public static String getRealMethodDeclarationSource(String original, Object processor, MethodDeclaration declaration) throws Exception {
        if (!isGenerated((ASTNode) declaration)) {
            return original;
        }
        List<Annotation> annotations = new ArrayList<>();
        for (Object modifier : declaration.modifiers()) {
            if (modifier instanceof Annotation) {
                Annotation annotation = (Annotation) modifier;
                String qualifiedAnnotationName = annotation.resolveTypeBinding().getQualifiedName();
                if (!"java.lang.Override".equals(qualifiedAnnotationName) && !"java.lang.SuppressWarnings".equals(qualifiedAnnotationName)) {
                    annotations.add(annotation);
                }
            }
        }
        StringBuilder signature = new StringBuilder();
        addAnnotations(annotations, signature);
        if (((Boolean) processor.getClass().getDeclaredField("fPublic").get(processor)).booleanValue()) {
            signature.append("public ");
        }
        if (((Boolean) processor.getClass().getDeclaredField("fAbstract").get(processor)).booleanValue()) {
            signature.append("abstract ");
        }
        signature.append(declaration.getReturnType2().toString()).append(" ").append(declaration.getName().getFullyQualifiedName()).append("(");
        boolean first = true;
        for (Object parameter : declaration.parameters()) {
            if (!first) {
                signature.append(", ");
            }
            first = false;
            signature.append(parameter);
        }
        signature.append(");");
        return signature.toString();
    }

    public static void addAnnotations(List<Annotation> annotations, StringBuilder signature) {
        Iterator<Annotation> it = annotations.iterator();
        while (it.hasNext()) {
            SingleMemberAnnotation singleMemberAnnotation = (Annotation) it.next();
            List<String> values = new ArrayList<>();
            if (singleMemberAnnotation.isSingleMemberAnnotation()) {
                SingleMemberAnnotation smAnn = singleMemberAnnotation;
                values.add(smAnn.getValue().toString());
            } else if (singleMemberAnnotation.isNormalAnnotation()) {
                NormalAnnotation normalAnn = (NormalAnnotation) singleMemberAnnotation;
                for (Object value : normalAnn.values()) {
                    values.add(value.toString());
                }
            }
            signature.append("@").append(singleMemberAnnotation.resolveTypeBinding().getQualifiedName());
            if (!values.isEmpty()) {
                signature.append("(");
                boolean first = true;
                for (String string : values) {
                    if (!first) {
                        signature.append(", ");
                    }
                    first = false;
                    signature.append('\"').append(string).append('\"');
                }
                signature.append(")");
            }
            signature.append(" ");
        }
    }

    public static MethodDeclaration getRealMethodDeclarationNode(IMethod sourceMethod, CompilationUnit cuUnit) throws JavaModelException {
        AbstractTypeDeclaration typeDeclaration;
        MethodDeclaration methodDeclarationNode = ASTNodeSearchUtil.getMethodDeclarationNode(sourceMethod, cuUnit);
        if (isGenerated((ASTNode) methodDeclarationNode)) {
            Stack<IType> typeStack = new Stack<>();
            for (IType declaringType = sourceMethod.getDeclaringType(); declaringType != null; declaringType = declaringType.getDeclaringType()) {
                typeStack.push(declaringType);
            }
            IType rootType = typeStack.pop();
            AbstractTypeDeclaration abstractTypeDeclarationFindTypeDeclaration = findTypeDeclaration(rootType, cuUnit.types());
            while (true) {
                typeDeclaration = abstractTypeDeclarationFindTypeDeclaration;
                if (typeStack.isEmpty() || typeDeclaration == null) {
                    break;
                }
                abstractTypeDeclarationFindTypeDeclaration = findTypeDeclaration(typeStack.pop(), typeDeclaration.bodyDeclarations());
            }
            if (typeStack.isEmpty() && typeDeclaration != null) {
                String methodName = sourceMethod.getElementName();
                for (Object declaration : typeDeclaration.bodyDeclarations()) {
                    if (declaration instanceof MethodDeclaration) {
                        MethodDeclaration methodDeclaration = (MethodDeclaration) declaration;
                        if (methodDeclaration.getName().toString().equals(methodName)) {
                            return methodDeclaration;
                        }
                    }
                }
            }
        }
        return methodDeclarationNode;
    }

    public static AbstractTypeDeclaration findTypeDeclaration(IType searchType, List<?> nodes) {
        for (Object object : nodes) {
            if (object instanceof AbstractTypeDeclaration) {
                AbstractTypeDeclaration typeDeclaration = (AbstractTypeDeclaration) object;
                if (typeDeclaration.getName().toString().equals(searchType.getElementName())) {
                    return typeDeclaration;
                }
            }
        }
        return null;
    }

    public static int getSourceEndFixed(int sourceEnd, org.eclipse.jdt.internal.compiler.ast.ASTNode node) throws Exception {
        org.eclipse.jdt.internal.compiler.ast.ASTNode object;
        if (sourceEnd == -1 && (object = (org.eclipse.jdt.internal.compiler.ast.ASTNode) node.getClass().getField("$generatedBy").get(node)) != null) {
            return object.sourceEnd;
        }
        return sourceEnd;
    }

    public static int fixRetrieveStartingCatchPosition(int original, int start) {
        return original == -1 ? start : original;
    }

    public static int fixRetrieveIdentifierEndPosition(int original, int start, int end) {
        if (original != -1 && original >= start) {
            return original;
        }
        return end;
    }

    public static int fixRetrieveEllipsisStartPosition(int original, int end) {
        return original == -1 ? end : original;
    }

    public static int fixRetrieveStartBlockPosition(int original, int start) {
        return original == -1 ? start : original;
    }

    public static int fixRetrieveRightBraceOrSemiColonPosition(int original, int end) {
        return original == -1 ? end : original;
    }

    public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, AbstractMethodDeclaration amd) {
        if (retVal != -1 || amd == null) {
            return retVal;
        }
        boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(amd) != null;
        if (isGenerated) {
            return amd.declarationSourceEnd;
        }
        return -1;
    }

    public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, FieldDeclaration fd) {
        if (retVal != -1 || fd == null) {
            return retVal;
        }
        boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(fd) != null;
        if (isGenerated) {
            return fd.declarationSourceEnd;
        }
        return -1;
    }

    public static int fixRetrieveProperRightBracketPosition(int retVal, Type type) {
        if (retVal != -1 || type == null) {
            return retVal;
        }
        if (isGenerated((ASTNode) type)) {
            return (type.getStartPosition() + type.getLength()) - 1;
        }
        return -1;
    }

    public static boolean checkBit24(Object node) throws Exception {
        int bits = ((Integer) node.getClass().getField("bits").get(node)).intValue();
        return (bits & 8388608) != 0;
    }

    public static boolean skipRewritingGeneratedNodes(ASTNode node) throws Exception {
        return ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
    }

    public static void setIsGeneratedFlag(ASTNode domNode, org.eclipse.jdt.internal.compiler.ast.ASTNode internalNode) throws Exception {
        if (internalNode == null || domNode == null) {
            return;
        }
        boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(internalNode) != null;
        if (isGenerated) {
            domNode.getClass().getField("$isGenerated").set(domNode, true);
        }
    }

    public static void setIsGeneratedFlagForName(Name name, Object internalNode) throws Exception {
        if (internalNode instanceof org.eclipse.jdt.internal.compiler.ast.ASTNode) {
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get((org.eclipse.jdt.internal.compiler.ast.ASTNode) internalNode) != null;
            if (isGenerated) {
                name.getClass().getField("$isGenerated").set(name, true);
            }
        }
    }

    public static RewriteEvent[] listRewriteHandleGeneratedMethods(RewriteEvent parent) {
        RewriteEvent[] children = parent.getChildren();
        List<RewriteEvent> newChildren = new ArrayList<>();
        List<RewriteEvent> modifiedChildren = new ArrayList<>();
        for (RewriteEvent child : children) {
            boolean isGenerated = isGenerated((ASTNode) child.getOriginalValue());
            if (isGenerated) {
                boolean isReplacedOrRemoved = child.getChangeKind() == 4 || child.getChangeKind() == 2;
                boolean convertingFromMethod = child.getOriginalValue() instanceof MethodDeclaration;
                if (isReplacedOrRemoved && convertingFromMethod && child.getNewValue() != null) {
                    modifiedChildren.add(new NodeRewriteEvent((Object) null, child.getNewValue()));
                }
            } else {
                newChildren.add(child);
            }
        }
        newChildren.addAll(modifiedChildren);
        return (RewriteEvent[]) newChildren.toArray(new RewriteEvent[0]);
    }

    public static int getTokenEndOffsetFixed(TokenScanner scanner, int token, int startOffset, Object domNode) throws CoreException {
        boolean isGenerated = false;
        try {
            isGenerated = ((Boolean) domNode.getClass().getField("$isGenerated").get(domNode)).booleanValue();
        } catch (Exception unused) {
        }
        if (isGenerated) {
            return -1;
        }
        return scanner.getTokenEndOffset(token, startOffset);
    }

    public static IMethod[] removeGeneratedMethods(IMethod[] methods) throws Exception {
        List<IMethod> result = new ArrayList<>();
        for (IMethod m : methods) {
            if (m.getNameRange().getLength() > 0 && !m.getNameRange().equals(m.getSourceRange())) {
                result.add(m);
            }
        }
        return result.size() == methods.length ? methods : (IMethod[]) result.toArray(new IMethod[0]);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0038  */
    public static SearchMatch[] removeGenerated(SearchMatch[] returnValue) {
        List<SearchMatch> result = new ArrayList<>();
        for (SearchMatch searchResult : returnValue) {
            if (searchResult.getElement() instanceof IField) {
                IField field = (IField) searchResult.getElement();
                IAnnotation annotation = field.getAnnotation("Generated");
                if (annotation == null) {
                    result.add(searchResult);
                }
            } else {
                result.add(searchResult);
            }
        }
        return (SearchMatch[]) result.toArray(new SearchMatch[0]);
    }

    public static SearchResultGroup[] createFakeSearchResult(SearchResultGroup[] returnValue, Object processor) throws Exception {
        Field declaredField;
        if ((returnValue == null || returnValue.length == 0) && (declaredField = processor.getClass().getDeclaredField("fField")) != null) {
            declaredField.setAccessible(true);
            SourceField fField = (SourceField) declaredField.get(processor);
            IAnnotation dataAnnotation = fField.getDeclaringType().getAnnotation("Data");
            if (dataAnnotation != null) {
                return new SearchResultGroup[]{new SearchResultGroup((IResource) null, new SearchMatch[1])};
            }
        }
        return returnValue;
    }

    public static SimpleName[] removeGeneratedSimpleNames(SimpleName[] in) throws Exception {
        Field f = SimpleName.class.getField("$isGenerated");
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == null || !((Boolean) f.get(in[i])).booleanValue()) {
                count++;
            }
        }
        if (count == in.length) {
            return in;
        }
        SimpleName[] newSimpleNames = new SimpleName[count];
        int count2 = 0;
        for (int i2 = 0; i2 < in.length; i2++) {
            if (in[i2] == null || !((Boolean) f.get(in[i2])).booleanValue()) {
                int i3 = count2;
                count2++;
                newSimpleNames[i3] = in[i2];
            }
        }
        return newSimpleNames;
    }

    public static org.eclipse.jdt.internal.compiler.ast.Annotation[] convertAnnotations(org.eclipse.jdt.internal.compiler.ast.Annotation[] out, IAnnotatable annotatable) {
        try {
            IAnnotation[] in = annotatable.getAnnotations();
            if (out == null) {
                return null;
            }
            int toWrite = 0;
            for (int idx = 0; idx < out.length; idx++) {
                String oName = new String(out[idx].type.getLastToken());
                boolean found = false;
                for (IAnnotation i : in) {
                    String name = i.getElementName();
                    int li = name.lastIndexOf(46);
                    if (li > -1) {
                        name = name.substring(li + 1);
                    }
                    if (name.equals(oName)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    toWrite++;
                } else {
                    out[idx] = null;
                }
            }
            org.eclipse.jdt.internal.compiler.ast.Annotation[] replace = out;
            if (toWrite < out.length) {
                replace = new org.eclipse.jdt.internal.compiler.ast.Annotation[toWrite];
                int idx2 = 0;
                for (int i2 = 0; i2 < out.length; i2++) {
                    if (out[i2] != null) {
                        int i3 = idx2;
                        idx2++;
                        replace[i3] = out[i2];
                    }
                }
            }
            return replace;
        } catch (Exception unused) {
            return out;
        }
    }
}
