package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.util.ArrayList;
import lombok.Builder$ObtainVia;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleBuilder$BuilderFieldData.SCL.lombok */
class HandleBuilder$BuilderFieldData {
    List<JCTree$JCAnnotation> annotations;
    JCTree$JCExpression type;
    Name rawName;
    Name name;
    Name builderFieldName;
    Name nameOfDefaultProvider;
    Name nameOfSetFlag;
    JavacSingularsRecipes$SingularData singularData;
    Builder$ObtainVia obtainVia;
    JavacNode obtainViaNode;
    JavacNode originalFieldNode;
    java.util.List<JavacNode> createdFields = new ArrayList();

    HandleBuilder$BuilderFieldData() {
    }
}
