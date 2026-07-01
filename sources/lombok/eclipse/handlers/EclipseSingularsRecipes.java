package lombok.eclipse.handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes.SCL.lombok */
public class EclipseSingularsRecipes {
    private static final EclipseSingularsRecipes INSTANCE = new EclipseSingularsRecipes();
    private final Map<String, EclipseSingularsRecipes$EclipseSingularizer> singularizers = new HashMap();
    private final TypeLibrary singularizableTypes = new TypeLibrary();

    private EclipseSingularsRecipes() {
        try {
            loadAll(this.singularizableTypes, this.singularizers);
            this.singularizableTypes.lock();
        } catch (IOException e) {
            System.err.println("Lombok's @Singularizable feature is broken due to misconfigured SPI files: " + e);
        }
    }

    private static void loadAll(TypeLibrary library, Map<String, EclipseSingularsRecipes$EclipseSingularizer> map) throws IOException {
        for (EclipseSingularsRecipes$EclipseSingularizer handler : SpiLoadUtil.findServices(EclipseSingularsRecipes$EclipseSingularizer.class, EclipseSingularsRecipes$EclipseSingularizer.class.getClassLoader())) {
            for (String type : handler.getSupportedTypes()) {
                EclipseSingularsRecipes$EclipseSingularizer existingSingularizer = map.get(type);
                if (existingSingularizer != null) {
                    EclipseSingularsRecipes$EclipseSingularizer toKeep = existingSingularizer.getClass().getName().compareTo(handler.getClass().getName()) > 0 ? handler : existingSingularizer;
                    System.err.println("Multiple singularizers found for type " + type + "; the alphabetically first class is used: " + toKeep.getClass().getName());
                    map.put(type, toKeep);
                } else {
                    map.put(type, handler);
                    library.addType(type);
                }
            }
        }
    }

    public static EclipseSingularsRecipes get() {
        return INSTANCE;
    }

    public String toQualified(String typeReference) {
        List<String> q = this.singularizableTypes.toQualifieds(typeReference);
        if (q.isEmpty()) {
            return null;
        }
        return q.get(0);
    }

    public EclipseSingularsRecipes$EclipseSingularizer getSingularizer(String fqn) {
        return this.singularizers.get(fqn);
    }
}
