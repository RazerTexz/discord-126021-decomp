package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build$VERSION;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.AtomicFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BrowserServiceFileProvider$FileSaveTask extends AsyncTask<String, Void, Void> {
    private final Context mAppContext;
    private final Bitmap mBitmap;
    private final Uri mFileUri;
    private final String mFilename;
    private final ResolvableFuture<Uri> mResultFuture;

    public BrowserServiceFileProvider$FileSaveTask(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
        this.mAppContext = context.getApplicationContext();
        this.mFilename = str;
        this.mBitmap = bitmap;
        this.mFileUri = uri;
        this.mResultFuture = resolvableFuture;
    }

    private void saveFileBlocking(File file) {
        FileOutputStream fileOutputStreamStartWrite;
        if (Build$VERSION.SDK_INT < 22) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.mBitmap.compress(Bitmap$CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                this.mResultFuture.set(this.mFileUri);
                return;
            } catch (IOException e) {
                this.mResultFuture.setException(e);
                return;
            }
        }
        AtomicFile atomicFile = new AtomicFile(file);
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite();
            try {
                this.mBitmap.compress(Bitmap$CompressFormat.PNG, 100, fileOutputStreamStartWrite);
                fileOutputStreamStartWrite.close();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
                this.mResultFuture.set(this.mFileUri);
            } catch (IOException e2) {
                e = e2;
                atomicFile.failWrite(fileOutputStreamStartWrite);
                this.mResultFuture.setException(e);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStreamStartWrite = null;
        }
    }

    private void saveFileIfNeededBlocking() {
        File file = new File(this.mAppContext.getFilesDir(), "image_provider");
        synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
            if (!file.exists() && !file.mkdir()) {
                this.mResultFuture.setException(new IOException("Could not create file directory."));
                return;
            }
            File file2 = new File(file, this.mFilename + ".png");
            if (file2.exists()) {
                this.mResultFuture.set(this.mFileUri);
            } else {
                saveFileBlocking(file2);
            }
            file2.setLastModified(System.currentTimeMillis());
        }
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Void doInBackground(String[] strArr) {
        return doInBackground2(strArr);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
        onPostExecute2(r1);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Void doInBackground2(String... strArr) {
        saveFileIfNeededBlocking();
        return null;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(Void r3) {
        new BrowserServiceFileProvider$FileCleanupTask(this.mAppContext).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
