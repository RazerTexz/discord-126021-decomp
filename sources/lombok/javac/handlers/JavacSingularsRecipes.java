package lombok.javac.handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.ConfigurationKeys;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacSingularsRecipes.SCL.lombok */
public class JavacSingularsRecipes {
    private static final JavacSingularsRecipes INSTANCE = new JavacSingularsRecipes();
    private final Map<String, JavacSingularsRecipes$JavacSingularizer> singularizers = new HashMap();
    private final TypeLibrary singularizableTypes = new TypeLibrary();

    private JavacSingularsRecipes() {
        try {
            loadAll(this.singularizableTypes, this.singularizers);
            this.singularizableTypes.lock();
        } catch (IOException e) {
            System.err.println("Lombok's @Singularizable feature is broken due to misconfigured SPI files: " + e);
        }
    }

    private static void loadAll(TypeLibrary library, Map<String, JavacSingularsRecipes$JavacSingularizer> map) throws IOException {
        for (JavacSingularsRecipes$JavacSingularizer handler : SpiLoadUtil.findServices(JavacSingularsRecipes$JavacSingularizer.class, JavacSingularsRecipes$JavacSingularizer.class.getClassLoader())) {
            for (String type : handler.getSupportedTypes()) {
                JavacSingularsRecipes$JavacSingularizer existingSingularizer = map.get(type);
                if (existingSingularizer != null) {
                    JavacSingularsRecipes$JavacSingularizer toKeep = existingSingularizer.getClass().getName().compareTo(handler.getClass().getName()) > 0 ? handler : existingSingularizer;
                    System.err.println("Multiple singularizers found for type " + type + "; the alphabetically first class is used: " + toKeep.getClass().getName());
                    map.put(type, toKeep);
                } else {
                    map.put(type, handler);
                    library.addType(type);
                }
            }
        }
    }

    public static JavacSingularsRecipes get() {
        return INSTANCE;
    }

    public String toQualified(String typeReference) {
        List<String> q = this.singularizableTypes.toQualifieds(typeReference);
        if (q.isEmpty()) {
            return null;
        }
        return q.get(0);
    }

    public JavacSingularsRecipes$JavacSingularizer getSingularizer(String fqn, JavacNode node) {
        JavacSingularsRecipes$JavacSingularizer singularizer = this.singularizers.get(fqn);
        boolean useGuavaInstead = Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.SINGULAR_USE_GUAVA));
        return useGuavaInstead ? singularizer.getGuavaInstead(node) : singularizer;
    }
}
