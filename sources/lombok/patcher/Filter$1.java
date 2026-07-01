package lombok.patcher;

import java.security.ProtectionDomain;

/* JADX INFO: loaded from: app.apk:lombok/patcher/Filter$1.SCL.lombok */
class Filter$1 implements Filter {
    Filter$1() {
    }

    @Override // lombok.patcher.Filter
    public boolean shouldTransform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        return true;
    }
}
