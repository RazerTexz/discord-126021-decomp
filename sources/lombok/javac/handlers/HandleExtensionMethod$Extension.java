package lombok.javac.handlers;

import com.sun.tools.javac.code.Symbol$MethodSymbol;
import com.sun.tools.javac.code.Symbol$TypeSymbol;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleExtensionMethod$Extension.SCL.lombok */
class HandleExtensionMethod$Extension {
    final List<Symbol$MethodSymbol> extensionMethods;
    final Symbol$TypeSymbol extensionProvider;

    public HandleExtensionMethod$Extension(List<Symbol$MethodSymbol> extensionMethods, Symbol$TypeSymbol extensionProvider) {
        this.extensionMethods = extensionMethods;
        this.extensionProvider = extensionProvider;
    }
}
