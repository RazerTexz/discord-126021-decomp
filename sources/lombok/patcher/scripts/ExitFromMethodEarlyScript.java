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

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ExitFromMethodEarlyScript.SCL.lombok */
public class ExitFromMethodEarlyScript extends MethodLevelPatchScript {
    private final Hook decisionWrapper;
    private final Hook valueWrapper;
    private final Set<StackRequest> requests;
    private final boolean transplant;
    private final boolean insert;
    private final boolean insertCallOnly;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$3(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !ExitFromMethodEarlyScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$0(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.decisionWrapper;
    }

    static /* synthetic */ Hook access$6(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.valueWrapper;
    }

    static /* synthetic */ Set access$1(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.requests;
    }

    static /* synthetic */ boolean access$2(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.insert;
    }

    static /* synthetic */ boolean access$4(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.transplant;
    }

    static /* synthetic */ boolean access$5(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.insertCallOnly;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "Exit Early from " + describeMatchers();
    }

    ExitFromMethodEarlyScript(List<TargetMatcher> matchers, Hook decisionWrapper, Hook valueWrapper, boolean transplant, boolean insert, Set<StackRequest> requests) {
        super(matchers);
        this.decisionWrapper = decisionWrapper;
        this.valueWrapper = valueWrapper;
        this.requests = requests;
        this.transplant = transplant;
        this.insert = insert;
        this.insertCallOnly = decisionWrapper != null && decisionWrapper.getMethodDescriptor().endsWith(")V");
        if (!this.insertCallOnly && decisionWrapper != null && !decisionWrapper.getMethodDescriptor().endsWith(")Z")) {
            throw new IllegalArgumentException("The decisionWrapper method must either return 'boolean' or return 'void'.");
        }
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript$MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        PatchScript$MethodPatcher patcher = new PatchScript$MethodPatcher(writer, transplantMapper, new ExitFromMethodEarlyScript$1(this, classSpec));
        if (this.transplant) {
            patcher.addTransplant(this.decisionWrapper);
            if (this.valueWrapper != null) {
                patcher.addTransplant(this.valueWrapper);
            }
        }
        return patcher;
    }
}
