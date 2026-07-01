package kotlin.io;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.y.Exceptions2;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: kotlin.io.FileSystemException, reason: use source file name */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Exceptions5 extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Exceptions5(File file, File file2, String str) {
        super(Exceptions2.access$constructMessage(file, file2, str));
        Intrinsics3.checkNotNullParameter(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
