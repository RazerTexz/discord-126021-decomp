package p007b.p109f.p132g.p133a.p134a.p136h.p137i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.util.Objects;
import p007b.p109f.p115d.p126k.InterfaceC1714b;
import p007b.p109f.p132g.p133a.p134a.p136h.C1743f;
import p007b.p109f.p132g.p133a.p134a.p136h.C1745h;
import p007b.p109f.p132g.p133a.p134a.p136h.InterfaceC1744g;
import p007b.p109f.p148h.p158b.p159a.C1826a;
import p007b.p109f.p148h.p158b.p159a.InterfaceC1827b;

/* JADX INFO: renamed from: b.f.g.a.a.h.i.a */
/* JADX INFO: compiled from: ImagePerfControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class C1746a extends C1826a<ImageInfo> implements Closeable {

    /* JADX INFO: renamed from: j */
    public static Handler f3242j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1714b f3243k;

    /* JADX INFO: renamed from: l */
    public final C1745h f3244l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC1744g f3245m;

    /* JADX INFO: renamed from: n */
    public final Supplier<Boolean> f3246n;

    /* JADX INFO: renamed from: o */
    public final Supplier<Boolean> f3247o;

    /* JADX INFO: renamed from: b.f.g.a.a.h.i.a$a */
    /* JADX INFO: compiled from: ImagePerfControllerListener2.java */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a */
        public final InterfaceC1744g f3248a;

        public a(@NonNull Looper looper, @NonNull InterfaceC1744g interfaceC1744g) {
            super(looper);
            this.f3248a = interfaceC1744g;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            Objects.requireNonNull(obj);
            C1745h c1745h = (C1745h) obj;
            int i = message.what;
            if (i == 1) {
                ((C1743f) this.f3248a).m1066b(c1745h, message.arg1);
            } else {
                if (i != 2) {
                    return;
                }
                ((C1743f) this.f3248a).m1065a(c1745h, message.arg1);
            }
        }
    }

    public C1746a(InterfaceC1714b interfaceC1714b, C1745h c1745h, InterfaceC1744g interfaceC1744g, Supplier<Boolean> supplier, Supplier<Boolean> supplier2) {
        this.f3243k = interfaceC1714b;
        this.f3244l = c1745h;
        this.f3245m = interfaceC1744g;
        this.f3246n = supplier;
        this.f3247o = supplier2;
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: a */
    public void mo1071a(String str, Object obj, InterfaceC1827b.a aVar) {
        long jNow = this.f3243k.now();
        C1745h c1745hM1075e = m1075e();
        c1745hM1075e.m1069b();
        c1745hM1075e.f3224i = jNow;
        c1745hM1075e.f3216a = str;
        c1745hM1075e.f3219d = obj;
        c1745hM1075e.f3215A = aVar;
        m1077n(c1745hM1075e, 0);
        c1745hM1075e.f3238w = 1;
        c1745hM1075e.f3239x = jNow;
        m1078q(c1745hM1075e, 1);
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: b */
    public void mo1072b(String str, Throwable th, InterfaceC1827b.a aVar) {
        long jNow = this.f3243k.now();
        C1745h c1745hM1075e = m1075e();
        c1745hM1075e.f3215A = aVar;
        c1745hM1075e.f3227l = jNow;
        c1745hM1075e.f3216a = str;
        c1745hM1075e.f3236u = th;
        m1077n(c1745hM1075e, 5);
        c1745hM1075e.f3238w = 2;
        c1745hM1075e.f3240y = jNow;
        m1078q(c1745hM1075e, 2);
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: c */
    public void mo1073c(String str, InterfaceC1827b.a aVar) {
        long jNow = this.f3243k.now();
        C1745h c1745hM1075e = m1075e();
        c1745hM1075e.f3215A = aVar;
        c1745hM1075e.f3216a = str;
        int i = c1745hM1075e.f3237v;
        if (i != 3 && i != 5 && i != 6) {
            c1745hM1075e.f3228m = jNow;
            m1077n(c1745hM1075e, 4);
        }
        c1745hM1075e.f3238w = 2;
        c1745hM1075e.f3240y = jNow;
        m1078q(c1745hM1075e, 2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m1075e().m1068a();
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: d */
    public void mo1074d(String str, Object obj, InterfaceC1827b.a aVar) {
        long jNow = this.f3243k.now();
        C1745h c1745hM1075e = m1075e();
        c1745hM1075e.f3215A = aVar;
        c1745hM1075e.f3226k = jNow;
        c1745hM1075e.f3230o = jNow;
        c1745hM1075e.f3216a = str;
        c1745hM1075e.f3220e = (ImageInfo) obj;
        m1077n(c1745hM1075e, 3);
    }

    /* JADX INFO: renamed from: e */
    public final C1745h m1075e() {
        return Boolean.FALSE.booleanValue() ? new C1745h() : this.f3244l;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1076f() {
        boolean zBooleanValue = this.f3246n.get().booleanValue();
        if (zBooleanValue && f3242j == null) {
            synchronized (this) {
                if (f3242j == null) {
                    HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    Objects.requireNonNull(looper);
                    f3242j = new a(looper, this.f3245m);
                }
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: n */
    public final void m1077n(C1745h c1745h, int i) {
        if (!m1076f()) {
            ((C1743f) this.f3245m).m1066b(c1745h, i);
            return;
        }
        Handler handler = f3242j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = c1745h;
        f3242j.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: renamed from: q */
    public final void m1078q(C1745h c1745h, int i) {
        if (!m1076f()) {
            ((C1743f) this.f3245m).m1065a(c1745h, i);
            return;
        }
        Handler handler = f3242j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = c1745h;
        f3242j.sendMessage(messageObtainMessage);
    }
}
