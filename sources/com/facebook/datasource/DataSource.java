package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.Executor;
import p007b.p109f.p129e.InterfaceC1726f;

/* JADX INFO: loaded from: classes.dex */
public interface DataSource<T> {
    /* JADX INFO: renamed from: a */
    Map<String, Object> mo1017a();

    /* JADX INFO: renamed from: b */
    boolean mo1018b();

    /* JADX INFO: renamed from: c */
    boolean mo1019c();

    boolean close();

    /* JADX INFO: renamed from: d */
    Throwable mo1020d();

    /* JADX INFO: renamed from: e */
    boolean mo1021e();

    /* JADX INFO: renamed from: f */
    void mo1022f(InterfaceC1726f<T> interfaceC1726f, Executor executor);

    float getProgress();

    T getResult();
}
