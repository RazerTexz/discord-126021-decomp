package b.b.a.g;

import android.net.Uri;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import java.io.File;

/* JADX INFO: renamed from: b.b.a.g.a, reason: use source file name */
/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileUtils {
    public static final Attachment<File> a(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$toAttachment");
        long jHashCode = file.hashCode();
        Uri uriFromFile = Uri.fromFile(file);
        Intrinsics3.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(this)");
        String name = file.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "this.name");
        return new Attachment<>(jHashCode, uriFromFile, name, file, false, 16, null);
    }
}
