package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;

/* JADX INFO: loaded from: classes.dex */
public class WorkSpecDao_Impl$1 extends EntityInsertionAdapter<WorkSpec> {
    public final /* synthetic */ WorkSpecDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkSpecDao_Impl$1(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = workSpecDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
        bind2(supportSQLiteStatement, workSpec);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
        String str = workSpec.f38id;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
        String str2 = workSpec.workerClassName;
        if (str2 == null) {
            supportSQLiteStatement.bindNull(3);
        } else {
            supportSQLiteStatement.bindString(3, str2);
        }
        String str3 = workSpec.inputMergerClassName;
        if (str3 == null) {
            supportSQLiteStatement.bindNull(4);
        } else {
            supportSQLiteStatement.bindString(4, str3);
        }
        byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
        if (byteArrayInternal == null) {
            supportSQLiteStatement.bindNull(5);
        } else {
            supportSQLiteStatement.bindBlob(5, byteArrayInternal);
        }
        byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
        if (byteArrayInternal2 == null) {
            supportSQLiteStatement.bindNull(6);
        } else {
            supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
        }
        supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
        supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
        supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
        supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
        supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
        supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
        supportSQLiteStatement.bindLong(13, workSpec.periodStartTime);
        supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
        supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
        supportSQLiteStatement.bindLong(16, workSpec.runInForeground ? 1L : 0L);
        Constraints constraints = workSpec.constraints;
        if (constraints == null) {
            supportSQLiteStatement.bindNull(17);
            supportSQLiteStatement.bindNull(18);
            supportSQLiteStatement.bindNull(19);
            supportSQLiteStatement.bindNull(20);
            supportSQLiteStatement.bindNull(21);
            supportSQLiteStatement.bindNull(22);
            supportSQLiteStatement.bindNull(23);
            supportSQLiteStatement.bindNull(24);
            return;
        }
        supportSQLiteStatement.bindLong(17, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
        supportSQLiteStatement.bindLong(18, constraints.requiresCharging() ? 1L : 0L);
        supportSQLiteStatement.bindLong(19, constraints.requiresDeviceIdle() ? 1L : 0L);
        supportSQLiteStatement.bindLong(20, constraints.requiresBatteryNotLow() ? 1L : 0L);
        supportSQLiteStatement.bindLong(21, constraints.requiresStorageNotLow() ? 1L : 0L);
        supportSQLiteStatement.bindLong(22, constraints.getTriggerContentUpdateDelay());
        supportSQLiteStatement.bindLong(23, constraints.getTriggerMaxContentDelay());
        byte[] bArrContentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
        if (bArrContentUriTriggersToByteArray == null) {
            supportSQLiteStatement.bindNull(24);
        } else {
            supportSQLiteStatement.bindBlob(24, bArrContentUriTriggersToByteArray);
        }
    }
}
