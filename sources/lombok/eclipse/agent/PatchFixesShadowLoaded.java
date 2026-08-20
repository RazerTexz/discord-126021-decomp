package lombok.eclipse.agent;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import lombok.core.DiagnosticsReceiver;
import lombok.core.PostCompiler;
import lombok.core.Version;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchFixesShadowLoaded.SCL.lombok */
public class PatchFixesShadowLoaded {
    public static String addLombokNotesToEclipseAboutDialog(String origReturnValue, String key) {
        if ("aboutText".equals(key)) {
            return origReturnValue.contains(" is installed. https://projectlombok.org") ? origReturnValue : String.valueOf(origReturnValue) + "\n\nLombok " + Version.getFullVersion() + " is installed. https://projectlombok.org/";
        }
        return origReturnValue;
    }

    public static byte[] runPostCompiler(byte[] bytes, String fileName) {
        byte[] transformed = PostCompiler.applyTransformations(bytes, fileName, DiagnosticsReceiver.CONSOLE);
        return transformed == null ? bytes : transformed;
    }

    public static OutputStream runPostCompiler(OutputStream out) throws IOException {
        return PostCompiler.wrapOutputStream(out, "TEST", DiagnosticsReceiver.CONSOLE);
    }

    public static BufferedOutputStream runPostCompiler(BufferedOutputStream out, String path, String name) throws IOException {
        String fileName = String.valueOf(path) + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + name;
        return new BufferedOutputStream(PostCompiler.wrapOutputStream(out, fileName, DiagnosticsReceiver.CONSOLE));
    }
}
