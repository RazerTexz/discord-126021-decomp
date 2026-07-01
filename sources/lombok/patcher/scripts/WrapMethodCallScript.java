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

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/WrapMethodCallScript.SCL.lombok */
public class WrapMethodCallScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Hook callToWrap;
    private final boolean transplant;
    private final boolean insert;
    private final boolean leaveReturnValueIntact;
    private final Set<StackRequest> extraRequests;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$5(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !WrapMethodCallScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$4(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.wrapper;
    }

    static /* synthetic */ Hook access$0(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.callToWrap;
    }

    static /* synthetic */ boolean access$3(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.insert;
    }

    static /* synthetic */ boolean access$6(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.transplant;
    }

    static /* synthetic */ boolean access$1(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.leaveReturnValueIntact;
    }

    static /* synthetic */ Set access$2(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.extraRequests;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "wrap " + this.callToWrap.getMethodName() + " with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    WrapMethodCallScript(List<TargetMatcher> matchers, Hook callToWrap, Hook wrapper, boolean transplant, boolean insert, Set<StackRequest> extraRequests) {
        super(matchers);
        if (callToWrap == null) {
            throw new NullPointerException("callToWrap");
        }
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.leaveReturnValueIntact = wrapper.getMethodDescriptor().endsWith(")V") && (!callToWrap.getMethodDescriptor().endsWith(")V") || callToWrap.isConstructor());
        this.callToWrap = callToWrap;
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
        PatchScript$MethodPatcher patcher = new PatchScript$MethodPatcher(writer, transplantMapper, new WrapMethodCallScript$1(this, classSpec));
        if (this.transplant) {
            patcher.addTransplant(this.wrapper);
        }
        return patcher;
    }
}
