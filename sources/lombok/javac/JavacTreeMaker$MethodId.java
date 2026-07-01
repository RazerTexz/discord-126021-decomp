package lombok.javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$MethodId.SCL.lombok */
final class JavacTreeMaker$MethodId<J> {
    private final Class<?> owner;
    private final String name;
    private final Class<J> returnType;
    private final Class<?>[] paramTypes;

    static /* synthetic */ Class access$1(JavacTreeMaker$MethodId javacTreeMaker$MethodId) {
        return javacTreeMaker$MethodId.owner;
    }

    static /* synthetic */ String access$2(JavacTreeMaker$MethodId javacTreeMaker$MethodId) {
        return javacTreeMaker$MethodId.name;
    }

    static /* synthetic */ Class access$0(JavacTreeMaker$MethodId javacTreeMaker$MethodId) {
        return javacTreeMaker$MethodId.returnType;
    }

    static /* synthetic */ Class[] access$3(JavacTreeMaker$MethodId javacTreeMaker$MethodId) {
        return javacTreeMaker$MethodId.paramTypes;
    }

    JavacTreeMaker$MethodId(Class<?> owner, String name, Class<J> returnType, Class<?>... clsArr) {
        this.owner = owner;
        this.name = name;
        this.paramTypes = clsArr;
        this.returnType = returnType;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.returnType.getName()).append(" ").append(this.owner.getName()).append(".").append(this.name).append("(");
        boolean f = true;
        for (Class<?> p : this.paramTypes) {
            if (f) {
                f = false;
            } else {
                out.append(", ");
            }
            out.append(p.getName());
        }
        return out.append(")").toString();
    }
}
