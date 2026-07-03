package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.p006db.SupportSQLiteQuery;
import androidx.view.LiveData;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface RawWorkInfoDao {
    @NonNull
    @RawQuery
    List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(@NonNull SupportSQLiteQuery supportSQLiteQuery);

    @NonNull
    @RawQuery
    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(@NonNull SupportSQLiteQuery supportSQLiteQuery);
}
