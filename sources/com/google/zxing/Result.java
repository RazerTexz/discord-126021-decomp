package com.google.zxing;

import b.i.e.a;
import b.i.e.j;
import b.i.e.k;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Result {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3140b;
    public k[] c;
    public final a d;
    public Map<j, Object> e;

    public Result(String str, byte[] bArr, k[] kVarArr, a aVar) {
        System.currentTimeMillis();
        this.a = str;
        this.f3140b = bArr;
        this.c = kVarArr;
        this.d = aVar;
        this.e = null;
    }

    public void a(Map<j, Object> map) {
        if (map != null) {
            Map<j, Object> map2 = this.e;
            if (map2 == null) {
                this.e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void b(j jVar, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(j.class);
        }
        this.e.put(jVar, obj);
    }

    public String toString() {
        return this.a;
    }

    public Result(String str, byte[] bArr, int i, k[] kVarArr, a aVar, long j) {
        this.a = str;
        this.f3140b = bArr;
        this.c = kVarArr;
        this.d = aVar;
        this.e = null;
    }
}
