package androidx.core.content;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface FileProvider$PathStrategy {
    File getFileForUri(Uri uri);

    Uri getUriForFile(File file);
}
