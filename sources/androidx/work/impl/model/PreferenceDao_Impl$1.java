package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceDao_Impl$1 extends EntityInsertionAdapter<Preference> {
    public final /* synthetic */ PreferenceDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDao_Impl$1(PreferenceDao_Impl preferenceDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = preferenceDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
        bind2(supportSQLiteStatement, preference);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
        String str = preference.mKey;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        Long l = preference.mValue;
        if (l == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindLong(2, l.longValue());
        }
    }
}
