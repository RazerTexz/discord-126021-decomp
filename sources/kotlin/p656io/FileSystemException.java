package kotlin.p656io;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.File;
import java.io.IOException;
import p507d0.p591y.C12202c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(C12202c.access$constructMessage(file, file2, str));
        C12238m.checkNotNullParameter(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
