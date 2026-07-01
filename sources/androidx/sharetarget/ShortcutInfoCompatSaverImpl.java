package androidx.sharetarget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompat$Builder;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import b.i.b.d.a.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class ShortcutInfoCompatSaverImpl extends ShortcutInfoCompatSaver<a<Void>> {
    private static final String DIRECTORY_BITMAPS = "ShortcutInfoCompatSaver_share_targets_bitmaps";
    private static final String DIRECTORY_TARGETS = "ShortcutInfoCompatSaver_share_targets";
    private static final int EXECUTOR_KEEP_ALIVE_TIME_SECS = 20;
    private static final String FILENAME_XML = "targets.xml";
    private static final Object GET_INSTANCE_LOCK = new Object();
    public static final String TAG = "ShortcutInfoCompatSaver";
    private static volatile ShortcutInfoCompatSaverImpl sInstance;
    public final File mBitmapsDir;
    public final ExecutorService mCacheUpdateService;
    public final Context mContext;
    private final ExecutorService mDiskIoService;
    public final File mTargetsXmlFile;
    public final Map<String, ShortcutsInfoSerialization$ShortcutContainer> mShortcutsMap = new ArrayMap();
    public final Map<String, a<?>> mScheduledBitmapTasks = new ArrayMap();

    @AnyThread
    public ShortcutInfoCompatSaverImpl(Context context, ExecutorService executorService, ExecutorService executorService2) {
        this.mContext = context.getApplicationContext();
        this.mCacheUpdateService = executorService;
        this.mDiskIoService = executorService2;
        File file = new File(context.getFilesDir(), DIRECTORY_TARGETS);
        this.mBitmapsDir = new File(file, DIRECTORY_BITMAPS);
        this.mTargetsXmlFile = new File(file, FILENAME_XML);
        executorService.submit(new ShortcutInfoCompatSaverImpl$1(this, file));
    }

    @AnyThread
    public static ExecutorService createExecutorService() {
        return new ThreadPoolExecutor(0, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static boolean ensureDir(File file) {
        if (file.exists() && !file.isDirectory() && !file.delete()) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    @AnyThread
    public static ShortcutInfoCompatSaverImpl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (GET_INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new ShortcutInfoCompatSaverImpl(context, createExecutorService(), createExecutorService());
                }
            }
        }
        return sInstance;
    }

    private a<Void> submitDiskOperation(Runnable runnable) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mDiskIoService.submit(new ShortcutInfoCompatSaverImpl$9(this, resolvableFutureCreate, runnable));
        return resolvableFutureCreate;
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ a<Void> addShortcuts(List list) {
        return addShortcuts((List<ShortcutInfoCompat>) list);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    public ShortcutsInfoSerialization$ShortcutContainer containerFrom(ShortcutInfoCompat shortcutInfoCompat) {
        String resourceName;
        String absolutePath;
        IconCompat icon = shortcutInfoCompat.getIcon();
        if (icon == null) {
            resourceName = null;
            absolutePath = null;
        } else {
            int type = icon.getType();
            if (type == 1) {
                absolutePath = new File(this.mBitmapsDir, UUID.randomUUID().toString()).getAbsolutePath();
                resourceName = null;
            } else if (type == 2) {
                resourceName = this.mContext.getResources().getResourceName(icon.getResId());
                absolutePath = null;
            } else if (type != 5) {
                resourceName = null;
                absolutePath = null;
            } else {
                absolutePath = new File(this.mBitmapsDir, UUID.randomUUID().toString()).getAbsolutePath();
                resourceName = null;
            }
        }
        return new ShortcutsInfoSerialization$ShortcutContainer(new ShortcutInfoCompat$Builder(shortcutInfoCompat).setIcon(null).build(), resourceName, absolutePath);
    }

    public void deleteDanglingBitmaps(List<ShortcutsInfoSerialization$ShortcutContainer> list) {
        ArrayList arrayList = new ArrayList();
        for (ShortcutsInfoSerialization$ShortcutContainer shortcutsInfoSerialization$ShortcutContainer : list) {
            if (!TextUtils.isEmpty(shortcutsInfoSerialization$ShortcutContainer.mBitmapPath)) {
                arrayList.add(shortcutsInfoSerialization$ShortcutContainer.mBitmapPath);
            }
        }
        for (File file : this.mBitmapsDir.listFiles()) {
            if (!arrayList.contains(file.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    @WorkerThread
    public IconCompat getShortcutIcon(String str) throws Exception {
        Bitmap bitmap;
        ShortcutsInfoSerialization$ShortcutContainer shortcutsInfoSerialization$ShortcutContainer = (ShortcutsInfoSerialization$ShortcutContainer) this.mCacheUpdateService.submit(new ShortcutInfoCompatSaverImpl$5(this, str)).get();
        if (shortcutsInfoSerialization$ShortcutContainer == null) {
            return null;
        }
        if (!TextUtils.isEmpty(shortcutsInfoSerialization$ShortcutContainer.mResourceName)) {
            int identifier = 0;
            try {
                identifier = this.mContext.getResources().getIdentifier(shortcutsInfoSerialization$ShortcutContainer.mResourceName, null, null);
            } catch (Exception unused) {
            }
            if (identifier != 0) {
                return IconCompat.createWithResource(this.mContext, identifier);
            }
        }
        if (TextUtils.isEmpty(shortcutsInfoSerialization$ShortcutContainer.mBitmapPath) || (bitmap = (Bitmap) this.mDiskIoService.submit(new ShortcutInfoCompatSaverImpl$6(this, shortcutsInfoSerialization$ShortcutContainer)).get()) == null) {
            return null;
        }
        return IconCompat.createWithBitmap(bitmap);
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @WorkerThread
    public List<ShortcutInfoCompat> getShortcuts() throws Exception {
        return (List) this.mCacheUpdateService.submit(new ShortcutInfoCompatSaverImpl$4(this)).get();
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ a<Void> removeAllShortcuts() {
        return removeAllShortcuts();
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ a<Void> removeShortcuts(List list) {
        return removeShortcuts((List<String>) list);
    }

    @WorkerThread
    public void saveBitmap(Bitmap bitmap, String str) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("path is empty");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            try {
                if (bitmap.compress(Bitmap$CompressFormat.PNG, 100, fileOutputStream)) {
                    fileOutputStream.close();
                    return;
                }
                Log.wtf(TAG, "Unable to compress bitmap");
                throw new RuntimeException("Unable to compress bitmap for saving " + str);
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | OutOfMemoryError | RuntimeException e) {
            Log.wtf(TAG, "Unable to write bitmap to file", e);
            throw new RuntimeException(b.d.b.a.a.w("Unable to write bitmap to file ", str), e);
        }
    }

    public a<Void> scheduleBitmapSaving(Bitmap bitmap, String str) {
        return submitDiskOperation(new ShortcutInfoCompatSaverImpl$8(this, bitmap, str));
    }

    public void scheduleSyncCurrentState(ResolvableFuture<Void> resolvableFuture) {
        a<Void> aVarSubmitDiskOperation = submitDiskOperation(new ShortcutInfoCompatSaverImpl$10(this, new ArrayList(this.mShortcutsMap.values())));
        aVarSubmitDiskOperation.addListener(new ShortcutInfoCompatSaverImpl$11(this, aVarSubmitDiskOperation, resolvableFuture), this.mCacheUpdateService);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public a<Void> addShortcuts(List<ShortcutInfoCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfoCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ShortcutInfoCompat$Builder(it.next()).build());
        }
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new ShortcutInfoCompatSaverImpl$7(this, arrayList, resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public a<Void> removeAllShortcuts() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new ShortcutInfoCompatSaverImpl$3(this, resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public a<Void> removeShortcuts(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new ShortcutInfoCompatSaverImpl$2(this, arrayList, resolvableFutureCreate));
        return resolvableFutureCreate;
    }
}
