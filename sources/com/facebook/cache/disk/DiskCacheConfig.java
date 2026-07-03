package com.facebook.cache.disk;

import android.content.Context;
import com.discord.api.permission.Permission;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p111b.p112a.C1654d;
import p007b.p109f.p111b.p112a.C1655e;
import p007b.p109f.p111b.p112a.InterfaceC1651a;
import p007b.p109f.p111b.p112a.InterfaceC1652b;
import p007b.p109f.p111b.p113b.C1659b;
import p007b.p109f.p111b.p113b.InterfaceC1664g;
import p007b.p109f.p115d.p116a.C1669b;
import p007b.p109f.p115d.p116a.InterfaceC1668a;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheConfig {

    /* JADX INFO: renamed from: a */
    public final int f19421a;

    /* JADX INFO: renamed from: b */
    public final String f19422b;

    /* JADX INFO: renamed from: c */
    public final Supplier<File> f19423c;

    /* JADX INFO: renamed from: d */
    public final long f19424d;

    /* JADX INFO: renamed from: e */
    public final long f19425e;

    /* JADX INFO: renamed from: f */
    public final long f19426f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC1664g f19427g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC1651a f19428h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC1652b f19429i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC1668a f19430j;

    /* JADX INFO: renamed from: k */
    public final Context f19431k;

    /* JADX INFO: renamed from: com.facebook.cache.disk.DiskCacheConfig$a */
    public class C10633a implements Supplier<File> {
        public C10633a() {
        }

        @Override // com.facebook.common.internal.Supplier
        public File get() {
            Objects.requireNonNull(DiskCacheConfig.this.f19431k);
            return DiskCacheConfig.this.f19431k.getApplicationContext().getCacheDir();
        }
    }

    /* JADX INFO: renamed from: com.facebook.cache.disk.DiskCacheConfig$b */
    public static class C10634b {

        /* JADX INFO: renamed from: b */
        public Supplier<File> f19434b;

        /* JADX INFO: renamed from: e */
        public final Context f19437e;

        /* JADX INFO: renamed from: a */
        public String f19433a = "image_cache";

        /* JADX INFO: renamed from: c */
        public long f19435c = 41943040;

        /* JADX INFO: renamed from: d */
        public InterfaceC1664g f19436d = new C1659b();

        public C10634b(Context context, C10633a c10633a) {
            this.f19437e = context;
        }
    }

    public DiskCacheConfig(C10634b c10634b) {
        C1654d c1654d;
        C1655e c1655e;
        C1669b c1669b;
        Context context = c10634b.f19437e;
        this.f19431k = context;
        C1460d.m423C((c10634b.f19434b == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (c10634b.f19434b == null && context != null) {
            c10634b.f19434b = new C10633a();
        }
        this.f19421a = 1;
        String str = c10634b.f19433a;
        Objects.requireNonNull(str);
        this.f19422b = str;
        Supplier<File> supplier = c10634b.f19434b;
        Objects.requireNonNull(supplier);
        this.f19423c = supplier;
        this.f19424d = c10634b.f19435c;
        this.f19425e = 10485760L;
        this.f19426f = Permission.SPEAK;
        InterfaceC1664g interfaceC1664g = c10634b.f19436d;
        Objects.requireNonNull(interfaceC1664g);
        this.f19427g = interfaceC1664g;
        synchronized (C1654d.class) {
            if (C1654d.f3017a == null) {
                C1654d.f3017a = new C1654d();
            }
            c1654d = C1654d.f3017a;
        }
        this.f19428h = c1654d;
        synchronized (C1655e.class) {
            if (C1655e.f3018a == null) {
                C1655e.f3018a = new C1655e();
            }
            c1655e = C1655e.f3018a;
        }
        this.f19429i = c1655e;
        synchronized (C1669b.class) {
            if (C1669b.f3077a == null) {
                C1669b.f3077a = new C1669b();
            }
            c1669b = C1669b.f3077a;
        }
        this.f19430j = c1669b;
    }
}
