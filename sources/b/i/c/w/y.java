package b.i.c.w;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class y {
    public static final long a = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1800b = 0;
    public final FirebaseInstanceId c;
    public final Context d;
    public final b.i.c.s.q e;
    public final b.i.c.s.n f;
    public final ScheduledExecutorService h;
    public final w j;

    @GuardedBy("pendingOperations")
    public final Map<String, ArrayDeque<TaskCompletionSource<Void>>> g = new ArrayMap();

    @GuardedBy("this")
    public boolean i = false;

    public y(FirebaseInstanceId firebaseInstanceId, b.i.c.s.q qVar, w wVar, b.i.c.s.n nVar, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.c = firebaseInstanceId;
        this.e = qVar;
        this.j = wVar;
        this.f = nVar;
        this.d = context;
        this.h = scheduledExecutorService;
    }

    @WorkerThread
    public static <T> T a(Task<T> task) throws IOException {
        try {
            return (T) b.i.a.f.e.o.f.k(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public static boolean d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    @WorkerThread
    public final void b(String str) throws IOException {
        b.i.c.s.o oVar = (b.i.c.s.o) a(this.c.f());
        b.i.c.s.n nVar = this.f;
        String id2 = oVar.getId();
        String strA = oVar.a();
        Objects.requireNonNull(nVar);
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        String strValueOf2 = String.valueOf(str);
        a(nVar.a(nVar.b(id2, strA, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle)));
    }

    @WorkerThread
    public final void c(String str) throws IOException {
        b.i.c.s.o oVar = (b.i.c.s.o) a(this.c.f());
        b.i.c.s.n nVar = this.f;
        String id2 = oVar.getId();
        String strA = oVar.a();
        Objects.requireNonNull(nVar);
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String strValueOf2 = String.valueOf(str);
        a(nVar.a(nVar.b(id2, strA, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle)));
    }

    public synchronized void e(boolean z2) {
        this.i = z2;
    }

    @WorkerThread
    public boolean f() throws IOException {
        while (true) {
            synchronized (this) {
                v vVarA = this.j.a();
                boolean z2 = true;
                if (vVarA == null) {
                    if (d()) {
                        Log.d("FirebaseMessaging", "topic sync succeeded");
                    }
                    return true;
                }
                try {
                    String str = vVarA.c;
                    byte b2 = -1;
                    int iHashCode = str.hashCode();
                    if (iHashCode != 83) {
                        if (iHashCode == 85 && str.equals("U")) {
                            b2 = 1;
                        }
                    } else if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        b2 = 0;
                    }
                    if (b2 == 0) {
                        b(vVarA.f1798b);
                        if (d()) {
                            String str2 = vVarA.f1798b;
                            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 31);
                            sb.append("Subscribe to topic: ");
                            sb.append(str2);
                            sb.append(" succeeded.");
                            Log.d("FirebaseMessaging", sb.toString());
                        }
                    } else if (b2 == 1) {
                        c(vVarA.f1798b);
                        if (d()) {
                            String str3 = vVarA.f1798b;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 35);
                            sb2.append("Unsubscribe from topic: ");
                            sb2.append(str3);
                            sb2.append(" succeeded.");
                            Log.d("FirebaseMessaging", sb2.toString());
                        }
                    } else if (d()) {
                        String strValueOf = String.valueOf(vVarA);
                        StringBuilder sb3 = new StringBuilder(strValueOf.length() + 24);
                        sb3.append("Unknown topic operation");
                        sb3.append(strValueOf);
                        sb3.append(".");
                        Log.d("FirebaseMessaging", sb3.toString());
                    }
                } catch (IOException e) {
                    if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                        String message = e.getMessage();
                        StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
                        sb4.append("Topic operation failed: ");
                        sb4.append(message);
                        sb4.append(". Will retry Topic operation.");
                        Log.e("FirebaseMessaging", sb4.toString());
                    } else {
                        if (e.getMessage() != null) {
                            throw e;
                        }
                        Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                    }
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
                w wVar = this.j;
                synchronized (wVar) {
                    final u uVar = wVar.c;
                    String str4 = vVarA.d;
                    synchronized (uVar.d) {
                        if (uVar.d.remove(str4)) {
                            uVar.e.execute(new Runnable(uVar) { // from class: b.i.c.w.t
                                public final u j;

                                {
                                    this.j = uVar;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    u uVar2 = this.j;
                                    synchronized (uVar2.d) {
                                        SharedPreferences.Editor editorEdit = uVar2.a.edit();
                                        String str5 = uVar2.f1797b;
                                        StringBuilder sb5 = new StringBuilder();
                                        Iterator<String> it = uVar2.d.iterator();
                                        while (it.hasNext()) {
                                            sb5.append(it.next());
                                            sb5.append(uVar2.c);
                                        }
                                        editorEdit.putString(str5, sb5.toString()).commit();
                                    }
                                }
                            });
                        }
                    }
                }
                synchronized (this.g) {
                    String str5 = vVarA.d;
                    if (this.g.containsKey(str5)) {
                        ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.g.get(str5);
                        TaskCompletionSource<Void> taskCompletionSourcePoll = arrayDeque.poll();
                        if (taskCompletionSourcePoll != null) {
                            taskCompletionSourcePoll.a.s(null);
                        }
                        if (arrayDeque.isEmpty()) {
                            this.g.remove(str5);
                        }
                    }
                }
            }
        }
    }

    public void g(long j) {
        this.h.schedule(new z(this, this.d, this.e, Math.min(Math.max(30L, j << 1), a)), j, TimeUnit.SECONDS);
        e(true);
    }
}
