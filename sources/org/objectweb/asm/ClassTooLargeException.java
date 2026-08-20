package org.objectweb.asm;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX WARN: Classes with same name are omitted, all sources:
  classes3.dex
  discord-126021.apk:org/objectweb/asm/ClassTooLargeException.SCL.lombok
 */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassTooLargeException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 160715609518896765L;
    private final String className;
    private final int constantPoolCount;

    public ClassTooLargeException(String str, int i) {
        super(C1643a.m883w("Class too large: ", str));
        this.className = str;
        this.constantPoolCount = i;
    }
}
