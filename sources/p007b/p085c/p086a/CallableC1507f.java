package p007b.p085c.p086a;

import android.content.Context;
import androidx.core.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p099z.C1612b;
import p007b.p085c.p086a.p099z.C1613c;
import p007b.p085c.p086a.p099z.EnumC1611a;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.f */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class CallableC1507f implements Callable<C1517p<C1505d>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Context f2355j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f2356k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f2357l;

    public CallableC1507f(Context context, String str, String str2) {
        this.f2355j = context;
        this.f2356k = str;
        this.f2357l = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public C1517p<C1505d> call() throws Exception {
        Pair pair;
        C1613c c1613c = new C1613c(this.f2355j, this.f2356k, this.f2357l);
        EnumC1611a enumC1611a = EnumC1611a.ZIP;
        C1612b c1612b = c1613c.f2930c;
        C1505d c1505d = null;
        if (c1612b != null) {
            String str = c1613c.f2929b;
            try {
                File fileM794b = c1612b.m794b();
                EnumC1611a enumC1611a2 = EnumC1611a.JSON;
                File file = new File(fileM794b, C1612b.m793a(str, enumC1611a2, false));
                if (!file.exists()) {
                    file = new File(c1612b.m794b(), C1612b.m793a(str, enumC1611a, false));
                    if (!file.exists()) {
                        file = null;
                    }
                }
                if (file == null) {
                    pair = null;
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (file.getAbsolutePath().endsWith(".zip")) {
                        enumC1611a2 = enumC1611a;
                    }
                    StringBuilder sbM837Y = C1643a.m837Y("Cache hit for ", str, " at ");
                    sbM837Y.append(file.getAbsolutePath());
                    C1495c.m639a(sbM837Y.toString());
                    pair = new Pair(enumC1611a2, fileInputStream);
                }
            } catch (FileNotFoundException unused) {
            }
            if (pair != null) {
                EnumC1611a enumC1611a3 = (EnumC1611a) pair.first;
                InputStream inputStream = (InputStream) pair.second;
                C1505d c1505d2 = (enumC1611a3 == enumC1611a ? C1506e.m677d(new ZipInputStream(inputStream), c1613c.f2929b) : C1506e.m675b(inputStream, c1613c.f2929b)).f2449a;
                if (c1505d2 != null) {
                    c1505d = c1505d2;
                }
            }
        }
        if (c1505d != null) {
            return new C1517p<>(c1505d);
        }
        StringBuilder sbM833U = C1643a.m833U("Animation for ");
        sbM833U.append(c1613c.f2929b);
        sbM833U.append(" not found in cache. Fetching from network.");
        C1495c.m639a(sbM833U.toString());
        try {
            return c1613c.m796a();
        } catch (IOException e) {
            return new C1517p<>((Throwable) e);
        }
    }
}
