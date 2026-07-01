package lombok.installer;

import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/installer/Installer$CmdArgs.SCL.lombok */
class Installer$CmdArgs {

    @Description("Specify paths to a location to install/uninstall. Use 'auto' to apply to all automatically discoverable installations.")
    @Sequential
    List<String> path = new ArrayList();

    @Description("Shows this help text")
    @Shorthand({"h", "?"})
    boolean help;

    private Installer$CmdArgs() {
    }
}
