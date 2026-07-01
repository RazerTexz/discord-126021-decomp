package b.f.e;

import com.facebook.datasource.DataSource;

/* JADX INFO: compiled from: BaseDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T> implements f<T> {
    @Override // b.f.e.f
    public void onCancellation(DataSource<T> dataSource) {
    }

    @Override // b.f.e.f
    public void onFailure(DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    public abstract void onFailureImpl(DataSource<T> dataSource);

    @Override // b.f.e.f
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

    @Override // b.f.e.f
    public void onProgressUpdate(DataSource<T> dataSource) {
    }
}
