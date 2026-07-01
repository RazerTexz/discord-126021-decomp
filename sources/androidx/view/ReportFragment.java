package androidx.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build$VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ReportFragment$ActivityInitializationListener mProcessListener;

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatch(@NonNull Activity activity, @NonNull Lifecycle$Event lifecycle$Event) {
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(lifecycle$Event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).handleLifecycleEvent(lifecycle$Event);
            }
        }
    }

    private void dispatchCreate(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        if (reportFragment$ActivityInitializationListener != null) {
            reportFragment$ActivityInitializationListener.onCreate();
        }
    }

    private void dispatchResume(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        if (reportFragment$ActivityInitializationListener != null) {
            reportFragment$ActivityInitializationListener.onResume();
        }
    }

    private void dispatchStart(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        if (reportFragment$ActivityInitializationListener != null) {
            reportFragment$ActivityInitializationListener.onStart();
        }
    }

    public static ReportFragment get(Activity activity) {
        return (ReportFragment) activity.getFragmentManager().findFragmentByTag(REPORT_FRAGMENT_TAG);
    }

    public static void injectIfNeededIn(Activity activity) {
        if (Build$VERSION.SDK_INT >= 29) {
            ReportFragment$LifecycleCallbacks.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag(REPORT_FRAGMENT_TAG) == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), REPORT_FRAGMENT_TAG).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatchCreate(this.mProcessListener);
        dispatch(Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle$Event.ON_DESTROY);
        this.mProcessListener = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dispatch(Lifecycle$Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        dispatchResume(this.mProcessListener);
        dispatch(Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        dispatchStart(this.mProcessListener);
        dispatch(Lifecycle$Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        dispatch(Lifecycle$Event.ON_STOP);
    }

    public void setProcessListener(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        this.mProcessListener = reportFragment$ActivityInitializationListener;
    }

    private void dispatch(@NonNull Lifecycle$Event lifecycle$Event) {
        if (Build$VERSION.SDK_INT < 29) {
            dispatch(getActivity(), lifecycle$Event);
        }
    }
}
