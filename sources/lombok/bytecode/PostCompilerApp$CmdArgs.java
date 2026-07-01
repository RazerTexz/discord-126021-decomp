package lombok.bytecode;

import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PostCompilerApp$CmdArgs.SCL.lombok */
public class PostCompilerApp$CmdArgs {

    @Mandatory
    @Description("paths to class files to be converted. If a directory is named, all files (recursively) in that directory will be converted.")
    @Sequential
    private List<String> classFiles = new ArrayList();

    @Description("Prints lots of status information as the post compiler runs")
    @Shorthand({"v"})
    boolean verbose = false;

    @Description("Shows this help text")
    @Shorthand({"h", "?"})
    boolean help = false;

    static /* synthetic */ List access$0(PostCompilerApp$CmdArgs postCompilerApp$CmdArgs) {
        return postCompilerApp$CmdArgs.classFiles;
    }
}
