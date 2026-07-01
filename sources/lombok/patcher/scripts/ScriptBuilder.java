package lombok.patcher.scripts;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder.SCL.lombok */
public class ScriptBuilder {
    private ScriptBuilder() throws NoSuchMethodException {
        throw new NoSuchMethodException("ScriptBuilder cannot be instantiated - just use the static methods.");
    }

    static /* synthetic */ void access$1(String str) {
        checkTypeSyntaxSlash(str);
    }

    private static void checkTypeSyntaxSlash(String spec) {
        if (spec.indexOf(46) > -1) {
            throw new IllegalArgumentException("Your type specification includes a dot, but this method wants a slash-separated type specification");
        }
    }

    static /* synthetic */ void access$0(String str) {
        checkTypeSyntaxDot(str);
    }

    private static void checkTypeSyntaxDot(String spec) {
        if (spec.indexOf(47) > -1) {
            throw new IllegalArgumentException("Your type specification includes a slash, but this method wants a dot-separated type specification");
        }
    }

    public static ScriptBuilder$AddFieldBuilder addField() {
        return new ScriptBuilder$AddFieldBuilder();
    }

    public static ScriptBuilder$ExitEarlyBuilder exitEarly() {
        return new ScriptBuilder$ExitEarlyBuilder();
    }

    public static ScriptBuilder$ReplaceMethodCallBuilder replaceMethodCall() {
        return new ScriptBuilder$ReplaceMethodCallBuilder();
    }

    public static ScriptBuilder$WrapMethodCallBuilder wrapMethodCall() {
        return new ScriptBuilder$WrapMethodCallBuilder();
    }

    public static ScriptBuilder$WrapReturnValueBuilder wrapReturnValue() {
        return new ScriptBuilder$WrapReturnValueBuilder();
    }

    public static ScriptBuilder$SetSymbolDuringMethodCallBuilder setSymbolDuringMethodCall() {
        return new ScriptBuilder$SetSymbolDuringMethodCallBuilder();
    }
}
