package b.i.c.m.d.k;

import android.os.Looper;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: b.i.c.m.d.k.h1, reason: use source file name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Utils3 {
    public static final FilenameFilter a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1687b = b.i.a.f.e.o.f.n("awaitEvenIfOnMainThread task continuation executor");

    /* JADX INFO: renamed from: b.i.c.m.d.k.h1$a */
    /* JADX INFO: compiled from: Utils.java */
    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public static <T> T a(Task<T> task) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.i(f1687b, new b.i.a.f.n.a(countDownLatch) { // from class: b.i.c.m.d.k.g1
            public final CountDownLatch a;

            {
                this.a = countDownLatch;
            }

            @Override // b.i.a.f.n.a
            public Object a(Task task2) {
                CountDownLatch countDownLatch2 = this.a;
                FilenameFilter filenameFilter = Utils3.a;
                countDownLatch2.countDown();
                return null;
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.p()) {
            return task.l();
        }
        if (task.n()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.o()) {
            throw new IllegalStateException(task.k());
        }
        throw new TimeoutException();
    }

    public static int b(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            return 0;
        }
        return c(Arrays.asList(fileArrListFiles), i, comparator);
    }

    public static int c(List<File> list, int i, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i) {
                return size;
            }
            d(file);
            size--;
        }
        return size;
    }

    public static void d(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                d(file2);
            }
        }
        file.delete();
    }
}
