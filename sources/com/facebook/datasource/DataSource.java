package com.facebook.datasource;

import b.f.e.DataSubscriber;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface DataSource<T> {
    Map<String, Object> a();

    boolean b();

    boolean c();

    boolean close();

    Throwable d();

    boolean e();

    void f(DataSubscriber<T> dataSubscriber, Executor executor);

    float getProgress();

    T getResult();
}
