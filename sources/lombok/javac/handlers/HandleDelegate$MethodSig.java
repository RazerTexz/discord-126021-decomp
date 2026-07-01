package lombok.javac.handlers;

import com.sun.tools.javac.util.Name;
import java.util.List;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ExecutableType;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate$MethodSig.SCL.lombok */
public class HandleDelegate$MethodSig {
    final Name name;
    final ExecutableType type;
    final boolean isDeprecated;
    final ExecutableElement elem;

    HandleDelegate$MethodSig(Name name, ExecutableType type, boolean isDeprecated, ExecutableElement elem) {
        this.name = name;
        this.type = type;
        this.isDeprecated = isDeprecated;
        this.elem = elem;
    }

    String[] getParameterNames() {
        List<? extends VariableElement> paramList = this.elem.getParameters();
        String[] paramNames = new String[paramList.size()];
        for (int i = 0; i < paramNames.length; i++) {
            paramNames[i] = ((VariableElement) paramList.get(i)).getSimpleName().toString();
        }
        return paramNames;
    }

    public String toString() {
        return String.valueOf(this.isDeprecated ? "@Deprecated " : "") + this.name + " " + this.type;
    }
}
