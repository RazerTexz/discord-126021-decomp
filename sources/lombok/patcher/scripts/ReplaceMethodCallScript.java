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

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ReplaceMethodCallScript.SCL.lombok */
public class ReplaceMethodCallScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Hook methodToReplace;
    private final boolean transplant;
    private final boolean insert;
    private final Set<StackRequest> extraRequests;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$4(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !ReplaceMethodCallScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$3(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.wrapper;
    }

    static /* synthetic */ Hook access$0(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.methodToReplace;
    }

    static /* synthetic */ boolean access$2(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.insert;
    }

    static /* synthetic */ boolean access$5(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.transplant;
    }

    static /* synthetic */ Set access$1(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.extraRequests;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "replace " + this.methodToReplace.getMethodName() + " with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    ReplaceMethodCallScript(List<TargetMatcher> matchers, Hook callToReplace, Hook wrapper, boolean transplant, boolean insert, Set<StackRequest> extraRequests) {
        super(matchers);
        if (callToReplace == null) {
            throw new NullPointerException("callToReplace");
        }
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.methodToReplace = callToReplace;
        this.wrapper = wrapper;
        this.transplant = transplant;
        this.insert = insert;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        this.extraRequests = extraRequests;
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript$MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        PatchScript$MethodPatcher patcher = new PatchScript$MethodPatcher(writer, transplantMapper, new ReplaceMethodCallScript$1(this, classSpec));
        if (this.transplant) {
            patcher.addTransplant(this.wrapper);
        }
        return patcher;
    }
}
