package lombok.bytecode;

import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.core.LombokApp;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PoolConstantsApp.SCL.lombok */
public class PoolConstantsApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "Xprintpool";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Prints the content of the constant pool to standard out.";
    }

    @Override // lombok.core.LombokApp
    public boolean isDebugTool() {
        return true;
    }

    /* JADX INFO: loaded from: app.apk:lombok/bytecode/PoolConstantsApp$CmdArgs.SCL.lombok */
    public static class CmdArgs {

        @Mandatory
        @Description("paths to class files to be printed. If a directory is named, all files (recursively) in that directory will be printed.")
        @Sequential
        private List<String> classFiles = new ArrayList();

        @Description("Shows this help text")
        @Shorthand({"h", "?"})
        boolean help = false;
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> raw) throws Exception {
        CmdReader<CmdArgs> reader = CmdReader.of(CmdArgs.class);
        try {
            CmdArgs args = reader.make((String[]) raw.toArray(new String[0]));
            if (!args.help) {
                List<File> filesToProcess = PostCompilerApp.cmdArgsToFiles(args.classFiles);
                int filesVisited = 0;
                boolean moreThanOne = filesToProcess.size() > 1;
                for (File file : filesToProcess) {
                    if (!file.exists() || !file.isFile()) {
                        System.out.printf("Cannot find file '%s'\n", file.getAbsolutePath());
                    } else {
                        filesVisited++;
                        if (moreThanOne) {
                            System.out.printf("Processing '%s'\n", file.getAbsolutePath());
                        }
                        System.out.println(new ClassFileMetaData(PostCompilerApp.readFile(file)).poolContent());
                    }
                }
                if (moreThanOne) {
                    System.out.printf("Total files visited: %d\n", Integer.valueOf(filesVisited));
                }
                return filesVisited == 0 ? 1 : 0;
            }
            System.out.println(reader.generateCommandLineHelp("java -jar lombok.jar -printpool"));
            return 0;
        } catch (InvalidCommandLineException e) {
            System.err.println(e.getMessage());
            System.err.println(reader.generateCommandLineHelp("java -jar lombok.jar -printpool"));
            return 1;
        }
    }
}
