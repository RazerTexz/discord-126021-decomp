package androidx.transition;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionManager$MultiListener implements ViewTreeObserver$OnPreDrawListener, View$OnAttachStateChangeListener {
    public ViewGroup mSceneRoot;
    public Transition mTransition;

    public TransitionManager$MultiListener(Transition transition, ViewGroup viewGroup) {
        this.mTransition = transition;
        this.mSceneRoot = viewGroup;
    }

    private void removeListeners() {
        this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
        this.mSceneRoot.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        removeListeners();
        if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
            return true;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> runningTransitions = TransitionManager.getRunningTransitions();
        ArrayList<Transition> arrayList = runningTransitions.get(this.mSceneRoot);
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            runningTransitions.put(this.mSceneRoot, arrayList);
        } else if (arrayList.size() > 0) {
            arrayList2 = new ArrayList(arrayList);
        }
        arrayList.add(this.mTransition);
        this.mTransition.addListener(new TransitionManager$MultiListener$1(this, runningTransitions));
        this.mTransition.captureValues(this.mSceneRoot, false);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).resume(this.mSceneRoot);
            }
        }
        this.mTransition.playTransition(this.mSceneRoot);
        return true;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        removeListeners();
        TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
        ArrayList<Transition> arrayList = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().resume(this.mSceneRoot);
            }
        }
        this.mTransition.clearValues(true);
    }
}
