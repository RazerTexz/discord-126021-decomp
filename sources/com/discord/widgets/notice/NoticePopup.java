package com.discord.widgets.notice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import b.p.a.Alert2;
import b.p.a.Alerter;
import b.p.a.Alerter3;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import d0.e0.KClass;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup {
    private static final int DEFAULT_AUTO_DISMISS_PERIOD_SECONDS = 5;
    public static final NoticePopup INSTANCE = new NoticePopup();

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoticePopup.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
        }
    }

    private NoticePopup() {
    }

    private final void cancelCountdown(ValueAnimator autoDismissAnimator) {
        if (autoDismissAnimator != null) {
            autoDismissAnimator.cancel();
        }
        if (autoDismissAnimator != null) {
            autoDismissAnimator.end();
        }
    }

    private final void dismiss(String name) {
        ViewGroup viewGroup;
        Alert2 alert2;
        WeakReference<ViewGroup> weakReference = Alerter3.a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            Intrinsics3.checkNotNullExpressionValue(viewGroup, "it");
            int childCount = viewGroup.getChildCount();
            if (childCount >= 0) {
                int i = 0;
                while (true) {
                    if (viewGroup.getChildAt(i) instanceof Alert2) {
                        View childAt = viewGroup.getChildAt(i);
                        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                        alert2 = (Alert2) childAt;
                    } else {
                        alert2 = null;
                    }
                    if (alert2 != null && alert2.getWindowToken() != null) {
                        ViewCompat.animate(alert2).alpha(0.0f).withEndAction(new Alerter(alert2));
                    }
                    if (i == childCount) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), name, 0L, 2, null);
    }

    private final ValueAnimator getAutoDismissAnimator(Integer autoDismissPeriodSecs, final Function0<Unit> onEnd) {
        if (autoDismissPeriodSecs == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ObjectAnimator.ofInt(0, 1);
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: com.discord.widgets.notice.NoticePopup$getAutoDismissAnimator$animatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (animation != null) {
                    animation.removeListener(this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                onEnd.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }
        };
        Intrinsics3.checkNotNullExpressionValue(valueAnimatorOfInt, "animator");
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setDuration(((long) autoDismissPeriodSecs.intValue()) * 1000);
        valueAnimatorOfInt.addListener(animatorListener);
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public final void enqueue(String noticeName, CharSequence noticeTitle, CharSequence noticeSubtitle, CharSequence noticeBody, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, List<Sticker> noticeStickers, String noticeIconUrl, Integer noticeIconResId, Drawable noticeIconTopRight, Integer noticeAutoDismissPeriodSecs, List<? extends KClass<? extends AppComponent>> validScreens, Function1<? super View, Unit> onClickTopRightIcon, Function1<? super View, Unit> onClick) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        Intrinsics3.checkNotNullParameter(validScreens, "validScreens");
        Intrinsics3.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
        Intrinsics3.checkNotNullParameter(onClick, "onClick");
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 1, false, validScreens, 1000L, false, 0L, new NoticePopup2(onClick, noticeName, noticeAutoDismissPeriodSecs, noticeIconUrl, noticeIconResId, noticeBodyImageUrl, noticeBodyImageDrawable, noticeBodyBackgroundDrawable, noticeTitle, noticeSubtitle, noticeBody, noticeIconTopRight, noticeStickers, onClickTopRightIcon), 150, null));
    }
}
