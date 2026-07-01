package lombok.launch;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$LombokDeps.SCL.lombok */
public final class PatchFixesHider$LombokDeps {
    public static final Method ADD_LOMBOK_NOTES;
    public static final Method POST_COMPILER_BYTES_STRING;
    public static final Method POST_COMPILER_OUTPUTSTREAM;
    public static final Method POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING;

    static {
        Class<?> shadowed = PatchFixesHider$Util.shadowLoadClass("lombok.eclipse.agent.PatchFixesShadowLoaded");
        ADD_LOMBOK_NOTES = PatchFixesHider$Util.findMethod(shadowed, "addLombokNotesToEclipseAboutDialog", String.class, String.class);
        POST_COMPILER_BYTES_STRING = PatchFixesHider$Util.findMethod(shadowed, "runPostCompiler", byte[].class, String.class);
        POST_COMPILER_OUTPUTSTREAM = PatchFixesHider$Util.findMethod(shadowed, "runPostCompiler", OutputStream.class);
        POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING = PatchFixesHider$Util.findMethod(shadowed, "runPostCompiler", BufferedOutputStream.class, String.class, String.class);
    }

    public static String addLombokNotesToEclipseAboutDialog(String origReturnValue, String key) {
        try {
            return (String) PatchFixesHider$Util.invokeMethod(ADD_LOMBOK_NOTES, origReturnValue, key);
        } catch (Throwable unused) {
            return origReturnValue;
        }
    }

    public static byte[] runPostCompiler(byte[] bytes, String fileName) {
        return (byte[]) PatchFixesHider$Util.invokeMethod(POST_COMPILER_BYTES_STRING, bytes, fileName);
    }

    public static OutputStream runPostCompiler(OutputStream out) throws IOException {
        return (OutputStream) PatchFixesHider$Util.invokeMethod(POST_COMPILER_OUTPUTSTREAM, out);
    }

    public static BufferedOutputStream runPostCompiler(BufferedOutputStream out, String path, String name) throws IOException {
        return (BufferedOutputStream) PatchFixesHider$Util.invokeMethod(POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING, out, path, name);
    }
}
