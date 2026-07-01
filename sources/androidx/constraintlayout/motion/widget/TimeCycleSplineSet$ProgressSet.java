package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TimeCycleSplineSet$ProgressSet extends TimeCycleSplineSet {
    public boolean mNoMethod = false;

    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(get(f, j, view, keyCache));
        } else {
            if (this.mNoMethod) {
                return false;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
            }
            Method method2 = method;
            if (method2 != null) {
                try {
                    method2.invoke(view, Float.valueOf(get(f, j, view, keyCache)));
                } catch (IllegalAccessException e) {
                    Log.e("SplineSet", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("SplineSet", "unable to setProgress", e2);
                }
            }
        }
        return this.mContinue;
    }
}
