package p007b.p076b.p077a.p082g;

import android.net.Uri;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.g.a */
/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1449a {
    /* JADX INFO: renamed from: a */
    public static final Attachment<File> m410a(File file) {
        C12238m.checkNotNullParameter(file, "$this$toAttachment");
        long jHashCode = file.hashCode();
        Uri uriFromFile = Uri.fromFile(file);
        C12238m.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(this)");
        String name = file.getName();
        C12238m.checkNotNullExpressionValue(name, "this.name");
        return new Attachment<>(jHashCode, uriFromFile, name, file, false, 16, null);
    }
}
