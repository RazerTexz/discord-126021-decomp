package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import java.util.HashSet;
import java.util.Set;
import lombok.delombok.FormatPreferences;
import lombok.delombok.LombokOptionsFactory;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/LombokOptions.SCL.lombok */
public abstract class LombokOptions extends Options {
    private boolean deleteLombokAnnotations;
    private final Set<JCTree.JCCompilationUnit> changed;
    private FormatPreferences formatPreferences;

    public abstract void putJavacOption(String str, String str2);

    public boolean isChanged(JCTree.JCCompilationUnit ast) {
        return this.changed.contains(ast);
    }

    public void setFormatPreferences(FormatPreferences formatPreferences) {
        this.formatPreferences = formatPreferences;
    }

    public FormatPreferences getFormatPreferences() {
        return this.formatPreferences;
    }

    public static void markChanged(Context context, JCTree.JCCompilationUnit ast) {
        LombokOptions options = LombokOptionsFactory.getDelombokOptions(context);
        options.changed.add(ast);
    }

    public static boolean shouldDeleteLombokAnnotations(Context context) {
        LombokOptions options = LombokOptionsFactory.getDelombokOptions(context);
        return options.deleteLombokAnnotations;
    }

    protected LombokOptions(Context context) {
        super(context);
        this.deleteLombokAnnotations = false;
        this.changed = new HashSet();
        this.formatPreferences = new FormatPreferences(null);
    }

    public void deleteLombokAnnotations() {
        this.deleteLombokAnnotations = true;
    }
}
