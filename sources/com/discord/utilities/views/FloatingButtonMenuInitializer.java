package com.discord.utilities.views;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.TableRow;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer {
    private final AnimatorFactory<View> animatorFactoryFadeIn;
    private final AnimatorFactory<View> animatorFactorySlideUp;
    private final Context context;
    private final Map<Integer, View.OnClickListener> onClickListenerMap;

    /* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
    public interface AnimatorFactory<T extends View> {
        Animator createAnimator(T view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingButtonMenuInitializer(Context context, Map<Integer, ? extends View.OnClickListener> map) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(map, "onClickListenerMap");
        this.context = context;
        this.onClickListenerMap = map;
        this.animatorFactoryFadeIn = new AnimatorFactory<View>() { // from class: com.discord.utilities.views.FloatingButtonMenuInitializer$animatorFactoryFadeIn$1
            @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
            public Animator createAnimator(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.this$0.context, R.animator.fade_in);
                animatorLoadAnimator.setTarget(view);
                return animatorLoadAnimator;
            }
        };
        this.animatorFactorySlideUp = new AnimatorFactory<View>() { // from class: com.discord.utilities.views.FloatingButtonMenuInitializer$animatorFactorySlideUp$1
            @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
            public Animator createAnimator(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                return ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getHeight() * 1.0f, 0.0f);
            }
        };
    }

    private final Animator configureEntranceAnimator(Animator[] menuRowAnimators) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Animator[]) Arrays.copyOf(menuRowAnimators, menuRowAnimators.length));
        animatorSet.setInterpolator(AnimationUtils.loadInterpolator(this.context, R.interpolator.accelerate_decelerate));
        AnimatorSet duration = animatorSet.setDuration(this.context.getResources().getInteger(R.integer.config_shortAnimTime));
        Intrinsics3.checkNotNullExpressionValue(duration, "animatorEntrance.setDura…n(totalDuration.toLong())");
        return duration;
    }

    private final Animator createDefaultMenuRowAnimation(ViewGroup row, View mainFab) {
        return row.getId() == com.discord.R.id.fab_menu_main ? this.animatorFactoryFadeIn.createAnimator(row) : createMenuRowAnimation(row, this.animatorFactoryFadeIn, getAnimatorFactoryScaleUp(mainFab), this.animatorFactorySlideUp);
    }

    private final Animator createMenuRowAnimation(ViewGroup row, AnimatorFactory<? super ViewGroup>... factories) {
        ArrayList arrayList = new ArrayList(factories.length);
        for (AnimatorFactory<? super ViewGroup> animatorFactory : factories) {
            Animator animatorCreateAnimator = animatorFactory.createAnimator(row);
            if (animatorCreateAnimator != null) {
                arrayList.add(animatorCreateAnimator);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.discord.utilities.views.FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1] */
    private final AnonymousClass1 getAnimatorFactoryScaleUp(final View mainFab) {
        return new AnimatorFactory<ViewGroup>() { // from class: com.discord.utilities.views.FloatingButtonMenuInitializer.getAnimatorFactoryScaleUp.1
            @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
            public Animator createAnimator(ViewGroup view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(mainFab, (Property<View, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(mainFab, (Property<View, Float>) View.SCALE_Y, 0.0f, 1.0f));
                return animatorSet;
            }
        };
    }

    private final Animator[] getMenuAnimators(ViewGroup menuContainer, View mainFab) {
        int childCount = menuContainer.getChildCount();
        Animator[] animatorArr = new Animator[childCount];
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            final ViewGroup viewGroup = (ViewGroup) childAt;
            viewGroup.setVisibility(4);
            Animator animatorCreateDefaultMenuRowAnimation = createDefaultMenuRowAnimation(viewGroup, mainFab);
            if (animatorCreateDefaultMenuRowAnimation != null) {
                animatorCreateDefaultMenuRowAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.discord.utilities.views.FloatingButtonMenuInitializer.getMenuAnimators.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics3.checkNotNullParameter(animation, "animation");
                        viewGroup.setVisibility(0);
                    }
                });
            }
            animatorArr[(childCount - 1) - i] = animatorCreateDefaultMenuRowAnimation;
        }
        return animatorArr;
    }

    private final void setFabMenuOnClickListener(TableRow row, View.OnClickListener listener) {
        int childCount = row.getChildCount();
        for (int i = 0; i < childCount; i++) {
            row.getChildAt(i).setOnClickListener(listener);
        }
    }

    public final FloatingButtonMenuInitializer initialize(final ViewGroup menuContainer, final View mainFab, View.OnClickListener defaultRowOnClickListener) {
        Intrinsics3.checkNotNullParameter(menuContainer, "menuContainer");
        Intrinsics3.checkNotNullParameter(mainFab, "mainFab");
        Intrinsics3.checkNotNullParameter(defaultRowOnClickListener, "defaultRowOnClickListener");
        int childCount = menuContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TableRow");
            TableRow tableRow = (TableRow) childAt;
            tableRow.setOnClickListener(defaultRowOnClickListener);
            setFabMenuOnClickListener(tableRow, this.onClickListenerMap.get(Integer.valueOf(tableRow.getId())));
        }
        menuContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.discord.utilities.views.FloatingButtonMenuInitializer.initialize.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FloatingButtonMenuInitializer floatingButtonMenuInitializer = FloatingButtonMenuInitializer.this;
                floatingButtonMenuInitializer.configureEntranceAnimator(floatingButtonMenuInitializer.getMenuAnimators(menuContainer, mainFab)).start();
                menuContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        return this;
    }
}
