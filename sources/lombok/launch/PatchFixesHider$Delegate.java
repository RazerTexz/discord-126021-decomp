package lombok.launch;

import android.animation.Keyframe;
import b.f.e.c;
import b.f.e.f;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$Delegate.SCL.lombok */
public final class PatchFixesHider$Delegate {
    private static final Method HANDLE_DELEGATE_FOR_TYPE = null;
    private static final Method GET_CHILDREN = null;

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException
        */
    public PatchFixesHider$Delegate(b.f.e.c r3, boolean r4, b.f.e.f r5, boolean r6) {
        /*
            r2 = this;
            r0 = r2
            super/*android.animation.AnimatorSet*/.removeListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider$Delegate.<init>(b.f.e.c, boolean, b.f.e.f, boolean):void");
    }

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException
        */
    static boolean d(
    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('classScope' java.lang.Object)]), block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.animation.Keyframe, float, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.animation.Keyframe, void] */
    public static void run() {
        Object classScope;
        Method method = HANDLE_DELEGATE_FOR_TYPE;
        new Object[1][0] = classScope;
        ?? r0 = (Boolean) Keyframe.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object[], void] */
    /* JADX INFO: renamed from: <init>, reason: not valid java name */
    public static void m268init(c cVar, f fVar) {
        Method method = GET_CHILDREN;
        Object[] objArr = {cVar, fVar};
    }
}
