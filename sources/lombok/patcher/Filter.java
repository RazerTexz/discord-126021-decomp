package lombok.patcher;

import java.security.ProtectionDomain;

/* JADX INFO: loaded from: app.apk:lombok/patcher/Filter.SCL.lombok */
public interface Filter {
    public static final Filter ALWAYS = new Filter() { // from class: lombok.patcher.Filter.1
        @Override // lombok.patcher.Filter
        public boolean shouldTransform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            return true;
        }
    };

    boolean shouldTransform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr);
}
