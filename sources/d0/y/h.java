package d0.y;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.w;
import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public class h extends g {
    public static final boolean deleteRecursively(File file) {
        m.checkNotNullParameter(file, "$this$deleteRecursively");
        while (true) {
            boolean z2 = true;
            for (File file2 : g.walkBottomUp(file)) {
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
        m.checkNotNullParameter(file, "$this$extension");
        String name = file.getName();
        m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return w.substringAfterLast(name, '.', "");
    }
}
