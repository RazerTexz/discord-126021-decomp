package p007b.p109f.p129e;

import com.facebook.datasource.DataSource;

/* JADX INFO: renamed from: b.f.e.d */
/* JADX INFO: compiled from: BaseDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1724d<T> implements InterfaceC1726f<T> {
    @Override // p007b.p109f.p129e.InterfaceC1726f
    public void onCancellation(DataSource<T> dataSource) {
    }

    @Override // p007b.p109f.p129e.InterfaceC1726f
    public void onFailure(DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    public abstract void onFailureImpl(DataSource<T> dataSource);

    @Override // p007b.p109f.p129e.InterfaceC1726f
    public void onNewResult(DataSource<T> dataSource) {
        boolean zMo1019c = dataSource.mo1019c();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (zMo1019c) {
                dataSource.close();
            }
        }
    }

    public abstract void onNewResultImpl(DataSource<T> dataSource);

    @Override // p007b.p109f.p129e.InterfaceC1726f
    public void onProgressUpdate(DataSource<T> dataSource) {
    }
}
