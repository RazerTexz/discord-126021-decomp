package lombok.patcher;

import java.security.ProtectionDomain;

/* JADX INFO: loaded from: app.apk:lombok/patcher/Filter.SCL.lombok */
public interface Filter {
    public static final Filter ALWAYS = new Filter$1();

    boolean shouldTransform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr);
}
