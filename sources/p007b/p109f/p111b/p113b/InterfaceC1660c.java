package p007b.p109f.p111b.p113b;

import java.io.IOException;
import java.util.Collection;
import p007b.p109f.p110a.C1650a;

/* JADX INFO: renamed from: b.f.b.b.c */
/* JADX INFO: compiled from: DiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1660c {

    /* JADX INFO: renamed from: b.f.b.b.c$a */
    /* JADX INFO: compiled from: DiskStorage.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        long mo945a();

        String getId();

        long getSize();
    }

    /* JADX INFO: renamed from: b.f.b.b.c$b */
    /* JADX INFO: compiled from: DiskStorage.java */
    public interface b {
    }

    /* JADX INFO: renamed from: a */
    void mo932a();

    /* JADX INFO: renamed from: b */
    b mo933b(String str, Object obj) throws IOException;

    /* JADX INFO: renamed from: c */
    boolean mo934c(String str, Object obj) throws IOException;

    /* JADX INFO: renamed from: d */
    C1650a mo935d(String str, Object obj) throws IOException;

    /* JADX INFO: renamed from: e */
    Collection<a> mo936e() throws IOException;

    /* JADX INFO: renamed from: f */
    long mo937f(String str) throws IOException;

    /* JADX INFO: renamed from: g */
    long mo938g(a aVar) throws IOException;

    boolean isExternal();
}
