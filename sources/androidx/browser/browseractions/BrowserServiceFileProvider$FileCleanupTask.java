package androidx.browser.browseractions;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class BrowserServiceFileProvider$FileCleanupTask extends AsyncTask<Void, Void, Void> {
    private static final long CLEANUP_REQUIRED_TIME_SPAN;
    private static final long DELETION_FAILED_REATTEMPT_DURATION;
    private static final long IMAGE_RETENTION_DURATION;
    private final Context mAppContext;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        IMAGE_RETENTION_DURATION = timeUnit.toMillis(7L);
        CLEANUP_REQUIRED_TIME_SPAN = timeUnit.toMillis(7L);
        DELETION_FAILED_REATTEMPT_DURATION = timeUnit.toMillis(1L);
    }

    public BrowserServiceFileProvider$FileCleanupTask(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    private static boolean isImageFile(File file) {
        return file.getName().endsWith("..png");
    }

    private static boolean shouldCleanUp(SharedPreferences sharedPreferences) {
        return System.currentTimeMillis() > sharedPreferences.getLong("last_cleanup_time", System.currentTimeMillis()) + CLEANUP_REQUIRED_TIME_SPAN;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
        return doInBackground2(voidArr);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Void doInBackground2(Void... voidArr) {
        SharedPreferences sharedPreferences = this.mAppContext.getSharedPreferences(this.mAppContext.getPackageName() + ".image_provider", 0);
        if (!shouldCleanUp(sharedPreferences)) {
            return null;
        }
        synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
            File file = new File(this.mAppContext.getFilesDir(), "image_provider");
            if (!file.exists()) {
                return null;
            }
            File[] fileArrListFiles = file.listFiles();
            long jCurrentTimeMillis = System.currentTimeMillis() - IMAGE_RETENTION_DURATION;
            boolean z2 = true;
            for (File file2 : fileArrListFiles) {
                if (isImageFile(file2) && file2.lastModified() < jCurrentTimeMillis && !file2.delete()) {
                    Log.e("BrowserServiceFP", "Fail to delete image: " + file2.getAbsoluteFile());
                    z2 = false;
                }
            }
            long jCurrentTimeMillis2 = z2 ? System.currentTimeMillis() : (System.currentTimeMillis() - CLEANUP_REQUIRED_TIME_SPAN) + DELETION_FAILED_REATTEMPT_DURATION;
            SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences.edit();
            sharedPreferences$EditorEdit.putLong("last_cleanup_time", jCurrentTimeMillis2);
            sharedPreferences$EditorEdit.apply();
            return null;
        }
    }
}
