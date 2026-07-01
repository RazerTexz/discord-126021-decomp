package lombok.patcher;

import java.util.LinkedList;

/* JADX INFO: loaded from: app.apk:lombok/patcher/Symbols$1.SCL.lombok */
class Symbols$1 extends ThreadLocal<LinkedList<String>> {
    @Override // java.lang.ThreadLocal
    protected /* bridge */ /* synthetic */ LinkedList<String> initialValue() {
        return initialValue();
    }

    Symbols$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.ThreadLocal
    protected LinkedList<String> initialValue() {
        return new LinkedList<>();
    }
}
