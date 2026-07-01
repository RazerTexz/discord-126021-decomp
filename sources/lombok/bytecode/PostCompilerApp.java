package lombok.bytecode;

import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.core.DiagnosticsReceiver;
import lombok.core.LombokApp;
import lombok.core.PostCompiler;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PostCompilerApp.SCL.lombok */
public class PostCompilerApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("post", "postcompile");
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Runs registered post compiler handlers to against existing class files, modifying them in the process.";
    }

    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "post-compile";
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> raw) throws Exception {
        CmdReader<PostCompilerApp$CmdArgs> reader = CmdReader.of(PostCompilerApp$CmdArgs.class);
        try {
            PostCompilerApp$CmdArgs args = reader.make((String[]) raw.toArray(new String[0]));
            if (args.help) {
                System.out.println(reader.generateCommandLineHelp("java -jar lombok.jar post-compile"));
                return 0;
            }
            int filesVisited = 0;
            int filesTouched = 0;
            for (File file : cmdArgsToFiles(PostCompilerApp$CmdArgs.access$0(args))) {
                if (!file.exists() || !file.isFile()) {
                    System.out.printf("Cannot find file '%s'\n", file);
                } else {
                    filesVisited++;
                    if (args.verbose) {
                        System.out.println("Processing " + file.getAbsolutePath());
                    }
                    byte[] original = readFile(file);
                    byte[] clone = (byte[]) original.clone();
                    byte[] transformed = PostCompiler.applyTransformations(clone, file.toString(), DiagnosticsReceiver.CONSOLE);
                    if (clone != transformed && !Arrays.equals(original, transformed)) {
                        filesTouched++;
                        if (args.verbose) {
                            System.out.println("Rewriting " + file.getAbsolutePath());
                        }
                        writeFile(file, transformed);
                    }
                }
            }
            if (args.verbose) {
                System.out.printf("Total files visited: %d total files changed: %d\n", Integer.valueOf(filesVisited), Integer.valueOf(filesTouched));
            }
            return filesVisited == 0 ? 1 : 0;
        } catch (InvalidCommandLineException e) {
            System.err.println(e.getMessage());
            System.err.println(reader.generateCommandLineHelp("java -jar lombok.jar post-compile"));
            return 1;
        }
    }

    static List<File> cmdArgsToFiles(List<String> fileNames) {
        List<File> filesToProcess = new ArrayList<>();
        for (String f : fileNames) {
            addFiles(filesToProcess, f);
        }
        return filesToProcess;
    }

    static void addFiles(List<File> filesToProcess, String f) {
        File file = new File(f);
        if (file.isDirectory()) {
            addRecursively(filesToProcess, file);
        } else {
            filesToProcess.add(file);
        }
    }

    static void addRecursively(List<File> filesToProcess, File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                addRecursively(filesToProcess, f);
            } else if (f.getName().endsWith(".class")) {
                filesToProcess.add(f);
            }
        }
    }

    static byte[] readFile(File file) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(buffer);
                if (read != -1) {
                    bytes.write(buffer, 0, read);
                } else {
                    fileInputStream.close();
                    return bytes.toByteArray();
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
    }

    static void writeFile(File file, byte[] transformed) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        try {
            out.write(transformed);
        } finally {
            out.close();
        }
    }
}
