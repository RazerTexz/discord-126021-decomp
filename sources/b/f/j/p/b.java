package b.f.j.p;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: BaseConsumer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> implements l<T> {
    public boolean a = false;

    public static boolean e(int i) {
        return (i & 1) == 1;
    }

    public static boolean f(int i) {
        return !e(i);
    }

    public static boolean l(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean m(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // b.f.j.p.l
    public synchronized void a(float f) {
        if (this.a) {
            return;
        }
        try {
            j(f);
        } catch (Exception e) {
            k(e);
        }
    }

    @Override // b.f.j.p.l
    public synchronized void b(T t, int i) {
        if (this.a) {
            return;
        }
        this.a = e(i);
        try {
            i(t, i);
        } catch (Exception e) {
            k(e);
        }
    }

    @Override // b.f.j.p.l
    public synchronized void c(Throwable th) {
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            h(th);
        } catch (Exception e) {
            k(e);
        }
    }

    @Override // b.f.j.p.l
    public synchronized void d() {
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            g();
        } catch (Exception e) {
            k(e);
        }
    }

    public abstract void g();

    public abstract void h(Throwable th);

    public abstract void i(T t, int i);

    public abstract void j(float f);

    public void k(Exception exc) {
        String strY = b.d.b.a.a.y(EnvironmentCompat.MEDIA_UNKNOWN, ":", getClass().getSimpleName());
        StringBuilder sb = new StringBuilder();
        sb.append("unhandled exception");
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        Log.println(6, strY, sb.toString());
    }
}
