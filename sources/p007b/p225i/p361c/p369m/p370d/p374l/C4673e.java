package p007b.p225i.p361c.p369m.p370d.p374l;

import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;

/* JADX INFO: renamed from: b.i.c.m.d.l.e */
/* JADX INFO: compiled from: QueueFileLogStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4673e implements InterfaceC4669a {

    /* JADX INFO: renamed from: a */
    public static final Charset f12491a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b */
    public final File f12492b;

    /* JADX INFO: renamed from: c */
    public final int f12493c;

    /* JADX INFO: renamed from: d */
    public C4671c f12494d;

    /* JADX INFO: renamed from: b.i.c.m.d.l.e$a */
    /* JADX INFO: compiled from: QueueFileLogStore.java */
    public class a {

        /* JADX INFO: renamed from: a */
        public final byte[] f12495a;

        /* JADX INFO: renamed from: b */
        public final int f12496b;

        public a(C4673e c4673e, byte[] bArr, int i) {
            this.f12495a = bArr;
            this.f12496b = i;
        }
    }

    public C4673e(File file, int i) {
        this.f12492b = file;
        this.f12493c = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.InterfaceC4669a
    /* JADX INFO: renamed from: a */
    public void mo6491a() {
        C4628h.m6409c(this.f12494d, "There was a problem closing the Crashlytics log file.");
        this.f12494d = null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.InterfaceC4669a
    /* JADX INFO: renamed from: b */
    public String mo6492b() {
        byte[] bArrMo6493c = mo6493c();
        if (bArrMo6493c != null) {
            return new String(bArrMo6493c, f12491a);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    @Override // p007b.p225i.p361c.p369m.p370d.p374l.InterfaceC4669a
    /* JADX INFO: renamed from: c */
    public byte[] mo6493c() {
        a aVar;
        if (this.f12492b.exists()) {
            m6513f();
            C4671c c4671c = this.f12494d;
            if (c4671c == null) {
                aVar = null;
            } else {
                int[] iArr = {0};
                byte[] bArr = new byte[c4671c.m6510x()];
                try {
                    this.f12494d.m6504e(new C4672d(this, bArr, iArr));
                } catch (IOException e) {
                    if (C4592b.f12227a.m6370a(6)) {
                        Log.e("FirebaseCrashlytics", "A problem occurred while reading the Crashlytics log file.", e);
                    }
                }
                aVar = new a(this, bArr, iArr[0]);
            }
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        int i = aVar.f12496b;
        byte[] bArr2 = new byte[i];
        System.arraycopy(aVar.f12495a, 0, bArr2, 0, i);
        return bArr2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.InterfaceC4669a
    /* JADX INFO: renamed from: d */
    public void mo6494d() {
        C4628h.m6409c(this.f12494d, "There was a problem closing the Crashlytics log file.");
        this.f12494d = null;
        this.f12492b.delete();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.InterfaceC4669a
    /* JADX INFO: renamed from: e */
    public void mo6495e(long j, String str) {
        m6513f();
        if (this.f12494d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.f12493c / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.f12494d.m6501b(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f12491a));
            while (!this.f12494d.m6505f() && this.f12494d.m6510x() > this.f12493c) {
                this.f12494d.m6507s();
            }
        } catch (IOException e) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m6513f() {
        if (this.f12494d == null) {
            try {
                this.f12494d = new C4671c(this.f12492b);
            } catch (IOException e) {
                C4592b c4592b = C4592b.f12227a;
                StringBuilder sbM833U = C1643a.m833U("Could not open log file: ");
                sbM833U.append(this.f12492b);
                c4592b.m6374e(sbM833U.toString(), e);
            }
        }
    }
}
