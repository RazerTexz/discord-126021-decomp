package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$ReplaceMethodCallBuilder.SCL.lombok */
public class ScriptBuilder$ReplaceMethodCallBuilder {
    private Hook replacementMethod;
    private Hook methodToReplace;
    private boolean transplant;
    private boolean insert;
    private List<TargetMatcher> matchers = new ArrayList();
    private Set<StackRequest> extraRequests = new HashSet();

    public ReplaceMethodCallScript build() {
        if (this.matchers.isEmpty()) {
            throw new IllegalStateException("You have to set a target method matcher");
        }
        if (this.replacementMethod == null) {
            throw new IllegalStateException("You have to set a replacement method");
        }
        if (this.methodToReplace == null) {
            throw new IllegalStateException("You have to set a method call to replace");
        }
        return new ReplaceMethodCallScript(this.matchers, this.methodToReplace, this.replacementMethod, this.transplant, this.insert, this.extraRequests);
    }

    public ScriptBuilder$ReplaceMethodCallBuilder target(TargetMatcher matcher) {
        this.matchers.add(matcher);
        return this;
    }

    public ScriptBuilder$ReplaceMethodCallBuilder replacementMethod(Hook hook) {
        this.replacementMethod = hook;
        return this;
    }

    public ScriptBuilder$ReplaceMethodCallBuilder methodToReplace(Hook hook) {
        this.methodToReplace = hook;
        return this;
    }

    public ScriptBuilder$ReplaceMethodCallBuilder transplant() {
        this.transplant = true;
        this.insert = false;
        return this;
    }

    public ScriptBuilder$ReplaceMethodCallBuilder insert() {
        this.transplant = false;
        this.insert = true;
        return this;
    }

    public ScriptBuilder$ReplaceMethodCallBuilder requestExtra(StackRequest... requests) {
        for (StackRequest r : requests) {
            if (r == StackRequest.RETURN_VALUE) {
                throw new IllegalArgumentException("You cannot ask for the tentative return value in ReplaceMethodCallScript");
            }
            this.extraRequests.add(r);
        }
        return this;
    }
}
