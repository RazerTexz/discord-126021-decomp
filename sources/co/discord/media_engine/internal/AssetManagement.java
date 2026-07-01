package co.discord.media_engine.internal;

import android.content.Context;
import android.util.Log;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.hammerandchisel.libdiscord.R;
import d0.y.IOStreams;
import d0.y.Utils7;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: AssetManagement.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AssetManagement {
    private final Context ctx;

    public AssetManagement(Context context) {
        Intrinsics3.checkNotNullParameter(context, "ctx");
        this.ctx = context;
    }

    private final void cleanup() {
        try {
            File file = new File(this.ctx.getFilesDir(), "thz");
            if (file.exists()) {
                Utils7.deleteRecursively(file);
            }
        } catch (Exception e) {
            StringBuilder sbU = outline.U("Failed removing krisp model files: ");
            sbU.append(e.getMessage());
            sbU.append(": ");
            sbU.append(e.toString());
            Log.e("DiscordKrisp", sbU.toString());
        }
    }

    private final void copy(File dir, String name) throws IOException {
        InputStream inputStreamOpen = this.ctx.getAssets().open("thz/" + name);
        Intrinsics3.checkNotNullExpressionValue(inputStreamOpen, "ctx.assets.open(\"thz/\" + name)");
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, name));
        IOStreams.copyTo(inputStreamOpen, fileOutputStream, 1024);
        inputStreamOpen.close();
        fileOutputStream.close();
    }

    public final void ensureKrispModelsCopied(boolean enabled) {
        if (!enabled) {
            cleanup();
            return;
        }
        try {
            File file = new File(this.ctx.getFilesDir(), "thz");
            String string = this.ctx.getString(R.string.krisp_model_version);
            Intrinsics3.checkNotNullExpressionValue(string, "ctx.getString(R.string.krisp_model_version)");
            if (new File(file, string).exists()) {
                return;
            }
            cleanup();
            File file2 = new File(this.ctx.getFilesDir(), "thz");
            file2.mkdir();
            File file3 = new File(file2, string);
            file3.mkdir();
            String[] list = this.ctx.getAssets().list("thz");
            if (list == null) {
                list = new String[0];
            }
            for (String str : list) {
                Intrinsics3.checkNotNullExpressionValue(str, "file");
                copy(file3, str);
            }
        } catch (Exception e) {
            StringBuilder sbU = outline.U("Failed copying krisp model files: ");
            sbU.append(e.getMessage());
            sbU.append(": ");
            sbU.append(e.toString());
            Log.e("DiscordKrisp", sbU.toString());
            cleanup();
        }
    }

    public final Context getCtx() {
        return this.ctx;
    }
}
