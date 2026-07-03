package com.discord.widgets.notice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p483p.p484a.C5279i;
import p007b.p483p.p484a.RunnableC5277g;
import p007b.p483p.p484a.ViewOnClickListenerC5272b;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup {
    private static final int DEFAULT_AUTO_DISMISS_PERIOD_SECONDS = 5;
    public static final NoticePopup INSTANCE = new NoticePopup();

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$1 */
    /* JADX INFO: compiled from: NoticePopup.kt */
    public static final class C90901 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C90901 INSTANCE = new C90901();

        public C90901() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
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
        ViewOnClickListenerC5272b viewOnClickListenerC5272b;
        WeakReference<ViewGroup> weakReference = C5279i.f14367a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            C12238m.checkNotNullExpressionValue(viewGroup, "it");
            int childCount = viewGroup.getChildCount();
            if (childCount >= 0) {
                int i = 0;
                while (true) {
                    if (viewGroup.getChildAt(i) instanceof ViewOnClickListenerC5272b) {
                        View childAt = viewGroup.getChildAt(i);
                        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                        viewOnClickListenerC5272b = (ViewOnClickListenerC5272b) childAt;
                    } else {
                        viewOnClickListenerC5272b = null;
                    }
                    if (viewOnClickListenerC5272b != null && viewOnClickListenerC5272b.getWindowToken() != null) {
                        ViewCompat.animate(viewOnClickListenerC5272b).alpha(0.0f).withEndAction(new RunnableC5277g(viewOnClickListenerC5272b));
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
        C12238m.checkNotNullExpressionValue(valueAnimatorOfInt, "animator");
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setDuration(((long) autoDismissPeriodSecs.intValue()) * 1000);
        valueAnimatorOfInt.addListener(animatorListener);
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public final void enqueue(String noticeName, CharSequence noticeTitle, CharSequence noticeSubtitle, CharSequence noticeBody, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, List<Sticker> noticeStickers, String noticeIconUrl, Integer noticeIconResId, Drawable noticeIconTopRight, Integer noticeAutoDismissPeriodSecs, List<? extends InterfaceC11230c<? extends AppComponent>> validScreens, Function1<? super View, Unit> onClickTopRightIcon, Function1<? super View, Unit> onClick) {
        C12238m.checkNotNullParameter(noticeName, "noticeName");
        C12238m.checkNotNullParameter(validScreens, "validScreens");
        C12238m.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
        C12238m.checkNotNullParameter(onClick, "onClick");
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 1, false, validScreens, 1000L, false, 0L, new NoticePopup$enqueue$notice$1(onClick, noticeName, noticeAutoDismissPeriodSecs, noticeIconUrl, noticeIconResId, noticeBodyImageUrl, noticeBodyImageDrawable, noticeBodyBackgroundDrawable, noticeTitle, noticeSubtitle, noticeBody, noticeIconTopRight, noticeStickers, onClickTopRightIcon), 150, null));
    }
}
