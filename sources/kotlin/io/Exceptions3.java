package kotlin.io;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: kotlin.io.AccessDeniedException, reason: use source file name */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Exceptions3 extends Exceptions5 {
    public /* synthetic */ Exceptions3(File file, File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Exceptions3(File file, File file2, String str) {
        super(file, file2, str);
        Intrinsics3.checkNotNullParameter(file, "file");
    }
}
