package p007b.p225i.p361c.p406w;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p398s.C4823n;
import p007b.p225i.p361c.p398s.C4826q;
import p007b.p225i.p361c.p398s.InterfaceC4824o;

/* JADX INFO: renamed from: b.i.c.w.y */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4887y {

    /* JADX INFO: renamed from: a */
    public static final long f13059a = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f13060b = 0;

    /* JADX INFO: renamed from: c */
    public final FirebaseInstanceId f13061c;

    /* JADX INFO: renamed from: d */
    public final Context f13062d;

    /* JADX INFO: renamed from: e */
    public final C4826q f13063e;

    /* JADX INFO: renamed from: f */
    public final C4823n f13064f;

    /* JADX INFO: renamed from: h */
    public final ScheduledExecutorService f13066h;

    /* JADX INFO: renamed from: j */
    public final C4885w f13068j;

    /* JADX INFO: renamed from: g */
    @GuardedBy("pendingOperations")
    public final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f13065g = new ArrayMap();

    /* JADX INFO: renamed from: i */
    @GuardedBy("this")
    public boolean f13067i = false;

    public C4887y(FirebaseInstanceId firebaseInstanceId, C4826q c4826q, C4885w c4885w, C4823n c4823n, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f13061c = firebaseInstanceId;
        this.f13063e = c4826q;
        this.f13068j = c4885w;
        this.f13064f = c4823n;
        this.f13062d = context;
        this.f13066h = scheduledExecutorService;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public static <T> T m6830a(Task<T> task) throws IOException {
        try {
            return (T) C3404f.m4307k(task, 30L, TimeUnit.SECONDS);
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

    /* JADX INFO: renamed from: d */
    public static boolean m6831d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final void m6832b(String str) throws IOException {
        InterfaceC4824o interfaceC4824o = (InterfaceC4824o) m6830a(this.f13061c.m9183f());
        C4823n c4823n = this.f13064f;
        String id2 = interfaceC4824o.getId();
        String strMo6729a = interfaceC4824o.mo6729a();
        Objects.requireNonNull(c4823n);
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        String strValueOf2 = String.valueOf(str);
        m6830a(c4823n.m6727a(c4823n.m6728b(id2, strMo6729a, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle)));
    }

    @WorkerThread
    /* JADX INFO: renamed from: c */
    public final void m6833c(String str) throws IOException {
        InterfaceC4824o interfaceC4824o = (InterfaceC4824o) m6830a(this.f13061c.m9183f());
        C4823n c4823n = this.f13064f;
        String id2 = interfaceC4824o.getId();
        String strMo6729a = interfaceC4824o.mo6729a();
        Objects.requireNonNull(c4823n);
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String strValueOf2 = String.valueOf(str);
        m6830a(c4823n.m6727a(c4823n.m6728b(id2, strMo6729a, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle)));
    }

    /* JADX INFO: renamed from: e */
    public synchronized void m6834e(boolean z2) {
        this.f13067i = z2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: f */
    public boolean m6835f() throws IOException {
        while (true) {
            synchronized (this) {
                C4884v c4884vM6829a = this.f13068j.m6829a();
                boolean z2 = true;
                if (c4884vM6829a == null) {
                    if (m6831d()) {
                        Log.d("FirebaseMessaging", "topic sync succeeded");
                    }
                    return true;
                }
                try {
                    String str = c4884vM6829a.f13048c;
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
                        m6832b(c4884vM6829a.f13047b);
                        if (m6831d()) {
                            String str2 = c4884vM6829a.f13047b;
                            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 31);
                            sb.append("Subscribe to topic: ");
                            sb.append(str2);
                            sb.append(" succeeded.");
                            Log.d("FirebaseMessaging", sb.toString());
                        }
                    } else if (b2 == 1) {
                        m6833c(c4884vM6829a.f13047b);
                        if (m6831d()) {
                            String str3 = c4884vM6829a.f13047b;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 35);
                            sb2.append("Unsubscribe from topic: ");
                            sb2.append(str3);
                            sb2.append(" succeeded.");
                            Log.d("FirebaseMessaging", sb2.toString());
                        }
                    } else if (m6831d()) {
                        String strValueOf = String.valueOf(c4884vM6829a);
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
                C4885w c4885w = this.f13068j;
                synchronized (c4885w) {
                    final C4883u c4883u = c4885w.f13052c;
                    String str4 = c4884vM6829a.f13049d;
                    synchronized (c4883u.f13044d) {
                        if (c4883u.f13044d.remove(str4)) {
                            c4883u.f13045e.execute(new Runnable(c4883u) { // from class: b.i.c.w.t

                                /* JADX INFO: renamed from: j */
                                public final C4883u f13040j;

                                {
                                    this.f13040j = c4883u;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    C4883u c4883u2 = this.f13040j;
                                    synchronized (c4883u2.f13044d) {
                                        SharedPreferences.Editor editorEdit = c4883u2.f13041a.edit();
                                        String str5 = c4883u2.f13042b;
                                        StringBuilder sb5 = new StringBuilder();
                                        Iterator<String> it = c4883u2.f13044d.iterator();
                                        while (it.hasNext()) {
                                            sb5.append(it.next());
                                            sb5.append(c4883u2.f13043c);
                                        }
                                        editorEdit.putString(str5, sb5.toString()).commit();
                                    }
                                }
                            });
                        }
                    }
                }
                synchronized (this.f13065g) {
                    String str5 = c4884vM6829a.f13049d;
                    if (this.f13065g.containsKey(str5)) {
                        ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f13065g.get(str5);
                        TaskCompletionSource<Void> taskCompletionSourcePoll = arrayDeque.poll();
                        if (taskCompletionSourcePoll != null) {
                            taskCompletionSourcePoll.f20845a.m6024s(null);
                        }
                        if (arrayDeque.isEmpty()) {
                            this.f13065g.remove(str5);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public void m6836g(long j) {
        this.f13066h.schedule(new RunnableC4888z(this, this.f13062d, this.f13063e, Math.min(Math.max(30L, j << 1), f13059a)), j, TimeUnit.SECONDS);
        m6834e(true);
    }
}
