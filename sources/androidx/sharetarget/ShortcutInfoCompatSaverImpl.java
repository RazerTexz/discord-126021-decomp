package androidx.sharetarget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.sharetarget.ShortcutsInfoSerialization;
import b.d.b.a.outline;
import b.i.b.d.a.ListenableFuture8;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ShortcutInfoCompatSaverImpl extends ShortcutInfoCompatSaver<ListenableFuture8<Void>> {
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
    public final Map<String, ShortcutsInfoSerialization.ShortcutContainer> mShortcutsMap = new ArrayMap();
    public final Map<String, ListenableFuture8<?>> mScheduledBitmapTasks = new ArrayMap();

    @AnyThread
    public ShortcutInfoCompatSaverImpl(Context context, ExecutorService executorService, ExecutorService executorService2) {
        this.mContext = context.getApplicationContext();
        this.mCacheUpdateService = executorService;
        this.mDiskIoService = executorService2;
        final File file = new File(context.getFilesDir(), DIRECTORY_TARGETS);
        this.mBitmapsDir = new File(file, DIRECTORY_BITMAPS);
        this.mTargetsXmlFile = new File(file, FILENAME_XML);
        executorService.submit(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ShortcutInfoCompatSaverImpl.ensureDir(file);
                    ShortcutInfoCompatSaverImpl.ensureDir(ShortcutInfoCompatSaverImpl.this.mBitmapsDir);
                    ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl = ShortcutInfoCompatSaverImpl.this;
                    shortcutInfoCompatSaverImpl.mShortcutsMap.putAll(ShortcutsInfoSerialization.loadFromXml(shortcutInfoCompatSaverImpl.mTargetsXmlFile, shortcutInfoCompatSaverImpl.mContext));
                    ShortcutInfoCompatSaverImpl.this.deleteDanglingBitmaps(new ArrayList(ShortcutInfoCompatSaverImpl.this.mShortcutsMap.values()));
                } catch (Exception e) {
                    Log.w(ShortcutInfoCompatSaverImpl.TAG, "ShortcutInfoCompatSaver started with an exceptions ", e);
                }
            }
        });
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

    private ListenableFuture8<Void> submitDiskOperation(final Runnable runnable) {
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mDiskIoService.submit(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.9
            @Override // java.lang.Runnable
            public void run() {
                if (resolvableFutureCreate.isCancelled()) {
                    return;
                }
                try {
                    runnable.run();
                    resolvableFutureCreate.set(null);
                } catch (Exception e) {
                    resolvableFutureCreate.setException(e);
                }
            }
        });
        return resolvableFutureCreate;
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ ListenableFuture8<Void> addShortcuts(List list) {
        return addShortcuts((List<ShortcutInfoCompat>) list);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    public ShortcutsInfoSerialization.ShortcutContainer containerFrom(ShortcutInfoCompat shortcutInfoCompat) {
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
        return new ShortcutsInfoSerialization.ShortcutContainer(new ShortcutInfoCompat.Builder(shortcutInfoCompat).setIcon(null).build(), resourceName, absolutePath);
    }

    public void deleteDanglingBitmaps(List<ShortcutsInfoSerialization.ShortcutContainer> list) {
        ArrayList arrayList = new ArrayList();
        for (ShortcutsInfoSerialization.ShortcutContainer shortcutContainer : list) {
            if (!TextUtils.isEmpty(shortcutContainer.mBitmapPath)) {
                arrayList.add(shortcutContainer.mBitmapPath);
            }
        }
        for (File file : this.mBitmapsDir.listFiles()) {
            if (!arrayList.contains(file.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    @WorkerThread
    public IconCompat getShortcutIcon(final String str) throws Exception {
        Bitmap bitmap;
        final ShortcutsInfoSerialization.ShortcutContainer shortcutContainer = (ShortcutsInfoSerialization.ShortcutContainer) this.mCacheUpdateService.submit(new Callable<ShortcutsInfoSerialization.ShortcutContainer>() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ShortcutsInfoSerialization.ShortcutContainer call() {
                return ShortcutInfoCompatSaverImpl.this.mShortcutsMap.get(str);
            }
        }).get();
        if (shortcutContainer == null) {
            return null;
        }
        if (!TextUtils.isEmpty(shortcutContainer.mResourceName)) {
            int identifier = 0;
            try {
                identifier = this.mContext.getResources().getIdentifier(shortcutContainer.mResourceName, null, null);
            } catch (Exception unused) {
            }
            if (identifier != 0) {
                return IconCompat.createWithResource(this.mContext, identifier);
            }
        }
        if (TextUtils.isEmpty(shortcutContainer.mBitmapPath) || (bitmap = (Bitmap) this.mDiskIoService.submit(new Callable<Bitmap>() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Bitmap call() {
                return BitmapFactory.decodeFile(shortcutContainer.mBitmapPath);
            }
        }).get()) == null) {
            return null;
        }
        return IconCompat.createWithBitmap(bitmap);
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @WorkerThread
    public List<ShortcutInfoCompat> getShortcuts() throws Exception {
        return (List) this.mCacheUpdateService.submit(new Callable<ArrayList<ShortcutInfoCompat>>() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.4
            @Override // java.util.concurrent.Callable
            public ArrayList<ShortcutInfoCompat> call() {
                ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<>();
                Iterator<ShortcutsInfoSerialization.ShortcutContainer> it = ShortcutInfoCompatSaverImpl.this.mShortcutsMap.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(new ShortcutInfoCompat.Builder(it.next().mShortcutInfo).build());
                }
                return arrayList;
            }
        }).get();
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ ListenableFuture8<Void> removeShortcuts(List list) {
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
                if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
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
            throw new RuntimeException(outline.w("Unable to write bitmap to file ", str), e);
        }
    }

    public ListenableFuture8<Void> scheduleBitmapSaving(final Bitmap bitmap, final String str) {
        return submitDiskOperation(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.8
            @Override // java.lang.Runnable
            public void run() {
                ShortcutInfoCompatSaverImpl.this.saveBitmap(bitmap, str);
            }
        });
    }

    public void scheduleSyncCurrentState(final ResolvableFuture<Void> resolvableFuture) {
        final ArrayList arrayList = new ArrayList(this.mShortcutsMap.values());
        final ListenableFuture8<Void> listenableFuture8SubmitDiskOperation = submitDiskOperation(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.10
            @Override // java.lang.Runnable
            public void run() {
                ShortcutInfoCompatSaverImpl.this.deleteDanglingBitmaps(arrayList);
                ShortcutsInfoSerialization.saveAsXml(arrayList, ShortcutInfoCompatSaverImpl.this.mTargetsXmlFile);
            }
        });
        listenableFuture8SubmitDiskOperation.addListener(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    listenableFuture8SubmitDiskOperation.get();
                    resolvableFuture.set(null);
                } catch (Exception e) {
                    resolvableFuture.setException(e);
                }
            }
        }, this.mCacheUpdateService);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public ListenableFuture8<Void> addShortcuts(List<ShortcutInfoCompat> list) {
        final ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfoCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ShortcutInfoCompat.Builder(it.next()).build());
        }
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.7
            @Override // java.lang.Runnable
            public void run() {
                for (ShortcutInfoCompat shortcutInfoCompat : arrayList) {
                    Set<String> categories = shortcutInfoCompat.getCategories();
                    if (categories != null && !categories.isEmpty()) {
                        ShortcutsInfoSerialization.ShortcutContainer shortcutContainerContainerFrom = ShortcutInfoCompatSaverImpl.this.containerFrom(shortcutInfoCompat);
                        Bitmap bitmap = shortcutContainerContainerFrom.mBitmapPath != null ? shortcutInfoCompat.getIcon().getBitmap() : null;
                        final String id2 = shortcutInfoCompat.getId();
                        ShortcutInfoCompatSaverImpl.this.mShortcutsMap.put(id2, shortcutContainerContainerFrom);
                        if (bitmap != null) {
                            final ListenableFuture8<Void> listenableFuture8ScheduleBitmapSaving = ShortcutInfoCompatSaverImpl.this.scheduleBitmapSaving(bitmap, shortcutContainerContainerFrom.mBitmapPath);
                            ListenableFuture8<?> listenableFuture8Put = ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.put(id2, listenableFuture8ScheduleBitmapSaving);
                            if (listenableFuture8Put != null) {
                                listenableFuture8Put.cancel(false);
                            }
                            listenableFuture8ScheduleBitmapSaving.addListener(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.remove(id2);
                                    if (listenableFuture8ScheduleBitmapSaving.isCancelled()) {
                                        return;
                                    }
                                    try {
                                        listenableFuture8ScheduleBitmapSaving.get();
                                    } catch (Exception e) {
                                        resolvableFutureCreate.setException(e);
                                    }
                                }
                            }, ShortcutInfoCompatSaverImpl.this.mCacheUpdateService);
                        }
                    }
                }
                ShortcutInfoCompatSaverImpl.this.scheduleSyncCurrentState(resolvableFutureCreate);
            }
        });
        return resolvableFutureCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public ListenableFuture8<Void> removeAllShortcuts() {
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.3
            @Override // java.lang.Runnable
            public void run() {
                ShortcutInfoCompatSaverImpl.this.mShortcutsMap.clear();
                Iterator<ListenableFuture8<?>> it = ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.values().iterator();
                while (it.hasNext()) {
                    it.next().cancel(false);
                }
                ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.clear();
                ShortcutInfoCompatSaverImpl.this.scheduleSyncCurrentState(resolvableFutureCreate);
            }
        });
        return resolvableFutureCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public ListenableFuture8<Void> removeShortcuts(List<String> list) {
        final ArrayList arrayList = new ArrayList(list);
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new Runnable() { // from class: androidx.sharetarget.ShortcutInfoCompatSaverImpl.2
            @Override // java.lang.Runnable
            public void run() {
                for (String str : arrayList) {
                    ShortcutInfoCompatSaverImpl.this.mShortcutsMap.remove(str);
                    ListenableFuture8<?> listenableFuture8Remove = ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.remove(str);
                    if (listenableFuture8Remove != null) {
                        listenableFuture8Remove.cancel(false);
                    }
                }
                ShortcutInfoCompatSaverImpl.this.scheduleSyncCurrentState(resolvableFutureCreate);
            }
        });
        return resolvableFutureCreate;
    }
}
