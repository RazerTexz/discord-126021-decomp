package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {
    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<DefaultSpecialEffectsController$AnimationInfo> list, @NonNull List<SpecialEffectsController$Operation> list2, boolean z2, @NonNull Map<SpecialEffectsController$Operation, Boolean> map) {
        ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList<DefaultSpecialEffectsController$AnimationInfo> arrayList = new ArrayList();
        boolean z3 = false;
        for (DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo : list) {
            if (defaultSpecialEffectsController$AnimationInfo.isVisibilityUnchanged()) {
                defaultSpecialEffectsController$AnimationInfo.completeSpecialEffect();
            } else {
                FragmentAnim$AnimationOrAnimator animation = defaultSpecialEffectsController$AnimationInfo.getAnimation(context);
                if (animation == null) {
                    defaultSpecialEffectsController$AnimationInfo.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(defaultSpecialEffectsController$AnimationInfo);
                    } else {
                        SpecialEffectsController$Operation operation = defaultSpecialEffectsController$AnimationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            defaultSpecialEffectsController$AnimationInfo.completeSpecialEffect();
                        } else {
                            boolean z4 = operation.getFinalState() == SpecialEffectsController$Operation$State.GONE;
                            if (z4) {
                                list2.remove(operation);
                            }
                            View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new DefaultSpecialEffectsController$2(this, container, view, z4, operation, defaultSpecialEffectsController$AnimationInfo));
                            animator.setTarget(view);
                            animator.start();
                            defaultSpecialEffectsController$AnimationInfo.getSignal().setOnCancelListener(new DefaultSpecialEffectsController$3(this, animator));
                            z3 = true;
                        }
                    }
                }
            }
        }
        for (DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo2 : arrayList) {
            SpecialEffectsController$Operation operation2 = defaultSpecialEffectsController$AnimationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                defaultSpecialEffectsController$AnimationInfo2.completeSpecialEffect();
            } else if (z3) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                defaultSpecialEffectsController$AnimationInfo2.completeSpecialEffect();
            } else {
                View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim$AnimationOrAnimator) Preconditions.checkNotNull(defaultSpecialEffectsController$AnimationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController$Operation$State.REMOVED) {
                    view2.startAnimation(animation2);
                    defaultSpecialEffectsController$AnimationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation = new FragmentAnim$EndViewTransitionAnimation(animation2, container, view2);
                    fragmentAnim$EndViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$4(this, container, view2, defaultSpecialEffectsController$AnimationInfo2));
                    view2.startAnimation(fragmentAnim$EndViewTransitionAnimation);
                }
                defaultSpecialEffectsController$AnimationInfo2.getSignal().setOnCancelListener(new DefaultSpecialEffectsController$5(this, view2, container, defaultSpecialEffectsController$AnimationInfo2));
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController$Operation, Boolean> startTransitions(@NonNull List<DefaultSpecialEffectsController$TransitionInfo> list, boolean z2, @Nullable SpecialEffectsController$Operation specialEffectsController$Operation, @Nullable SpecialEffectsController$Operation specialEffectsController$Operation2) {
        SpecialEffectsController$Operation specialEffectsController$Operation3;
        Object obj;
        View view;
        Object obj2;
        ArrayList arrayList;
        Rect rect;
        HashMap map;
        ArrayList<View> arrayList2;
        View view2;
        ArrayList arrayList3;
        Rect rect2;
        HashMap map2;
        Object objMergeTransitionsTogether;
        View view3;
        HashMap map3;
        Rect rect3;
        View view4;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList4;
        View view5;
        String strFindKeyForValue;
        ArrayList<String> arrayList5;
        HashMap map4 = new HashMap();
        FragmentTransitionImpl fragmentTransitionImpl = null;
        for (DefaultSpecialEffectsController$TransitionInfo defaultSpecialEffectsController$TransitionInfo : list) {
            if (!defaultSpecialEffectsController$TransitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = defaultSpecialEffectsController$TransitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl == null) {
                    fragmentTransitionImpl = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl != handlingImpl) {
                    StringBuilder sbU = a.U("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    sbU.append(defaultSpecialEffectsController$TransitionInfo.getOperation().getFragment());
                    sbU.append(" returned Transition ");
                    sbU.append(defaultSpecialEffectsController$TransitionInfo.getTransition());
                    sbU.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(sbU.toString());
                }
            }
        }
        if (fragmentTransitionImpl == null) {
            for (DefaultSpecialEffectsController$TransitionInfo defaultSpecialEffectsController$TransitionInfo2 : list) {
                map4.put(defaultSpecialEffectsController$TransitionInfo2.getOperation(), Boolean.FALSE);
                defaultSpecialEffectsController$TransitionInfo2.completeSpecialEffect();
            }
            return map4;
        }
        View view6 = new View(getContainer().getContext());
        Rect rect4 = new Rect();
        ArrayList<View> arrayList6 = new ArrayList<>();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayMap arrayMap = new ArrayMap();
        Object obj3 = null;
        SpecialEffectsController$Operation specialEffectsController$Operation4 = specialEffectsController$Operation2;
        View view7 = null;
        boolean z3 = false;
        SpecialEffectsController$Operation specialEffectsController$Operation5 = specialEffectsController$Operation;
        for (DefaultSpecialEffectsController$TransitionInfo defaultSpecialEffectsController$TransitionInfo3 : list) {
            if (!defaultSpecialEffectsController$TransitionInfo3.hasSharedElementTransition() || specialEffectsController$Operation5 == null || specialEffectsController$Operation4 == null) {
                view3 = view7;
            } else {
                Object objWrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(defaultSpecialEffectsController$TransitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = specialEffectsController$Operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = specialEffectsController$Operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = specialEffectsController$Operation.getFragment().getSharedElementTargetNames();
                int i = 0;
                while (i < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    ArrayList<String> arrayList8 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                    sharedElementTargetNames = arrayList8;
                }
                ArrayList<String> sharedElementTargetNames2 = specialEffectsController$Operation2.getFragment().getSharedElementTargetNames();
                if (z2 == 0) {
                    enterTransitionCallback = specialEffectsController$Operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = specialEffectsController$Operation2.getFragment().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = specialEffectsController$Operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = specialEffectsController$Operation2.getFragment().getExitTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                int i2 = 0;
                while (i2 < size) {
                    arrayMap.put(sharedElementSourceNames.get(i2), sharedElementTargetNames2.get(i2));
                    i2++;
                    size = size;
                    view7 = view7;
                }
                view3 = view7;
                ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
                findNamedViews(arrayMap2, specialEffectsController$Operation.getFragment().mView);
                arrayMap2.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap2);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view8 = arrayMap2.get(str);
                        if (view8 == null) {
                            arrayMap.remove(str);
                            arrayList5 = sharedElementSourceNames;
                        } else {
                            arrayList5 = sharedElementSourceNames;
                            if (!str.equals(ViewCompat.getTransitionName(view8))) {
                                arrayMap.put(ViewCompat.getTransitionName(view8), (String) arrayMap.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList5;
                    }
                    arrayList4 = sharedElementSourceNames;
                } else {
                    arrayList4 = sharedElementSourceNames;
                    arrayMap.retainAll(arrayMap2.keySet());
                }
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, specialEffectsController$Operation2.getFragment().mView);
                arrayMap3.retainAll(sharedElementTargetNames2);
                arrayMap3.retainAll(arrayMap.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap3);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view9 = arrayMap3.get(str2);
                        if (view9 == null) {
                            String strFindKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, str2);
                            if (strFindKeyForValue2 != null) {
                                arrayMap.remove(strFindKeyForValue2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view9)) && (strFindKeyForValue = FragmentTransition.findKeyForValue(arrayMap, str2)) != null) {
                            arrayMap.put(strFindKeyForValue, ViewCompat.getTransitionName(view9));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap, arrayMap3);
                }
                retainMatchingViews(arrayMap2, arrayMap.keySet());
                retainMatchingViews(arrayMap3, arrayMap.values());
                if (arrayMap.isEmpty()) {
                    arrayList6.clear();
                    arrayList7.clear();
                    obj3 = null;
                    specialEffectsController$Operation5 = specialEffectsController$Operation;
                    specialEffectsController$Operation4 = specialEffectsController$Operation2;
                } else {
                    FragmentTransition.callSharedElementStartEnd(specialEffectsController$Operation2.getFragment(), specialEffectsController$Operation.getFragment(), z2, arrayMap2, true);
                    ArrayList<String> arrayList9 = arrayList4;
                    ArrayMap arrayMap4 = arrayMap;
                    HashMap map5 = map4;
                    OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$6(this, specialEffectsController$Operation2, specialEffectsController$Operation, z2, arrayMap3));
                    Iterator<View> it = arrayMap2.values().iterator();
                    while (it.hasNext()) {
                        captureTransitioningViews(arrayList6, it.next());
                    }
                    if (!arrayList9.isEmpty()) {
                        View view10 = arrayMap2.get(arrayList9.get(0));
                        fragmentTransitionImpl.setEpicenter(objWrapTransitionInSet, view10);
                        view3 = view10;
                    }
                    Iterator<View> it2 = arrayMap3.values().iterator();
                    while (it2.hasNext()) {
                        captureTransitioningViews(arrayList7, it2.next());
                    }
                    if (!sharedElementTargetNames2.isEmpty() && (view5 = arrayMap3.get(sharedElementTargetNames2.get(0))) != null) {
                        OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$7(this, fragmentTransitionImpl, view5, rect4));
                        z3 = true;
                    }
                    fragmentTransitionImpl.setSharedElementTargets(objWrapTransitionInSet, view6, arrayList6);
                    arrayMap = arrayMap4;
                    arrayList7 = arrayList7;
                    arrayList6 = arrayList6;
                    View view11 = view6;
                    fragmentTransitionImpl = fragmentTransitionImpl;
                    fragmentTransitionImpl.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList7);
                    Boolean bool = Boolean.TRUE;
                    map3 = map5;
                    map3.put(specialEffectsController$Operation, bool);
                    map3.put(specialEffectsController$Operation2, bool);
                    rect3 = rect4;
                    obj3 = objWrapTransitionInSet;
                    specialEffectsController$Operation4 = specialEffectsController$Operation2;
                    view4 = view11;
                    specialEffectsController$Operation5 = specialEffectsController$Operation;
                }
                arrayMap = arrayMap;
                arrayList7 = arrayList7;
                arrayList6 = arrayList6;
                rect4 = rect3;
                view7 = view3;
                view6 = view4;
                map4 = map3;
                fragmentTransitionImpl = fragmentTransitionImpl;
            }
            map3 = map4;
            view4 = view6;
            rect3 = rect4;
            arrayMap = arrayMap;
            arrayList7 = arrayList7;
            arrayList6 = arrayList6;
            rect4 = rect3;
            view7 = view3;
            view6 = view4;
            map4 = map3;
            fragmentTransitionImpl = fragmentTransitionImpl;
        }
        View view12 = view7;
        ArrayMap arrayMap5 = arrayMap;
        ArrayList<View> arrayList10 = arrayList7;
        ArrayList<View> arrayList11 = arrayList6;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        HashMap map6 = map4;
        View view13 = view6;
        Rect rect5 = rect4;
        ArrayList arrayList12 = new ArrayList();
        Object objMergeTransitionsTogether2 = null;
        Object obj4 = null;
        for (DefaultSpecialEffectsController$TransitionInfo defaultSpecialEffectsController$TransitionInfo4 : list) {
            if (defaultSpecialEffectsController$TransitionInfo4.isVisibilityUnchanged()) {
                map6.put(defaultSpecialEffectsController$TransitionInfo4.getOperation(), Boolean.FALSE);
                defaultSpecialEffectsController$TransitionInfo4.completeSpecialEffect();
            } else {
                Object objCloneTransition = fragmentTransitionImpl2.cloneTransition(defaultSpecialEffectsController$TransitionInfo4.getTransition());
                SpecialEffectsController$Operation operation = defaultSpecialEffectsController$TransitionInfo4.getOperation();
                boolean z4 = obj3 != null && (operation == specialEffectsController$Operation5 || operation == specialEffectsController$Operation4);
                if (objCloneTransition == null) {
                    if (!z4) {
                        map6.put(operation, Boolean.FALSE);
                        defaultSpecialEffectsController$TransitionInfo4.completeSpecialEffect();
                    }
                    rect2 = rect5;
                    map2 = map6;
                    arrayList3 = arrayList12;
                    objMergeTransitionsTogether = obj4;
                    view2 = view12;
                } else {
                    HashMap map7 = map6;
                    ArrayList<View> arrayList13 = new ArrayList<>();
                    Object obj5 = obj4;
                    captureTransitioningViews(arrayList13, operation.getFragment().mView);
                    if (z4) {
                        if (operation == specialEffectsController$Operation5) {
                            arrayList13.removeAll(arrayList11);
                        } else {
                            arrayList13.removeAll(arrayList10);
                        }
                    }
                    if (arrayList13.isEmpty()) {
                        fragmentTransitionImpl2.addTarget(objCloneTransition, view13);
                        obj = obj5;
                        specialEffectsController$Operation3 = operation;
                        obj2 = objMergeTransitionsTogether2;
                        arrayList = arrayList12;
                        rect = rect5;
                        arrayList2 = arrayList13;
                        view = view12;
                        map = map7;
                    } else {
                        fragmentTransitionImpl2.addTargets(objCloneTransition, arrayList13);
                        specialEffectsController$Operation3 = operation;
                        obj = obj5;
                        view = view12;
                        obj2 = objMergeTransitionsTogether2;
                        arrayList = arrayList12;
                        rect = rect5;
                        map = map7;
                        fragmentTransitionImpl2.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList13, null, null, null, null);
                        if (specialEffectsController$Operation3.getFinalState() == SpecialEffectsController$Operation$State.GONE) {
                            objCloneTransition = objCloneTransition;
                            arrayList2 = arrayList13;
                            fragmentTransitionImpl2.scheduleHideFragmentView(objCloneTransition, specialEffectsController$Operation3.getFragment().mView, arrayList2);
                            OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$8(this, arrayList2));
                        } else {
                            objCloneTransition = objCloneTransition;
                            arrayList2 = arrayList13;
                        }
                    }
                    if (specialEffectsController$Operation3.getFinalState() == SpecialEffectsController$Operation$State.VISIBLE) {
                        arrayList3 = arrayList;
                        arrayList3.addAll(arrayList2);
                        rect2 = rect;
                        if (z3) {
                            fragmentTransitionImpl2.setEpicenter(objCloneTransition, rect2);
                        }
                        view2 = view;
                    } else {
                        view2 = view;
                        arrayList3 = arrayList;
                        rect2 = rect;
                        fragmentTransitionImpl2.setEpicenter(objCloneTransition, view2);
                    }
                    map2 = map;
                    map2.put(specialEffectsController$Operation3, Boolean.TRUE);
                    if (defaultSpecialEffectsController$TransitionInfo4.isOverlapAllowed()) {
                        objMergeTransitionsTogether = fragmentTransitionImpl2.mergeTransitionsTogether(obj, objCloneTransition, null);
                        objMergeTransitionsTogether2 = obj2;
                    } else {
                        objMergeTransitionsTogether = obj;
                        objMergeTransitionsTogether2 = fragmentTransitionImpl2.mergeTransitionsTogether(obj2, objCloneTransition, null);
                    }
                }
                view12 = view2;
                obj4 = objMergeTransitionsTogether;
                arrayList12 = arrayList3;
                view13 = view13;
                map6 = map2;
                rect5 = rect2;
            }
        }
        HashMap map8 = map6;
        ArrayList arrayList14 = arrayList12;
        Object objMergeTransitionsInSequence = fragmentTransitionImpl2.mergeTransitionsInSequence(obj4, objMergeTransitionsTogether2, obj3);
        for (DefaultSpecialEffectsController$TransitionInfo defaultSpecialEffectsController$TransitionInfo5 : list) {
            if (!defaultSpecialEffectsController$TransitionInfo5.isVisibilityUnchanged()) {
                Object transition = defaultSpecialEffectsController$TransitionInfo5.getTransition();
                SpecialEffectsController$Operation operation2 = defaultSpecialEffectsController$TransitionInfo5.getOperation();
                boolean z5 = obj3 != null && (operation2 == specialEffectsController$Operation5 || operation2 == specialEffectsController$Operation4);
                if (transition != null || z5) {
                    fragmentTransitionImpl2.setListenerForTransitionEnd(defaultSpecialEffectsController$TransitionInfo5.getOperation().getFragment(), objMergeTransitionsInSequence, defaultSpecialEffectsController$TransitionInfo5.getSignal(), new DefaultSpecialEffectsController$9(this, defaultSpecialEffectsController$TransitionInfo5));
                }
            }
        }
        FragmentTransition.setViewVisibility(arrayList14, 4);
        ArrayList<String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl2.prepareSetNameOverridesReordered(arrayList10);
        fragmentTransitionImpl2.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
        fragmentTransitionImpl2.setNameOverridesReordered(getContainer(), arrayList11, arrayList10, arrayListPrepareSetNameOverridesReordered, arrayMap5);
        FragmentTransition.setViewVisibility(arrayList14, 0);
        fragmentTransitionImpl2.swapSharedElementTargets(obj3, arrayList11, arrayList10);
        return map8;
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController$Operation specialEffectsController$Operation) {
        specialEffectsController$Operation.getFinalState().applyState(specialEffectsController$Operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController$Operation> list, boolean z2) {
        SpecialEffectsController$Operation specialEffectsController$Operation = null;
        SpecialEffectsController$Operation specialEffectsController$Operation2 = null;
        for (SpecialEffectsController$Operation specialEffectsController$Operation3 : list) {
            SpecialEffectsController$Operation$State specialEffectsController$Operation$StateFrom = SpecialEffectsController$Operation$State.from(specialEffectsController$Operation3.getFragment().mView);
            int iOrdinal = specialEffectsController$Operation3.getFinalState().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (specialEffectsController$Operation$StateFrom != SpecialEffectsController$Operation$State.VISIBLE) {
                    specialEffectsController$Operation2 = specialEffectsController$Operation3;
                }
            }
            if (specialEffectsController$Operation$StateFrom == SpecialEffectsController$Operation$State.VISIBLE && specialEffectsController$Operation == null) {
                specialEffectsController$Operation = specialEffectsController$Operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (SpecialEffectsController$Operation specialEffectsController$Operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            specialEffectsController$Operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new DefaultSpecialEffectsController$AnimationInfo(specialEffectsController$Operation4, cancellationSignal));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            specialEffectsController$Operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z3 = false;
            if (z2) {
                if (specialEffectsController$Operation4 == specialEffectsController$Operation) {
                    z3 = true;
                }
            } else if (specialEffectsController$Operation4 == specialEffectsController$Operation2) {
                z3 = true;
            }
            arrayList2.add(new DefaultSpecialEffectsController$TransitionInfo(specialEffectsController$Operation4, cancellationSignal2, z2, z3));
            specialEffectsController$Operation4.addCompletionListener(new DefaultSpecialEffectsController$1(this, arrayList3, specialEffectsController$Operation4));
        }
        Map<SpecialEffectsController$Operation, Boolean> mapStartTransitions = startTransitions(arrayList2, z2, specialEffectsController$Operation, specialEffectsController$Operation2);
        startAnimations(arrayList, arrayList3, mapStartTransitions.containsValue(Boolean.TRUE), mapStartTransitions);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges((SpecialEffectsController$Operation) it.next());
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map$Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
