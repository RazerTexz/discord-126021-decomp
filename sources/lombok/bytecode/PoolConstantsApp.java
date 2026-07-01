package lombok.bytecode;

import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import java.io.File;
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

    @Override // lombok.core.LombokApp
    public int runApp(List<String> raw) throws Exception {
        CmdReader<PoolConstantsApp$CmdArgs> reader = CmdReader.of(PoolConstantsApp$CmdArgs.class);
        try {
            PoolConstantsApp$CmdArgs args = reader.make((String[]) raw.toArray(new String[0]));
            if (args.help) {
                System.out.println(reader.generateCommandLineHelp("java -jar lombok.jar -printpool"));
                return 0;
            }
            List<File> filesToProcess = PostCompilerApp.cmdArgsToFiles(PoolConstantsApp$CmdArgs.access$0(args));
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
        } catch (InvalidCommandLineException e) {
            System.err.println(e.getMessage());
            System.err.println(reader.generateCommandLineHelp("java -jar lombok.jar -printpool"));
            return 1;
        }
    }
}
