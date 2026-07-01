package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder$ObtainVia;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleBuilder$BuilderFieldData.SCL.lombok */
class HandleBuilder$BuilderFieldData {
    Annotation[] annotations;
    TypeReference type;
    char[] rawName;
    char[] name;
    char[] builderFieldName;
    char[] nameOfDefaultProvider;
    char[] nameOfSetFlag;
    EclipseSingularsRecipes$SingularData singularData;
    Builder$ObtainVia obtainVia;
    EclipseNode obtainViaNode;
    EclipseNode originalFieldNode;
    List<EclipseNode> createdFields = new ArrayList();

    HandleBuilder$BuilderFieldData() {
    }
}
