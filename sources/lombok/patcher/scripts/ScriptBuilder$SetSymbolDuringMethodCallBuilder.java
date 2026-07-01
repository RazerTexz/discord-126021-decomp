package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.List;
import lombok.patcher.Hook;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$SetSymbolDuringMethodCallBuilder.SCL.lombok */
public class ScriptBuilder$SetSymbolDuringMethodCallBuilder {
    private List<TargetMatcher> matchers = new ArrayList();
    private Hook callToWrap;
    private String symbol;
    private boolean report;

    public SetSymbolDuringMethodCallScript build() {
        if (this.matchers.isEmpty()) {
            throw new IllegalStateException("You have to set a target method matcher");
        }
        if (this.callToWrap == null) {
            throw new IllegalStateException("You have to set a method that needs to set the symbol during its invocation");
        }
        if (this.symbol == null) {
            throw new IllegalStateException("You have to specify the symbol that is on the stack during callToWrap's invocation");
        }
        return new SetSymbolDuringMethodCallScript(this.matchers, this.callToWrap, this.symbol, this.report);
    }

    public ScriptBuilder$SetSymbolDuringMethodCallBuilder target(TargetMatcher matcher) {
        this.matchers.add(matcher);
        return this;
    }

    public ScriptBuilder$SetSymbolDuringMethodCallBuilder callToWrap(Hook callToWrap) {
        this.callToWrap = callToWrap;
        return this;
    }

    public ScriptBuilder$SetSymbolDuringMethodCallBuilder symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public ScriptBuilder$SetSymbolDuringMethodCallBuilder report() {
        this.report = true;
        return this;
    }
}
