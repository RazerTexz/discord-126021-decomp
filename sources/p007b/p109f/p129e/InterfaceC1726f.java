package p007b.p109f.p129e;

import com.facebook.datasource.DataSource;

/* JADX INFO: renamed from: b.f.e.f */
/* JADX INFO: compiled from: DataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1726f<T> {
    void onCancellation(DataSource<T> dataSource);

    void onFailure(DataSource<T> dataSource);

    void onNewResult(DataSource<T> dataSource);

    void onProgressUpdate(DataSource<T> dataSource);
}
