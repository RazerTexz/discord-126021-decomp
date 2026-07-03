package co.discord.media_engine.internal;

import android.content.Context;
import android.util.Log;
import com.discord.models.domain.ModelAuditLogEntry;
import com.hammerandchisel.libdiscord.C11150R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p591y.C12200a;
import p507d0.p591y.C12207h;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AssetManagement.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AssetManagement {
    private final Context ctx;

    public AssetManagement(Context context) {
        C12238m.checkNotNullParameter(context, "ctx");
        this.ctx = context;
    }

    private final void cleanup() {
        try {
            File file = new File(this.ctx.getFilesDir(), "thz");
            if (file.exists()) {
                C12207h.deleteRecursively(file);
            }
        } catch (Exception e) {
            StringBuilder sbM833U = C1643a.m833U("Failed removing krisp model files: ");
            sbM833U.append(e.getMessage());
            sbM833U.append(": ");
            sbM833U.append(e.toString());
            Log.e("DiscordKrisp", sbM833U.toString());
        }
    }

    private final void copy(File dir, String name) throws IOException {
        InputStream inputStreamOpen = this.ctx.getAssets().open("thz/" + name);
        C12238m.checkNotNullExpressionValue(inputStreamOpen, "ctx.assets.open(\"thz/\" + name)");
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, name));
        C12200a.copyTo(inputStreamOpen, fileOutputStream, 1024);
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
            String string = this.ctx.getString(C11150R.string.krisp_model_version);
            C12238m.checkNotNullExpressionValue(string, "ctx.getString(R.string.krisp_model_version)");
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
                C12238m.checkNotNullExpressionValue(str, "file");
                copy(file3, str);
            }
        } catch (Exception e) {
            StringBuilder sbM833U = C1643a.m833U("Failed copying krisp model files: ");
            sbM833U.append(e.getMessage());
            sbM833U.append(": ");
            sbM833U.append(e.toString());
            Log.e("DiscordKrisp", sbM833U.toString());
            cleanup();
        }
    }

    public final Context getCtx() {
        return this.ctx;
    }
}
