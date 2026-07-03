package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Lazy;
import kotlin.Unit;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {
    private final ActivityResultContract<I, O> callerContract;
    private final I input;
    private final ActivityResultLauncher<I> launcher;

    /* JADX INFO: renamed from: resultContract$delegate, reason: from kotlin metadata */
    private final Lazy resultContract;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> activityResultLauncher, ActivityResultContract<I, O> activityResultContract, I i) {
        C12238m.checkNotNullParameter(activityResultLauncher, "launcher");
        C12238m.checkNotNullParameter(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.input = i;
        this.resultContract = C12083g.lazy(new ActivityResultCallerLauncher$resultContract$2(this));
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<Unit, ?> getContract() {
        return getResultContract();
    }

    public final I getInput() {
        return this.input;
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.resultContract.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(Unit unit, ActivityOptionsCompat options) {
        this.launcher.launch(this.input, options);
    }
}
