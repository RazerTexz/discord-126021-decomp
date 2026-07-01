package com.google.zxing;

import b.i.e.BarcodeFormat;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Result {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3140b;
    public ResultPoint[] c;
    public final BarcodeFormat d;
    public Map<ResultMetadataType, Object> e;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        System.currentTimeMillis();
        this.a = str;
        this.f3140b = bArr;
        this.c = resultPointArr;
        this.d = barcodeFormat;
        this.e = null;
    }

    public void a(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.e;
            if (map2 == null) {
                this.e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void b(ResultMetadataType resultMetadataType, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(ResultMetadataType.class);
        }
        this.e.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.a;
    }

    public Result(String str, byte[] bArr, int i, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this.a = str;
        this.f3140b = bArr;
        this.c = resultPointArr;
        this.d = barcodeFormat;
        this.e = null;
    }
}
