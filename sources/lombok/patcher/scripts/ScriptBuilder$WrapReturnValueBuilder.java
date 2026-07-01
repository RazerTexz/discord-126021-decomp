package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$WrapReturnValueBuilder.SCL.lombok */
public class ScriptBuilder$WrapReturnValueBuilder {
    private Hook wrapMethod;
    private boolean transplant;
    private boolean insert;
    private boolean cast;
    private List<TargetMatcher> matchers = new ArrayList();
    private Set<StackRequest> requests = new HashSet();

    public WrapReturnValuesScript build() {
        if (this.matchers.isEmpty()) {
            throw new IllegalStateException("You have to set a target method matcher");
        }
        if (this.wrapMethod == null) {
            throw new IllegalStateException("You have to set a method you'd like to wrap the return values with");
        }
        return new WrapReturnValuesScript(this.matchers, this.wrapMethod, this.transplant, this.insert, this.cast, this.requests);
    }

    public ScriptBuilder$WrapReturnValueBuilder target(TargetMatcher matcher) {
        this.matchers.add(matcher);
        return this;
    }

    public ScriptBuilder$WrapReturnValueBuilder wrapMethod(Hook hook) {
        this.wrapMethod = hook;
        return this;
    }

    public ScriptBuilder$WrapReturnValueBuilder transplant() {
        this.transplant = true;
        this.insert = false;
        return this;
    }

    public ScriptBuilder$WrapReturnValueBuilder insert() {
        if (this.cast) {
            throw new IllegalArgumentException("cast and insert are mutually exlusive");
        }
        this.transplant = false;
        this.insert = true;
        return this;
    }

    public ScriptBuilder$WrapReturnValueBuilder cast() {
        if (this.insert) {
            throw new IllegalArgumentException("insert and cast are mutually exlusive");
        }
        this.cast = true;
        return this;
    }

    public ScriptBuilder$WrapReturnValueBuilder request(StackRequest... requests) {
        for (StackRequest r : requests) {
            this.requests.add(r);
        }
        return this;
    }
}
