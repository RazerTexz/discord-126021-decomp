package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$WrapMethodCallBuilder.SCL.lombok */
public class ScriptBuilder$WrapMethodCallBuilder {
    private Hook wrapMethod;
    private Hook methodToWrap;
    private boolean transplant;
    private boolean insert;
    private List<TargetMatcher> matchers = new ArrayList();
    private Set<StackRequest> extraRequests = new HashSet();

    public WrapMethodCallScript build() {
        if (this.matchers.isEmpty()) {
            throw new IllegalStateException("You have to set a target method matcher");
        }
        if (this.wrapMethod == null) {
            throw new IllegalStateException("You have to set method to wrap with");
        }
        if (this.methodToWrap == null) {
            throw new IllegalStateException("You have to set a method call to wrap");
        }
        return new WrapMethodCallScript(this.matchers, this.methodToWrap, this.wrapMethod, this.transplant, this.insert, this.extraRequests);
    }

    public ScriptBuilder$WrapMethodCallBuilder target(TargetMatcher matcher) {
        this.matchers.add(matcher);
        return this;
    }

    public ScriptBuilder$WrapMethodCallBuilder wrapMethod(Hook hook) {
        this.wrapMethod = hook;
        return this;
    }

    public ScriptBuilder$WrapMethodCallBuilder methodToWrap(Hook hook) {
        this.methodToWrap = hook;
        return this;
    }

    public ScriptBuilder$WrapMethodCallBuilder transplant() {
        this.transplant = true;
        this.insert = false;
        return this;
    }

    public ScriptBuilder$WrapMethodCallBuilder insert() {
        this.transplant = false;
        this.insert = true;
        return this;
    }

    public ScriptBuilder$WrapMethodCallBuilder requestExtra(StackRequest... requests) {
        for (StackRequest r : requests) {
            if (r == StackRequest.RETURN_VALUE) {
                throw new IllegalArgumentException("You cannot ask for the tentative return value in WrapMethodCallBuilder");
            }
            this.extraRequests.add(r);
        }
        return this;
    }
}
