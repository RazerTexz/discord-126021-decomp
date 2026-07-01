package lombok.patcher;

import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$MethodPatcherFactory.SCL.lombok */
public interface PatchScript$MethodPatcherFactory {
    MethodVisitor createMethodVisitor(String str, String str2, MethodVisitor methodVisitor, MethodLogistics methodLogistics);
}
