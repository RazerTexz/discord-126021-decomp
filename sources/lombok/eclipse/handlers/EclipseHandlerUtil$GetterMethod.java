package lombok.eclipse.handlers;

import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$GetterMethod.SCL.lombok */
class EclipseHandlerUtil$GetterMethod {
    private final char[] name;
    private final TypeReference type;

    static /* synthetic */ char[] access$1(EclipseHandlerUtil$GetterMethod eclipseHandlerUtil$GetterMethod) {
        return eclipseHandlerUtil$GetterMethod.name;
    }

    static /* synthetic */ TypeReference access$0(EclipseHandlerUtil$GetterMethod eclipseHandlerUtil$GetterMethod) {
        return eclipseHandlerUtil$GetterMethod.type;
    }

    EclipseHandlerUtil$GetterMethod(char[] name, TypeReference type) {
        this.name = name;
        this.type = type;
    }
}
