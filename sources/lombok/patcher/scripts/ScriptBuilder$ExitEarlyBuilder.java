package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$ExitEarlyBuilder.SCL.lombok */
public class ScriptBuilder$ExitEarlyBuilder {
    private Hook decisionMethod;
    private Hook valueMethod;
    private boolean transplant;
    private boolean insert;
    private List<TargetMatcher> matchers = new ArrayList();
    private Set<StackRequest> requests = new HashSet();

    public ExitFromMethodEarlyScript build() {
        if (this.matchers.isEmpty()) {
            throw new IllegalStateException("You have to set a target method matcher");
        }
        return new ExitFromMethodEarlyScript(this.matchers, this.decisionMethod, this.valueMethod, this.transplant, this.insert, this.requests);
    }

    public ScriptBuilder$ExitEarlyBuilder target(TargetMatcher matcher) {
        this.matchers.add(matcher);
        return this;
    }

    public ScriptBuilder$ExitEarlyBuilder decisionMethod(Hook hook) {
        this.decisionMethod = hook;
        return this;
    }

    public ScriptBuilder$ExitEarlyBuilder valueMethod(Hook hook) {
        this.valueMethod = hook;
        return this;
    }

    public ScriptBuilder$ExitEarlyBuilder transplant() {
        this.transplant = true;
        this.insert = false;
        return this;
    }

    public ScriptBuilder$ExitEarlyBuilder insert() {
        this.transplant = false;
        this.insert = true;
        return this;
    }

    public ScriptBuilder$ExitEarlyBuilder request(StackRequest... requests) {
        for (StackRequest r : requests) {
            if (r == StackRequest.RETURN_VALUE) {
                throw new IllegalArgumentException("You cannot ask for the tentative return value in ExitFromMethodEarlyScript");
            }
            this.requests.add(r);
        }
        return this;
    }
}
