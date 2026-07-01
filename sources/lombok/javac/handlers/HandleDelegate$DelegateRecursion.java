package lombok.javac.handlers;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate$DelegateRecursion.SCL.lombok */
class HandleDelegate$DelegateRecursion extends Throwable {
    final String type;
    final String member;

    public HandleDelegate$DelegateRecursion(String type, String member) {
        this.type = type;
        this.member = member;
    }
}
