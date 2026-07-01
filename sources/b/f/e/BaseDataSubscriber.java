package b.f.e;

import com.facebook.datasource.DataSource;

/* JADX INFO: renamed from: b.f.e.d, reason: use source file name */
/* JADX INFO: compiled from: BaseDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    @Override // b.f.e.DataSubscriber
    public void onCancellation(DataSource<T> dataSource) {
    }

    @Override // b.f.e.DataSubscriber
    public void onFailure(DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    public abstract void onFailureImpl(DataSource<T> dataSource);

    @Override // b.f.e.DataSubscriber
    public void onNewResult(DataSource<T> dataSource) {
        boolean zC = dataSource.c();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (zC) {
                dataSource.close();
            }
        }
    }

    public abstract void onNewResultImpl(DataSource<T> dataSource);

    @Override // b.f.e.DataSubscriber
    public void onProgressUpdate(DataSource<T> dataSource) {
    }
}
