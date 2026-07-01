package lombok.bytecode;

import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PoolConstantsApp$CmdArgs.SCL.lombok */
public class PoolConstantsApp$CmdArgs {

    @Mandatory
    @Description("paths to class files to be printed. If a directory is named, all files (recursively) in that directory will be printed.")
    @Sequential
    private List<String> classFiles = new ArrayList();

    @Description("Shows this help text")
    @Shorthand({"h", "?"})
    boolean help = false;

    static /* synthetic */ List access$0(PoolConstantsApp$CmdArgs poolConstantsApp$CmdArgs) {
        return poolConstantsApp$CmdArgs.classFiles;
    }
}
