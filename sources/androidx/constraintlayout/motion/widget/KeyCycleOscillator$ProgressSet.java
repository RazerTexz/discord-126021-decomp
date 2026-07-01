package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycleOscillator$ProgressSet extends KeyCycleOscillator {
    public boolean mNoMethod = false;

    @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
    public void setProperty(View view, float f) {
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(get(f));
            return;
        }
        if (this.mNoMethod) {
            return;
        }
        Method method = null;
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.mNoMethod = true;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(get(f)));
            } catch (IllegalAccessException e) {
                Log.e("KeyCycleOscillator", "unable to setProgress", e);
            } catch (InvocationTargetException e2) {
                Log.e("KeyCycleOscillator", "unable to setProgress", e2);
            }
        }
    }
}
