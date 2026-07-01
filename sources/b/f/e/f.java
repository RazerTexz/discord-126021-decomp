package b.f.e;

import com.facebook.datasource.DataSource;

/* JADX INFO: compiled from: DataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public interface f<T> {
    void onCancellation(DataSource<T> dataSource);

    void onFailure(DataSource<T> dataSource);

    void onNewResult(DataSource<T> dataSource);

    void onProgressUpdate(DataSource<T> dataSource);
}
