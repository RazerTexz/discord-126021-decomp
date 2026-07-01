package androidx.core.content;

import android.net.Uri;
import android.net.Uri$Builder;
import android.text.TextUtils;
import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider$SimplePathStrategy implements FileProvider$PathStrategy {
    private final String mAuthority;
    private final HashMap<String, File> mRoots = new HashMap<>();

    public FileProvider$SimplePathStrategy(String str) {
        this.mAuthority = str;
    }

    public void addRoot(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            this.mRoots.put(str, file.getCanonicalFile());
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
        }
    }

    @Override // androidx.core.content.FileProvider$PathStrategy
    public File getFileForUri(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int iIndexOf = encodedPath.indexOf(47, 1);
        String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
        String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
        File file = this.mRoots.get(strDecode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, strDecode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (canonicalFile.getPath().startsWith(file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
    }

    @Override // androidx.core.content.FileProvider$PathStrategy
    public Uri getUriForFile(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            Map$Entry<String, File> map$Entry = null;
            for (Map$Entry<String, File> map$Entry2 : this.mRoots.entrySet()) {
                String path = map$Entry2.getValue().getPath();
                if (canonicalPath.startsWith(path) && (map$Entry == null || path.length() > map$Entry.getValue().getPath().length())) {
                    map$Entry = map$Entry2;
                }
            }
            if (map$Entry == null) {
                throw new IllegalArgumentException(a.w("Failed to find configured root that contains ", canonicalPath));
            }
            String path2 = map$Entry.getValue().getPath();
            return new Uri$Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(map$Entry.getKey()) + MentionUtilsKt.SLASH_CHAR + Uri.encode(path2.endsWith(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN) ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)).build();
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }
}
