package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder.SCL.lombok */
public class ScriptBuilder {
    private ScriptBuilder() throws NoSuchMethodException {
        throw new NoSuchMethodException("ScriptBuilder cannot be instantiated - just use the static methods.");
    }

    private static void checkTypeSyntaxSlash(String spec) {
        if (spec.indexOf(46) > -1) {
            throw new IllegalArgumentException("Your type specification includes a dot, but this method wants a slash-separated type specification");
        }
    }

    private static void checkTypeSyntaxDot(String spec) {
        if (spec.indexOf(47) > -1) {
            throw new IllegalArgumentException("Your type specification includes a slash, but this method wants a dot-separated type specification");
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$AddFieldBuilder.SCL.lombok */
    public static class AddFieldBuilder {
        private int accessFlags;
        private List<String> targetClasses = new ArrayList();
        private String fieldName;
        private String fieldType;
        private Object value;
        private static final int NO_ACCESS_LEVELS = -4;

        public AddFieldScript build() {
            if (this.targetClasses.isEmpty()) {
                throw new IllegalStateException("You have to set at least one targetClass.");
            }
            if (this.fieldName == null) {
                throw new IllegalStateException("You have to set a fieldName");
            }
            if (this.fieldType == null) {
                throw new IllegalStateException("You have to set the new field's type by calling fieldType");
            }
            if (this.value != null) {
                setStatic();
                setFinal();
            }
            return new AddFieldScript(this.targetClasses, this.accessFlags, this.fieldName, this.fieldType, this.value);
        }

        public AddFieldBuilder targetClass(String targetClass) {
            ScriptBuilder.checkTypeSyntaxDot(targetClass);
            this.targetClasses.add(targetClass);
            return this;
        }

        public AddFieldBuilder value(Object value) {
            this.value = value;
            return this;
        }

        public AddFieldBuilder fieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public AddFieldBuilder fieldType(String fieldType) {
            ScriptBuilder.checkTypeSyntaxSlash(fieldType);
            this.fieldType = fieldType;
            return this;
        }

        public AddFieldBuilder setPublic() {
            this.accessFlags = (this.accessFlags & (-4)) | 1;
            return this;
        }

        public AddFieldBuilder setPrivate() {
            this.accessFlags = (this.accessFlags & (-4)) | 2;
            return this;
        }

        public AddFieldBuilder setProtected() {
            this.accessFlags = (this.accessFlags & (-4)) | 4;
            return this;
        }

        public AddFieldBuilder setPackageAccess() {
            this.accessFlags &= -4;
            return this;
        }

        public AddFieldBuilder setStatic() {
            this.accessFlags |= 8;
            return this;
        }

        public AddFieldBuilder setFinal() {
            this.accessFlags |= 16;
            return this;
        }

        public AddFieldBuilder setVolatile() {
            this.accessFlags |= 64;
            return this;
        }

        public AddFieldBuilder setTransient() {
            this.accessFlags |= 128;
            return this;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$ExitEarlyBuilder.SCL.lombok */
    public static class ExitEarlyBuilder {
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

        public ExitEarlyBuilder target(TargetMatcher matcher) {
            this.matchers.add(matcher);
            return this;
        }

        public ExitEarlyBuilder decisionMethod(Hook hook) {
            this.decisionMethod = hook;
            return this;
        }

        public ExitEarlyBuilder valueMethod(Hook hook) {
            this.valueMethod = hook;
            return this;
        }

        public ExitEarlyBuilder transplant() {
            this.transplant = true;
            this.insert = false;
            return this;
        }

        public ExitEarlyBuilder insert() {
            this.transplant = false;
            this.insert = true;
            return this;
        }

        public ExitEarlyBuilder request(StackRequest... requests) {
            for (StackRequest r : requests) {
                if (r == StackRequest.RETURN_VALUE) {
                    throw new IllegalArgumentException("You cannot ask for the tentative return value in ExitFromMethodEarlyScript");
                }
                this.requests.add(r);
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$ReplaceMethodCallBuilder.SCL.lombok */
    public static class ReplaceMethodCallBuilder {
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

        public ReplaceMethodCallBuilder target(TargetMatcher matcher) {
            this.matchers.add(matcher);
            return this;
        }

        public ReplaceMethodCallBuilder replacementMethod(Hook hook) {
            this.replacementMethod = hook;
            return this;
        }

        public ReplaceMethodCallBuilder methodToReplace(Hook hook) {
            this.methodToReplace = hook;
            return this;
        }

        public ReplaceMethodCallBuilder transplant() {
            this.transplant = true;
            this.insert = false;
            return this;
        }

        public ReplaceMethodCallBuilder insert() {
            this.transplant = false;
            this.insert = true;
            return this;
        }

        public ReplaceMethodCallBuilder requestExtra(StackRequest... requests) {
            for (StackRequest r : requests) {
                if (r == StackRequest.RETURN_VALUE) {
                    throw new IllegalArgumentException("You cannot ask for the tentative return value in ReplaceMethodCallScript");
                }
                this.extraRequests.add(r);
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$WrapMethodCallBuilder.SCL.lombok */
    public static class WrapMethodCallBuilder {
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

        public WrapMethodCallBuilder target(TargetMatcher matcher) {
            this.matchers.add(matcher);
            return this;
        }

        public WrapMethodCallBuilder wrapMethod(Hook hook) {
            this.wrapMethod = hook;
            return this;
        }

        public WrapMethodCallBuilder methodToWrap(Hook hook) {
            this.methodToWrap = hook;
            return this;
        }

        public WrapMethodCallBuilder transplant() {
            this.transplant = true;
            this.insert = false;
            return this;
        }

        public WrapMethodCallBuilder insert() {
            this.transplant = false;
            this.insert = true;
            return this;
        }

        public WrapMethodCallBuilder requestExtra(StackRequest... requests) {
            for (StackRequest r : requests) {
                if (r == StackRequest.RETURN_VALUE) {
                    throw new IllegalArgumentException("You cannot ask for the tentative return value in WrapMethodCallBuilder");
                }
                this.extraRequests.add(r);
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$WrapReturnValueBuilder.SCL.lombok */
    public static class WrapReturnValueBuilder {
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

        public WrapReturnValueBuilder target(TargetMatcher matcher) {
            this.matchers.add(matcher);
            return this;
        }

        public WrapReturnValueBuilder wrapMethod(Hook hook) {
            this.wrapMethod = hook;
            return this;
        }

        public WrapReturnValueBuilder transplant() {
            this.transplant = true;
            this.insert = false;
            return this;
        }

        public WrapReturnValueBuilder insert() {
            if (this.cast) {
                throw new IllegalArgumentException("cast and insert are mutually exlusive");
            }
            this.transplant = false;
            this.insert = true;
            return this;
        }

        public WrapReturnValueBuilder cast() {
            if (this.insert) {
                throw new IllegalArgumentException("insert and cast are mutually exlusive");
            }
            this.cast = true;
            return this;
        }

        public WrapReturnValueBuilder request(StackRequest... requests) {
            for (StackRequest r : requests) {
                this.requests.add(r);
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$SetSymbolDuringMethodCallBuilder.SCL.lombok */
    public static class SetSymbolDuringMethodCallBuilder {
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

        public SetSymbolDuringMethodCallBuilder target(TargetMatcher matcher) {
            this.matchers.add(matcher);
            return this;
        }

        public SetSymbolDuringMethodCallBuilder callToWrap(Hook callToWrap) {
            this.callToWrap = callToWrap;
            return this;
        }

        public SetSymbolDuringMethodCallBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public SetSymbolDuringMethodCallBuilder report() {
            this.report = true;
            return this;
        }
    }

    public static AddFieldBuilder addField() {
        return new AddFieldBuilder();
    }

    public static ExitEarlyBuilder exitEarly() {
        return new ExitEarlyBuilder();
    }

    public static ReplaceMethodCallBuilder replaceMethodCall() {
        return new ReplaceMethodCallBuilder();
    }

    public static WrapMethodCallBuilder wrapMethodCall() {
        return new WrapMethodCallBuilder();
    }

    public static WrapReturnValueBuilder wrapReturnValue() {
        return new WrapReturnValueBuilder();
    }

    public static SetSymbolDuringMethodCallBuilder setSymbolDuringMethodCall() {
        return new SetSymbolDuringMethodCallBuilder();
    }
}
