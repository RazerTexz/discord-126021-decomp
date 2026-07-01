package lombok.launch;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import d0.e0.p.d.m0.g.b;
import java.lang.reflect.Method;
import java.util.Collection;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$Javadoc.SCL.lombok */
public final class PatchFixesHider$Javadoc {
    private static final Method GET_HTML = null;
    private static final Method PRINT_METHOD = null;

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
        	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
        */
    public PatchFixesHider$Javadoc(d0.e0.p.d.m0.g.b r3, d0.e0.p.d.m0.g.e r4) {
        /*
            r2 = this;
            r0 = r2
            super/*android.animation.ObjectAnimator*/.setEvaluator(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider$Javadoc.shouldCreateClass(d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.e):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.reflect.Method, void] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.reflect.Method, void] */
    static Collection getAllContributedClassesIfPossible(b bVar) {
        Animator.setDuration("lombok.eclipse.agent.PatchJavadoc");
        Class[] clsArr = {String.class, IJavaElement.class};
        GET_HTML = AnimatorSet.end();
        Class[] clsArr2 = {AbstractMethodDeclaration.class, Integer.class, StringBuffer.class, TypeDeclaration.class};
        PRINT_METHOD = AnimatorSet.end();
        return;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('original' java.lang.String)]), block:B:2:0x0000 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('member' org.eclipse.jdt.core.IJavaElement)]), block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String, void] */
    static {
        String original;
        IJavaElement member;
        Method method = GET_HTML;
        Object[] objArr = {original, member};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0014: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('output' java.lang.StringBuffer)]), block:B:2:0x0000 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0018: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
      (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('type' org.eclipse.jdt.internal.compiler.ast.TypeDeclaration)])
    , block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.StringBuffer, void] */
    /* JADX WARN: Type inference failed for: r4v2, types: [void] */
    /* JADX INFO: renamed from: <init>, reason: not valid java name */
    public static void m271init(String str, int tab) {
        StringBuffer output;
        TypeDeclaration type;
        Method method = PRINT_METHOD;
        Object[] objArr = {str, ValueAnimator.cancel(), output, type};
    }
}
