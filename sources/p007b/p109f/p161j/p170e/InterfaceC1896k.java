package p007b.p109f.p161j.p170e;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Set;
import p007b.p109f.p114c.InterfaceC1667a;
import p007b.p109f.p115d.p117b.InterfaceExecutorServiceC1675f;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p161j.p168c.InterfaceC1852a;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1866m;
import p007b.p109f.p161j.p168c.InterfaceC1871r;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p172g.C1907a;
import p007b.p109f.p161j.p173h.C1910c;
import p007b.p109f.p161j.p173h.InterfaceC1909b;
import p007b.p109f.p161j.p173h.InterfaceC1911d;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p177l.C1952x;
import p007b.p109f.p161j.p181p.InterfaceC2002o0;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: renamed from: b.f.j.e.k */
/* JADX INFO: compiled from: ImagePipelineConfigInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1896k {
    /* JADX INFO: renamed from: A */
    Supplier<MemoryCacheParams> mo1264A();

    /* JADX INFO: renamed from: B */
    InterfaceC1909b mo1265B();

    /* JADX INFO: renamed from: C */
    Supplier<MemoryCacheParams> mo1266C();

    /* JADX INFO: renamed from: D */
    InterfaceC1890e mo1267D();

    /* JADX INFO: renamed from: a */
    C1952x mo1268a();

    /* JADX INFO: renamed from: b */
    Set<InterfaceC1927d> mo1269b();

    /* JADX INFO: renamed from: c */
    int mo1270c();

    /* JADX INFO: renamed from: d */
    Supplier<Boolean> mo1271d();

    /* JADX INFO: renamed from: e */
    InterfaceC1891f mo1272e();

    /* JADX INFO: renamed from: f */
    C1907a mo1273f();

    /* JADX INFO: renamed from: g */
    InterfaceC1852a mo1274g();

    Context getContext();

    C1897l getExperiments();

    /* JADX INFO: renamed from: h */
    InterfaceC2002o0 mo1275h();

    /* JADX INFO: renamed from: i */
    InterfaceC1876w<CacheKey, PooledByteBuffer> mo1276i();

    /* JADX INFO: renamed from: j */
    DiskCacheConfig mo1277j();

    /* JADX INFO: renamed from: k */
    Set<InterfaceC1928e> mo1278k();

    /* JADX INFO: renamed from: l */
    InterfaceC1862i mo1279l();

    /* JADX INFO: renamed from: m */
    boolean mo1280m();

    /* JADX INFO: renamed from: n */
    InterfaceC1876w.a mo1281n();

    /* JADX INFO: renamed from: o */
    InterfaceC1911d mo1282o();

    /* JADX INFO: renamed from: p */
    DiskCacheConfig mo1283p();

    /* JADX INFO: renamed from: q */
    InterfaceC1871r mo1284q();

    /* JADX INFO: renamed from: r */
    InterfaceC1866m.b<CacheKey> mo1285r();

    /* JADX INFO: renamed from: s */
    boolean mo1286s();

    /* JADX INFO: renamed from: t */
    InterfaceExecutorServiceC1675f mo1287t();

    /* JADX INFO: renamed from: u */
    Integer mo1288u();

    /* JADX INFO: renamed from: v */
    InterfaceC2033c mo1289v();

    /* JADX INFO: renamed from: w */
    InterfaceC1696c mo1290w();

    /* JADX INFO: renamed from: x */
    C1910c mo1291x();

    /* JADX INFO: renamed from: y */
    boolean mo1292y();

    /* JADX INFO: renamed from: z */
    InterfaceC1667a mo1293z();
}
