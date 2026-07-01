package androidx.work.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    private static boolean enqueueContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean zEnqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return zEnqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0199  */
    /* JADX WARN: Code duplicated, block: B:113:0x019d  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:123:0x01bc A[LOOP:4: B:122:0x01ba->B:123:0x01bc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:127:0x01e1 A[LOOP:5: B:125:0x01db->B:127:0x01e1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:129:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:144:0x020a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x014e A[PHI: r1 r9 r12 r13 r14
      0x014e: PHI (r1v1 java.lang.String[]) = (r1v0 java.lang.String[]), (r1v0 java.lang.String[]), (r1v4 java.lang.String[]) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r9v2 boolean) = (r9v1 boolean), (r9v1 boolean), (r9v7 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v4 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v5 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r14v2 boolean) = (r14v1 boolean), (r14v1 boolean), (r14v5 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:121:0x01b8, please report this as an issue */
    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, @NonNull List<? extends WorkRequest> list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        Iterator<String> it;
        int i2;
        boolean z6;
        List listEmptyList;
        WorkManagerImpl workManagerImpl2 = workManagerImpl;
        String[] strArr2 = strArr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        boolean z7 = strArr2 != null && strArr2.length > 0;
        if (z7) {
            z2 = true;
            z3 = false;
            z4 = false;
            for (String str2 : strArr2) {
                WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(str2);
                if (workSpec == null) {
                    Logger.get().error(TAG, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                WorkInfo.State state = workSpec.state;
                z2 &= state == WorkInfo.State.SUCCEEDED;
                if (state == WorkInfo.State.FAILED) {
                    z4 = true;
                } else if (state == WorkInfo.State.CANCELLED) {
                    z3 = true;
                }
            }
        } else {
            z2 = true;
            z3 = false;
            z4 = false;
        }
        boolean z8 = !TextUtils.isEmpty(str);
        if (z8 && !z7) {
            List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workDatabase.workSpecDao().getWorkSpecIdAndStatesForName(str);
            if (workSpecIdAndStatesForName.isEmpty()) {
                z5 = false;
            } else if (existingWorkPolicy == ExistingWorkPolicy.APPEND || existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) {
                DependencyDao dependencyDao = workDatabase.dependencyDao();
                ArrayList arrayList = new ArrayList();
                for (WorkSpec.IdAndState idAndState : workSpecIdAndStatesForName) {
                    if (!dependencyDao.hasDependents(idAndState.f39id)) {
                        WorkInfo.State state2 = idAndState.state;
                        boolean z9 = (state2 == WorkInfo.State.SUCCEEDED) & z2;
                        if (state2 == WorkInfo.State.FAILED) {
                            z4 = true;
                        } else if (state2 == WorkInfo.State.CANCELLED) {
                            z3 = true;
                        }
                        arrayList.add(idAndState.f39id);
                        z2 = z9;
                    }
                    dependencyDao = dependencyDao;
                }
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE && (z3 || z4)) {
                    WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                    Iterator<WorkSpec.IdAndState> it2 = workSpecDao.getWorkSpecIdAndStatesForName(str).iterator();
                    while (it2.hasNext()) {
                        workSpecDao.delete(it2.next().f39id);
                    }
                    z6 = false;
                    z3 = false;
                    listEmptyList = Collections.emptyList();
                } else {
                    z6 = z4;
                    listEmptyList = arrayList;
                }
                strArr2 = (String[]) listEmptyList.toArray(strArr2);
                z7 = strArr2.length > 0;
                z4 = z6;
                z5 = false;
            } else {
                if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                    Iterator<WorkSpec.IdAndState> it3 = workSpecIdAndStatesForName.iterator();
                    while (it3.hasNext()) {
                        WorkInfo.State state3 = it3.next().state;
                        if (state3 == WorkInfo.State.ENQUEUED || state3 == WorkInfo.State.RUNNING) {
                            return false;
                        }
                    }
                }
                CancelWorkRunnable.forName(str, workManagerImpl2, false).run();
                WorkSpecDao workSpecDao2 = workDatabase.workSpecDao();
                Iterator<WorkSpec.IdAndState> it4 = workSpecIdAndStatesForName.iterator();
                while (it4.hasNext()) {
                    workSpecDao2.delete(it4.next().f39id);
                }
                z5 = true;
            }
        } else {
            z5 = false;
        }
        for (WorkRequest workRequest : list) {
            WorkSpec workSpec2 = workRequest.getWorkSpec();
            if (!z7 || z2) {
                if (workSpec2.isPeriodic()) {
                    workSpec2.periodStartTime = 0L;
                } else {
                    workSpec2.periodStartTime = jCurrentTimeMillis;
                }
                i = Build.VERSION.SDK_INT;
                if (i < 23 && i <= 25) {
                    tryDelegateConstrainedWorkSpec(workSpec2);
                } else if (i <= 22 && usesScheduler(workManagerImpl2, Schedulers.GCM_SCHEDULER)) {
                    tryDelegateConstrainedWorkSpec(workSpec2);
                }
                if (workSpec2.state == WorkInfo.State.ENQUEUED) {
                    z5 = true;
                }
                workDatabase.workSpecDao().insertWorkSpec(workSpec2);
                if (z7) {
                    for (String str3 : strArr2) {
                        workDatabase.dependencyDao().insertDependency(new Dependency(workRequest.getStringId(), str3));
                    }
                }
                it = workRequest.getTags().iterator();
                while (it.hasNext()) {
                    workDatabase.workTagDao().insert(new WorkTag(it.next(), workRequest.getStringId()));
                }
                if (z8) {
                    workDatabase.workNameDao().insert(new WorkName(str, workRequest.getStringId()));
                }
                workManagerImpl2 = workManagerImpl;
                jCurrentTimeMillis = jCurrentTimeMillis;
            } else if (z4) {
                workSpec2.state = WorkInfo.State.FAILED;
            } else if (z3) {
                workSpec2.state = WorkInfo.State.CANCELLED;
            } else {
                workSpec2.state = WorkInfo.State.BLOCKED;
            }
            i = Build.VERSION.SDK_INT;
            if (i < 23) {
                if (i <= 22) {
                    tryDelegateConstrainedWorkSpec(workSpec2);
                }
            } else if (i <= 22) {
                tryDelegateConstrainedWorkSpec(workSpec2);
            }
            if (workSpec2.state == WorkInfo.State.ENQUEUED) {
                z5 = true;
            }
            workDatabase.workSpecDao().insertWorkSpec(workSpec2);
            if (z7) {
                while (i2 < r4) {
                    workDatabase.dependencyDao().insertDependency(new Dependency(workRequest.getStringId(), str3));
                }
            }
            it = workRequest.getTags().iterator();
            while (it.hasNext()) {
                workDatabase.workTagDao().insert(new WorkTag(it.next(), workRequest.getStringId()));
            }
            if (z8) {
                workDatabase.workNameDao().insert(new WorkName(str, workRequest.getStringId()));
            }
            workManagerImpl2 = workManagerImpl;
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
        return z5;
    }

    private static boolean processContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z2 = false;
        if (parents != null) {
            boolean zProcessContinuation = false;
            for (WorkContinuationImpl workContinuationImpl2 : parents) {
                if (workContinuationImpl2.isEnqueued()) {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", workContinuationImpl2.getIds())), new Throwable[0]);
                } else {
                    zProcessContinuation |= processContinuation(workContinuationImpl2);
                }
            }
            z2 = zProcessContinuation;
        }
        return enqueueContinuation(workContinuationImpl) | z2;
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            String str = workSpec.workerClassName;
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<Scheduler> it = workManagerImpl.getSchedulers().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean zProcessContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return zProcessContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mWorkContinuation.hasCycles()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.mWorkContinuation));
            }
            if (addToDatabase()) {
                PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                scheduleWorkInBackground();
            }
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
