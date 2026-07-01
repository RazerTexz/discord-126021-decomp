package b.b.a.f;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.managers.FileManager;
import d0.z.d.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: SimpleFileManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements FileManager {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325b;
    public final String c;

    public b(Context context, String str, String str2, int i) {
        String str3;
        String string = null;
        if ((i & 2) != 0) {
            str3 = context.getPackageName() + ".file-provider";
        } else {
            str3 = null;
        }
        if ((i & 4) != 0) {
            string = context.getString(R$h.discord);
            m.checkNotNullExpressionValue(string, "context.getString(R.string.discord)");
        }
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(str3, "providerAuthority");
        m.checkNotNullParameter(string, "imageDirName");
        this.a = context;
        this.f325b = str3;
        this.c = string;
    }

    @Override // com.lytefast.flexinput.managers.FileManager
    public Uri a(Context context, File file) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(file, "file");
        Uri uriForFile = FileProvider.getUriForFile(context, this.f325b, file);
        m.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi… providerAuthority, file)");
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
            m.checkNotNullExpressionValue(file, "context.filesDir");
        }
        return new File(file, b.d.b.a.a.w(str, ".jpg"));
    }
}
