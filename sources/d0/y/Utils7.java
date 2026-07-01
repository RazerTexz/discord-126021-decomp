package d0.y;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.io.File;

/* JADX INFO: renamed from: d0.y.h, reason: use source file name */
/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Utils7 extends FileTreeWalk3 {
    public static final boolean deleteRecursively(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$deleteRecursively");
        while (true) {
            boolean z2 = true;
            for (File file2 : FileTreeWalk3.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z2) {
                    }
                }
                z2 = false;
            }
            return z2;
        }
    }

    public static final String getExtension(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$extension");
        String name = file.getName();
        Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Strings4.substringAfterLast(name, '.', "");
    }
}
