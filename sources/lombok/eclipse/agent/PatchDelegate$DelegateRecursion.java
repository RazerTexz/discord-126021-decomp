package lombok.eclipse.agent;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$DelegateRecursion.SCL.lombok */
class PatchDelegate$DelegateRecursion extends Throwable {
    final char[] type;
    final char[] member;

    public PatchDelegate$DelegateRecursion(char[] type, char[] member) {
        this.type = type;
        this.member = member;
    }
}
