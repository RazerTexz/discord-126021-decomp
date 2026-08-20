package p007b.p109f.p111b.p113b;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p110a.C1650a;
import p007b.p109f.p111b.p112a.C1654d;
import p007b.p109f.p111b.p112a.InterfaceC1651a;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.b.b.e */
/* JADX INFO: compiled from: DynamicDefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class C1662e implements InterfaceC1660c {

    /* JADX INFO: renamed from: a */
    public final int f3065a;

    /* JADX INFO: renamed from: b */
    public final Supplier<File> f3066b;

    /* JADX INFO: renamed from: c */
    public final String f3067c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1651a f3068d;

    /* JADX INFO: renamed from: e */
    @VisibleForTesting
    public volatile a f3069e = new a(null, null);

    /* JADX INFO: renamed from: b.f.b.b.e$a */
    /* JADX INFO: compiled from: DynamicDefaultDiskStorage.java */
    @VisibleForTesting
    public static class a {

        /* JADX INFO: renamed from: a */
        public final InterfaceC1660c f3070a;

        /* JADX INFO: renamed from: b */
        public final File f3071b;

        @VisibleForTesting
        public a(File file, InterfaceC1660c interfaceC1660c) {
            this.f3070a = interfaceC1660c;
            this.f3071b = file;
        }
    }

    public C1662e(int i, Supplier<File> supplier, String str, InterfaceC1651a interfaceC1651a) {
        this.f3065a = i;
        this.f3068d = interfaceC1651a;
        this.f3066b = supplier;
        this.f3067c = str;
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: a */
    public void mo932a() {
        try {
            m960i().mo932a();
        } catch (IOException e) {
            C1691a.m974b(C1662e.class, "purgeUnexpectedResources", e);
        }
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: b */
    public InterfaceC1660c.b mo933b(String str, Object obj) throws IOException {
        return m960i().mo933b(str, obj);
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: c */
    public boolean mo934c(String str, Object obj) throws IOException {
        return m960i().mo934c(str, obj);
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: d */
    public C1650a mo935d(String str, Object obj) throws IOException {
        return m960i().mo935d(str, obj);
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: e */
    public Collection<InterfaceC1660c.a> mo936e() throws IOException {
        return m960i().mo936e();
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: f */
    public long mo937f(String str) throws IOException {
        return m960i().mo937f(str);
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: g */
    public long mo938g(InterfaceC1660c.a aVar) throws IOException {
        return m960i().mo938g(aVar);
    }

    /* JADX INFO: renamed from: h */
    public final void m959h() throws IOException {
        File file = new File(this.f3066b.get(), this.f3067c);
        try {
            C1460d.m541l1(file);
            file.getAbsolutePath();
            int i = C1691a.f3102a;
            this.f3069e = new a(file, new C1658a(file, this.f3065a, this.f3068d));
        } catch (FileUtils$CreateDirectoryException e) {
            Objects.requireNonNull((C1654d) this.f3068d);
            throw e;
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: i */
    public synchronized InterfaceC1660c m960i() throws IOException {
        InterfaceC1660c interfaceC1660c;
        File file;
        a aVar = this.f3069e;
        if (aVar.f3070a == null || (file = aVar.f3071b) == null || !file.exists()) {
            if (this.f3069e.f3070a != null && this.f3069e.f3071b != null) {
                C1460d.m492Z(this.f3069e.f3071b);
            }
            m959h();
        }
        interfaceC1660c = this.f3069e.f3070a;
        Objects.requireNonNull(interfaceC1660c);
        return interfaceC1660c;
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    public boolean isExternal() {
        try {
            return m960i().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }
}
