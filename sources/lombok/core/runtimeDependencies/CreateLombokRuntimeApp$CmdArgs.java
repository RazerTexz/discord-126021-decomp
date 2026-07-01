package lombok.core.runtimeDependencies;

import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Requires;
import com.zwitserloot.cmdreader.Shorthand;

/* JADX INFO: loaded from: app.apk:lombok/core/runtimeDependencies/CreateLombokRuntimeApp$CmdArgs.SCL.lombok */
class CreateLombokRuntimeApp$CmdArgs {

    @Description("Prints those lombok transformations that require lombok-runtime.jar.")
    @Mandatory(onlyIfNot = {"create"})
    @Shorthand({"p"})
    boolean print;

    @Description("Creates the lombok-runtime.jar.")
    @Mandatory(onlyIfNot = {"print"})
    @Shorthand({"c"})
    boolean create;

    @Requires({"create"})
    @Description("Where to write the lombok-runtime.jar. Defaults to the current working directory.")
    @Shorthand({"o"})
    String output;

    @Description("Shows this help text")
    boolean help;

    private CreateLombokRuntimeApp$CmdArgs() {
    }
}
