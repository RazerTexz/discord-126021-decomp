package p507d0.p591y;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.File;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.y.h */
/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12207h extends C12206g {
    public static final boolean deleteRecursively(File file) {
        C12238m.checkNotNullParameter(file, "$this$deleteRecursively");
        while (true) {
            boolean z2 = true;
            for (File file2 : C12206g.walkBottomUp(file)) {
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
        C12238m.checkNotNullParameter(file, "$this$extension");
        String name = file.getName();
        C12238m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12106w.substringAfterLast(name, '.', "");
    }
}
