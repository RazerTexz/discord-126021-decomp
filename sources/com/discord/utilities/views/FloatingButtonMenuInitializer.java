package com.discord.utilities.views;

import android.R$integer;
import android.R$interpolator;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TableRow;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer {
    private final FloatingButtonMenuInitializer$AnimatorFactory<View> animatorFactoryFadeIn;
    private final FloatingButtonMenuInitializer$AnimatorFactory<View> animatorFactorySlideUp;
    private final Context context;
    private final Map<Integer, View$OnClickListener> onClickListenerMap;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingButtonMenuInitializer(Context context, Map<Integer, ? extends View$OnClickListener> map) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(map, "onClickListenerMap");
        this.context = context;
        this.onClickListenerMap = map;
        this.animatorFactoryFadeIn = new FloatingButtonMenuInitializer$animatorFactoryFadeIn$1(this);
        this.animatorFactorySlideUp = new FloatingButtonMenuInitializer$animatorFactorySlideUp$1();
    }

    public static final /* synthetic */ Animator access$configureEntranceAnimator(FloatingButtonMenuInitializer floatingButtonMenuInitializer, Animator[] animatorArr) {
        return floatingButtonMenuInitializer.configureEntranceAnimator(animatorArr);
    }

    public static final /* synthetic */ Context access$getContext$p(FloatingButtonMenuInitializer floatingButtonMenuInitializer) {
        return floatingButtonMenuInitializer.context;
    }

    public static final /* synthetic */ Animator[] access$getMenuAnimators(FloatingButtonMenuInitializer floatingButtonMenuInitializer, ViewGroup viewGroup, View view) {
        return floatingButtonMenuInitializer.getMenuAnimators(viewGroup, view);
    }

    private final Animator configureEntranceAnimator(Animator[] menuRowAnimators) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Animator[]) Arrays.copyOf(menuRowAnimators, menuRowAnimators.length));
        animatorSet.setInterpolator(AnimationUtils.loadInterpolator(this.context, R$interpolator.accelerate_decelerate));
        AnimatorSet duration = animatorSet.setDuration(this.context.getResources().getInteger(R$integer.config_shortAnimTime));
        m.checkNotNullExpressionValue(duration, "animatorEntrance.setDura…n(totalDuration.toLong())");
        return duration;
    }

    private final Animator createDefaultMenuRowAnimation(ViewGroup row, View mainFab) {
        return row.getId() == 2131363376 ? this.animatorFactoryFadeIn.createAnimator(row) : createMenuRowAnimation(row, this.animatorFactoryFadeIn, getAnimatorFactoryScaleUp(mainFab), this.animatorFactorySlideUp);
    }

    private final Animator createMenuRowAnimation(ViewGroup row, FloatingButtonMenuInitializer$AnimatorFactory<? super ViewGroup>... factories) {
        ArrayList arrayList = new ArrayList(factories.length);
        for (FloatingButtonMenuInitializer$AnimatorFactory<? super ViewGroup> floatingButtonMenuInitializer$AnimatorFactory : factories) {
            Animator animatorCreateAnimator = floatingButtonMenuInitializer$AnimatorFactory.createAnimator(row);
            if (animatorCreateAnimator != null) {
                arrayList.add(animatorCreateAnimator);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    private final FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1 getAnimatorFactoryScaleUp(View mainFab) {
        return new FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1(mainFab);
    }

    private final Animator[] getMenuAnimators(ViewGroup menuContainer, View mainFab) {
        int childCount = menuContainer.getChildCount();
        Animator[] animatorArr = new Animator[childCount];
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) childAt;
            viewGroup.setVisibility(4);
            Animator animatorCreateDefaultMenuRowAnimation = createDefaultMenuRowAnimation(viewGroup, mainFab);
            if (animatorCreateDefaultMenuRowAnimation != null) {
                animatorCreateDefaultMenuRowAnimation.addListener(new FloatingButtonMenuInitializer$getMenuAnimators$1(viewGroup));
            }
            animatorArr[(childCount - 1) - i] = animatorCreateDefaultMenuRowAnimation;
        }
        return animatorArr;
    }

    private final void setFabMenuOnClickListener(TableRow row, View$OnClickListener listener) {
        int childCount = row.getChildCount();
        for (int i = 0; i < childCount; i++) {
            row.getChildAt(i).setOnClickListener(listener);
        }
    }

    public final FloatingButtonMenuInitializer initialize(ViewGroup menuContainer, View mainFab, View$OnClickListener defaultRowOnClickListener) {
        m.checkNotNullParameter(menuContainer, "menuContainer");
        m.checkNotNullParameter(mainFab, "mainFab");
        m.checkNotNullParameter(defaultRowOnClickListener, "defaultRowOnClickListener");
        int childCount = menuContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TableRow");
            TableRow tableRow = (TableRow) childAt;
            tableRow.setOnClickListener(defaultRowOnClickListener);
            setFabMenuOnClickListener(tableRow, this.onClickListenerMap.get(Integer.valueOf(tableRow.getId())));
        }
        menuContainer.getViewTreeObserver().addOnGlobalLayoutListener(new FloatingButtonMenuInitializer$initialize$1(this, menuContainer, mainFab));
        return this;
    }
}
