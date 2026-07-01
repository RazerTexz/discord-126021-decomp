package b.b.a.f;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import b.d.b.a.outline;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.managers.FileManager;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: renamed from: b.b.a.f.b, reason: use source file name */
/* JADX INFO: compiled from: SimpleFileManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleFileManager implements FileManager {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325b;
    public final String c;

    public SimpleFileManager(Context context, String str, String str2, int i) {
        String str3;
        String string = null;
        if ((i & 2) != 0) {
            str3 = context.getPackageName() + ".file-provider";
        } else {
            str3 = null;
        }
        if ((i & 4) != 0) {
            string = context.getString(R.h.discord);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.discord)");
        }
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str3, "providerAuthority");
        Intrinsics3.checkNotNullParameter(string, "imageDirName");
        this.a = context;
        this.f325b = str3;
        this.c = string;
    }

    @Override // com.lytefast.flexinput.managers.FileManager
    public Uri a(Context context, File file) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(file, "file");
        Uri uriForFile = FileProvider.getUriForFile(context, this.f325b, file);
        Intrinsics3.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi… providerAuthority, file)");
        return uriForFile;
    }

    @Override // com.lytefast.flexinput.managers.FileManager
    public File b() {
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        Context context = this.a;
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), this.c);
        file.mkdirs();
        if (!file.exists()) {
            file = context.getFilesDir();
            Intrinsics3.checkNotNullExpressionValue(file, "context.filesDir");
        }
        return new File(file, outline.w(str, ".jpg"));
    }
}
