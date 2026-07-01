package lombok.core.configuration;

import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Excludes;
import com.zwitserloot.cmdreader.FullName;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Requires;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp$CmdArgs.SCL.lombok */
public class ConfigurationApp$CmdArgs {

    @Mandatory(onlyIfNot = {"help", "generate"})
    @Description("Paths to java files or directories the configuration is to be printed for.")
    @Sequential
    private List<String> paths = new ArrayList();

    @Excludes({"paths"})
    @Description("Generates a list containing all the available configuration parameters. Add --verbose to print more information.")
    @Shorthand({"g"})
    boolean generate = false;

    @Description("Displays more information.")
    @Shorthand({"v"})
    boolean verbose = false;

    @Requires({"verbose"})
    @Description("Also display files that don't mention the key.")
    @Shorthand({"n"})
    @FullName("not-mentioned")
    boolean notMentioned = false;

    @Description("Limit the result to these keys.")
    @Shorthand({"k"})
    private List<String> key = new ArrayList();

    @Description("Shows this help text.")
    @Shorthand({"h", "?"})
    boolean help = false;

    static /* synthetic */ List access$1(ConfigurationApp$CmdArgs configurationApp$CmdArgs) {
        return configurationApp$CmdArgs.paths;
    }

    static /* synthetic */ List access$0(ConfigurationApp$CmdArgs configurationApp$CmdArgs) {
        return configurationApp$CmdArgs.key;
    }
}
