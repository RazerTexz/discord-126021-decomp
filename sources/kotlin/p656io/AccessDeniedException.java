package kotlin.p656io;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AccessDeniedException extends FileSystemException {
    public /* synthetic */ AccessDeniedException(File file, File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessDeniedException(File file, File file2, String str) {
        super(file, file2, str);
        C12238m.checkNotNullParameter(file, "file");
    }
}
