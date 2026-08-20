package p007b.p109f.p161j.p181p;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.io.PrintWriter;
import java.io.StringWriter;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.j.p.b */
/* JADX INFO: compiled from: BaseConsumer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1965b<T> implements InterfaceC1995l<T> {

    /* JADX INFO: renamed from: a */
    public boolean f3993a = false;

    /* JADX INFO: renamed from: e */
    public static boolean m1419e(int i) {
        return (i & 1) == 1;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m1420f(int i) {
        return !m1419e(i);
    }

    /* JADX INFO: renamed from: l */
    public static boolean m1421l(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: renamed from: m */
    public static boolean m1422m(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1995l
    /* JADX INFO: renamed from: a */
    public synchronized void mo1423a(float f) {
        if (this.f3993a) {
            return;
        }
        try {
            mo1321j(f);
        } catch (Exception e) {
            m1427k(e);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1995l
    /* JADX INFO: renamed from: b */
    public synchronized void mo1424b(T t, int i) {
        if (this.f3993a) {
            return;
        }
        this.f3993a = m1419e(i);
        try {
            mo1320i(t, i);
        } catch (Exception e) {
            m1427k(e);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1995l
    /* JADX INFO: renamed from: c */
    public synchronized void mo1425c(Throwable th) {
        if (this.f3993a) {
            return;
        }
        this.f3993a = true;
        try {
            mo1319h(th);
        } catch (Exception e) {
            m1427k(e);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1995l
    /* JADX INFO: renamed from: d */
    public synchronized void mo1426d() {
        if (this.f3993a) {
            return;
        }
        this.f3993a = true;
        try {
            mo1318g();
        } catch (Exception e) {
            m1427k(e);
        }
    }

    /* JADX INFO: renamed from: g */
    public abstract void mo1318g();

    /* JADX INFO: renamed from: h */
    public abstract void mo1319h(Throwable th);

    /* JADX INFO: renamed from: i */
    public abstract void mo1320i(T t, int i);

    /* JADX INFO: renamed from: j */
    public abstract void mo1321j(float f);

    /* JADX INFO: renamed from: k */
    public void m1427k(Exception exc) {
        String strM886y = C1643a.m886y(EnvironmentCompat.MEDIA_UNKNOWN, ":", getClass().getSimpleName());
        StringBuilder sb = new StringBuilder();
        sb.append("unhandled exception");
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        Log.println(6, strM886y, sb.toString());
    }
}
