package lombok.patcher.scripts;

import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.PatchScript$MethodPatcher;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapReturnValuesScript.SCL.lombok */
public final class WrapReturnValuesScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Set<StackRequest> requests;
    private final boolean hijackReturnValue;
    private final boolean transplant;
    private final boolean insert;
    private final boolean cast;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$5(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !WrapReturnValuesScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$4(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.wrapper;
    }

    static /* synthetic */ Set access$1(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.requests;
    }

    static /* synthetic */ boolean access$2(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.hijackReturnValue;
    }

    static /* synthetic */ boolean access$3(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.insert;
    }

    static /* synthetic */ boolean access$6(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.transplant;
    }

    static /* synthetic */ boolean access$7(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.cast;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "wrap returns with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    WrapReturnValuesScript(List<TargetMatcher> matchers, Hook wrapper, boolean transplant, boolean insert, boolean cast, Set<StackRequest> requests) {
        super(matchers);
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.wrapper = wrapper;
        this.hijackReturnValue = !wrapper.getMethodDescriptor().endsWith(")V");
        this.requests = requests;
        this.transplant = transplant;
        this.insert = insert;
        this.cast = cast && this.hijackReturnValue;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && cast && insert) {
            throw new AssertionError();
        }
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript$MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        PatchScript$MethodPatcher patcher = new PatchScript$MethodPatcher(writer, transplantMapper, new WrapReturnValuesScript$1(this, classSpec));
        if (this.transplant) {
            patcher.addTransplant(this.wrapper);
        }
        return patcher;
    }

    static /* synthetic */ String access$0(String str) {
        return extractReturnValueFromDesc(str);
    }

    private static String extractReturnValueFromDesc(String desc) {
        int lastIdx = desc == null ? -1 : desc.lastIndexOf(41);
        if (lastIdx == -1) {
            return null;
        }
        String rd = desc.substring(lastIdx + 1);
        return (rd.startsWith("L") && rd.endsWith(";")) ? rd.substring(1, rd.length() - 1) : rd;
    }

    public String toString() {
        return "WrapReturnValues(wrapper: " + this.wrapper + ", hijackReturn: " + this.hijackReturnValue + ", transplant: " + this.transplant + ", insert: " + this.insert + ", requests: " + this.requests + ")";
    }
}
