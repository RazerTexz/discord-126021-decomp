package kotlin.io;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.y.c;
import d0.z.d.m;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(c.access$constructMessage(file, file2, str));
        m.checkNotNullParameter(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
