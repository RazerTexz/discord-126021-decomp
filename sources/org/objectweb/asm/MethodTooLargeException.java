package org.objectweb.asm;

/* JADX WARN: Classes with same name are omitted, all sources:
  classes3.dex
  discord-126021.apk:org/objectweb/asm/MethodTooLargeException.SCL.lombok
 */
/* JADX INFO: loaded from: classes3.dex */
public final class MethodTooLargeException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 6807380416709738314L;
    private final String className;
    private final int codeSize;
    private final String descriptor;
    private final String methodName;

    public MethodTooLargeException(String str, String str2, String str3, int i) {
        super("Method too large: " + str + "." + str2 + " " + str3);
        this.className = str;
        this.methodName = str2;
        this.descriptor = str3;
        this.codeSize = i;
    }
}
