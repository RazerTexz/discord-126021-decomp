package lombok.javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$FieldId.SCL.lombok */
final class JavacTreeMaker$FieldId<J> {
    private final Class<?> owner;
    private final String name;
    private final Class<J> fieldType;

    static /* synthetic */ Class access$1(JavacTreeMaker$FieldId javacTreeMaker$FieldId) {
        return javacTreeMaker$FieldId.owner;
    }

    static /* synthetic */ String access$2(JavacTreeMaker$FieldId javacTreeMaker$FieldId) {
        return javacTreeMaker$FieldId.name;
    }

    static /* synthetic */ Class access$0(JavacTreeMaker$FieldId javacTreeMaker$FieldId) {
        return javacTreeMaker$FieldId.fieldType;
    }

    JavacTreeMaker$FieldId(Class<?> owner, String name, Class<J> fieldType) {
        this.owner = owner;
        this.name = name;
        this.fieldType = fieldType;
    }
}
