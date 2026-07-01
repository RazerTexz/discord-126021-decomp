package b.b.a.g;

import android.net.Uri;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final Attachment<File> a(File file) {
        m.checkNotNullParameter(file, "$this$toAttachment");
        long jHashCode = file.hashCode();
        Uri uriFromFile = Uri.fromFile(file);
        m.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(this)");
        String name = file.getName();
        m.checkNotNullExpressionValue(name, "this.name");
        return new Attachment<>(jHashCode, uriFromFile, name, file, false, 16, null);
    }
}
