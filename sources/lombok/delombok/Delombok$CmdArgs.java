package lombok.delombok;

import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Excludes;
import com.zwitserloot.cmdreader.FullName;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/delombok/Delombok$CmdArgs.SCL.lombok */
class Delombok$CmdArgs {

    @Excludes({"quiet"})
    @Description("Print the name of each file as it is being delombok-ed.")
    @Shorthand({"v"})
    private boolean verbose;

    @FullName("format-help")
    private boolean formatHelp;

    @Excludes({"verbose"})
    @Description("No warnings or errors will be emitted to standard error")
    @Shorthand({"q"})
    private boolean quiet;

    @Description("Sets the encoding of your source files. Defaults to the system default charset. Example: \"UTF-8\"")
    @Shorthand({"e"})
    private String encoding;

    @Description("Print delombok-ed code to standard output instead of saving it in target directory")
    @Shorthand({"p"})
    private boolean print;

    @Description("Directory to save delomboked files to")
    @Mandatory(onlyIfNot = {"print", "help", "format-help"})
    @Shorthand({"d"})
    private String target;

    @Description("Classpath (analogous to javac -cp option)")
    @Shorthand({"c"})
    private String classpath;

    @Description("Sourcepath (analogous to javac -sourcepath option)")
    @Shorthand({"s"})
    private String sourcepath;

    @Description("override Bootclasspath (analogous to javac -bootclasspath option)")
    private String bootclasspath;

    @Description("Module path (analogous to javac --module-path option)")
    @FullName("module-path")
    private String modulepath;

    @Description("Lombok will only delombok source files. Without this option, non-java, non-class files are copied to the target directory.")
    @Shorthand({"n"})
    private boolean nocopy;

    @Description("Output only changed files (implies -n)")
    private boolean onlyChanged;

    @Description("By default lombok enables preview features if available (introduced in JDK 12). With this option, lombok won't do that.")
    @FullName("disable-preview")
    private boolean disablePreview;
    private boolean help;

    @Description("Sets formatting rules. Use --format-help to list all available rules. Unset format rules are inferred by scanning the source for usages.")
    @Shorthand({"f"})
    private List<String> format = new ArrayList();

    @Description("Files to delombok. Provide either a file, or a directory. If you use a directory, all files in it (recursive) are delombok-ed")
    @Sequential
    private List<String> input = new ArrayList();

    private Delombok$CmdArgs() {
    }

    static /* synthetic */ boolean access$6(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.verbose;
    }

    static /* synthetic */ List access$4(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.format;
    }

    static /* synthetic */ boolean access$2(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.formatHelp;
    }

    static /* synthetic */ boolean access$3(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.quiet;
    }

    static /* synthetic */ String access$5(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.encoding;
    }

    static /* synthetic */ boolean access$10(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.print;
    }

    static /* synthetic */ String access$11(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.target;
    }

    static /* synthetic */ String access$12(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.classpath;
    }

    static /* synthetic */ String access$13(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.sourcepath;
    }

    static /* synthetic */ String access$14(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.bootclasspath;
    }

    static /* synthetic */ String access$15(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.modulepath;
    }

    static /* synthetic */ List access$1(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.input;
    }

    static /* synthetic */ boolean access$7(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.nocopy;
    }

    static /* synthetic */ boolean access$8(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.onlyChanged;
    }

    static /* synthetic */ boolean access$9(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.disablePreview;
    }

    static /* synthetic */ boolean access$0(Delombok$CmdArgs delombok$CmdArgs) {
        return delombok$CmdArgs.help;
    }
}
