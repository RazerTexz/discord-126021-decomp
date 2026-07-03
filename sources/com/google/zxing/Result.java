package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4955j;

/* JADX INFO: loaded from: classes3.dex */
public final class Result {

    /* JADX INFO: renamed from: a */
    public final String f21668a;

    /* JADX INFO: renamed from: b */
    public final byte[] f21669b;

    /* JADX INFO: renamed from: c */
    public C4956k[] f21670c;

    /* JADX INFO: renamed from: d */
    public final EnumC4946a f21671d;

    /* JADX INFO: renamed from: e */
    public Map<EnumC4955j, Object> f21672e;

    public Result(String str, byte[] bArr, C4956k[] c4956kArr, EnumC4946a enumC4946a) {
        System.currentTimeMillis();
        this.f21668a = str;
        this.f21669b = bArr;
        this.f21670c = c4956kArr;
        this.f21671d = enumC4946a;
        this.f21672e = null;
    }

    /* JADX INFO: renamed from: a */
    public void m9261a(Map<EnumC4955j, Object> map) {
        if (map != null) {
            Map<EnumC4955j, Object> map2 = this.f21672e;
            if (map2 == null) {
                this.f21672e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9262b(EnumC4955j enumC4955j, Object obj) {
        if (this.f21672e == null) {
            this.f21672e = new EnumMap(EnumC4955j.class);
        }
        this.f21672e.put(enumC4955j, obj);
    }

    public String toString() {
        return this.f21668a;
    }

    public Result(String str, byte[] bArr, int i, C4956k[] c4956kArr, EnumC4946a enumC4946a, long j) {
        this.f21668a = str;
        this.f21669b = bArr;
        this.f21670c = c4956kArr;
        this.f21671d = enumC4946a;
        this.f21672e = null;
    }
}
